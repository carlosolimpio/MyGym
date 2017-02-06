package dados;

import java.util.ArrayList;

import classesBasicas.Cliente;
import classesBasicas.Treino;

public interface IRepositorioTreino {
	void cadastrar(Treino treino);

	void remover(Treino treino);
	
	Treino atualizar(Treino treino);

	Treino procurar(String nome);

	void removerTreinosPeloCliente(Cliente cliente);
	ArrayList<Treino> procurarTreinosPeloCliente(Cliente c);

}
