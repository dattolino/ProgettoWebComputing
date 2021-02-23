package it.unicaldelivery.restcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.log.SysoLogger;

import model.siteweb.Dipendente;
import model.siteweb.Feedback;
import persistence.configuration.DAOFactory;
import persistence.website.abstraction.DipendenteDAO;
import persistence.website.abstraction.FeedbackDAO;
import persistence.website.abstraction.UtenteDAO;

@RestController
@RequestMapping("/")

public class DipendenteRestController {

@PostMapping("/licenziaDipendente")
public void licenzia(@RequestParam String cf) {
	System.out.println("aaa");
	DAOFactory f = DAOFactory.getDAOFactory();
	DipendenteDAO dao = f.getDipendenteDAO();
	
	String emailDipendenteLicenziato = dao.getEmailByCF(cf);
	UtenteDAO dao2 = f.getUtenteDAO();
	dao2.deleteUtente(emailDipendenteLicenziato);
	dao.deleteDipendenteByCF(cf);
	
	System.out.println(emailDipendenteLicenziato);
	
	
	
	}

@PostMapping("/valutaDipendente")
public void valuta(@RequestParam String cf,@RequestParam String motivazione) {
	System.out.println("valutazione in background");
	DAOFactory f = DAOFactory.getDAOFactory();
	FeedbackDAO dao = f.getFeedbackDAO();
	
	dao.insertFeedback(new Feedback(cf,motivazione));
}



}
