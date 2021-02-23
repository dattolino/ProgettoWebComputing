package persistence.website.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.security.crypto.bcrypt.BCrypt;

import it.unicaldelivery.controller.LoginController;
import model.abstraction.Persona;
import model.siteweb.Dipendente;
import model.siteweb.Utente;
import persistence.configuration.PostgresDAOFactory;
import persistence.website.abstraction.DipendenteDAO;
import persistence.website.abstraction.PortafoglioDAO;
import persistence.website.abstraction.UtenteDAO;

public class DipendenteDAOImplementation implements DipendenteDAO {
	
	private Connection con;
	private PortafoglioDAO portafoglioDAO;
	private UtenteDAO utenteDAO;
	
	public DipendenteDAOImplementation() {
		con = PostgresDAOFactory.getConnection();
		portafoglioDAO = new PortafoglioDAOImplementation();
		utenteDAO = new UtenteDAOImplementation();
	}

	//Qua dobbiamo aggiungere il createTable di PortafoglioDAO
	@Override
	public void createTable() {
		try {
			String query = "create table if not exists employee (id SERIAL, cf varchar(55), name varchar(55), surname varchar(55), role varchar(17), email varchar(255),password varchar(255), primary key(id))";
			portafoglioDAO.createTable();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("ERRORE: Si è verificato un errore in createTable : DipendenteDAO");
		}
	}

	@Override
	public ArrayList<Dipendente> selectAll() {
		ArrayList<Dipendente> daRitornare = new ArrayList<>();
		try {
			String query = "select * from employee";
			Statement stmt = con.createStatement();
			ResultSet st = stmt.executeQuery(query);
			while(st.next()){ /*cf, name, surname, role, email, password*/
				daRitornare.add(new Dipendente(st.getString("cf"),st.getString("name"),st.getString("surname"),st.getString("email"),st.getString("role")));
			}
			return daRitornare;
		} catch (Exception e) {
			System.out.println("ERRORE : Si è verificato un errore in selectAllDipendenti");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Dipendente> selectAllByRole(String role) {
		ArrayList<Dipendente> emploies = new ArrayList<Dipendente>();
		try {
			String query = "select * from employee where role=?"; /*where id='3'* per esempio*/
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, role);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Dipendente temp = new Dipendente(rs.getString("cf"),rs.getString("name"),rs.getString("surname"),rs.getString("email"),rs.getString("role"));
				emploies.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emploies;
	}

	@Override //Bisogna aggiungere insertPortafoglio(e);
	public boolean insertDipendente(Persona e) {
		try {
			String query = "select * from employee";
			Statement stmt = con.createStatement();
			ResultSet st = stmt.executeQuery(query);
			while(st.next()){
				if(st.getString("email").equalsIgnoreCase(e.getEmail().getValue()))
						return false;
			}
		}catch(Exception e3) {
				e3.printStackTrace();
			}
			
			try{
				String query1 = "INSERT INTO public.employee(cf, name, surname, role, email, password)\r\n" + 
			
					"	VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement pstmt1 = con.prepareStatement(query1);
			
			pstmt1.setString(1, e.getCf().getValue());
			pstmt1.setString(2, e.getName().getValue());
			pstmt1.setString(3, e.getSurname().getValue());
			pstmt1.setString(4, e.getRole().getValue());
			pstmt1.setString(5, e.getEmail().getValue());
			
			pstmt1.setString(6, BCrypt.hashpw("defaultpassword", BCrypt.gensalt()));
			
			pstmt1.executeUpdate();
			
			portafoglioDAO.insertPortafoglio(e);
			utenteDAO.insertUtente(new Utente(e.getEmail().getValue(),"defaultpassword","dipendente"));
			
		} catch (Exception e2) {
			System.out.println("ERRORE: Si è verificato un errore in insertDipendente : DipendenteDAO");
			e2.printStackTrace();
		}
		return true;
	}

	@Override //deletePortafoglio(Dipendente e);
	public void deleteDipendente(Dipendente e) {
		try {
			String query = "delete from employee where cf=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, e.getCf().getValue());
			pstmt.executeUpdate();
			
			portafoglioDAO.deletePortafoglio(e);
			utenteDAO.deleteUtente(e.getEmail().getValue());
		} catch (Exception e2) {
			System.out.println("ERRORE: Si è verificato un errore in deleteDipendente");
		}
		
	}
	@Override
	public void deleteDipendenteByCF(String cf) {
		try {
			String query = "delete from employee where cf=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, cf);
			pstmt.executeUpdate();
			
			String email = getEmailByCF(cf);
			portafoglioDAO.deletePortafoglioByCf(cf);
			utenteDAO.deleteUtente(email);
		} catch (Exception e2) {
			System.out.println("ERRORE: Si è verificato un errore in deleteDipendente");
		}
		
	}
	
	@Override
	public String getEmailByCF(String cf){
		try {
			String query = "select * from employee where cf=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, cf);
			ResultSet st = pstmt.executeQuery();
			while(st.next()) {
				return st.getString("email");
			}
		} catch (Exception e) {
			System.out.println("ERRORE in getEmailByCF");
		}
		return null;
	}
	@Override
	public Dipendente getDipendenteLoggato(){
			try {
				String query = "select * from employee where email=?";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, LoginController.getUtenteLoggatoAttualmente().getEmail());
				ResultSet st = stmt.executeQuery();
				while(st.next()) {
						return new Dipendente(st.getString("cf"),st.getString("name"),st.getString("surname"),
								st.getString("email"),st.getString("role"));
				}
					
			} catch (Exception e) {
				System.out.println("errore qua");
				// TODO: handle exception
			}
	
		return null;
	}

	

}
