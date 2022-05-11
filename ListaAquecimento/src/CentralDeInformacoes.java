
import java.util.ArrayList;

public class CentralDeInformacoes {

	private ArrayList <ProgramaDeTv> todosOsProgramas;
	private ArrayList<Canal> listaCanais;

	public boolean adicionarProgramaDeTv(ProgramaDeTv programa) {
		if(recuperarProgramaDeTvPeloId(programa) == null) {
			todosOsProgramas.add(programa);
			return true;
		}
		return false;
	}

	public ArrayList <ProgramaDeTv> getTodosOsProgramas() {
		return todosOsProgramas;
	}

	public void setTodosOsProgramas(ArrayList<ProgramaDeTv> todosOsProgramas) {
		this.todosOsProgramas = todosOsProgramas;
	}

	public ProgramaDeTv recuperarProgramaDeTvPeloId(ProgramaDeTv id){
		for(ProgramaDeTv p : todosOsProgramas) {
			if(p.getId() == id.getId()) {
				return p;
			}
		}
		return null;
	}
}
