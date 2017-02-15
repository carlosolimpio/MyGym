package dados;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import classesBasicas.Login;
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
	
	/*------------------------------------BANCO DE DADOS---------------------------------------*/
	
	public void bdCadastrar(Treinador treinador, Connection conexao) throws SQLException {	
		
		Long aux = new Long(treinador.getCpf());
		
		Statement simpleStatement = conexao.createStatement();
		
		//login
		simpleStatement.execute("insert into Login(login, senha) values ('" 
				+ treinador.getLogin().getUsuario() + "', '"
				+ treinador.getLogin().getSenha() + "')");
		
		//pessoa
		simpleStatement.execute("insert into Pessoa(nome, cpf, login_pessoa) values ('" 
				+ treinador.getNome() + "', '"
				+ aux.toString() + "', '"
				+ treinador.getLogin().getUsuario() + "')");
		
		//treinador
		simpleStatement.execute("insert into Treinador(cpf_treinador) values ('" 
				+ aux.toString() + "')");
	}
	
	public static void main(String[] args) {
		Login l = new Login("tam", "123");
		Treinador t = new Treinador("Tamires", 1234577, l);
		
		RepositorioTreinador r = new RepositorioTreinador();
		
		try { 
			 r.bdCadastrar(t, Conexao.getConexao());
		 } catch (SQLException e) {
			 System.out.println("error");
		 }
		
	}
}
