package persistence.website.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.siteweb.Partenza;
import persistence.configuration.PostgresDAOFactory;
import persistence.website.abstraction.PartenzaDAO;

public class PartenzeDAOImplementation implements PartenzaDAO{
	
	private static Connection con = null;
	
	public PartenzeDAOImplementation() {
		con = PostgresDAOFactory.getConnection();
	}

	@Override
	public void createTable() {
		try {
			String query = "create table if not exists partenze(partenza varchar(55),arrivo varchar(255),prezzo int,durata int,modalita varchar(255))";
			
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertPartenza(Partenza daAggiungere) {
		try {
			String query = "INSERT INTO partenze(partenza, arrivo, prezzo, durata, modalita) VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, daAggiungere.getPartenza().getValue());
			pstmt.setString(2, daAggiungere.getDestinazione().getValue());
			int prezzo = Integer.parseInt(daAggiungere.getPrezzo().getValue());
			int durata = Integer.parseInt(daAggiungere.getDurata().getValue());
			pstmt.setInt(3, prezzo);
			pstmt.setInt(4, durata);
			pstmt.setString(5, daAggiungere.getModalita().getValue());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	

	@Override
	public int getGuadagno(String destinazione, String modalita) {
		try {
			String query = "select * from partenze where arrivo=? and modalita=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,destinazione);
			pstmt.setString(2, modalita);
			ResultSet st = pstmt.executeQuery();
			while(st.next()) {
				return st.getInt("prezzo");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}

	@Override
	public int getDurata(String destinazione, String modalita) {
		try {
			String query = "select * from partenze where arrivo=? and modalita=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,destinazione);
			pstmt.setString(2, modalita);
			ResultSet st = pstmt.executeQuery();
			while(st.next()) {
				return st.getInt("durata");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}

	@Override
	public ArrayList<String> tutteLeDestinazioni() {
		ArrayList<String> daRitornare = new ArrayList<>();
		try {
			String query = "select * from partenze"; //partenza, arrivo, prezzo, durata, modalita
			Statement stmt = con.createStatement();
			ResultSet st = stmt.executeQuery(query);
			while(st.next()) {
				daRitornare.add(st.getString("arrivo"));
			}
			return daRitornare;
		} catch (Exception e) {
			System.out.println("errore");
		}
		return null;
	}
	
	@Override
	public Partenza getTappa(String destinazione) {
		try {
			String query = "select * from partenze where arrivo=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, destinazione);
			ResultSet st = pstmt.executeQuery();
			while(st.next()) {
				return new Partenza(st.getString("partenza"),st.getString("arrivo"),st.getString("prezzo"),st.getString("durata"),st.getString("modalita"));
			}
		} catch (Exception e) {
			System.out.println("errore");
		}
		return null;
	}

}
