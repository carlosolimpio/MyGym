package dados;

import java.sql.Connection;
import java.sql.ResultSet;
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
		Statement s = conexao.createStatement();
		
		//login
		s.execute("insert into Login(login, senha) values ('" 
				+ treinador.getLogin().getUsuario() + "', '"
				+ treinador.getLogin().getSenha() + "')");
		
		//pessoa
		s.execute("insert into Pessoa(nome, cpf, login_pessoa) values ('" 
				+ treinador.getNome() + "', '"
				+ aux.toString() + "', '"
				+ treinador.getLogin().getUsuario() + "')");
		
		//treinador
		s.execute("insert into Treinador(cpf_treinador) values ('" 
				+ aux.toString() + "')");
		
		s.close();
		conexao.close();
	}
	
	public void bdRemover(long cpf, Connection conexao) throws SQLException {
		Long aux = new Long(cpf);
		Statement s = conexao.createStatement();
		
		s.execute("delete from Pessoa where Pessoa.cpf = '" + aux.toString() + "';");
		
		s.close();
		conexao.close();
	}
	
	private boolean isTreinador(String cpf, Connection conexao) throws SQLException {
		/*
		 * Retorna True se o cpf do treinador existir no BD.
		 */
		boolean r = false;
		Statement s = conexao.createStatement();
		ResultSet rs = s.executeQuery("select Treinador.cpf_treinador from Treinador where Treinador.cpf_treinador = '" + cpf + "';");
		
		if(rs.next())
			r = true;
		
		return r;
	}
	
	public void bdAtualizar(long cpf, Treinador novo, Connection conexao) throws SQLException {
		this.bdRemover(cpf, conexao);
		this.bdCadastrar(novo, conexao);
		conexao.close();
	}
	
	public Treinador bdProcurar(long cpf, Connection conexao) throws SQLException {
		Treinador t = null;
		Long aux = new Long(cpf);
		Statement s = conexao.createStatement();
		
		if(isTreinador(aux.toString(), conexao)) {
			//retorna cpf, nome, login, senha treinador
			ResultSet rs = s.executeQuery("select Pessoa.cpf, Pessoa.nome, Login.login, Login.senha from Pessoa, Login where " 
					+ aux.toString() + " = Pessoa.cpf and Pessoa.login_pessoa = Login.login;");
			
			if(rs.next()) {
				String cpf_treinador = rs.getString("cpf");
				String nome = rs.getString("nome");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				
				Login l = new Login(login, senha);
				t = new Treinador(nome, cpf, l);
			}
		}
		s.close();
		conexao.close();
		return t;
	}
}
