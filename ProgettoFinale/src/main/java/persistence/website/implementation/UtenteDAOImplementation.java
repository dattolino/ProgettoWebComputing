package persistence.website.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.security.crypto.bcrypt.BCrypt;


import persistence.configuration.PostgresDAOFactory;
import persistence.website.abstraction.UtenteDAO;
import model.siteweb.Utente;

public class UtenteDAOImplementation implements UtenteDAO{
	
	private Connection con;
	
	public UtenteDAOImplementation(){
		con = PostgresDAOFactory.getConnection();
	}
	
	@Override
	public void createTable(){
		try {
			String query = "create table if not exists utenti (email varchar(55), password varchar(255), permessiAccesso varchar(17))";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("ERRORE: Si è verificato un errore in createTable : UtenteDAOImplementation");
		}
	}
	
	@Override
	public boolean esisteQuestaMail(String email) {
		try {
			String query = "select * from utenti where email=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			ResultSet st = pstmt.executeQuery();
			while(st.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Errore in esisteQuestaMail");
		}
		return false;
	}

	@Override
	public void insertUtente(Utente u) {
		try {
			String query = "insert into utenti (email,password,permessiAccesso) values (?,?,?);";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, u.getEmail());
			pstmt.setString(2, BCrypt.hashpw(u.getPassword(),BCrypt.gensalt()));
			pstmt.setString(3, u.getPermessiAccesso());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("ERRORE in insertUtente dell'UtenteDAO");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void insertUtenteProfessori(Utente u) {
		try {
			String query = "insert into utenti (email,password,permessiAccesso) values (?,?,?);";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, u.getEmail());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getPermessiAccesso());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("ERRORE in insertUtente dell'UtenteDAO");
			e.printStackTrace();
		}
		
	}

	@Override
	public Utente selectUtente(String email, String password) {
		try {
			String query = "select * from utenti where email=? and password=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,email);
			pstmt.setString(2,password);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Utente daRitornare = new Utente(email,password,rs.getString("permessiAccesso"));
				return daRitornare;
			}
			
			
		} catch (Exception e) {
			System.out.println("ERRORE in selectUtente dell'UtenteDAO");
			e.printStackTrace();
		}
		return null;
	}

	@Override //DA RIVEDERE
	public void cambiaPassword(String email, String password, String newPassword) {
		Utente u = selectUtente(email, password);
		if(u!=null) {
			if(u.getPermessiAccesso().equalsIgnoreCase("dipendente")) {
				try {
					
					String query = "update employee set password=? where email=?";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1,BCrypt.hashpw(newPassword,BCrypt.gensalt()));
					pstmt.setString(2,email);
					
					pstmt.executeUpdate();
				}catch (Exception e) {
					System.out.println("ERRORE: Si è verificato un errore in cambiaPassword");
					e.printStackTrace();
				}
				
			}
				try {
					String query = "update utenti set password=? where email=?";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1,BCrypt.hashpw(newPassword,BCrypt.gensalt()));
					pstmt.setString(2,email);
					
					pstmt.executeUpdate();
				} catch (Exception e) {
					System.out.println("ERRORE: Si è verificato un errore in cambiaPassword");
					e.printStackTrace();
				}
				
			}
		}


	@Override
	public void cambiaEmail(String email, String password, String newEmail) {
		Utente u = selectUtente(email, password);
		if(u!=null) {
			if(u.getPermessiAccesso().equalsIgnoreCase("dipendente")) {
				System.out.println("Sono qua pt1");
				try {
					System.out.println(email);
					System.out.println("ho cambiato l'email nella tabella dipendente");
					String query = "update employee set email=? where email=?";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, newEmail);
					pstmt.setString(2, email);
					pstmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Sono qua2");
			try {
				System.out.println("ho cambiato l'email nella tabella utenti");
				String query = "update utenti set email=? where email=?";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, newEmail);
				pstmt.setString(2, email);
				pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("ERRORE: Si è verificato un errore in cambiaEmail");
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	public String getPasswordByEmail(String email) {
		try {
			String query = "select * from utenti where email=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			ResultSet st = pstmt.executeQuery();
			while(st.next()) {
				return st.getString("password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteUtente(String email) {
		try {
			System.out.println("A");
			String query = "delete from utenti where email=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,email);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Errore: Si è verificato un errore in UtenteDAOImplementation : deleteUtente");
		}
	}
	
	@Override
	public void cambiaPasswordDaRecupero(String email,String newPassword) {
		try {
			
			String query = "update utenti set password=? where email=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, BCrypt.hashpw(newPassword, BCrypt.gensalt()));
			pstmt.setString(2, email);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("ERRORE: Si è verificato un errore in cambiaPWDaRecupero");
			e.printStackTrace();
		}
		
	}
	@Override
	public String selectEmailCapo() {
        try {
            String query = "select * from utenti where permessiAccesso = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, "Capo");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                return rs.getString("email");
            }
        } catch (Exception e) {
            System.out.println("ERRORE: Si è verificato un errore in cambiaEmail");
            e.printStackTrace();
        }
       
        return "ERROR";
    }

	@Override
	public Utente selectUtente(String email) {
		try {
			String query = "select * from utenti where email=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,email);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Utente daRitornare = new Utente(email,rs.getString("password"),rs.getString("permessiAccesso"));
				return daRitornare;
			}
			
			
		} catch (Exception e) {
			System.out.println("ERRORE in selectUtente dell'UtenteDAO");
			e.printStackTrace();
		}
		return null;
	}

	

}
