package persistence.website.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.siteweb.RichiestaAssunzione;
import persistence.configuration.PostgresDAOFactory;
import persistence.website.abstraction.RichiestaAssunzioneDAO;

public class RichiestaAssunzioneDAOImplementation implements RichiestaAssunzioneDAO{
	
	private Connection con;
	
	public RichiestaAssunzioneDAOImplementation() {
		con = PostgresDAOFactory.getConnection();
	}
	
	@Override
	public void createTable() {
        try {
            String query = "create table if not exists requesttable(cf varchar(50),name varchar(55),surname varchar(55),email varchar(255),"
                    + "role varchar(17),primary key(cf) )";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
	public ArrayList<RichiestaAssunzione> selectAll() {
		ArrayList<RichiestaAssunzione> daRitornare = new ArrayList<>();
		try {
			String query = "select * from requesttable";
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()){
				daRitornare.add(new RichiestaAssunzione(rs.getString("cf"),rs.getString("name"),rs.getString("surname"),rs.getString("email"),rs.getString("role")));
				
			}
			return daRitornare;
		} catch (Exception e) {
			System.out.println("ERRORE: Si è verificato un errore in selectAllRichiesteAssunzione");
		}
		return null;
	}

	@Override
	public RichiestaAssunzione selectRichiestaAssunzioneByCF(String cf) {
		try {
			String query = "select * from requesttable where cf=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, cf);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				return new RichiestaAssunzione(rs.getString("cf"),rs.getString("name"),rs.getString("surname"),rs.getString("email"),rs.getString("role"));
			}
		} catch (Exception e) {
			System.out.println("ERRORE: Si è verificato un errore in selectRichiestaAssunzioneByCF");
		}
		return null;
	}

	@Override
	public void deleteRichiestaAssunzione(String cf) {
		try {
			String query = "DELETE FROM requesttable WHERE cf = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, cf);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertRichiestaAssunzione(RichiestaAssunzione e) {
		try {
			String query = "INSERT INTO public.requesttable(\r\n" + 
					"	cf, name, surname, email, role)\r\n" + 
					"	VALUES (?, ?, ?, ?, ?);";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, e.getCf().getValue());
			pstmt.setString(2, e.getName().getValue());
			pstmt.setString(3, e.getSurname().getValue());
			pstmt.setString(4, e.getEmail().getValue());
			pstmt.setString(5, e.getRole().getValue());
			pstmt.executeUpdate();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		
	}

	@Override
	public ArrayList<RichiestaAssunzione> selectAllByRole(String role) {
		ArrayList<RichiestaAssunzione> daRitornare = new ArrayList<>();
		try {
			String query = "select * from requesttable where role=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, role);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				daRitornare.add(new RichiestaAssunzione(rs.getString("cf"),rs.getString("name"),rs.getString("surname"),rs.getString("email"),rs.getString("role")));
			}
			return daRitornare;
		} catch (Exception e) {
			System.out.println("ERRORE: Si è verificato un problema in selectAllByRole : RichiestaAssunzioneDAO");
		}
		return null;
	}

	

}
