package model.siteweb;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Partenza {

	private StringProperty partenza,destinazione,prezzo,durata,modalita;

	
	public Partenza(String partenza, String destinazione,String prezzo, String durata,String modalita) {
		this.partenza = new SimpleStringProperty(partenza);
		this.destinazione = new SimpleStringProperty(destinazione);
		this.prezzo = new SimpleStringProperty(prezzo);
		this.durata = new SimpleStringProperty(durata);
		this.modalita = new SimpleStringProperty(modalita);
	}
	
	public StringProperty getPartenza() {
		return partenza;
	}
	
	public StringProperty getDestinazione() {
		return destinazione;
	}
	
	public StringProperty getDurata() {
		return durata;
	}
	
	public StringProperty getPrezzo() {
		return prezzo;
	}
	
	public StringProperty getModalita() {
		return modalita;
	}
}
