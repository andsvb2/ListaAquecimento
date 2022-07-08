package janelas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import metodos.Persistencia;
import metodos.ValidadorEmail;
import users.Usuario;


public class LogarUsuario extends JanelaPadrao {
	private JTextField campoEmail;
	private JPasswordField campoSenha;
	

	public LogarUsuario() {
		super("Login");
		adicionarTitulo();
		adicionarLabels();
		adicionarTextFields();
		adicionarBotaoLogin();
		setVisible(true);
	}
	
	public JTextField getCampoEmail() {
		return campoEmail;
	}

	public JPasswordField getCampoSenha() {
		return campoSenha;
	}

	protected void adicionarTitulo() {
		ImageIcon icone = new ImageIcon();
		JLabel titulo = new JLabel("LOGIN", icone, JLabel.CENTER);
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
		campoEmail = new JTextField();
		campoEmail.setBounds(55, 35, 540, 30);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(55, 70, 540, 30);
		
		add(campoEmail);
		add(campoSenha);
	}
	
	private void adicionarBotaoLogin() {
		JButton botaoLogin = new JButton("Entrar");
		OuvinteBotaoLogin ouvinte = new OuvinteBotaoLogin(this);
		
		botaoLogin.setBounds(5, 120, 140, 30);
//		botaoCadastro.setIcon(new ImageIcon());
		botaoLogin.addActionListener(ouvinte);
		add(botaoLogin);
	}
	
	private class OuvinteBotaoLogin implements ActionListener{
		private LogarUsuario janela;
		
		private OuvinteBotaoLogin(LogarUsuario janela) {
			this.janela = janela;
		}
		
		public void actionPerformed(ActionEvent ouvinte) {
			String email = campoEmail.getText().trim();
			String senha = new String (campoSenha.getPassword());

			boolean deuCerto = false;
			
			Persistencia pe = Persistencia.getInstancia();
			Usuario temp = new Usuario(email, senha);
			Usuario existente = pe.recuperarUsuario();
			
			if (temp.equals(existente)) {
				deuCerto = true;
				dispose();
				new CadastrarCanal();
			}
			
			if ((temp.getEmail().equals(existente.getEmail()) == false)
					&& (temp.getSenha().equals(existente.getSenha()) == false)) {
				JOptionPane.showMessageDialog(null, "Email e senha são diferentes dos cadastrados.");
			} else if (temp.getEmail().equals(existente.getEmail()) == false) {
				JOptionPane.showMessageDialog(null, "Email diferente do cadastrado.");
			} else {
				JOptionPane.showMessageDialog(null, "Senha diferente da cadastrada.");
			}
		
		}

	}
	
}

