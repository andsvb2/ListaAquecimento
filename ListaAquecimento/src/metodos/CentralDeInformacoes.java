package metodos;
import java.util.ArrayList;

import midia.Canal;
import programas.ProgramaDeTv;

public final class CentralDeInformacoes {
	
	private ArrayList<ProgramaDeTv> todosOsProgramas = new ArrayList<>();
	private ArrayList<Canal> listaCanais = new ArrayList<>();
	
	public boolean adicionarProgramaDeTv(ProgramaDeTv programa) {
		if (recuperarProgramaDeTvPeloId(programa) == null) {
			todosOsProgramas.add(programa);
			return true;
		}
		return false;
	}

	public ArrayList<ProgramaDeTv> getTodosOsProgramas() {
		return todosOsProgramas;
	}

	public void setTodosOsProgramas(ArrayList<ProgramaDeTv> todosOsProgramas) {
		this.todosOsProgramas = todosOsProgramas;
	}

	public ProgramaDeTv recuperarProgramaDeTvPeloId(ProgramaDeTv id) {
		for (ProgramaDeTv p : todosOsProgramas) {
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
