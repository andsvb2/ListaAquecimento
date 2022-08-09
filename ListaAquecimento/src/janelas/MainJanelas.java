package janelas;

import javax.swing.JFrame;

import janelas.programa.CadastrarPrograma;
import janelas.usuario.CadastrarUsuario;
import janelas.usuario.LogarUsuario;
import metodos.CentralDeInformacoes;
import metodos.Persistencia;
import users.Usuario;

public class MainJanelas {

	public static void main(String[] args) {
		
		JFrame janela;
		Persistencia pe = new Persistencia();
		CentralDeInformacoes central = pe.recuperarCentral();
				
		if (central.recuperarUsuario() == null) {
			janela = new CadastrarUsuario();
		} else {
			janela = new LogarUsuario();
		}
	}
}
