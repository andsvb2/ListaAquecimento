package janelas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import metodos.CentralDeInformacoes;
import metodos.Persistencia;


public class JanelaTiposDeProgramas extends JanelaPadrao{

	private Persistencia pe = Persistencia.getInstancia();
	private CentralDeInformacoes central = pe.recuperarCentral();

	public JanelaTiposDeProgramas() {
		super("Reality shows/Programas contínuos");
		adicionarTitulo();
		adicionarLabels();
		adicionarTextFields();
		adicionarCombo();
		setVisible(true);
	}

		
	protected void adicionarTitulo() {
		JLabel titulo = new JLabel("Cadastrar Programa", JLabel.CENTER);
		titulo.setBounds(0, 0, 600, 30);
		titulo.setFont(new Font("Fira Sans", Font.BOLD, 15));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setOpaque(true);
		add(titulo);
	}

	protected void adicionarLabels() {
		JLabel nomeDoPrograma = new JLabel("Nome do Programa");
		nomeDoPrograma.setBounds(5, 35, 45, 30);
		nomeDoPrograma.setHorizontalAlignment(JLabel.CENTER);
		nomeDoPrograma.setOpaque(true);
		add(nomeDoPrograma);
		
		JLabel apresentadores = new JLabel("Apresentador(es)");
		apresentadores.setBounds(15, 35, 45, 30);
		apresentadores.setHorizontalAlignment(JLabel.CENTER);
		apresentadores.setOpaque(true);
		add(apresentadores);
	}

	protected void adicionarTextFields() {
		JTextField campoPrograma = new JTextField();
		campoPrograma.setBounds(55, 35, 540, 30);
		
		JTextField campoApresentadores = new JTextField();
		campoApresentadores.setBounds(55, 35, 50, 30);
		
		add(campoPrograma);
		add(campoApresentadores);
	}

	protected void adicionarCombo() {
		JComboBox<String> combo = new JComboBox<String>();
		
		String comboStatusDoPrograma[] = {"Status do programa", "Em exibição", "Hiato", "Finalizado", "Cancelado"};
		combo.setBounds(55,75,100,30);
		
		combo = new JComboBox(comboStatusDoPrograma);
		
		add(combo);
	}
	
	private void adicionarBotaoCadastro() {
		JButton botaoCadastro = new JButton("Cadastrar programa");
		
		botaoCadastro.setBounds(55, 85, 30, 30);
		add(botaoCadastro);
	}
	
	private class OuvinteBotaoCadastro implements ActionListener{
		
		private JanelaTiposDeProgramas janela;
		
		private OuvinteBotaoCadastro(JanelaTiposDeProgramas janela) {
			this.janela = janela;
		}
		
		public void actionPerformed(ActionEvent ouvinte) {
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
		
			// TODO: corrigir isso
			central.adicionarProgramaDeTV();
		}
	}
	// TODO: corrigir isso
	pe.salvarCentral(central);
}
