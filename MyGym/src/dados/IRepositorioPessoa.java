package dados;

import classesBasicas.Pessoa;

public interface IRepositorioPessoa {
	
	Pessoa procurar(String usuario, String senha);

	boolean procurarLogin(String Usuario);

	boolean procurarLoginExistente(String usuario);

	boolean procurarCpfExistente(long cpf);
}
