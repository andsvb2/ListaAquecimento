package programas;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

import enums.EstiloSerieRegular;
import enums.StatusPrograma;
import midia.Canal;

public class SerieRegular extends Programa {
	
	private DayOfWeek diaExibicao;
	private int qtdTemporadas;
	private EstiloSerieRegular estilo;
	private String genero;
	
	public SerieRegular(String n, Canal c, LocalTime h, StatusPrograma s, 
			DayOfWeek dia, int t, EstiloSerieRegular e, String g) {
		super(n, c, h, s);
		diaExibicao = dia;
		qtdTemporadas = t;
		estilo = e;
		genero = g;
	}

	public DayOfWeek getDiaExibicao() {
		return diaExibicao;
	}

	public void setDiaExibicao(DayOfWeek diaExibicao) {
		this.diaExibicao = diaExibicao;
	}

	public int getQtdTemporadas() {
		return qtdTemporadas;
	}

	public void setQtdTemporadas(int qtdTemporadas) {
		this.qtdTemporadas = qtdTemporadas;
	}

	public EstiloSerieRegular getEstilo() {
		return estilo;
	}

	public void setEstilo(EstiloSerieRegular estilo) {
		this.estilo = estilo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
}
