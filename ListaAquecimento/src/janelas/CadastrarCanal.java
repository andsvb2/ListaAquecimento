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

public class CadastrarCanal extends JanelaPadrao {
	
	private JComboBox<String> combo;
	private JFormattedTextField tfNumero;

	public CadastrarCanal() {
		super("Cadastro de canal");
		adicionarTitulo();
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
		JLabel nomeDoCanal = new JLabel("Nome do canal");
		nomeDoCanal.setBounds(getBounds());
		nomeDoCanal.setOpaque(true);
		add(nomeDoCanal);
		
		JLabel numeroDoCanal = new JLabel("Número do canal");
		numeroDoCanal.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		numeroDoCanal.setOpaque(true);
		add(nomeDoCanal);
	}

	private void adicionarTextFields() {
		JTextField campoNome = new JTextField();
		campoNome.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		
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
		combo = new JComboBox<String>();
		
		combo.add("Canal aberto");
		combo.add("Broadcasting aberto");
		combo.add("Pacote de assinatura");
		combo.add("Assinatura individual de televisão");
		combo.add("Assinatura individual de broadcasting");
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
					&& opcao.equals("Pacote de assinatura") 
					&& opcao.equals("Assinatura individual de televisão")) {
				tfNumero.setEditable(true);
			} else {
				dispose();
				new JanelaDeBroadcasting();
			}
		}
	}

}
