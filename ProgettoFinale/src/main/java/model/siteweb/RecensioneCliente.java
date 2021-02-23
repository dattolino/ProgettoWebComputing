package model.siteweb;

public class RecensioneCliente {

	private String motivazione=null;
	private String descrizione=null;
	
	private String pathImg = null;
	
	public RecensioneCliente(String motivazione, String descrizione) {
		this.motivazione=motivazione;
		this.descrizione=descrizione;
		
		if(motivazione.equals("Insoddisfatto, servizio pessimo.")||motivazione.equals("Servizio da migliorare, si può fare di meglio."))
			pathImg = "resources/img/bad.png";
		else pathImg= "resources/img/star.png";
		
	}
	
	public String getImmagine() {
		return pathImg;
	}
	
	public String getMotivazione() {
		return motivazione;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	
}
