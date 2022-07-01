package users;

import java.util.Objects;

public class Usuario {
	
	private long id;
	private String nome;
	private String email;
	private String senha;
	
	public Usuario() {
		id = System.currentTimeMillis();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Usuário: " + nome + ". \nEmail: " + email + ".";
	}
	
	public boolean equals(Usuario u) {
		return (this.email.equals(u.getEmail()) && this.senha.equals(u.getSenha()));
	}
	
}
