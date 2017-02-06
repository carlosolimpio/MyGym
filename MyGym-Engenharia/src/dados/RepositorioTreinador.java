package dados;

import java.util.ArrayList;

import classesBasicas.Cliente;
import classesBasicas.Pessoa;
import classesBasicas.Treinador;

public class RepositorioTreinador extends Repositorio<Treinador> implements IRepositorioTreinador{
	
	private static RepositorioTreinador repositorioTreinador;


	public RepositorioTreinador() {
		super("Treinador");
	}
	
	public static RepositorioTreinador getInstance() {
		if (repositorioTreinador == null) {
			repositorioTreinador = new RepositorioTreinador();
		}

		return repositorioTreinador;
	}
	
	@Override
	public void cadastrar(Treinador treinador) {
		super.cadastrar(treinador); // chama repositorio para cadastrar um objeto
	}
	
	@Override
	public void remover(Treinador treinador) {
		super.remover(treinador); // chama repositorio para remover um objeto
	}
	
	@Override
	public Treinador procurar(long cpf) {
		for (Treinador treinador : super.getLista()) {
			if(treinador.getCpf() == cpf){
				return treinador;
			}
		}
		return null;
	}
	
	@Override
	public Treinador atualizar(Treinador treinador) {
		
		return super.atualizar(treinador); // chama repositorio para atualizar um objeto
	}	
	



}
