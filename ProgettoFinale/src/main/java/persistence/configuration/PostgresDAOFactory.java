package persistence.configuration;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.security.crypto.bcrypt.BCrypt;

import persistence.website.abstraction.DipendenteDAO;
import persistence.website.abstraction.FeedbackDAO;
import persistence.website.abstraction.OrdineEffettivoDAO;
import persistence.website.abstraction.PartenzaDAO;
import persistence.website.abstraction.PortafoglioDAO;
import persistence.website.abstraction.RecensioneClienteDAO;
import persistence.website.abstraction.RichiestaAssunzioneDAO;
import persistence.website.abstraction.RichiestaOrdineDAO;
import persistence.website.abstraction.UtenteDAO;
import persistence.website.implementation.DipendenteDAOImplementation;
import persistence.website.implementation.FeedbackDAOImplementation;
import persistence.website.implementation.OrdineEffettivoDAOImplementation;
import persistence.website.implementation.PartenzeDAOImplementation;
import persistence.website.implementation.PortafoglioDAOImplementation;
import persistence.website.implementation.RecensioneClienteDAOImplementation;
import persistence.website.implementation.RichiestaAssunzioneDAOImplementation;
import persistence.website.implementation.RichiestaOrdineDAOImplementation;
import persistence.website.implementation.UtenteDAOImplementation;
import model.siteweb.Dipendente;
import model.siteweb.Partenza;
import model.siteweb.Utente;

public class PostgresDAOFactory extends DAOFactory {
	
	private static Connection con = null;
	

	public static Connection getConnection(){
		
		if(con == null) {
			try {
				Class.forName("org.postgresql.Driver");
				con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","siw19");
				
				if(con!=null)
					System.out.println("Connesso");
				else 
					System.out.println("Errore");
				
			} catch (Exception e) {
				System.out.println(e);
			}
			return con;
		}
		
		System.out.println("Connessione gia stabilita!");
		return con;
	
	}
	
	public static void initDB(){
		dipendenteDAO = new DipendenteDAOImplementation();
		portafoglioDAO = new PortafoglioDAOImplementation();
		
		ordineeffettivoDAO = new OrdineEffettivoDAOImplementation();
		feedbackDAO = new FeedbackDAOImplementation();
		utenteDAO = new UtenteDAOImplementation();
		richiestaassunzioneDAO = new RichiestaAssunzioneDAOImplementation();
		richiestaordineDAO = new RichiestaOrdineDAOImplementation();
		partenzaDAO = new PartenzeDAOImplementation();
		recensioneDAO = new RecensioneClienteDAOImplementation();
		
		dipendenteDAO.createTable(); //Non faccio portafoglioDAO.createTable() perchè è dentro dipendenteDAO();
		recensioneDAO.createTable();
		ordineeffettivoDAO.createTable();
		feedbackDAO.createTable();
		utenteDAO.createTable();
		richiestaassunzioneDAO.createTable();
		richiestaordineDAO.createTable();
		partenzaDAO.createTable();
		
		if(utenteDAO.getPasswordByEmail("esamewebcomputing@capo.it")==null) //esamewebcomputing@capo.it - unicaldelivery
		{
			System.out.println("Sto creando l'account capo dei professori");
			utenteDAO.insertUtenteProfessori(new Utente("esamewebcomputing@capo.it", BCrypt.hashpw("unicaldelivery", BCrypt.gensalt()), "capo"));
		}
		if(utenteDAO.getPasswordByEmail("esamewebcomputing1@dipendente.it")==null) { //esamewebcomputing@dipendente.it - defaultpassword
			System.out.println("Sto creando l'account dipendente dei professori");
			dipendenteDAO.insertDipendente(new Dipendente("esamewebcomputing1-2021", "Web", "Computing", "esamewebcomputing1@dipendente.it","ConsegnaTerrena"));
		}
		if(utenteDAO.getPasswordByEmail("esamewebcomputing2@dipendente.it")==null) { //esamewebcomputing@dipendente.it - defaultpassword
			System.out.println("Sto creando l'account dipendente dei professori");
			dipendenteDAO.insertDipendente(new Dipendente("esamewebcomputing2-2021", "Web", "Computing", "esamewebcomputing2@dipendente.it","ConsegnaAerea"));
		}
		if(utenteDAO.getPasswordByEmail("esamewebcomputing3@dipendente.it")==null) { //esamewebcomputing@dipendente.it - defaultpassword
			System.out.println("Sto creando l'account dipendente dei professori");
			dipendenteDAO.insertDipendente(new Dipendente("esamewebcomputing3-2021", "Web", "Computing", "esamewebcomputing3@dipendente.it","ConsegnaTerrena"));
		}
		
		if(partenzaDAO.getTappa("Milano") == null && partenzaDAO.getTappa("Firenze") == null && partenzaDAO.getTappa("Bologna") == null && partenzaDAO.getTappa("Torino") == null && partenzaDAO.getTappa("Bari") == null && partenzaDAO.getTappa("Napoli") == null)
		{
			partenzaDAO.insertPartenza(new Partenza("Roma","Milano","120","2","ConsegnaAerea"));
			partenzaDAO.insertPartenza(new Partenza("Roma","Milano","100","4","ConsegnaTerrena"));
			partenzaDAO.insertPartenza(new Partenza("Roma","Firenze","55","1","ConsegnaAerea"));
			partenzaDAO.insertPartenza(new Partenza("Roma","Firenze","65","2","ConsegnaTerrena"));
			partenzaDAO.insertPartenza(new Partenza("Roma","Bologna","70","1","ConsegnaAerea"));
			partenzaDAO.insertPartenza(new Partenza("Roma","Bologna","75","2","ConsegnaTerrena"));
			partenzaDAO.insertPartenza(new Partenza("Roma","Torino","90","2","ConsegnaAerea"));
			partenzaDAO.insertPartenza(new Partenza("Roma","Torino","100","3","ConsegnaTerrena"));
			partenzaDAO.insertPartenza(new Partenza("Roma","Bari","45","1","ConsegnaAerea"));
			partenzaDAO.insertPartenza(new Partenza("Roma","Bari","55","2","ConsegnaTerrena"));
			partenzaDAO.insertPartenza(new Partenza("Roma","Napoli","35","1","ConsegnaAerea"));
			partenzaDAO.insertPartenza(new Partenza("Roma","Napoli","40","2","ConsegnaTerrena"));
			
		}
		
	}
	@Override
	public RecensioneClienteDAO getRecensioneClienteDAO() {
		return recensioneDAO;
	}
	
	
	@Override
	public DipendenteDAO getDipendenteDAO() {
		return dipendenteDAO;
	}

	@Override
	public PartenzaDAO getPartenzaDAO() {
		return partenzaDAO;
	}


	@Override
	public OrdineEffettivoDAO getOrdineEffettivoDAO() {
		return ordineeffettivoDAO;
	}


	@Override
	public FeedbackDAO getFeedbackDAO() {
		return feedbackDAO;
	}


	@Override
	public UtenteDAO getUtenteDAO() {
		return utenteDAO;
	}


	@Override
	public RichiestaAssunzioneDAO getRichiestaAssunzioneDAO() {
		return richiestaassunzioneDAO;
	}


	@Override
	public RichiestaOrdineDAO getRichiestaOrdineDAO() {
		return richiestaordineDAO;
	}


	@Override
	public PortafoglioDAO getPortafoglioDAO() {
		return portafoglioDAO;
	}




}
