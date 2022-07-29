package metodos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import midia.Canal;
import programas.SerieRegular;

public class MainAgenda {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);

		Persistencia pe = Persistencia.getInstancia();
		CentralDeInformacoes central = pe.recuperarCentral();
		Canal canal = new Canal();
		
		boolean sair = false;
		do {
			System.out.println("[1] - Novo Programa");
			System.out.println("[2] - Listar Programas");
			System.out.println("[3] - Listar programas de um mesmo tipo");
			System.out.println("[4] - Novo canal");
			System.out.println("[5] - Listar canais");
			System.out.println("[6] - Gerar relatório dos programas de um mesmo canal");
			System.out.println("[7] - Enviar programação de hoje");
			System.out.println("[S] - Sair");
			System.out.print("\nOpção: ");
			
			String opcao = leia.nextLine();
			switch (opcao) {
			case "1":
				if (central.getListaCanais().isEmpty()) {
					System.out.println("Para cadastrar um programa é necessário cadastrar um Canal(s) previamente.\n");
				} else {
					System.out.println("\n-- dados do Programa -- ");

					System.out.print("Nome do Programa: ");
					String nome = leia.nextLine();

					System.out.print("Tipo do Programa: ");
					central.getTodosOsProgramas();

					System.out.print("\nOpção: ");
					String tipoString = leia.nextLine().toUpperCase();

					System.out.print("Canais: ");
					central.getListaCanais();

					System.out.print("\nCanal: ");
					String nomeCanal = leia.nextLine();

					canal = central.recuperarCanalPeloNome(nomeCanal);
					
					if(canal == null) {
						System.out.println("Não existe esse canal: " +
								nomeCanal);
						break;
					}

					System.out.println("Dias da Semana: ");
					System.out.print("Dias escolhidos: ");
					String[] dias = leia.nextLine().split(",");

					ArrayList<String> diasDaSemana = new
							ArrayList<>(Arrays.asList(dias));

					SerieRegular programa = new SerieRegular(nomeCanal, null, null, canal);
					if (central.adicionarPrograma(programa)) {
						System.out.println("Programa cadastrado com sucesso!");
						pe.salvarCentral(central);
					} else {
						System.out.println("Não foi possível cadastrar o programa!");
						System.out.println("O programa já existe ou não possui um canal.");
					}
				}
				break;
			case "2":
				if (central.getTodosOsProgramas().isEmpty()) {
					System.out.println("Não há programa cadastrado.");
				} else {
					central.getTodosOsProgramas();
				}
				break;
			case "3":
				if (central.getTodosOsProgramas().isEmpty()) {
					System.out.println("Não há programa cadastrado.");
				} else {
					System.out.print("Tipo do Programa: ");
					canal.getTipoCanal();
					
					System.out.print("\nOpção: ");
					String tipoString = leia.nextLine().toUpperCase();
					
					if(canal.getTipoCanal().contains(tipoString)) {
						canal.getTipoCanal();
					} else {
						System.out.println("Não existe esse tipo de programa : " +
								tipoString);
						break;
					}
				}
				
				break;
			case "4":
				System.out.println("-- dados do canal --");
				
				System.out.print("nome: ");
				String nomeCanal = leia.nextLine();
				
				System.out.print("Tipo do canal: ");
				String tipoCanal = leia.nextLine();
				
				Canal c = new Canal(nomeCanal, tipoCanal);
				
				if (central.adicionarCanal(c)) {
					System.out.println("Canal cadastrado com sucesso!\n");
					pe.salvarCentral(central);
				} else {
					System.out.println("Não foi possível cadastrar o canal!");
					System.out.println("O canal já existe.");
				}
				break;
			case "5":
				if (central.getListaCanais().isEmpty()) {
					System.out.println("nenhum canal cadastrado.\n");
				} else {
					ArrayList<Canal> listaCanais = central.getListaCanais();
					for (Canal c1 : listaCanais)
						System.out.println(c1);
				}
				break;
			case "6":
				System.out.print("Canais: ");
				central.getListaCanais();
				
				System.out.print("\nOpção: ");
				String nomeDoCanal = leia.nextLine();
				
				canal = central.recuperarCanalPeloNome(nomeDoCanal);
				if( canal != null) {
					GeradorDeRelatorios.obterProgramacaoDeUmCanal(canal);
				} else {
					System.out.println("Não foi encontrado um canal com esse nome");
				}
				break;
			case "7":
				System.out.print("informe seu e-mail: ");
				String destinatario = leia.nextLine();
				
				System.out.println("enviando e-mail...");
				Mensageiro.enviarProgramacaoDeHoje("Programação do dia");
				System.out.println("e-mail enviado. cheque sua caixa de entrada ou spam");
				break;
			case "s":
			case "S":
				System.out.println("Fim de programa");
				sair = true;
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		} while (!sair);
	}

}


