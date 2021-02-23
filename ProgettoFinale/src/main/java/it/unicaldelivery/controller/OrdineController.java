package it.unicaldelivery.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itextpdf.text.log.SysoLogger;

import model.siteweb.RichiestaOrdine;
import persistence.configuration.DAOFactory;
import persistence.website.abstraction.PartenzaDAO;
import persistence.website.abstraction.RichiestaOrdineDAO;
import persistence.website.implementation.RichiestaOrdineDAOImplementation;

@Controller
public class OrdineController {
	
	private RichiestaOrdine d;

	@GetMapping("/richiediconsegna")
	public String richiediOrdine(Model model) {
		DAOFactory daoFactory = DAOFactory.getDAOFactory();
		PartenzaDAO dao = daoFactory.getPartenzaDAO();
		ArrayList<String> destinazioni = dao.tutteLeDestinazioni();
		List<String> uniqueList = new ArrayList<String>(new HashSet<String>(destinazioni)); //Sto togliendo i doppioni
		model.addAttribute("listaPartenze", uniqueList);
		return "richiediconsegna";
	}
	
	@PostMapping("/metodipagamento")
	public String metodiPagamento(@RequestParam("nome") String nome,@RequestParam("email") String email, @RequestParam("da") String da, @RequestParam("a") String a, @RequestParam("via") String via, @RequestParam("ruolo")String modalita, @RequestParam("richiesta") String richiesta) {
		d = new RichiestaOrdine(nome,email,da,a,via,modalita,richiesta);
		return "metodipagamento";
	}
	@GetMapping("/pagamentoonline")
	public String pagamentoOnline(Model model) {
		model.addAttribute("prezzoDaPagare",20);
		return "pagamentoonline";
	}
	
	@PostMapping("/riepilogoOnline") 
	public String riepilogoOnline(@RequestParam("numeroCarta") String numero, @RequestParam("CVV") String cvv, @RequestParam("scadenzaCarta") String scadenza,Model model) {
		
		model.addAttribute("nome",d.getName().getValue());
		model.addAttribute("email",d.getEmail().getValue());
		model.addAttribute("da",d.getDa().getValue());
		model.addAttribute("a",d.getA().getValue());
		model.addAttribute("via",d.getVia().getValue());
		model.addAttribute("modalita",d.getModalita().getValue());
		model.addAttribute("richiesta",d.getRichiesta().getValue());
		
		model.addAttribute("numeroCarta",numero);
		model.addAttribute("CVV",cvv);
		model.addAttribute("scadenzaCarta",scadenza);
		
		return "riepilogoordine";
	}
	
	@GetMapping("/conferma")
	public String confermaOnline() {
		DAOFactory factory = DAOFactory.getDAOFactory();
		RichiestaOrdineDAO dao = factory.getRichiestaOrdineDAO();
		
		
		dao.insertRichiestaOrdine(d);
		return "homepageCliente";
	}
	
	@GetMapping("/riepilogoContrassegno")
	public String riepilogoContrassegno(Model model)
	{
		model.addAttribute("nome",d.getName().getValue());
		model.addAttribute("email",d.getEmail().getValue());
		model.addAttribute("da",d.getDa().getValue());
		model.addAttribute("a",d.getA().getValue());
		model.addAttribute("via",d.getVia().getValue());
		model.addAttribute("modalita",d.getModalita().getValue());
		model.addAttribute("richiesta",d.getRichiesta().getValue());
		
		model.addAttribute("numeroCarta","CONTRASSEGNO");
		model.addAttribute("CVV","CONTRASSEGNO");
		model.addAttribute("scadenzaCarta","CONTRASSEGNO");
		
		return "riepilogoordine";
	}

	//QUA
	ArrayList<RichiestaOrdine> listaRichieste = new ArrayList<RichiestaOrdine>();

	@GetMapping("RichiesteOrdine")
	public String RichiesteOrdini(Model model) {
		listaRichieste.clear();
		DAOFactory factory = DAOFactory.getDAOFactory();
		RichiestaOrdineDAOImplementation dao =  (RichiestaOrdineDAOImplementation) factory.getRichiestaOrdineDAO();
		listaRichieste = dao.selectAll();
		model.addAttribute("listaRichieste", listaRichieste);
		return "RichiesteOrdine";
	}

	
}
