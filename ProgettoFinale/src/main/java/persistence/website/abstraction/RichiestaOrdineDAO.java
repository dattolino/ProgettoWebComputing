package persistence.website.abstraction;

import java.util.ArrayList;

import model.siteweb.RichiestaOrdine;

public interface RichiestaOrdineDAO {
	
	public void createTable();
	
	public ArrayList<RichiestaOrdine> selectAll();
	
	public ArrayList<RichiestaOrdine> selectByType(String type);
	
	public void insertRichiestaOrdine(RichiestaOrdine o);
	
	public void deleteRichiestaOrdine(RichiestaOrdine o);

}
