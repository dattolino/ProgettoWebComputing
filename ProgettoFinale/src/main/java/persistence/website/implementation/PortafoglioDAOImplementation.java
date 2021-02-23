package persistence.website.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.abstraction.Persona;
import model.siteweb.Dipendente;
import model.siteweb.Portafoglio;
import persistence.configuration.PostgresDAOFactory;
import persistence.website.abstraction.PortafoglioDAO;

public class PortafoglioDAOImplementation implements PortafoglioDAO {
	
	private Connection con;
	
	public PortafoglioDAOImplementation() {
		con = PostgresDAOFactory.getConnection();
	}

	@Override
	public void createTable() {
		try {
			String query = "create table if not exists employeewallet(id SERIAL, cf varchar(55), ammonizioni int, bonus int, stipendio int, effettuati int, rifiutati int, primary key(id))";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("ERRORE: Si è verificato un errore in createTable : PortafoglioDAO");
		}
		
	}

	@Override
	public ArrayList<Portafoglio> selectAll() {
		ArrayList<Portafoglio> daRitornare = new ArrayList<>();
		try {
			String query = "select * from employeewallet";
			Statement stmt = con.createStatement();
			ResultSet st = stmt.executeQuery(query);
			
			while(st.next()){
				daRitornare.add(new Portafoglio(st.getString("cf"),st.getString("ammonizioni"),st.getString("bonus"),st.getString("stipendio"),st.getString("effettuati"),st.getString("rifiutati")));
				
			}
			return daRitornare;
		} catch (Exception e) {
			System.out.println("Errore: Si è verificato un errore in selectAll : PortafoglioDAO");
		}
		return null;
	}

	@Override
	public Portafoglio selectPortafoglioDipendente(Dipendente e) {
		try {
			String query = "select * from employeewallet where cf=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, e.getCf().getValue());
			
			ResultSet st = pstmt.executeQuery();
			while(st.next()){
				return new Portafoglio(st.getString("cf"),st.getString("ammonizioni"),st.getString("bonus"),st.getString("stipendio"),st.getString("effettuati"),st.getString("rifiutati"));
			}
		} catch (Exception e2) {
			System.out.println("ERRORE: Si e' verificato un errore in selectPortafoglioDipendente : PortafoglioDAO");
		}
		return null;
	}

	@Override //Dobbiamo scegliere i criteri con il quale implementarla
	public Portafoglio selectPortafoglioMigliore() {
		return null;
	}

	@Override
	public void insertPortafoglio(Persona e) {
		try {
			String query = "INSERT INTO public.employeewallet(cf, ammonizioni, bonus, stipendio, effettuati, rifiutati)\r\n" + 
					"	VALUES (?, 0, 0, 1300, 0, 0);";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,e.getCf().getValue());
			pstmt.executeUpdate();
		} catch (Exception e2) {
			System.out.println("Errore: Si è verificato un errore in insertPortafoglio : PortafoglioDAO");
		}
	
		
	}

	@Override
	public void deletePortafoglio(Dipendente e) {
		try {
			String query = "DELETE FROM employeewallet WHERE cf = ?"; 
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,e.getCf().getValue());
			pstmt.executeUpdate();
		} catch (Exception e2) {
			System.out.println("ERRORE: Si è verificato un errore in deletePortafoglio : PortafoglioDAO");
		}
		
	}
	

	@Override
	public void deletePortafoglioByCf(String cf) {
		try {
			String query = "DELETE FROM employeewallet WHERE cf = ?"; 
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,cf);
			pstmt.executeUpdate();
		} catch (Exception e2) {
			System.out.println("ERRORE: Si è verificato un errore in deletePortafoglio : PortafoglioDAO");
		}
		
	}

	@Override
	public void attribuisciBonus(Dipendente d) {
		try {
			String query = "update employeewallet set bonus=? where cf=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1,getNumeroBonusDipendente(d)+1);
			pstmt.setString(2,d.getCf().getValue());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private int getNumeroBonusDipendente(Persona p) {
		try {
			String query = "select * from employeewallet where cf=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, p.getCf().getValue());
			ResultSet st = pstmt.executeQuery();
			
			while(st.next()) {
				return st.getInt("bonus");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void attribuisciAmmonizione(Dipendente d) {
		try {
			String query = "update employeewallet set ammonizioni=? where cf=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1,getNumeroAmmonizioniDipendente(d)+1);
			pstmt.setString(2,d.getCf().getValue());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private int getNumeroAmmonizioniDipendente(Persona p) {
		try {
			String query = "select * from employeewallet where cf=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, p.getCf().getValue());
			ResultSet st = pstmt.executeQuery();
			
			while(st.next()) {
				return st.getInt("ammonizioni");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void attribuisciLavoroEffettuato(Dipendente d) {
		try {
			String query = "update employeewallet set effettuati=? where cf=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1,getlavoriEffettuatiDipendente(d)+1);
			pstmt.setString(2,d.getCf().getValue());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private int getlavoriEffettuatiDipendente(Persona p) {
		try {
			String query = "select * from employeewallet where cf=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, p.getCf().getValue());
			ResultSet st = pstmt.executeQuery();
			
			while(st.next()) {
				return st.getInt("effettuati");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void attribuisciLavoroRifiutato(Dipendente d) {
		try {
			String query = "update employeewallet set rifiutati=? where cf=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1,getlavoriRifiutatiDipendente(d)+1);
			pstmt.setString(2,d.getCf().getValue());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private int getlavoriRifiutatiDipendente(Persona p) {
		try {
			String query = "select * from employeewallet where cf=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, p.getCf().getValue());
			ResultSet st = pstmt.executeQuery();
			
			while(st.next()) {
				return st.getInt("rifiutati");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}





}
