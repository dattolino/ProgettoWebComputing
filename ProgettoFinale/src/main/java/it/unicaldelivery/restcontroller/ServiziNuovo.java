package it.unicaldelivery.restcontroller;

import java.io.FileNotFoundException;

import java.time.LocalTime;
import java.util.ArrayList;

import model.siteweb.Dipendente;
import model.siteweb.Feedback;
import model.siteweb.OrdineEffettivo;
import model.siteweb.RichiestaOrdine;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;










import persistence.configuration.DAOFactory;
import persistence.website.abstraction.FeedbackDAO;
import persistence.website.abstraction.OrdineEffettivoDAO;
import persistence.website.abstraction.UtenteDAO;
import persistence.website.implementation.DipendenteDAOImplementation;
import persistence.website.implementation.OrdineEffettivoDAOImplementation;
import persistence.website.implementation.PortafoglioDAOImplementation;
import persistence.website.implementation.RichiestaOrdineDAOImplementation;
import persistence.website.implementation.UtenteDAOImplementation;

@RestController
public class ServiziNuovo {
	ArrayList<OrdineEffettivo> listaOrdini = new ArrayList<OrdineEffettivo>();
	ArrayList<Dipendente> listaDipendenti = new ArrayList<Dipendente>();
	ArrayList<RichiestaOrdine> listaRichieste = new ArrayList<RichiestaOrdine>();
	RichiestaOrdine ordineSelezionato; 

	@PostMapping("Analizza")
	public OrdineEffettivo AnalizzaOrdine(String richiesta, String statoOrdine, Model model) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		DipendenteDAOImplementation dao = (DipendenteDAOImplementation) factory.getDipendenteDAO();
		Dipendente d = dao.getDipendenteLoggato();
		OrdineEffettivoDAOImplementation dao2 = (OrdineEffettivoDAOImplementation) factory.getOrdineEffettivoDAO();
		String riferimento = d.getCf().getValue();
		listaOrdini = dao2.selectAllByRiferimento(riferimento, statoOrdine);
		for(OrdineEffettivo oe: listaOrdini) {
			if(oe.getRichiesta().getValue().equals(richiesta)) {
				return oe;
			}
		}
		System.out.println("quiiii");
		//model.addAttribute("listaOrdini", listaOrdini);
		return null;
	}
	
	@PostMapping("AnalizzaRichiesta")
	public RichiestaOrdine AnalizzaRichiesta(String richiesta) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		RichiestaOrdineDAOImplementation dao2 =  (RichiestaOrdineDAOImplementation) factory.getRichiestaOrdineDAO();
		listaRichieste = dao2.selectAll();
		System.out.println(richiesta);
		for(RichiestaOrdine oe: listaRichieste) {
			
			if(oe.getRichiesta().getValue().equals(richiesta)) {
				
				return oe;
			}
		}
		
		//model.addAttribute("listaOrdini", listaOrdini);
		return null;
	}
	
	@PostMapping("listaOrdiniRefresh")
	public ArrayList<OrdineEffettivo> listaOrdiniInAttesa(String stato) {
		listaOrdini.clear();
		DAOFactory factory = DAOFactory.getDAOFactory();
		DipendenteDAOImplementation dao = (DipendenteDAOImplementation) factory.getDipendenteDAO();
		Dipendente d = dao.getDipendenteLoggato();
		OrdineEffettivoDAO dao2 = factory.getOrdineEffettivoDAO();
		String riferimento = d.getCf().getValue();
		
		return listaOrdini = dao2.selectAllByRiferimento(riferimento, stato);
	}
	@PostMapping("listaRichiesteRefresh")
	public ArrayList<RichiestaOrdine> listaRichieste() {
		DAOFactory factory = DAOFactory.getDAOFactory();
		RichiestaOrdineDAOImplementation dao2 =  (RichiestaOrdineDAOImplementation) factory.getRichiestaOrdineDAO();
		listaRichieste = dao2.selectAll();
		return listaRichieste ;
	}
	
	@PostMapping("InoltraDipendente")
	public ArrayList<Dipendente> InoltraDipendente(String modalita,String richiesta) {
		
		DAOFactory factory = DAOFactory.getDAOFactory();
		DipendenteDAOImplementation dao = (DipendenteDAOImplementation) factory.getDipendenteDAO();
		RichiestaOrdineDAOImplementation dao2 =  (RichiestaOrdineDAOImplementation) factory.getRichiestaOrdineDAO();
		listaRichieste = dao2.selectAll();
		for(RichiestaOrdine oe: listaRichieste) {
			if(oe.getRichiesta().getValue().equals(richiesta) && oe.getModalita().getValue().equals(modalita)) {
				ordineSelezionato = oe;
				
			}
		}
		listaDipendenti = dao.selectAllByRole(modalita);
	
		return listaDipendenti;
	}
	
	@PostMapping("confermaInoltro")
	public String ConfermaInoltro(String riferimento){
		
		DAOFactory factory = DAOFactory.getDAOFactory();
		OrdineEffettivoDAOImplementation dao2 = (OrdineEffettivoDAOImplementation) factory.getOrdineEffettivoDAO();
		OrdineEffettivo oe = ordineSelezionato.trasformaInOrdineEffettivo(riferimento);
		dao2.aggiungiOrdineEffettivo(oe);
		RichiestaOrdineDAOImplementation dao3 =  (RichiestaOrdineDAOImplementation) factory.getRichiestaOrdineDAO();
		dao3.deleteRichiestaOrdine(ordineSelezionato);
		return "Ordine Inoltrato";
	}
	
	@PostMapping("gestisciOrdine1")
	public String gestisciOrdine1(String richiesta , String stato, String nuovoStato) {
		listaOrdini.clear();
		DAOFactory factory = DAOFactory.getDAOFactory();
		DipendenteDAOImplementation dao = (DipendenteDAOImplementation) factory.getDipendenteDAO();
		Dipendente d = dao.getDipendenteLoggato();
		OrdineEffettivoDAOImplementation dao2 = (OrdineEffettivoDAOImplementation) factory.getOrdineEffettivoDAO();
		PortafoglioDAOImplementation dao3 = (PortafoglioDAOImplementation) factory.getPortafoglioDAO();

		String riferimento = d.getCf().getValue();
		listaOrdini = dao2.selectAllByRiferimento(riferimento, stato);
		
		for(OrdineEffettivo ord : listaOrdini) {
			if(nuovoStato.equals("in transito")) {
				if(ord.getRichiesta().getValue().equals(richiesta)) {	
					dao2.cambiaStato(nuovoStato, ord);
					LocalTime t = LocalTime.now();
					dao2.updateOrario(ord, t.getHour());
					return "OK";
				}
			} 
			else if(nuovoStato.equals("consegnato")) {
				if(ord.getRichiesta().getValue().equals(richiesta)) {
					dao2.cambiaStato(nuovoStato, ord);
					dao3.attribuisciLavoroEffettuato(d);
					int orarioVecchio = dao2.getOrarioFromDB(ord);
					LocalTime t = LocalTime.now();
					int orarioNuovo = t.getHour();
					dao2.updateOrario(ord, orarioNuovo);
					int orarioDaConsiderare = Integer.parseInt(ord.getDurata().getValue());
					if((orarioNuovo-orarioVecchio) > orarioDaConsiderare) {						
						dao3.attribuisciAmmonizione(d);
						return "BONUS FAIL";
					}
					else {
						dao3.attribuisciBonus(d);	
						return "BONUS OK";
					}
				}
			} 
			else {
				if(ord.getRichiesta().getValue().equals(richiesta)) {
					dao2.cancellaOrdine(ord);
					return "ELIMINATO";
				}
			}
		}
		return "FAIL";
	}
	
	@PostMapping("gestisciOrdine2")
	public String gestisciOrdine2(String richiesta , String stato, String nuovoStato) {
		listaOrdini.clear();
		DAOFactory factory = DAOFactory.getDAOFactory();
		DipendenteDAOImplementation dao = (DipendenteDAOImplementation) factory.getDipendenteDAO();
		Dipendente d = dao.getDipendenteLoggato();
		OrdineEffettivoDAOImplementation dao2 = (OrdineEffettivoDAOImplementation) factory.getOrdineEffettivoDAO();
		PortafoglioDAOImplementation dao3 = (PortafoglioDAOImplementation) factory.getPortafoglioDAO();
		RichiestaOrdineDAOImplementation dao4 = (RichiestaOrdineDAOImplementation) factory.getRichiestaOrdineDAO();
		String riferimento = d.getCf().getValue();
		listaOrdini = dao2.selectAllByRiferimento(riferimento, stato);
		
			for(OrdineEffettivo ord : listaOrdini) {
				if(nuovoStato.equals("rifiutato")) {
					if(ord.getRichiesta().getValue().equals(richiesta)) {	
						dao3.attribuisciLavoroRifiutato(d);
						OrdineEffettivo daCancellare = ord;
						RichiestaOrdine daInserire = daCancellare.trasformaInRichiestaOrdine();
						dao4.insertRichiestaOrdine(daInserire);
						dao2.cancellaOrdine(daCancellare);
						FeedbackDAO feedback = factory.getFeedbackDAO();
						feedback.insertFeedback(new Feedback(riferimento, "Ordine rifiutato" ));
	
						return "RIFIUTATO";
					}
				} 
				else if(nuovoStato.equals("in attesa")) {
					if(ord.getRichiesta().getValue().equals(richiesta)) {
						dao2.cambiaStato(nuovoStato, ord);
					}
					return "IN ATTESA";
				} 			
			}
		return "FAIL";
	}
	
	@GetMapping("eliminaOrdiniConsegnati")
	public void eliminaOrdiniConsegnati() {
		DAOFactory factory = DAOFactory.getDAOFactory();
		DipendenteDAOImplementation dao = (DipendenteDAOImplementation) factory.getDipendenteDAO();
		Dipendente d = dao.getDipendenteLoggato();
		OrdineEffettivoDAOImplementation dao2 = (OrdineEffettivoDAOImplementation) factory.getOrdineEffettivoDAO();
		String riferimento = d.getCf().getValue();
		listaOrdini = dao2.selectAllByRiferimento(riferimento, "consegnato");
		
		for(OrdineEffettivo ord : listaOrdini) {
			dao2.cancellaOrdine(ord);
		}
	}
	
	@PostMapping("emailSender")
	public String emailSender(String oggetto, String testo, String emailMittente) {
		//DAOFactory factory = DAOFactory.getDAOFactory();
		//UtenteDAO dao = factory.getUtenteDAO();
		String testoConEmail = "Email inviata da: " + emailMittente + System.lineSeparator() + testo;
		try {
			email.EmailSender.sendMessage("unicaldeliveryspa@gmail.com", oggetto, testoConEmail, "", false);
			return "SUCCESS";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "ERROR";
		}
	}
	
	@PostMapping("downloadListaOrdini")
	public String downloadListaOrdini(String cf1) {
		if(cf1 == null) {
			return "ERROR";
		}
		listaOrdini.clear();
		DAOFactory factory = DAOFactory.getDAOFactory();
		OrdineEffettivoDAOImplementation dao = (OrdineEffettivoDAOImplementation) factory.getOrdineEffettivoDAO();
		
		listaOrdini = dao.selectAllByRiferimento(cf1, "in attesa");
		listaOrdini.addAll(dao.selectAllByRiferimento(cf1, "in transito"));
		listaOrdini.addAll(dao.selectAllByRiferimento(cf1, "consegnato"));
		
		try {
			email.Utility.generatePdfOrdini(listaOrdini);
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
			return "ERROR";
		}
		
		return "SUCCESS";
	}
	
}
