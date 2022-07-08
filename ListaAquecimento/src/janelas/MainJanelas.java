package janelas;

import javax.swing.JFrame;

import metodos.Persistencia;
import users.Usuario;

public class MainJanelas {

	public static void main(String[] args) {
		
		JFrame janela;
		Persistencia pe = Persistencia.getInstancia();
		Usuario usuario = pe.recuperarUsuario();
		
		if (usuario.getEmail() == null && usuario.getSenha() == null) {
			janela = new CadastrarUsuario();
		} else {
			janela = new LogarUsuario();
		}
		
	}
}
