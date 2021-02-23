package it.unicaldelivery.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.siteweb.Utente;
import persistence.configuration.DAOFactory;
import persistence.website.abstraction.UtenteDAO;

@Controller
public class HomepageController {
	
	@GetMapping("/")
	public String primaPagina(Model model) {
		if(LoginController.utenteLoggato != null && LoginController.ricordaAccesso != null) {
			if(LoginController.utenteLoggato.getPermessiAccesso().equalsIgnoreCase("capo")) {
				LoginController.inizializzaGrafici(model);
				model.addAttribute("emailAttuale",LoginController.getUtenteLoggatoAttualmente().getEmail());
				return "homepageCapo";
			}else {
				///////////////////
			}
			
		}
		
		if(LoginController.utenteLoggato != null && LoginController.ricordaAccesso == null) {
			LoginController.session.invalidate();
			LoginController.utenteLoggato = null;
		}
		model.addAttribute("tentativiAccesso",LoginController.tentativiAccesso);
		model.addAttribute("messaggio","Benvenuto");
		return "introduzione";
	}
	
	
	
	@GetMapping("/homepageCliente")
	public String index() {
		return "homepageCliente"; ///WEBINF/views/index.jsp
	}
	
	@GetMapping("/chisiamo")
	public String chiSiamo() {
		return "chisiamo";
	}
	
	@GetMapping("/FAQ")
	public String faq() {
		return "faq";
	}
	
}
