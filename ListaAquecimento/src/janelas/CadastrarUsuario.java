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

import metodos.CentralDeInformacoes;
import metodos.Persistencia;
import metodos.ValidadorEmail;
import users.Usuario;


public class CadastrarUsuario extends LoginPadrao {
	private JTextField campoEmail;
	private JPasswordField campoSenha;
	

	public CadastrarUsuario() {
		super("Cadastro");
		adicionarTitulo();
		adicionarLabels();
		adicionarTextFields();
		adicionarBotao();
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
		campoEmail = new JTextField();
		campoEmail.setBounds(55, 35, 540, 30);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(55, 70, 540, 30);
		
		add(campoEmail);
		add(campoSenha);
	}
	
	protected void adicionarBotao() {
		JButton botaoCadastro = new JButton("Finalizar cadastro");
		OuvinteBotaoCadastrar ouvinte = new OuvinteBotaoCadastrar(this);
		
		botaoCadastro.setBounds(5, 120, 140, 30);
//		botaoCadastro.setIcon(new ImageIcon());
		botaoCadastro.addActionListener(ouvinte);
		add(botaoCadastro);
	}
	
	private class OuvinteBotaoCadastrar implements ActionListener{
		private CadastrarUsuario janela;
		
		private OuvinteBotaoCadastrar(CadastrarUsuario janela) {
			this.janela = janela;
		}
		
		public void actionPerformed(ActionEvent ouvinte) {
			String email = campoEmail.getText().trim();
			String senha = new String (campoSenha.getPassword());

			boolean deuCerto = false;
			
			if (ValidadorEmail.isValidEmailAddress(email)) {
				Usuario u = new Usuario(email, senha);
				Persistencia pe = Persistencia.getInstancia();
				CentralDeInformacoes central = pe.recuperarCentral();
				central.adicionarUsuario(u);
				pe.salvarCentral(central);
				deuCerto = true;
			}
			
			if (deuCerto) {
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
				dispose();
				new CadastrarCanal();
			} else {
				JOptionPane.showMessageDialog(null, "Deu erro.");
			}
		}

	}
	
}

