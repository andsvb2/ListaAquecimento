package enums;

public enum TipoDePrograma {
	
	SR("Série regular"),
	RS("Reality show"),
	PC("Programa contínuo");
	
	private final String tipo;
	
	TipoDePrograma(String novoTipo){
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
