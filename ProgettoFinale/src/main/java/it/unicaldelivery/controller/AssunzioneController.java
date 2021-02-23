package it.unicaldelivery.controller;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.abstraction.Persona;
import model.siteweb.RichiestaAssunzione;
import persistence.configuration.DAOFactory;
import persistence.website.abstraction.DipendenteDAO;
import persistence.website.abstraction.RichiestaAssunzioneDAO;
import utility.SyntheticMailSender;

@Controller
public class AssunzioneController {
	
	private RichiestaAssunzione p;

	@GetMapping("/lavoraconnoi")
		public String lavora() {
			return "lavoraconnoi";
	}
	
	@PostMapping("/riepilogoDati")
	public String riepilogo(@RequestParam("codiceFiscale") String codiceFiscale, @RequestParam("nome") String nome, @RequestParam("cognome") String cognome, @RequestParam("email") String email,@RequestParam("ruolo")String ruolo, Model model) {
		
		model.addAttribute("nome",nome);
		model.addAttribute("codiceFiscale",codiceFiscale);
		
		model.addAttribute("cognome",cognome); 
		model.addAttribute("email",email);
		model.addAttribute("ruolo",ruolo);
		
		p = new RichiestaAssunzione(codiceFiscale,nome,cognome,email,ruolo);
		
		
		return "riepilogoassunzione";
	}
	
	
	//insert //Da aggiungere un controllo che veda se questa richiesta d'assunzione sia stata già fatta, o esiste già un dipendente con lo stesso cf
	@GetMapping("/confermaDati")
	public String confermaDati() {
		DAOFactory factory = DAOFactory.getDAOFactory();
		RichiestaAssunzioneDAO dao = (RichiestaAssunzioneDAO) factory.getRichiestaAssunzioneDAO();
		
		RichiestaAssunzione ipoteticaEsistenza = dao.selectRichiestaAssunzioneByCF(p.getCf().getValue());
		if(ipoteticaEsistenza != null)
			return "faq";
		dao.insertRichiestaAssunzione(p);
		
		SyntheticMailSender.sendEmail(p.getEmail().getValue(), "Richiesta d'assunzione inoltrata", "La informiamo che la sua richiesta d'assunzione e' stata inviata correttamente al sistema Unical Delivery, attendi per l'esito da parte del capo dell'azienda");
		return "homepageCliente";
		
		
	}
	
	//selectAll
	@GetMapping("richiesteAssunzione")
	public String gestisciRichieste(Model model) {
		
		DAOFactory daoFactory = DAOFactory.getDAOFactory();
		RichiestaAssunzioneDAO dao = daoFactory.getRichiestaAssunzioneDAO();
		
		ArrayList<RichiestaAssunzione> lista = dao.selectAll();
		model.addAttribute("listaRichiesteAssunzione",lista);
		
		return "gestionerichiesteassunzioni";
	}
	
	
	//insert:DipendenteDAO delete::RichiestaAssunzioneDAO
	@PostMapping("/gestioneRichiesta")
	public String accetta(@RequestParam("check") String check,@RequestParam("value") String bottonePremuto, Model model) {
		DAOFactory daoFactory = DAOFactory.getDAOFactory();
		RichiestaAssunzioneDAO dao = daoFactory.getRichiestaAssunzioneDAO();
		DipendenteDAO dao2 = daoFactory.getDipendenteDAO();
		
		RichiestaAssunzione a = dao.selectRichiestaAssunzioneByCF(check);
		
		if(bottonePremuto.equalsIgnoreCase("Rifiuta")){
			dao.deleteRichiestaAssunzione(check);
		}
		
		if(bottonePremuto.equalsIgnoreCase("Accetta")) {
			dao2.insertDipendente(a);
			dao.deleteRichiestaAssunzione(check);
		}
		
		
		ArrayList<RichiestaAssunzione> lista = dao.selectAll();
		model.addAttribute("listaRichiesteAssunzione",lista);
		model.addAttribute("emailAttuale",LoginController.getUtenteLoggatoAttualmente().getEmail());
		return "gestionerichiesteassunzioni";
		
	}
	
	
	
	
}
