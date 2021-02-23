package model.abstraction;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Ordine {
	
	//String name,email,da,a,via,modalit�,richiesta;
	
	/* OrdineEffetivo -> Nome , email, da, a , via , modalit� , richiesta , guadagno, tempo di consegna 
	 * 
	 * guadagno, tempodiconsegna*/
	private StringProperty name,email,da,a,via,modalita,richiesta;
	
	public Ordine(String name,String email,String da,String a,String via,String modalita,String richiesta) {
		this.name = new SimpleStringProperty(name);
		this.email = new SimpleStringProperty(email);
		this.da = new SimpleStringProperty(da);
		this.a = new SimpleStringProperty(a);
		this.via = new SimpleStringProperty(via);
		this.modalita = new SimpleStringProperty(modalita);
		this.richiesta = new SimpleStringProperty(richiesta);
	}
	
	public StringProperty getName() {
		return name;
	}
	
	public StringProperty getEmail() {
		return email;
	}
	
	public StringProperty getDa() {
		return da;
	}
	
	public StringProperty getA() {
		return a;
	}
	
	public StringProperty getVia() {
		return via;
	}
	
	public StringProperty getModalita() {
		return modalita;
	}
	
	public StringProperty getRichiesta() {
		return richiesta;
	}
	
	/*@Override
	public String toString() {
		return "RICHIESTA: " + richiesta + System.lineSeparator() + "MODALITA': " + modalit�;
	}*/

}
