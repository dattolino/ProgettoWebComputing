package persistence.website.abstraction;

import java.util.ArrayList;

import model.abstraction.Persona;
import model.siteweb.Dipendente;
import model.siteweb.Portafoglio;

public interface PortafoglioDAO {
	
	public void createTable();
	
	public ArrayList<Portafoglio> selectAll();
	
	public Portafoglio selectPortafoglioDipendente(Dipendente e);
	
	public Portafoglio selectPortafoglioMigliore();
	
	public void insertPortafoglio(Persona e);
	
	public void deletePortafoglio(Dipendente e);
	
	public void deletePortafoglioByCf(String cf);
	
	public void attribuisciBonus(Dipendente e);
	
	public void attribuisciAmmonizione(Dipendente e);
	
	public void attribuisciLavoroEffettuato(Dipendente e);
	
	public void attribuisciLavoroRifiutato(Dipendente e);
	
	
	

}
