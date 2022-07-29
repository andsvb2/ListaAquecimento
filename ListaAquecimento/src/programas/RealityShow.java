package programas;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

import enums.EstiloSerieRegular;
import enums.StatusPrograma;
import midia.Canal;

public class RealityShow extends Programa {
	
	private int qtdTemporadas;
	private ArrayList<String> apresentadores;
	
	public RealityShow(String n, Canal c, LocalTime h, StatusPrograma s, 
			ArrayList<DayOfWeek> d, int t, ArrayList<String> a) {
		super(n, c, h, s, d);
		qtdTemporadas = t;
		apresentadores = a;
	}

	public int getQtdTemporadas() {
		return qtdTemporadas;
	}

	public void setQtdTemporadas(int qtdTemporadas) {
		this.qtdTemporadas = qtdTemporadas;
	}

	public ArrayList<String> getApresentadores() {
		return apresentadores;
	}

	public void setApresentadores(ArrayList<String> apresentadores) {
		this.apresentadores = apresentadores;
	}
	
}
