package email;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;




import javafx.collections.ObservableList;
import model.abstraction.Persona;
import model.siteweb.OrdineEffettivo;
import model.siteweb.Portafoglio;

public class Utility {
	
	public static String generatePdf(String ogg, String nomeFile, ObservableList<Persona> persone) throws DocumentException, FileNotFoundException {
    	
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(nomeFile));	
		document.open();
		
		try {
			Image g = Image.getInstance("src/main/java/resources/logounicaldelivery.PNG");
			g.setWidthPercentage(70);
			document.add(g);
		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		document.add(new Paragraph("LISTA PERSONE : "));
		int cont = 1;
		for(Persona req : persone) {
			document.add(new Paragraph(ogg + " NUMERO " + cont));
			document.add(new Paragraph("Nome : " + req.getName().getValue()));
			document.add(new Paragraph("Cognome : " + req.getSurname().getValue()));
			document.add(new Paragraph("Email : " + req.getEmail().getValue()));
			document.add(new Paragraph("Ruolo : " + req.getRole().getValue()));
			document.add(new Paragraph(""));
			document.add(new Paragraph(""));
			cont++;
			
		}
        
        document.close();
        
        return nomeFile;
    }
	
	public static String generatePdfOrdini(ArrayList<OrdineEffettivo> ordini) throws DocumentException, FileNotFoundException  {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("ListaOrdini-" + LocalDate.now().toString() + ".pdf"));	
		document.open();
//		try {
//			Image g = Image.getInstance("src/main/java/resources/static/img/logounicaldelivery.PNG");
//			g.setWidthPercentage(70);
//			document.add(g);
//		} catch (BadElementException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		document.add(new Paragraph("LISTA ORDINI : "));
		int cont = 1;
		for(OrdineEffettivo req : ordini) {
			document.add(new Paragraph("ORDINE NUMERO " + cont));
			document.add(new Paragraph("Nome : " + req.getName().getValue()));
			document.add(new Paragraph("Email : " + req.getEmail().getValue()));
			document.add(new Paragraph("Da : " + req.getDa().getValue()));
			document.add(new Paragraph("A : " + req.getA().getValue()));
			document.add(new Paragraph("Via : " + req.getVia().getValue()));
			document.add(new Paragraph("Modalità : " + req.getModalita().getValue()));
			document.add(new Paragraph("Richiesta : " + req.getRichiesta().getValue()));
			document.add(new Paragraph("Tempo Di Consegna: " + req.getDurata().getValue()));
			document.add(new Paragraph("Guadagno : " + req.getPrezzo().getValue()));
			document.add(new Paragraph(""));
			document.add(new Paragraph(""));
			cont++;
		}
        
        document.close();
        
        return "ListaOrdini-" + LocalDate.now().toString() + ".pdf";
		
				
	}
	
	
	public static String generatePdfPortafoglio(Portafoglio ew,String nomeFile) throws FileNotFoundException, DocumentException {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(nomeFile));	
		document.open();
		
		try {
			Image g = Image.getInstance("src/main/java/resources/logounicaldelivery.PNG");
			g.setWidthPercentage(70);
			document.add(g);
		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.add(new Paragraph("Portafoglio:"));
		document.add(new Paragraph("Lavori effettuati: "+ ew.getLavoriEffettuati().getValue()));
		document.add(new Paragraph("Lavori rifiutati: "+ ew.getLavoriRifiutati().getValue()));
		document.add(new Paragraph("Bonus: "+ ew.getBonus().getValue()));
		document.add(new Paragraph("Ammonizioni: "+ ew.getAmmonizioni().getValue()));
		document.add(new Paragraph("Stipendio: "+ ew.getStipendio().getValue()));
		
		document.close();
		
		return nomeFile;
		
	}
	
//	public static String generateDashBoard(String nomeFile,UnicalDelivery ud) throws FileNotFoundException, DocumentException {
//		
//		Document document = new Document();
//		PdfWriter.getInstance(document, new FileOutputStream(nomeFile));	
//		document.open();
//		try {
//			Image g = Image.getInstance("src/main/java/resources/logounicaldelivery.PNG");
//			g.setWidthPercentage(70);
//			document.add(g);
//		} catch (BadElementException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		document.add(new Paragraph("DashBoard:"));
//		document.add(new Paragraph("Dipendenti Totali: "+ ud.getDipendentiTotali().toString()));
//		document.add(new Paragraph("Dipendenti Consegna Terrena: "+ ud.getDipendentiConsegnaTerrena().toString()));
//		document.add(new Paragraph("Dipendenti Consegna Aerea: "+ ud.getDipendentiConsegnaAerea().toString()));
//		document.add(new Paragraph("Richieste di Assunzione: "+ ud.getRichiesteAssunzione().toString()));
//		document.add(new Paragraph("Richieste d'ordine: "+ ud.getRichiesteOrdine().toString()));
//		document.add(new Paragraph("Ordini in Attesa: "+ ud.getOrdiniInAttesa().toString()));
//		document.add(new Paragraph("Ordini in transito: "+ ud.getOrdiniInTransito().toString()));
//		document.add(new Paragraph("Ordini consegnati: "+ ud.getOrdiniConsegnati().toString()));
//		document.close();
//		return nomeFile;
//	}
	
	public static boolean checkMail(String e) {
	    return Pattern.matches("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}", e);
	}
	
}
	

