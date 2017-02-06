package classesBasicas;

import java.io.Serializable;


public class Treinador extends Pessoa implements Serializable{
	
	public Treinador(String nome,long cpf,Login login ) {
		super(nome,cpf, login);
		
	}
	
	
	
	public String toString() {
		
		return "\nNome: " + this.getNome() + "\nCPF: " + this.getCpf() + "\nUsuario: " + this.getLogin().getUsuario() + "\nSenha: " + this.getLogin().getSenha();
	}


}
