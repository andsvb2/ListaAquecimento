package executaveis;

import metodos.CentralDeInformacoes;
import metodos.Persistencia;

public class MainTestePersistencia {

	public static void main(String[] args) {
		
		Persistencia pe = new Persistencia();
		CentralDeInformacoes central = pe.recuperarCentral("central");
		
		
		

	}

}
