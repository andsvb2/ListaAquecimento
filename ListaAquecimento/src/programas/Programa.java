package programas;

import enums.TipoDePrograma;

public abstract class Programa {

	private long id;
	private String nome;
	private TipoDePrograma tipo;
	
	public Programa(String n, TipoDePrograma t) {
		id = System.currentTimeMillis();
		nome = n;
		tipo = t;
	}
	
	public String toString() {
		return nome;
	}
	
	public long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String novoNome) {
		nome = novoNome;
	}
	
	public TipoDePrograma getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoDePrograma novoTipo) {
		tipo = novoTipo;
	}
	
}
