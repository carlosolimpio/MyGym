package dados;

import java.util.ArrayList;

import classesBasicas.Aula;

public class RepositorioAulas extends Repositorio<Aula> implements IRepositorioAulas{
	
	private static RepositorioAulas repositorioAulas;

	public RepositorioAulas() {
		super("Aulas");
	}
	
	public static RepositorioAulas getInstance() {
		if (repositorioAulas == null) {
			repositorioAulas = new RepositorioAulas();
		}

		return repositorioAulas;
	}
	
	@Override
	public void cadastrar(Aula aula) {
		super.cadastrar(aula); // chama repositorio para cadastrar um objeto
	}
	
	@Override
	public void remover(Aula aula ) {
		super.remover(aula);
			}
		
	
	@Override
	public Aula procurar(String nome) {
		for (Aula aula : super.getLista()) {
			if(aula.getNomeDaAula().toLowerCase().equals(nome.toLowerCase())){
				return aula;
			}
		}
		return null;
	}
	
	@Override
	public Aula atualizar(Aula aula) {
		
		return super.atualizar(aula); // chama repositorio para atualizar um objeto
	}	
	

	@Override
	public ArrayList<Aula> listaAulas() {
		// TODO Auto-generated method stub
		return repositorioAulas.getLista();
	}

}
