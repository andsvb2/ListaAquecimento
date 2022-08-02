package enums;

public enum TipoCanal {
	ABERTO("Canal aberto de televisão"),
	BROADCASTING("Boadcasting aberto na Internet"),
	PACOTE("Pacote de assinatura"),
	AIT("Assinatura individual de televisão"),
	AIB("Assinatura individual de broadcasting");
	
	private final String tipo;
	
	TipoCanal(String novoTipo) {
		tipo = novoTipo;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	@Override
	public String toString() {
		return this.tipo;
	}
	
}