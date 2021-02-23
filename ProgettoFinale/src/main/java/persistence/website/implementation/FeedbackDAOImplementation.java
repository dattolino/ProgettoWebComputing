package persistence.website.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.siteweb.Feedback;
import persistence.configuration.PostgresDAOFactory;
import persistence.website.abstraction.FeedbackDAO;

public class FeedbackDAOImplementation implements FeedbackDAO {
	
	private Connection con;
	
	public FeedbackDAOImplementation() {
		con = PostgresDAOFactory.getConnection();
	}

	@Override
	public void createTable() {
		try {
			String query = "create table if not exists feedback(riferimento varchar(255), motivazione varchar(255),date varchar(255))"; 
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertFeedback(Feedback u) {
		try {
			String query = "INSERT INTO feedback(riferimento,motivazione,date) VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1,u.getRiferimento().getValue());
			pstmt.setString(2, u.getMotivazione().getValue());
			pstmt.setString(3,u.getData().getValue());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Feedback> selectFeedbackByCF(String cf) {
			ArrayList<Feedback> daRitornare = new ArrayList<Feedback>();
		
		try {
			String query = "select * from feedback where riferimento=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, cf);
			ResultSet st = pstmt.executeQuery();
			
			while(st.next()) {
				daRitornare.add(new Feedback(st.getString("riferimento"),st.getString("motivazione")));
			}
			
			return daRitornare;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	}

}


