package it.unicaldelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailJSPController {
	public static String to,subject,msg = null;
	
	@PostMapping("/inviaEmailDaJSP")
	public String inviaEmailDaJSP(@RequestParam("to") String to,@RequestParam("subject") String subject, @RequestParam("msg") String msg,Model model) {
		
		this.to = to;
		this.subject = subject;
		this.msg = msg;
		model.addAttribute("to",to);
		model.addAttribute("subject",subject);
		model.addAttribute("message",msg);
		return "scriptEmail";
	}
	
	@GetMapping("/riprovaInvio")
	public String riprovaEmail(Model model) {
		model.addAttribute("to",to);
		model.addAttribute("to",to);
		model.addAttribute("subject",subject);
		model.addAttribute("message",msg);
		return "scriptEmail";
	}

}
