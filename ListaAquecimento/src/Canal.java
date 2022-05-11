
public class Canal {

	private String nomeCanal;
	private String tipoCanal;
	
	
	public Canal(String n, String t) {
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

	public String getTipoCanal() {
		return tipoCanal;
	}
	
	
}
