package dados;

import java.util.ArrayList;

import classesBasicas.Aula;

public interface IRepositorioAulas {
	void cadastrar(Aula aula);

	void remover(Aula aula );
	
	Aula atualizar(Aula aula );

	Aula procurar(String nome );

	ArrayList<Aula> listaAulas();
}
