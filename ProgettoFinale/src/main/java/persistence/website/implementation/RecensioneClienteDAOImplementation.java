package persistence.website.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.siteweb.RecensioneCliente;
import persistence.configuration.PostgresDAOFactory;
import persistence.website.abstraction.RecensioneClienteDAO;

public class RecensioneClienteDAOImplementation implements RecensioneClienteDAO {

	private static Connection con=null;
	
	public RecensioneClienteDAOImplementation() {
		con=PostgresDAOFactory.getConnection();
	}
	
	@Override
	public void createTable() {
		try {
			String query = "create table if not exists recensionicliente(motivazione varchar(255),descrizione varchar(255))";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("errore");
		}
		
	}

	@Override
	public void insertRecensione(RecensioneCliente c) {
		try {
			String query = "insert into recensionicliente(motivazione,descrizione) values(?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, c.getMotivazione());
			pstmt.setString(2, c.getDescrizione());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public ArrayList<RecensioneCliente> selectAllRecensioni() {
		ArrayList<RecensioneCliente> listaRecensioni = new ArrayList<>();
		try {
			String query = "select * from recensionicliente";
			Statement stmt = con.createStatement();
			ResultSet st = stmt.executeQuery(query);
			while(st.next()) {
				listaRecensioni.add(new RecensioneCliente(st.getString("motivazione"),st.getString("descrizione")));
			}
			return listaRecensioni;
		} catch (Exception e) {
			System.out.println("errore");
		}
		return null;
	}

	
}
