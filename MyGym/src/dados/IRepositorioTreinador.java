package dados;

import java.util.ArrayList;

import classesBasicas.Treinador;
import excecoes.ObjetoNaoExisteException;

public interface IRepositorioTreinador {
	
	void cadastrar(Treinador treinador);

	void remover(Treinador treinador);
	
	Treinador atualizar(Treinador treinador);

	Treinador procurar(long cpf);
	
	
}
