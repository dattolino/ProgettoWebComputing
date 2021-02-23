package it.unicaldelivery.restcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import utility.SyntheticMailSender;

@RestController
@RequestMapping("/")
public class EmailRestController {

	
	@PostMapping("/contattaAzienda")
	public void contattaAzienda(@RequestParam String emailRichiedente, @RequestParam String subject, @RequestParam String message) {
		System.out.println("Sto contattando l'azienda in background");
		String messaggioFinale = "Email inviata da: " + emailRichiedente + System.lineSeparator() + message;
		
		System.out.println(messaggioFinale);
		SyntheticMailSender.botSendsEmail(subject, messaggioFinale);
	}
	
	
}
