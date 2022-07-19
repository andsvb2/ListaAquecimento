package programas;

import java.util.ArrayList;

import enums.TipoDePrograma;

import java.time.DayOfWeek;

import midia.Canal;

public class ProgramaDeTv extends Programa {
	
	private Canal canal;
	private ArrayList <DayOfWeek> diasExibicao;
	
	public ProgramaDeTv(String n, TipoDePrograma t, ArrayList<DayOfWeek> dias, Canal c) {
		super(n, t);
		diasExibicao = dias;
		canal = c;
	}
	
	public ArrayList<DayOfWeek> getDiasExibicao(){
		return diasExibicao;
	}
	
	public void setDiasExibicao(ArrayList<DayOfWeek> dias) {
		diasExibicao = dias;
	}
	
	public Canal getCanal() {
		return canal;
	}
	
	public void setCanal(Canal novoCanal) {
		canal = novoCanal;
	}
}
