package janelas;

import metodos.MainAgenda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JanelaPadrao {

	public Menu() {
		super("Menu");
		adicionarTitulo();
	}
	
	protected void adicionarTitulo() {
		JLabel titulo = new JLabel("Menu", JLabel.CENTER);
		titulo.setBounds(0, 0, 0, 0);
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setOpaque(true);
		add(titulo);
	}
	
	private void adicionarMenu() {
		
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		JMenu menuOpcoes = new JMenu("Opções");
		menu.add(menuOpcoes);
		
		OuvinteDoMenu ouvinteMenu = new OuvinteDoMenu();
		
		JMenuItem cadastrarCanal = new JMenuItem("Cadastrar canal");
		menuOpcoes.add(cadastrarCanal);
		cadastrarCanal.addActionListener(ouvinteMenu);
		
		JMenuItem cadastrarPrograma = new JMenuItem("Cadastrar programa");
		menuOpcoes.add(cadastrarPrograma);
		cadastrarPrograma.addActionListener(ouvinteMenu);
		
		JMenuItem listarCanais = new JMenuItem("Listar todos os canais");
		menuOpcoes.add(listarCanais);
		listarCanais.addActionListener(ouvinteMenu);
		
		JMenuItem listarProgramas = new JMenuItem("Listar todos os programas");
		menuOpcoes.add(listarProgramas);
		listarProgramas.addActionListener(ouvinteMenu);
		
		JMenuItem gerarPDF = new JMenuItem("Gerar programação de séries em PDF");
		menuOpcoes.add(gerarPDF);
		gerarPDF.addActionListener(ouvinteMenu);
		
		JMenuItem enviarEmail = new JMenuItem("Enviar programação de séries da semana por email");
		menuOpcoes.add(enviarEmail);
		enviarEmail.addActionListener(ouvinteMenu);
		
		JMenuItem deletarCadastro = new JMenuItem("Deletar cadastro");
		menuOpcoes.add(deletarCadastro);
		deletarCadastro.addActionListener(ouvinteMenu);
		
	}
	
	private class OuvinteDoMenu implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String opcao = e.getActionCommand();
			
			switch (opcao) {
			case "Cadastrar canal":
				dispose();
				new cadastrarCanal();
				break;
			case "Cadastrar programa":
				dispose();
				new cadastrarPrograma();
				break;
			case "Listar todos os canais":
				dispose();
				new listarCanais();
				break;
			case "Listar todos os programas":
				dispose();
				new listarProgramas();
				break;
			case "Gerar programação de séries em PDF":
				dispose();
				new gerarProgramacao();
				break;
			case "Enviar programação de séries da semana por email":
				dispose();
				new enviarEmail();
				break;
			case "Deletar cadastro":
				dispose();
				new JanelaDeCadastro();
				break;
			default:
				break;
			}
		}
		
	}
}
