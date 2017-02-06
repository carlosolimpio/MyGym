package dados;

import java.util.ArrayList;

import classesBasicas.Aula;
import classesBasicas.Cliente;
import classesBasicas.Treino;

public class RepositorioTreino extends Repositorio<Treino> implements IRepositorioTreino{
	
	private static RepositorioTreino repositorioTreino;
	private ArrayList<Cliente> listaClientes;

	public RepositorioTreino() {
		super("Treino");
	}
	
	public static RepositorioTreino getInstance() {
		if (repositorioTreino == null) {
			repositorioTreino = new RepositorioTreino();
		}

		return repositorioTreino;
	}
	
	@Override
	public void cadastrar(Treino treino) {
		super.cadastrar(treino); // chama repositorio para cadastrar um objeto
	}
	
	@Override
	public void remover(Treino treino) {
		
		super.remover(treino); // chama repositorio para remover um objeto
	}
	
	@Override
	public Treino procurar(String nome) {
		for (Treino treino : super.getLista()) {
			if(treino.getNomeTreino().toLowerCase().equals(nome.toLowerCase())){
				return treino;
			}
		}
		return null;
	}
	
	@Override
	public Treino atualizar(Treino treino) {
		
		return super.atualizar(treino); // chama repositorio para atualizar um objeto
	}
	
	public ArrayList<Cliente> getLitaCliente(){

		listaClientes.addAll(RepositorioCliente.getInstance().getLista()); // Adiciona a lista de cliente na lista de pessoa
	
		return listaClientes;
	}

	@Override
	public ArrayList<Treino> procurarTreinosPeloCliente(Cliente c) {
		ArrayList<Treino> lt = new ArrayList<Treino>();
		for (Treino treino : super.getLista()) {
			if(treino.getCliente().getCpf()==c.getCpf()){
				lt.add(treino);
			}
		}
		return lt;
	}

	public void removerTreinosPeloCliente(Cliente c) {
		ArrayList<Treino> lt = new ArrayList<Treino>();
		lt.addAll(super.getLista());
		for (Treino treino : lt) {
			if(treino.getCliente().getCpf() == c.getCpf()){
				remover(treino);
			}
		}
	}
}
