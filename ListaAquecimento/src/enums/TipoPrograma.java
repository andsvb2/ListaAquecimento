package enums;

public enum TipoPrograma {
	
	SR("Série regular"),
	RS("Reality show"),
	PC("Programa contínuo");
	
	private final String tipo;
	
	TipoPrograma(String novoTipo){
		tipo = novoTipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	@Override
	public String toString() {
		return this.tipo;
	}
	
}
