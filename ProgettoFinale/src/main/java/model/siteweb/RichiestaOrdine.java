package model.siteweb;

import model.abstraction.Ordine;

public class RichiestaOrdine extends Ordine{

	public RichiestaOrdine(String name, String email, String da, String a, String via, String modalita,
			String richiesta) {
		super(name, email, da, a, via, modalita, richiesta);
	
	}
	
	public OrdineEffettivo trasformaInOrdineEffettivo(String riferimento) {
		return new OrdineEffettivo(getName().getValue(),getEmail().getValue(), getDa().getValue(),getA().getValue(), getVia().getValue(), getModalita().getValue(), getRichiesta().getValue(), riferimento,"in attesa",0);
	}

}
