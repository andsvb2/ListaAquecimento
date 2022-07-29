package metodos;
import java.util.ArrayList;

import midia.Canal;
import programas.Programa;

public final class CentralDeInformacoes {
	
	private ArrayList<Programa> todosOsProgramas = new ArrayList<>();
	private ArrayList<Canal> listaCanais = new ArrayList<>();
	
	public boolean adicionarPrograma(Programa programa) {
		if (recuperarProgramaPeloId(programa) == null) {
			todosOsProgramas.add(programa);
			return true;
		}
		return false;
	}

	public ArrayList<Programa> getTodosOsProgramas() {
		return todosOsProgramas;
	}

	public void setTodosOsProgramas(ArrayList<Programa> todosOsProgramas) {
		this.todosOsProgramas = todosOsProgramas;
	}

	public Programa recuperarProgramaPeloId(Programa id) {
		for (Programa p : todosOsProgramas) {
			if (p.getId() == id.getId()) {
				return p;
			}
		}
		return null;
	}

	public ArrayList<Canal> getListaCanais() {
		return listaCanais;
	}

	public boolean adicionarCanal(Canal c) {
		if (recuperarCanalPeloNome(c.getNomeCanal()) == null) {
			listaCanais.add(c);
			return true;
		}
		return false;
	}

	public Canal recuperarCanalPeloNome(String nomeTeste) {
			for (Canal c : listaCanais) {
				if (nomeTeste.equals(c.getNomeCanal()))
					return c;
			}
		return null;
	}
}
