package janelas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import enums.TipoCanal;
import metodos.CentralDeInformacoes;
import metodos.Persistencia;

public class CadastrarCanal extends JanelaPadrao {
	
	private JComboBox<String> combo;
	private JFormattedTextField tfNumero;
	private JFormattedTextField tfLink;
	private Persistencia pe = Persistencia.getInstancia();
	private CentralDeInformacoes central = pe.recuperarCentral();

	public CadastrarCanal() {
		super("Cadastro de canal");
		adicionarTitulo();
		adicionarLabels();
		adicionarTextFields();
		adicionarBotoes();
		adicionarCombo();
		setVisible(true);
	}

	public JFormattedTextField getTfNumero() {
		return tfNumero;
	}
	
	private void adicionarTitulo() {
		JLabel titulo = new JLabel("CADASTRO DE CANAL", JLabel.CENTER);
		titulo.setBounds(0, 0, 600, 30);
		titulo.setFont(new Font("Fira Sans", Font.BOLD, 15));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setOpaque(true);
		add(titulo);
	}

	private void adicionarLabels() {
		JLabel nomeDoCanal = new JLabel("Nome:");
		nomeDoCanal.setBounds(5, 35, 55, 30);
		nomeDoCanal.setHorizontalAlignment(JLabel.CENTER);
		add(nomeDoCanal);
		
		JLabel numeroDoCanal = new JLabel("Número:");
		numeroDoCanal.setBounds(5, 70, 55, 30);
		numeroDoCanal.setHorizontalAlignment(JLabel.CENTER);
//		numeroDoCanal.setOpaque(true);
		add(numeroDoCanal);
		
		JLabel tipoCanal = new JLabel("Tipo:");
		tipoCanal.setBounds(190, 70, 55, 30);
		tipoCanal.setHorizontalAlignment(JLabel.CENTER);
		add(tipoCanal);
		
	}

	private void adicionarTextFields() {
		JTextField campoNome = new JTextField();
		campoNome.setBounds(65, 35, 520, 30);
		add(campoNome);
		
		try {
			MaskFormatter mascara = new MaskFormatter("####");
			tfNumero = new JFormattedTextField(mascara);
			tfNumero.setHorizontalAlignment(JFormattedTextField.CENTER);
			tfNumero.setBounds(65, 70, 120, 30);
			add(tfNumero);
		} catch (Exception e) {}
	}
	
	private void adicionarBotoes() {
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setBounds(465, 505, 130, 30);
		add(botaoCadastrar);
		
		JButton botaoEditar = new JButton("Editar");
		botaoEditar.setBounds(330, 505, 130, 30);
		add(botaoEditar);
	}
	
	private void adicionarCombo() {
		combo = new JComboBox(TipoCanal.values());
		combo.setBounds(250, 70, 345, 30);
		add(combo);
	}
	
	private class OuvinteBotaoCadastrar implements ActionListener{
		private CadastrarCanal cadastro;
		private OuvinteBotaoCadastrar(CadastrarCanal cadastro) {
			this.cadastro = cadastro;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			boolean deuCerto = false;
			// TODO: implementar lógica. do jeito que está a flag não é alterada. 
			
			if (deuCerto) {
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
			} else {
				JOptionPane.showMessageDialog(null, "Cadastro não pôde ser concluído");
			}
		}
	}
	
	private class OuvinteBotaoEditar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String opcao = (String) combo.getSelectedItem();
			
			if(opcao.equals("Canal aberto") 
					|| opcao.equals("Pacote de assinatura") 
					|| opcao.equals("Assinatura individual de televisão")) {
				tfNumero.setEditable(true);
			} else {
				dispose();
				new JanelaDeBroadcasting();
			}
		}
	}

}
