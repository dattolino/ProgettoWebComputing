package it.unicaldelivery.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.siteweb.Dipendente;
import model.siteweb.Feedback;
import persistence.configuration.DAOFactory;
import persistence.website.abstraction.DipendenteDAO;
import persistence.website.abstraction.FeedbackDAO;


@Controller
public class DipendentiController {

	@GetMapping("/dipendenti")
	public String dipendenti(Model model){
		
		DAOFactory factory = DAOFactory.getDAOFactory();
		DipendenteDAO dao = factory.getDipendenteDAO();
		
		ArrayList<Dipendente> lista = dao.selectAll();
		model.addAttribute("listaDipendenti",lista);
		model.addAttribute("emailAttuale",LoginController.getUtenteLoggatoAttualmente().getEmail());
		return "gestioneDipendenti";
	}
	

}
