package janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class JanelaDeCadastro extends JanelaPadrao {

	public JanelaDeCadastro() {
		super("Cadastro");
		adicionarTitulo();
		adicionarLabels();
		adicionarTextFields();
		adicionarBotaoCadastro();
		setVisible(true);
	}
	
	protected void adicionarTitulo() {
		ImageIcon icone = new ImageIcon();
		JLabel titulo = new JLabel("CADASTRO", icone, JLabel.CENTER);
		titulo.setBounds(0, 0, 600, 30);
		titulo.setFont(new Font("Fira Sans", Font.BOLD, 15));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setOpaque(true);
		add(titulo);
	}
	
	protected void adicionarLabels() {
		JLabel email = new JLabel("Email");
		email.setBounds(5, 35, 45, 30);
		email.setHorizontalAlignment(JLabel.CENTER);
		email.setOpaque(true);
		add(email);
		
		JLabel senha = new JLabel("Senha");
		senha.setBounds(5,70,45,30);
		senha.setHorizontalAlignment(JLabel.CENTER);
		senha.setOpaque(true);
		add(senha);
	}
	
	protected void adicionarTextFields() {
		JTextField campoEmail = new JTextField();
		campoEmail.setBounds(55, 35, 540, 30);
		
		JPasswordField campoSenha = new JPasswordField();
		campoSenha.setBounds(55, 70, 540, 30);
		
		add(campoEmail);
		add(campoSenha);
	}
	
	private void adicionarBotaoCadastro() {
		JButton botaoCadastro = new JButton("Finalizar cadastro");
		OuvinteBotaoCadastrar ouvinte = new OuvinteBotaoCadastrar(this);
		
		botaoCadastro.setBounds(10, 80, 30, 30);
//		botaoCadastro.setIcon(new ImageIcon());
		botaoCadastro.addActionListener(ouvinte);
		add(botaoCadastro);
	}
	
	private class OuvinteBotaoCadastrar implements ActionListener{
		private JanelaDeCadastro janela;
		
		private OuvinteBotaoCadastrar(JanelaDeCadastro janela) {
			this.janela = janela;
		}
		
		public void actionPerformed(ActionEvent ouvinte) {
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
		}

	}
	
}

