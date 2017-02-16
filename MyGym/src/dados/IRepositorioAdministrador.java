package dados;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import classesBasicas.Administrador;;

public interface IRepositorioAdministrador {
	
	void cadastrar(Administrador administrador  );

	void remover(Administrador administrador);
	
	Administrador atualizar(Administrador administrador);

	Administrador procurar(long cpf);

	ArrayList<Administrador> getLista();
	
	/*-------------------------------BANCO DE DADOS---------------------------*/
	
	void bdCadastrar(Administrador adm, Connection conexao) throws SQLException;
	
	void bdRemover(long cpf, Connection conexao) throws SQLException;
	
	void bdAtualizar(long cpf, Administrador novo, Connection conexao) throws SQLException;
	
	Administrador bdProcurar(long cpf, Connection conexao) throws SQLException;

}
