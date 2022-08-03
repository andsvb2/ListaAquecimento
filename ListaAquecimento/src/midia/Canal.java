package midia;

import enums.TipoCanal;

public abstract class Canal {

	protected String nomeCanal;
	protected TipoCanal tipoCanal;
	
	
	public Canal(String n, TipoCanal t) {
		nomeCanal = n;
		tipoCanal = t;
	}
	
	public Canal() {
	}
	
	public String toString() {
		return nomeCanal;
	}
	
	public boolean equals(Canal c) {
		return nomeCanal.equals(c.getNomeCanal());
	}

	public String getNomeCanal() {
		return nomeCanal;
	}

	public TipoCanal getTipoCanal() {
		return tipoCanal;
	}
	
	public abstract Object numeroOuLink();
	
	
}
