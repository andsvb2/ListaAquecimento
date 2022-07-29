package executaveis;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

import enums.EstiloSerieRegular;
import enums.StatusPrograma;
import enums.TipoCanal;
import metodos.CentralDeInformacoes;
import metodos.Persistencia;
import midia.Canal;
import programas.SerieRegular;

public class MainTestePersistencia {

	public static void main(String[] args) {
		
		Persistencia pe = Persistencia.getInstancia();
		CentralDeInformacoes central = pe.recuperarCentral();
		
		Canal c = new Canal("SBT", TipoCanal.ABERTO);
		
		ArrayList<DayOfWeek> diasExibicao = new ArrayList<>();
		
		diasExibicao.add(DayOfWeek.MONDAY);
		diasExibicao.add(DayOfWeek.TUESDAY);
		diasExibicao.add(DayOfWeek.WEDNESDAY);
		diasExibicao.add(DayOfWeek.THURSDAY);
		diasExibicao.add(DayOfWeek.FRIDAY);
		diasExibicao.add(DayOfWeek.SATURDAY);
		
		LocalTime hora = LocalTime.of(21, 15);
		StatusPrograma status = StatusPrograma.EXIBINDO;
		int temporadas = 5;
		EstiloSerieRegular estilo = EstiloSerieRegular.LA;
		String genero = "Jornal";

		SerieRegular jornal = new SerieRegular("Jornal da Noite", c, hora, 
				status, diasExibicao, temporadas, estilo, genero);
		
		
		central.adicionarCanal(c);
		central.adicionarPrograma(jornal);
		
		pe.salvarCentral(central);
		
	}

}
