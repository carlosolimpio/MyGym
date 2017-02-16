package dados;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import classesBasicas.Administrador;
import classesBasicas.Login;
import classesBasicas.Treinador;

public class RepositorioAdministrador extends Repositorio<Administrador> implements IRepositorioAdministrador{

	private static RepositorioAdministrador repositorioAdministrador;
	
	public RepositorioAdministrador() {
		super("Administrador");
		
	}
		public static IRepositorioAdministrador getInstance() {
			if (repositorioAdministrador == null) {
				repositorioAdministrador = new RepositorioAdministrador();
			}

			return repositorioAdministrador;
		}
		 
		@Override
		public void cadastrar(Administrador administrador) {
			super.cadastrar(administrador); // chama repositorio para cadastrar um objeto
		}
		
		@Override
		public void remover(Administrador administrador) {
			super.remover(administrador); // chama repositorio para remover um objeto
		}
		
		@Override
		public Administrador procurar(long cpf) {
			for (Administrador administrador : super.getLista()) {
				if(administrador.getCpf() == cpf){
					return administrador;
				}
			}
			return null;
		}
		
		@Override
		public Administrador atualizar(Administrador administrador) {
			
			return super.atualizar(administrador); // chama repositorio para atualizar um objeto
		}

		/*------------------------------------------BANCO DE DADOS-----------------------------------------------*/
		
		public void bdCadastrar(Administrador adm, Connection conexao) throws SQLException {	
			
			Long aux = new Long(adm.getCpf());
			Statement s = conexao.createStatement();
			
			//login
			s.execute("insert into Login(login, senha) values ('" 
					+ adm.getLogin().getUsuario() + "', '"
					+ adm.getLogin().getSenha() + "')");
			
			//pessoa
			s.execute("insert into Pessoa(nome, cpf, login_pessoa) values ('" 
					+ adm.getNome() + "', '"
					+ aux.toString() + "', '"
					+ adm.getLogin().getUsuario() + "')");
			
			//administrador
			s.execute("insert into Administrador(cpf_administrador) values ('" 
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
		
		private boolean isAdministrador(String cpf, Connection conexao) throws SQLException {
			/*
			 * Retorna True se o cpf do administrador existir no BD.
			 */
			boolean r = false;
			Statement s = conexao.createStatement();
			ResultSet rs = s.executeQuery("select Administrador.cpf_administrador from Administrador where Administrador.cpf_administrador = '" 
					+ cpf + "';");
			
			if(rs.next())
				r = true;
			
			return r;
		}
		
		public void bdAtualizar(long cpf, Administrador novo, Connection conexao) throws SQLException {
			this.bdRemover(cpf, conexao);
			this.bdCadastrar(novo, conexao);
			conexao.close();
		}
		
		public Administrador bdProcurar(long cpf, Connection conexao) throws SQLException {
			Administrador a = null;
			Long aux = new Long(cpf);
			Statement s = conexao.createStatement();
			
			if(isAdministrador(aux.toString(), conexao)) {
				//retorna cpf, nome, login, senha ADM
				ResultSet rs = s.executeQuery("select Pessoa.cpf, Pessoa.nome, Login.login, Login.senha from Pessoa, Login where " 
						+ aux.toString() + " = Pessoa.cpf and Pessoa.login_pessoa = Login.login;");
				
				if(rs.next()) {
					String cpf_adminsitrador = rs.getString("cpf");
					String nome = rs.getString("nome");
					String login = rs.getString("login");
					String senha = rs.getString("senha");
					
					Login l = new Login(login, senha);
					a = new Administrador(nome, cpf, l);
				}
			}
			s.close();
			conexao.close();
			return a;
		}

	}


