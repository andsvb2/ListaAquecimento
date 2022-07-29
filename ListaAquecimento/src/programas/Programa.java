package programas;

import java.time.LocalTime;

import enums.StatusPrograma;
import midia.Canal;

public abstract class Programa {

	private long id;
	private String nome;
	private Canal canal;
	private LocalTime horario;
	private StatusPrograma status;
	
	public Programa(String n, Canal c, LocalTime h, StatusPrograma s) {
		id = System.currentTimeMillis();
		nome = n;
		canal = c;
		horario = h;
		status = s;
	}
	
	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
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
	
	public LocalTime getHorario() {
		return horario;
	}
	
	public void setHorario(LocalTime novoHorario) {
		horario = novoHorario;
	}

	public StatusPrograma getStatus() {
		return status;
	}

	public void setStatus(StatusPrograma status) {
		this.status = status;
	}
	
}
