package it.unicaldelivery.restcontroller;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unicaldelivery.controller.LoginController;
import persistence.configuration.DAOFactory;
import persistence.website.abstraction.UtenteDAO;

@RestController
@RequestMapping("/")
public class ProfileRestController {


@PostMapping("/modificaProfilo")
public void modifica(@RequestParam String newEmail, @RequestParam String oldPw, @RequestParam String newPw){
	System.out.println("Sto modificando il profilo in background nel DB");
	DAOFactory daoFactory = DAOFactory.getDAOFactory();
	UtenteDAO dao = daoFactory.getUtenteDAO();
	
	
	
	if(BCrypt.checkpw(oldPw,LoginController.utenteLoggato.getPassword())) {
		
		if(newPw.isEmpty()) {
			System.out.println("Vuole cambiato solo l'email");
			dao.cambiaEmail(LoginController.utenteLoggato.getEmail(), LoginController.utenteLoggato.getPassword(), newEmail);
			
			LoginController.utenteLoggato.setEmail(newEmail);
		}
		
		if(newEmail.isEmpty()) {
			System.out.println("Vuole cambiato solo la password");
			dao.cambiaPassword(LoginController.utenteLoggato.getEmail(), LoginController.utenteLoggato.getPassword(), newPw);
			
			LoginController.utenteLoggato.setPassword(dao.getPasswordByEmail(LoginController.utenteLoggato.getEmail()));
		}
		
		if(!newPw.isEmpty() && !newEmail.isEmpty()) {
			System.out.println("Vuole cambiato email e password");
			System.out.println(LoginController.utenteLoggato.getEmail());
			dao.cambiaEmail(LoginController.utenteLoggato.getEmail(), LoginController.utenteLoggato.getPassword(), newEmail);
			LoginController.utenteLoggato.setEmail(newEmail);
			dao.cambiaPassword(LoginController.utenteLoggato.getEmail(), LoginController.utenteLoggato.getPassword(), newPw);
			
			
			LoginController.utenteLoggato.setPassword(dao.getPasswordByEmail(LoginController.utenteLoggato.getEmail()));
		}
		
		
	}
	

	
	
}

}
