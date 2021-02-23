package persistence.configuration;

import javax.swing.JOptionPane;

import persistence.website.abstraction.DipendenteDAO;
import persistence.website.abstraction.FeedbackDAO;
import persistence.website.abstraction.OrdineEffettivoDAO;
import persistence.website.abstraction.PartenzaDAO;
import persistence.website.abstraction.PortafoglioDAO;
import persistence.website.abstraction.RecensioneClienteDAO;
import persistence.website.abstraction.RichiestaAssunzioneDAO;
import persistence.website.abstraction.RichiestaOrdineDAO;
import persistence.website.abstraction.UtenteDAO;
import model.siteweb.Utente;

public abstract class DAOFactory {
	
	protected static DipendenteDAO dipendenteDAO;
	protected static PortafoglioDAO portafoglioDAO;
	protected static PartenzaDAO partenzaDAO;
	protected static RecensioneClienteDAO recensioneDAO;
	
	protected static OrdineEffettivoDAO ordineeffettivoDAO;
	protected static FeedbackDAO feedbackDAO;
	protected static UtenteDAO utenteDAO;
	protected static RichiestaAssunzioneDAO richiestaassunzioneDAO;
	protected static RichiestaOrdineDAO richiestaordineDAO;

	public abstract DipendenteDAO getDipendenteDAO();	
	public abstract PortafoglioDAO getPortafoglioDAO();

	
	public abstract UtenteDAO getUtenteDAO();
	public abstract RichiestaAssunzioneDAO getRichiestaAssunzioneDAO();
	public abstract RichiestaOrdineDAO getRichiestaOrdineDAO();
	public abstract PartenzaDAO getPartenzaDAO();
	public abstract RecensioneClienteDAO getRecensioneClienteDAO();
	
	/*Da ristrutturare*/
	
	public abstract OrdineEffettivoDAO getOrdineEffettivoDAO();
	public abstract FeedbackDAO getFeedbackDAO();
	

	
	private static DAOFactory uniqueFactoryInstance = null;
	
	protected DAOFactory() {
		
	}
	
	public static DAOFactory getDAOFactory() {
		if(uniqueFactoryInstance == null) {
			try {
				uniqueFactoryInstance = (DAOFactory) Class.forName("persistence.configuration.PostgresDAOFactory").newInstance();
				System.out.println("inizializzo fabbrica");
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				System.out.println("NULL");
				e.printStackTrace();
			}
		}
		
		return uniqueFactoryInstance;
	}

}
