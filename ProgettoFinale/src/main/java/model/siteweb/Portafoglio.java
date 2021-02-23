package model.siteweb;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Portafoglio {
	
	private StringProperty cf, ammonizioni, bonus, stipendio, lavoriEffettuati, lavoriRifiutati;

	public Portafoglio(String cf, String ammonizioni, String bonus,
			String stipendio, String lavoriEffettuati, String lavoriRifiutati) {
		super();
		this.cf = new SimpleStringProperty(cf);
		this.ammonizioni = new SimpleStringProperty(ammonizioni);
		this.bonus = new SimpleStringProperty(bonus);
		this.stipendio = new SimpleStringProperty(stipendio);
		this.lavoriEffettuati = new SimpleStringProperty(lavoriEffettuati);
		this.lavoriRifiutati = new SimpleStringProperty(lavoriRifiutati);
	}

	public StringProperty getLavoriEffettuati() {
		return lavoriEffettuati;
	}

	public void setLavoriEffettuati(StringProperty lavoriEffettuati) {
		this.lavoriEffettuati = lavoriEffettuati;
	}

	public StringProperty getStipendio() {
		return stipendio;
	}

	public void setStipendio(StringProperty stipendio) {
		this.stipendio = stipendio;
	}

	public StringProperty getCf() {
		return cf;
	}

	public void setCf(StringProperty cf) {
		this.cf = cf;
	}

	public StringProperty getAmmonizioni() {
		return ammonizioni;
	}

	public void setAmmonizioni(StringProperty ammonizioni) {
		this.ammonizioni = ammonizioni;
	}

	public StringProperty getLavoriRifiutati() {
		return lavoriRifiutati;
	}

	public void setLavoriRifiutati(StringProperty lavoriRifiutati) {
		this.lavoriRifiutati = lavoriRifiutati;
	}

	public StringProperty getBonus() {
		return bonus;
	}

	public void setBonus(StringProperty bonus) {
		this.bonus = bonus;
	}

}
