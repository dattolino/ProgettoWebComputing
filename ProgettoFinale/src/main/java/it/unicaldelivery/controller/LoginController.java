package it.unicaldelivery.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import model.siteweb.Dipendente;
import model.siteweb.OrdineEffettivo;
import model.siteweb.Utente;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import persistence.configuration.DAOFactory;
import persistence.website.abstraction.DipendenteDAO;
import persistence.website.abstraction.OrdineEffettivoDAO;
import persistence.website.abstraction.RichiestaAssunzioneDAO;
import persistence.website.abstraction.RichiestaOrdineDAO;
import persistence.website.abstraction.UtenteDAO;
import persistence.website.implementation.UtenteDAOImplementation;

@Controller
public class LoginController {
	
	

	public static Utente utenteLoggato = null;
	public static Integer tentativiAccesso = 3;
	public static String ricordaAccesso = null;
	public static HttpSession session = null;
	
	public static void inizializzaGrafici(Model model) {
		DAOFactory daoFactory = DAOFactory.getDAOFactory();
		DipendenteDAO dao = daoFactory.getDipendenteDAO();
		RichiestaAssunzioneDAO dao2 = daoFactory.getRichiestaAssunzioneDAO();
		RichiestaOrdineDAO dao3 = daoFactory.getRichiestaOrdineDAO();
		
		int dipendentiTotaliSize = dao.selectAll().size();
		int dipendentiAerea = dao.selectAllByRole("ConsegnaAerea").size();
		int dipendentiTerrena = dao.selectAllByRole("ConsegnaTerrena").size();
		
		int assunzioneAerea = dao2.selectAllByRole("ConsegnaAerea").size();
		int assunzioneTerrena = dao2.selectAllByRole("ConsegnaTerrena").size();
		
		int richiestaAerea = dao3.selectByType("ConsegnaAerea").size();
		int richiestaTerrena = dao3.selectByType("ConsegnaTerrena").size();
		
		int richiesteAssunzioniTotali = dao2.selectAll().size();
		int richiesteOrdineTotali = dao3.selectAll().size();
		
		int somma = richiesteAssunzioniTotali + richiesteOrdineTotali;
		
		
		model.addAttribute("dipendentiAerea",dipendentiAerea);
		model.addAttribute("dipendentiTerrena",dipendentiTerrena);
		model.addAttribute("assunzioneAerea",assunzioneAerea);
		model.addAttribute("assunzioneTerrena",assunzioneTerrena);
		model.addAttribute("richiesteAerea",richiestaAerea);
		model.addAttribute("richiesteTerrena",richiestaTerrena);
		
		model.addAttribute("sizeRichiesteAssunzione",richiesteAssunzioniTotali);
		model.addAttribute("sizeRichiesteOrdine",richiesteOrdineTotali);
		model.addAttribute("somma",somma);
		
		System.out.println(somma);
		
	
		
		
	}

	@PostMapping("/doLogin")
	public String doLogin(HttpSession session,@RequestParam("email") String email, @RequestParam("password") String password,@RequestParam(value="checkboxValue",required=false) String checkbox,Model model){
		
		
		//Dobbiamo fare i diversi controlli: se vuole rimanere autenticato, non dovremo fare invalidate, altrimenti se non ha selezionato, dobbiamo capire quando sta per chiudere il sito e fare invalidate
		DAOFactory daoFactory = DAOFactory.getDAOFactory();
		UtenteDAO dao = daoFactory.getUtenteDAO();
		
		Utente u = null;
		
		
		
		String passwordHashed = dao.getPasswordByEmail(email);
		
		if(passwordHashed!=null) { 
		if(BCrypt.checkpw(password, passwordHashed))
				{
					System.out.println("Debug: riuscito");
					u = dao.selectUtente(email, passwordHashed);
				}
		}
		
		if(u!=null) {
			this.ricordaAccesso = checkbox;
			this.utenteLoggato = u;
			this.session = session;
			if(u.getPermessiAccesso().equalsIgnoreCase("Capo")) {
				session.setAttribute("capo", email);
				model.addAttribute("emailAttuale",email);
				inizializzaGrafici(model);
				return "homepageProvaCapo";
				//return "homepageCliente";
			}
			if(u.getPermessiAccesso().equalsIgnoreCase("Dipendente")) {
				session.setAttribute("dipendente", email);
				DipendenteDAO dao2 = daoFactory.getDipendenteDAO();
				Dipendente d= dao2.getDipendenteLoggato();
				String nome = d.getName().getValue();
				model.addAttribute("nome",nome);
				OrdineEffettivoDAO dao3 = daoFactory.getOrdineEffettivoDAO();
				String codiceFiscaleDipendenteLoggato = d.getCf().getValue();
				ArrayList<OrdineEffettivo> listaOrdini = dao3.selectAllByRiferimento(codiceFiscaleDipendenteLoggato, "in attesa");
				int ordiniInAttesa = listaOrdini.size();
				listaOrdini.clear();
				
				listaOrdini = dao3.selectAllByRiferimento(codiceFiscaleDipendenteLoggato, "in transito");
				int ordiniInTransito = listaOrdini.size();
				listaOrdini.clear();
				listaOrdini = dao3.selectAllByRiferimento(codiceFiscaleDipendenteLoggato, "consegnato");
				int ordiniConsegnati = listaOrdini.size();
				listaOrdini.clear();
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
		}
		if(tentativiAccesso == 1)
			return "faq";
		
		tentativiAccesso-=1;
		model.addAttribute("tentativiAccesso",tentativiAccesso);
		model.addAttribute("messaggio","Login non riuscito");
		return "introduzione";
		
}
	
	@GetMapping("/doLogout")
	public String doLogout(HttpSession session){
		session.invalidate();
		utenteLoggato = null;
		return "introduzione";
	}
	
	//Da cancellare poichè è nel ProfileRestController
	@PostMapping("/modificaProfiloCapo")
	public String modifica(@RequestParam("nuovaEmail") String nuovaEmail, @RequestParam("vecchiaPassword") String vecchiaPassword, @RequestParam("nuovaPassword") String nuovaPassword, Model model) {
		
		DAOFactory daoFactory = DAOFactory.getDAOFactory();
		UtenteDAO dao = daoFactory.getUtenteDAO();
		
		if(BCrypt.checkpw(vecchiaPassword,utenteLoggato.getPassword())) {
			
			if(nuovaPassword.isEmpty()) {
				System.out.println("Vuole cambiato solo l'email");
				dao.cambiaEmail(utenteLoggato.getEmail(), utenteLoggato.getPassword(), nuovaEmail);
				
				utenteLoggato.setEmail(nuovaEmail);
			}
			if(nuovaEmail.isEmpty()) {
				System.out.println("Vuole cambiato solo la password");
				dao.cambiaPassword(utenteLoggato.getEmail(), utenteLoggato.getPassword(), nuovaPassword);
				
				utenteLoggato.setPassword(dao.getPasswordByEmail(utenteLoggato.getEmail()));
			}
			
			if(!nuovaPassword.isEmpty() && !nuovaEmail.isEmpty()) {
				System.out.println("Vuole cambiato email e password");
				dao.cambiaPassword(utenteLoggato.getEmail(), vecchiaPassword, nuovaPassword);
				dao.cambiaEmail(utenteLoggato.getEmail(), vecchiaPassword, nuovaEmail);
				
				utenteLoggato.setEmail(nuovaEmail);
				utenteLoggato.setPassword(dao.getPasswordByEmail(utenteLoggato.getEmail()));
			}
			
			if(utenteLoggato.getPermessiAccesso().equalsIgnoreCase("capo")) {
				inizializzaGrafici(model);
				model.addAttribute("emailAttuale",utenteLoggato.getEmail());
				return "homepageCapo";
			}
			
			if(utenteLoggato.getPermessiAccesso().equalsIgnoreCase("dipendente"))
			{
				return "homepageDipendente";
			}
		}
		

		
		return "faq";
	

	}
	
	public static Utente getUtenteLoggatoAttualmente(){
		return utenteLoggato;
	}
}
