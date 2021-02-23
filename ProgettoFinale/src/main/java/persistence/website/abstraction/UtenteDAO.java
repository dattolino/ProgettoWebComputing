package persistence.website.abstraction;

import model.siteweb.Utente;

public interface UtenteDAO {
	
	public void createTable();

	public void insertUtente(Utente u);
	
	public void insertUtenteProfessori(Utente u);
	
	public Utente selectUtente(String email);
	
	public Utente selectUtente(String email, String password);
	
	public void cambiaPassword(String email, String password, String newPassword);
	
	public void cambiaPasswordDaRecupero(String email,String newPassword);
	
	public void cambiaEmail(String email, String password, String newEmail);
	
	public String getPasswordByEmail(String email);
	
	public void deleteUtente(String email);
	
	public boolean esisteQuestaMail(String email);
	
	public String selectEmailCapo();
}
