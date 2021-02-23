package persistence.website.abstraction;

import java.util.ArrayList;

import model.siteweb.RichiestaAssunzione;

public interface RichiestaAssunzioneDAO {
	
	public void createTable();

	public ArrayList<RichiestaAssunzione> selectAll();
	
	public ArrayList<RichiestaAssunzione> selectAllByRole(String role);
	
	public RichiestaAssunzione selectRichiestaAssunzioneByCF(String cf);
	
	public void deleteRichiestaAssunzione(String cf);
	
	public void insertRichiestaAssunzione(RichiestaAssunzione e);
}
