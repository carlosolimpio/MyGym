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
	
}
