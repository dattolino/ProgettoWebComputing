package it.unicaldelivery.controller;

import java.util.ArrayList;

import model.siteweb.Dipendente;
import model.siteweb.OrdineEffettivo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import persistence.configuration.DAOFactory;
import persistence.website.implementation.DipendenteDAOImplementation;
import persistence.website.implementation.OrdineEffettivoDAOImplementation;
import persistence.website.implementation.PortafoglioDAOImplementation;



@Controller

public class ControllerSezioneDipendenteNuovo {
	
	ArrayList<OrdineEffettivo> listaOrdini = new ArrayList<OrdineEffettivo>();
	
	@GetMapping("listaOrdiniInAttesa")
	public String listaOrdiniInAttesa(Model model) {
		listaOrdini.clear();
		DAOFactory factory = DAOFactory.getDAOFactory();
		DipendenteDAOImplementation dao = (DipendenteDAOImplementation) factory.getDipendenteDAO();
		Dipendente d = dao.getDipendenteLoggato();
		OrdineEffettivoDAOImplementation dao2 = (OrdineEffettivoDAOImplementation) factory.getOrdineEffettivoDAO();
		String riferimento = d.getCf().getValue();
		listaOrdini = dao2.selectAllByRiferimento(riferimento, "in attesa");
		model.addAttribute("listaOrdini", listaOrdini);
		model.addAttribute("cf", riferimento);
		
		return "dipendente/listaOrdini";
	}

	@GetMapping("Profilo")
	public String Profilo(Model model) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		DipendenteDAOImplementation dao = (DipendenteDAOImplementation) factory.getDipendenteDAO();
		Dipendente d = dao.getDipendenteLoggato();
		model.addAttribute("name",d.getName().getValue());
		model.addAttribute("surname",d.getSurname().getValue());
		model.addAttribute("email",d.getEmail().getValue());
		model.addAttribute("role",d.getRole().getValue());
		model.addAttribute("cf",d.getCf().getValue());
		return "dipendente/Profilo";
	}
	@GetMapping("Portafoglio")
	public String Portafoglio(Model model) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		DipendenteDAOImplementation dao = (DipendenteDAOImplementation) factory.getDipendenteDAO();
		Dipendente d = dao.getDipendenteLoggato();
		PortafoglioDAOImplementation dao2 = (PortafoglioDAOImplementation) factory.getPortafoglioDAO();
		model.addAttribute("stipendio",dao2.selectPortafoglioDipendente(d).getStipendio().getValue());
		model.addAttribute("accettati",dao2.selectPortafoglioDipendente(d).getLavoriEffettuati().getValue());
		model.addAttribute("rifiutati",dao2.selectPortafoglioDipendente(d).getLavoriRifiutati().getValue());
		model.addAttribute("bonus",dao2.selectPortafoglioDipendente(d).getBonus().getValue());
		model.addAttribute("ammonizioni",dao2.selectPortafoglioDipendente(d).getAmmonizioni().getValue());
		return "dipendente/Portafoglio";
	}
	
	@GetMapping("Chiarimenti")
	public String Chiarimenti(Model model) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		DipendenteDAOImplementation dao = (DipendenteDAOImplementation) factory.getDipendenteDAO();
		Dipendente d = dao.getDipendenteLoggato();
		String riferimento = d.getCf().getValue();
		model.addAttribute("email", dao.getEmailByCF(riferimento));

		return "dipendente/Chiarimenti";
	}
	
	
	
	@GetMapping("ricaricaHomepage")
	public String ricarica(Model model) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		DipendenteDAOImplementation dao2 = (DipendenteDAOImplementation) factory.getDipendenteDAO();
		Dipendente d= dao2.getDipendenteLoggato();
		String nome = d.getName().getValue();
		model.addAttribute("nome",nome);
		OrdineEffettivoDAOImplementation dao3 = (OrdineEffettivoDAOImplementation) factory.getOrdineEffettivoDAO();
		String riferimento = d.getCf().getValue();
		//model.addAttribute("cf", riferimento);
		ArrayList<OrdineEffettivo> listaOrdini = dao3.selectAllByRiferimento(riferimento, "in attesa");
		int ordiniInAttesa = listaOrdini.size();
		listaOrdini.clear();
		listaOrdini = dao3.selectAllByRiferimento(riferimento, "in transito");
		int ordiniInTransito = listaOrdini.size();
		listaOrdini.clear();
		listaOrdini = dao3.selectAllByRiferimento(riferimento, "consegnato");
		int ordiniConsegnati = listaOrdini.size();
		model.addAttribute("inattesa",ordiniInAttesa);
		model.addAttribute("intransito",ordiniInTransito);
		model.addAttribute("consegnato",ordiniConsegnati);
		String tipo = d.getRole().getValue();
		if(tipo.equalsIgnoreCase("ConsegnaTerrena")) {
			model.addAttribute("CT","camion");
		}
		if(tipo.equalsIgnoreCase("ConsegnaAerea")) {
			model.addAttribute("CT","aereo");
		}
		
		return "dipendente/homepageDipendente";
	}
	
	@GetMapping("Settings")
	public String Settings(Model model) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		DipendenteDAOImplementation dao2 = (DipendenteDAOImplementation) factory.getDipendenteDAO();
		Dipendente d= dao2.getDipendenteLoggato();
		String emailAtt=d.getEmail().getValue();
		model.addAttribute("emailat",emailAtt);
		return "dipendente/Impostazioni";
	}
	
	
	
	
}
