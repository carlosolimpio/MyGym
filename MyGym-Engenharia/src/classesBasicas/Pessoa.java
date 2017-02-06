package classesBasicas;

import java.io.Serializable;

import classesBasicas.Entidade;

public class Pessoa extends Entidade implements Serializable{
 private String nome;
 private long cpf;
 private Login login;
	public Pessoa(String nome, long cpf, Login login) {
		setNome(nome);
		this.cpf = cpf;
		this.login = login;


	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public long getCpf() {
		return cpf;
	}
	public Login getLogin() {
		return login;
	}
	
	
		
}
