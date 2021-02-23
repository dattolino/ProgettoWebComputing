package persistence.website.abstraction;

import java.util.ArrayList;

import model.abstraction.Persona;
import model.siteweb.Dipendente;

public interface DipendenteDAO {

	public void createTable();
	
	public ArrayList<Dipendente> selectAll();
	
	public ArrayList<Dipendente> selectAllByRole(String role);

	public boolean insertDipendente(Persona e);
	
	public void deleteDipendente(Dipendente e);
	
	public void deleteDipendenteByCF(String cf);
	
	public Dipendente getDipendenteLoggato();
	
	public String getEmailByCF(String cf);
	

}
