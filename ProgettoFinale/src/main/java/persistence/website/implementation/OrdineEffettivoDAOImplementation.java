package persistence.website.implementation;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import model.siteweb.OrdineEffettivo;
import persistence.configuration.PostgresDAOFactory;
import persistence.website.abstraction.OrdineEffettivoDAO;

public class OrdineEffettivoDAOImplementation implements OrdineEffettivoDAO{

	private Connection con;
	
	
	public OrdineEffettivoDAOImplementation() {
		con = PostgresDAOFactory.getConnection();
	}
	@Override
	public void createTable() {
		try {
			String query = "create table if not exists ordinieffettivi (name varchar(55),email varchar(255),da varchar(55),a varchar(55),via varchar(100), modalita varchar(20),richiesta varchar(255),riferimento varchar(255),guadagno varchar(255), tempodiconsegna varchar(255),stato varchar(55), orario int)";
			
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void aggiungiOrdineEffettivo(OrdineEffettivo e) {
		try {
			String query1 = "INSERT INTO ordinieffettivi(name, email, da, a, via, modalita, richiesta,riferimento,guadagno,tempodiconsegna,stato,orario)\r\n" + 
					"	VALUES (?, ?,?, ?, ?, ?,?,?,?,?,'in attesa',0);";
			
			PreparedStatement pstmt1 = con.prepareStatement(query1);
			pstmt1.setString(1, e.getName().getValue());
			pstmt1.setString(2, e.getEmail().getValue());
			pstmt1.setString(3, e.getDa().getValue());
			pstmt1.setString(4, e.getA().getValue());
			pstmt1.setString(5, e.getVia().getValue());
			pstmt1.setString(6, e.getModalita().getValue());
			pstmt1.setString(7, e.getRichiesta().getValue());
			pstmt1.setString(8, e.getRiferimento().getValue());
			pstmt1.setString(9, e.getPrezzo().getValue());
			pstmt1.setString(10, e.getDurata().getValue());
			
			pstmt1.executeUpdate();
			
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<OrdineEffettivo> selectAllByRiferimento(String Riferimento, String stato) {
		
		ArrayList<OrdineEffettivo> lista = new ArrayList<OrdineEffettivo>();
		try {
			String query = "select * from ordinieffettivi where riferimento=? and stato=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, Riferimento);
			stmt.setString(2, stato);
			ResultSet s = stmt.executeQuery();
			while(s.next()) {
				OrdineEffettivo Temp= new OrdineEffettivo(s.getString("name"),s.getString("email"),
						s.getString("da"),s.getString("a"),s.getString("via"),s.getString("modalita"),
						s.getString("richiesta"),s.getString("riferimento"),s.getString("stato"),s.getInt("orario"));
				lista.add(Temp);
			}
			return lista;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}

	@Override
	public void cambiaStato(String stato, OrdineEffettivo oe) {
		try {
			String query = "update ordinieffettivi set stato=? where richiesta=? and email=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1,stato);
			stmt.setString(2, oe.getRichiesta().getValue());
			stmt.setString(3, oe.getEmail().getValue());
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void cancellaOrdine(OrdineEffettivo oe) {
		try {
			String query = "DELETE FROM ordinieffettivi WHERE richiesta=? and email=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, oe.getRichiesta().getValue());
			pstmt.setString(2, oe.getEmail().getValue());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int getOrarioFromDB(OrdineEffettivo o) {
		try {
			String query = "select * from ordinieffettivi where richiesta=? and email=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, o.getRichiesta().getValue());
			pstmt.setString(2, o.getEmail().getValue());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				return rs.getInt("orario");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}

	@Override
	public void updateOrario(OrdineEffettivo o, int orario) {
		String query = "update ordinieffettivi set orario=? where richiesta=? and email=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orario);
			pstmt.setString(2, o.getRichiesta().getValue());
			pstmt.setString(3, o.getEmail().getValue());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int getOrarioInTransito(OrdineEffettivo oe) {
		try {
			String query = "select * from ordinieffettivi where stato='in transito' and richiesta = ? and email=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, oe.getRichiesta().getValue());
			pstmt.setString(2, oe.getEmail().getValue());
			ResultSet st = pstmt.executeQuery();
			while(st.next()) {
				return st.getInt("orario");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}

}
