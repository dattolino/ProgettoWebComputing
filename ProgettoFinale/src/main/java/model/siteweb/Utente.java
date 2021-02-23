package model.siteweb;

public class Utente {

	private String email;
	private String password;
	private String permessiAccesso;
	
	public Utente(String email, String password, String permessiAccesso) {
		this.email = email;
		this.password = password;
		this.permessiAccesso = permessiAccesso;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getPermessiAccesso() {
		return permessiAccesso;
	}
	
}
