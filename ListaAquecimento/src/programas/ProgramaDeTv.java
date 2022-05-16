package programas;

import java.util.ArrayList;
import java.util.Calendar;

import midia.Canal;

public class ProgramaDeTv extends Programa {
	
	private ArrayList <String> diasDaSemana;
	private Canal canal;
	
	Calendar c = Calendar.getInstance();
	
	public ProgramaDeTv(String n, TipoDePrograma t, Canal c) {
		super(n, t);
		canal = c;
	}
	
	public ArrayList <String> getDiasDaSemana(){
		return diasDaSemana;
	}
	
	public void setDiasDaSemana(ArrayList<String>diasDaSemana) {
		this.diasDaSemana = diasDaSemana;
	}
	
	public Canal getCanal() {
		return canal;
	}
	
	public void setCanal(Canal novoCanal) {
		canal = novoCanal;
	}
}
