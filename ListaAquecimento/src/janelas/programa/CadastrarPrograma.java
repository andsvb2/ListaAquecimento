package janelas.programa;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import enums.StatusPrograma;
import enums.TipoPrograma;
import janelas.JanelaPadrao;
import metodos.CentralDeInformacoes;
import metodos.Persistencia;

public class CadastrarPrograma extends JanelaPadrao{

	private Persistencia pe = new Persistencia();
	private CentralDeInformacoes central = pe.recuperarCentral();
	private JFormattedTextField tfTemporada;
	private JTextField tfPrograma;
	private JComboBox<TipoPrograma> cbTipoPrograma;
	private JComboBox<StatusPrograma> cbStatusPrograma;

	public CadastrarPrograma() {
		super("Cadastro");
		adicionarTitulo();
		adicionarLabels();
		adicionarTextFields();
		adicionarCombo();
		adicionarBotaoCadastro();
		setVisible(true);
	}
		
	private void adicionarTitulo() {
		JLabel titulo = new JLabel("Cadastrar Programa", JLabel.CENTER);
		titulo.setBounds(0, 0, 600, 30);
		titulo.setFont(new Font("Fira Sans", Font.BOLD, 15));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setOpaque(true);
		add(titulo);
	}

	private void adicionarLabels() {
		JLabel lbPrograma = new JLabel("Nome");
		lbPrograma.setBounds(5, 35, 75, 30);
		lbPrograma.setHorizontalAlignment(JLabel.CENTER);
		add(lbPrograma);
		
		JLabel lbTipo = new JLabel("Tipo");
		lbTipo.setBounds(5, 70, 75, 30);
		lbTipo.setHorizontalAlignment(JLabel.CENTER);
		add(lbTipo);

		JLabel lbTemporada = new JLabel("Temporada");
		lbTemporada.setBounds(5,105,75,30);
		lbTemporada.setHorizontalAlignment(JLabel.CENTER);
		add(lbTemporada);
		
		JLabel lbStatus = new JLabel("Status");
		lbStatus.setBounds(5,140,75,30);
		lbStatus.setHorizontalAlignment(JLabel.CENTER);
		add(lbStatus);
	}

	private void adicionarTextFields() {
		tfPrograma = new JTextField();
		tfPrograma.setBounds(70, 35, 520, 30);
		add(tfPrograma);

		
		try {
			MaskFormatter mascara = new MaskFormatter("##");
			tfTemporada = new JFormattedTextField(mascara);
			tfTemporada.setHorizontalAlignment(JFormattedTextField.CENTER);
			tfTemporada.setBounds(85, 105, 50, 30);
			add(tfTemporada);
		} catch (Exception e) {}
	}

	private void adicionarCombo() {
		
		cbTipoPrograma = new JComboBox(TipoPrograma.values());
		cbTipoPrograma.setBounds(70, 70, 200, 30);
		add(cbTipoPrograma);
		
		cbStatusPrograma = new JComboBox(StatusPrograma.values());
		cbStatusPrograma.setBounds(70, 140, 200, 30);
		add(cbStatusPrograma);
	}

	private void adicionarBotaoCadastro() {
		JButton botaoCadastro = new JButton("Cadastrar");

		botaoCadastro.setBounds(465, 505, 130, 30);
		add(botaoCadastro);

		JButton botaoFavoritos = new JButton("Favoritar");

		botaoFavoritos.setBounds(330, 505, 130, 30);
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
		
	}
	
	
}
