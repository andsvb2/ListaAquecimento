package janelas;

import javax.swing.JFrame;

import metodos.Persistencia;
import users.Usuario;

public class MainJanelas {

	public static void main(String[] args) {
		
		Persistencia pe = new Persistencia();
		Usuario usuario = pe.recuperarUsuario();
		
		if (usuario.getEmail() == null && usuario.getSenha() == null) {
			JanelaDeCadastro cadastroUsuario = new JanelaDeCadastro();
		}
		
	}

}
