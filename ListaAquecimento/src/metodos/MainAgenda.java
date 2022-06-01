package metodos;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Scanner;

import programas.TipoDePrograma;

public class MainAgenda {
	
	private static void exibirMenu() {
		System.out.println(
				"1 - cadastrar novo programa;"
				+ "\n2 - listar todos os programas;"
				+ "\n3 - listar os programas de um tipo;"
				+ "\n4 - cadastrar novo canal de televisão;"
				+ "\n5 - listar todos os canais de televisão;"
				+ "\nS - sair");	
	}
	
	private static void cadastrarPrograma(Scanner input) {
		
		System.out.print("Nome do programa: ");
		String nome = input.nextLine();
		
		System.out.print("Tipo do programa:"
				+ "\n1 - Série Regular;"
				+ "\n2 - Reality show;"
				+ "\n3 - Programa contínuo.");
		TipoDePrograma tipoPrograma = TipoDePrograma.of(Integer.parseInt(input.nextLine()));
		
		System.out.print("Quantos dias de exibição por semana?");
		int qtdDias = Integer.parseInt(input.nextLine());
		
		ArrayList<DayOfWeek> diasExibicao = new ArrayList<DayOfWeek>();
		
		System.out.print("Quais os dias de exibição na semana?"
				+ "\n1 - segunda;"
				+ "\n2 - terça;"
				+ "\n3 - quarta;"
				+ "\n4 - quinta;"
				+ "\n5 - sexta;"
				+ "\n6 - sábado;"
				+ "\n7 - domingo.");
		
		for(int i = 0; 0 < qtdDias;) {
			DayOfWeek dia = DayOfWeek.of(Integer.parseInt(input.nextLine()));
			
			if (diasExibicao.contains(dia) == false) {
				diasExibicao.add(dia);
				i++;
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String opcao = null;
		
		while (!opcao.equals("S")) {
			
			exibirMenu();
			
			opcao = input.nextLine();
			
			switch (opcao) {
			
			case "1":
				cadastrarPrograma(input);
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				break;
			default:
				break;
			}
			
		}
		
	}
}
