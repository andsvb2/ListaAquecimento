package programas;

public enum TipoDePrograma {
	
	SR("Série regular"),
	RS("Reality show"),
	PC("Programa contínuo");
	
	private static final TipoDePrograma[] ENUMS = TipoDePrograma.values();
	private final String tipo;
	
	TipoDePrograma(String novoTipo){
		tipo = novoTipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public static TipoDePrograma of(int tipo) {
        return ENUMS[tipo - 1];
	}
}
