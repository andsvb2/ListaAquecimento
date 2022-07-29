package metodos;
import java.util.ArrayList;

import midia.Canal;
import programas.SerieRegular;

public final class CentralDeInformacoes {
	
	private ArrayList<SerieRegular> todosOsProgramas = new ArrayList<>();
	private ArrayList<Canal> listaCanais = new ArrayList<>();
	
	public boolean adicionarProgramaDeTv(SerieRegular programa) {
		if (recuperarProgramaDeTvPeloId(programa) == null) {
			todosOsProgramas.add(programa);
			return true;
		}
		return false;
	}

	public ArrayList<SerieRegular> getTodosOsProgramas() {
		return todosOsProgramas;
	}

	public void setTodosOsProgramas(ArrayList<SerieRegular> todosOsProgramas) {
		this.todosOsProgramas = todosOsProgramas;
	}

	public SerieRegular recuperarProgramaDeTvPeloId(SerieRegular id) {
		for (SerieRegular p : todosOsProgramas) {
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
