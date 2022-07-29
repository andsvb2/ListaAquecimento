package executaveis;

import java.time.DayOfWeek;
import java.util.ArrayList;

import enums.TipoDePrograma;
import metodos.CentralDeInformacoes;
import metodos.Persistencia;
import midia.Canal;
import programas.SerieRegular;

public class MainTestePersistencia {

	public static void main(String[] args) {
		
		Persistencia pe = Persistencia.getInstancia();
		CentralDeInformacoes central = pe.recuperarCentral();
		
		Canal c = new Canal("SBT", "Canal aberto");
		
		ArrayList<DayOfWeek> diasExibicao = new ArrayList<>();
		
		diasExibicao.add(DayOfWeek.MONDAY);
		diasExibicao.add(DayOfWeek.TUESDAY);
		diasExibicao.add(DayOfWeek.WEDNESDAY);
		diasExibicao.add(DayOfWeek.THURSDAY);
		diasExibicao.add(DayOfWeek.FRIDAY);
		diasExibicao.add(DayOfWeek.SATURDAY);

		SerieRegular pdtv = new SerieRegular("Jornal da Noite", TipoDePrograma.PC, diasExibicao, c);
		
		
		central.adicionarCanal(c);
		central.adicionarProgramaDeTv(pdtv);
		
		pe.salvarCentral(central);
		
	}

}
