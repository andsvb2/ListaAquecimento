package metodos;
import java.util.ArrayList;

import midia.Canal;
import programas.Programa;
import users.Usuario;

/**
* Classe responsável por registrar e recuperar informações de programas e canais.
* As informações aqui registradas são salvas em arquivo XML por meio da classe Persistencia.
* @see Persistencia
* 
* @author Maria Beatriz Targino
* @author Anderson Silva Vieira
* 
* @version 1.0
* 
*/
/**
 * @author andersonsv
 *
 */
public final class CentralDeInformacoes {
	
	private ArrayList<Programa> todosOsProgramas = new ArrayList<>();
	private ArrayList<Canal> listaCanais = new ArrayList<>();
	private Usuario usuario = new Usuario();
//	private ArrayList<Usuario> usuario = new ArrayList<>();
	
	
	/*
	 * Métodos relacionados aos Programas
	 */
	
	/** Método para adicionar um programa ao ArrayList todosOsProgramas
	 * @param Programa programa - um objeto da classe Programa instanciado em outro contexto
	 * @return boolean - o retorno serve como uma flag para outros métodos */
	public boolean adicionarPrograma(Programa programa) {
		if (recuperarProgramaPeloId(programa) == null) {
			todosOsProgramas.add(programa);
			return true;
		}
		return false;
	}

	/** Método para retornar o ArrayList contendo todos os programas já cadastrados
	 * @return ArrayList<Programa> */
	public ArrayList<Programa> getTodosOsProgramas() {
		return todosOsProgramas;
	}

	/** Método para recuperar algum Programa do ArrayList usando o Id gerado na criação do objeto.
	 * @param Programa id - programa a ser recuperado
	 * @return Programa p - caso uma Id igual seja encontrada, é retornado o Programa de mesma Id que estava no ArrayList
	 * @return null - caso não haja programa de mesma Id no ArrayList, é retornado null */
	public Programa recuperarProgramaPeloId(Programa id) {
		for (Programa p : todosOsProgramas) {
			if (p.getId() == id.getId()) {
				return p;
			}
		}
		return null;
	}
	
	/*
	 * Métodos relacionados aos Canais
	 */

	/** Método para retornar o ArrayList contendo todos os canais já cadastrados
	 * @return ArrayList<Canal> */
	public ArrayList<Canal> getListaCanais() {
		return listaCanais;
	}

	/** Método para adicionar um canal ao ArrayList listaCanais
	 * @param Canal c - um objeto da classe Canal instanciado em outro contexto
	 * @return boolean - o retorno serve como uma flag para outros métodos */
	public boolean adicionarCanal(Canal c) {
		if (recuperarCanalPeloNome(c.getNomeCanal()) == null) {
			listaCanais.add(c);
			return true;
		}
		return false;
	}

	/** Método para recuperar algum Canal do ArrayList usando seu nome.
	 * @param String nomeTeste - nome do canal a ser recuperado
	 * @return Canal c - caso seja encontrado um canal de mesmo nome, é retornado aquele que estava no ArrayList
	 * @return null - caso não haja canal de mesmo nome no ArrayList, é retornado null */
	public Canal recuperarCanalPeloNome(String nomeTeste) {
			for (Canal c : listaCanais) {
				if (nomeTeste.equals(c.getNomeCanal()))
					return c;
			}
		return null;
	}
	
	/*
	 * Métodos relacionados ao Usuário
	 */
	
	public void adicionarUsuario(Usuario u) {
		usuario = u;
	}
	
	public Usuario recuperarUsuario() {
		if(usuario.getEmail() == null && usuario.getSenha() == null)
			return null;
		
		return usuario;
	}
	
	public void removerUsuario() {
		usuario = null;
	}
	
}
