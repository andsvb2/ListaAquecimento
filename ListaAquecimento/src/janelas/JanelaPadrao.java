package janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class JanelaPadrao extends JFrame {
	
	public JanelaPadrao(String titulo) {
		setTitle(titulo);
		setSize(600, 600);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (UnsupportedLookAndFeelException ulfe) {
			// handle exception
		} catch (ClassNotFoundException cnfe) {
			// handle exception
		} catch (InstantiationException ie) {
			// handle exception
		} catch (IllegalAccessException iae) {
			// handle exception
		}
	}
	
	private void adicionarTitulo() {
		
	}
	
	private void adicionarLabels() {
		
	}
	
	private void adicionarTextFields() {
		
	}
	
	
private void adicionarMenu() {
		
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		JMenu menuOpcoes = new JMenu("Opções");
		menu.add(menuOpcoes);
		
		OuvinteDoMenu ouvinteMenu = new OuvinteDoMenu(this);
		
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
		
		private JFrame janela;
		
		public OuvinteDoMenu(JFrame janela) {
			this.janela = janela;
		}

		public void actionPerformed(ActionEvent e) {
			String opcao = e.getActionCommand();
			
			switch (opcao) {
			case "Cadastrar canal":
				if (!(janela instanceof CadastrarCanal)) {
					dispose();
					new CadastrarCanal();
				}
				break;
			case "Cadastrar programa":
				if (!(janela instanceof JanelaCadastroPrograma)) {
					dispose();
					new JanelaCadastroPrograma();
				}
				break;
			case "Listar todos os canais":
				if (!(janela instanceof ListaCanais)) {
					dispose();
					new ListaCanais();
				}
				break;
			case "Listar todos os programas":
//				if (!(janela instanceof ListaCanais)) {
//					dispose();
//					new ListaCanais();
//				}
//				new listarProgramas();
				break;
			case "Gerar programação de séries em PDF":
				dispose();
//				new gerarProgramacao();
				break;
			case "Enviar programação de séries da semana por email":
				dispose();
//				new enviarEmail();
				break;
			case "Deletar cadastro":
				if (!(janela instanceof CadastrarUsuario)) {
					dispose();
					new CadastrarUsuario();
				}
				break;
			default:
				break;
			}
		}
		
	}
}
