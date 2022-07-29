package enums;

public enum EstiloSerieRegular {
	LA("Live action"),
	ANIMADA("Animação");
	
	private final String nome;
	
	EstiloSerieRegular(String n){
		nome = n;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
}
