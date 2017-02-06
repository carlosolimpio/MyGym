package classesBasicas;

import java.io.Serializable;
import java.util.Calendar;



public class Cliente extends Pessoa implements Serializable{

	private String endereco;
	private int idade;
	private long telefone;
	private String email;
	private Avaliacao avaliacaofisica;
	private Treinador treinador;

	public Cliente(String nome, String endereco, int idade, long cpf, long telefone, String email, Login login, Avaliacao avaliacaoFisica, Treinador treinador) {
		super (nome, cpf, login);
		setEndereco(endereco);
		setIdade(idade);
		setEmail(email);
		setTreinador(treinador);
		setAvaliacaofisica(avaliacaoFisica);
		this.telefone = telefone;
		
	}
	
	public void setTreinador(Treinador treinador2) {
		this.treinador = treinador2;
		
	}

	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setIdade(int idade){
		this.idade = idade;
	}
	
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAvaliacaofisica(Avaliacao avaliacaofisica) {
		this.avaliacaofisica = avaliacaofisica;
	
	}
	public Treinador getTreinador() {
		return treinador;
	}
	
	
	
	public String getEndereco(){
		return endereco;
	}
	
	public int getIdade(){
		return idade;
	}
	

	
	public long getTelefone() {
		return telefone;
	}
	
	public String getEmail() {
		return email;
	}

	
	public Avaliacao getAvaliacaofisica() {
		return avaliacaofisica;
	}
	
public String toString() {

	return ("\n\nNome: " + this.getNome() + "\nEndereco: " + this.endereco + "\nIdade: " + this.idade  + "\nTelefone: " + this.telefone
			+ "\nEmail : " + this.email + "\nAvaliação Fisica\n" + this.avaliacaofisica.toString() + "\nTreinador: " + treinador.getNome());
}
}
