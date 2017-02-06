package classesBasicas;

import java.util.Date;

public class Presenca {

	private Cliente cliente;
	private Treino treino;
	private Date data;
	
	public Presenca(Cliente cliente, Treino treino, Date data){
		setCliente(cliente);
		setDate(data);
		setTreino(treino);
	}
	
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}
	
	public void setTreino(Treino treino){
		this.treino = treino;
	}
	
	public void setDate(Date data){
		this.data = data;
	}
	
	public Cliente getCliente(){
		return cliente;
	}
	
	public Treino getTreino(){
		return treino;
	}
	
	public Date getDate(){
		return data;
	}
	
	
	public String toString() {//arrumar
		
		return super.toString();
	}
	
}

