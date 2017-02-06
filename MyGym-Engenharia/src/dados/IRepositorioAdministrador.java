package dados;

import java.util.ArrayList;

import classesBasicas.Administrador;;

public interface IRepositorioAdministrador {
	
	void cadastrar(Administrador administrador  );

	void remover(Administrador administrador);
	
	Administrador atualizar(Administrador administrador);

	Administrador procurar(long cpf);

	ArrayList<Administrador> getLista();

}
