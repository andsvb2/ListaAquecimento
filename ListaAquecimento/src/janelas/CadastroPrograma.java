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

public class CadastroPrograma extends JanelaPadrao{

	private Persistencia pe = Persistencia.getInstancia();
	private CentralDeInformacoes central = pe.recuperarCentral();

	public CadastroPrograma() {
		super("Cadastro");
		adicionarTitulo();
		adicionarLabels();
		adicionarTextFields();
		adicionarCombo();
		adicionarBotaoCadastro();
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

		JLabel temporada = new JLabel("Temporada");
		temporada.setBounds(65,65,45,30);
		temporada.setHorizontalAlignment(JLabel.CENTER);
		temporada.setOpaque(true);
		add(temporada);
	}

	protected void adicionarTextFields() {
		JTextField campoPrograma = new JTextField();
		campoPrograma.setBounds(55, 35, 540, 30);

		JTextField campoTemporada = new JTextField();
		campoTemporada.setBounds(55, 35, 50, 30);

		add(campoPrograma);
		add(campoTemporada);
	}

	private void adicionarCombo() {
		JComboBox<String> combo = new JComboBox<String>();

		String[] comboTipos = {"Escolha uma opção", "Séries regulares", "Reality shows", "Programas contínuos"};
		
		combo = new JComboBox(comboTipos);
		combo.setBounds(55,45,100,30);
		
		String[] comboGeneros = {"Escolha um gênero", "Comédia", "Drama", "Ficção", "Romance"};
		
		combo = new JComboBox(comboGeneros);
		combo.setBounds(55,55,100,30);

		String[] comboEstilo = {"Escolha um estilo", "Live action", "Animada"};
		
		combo = new JComboBox(comboEstilo);
		combo.setBounds(55,65,100,30);

		String[] comboStatus = {"Status do programa", "Em exibição", "Hiato", "Finalizado", "Cancelada"};
		
		combo = new JComboBox(comboStatus);
		combo.setBounds(55,75,100,30);

		add(combo);
	}

	private void adicionarBotaoCadastro() {
		JButton botaoCadastro = new JButton("Cadastrar programa");

		botaoCadastro.setBounds(55, 85, 30, 30);
		add(botaoCadastro);

		JButton botaoFavoritos = new JButton("Adicionar aos favoritos");

		botaoFavoritos.setBounds(70,85,30,30);
		add(botaoFavoritos);
	}

	private class OuvinteBotaoCadastro implements ActionListener{

		private JanelaPadrao janela;

		private OuvinteBotaoCadastro(JanelaPadrao janela) {
			this.janela = janela;
		}

		public void actionPerformed(ActionEvent ouvinte) {
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
		}
		// TODO: falta corrigir isso
	central.adicionarProgramaDeTv();
	}
	
	// TODO: falta corrigir isso
    pe.salvarCentral(central);
	
	public static void main(String[] args) {
		JanelaCadastroPrograma janela = new JanelaCadastroPrograma();
	}
}
