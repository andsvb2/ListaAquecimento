package janelas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import metodos.Persistencia;
import users.Usuario;

public class MainJanelas {

	public static void main(String[] args) {
		
		Persistencia pe = Persistencia.getInstancia();
		Usuario usuario = pe.recuperarUsuario();
		
		if (usuario.getEmail() == null && usuario.getSenha() == null) {
			CadastrarUsuario cadastroUsuario = new CadastrarUsuario();
		} else {
			JOptionPane.showMessageDialog(null, "Já cadastrou!");
		}
		
	}
}
