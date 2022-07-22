package midia;

import enums.TipoCanal;

public class Canal {

	private String nomeCanal;
	private TipoCanal tipoCanal;
//	private String tipoCanal;
	
	
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
	
	
}
