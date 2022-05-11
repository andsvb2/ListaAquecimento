

import java.util.ArrayList;
import java.util.Calendar;

public class ProgramaDeTv {
	
	private long id;
	private String nome;
	private TipoDePrograma tipo;
	private ArrayList <String> diasDaSemana;
	
	Calendar c = Calendar.getInstance();
	
	public ProgramaDeTv(String n, TipoDePrograma t) {
		id = System.currentTimeMillis();
		this.nome = n;
		this.tipo = t;
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
	
	public ArrayList <String> getDiasDaSemana(){
		return diasDaSemana;
	}
	
	public void setDiasDaSemana(ArrayList<String>diasDaSemana) {
		this.diasDaSemana = diasDaSemana;
	}
	
	
}
