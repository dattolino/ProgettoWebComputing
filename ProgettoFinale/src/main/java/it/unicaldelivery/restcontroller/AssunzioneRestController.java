package it.unicaldelivery.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.siteweb.Dipendente;
import model.siteweb.RichiestaAssunzione;
import persistence.configuration.DAOFactory;
import persistence.website.abstraction.DipendenteDAO;
import persistence.website.abstraction.RichiestaAssunzioneDAO;
import utility.SyntheticMailSender;

@RestController
@RequestMapping("/") 
public class AssunzioneRestController {

	@PostMapping("/rifiutaRichiesta")
	public RichiestaAssunzione rifiuta(@RequestParam String check, @RequestParam String motivazione) {
		System.out.println(motivazione);
		
		if(motivazione.equalsIgnoreCase("Qua...")) {
			motivazione = "Motivazione non specificata";
		}
		
		
		//Inviare un email in background con la motivazione.
		System.out.println("Sto eliminando dal DB in background");
		DAOFactory daoFactory = DAOFactory.getDAOFactory();
		RichiestaAssunzioneDAO dao = daoFactory.getRichiestaAssunzioneDAO();
		
		RichiestaAssunzione trattataAttualmente = dao.selectRichiestaAssunzioneByCF(check);
		
		//Invio email
		SyntheticMailSender.sendEmail(trattataAttualmente.getEmail().getValue(), "Rifiuto richiesta assunzione mandata da : " + trattataAttualmente.getName().getValue(), "La informiamo che la sua richiesta d'assunzione e' stata rifiutata da parte del capo per motivi di : " + motivazione + System.lineSeparator() + " La invitiamo a ritentare in un altro momento. La UnicalDelivery le lascia i saluti e le dispiace di tale situazione!");
		dao.deleteRichiestaAssunzione(check);
		
		
		
		return dao.selectRichiestaAssunzioneByCF(check);
	}
	
	@PostMapping("/accettaRichiesta")
	public RichiestaAssunzione accetta(@RequestParam String check) {
		//Inviare un email in background con la password;
		
		System.out.println("Sto accettando la richiesta ed eliminando dal DB in background");
		DAOFactory daoFactory = DAOFactory.getDAOFactory();
		RichiestaAssunzioneDAO dao = daoFactory.getRichiestaAssunzioneDAO();
		DipendenteDAO dao2 = daoFactory.getDipendenteDAO();
		
		RichiestaAssunzione a = dao.selectRichiestaAssunzioneByCF(check);
		SyntheticMailSender.sendEmail(a.getEmail().getValue(), a.getName().getValue() + " sei stato assunto dalla UnicalDelivery", "La UnicalDelivery S.p.A e' lieta di annunciarti che la sua candidatura come dipendente dell'azienda e' andata a buon fine. E' gia un nostro dipendente, cosa aspetti ad accedere al sistema? " + System.lineSeparator() + " Di seguito le forniamo le credenziali necessarie per accedere al sistema: " + System.lineSeparator() + "EMAIL: " + a.getEmail().getValue() + System.lineSeparator() + "PASSWORD: " + "defaultpassword" );
		dao2.insertDipendente(a);
		dao.deleteRichiestaAssunzione(check);
		return a;
	}
	
	@GetMapping("/ciao")
	public String ciao() {
		String ciao = "Ciao";
		return ciao;
	}
}
