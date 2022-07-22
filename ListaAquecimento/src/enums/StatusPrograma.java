package enums;

public enum StatusPrograma {
	EXIBINDO("Em exibição"),
	HIATO("Hiato"),
	FINALIZADO("Finalizado"),
	CANCELADO("Cancelado");
	
	private String status;
	
	private StatusPrograma(String novoStatus) {
		status = novoStatus;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	@Override
	public String toString() {
		return this.status;
	}

}
