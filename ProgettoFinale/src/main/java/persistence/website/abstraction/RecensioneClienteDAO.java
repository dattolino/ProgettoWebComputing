package persistence.website.abstraction;

import java.util.ArrayList;

import model.siteweb.RecensioneCliente;

public interface RecensioneClienteDAO {

	public void createTable();
	
	public void insertRecensione(RecensioneCliente c);
	
	public ArrayList<RecensioneCliente> selectAllRecensioni();
}
