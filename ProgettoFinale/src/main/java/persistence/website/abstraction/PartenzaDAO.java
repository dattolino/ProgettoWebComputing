package persistence.website.abstraction;

import java.util.ArrayList;

import model.siteweb.Partenza;

public interface PartenzaDAO {

	public void createTable();
	
	public void insertPartenza(Partenza daAggiungere);
	
	public ArrayList<String> tutteLeDestinazioni();

	public int getGuadagno(String destinazione, String modalita);
	
	public int getDurata(String destinazione, String modalita);
	
	public Partenza getTappa(String destinazione);
	
	
}
