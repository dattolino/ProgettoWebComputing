package persistence.website.abstraction;

import java.util.ArrayList;

import model.siteweb.OrdineEffettivo;




public interface OrdineEffettivoDAO {

	
	public void createTable();
	public void aggiungiOrdineEffettivo(OrdineEffettivo e) ;
	public ArrayList<OrdineEffettivo> selectAllByRiferimento(String Riferimento, String stato);
	public void cambiaStato(String stato,OrdineEffettivo oe);
	public void cancellaOrdine(OrdineEffettivo oe) ;
	public int getOrarioFromDB(OrdineEffettivo o);
	public void updateOrario(OrdineEffettivo o, int orario);
	public int getOrarioInTransito(OrdineEffettivo oe);
}
