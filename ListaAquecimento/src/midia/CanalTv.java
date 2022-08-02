package midia;

import enums.TipoCanal;

public class CanalTv extends Canal{

	private int numero;
	
	
	public CanalTv(String nome, TipoCanal t, int num) {
		super(nome, t);
		numero = num;
	}
	
	public CanalTv() {
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
