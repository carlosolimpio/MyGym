package classesBasicas;

import java.io.Serializable;

import classesBasicas.Cliente;

public class Treino extends Entidade implements Serializable{
	
	private String nomeDoTreino;
	private String nomeExercicio;
	private int repeticao;
	private Cliente cliente;
	
	public Treino(String nomeTreino, String nomeExericio, int repeticoes, Cliente cliente){
		setNomeTreino(nomeTreino);
		setNomeExercicio(nomeExericio);
		setRepeticao(repeticoes);
		setCliente(cliente);
	}
	
	public void setNomeTreino(String nomeTreino){
		this.nomeDoTreino = nomeTreino;
	}
	
	public void setNomeExercicio(String nomeExercicio){
		this.nomeExercicio = nomeExercicio;
	}
	
	public void setRepeticao(int repeticao){
		this.repeticao = repeticao;
	}
	
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}
	
	public String getNomeTreino(){
		return nomeDoTreino;
	}
	
	public String getNomeExercicio(){
		return nomeExercicio;
	}
	
	public int getRepeticao(){
		return repeticao;
	}
	
	public Cliente getCliente(){
		return cliente;
	}
	
	public String toString(){
		return "Nome do Cliente: " + cliente.getNome() + "\n\nNome do treino: " + nomeDoTreino + "\n\n\nNome do exercício: " + nomeExercicio + "\t"+ repeticao;
	}
	
}