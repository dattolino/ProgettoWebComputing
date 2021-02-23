package persistence.website.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.siteweb.RichiestaOrdine;
import persistence.configuration.PostgresDAOFactory;
import persistence.website.abstraction.RichiestaOrdineDAO;

public class RichiestaOrdineDAOImplementation implements RichiestaOrdineDAO {
	
	private Connection con;
	
	public RichiestaOrdineDAOImplementation() {
		con = PostgresDAOFactory.getConnection();
	}
	
	@Override
	public void createTable() {
	        try {
	            String query = "create table if not exists clientrequest (name varchar(55),email varchar(255),da varchar(55),a varchar(55),via varchar(100), modalita varchar(20),richiesta varchar(255))";
	            Statement stmt = con.createStatement();
	            stmt.executeUpdate(query);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		
	

	@Override
	public ArrayList<RichiestaOrdine> selectAll() {
		ArrayList<RichiestaOrdine> daRitornare = new ArrayList<>();
		try {
			String query = "select * from clientrequest";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				daRitornare.add(new RichiestaOrdine(rs.getString("name"),rs.getString("email"),rs.getString("da"),rs.getString("a"),rs.getString("via"),rs.getString("modalita"),rs.getString("richiesta")));
				
			}
			return daRitornare;
		} catch (Exception e) {
			System.out.println("ERRORE: Si è verificato un errore in selectAllRichiestaOrdine");
		}
		return null;
	}

	@Override
	public void insertRichiestaOrdine(RichiestaOrdine o) {
		try {
			String query = "INSERT INTO public.clientrequest(\r\n" + 
					"	name, email, da, a, via, modalita,richiesta)\r\n" + 
					"	VALUES (?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, o.getName().getValue());
			pstmt.setString(2, o.getEmail().getValue());
			pstmt.setString(3, o.getDa().getValue());
			pstmt.setString(4, o.getA().getValue());
			pstmt.setString(5, o.getVia().getValue());
			pstmt.setString(6, o.getModalita().getValue());
			pstmt.setString(7, o.getRichiesta().getValue());


			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteRichiestaOrdine(RichiestaOrdine o) {
		try {
			String query = "DELETE FROM clientrequest WHERE name = ? AND email = ? AND richiesta = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, o.getName().getValue());
			pstmt.setString(2, o.getEmail().getValue());
			pstmt.setString(3, o.getRichiesta().getValue());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<RichiestaOrdine> selectByType(String type) {
		ArrayList<RichiestaOrdine> daRitornare = new ArrayList<>();
		try {
			String query = "select * from clientrequest where modalita=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, type);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				daRitornare.add(new RichiestaOrdine(rs.getString("name"),rs.getString("email"),rs.getString("da"),rs.getString("a"),rs.getString("via"),rs.getString("modalita"),rs.getString("richiesta")));
				
			}
			return daRitornare;
		} catch (Exception e) {
			System.out.println("ERRORE : Si è verificato un errore in selectByType : RichiestaOrdineDAO");

		}
		return null;
	}

	

}
