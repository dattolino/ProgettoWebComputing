package it.unicaldelivery.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import persistence.configuration.DAOFactory;
import persistence.website.abstraction.UtenteDAO;
import utility.SyntheticMailSender;

@Controller
public class RecuperoPasswordController {
	
	public static int codiceDaInserire = 0;
	private String emailInConsiderazione = null;

	@GetMapping("/recuperoPassword")
	public String recuperoPassword() {
		return "recuperopassword";
	}
	
	@PostMapping("/invioMailConfermaCodice")
	public String invioMaileConfermaCodice(@RequestParam("email") String email, @RequestParam("ruolo") String ruolo, Model model) {
		DAOFactory daoFactory = DAOFactory.getDAOFactory();
		UtenteDAO dao = daoFactory.getUtenteDAO();
		
		if(!dao.esisteQuestaMail(email)) {
			return "faq";
		}
		
		Random rnd = new Random();
		int n = rnd.nextInt(15000);
		this.codiceDaInserire = n;
		this.emailInConsiderazione = email;
		
		SyntheticMailSender.sendEmail(email, "Codice recupero password", "Il codice da inserire e': " + n);
		model.addAttribute("emailPersona", email);
		return "recuperoPassword2";
		
	}
	
	@PostMapping("/confermaCodice")
	public String confermaCodice(@RequestParam("codice") int codice,Model model) {
		if(codice != codiceDaInserire)
			return "faq";
		model.addAttribute("emailPersona",emailInConsiderazione);
		return "recuperoPassword3"; //Dove gli facciamo modificare la password
		
	}
	
	@PostMapping("/cambiaUfficialmentePassword")
	public String cambiaPassword(@RequestParam("passwordNuova") String passwordNuova, Model model) {
		
		
		DAOFactory daoFactory = DAOFactory.getDAOFactory();
		UtenteDAO dao = daoFactory.getUtenteDAO();
		
		dao.cambiaPasswordDaRecupero(emailInConsiderazione, passwordNuova);
		model.addAttribute("messaggio","Password modificata con successo");
		return "introduzione";
		
	}
}
