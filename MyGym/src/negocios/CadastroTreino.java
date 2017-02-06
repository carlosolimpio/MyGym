package negocios;
import java.util.ArrayList;

import classesBasicas.Cliente;
import classesBasicas.Treino;
import dados.IRepositorioTreino;
import dados.RepositorioTreino;
import excecoes.ObjetoJaExisteException;
import excecoes.ObjetoNaoExisteException;

public class CadastroTreino {

	private static IRepositorioTreino repositorioTreino;

	public CadastroTreino() {
		this.repositorioTreino = RepositorioTreino.getInstance();
	}
	
	
	public static void removerTreinoPeloCliente(Cliente cliente) {
		repositorioTreino.removerTreinosPeloCliente(cliente);
		
	}
	public void removerTreino(String nome ) throws ObjetoNaoExisteException{
		Treino treino = repositorioTreino.procurar(nome.toLowerCase());
		if(treino != null){
		repositorioTreino.remover(treino);
		}else{
			throw new ObjetoNaoExisteException();
		
			} 
	}

	public void cadastrarTreino(Treino treino) throws ObjetoJaExisteException{
		if (treino == null) {
			throw new IllegalArgumentException("Parametro invalido");
		} else {
			Treino treinoRetornar;

			treinoRetornar = this.repositorioTreino.procurar(treino.getNomeTreino().toLowerCase());

			if (treinoRetornar == null) {
				repositorioTreino.cadastrar(treino);
			} else {
				throw new ObjetoJaExisteException(treino);
			}
		}
	}

	public void atualizarTreino(Treino treino) throws ObjetoNaoExisteException {
		if (treino == null) {
			throw new IllegalArgumentException("Parametro invalido");
		} else {
			Treino treinoRetornar;

			treinoRetornar = this.repositorioTreino.atualizar(treino);

			if (treinoRetornar == null) {
				throw new ObjetoNaoExisteException();
			}
		}
	}
	
	public Treino procurarTreino(String nome )throws ObjetoNaoExisteException{
		if (nome == null) {
			throw new IllegalArgumentException("Parametro invalido");
		} else {
			Treino treinoRetornar;

			treinoRetornar = this.repositorioTreino.procurar(nome.toLowerCase());
	
			if (treinoRetornar == null) {
			  
			throw new ObjetoNaoExisteException();
		
			}
			return treinoRetornar;
		
		}
	}


	public ArrayList<Treino> procurarTreinoPeloCliente(Cliente c ){
		if (c == null) {
			throw new IllegalArgumentException("Parametro invalido");
		} else {

			return this.repositorioTreino.procurarTreinosPeloCliente(c);
		
		}
	}
	
	
}