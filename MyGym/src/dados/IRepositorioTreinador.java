package dados;

import java.sql.Connection;
import java.sql.SQLException;

import classesBasicas.Treinador;

public interface IRepositorioTreinador {
	
	void cadastrar(Treinador treinador);

	void remover(Treinador treinador);
	
	Treinador atualizar(Treinador treinador);

	Treinador procurar(long cpf);
	
	/*--------------------BANCO DE DADOS-----------------------*/
	
	void bdCadastrar(Treinador treinador, Connection conexao) throws SQLException;
	
	void bdRemover(long cpf, Connection conexao) throws SQLException;
	
	Treinador bdProcurar(long cpf, Connection conexao) throws SQLException;
	
	void bdAtualizar(long cpf, Treinador novo, Connection conexao) throws SQLException;
	
}
