package model.siteweb;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.abstraction.Ordine;
import persistence.configuration.DAOFactory;
import persistence.website.abstraction.PartenzaDAO;


public class OrdineEffettivo extends Ordine {

	private int prezzo,durata, orario;
	StringProperty riferimento;/*Se � riempito con un solo CF, o con la stringa "TUTTI"*/
	StringProperty stato;
	StringProperty prezzoString, durataString, orarioString;
	
	public OrdineEffettivo(String name, String email, String da, String a, String via, String modalita,
			String richiesta,String riferimento,String stato ,int orario) {
		
		
		super(name, email, da, a, via, modalita, richiesta);
		
		
		DAOFactory daoFactory = DAOFactory.getDAOFactory();
		PartenzaDAO dao = daoFactory.getPartenzaDAO();
		
		
		this.prezzo = dao.getGuadagno(a,modalita);
		this.durata = dao.getDurata(a, modalita);
		
		Integer prezzoInteger = prezzo;
		Integer durataInteger = durata;
		this.orario = orario;
		
		this.prezzoString = new SimpleStringProperty(prezzoInteger.toString());
		this.durataString = new SimpleStringProperty(durataInteger.toString());
		this.riferimento = new SimpleStringProperty(riferimento);
		this.stato = new SimpleStringProperty(stato); /*In attesa di essere accettato*/
		
	}
	
	public int getOrario() {
		return this.orario;
	}
	
	public StringProperty getDurata() { /*TempoDIConsegna*/
		return durataString;
	}
	
	public StringProperty getStato() {
		return stato;
	}
	
	public StringProperty getRiferimento() {
		return riferimento;
	}
	
	public StringProperty getPrezzo() { /*Guadagno*/
		return prezzoString;
	}
	
	public RichiestaOrdine trasformaInRichiestaOrdine() {
		return new RichiestaOrdine(getName().getValue(), getEmail().getValue(), getDa().getValue(), getA().getValue(),
				getVia().getValue(), getModalita().getValue(), getRichiesta().getValue());
	}
	
	

}
