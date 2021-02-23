package model.siteweb;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Feedback {
	private StringProperty riferimento;
	private StringProperty motivazione;
	private StringProperty data;
	
	
	public Feedback(String riferimento,String motivazione) {
		this.riferimento = new SimpleStringProperty(riferimento);
		this.motivazione = new SimpleStringProperty(motivazione);
		this.data = new SimpleStringProperty(LocalDate.now().toString());
	}
	
	public StringProperty getMotivazione() {
		return motivazione;
	}
	
	public StringProperty getRiferimento() {
		return riferimento;
	}
	
	public StringProperty getData() {
		return data;
	}
	
	
	
}
