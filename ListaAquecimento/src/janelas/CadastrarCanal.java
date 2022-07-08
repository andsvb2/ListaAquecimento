package janelas;

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

import metodos.CentralDeInformacoes;
import metodos.Persistencia;

public class CadastrarCanal extends JanelaPadrao {
	
	private JComboBox<String> combo;
	private JFormattedTextField tfNumero;
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
		numeroDoCanal.setOpaque(true);
		add(numeroDoCanal);
	}

	private void adicionarTextFields() {
		JTextField campoNome = new JTextField();
		campoNome.setBounds(65, 35, 540, 30);
		add(campoNome);
		
		try {
			MaskFormatter mascara = new MaskFormatter("####");
			tfNumero = new JFormattedTextField(mascara);
			tfNumero.setHorizontalAlignment(JFormattedTextField.CENTER);
			tfNumero.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		} catch (Exception e) {}
	}
	
	private void adicionarBotoes() {
		JButton botaoCadastrar = new JButton("Cadastrar canal");
		botaoCadastrar.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		add(botaoCadastrar);
		
		JButton botaoEditar = new JButton("Edtiar canal");
		botaoEditar.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		add(botaoEditar);
	}
	
	private void adicionarCombo() {
		String tipos[] = {"Canal aberto", "Broadcasting aberto", "Pacote de assinatura",
				"Assinatura individual de televisão", "Assinatura individual de broadcasting"};
		
		combo = new JComboBox(tipos);
		combo.setBounds(getBounds());
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
