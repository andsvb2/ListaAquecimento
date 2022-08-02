package midia;

import enums.TipoCanal;

public class CanalBroadcast extends Canal{

	private String link;
	
	
	public CanalBroadcast(String nome, TipoCanal t, String l) {
		super(nome, t);
		link = l;
	}
	
	public CanalBroadcast() {
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
}
