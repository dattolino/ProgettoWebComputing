package model.siteweb;

import javafx.beans.property.SimpleStringProperty;
import model.abstraction.Persona;

public class Dipendente extends Persona {

	private SimpleStringProperty password;


	public Dipendente(String cf, String name, String surname, String email, String role) {
		super(cf, name, surname, email, role);
		this.setPassword(new SimpleStringProperty("defaultpassword"));
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public SimpleStringProperty getPassword() {
		return password;
	}


	public void setPassword(SimpleStringProperty password) {
		this.password = password;
	}


	private Integer id;
	
}
