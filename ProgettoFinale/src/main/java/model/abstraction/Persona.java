package model.abstraction;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Persona {

private StringProperty cf,name,surname,email,role;
	
	public Persona(String cf, String name,String surname,String email,String role) {
		this.cf = new SimpleStringProperty(cf);
		this.name = new SimpleStringProperty(name);
		this.surname = new SimpleStringProperty(surname);
		this.email = new SimpleStringProperty(email);
		this.role = new SimpleStringProperty(role);
	}
	
	
	public StringProperty getEmail() {
		return email;
	}
	
	public StringProperty getName() {
		return name;
	}
	
	public StringProperty getRole() {
		return role;
	}
	
	public StringProperty getSurname() {
		return surname;
	}
	
	@Override
	public String toString() {
		return "NAME: " + name.getValue() + System.lineSeparator() + "COGNOME: " + surname.getValue() + System.lineSeparator() + "EMAIL: " + email.getValue() + System.lineSeparator() + "ROLE: " + role.getValue(); 
	}

	public StringProperty getCf() {
		return cf;
	}

	public void setCf(StringProperty cf) {
		this.cf = cf;
	}
}
