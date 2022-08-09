package midia;

import java.util.ArrayList;

import enums.TipoCanal;
import programas.Programa;

public abstract class Canal {

	protected String nomeCanal;
	protected TipoCanal tipoCanal;
	protected ArrayList<Programa> programasNoCanal;
	
	
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
