package teste;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

import enums.EstiloSerieRegular;
import enums.StatusPrograma;
import enums.TipoCanal;
import enums.TipoPrograma;
import metodos.CentralDeInformacoes;
import metodos.Persistencia;
import midia.Canal;
import midia.CanalTv;
import programas.ProgramaContinuo;
import users.Usuario;

public class MainTestePersistencia {

	public static void main(String[] args) {
		
		Persistencia pe = new Persistencia();
		CentralDeInformacoes central = pe.recuperarCentral();
		
		Usuario u = new Usuario("teste@gmail.com", "teste123");
		central.adicionarUsuario(u);
		
		Canal c = new CanalTv("SBT", TipoCanal.ABERTO, 540);
		
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
		TipoPrograma tipoP = TipoPrograma.PC;
		ArrayList<String> apresentadores = new ArrayList<>();
		apresentadores.add("Fulana");
		apresentadores.add("Ciclano");

		ProgramaContinuo jornal = new ProgramaContinuo("Jornal da Noite", c, hora, 
				status, diasExibicao, tipoP, apresentadores);
		
		
		central.adicionarCanal(c);
		central.adicionarPrograma(jornal);
		
		pe.salvarCentral(central);
		
	}

}
