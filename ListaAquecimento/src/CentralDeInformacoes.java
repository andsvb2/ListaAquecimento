

import java.util.ArrayList;

public class CentralDeInformacoes {

	private ArrayList <ProgramaDeTv> todosOsProgramas;

	public boolean adicionarProgramaDeTv(ProgramaDeTv programa) {
		if(recuperarProgramaDeTvPeloId() {
			return false;
		}
		todosOsProgramas.add(programa);
		return true;
	}

	public ArrayList <ProgramaDeTv> getTodosOsProgramas() {
		return todosOsProgramas;
	}

	public void setTodosOsProgramas(ArrayList<ProgramaDeTv> todosOsProgramas) {
		this.todosOsProgramas = todosOsProgramas;
	}

	public ProgramaDeTv recuperarProgramaDeTvPeloId(ProgramaDeTv id){
		ProgramaDeTv programa = new ProgramaDeTv(null, null);
		for(ProgramaDeTv p : todosOsProgramas) {
			if(p.getId() == programa.getId()) {
				return p;
			}
		}
		return null;
	}
}
