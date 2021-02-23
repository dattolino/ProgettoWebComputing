package it.unicaldelivery.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import model.siteweb.Dipendente;
import model.siteweb.RecensioneCliente;
import persistence.configuration.DAOFactory;
import persistence.website.abstraction.DipendenteDAO;
import persistence.website.abstraction.RecensioneClienteDAO;

@Controller
public class RecensioneController {

	@GetMapping("/recensioni")
	public String prova(Model model) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		RecensioneClienteDAO dao = factory.getRecensioneClienteDAO();
		
		ArrayList<RecensioneCliente> lista = dao.selectAllRecensioni();
		model.addAttribute("size",lista.size());
		model.addAttribute("listaRecensioni",lista);
		return "prova";
	}
	
	@GetMapping("/provaimg")
	public String a(Model model) {
		model.addAttribute("daInput","resources/img/logoCircolare.jpg");
		return "provaimmagine";
		
	}
}

