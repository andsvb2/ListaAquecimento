package programas;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import enums.StatusPrograma;
import enums.TipoPrograma;
import midia.Canal;

public abstract class Programa {

	private long id;
	private String nome;
	private Canal canal;
	private LocalTime horario;
	private StatusPrograma status;
	private ArrayList<DayOfWeek> diasExibicao;
	private Date dataRetorno;
	private TipoPrograma tipo;
	
	public Programa(String n, Canal c, LocalTime h, StatusPrograma s, ArrayList<DayOfWeek> d, TipoPrograma t) {
		id = System.currentTimeMillis();
		nome = n;
		canal = c;
		horario = h;
		status = s;
		diasExibicao = d;
		tipo = t;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public StatusPrograma getStatus() {
		return status;
	}

	public void setStatus(StatusPrograma status) {
		this.status = status;
	}

	public ArrayList<DayOfWeek> getDiasExibicao() {
		return diasExibicao;
	}

	public void setDiasExibicao(ArrayList<DayOfWeek> diasExibicao) {
		this.diasExibicao = diasExibicao;
	}

	public Date getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	public long getId() {
		return id;
	}

	public TipoPrograma getTipo() {
		return tipo;
	}
	
	

}
