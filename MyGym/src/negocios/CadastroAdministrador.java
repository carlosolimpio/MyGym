package negocios;

import java.sql.Connection;
import java.sql.SQLException;

import classesBasicas.Administrador;
import classesBasicas.Treinador;
import dados.Conexao;
import dados.IRepositorioAdministrador;
import dados.RepositorioAdministrador;
import excecoes.ObjetoJaExisteException;
import excecoes.ObjetoNaoExisteException;
import excecoes.UsuarioJaExisteException;

public class CadastroAdministrador {
	
	private static IRepositorioAdministrador repositorioAdministrador;
	public Connection conexao;

	public CadastroAdministrador() throws SQLException {
		this.repositorioAdministrador = RepositorioAdministrador.getInstance();
		this.conexao = Conexao.getConexao();
	}
	
	
	public void removerAdministrador(Long cpf ) throws ObjetoNaoExisteException{
		Administrador adm = repositorioAdministrador.procurar(cpf);
		if(adm != null){
			repositorioAdministrador.remover(adm);
		} else{
			throw new ObjetoNaoExisteException();
		}
	}

	public void cadastrarAdministrador(Administrador administrador) throws ObjetoJaExisteException, UsuarioJaExisteException, IllegalArgumentException{
		if (administrador == null) {
			throw new IllegalArgumentException("Parametro invalido");
		}  else if(CadastroPessoa.loginExiste(administrador.getLogin())){
			throw new UsuarioJaExisteException(administrador.getLogin());
		}else {
			Administrador administradorRetornar ;
			administradorRetornar = this.repositorioAdministrador.procurar(administrador.getCpf());


			if (administradorRetornar == null) {
				repositorioAdministrador.cadastrar(administrador);
			} else {
				throw new ObjetoJaExisteException(administrador);
			}
		}
	}

	public static void atualizarAdministrador(Administrador administrador) throws ObjetoNaoExisteException, IllegalArgumentException{
		if (administrador == null) {
			throw new IllegalArgumentException("Parametro invalido");
		} else {
			Administrador administradorRetornar;

			administradorRetornar = repositorioAdministrador.atualizar(administrador);

			if (administradorRetornar == null) {
				throw new ObjetoNaoExisteException();
			}
		}
	}
	
	public Administrador procurarAdministrador(long cpf) throws ObjetoNaoExisteException, IllegalArgumentException{
		if (cpf == 0) {
			throw new IllegalArgumentException("Parametro invalido");
		} else {
			Administrador administradorRetornar = this.repositorioAdministrador.procurar(cpf);
			if (administradorRetornar == null) {
			
			throw new ObjetoNaoExisteException();
			}
			
			return administradorRetornar;
		}
	}
	
	/*--------------------------------------------BANCO DE DADOS-------------------------------------------------*/
	
	public void bcCadastrarAdministrador(Administrador adm) throws SQLException, IllegalArgumentException, UsuarioJaExisteException, ObjetoJaExisteException{
		if (adm == null) {
			throw new IllegalArgumentException("Parametro invalido");
		} else if(CadastroPessoa.loginExiste(adm.getLogin())){
			throw new UsuarioJaExisteException(adm.getLogin());
		}else {
			Administrador administradorRetornar;

			administradorRetornar = repositorioAdministrador.bdProcurar(adm.getCpf(), this.conexao);

			if (administradorRetornar == null) {
				repositorioAdministrador.bdCadastrar(adm, this.conexao);
			} else {
				throw new ObjetoJaExisteException(adm);
			}
		}
	}
	
	public void bcRemoverAdministrador(Administrador adm) throws SQLException, ObjetoNaoExisteException {
		Administrador a = repositorioAdministrador.bdProcurar(adm.getCpf(), conexao);
		
		if(a != null) {
			repositorioAdministrador.bdRemover(adm.getCpf(), conexao);
		} else {
			throw new ObjetoNaoExisteException();
		}
	}
	
	public Administrador bcProcurarAdministrador(long cpf) throws SQLException, IllegalArgumentException, ObjetoNaoExisteException {
		if (cpf <= 0) {
			throw new IllegalArgumentException("Parametro invalido");
		} else {
			Administrador adm = repositorioAdministrador.bdProcurar(cpf, this.conexao);
			if(adm == null)
				throw new ObjetoNaoExisteException();
			
			return adm;
		}
	}
	
	public void bcAtualizarAdministrador(long cpf, Administrador novo) throws SQLException, IllegalArgumentException, ObjetoNaoExisteException {
		if(cpf <= 0)
			throw new IllegalArgumentException("Parametro Invalido!");
		else {
			Administrador a = this.bcProcurarAdministrador(cpf);
			if(a != null && novo != null)
				repositorioAdministrador.bdAtualizar(cpf, novo, this.conexao);
			else
				throw new ObjetoNaoExisteException();
		}
	}
}