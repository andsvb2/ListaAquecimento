package programas;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

import enums.EstiloSerieRegular;
import enums.StatusPrograma;
import midia.Canal;

public class ProgramaContinuo extends Programa {
	
	private ArrayList<DayOfWeek> diasExibicao;
	private ArrayList<String> apresentadores;
	
	public ProgramaContinuo(String n, Canal c, LocalTime h, StatusPrograma s, 
			ArrayList<DayOfWeek> d, ArrayList<String> a) {
		super(n, c, h, s, d);
		apresentadores = a;
	}

	public ArrayList<DayOfWeek> getDiasExibicao() {
		return diasExibicao;
	}

	public void setDiasExibicao(ArrayList<DayOfWeek> diasExibicao) {
		this.diasExibicao = diasExibicao;
	}

	public ArrayList<String> getApresentadores() {
		return apresentadores;
	}

	public void setApresentadores(ArrayList<String> apresentadores) {
		this.apresentadores = apresentadores;
	}
	
}
