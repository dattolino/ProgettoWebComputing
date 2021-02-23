package it.unicaldelivery.restcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.siteweb.RecensioneCliente;
import persistence.configuration.DAOFactory;
import persistence.website.abstraction.RecensioneClienteDAO;

@RestController
@RequestMapping("/")
public class RecensioneClienteRestController {

	@PostMapping("/inserisciRecensione")
	public void inserisciRecensione(@RequestParam String motivazione, @RequestParam String descrizione) {
		DAOFactory daoFactory = DAOFactory.getDAOFactory();
		RecensioneClienteDAO dao = daoFactory.getRecensioneClienteDAO();
		
		dao.insertRecensione(new RecensioneCliente(motivazione,descrizione));
	}
}
