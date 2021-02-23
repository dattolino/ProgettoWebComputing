package it.unicaldelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.siteweb.Feedback;
import persistence.configuration.DAOFactory;
import persistence.website.abstraction.DipendenteDAO;
import persistence.website.abstraction.FeedbackDAO;
import persistence.website.abstraction.RichiestaAssunzioneDAO;

@Controller
public class CapoController {

	@GetMapping("/homepageCapo")
	public String homepageCapo(Model model) {
		LoginController.inizializzaGrafici(model);
		model.addAttribute("emailAttuale",LoginController.getUtenteLoggatoAttualmente().getEmail());
		return "homepageProvaCapo";
	}
	
	@GetMapping("/visualizzaMap")
	public String map() {
		return "mapbox";
	}
	
	@GetMapping("/relazione")
	public String get() {
		return "pdfviewer";
	}
	


	
	
	
}
