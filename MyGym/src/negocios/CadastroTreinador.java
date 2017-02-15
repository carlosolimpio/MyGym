package negocios;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import classesBasicas.Treinador;
import dados.Conexao;
import dados.IRepositorioTreinador;
import dados.RepositorioTreinador;
import excecoes.ObjetoJaExisteException;
import excecoes.ObjetoNaoExisteException;
import excecoes.UsuarioJaExisteException;


	public class CadastroTreinador {

		private static IRepositorioTreinador repositorioTreinador;
		Connection conexao;

		public CadastroTreinador() throws SQLException{
			this.repositorioTreinador = RepositorioTreinador.getInstance();
			this.conexao = Conexao.getConexao();
		}
		
		public void removerTreinador(Long cpf) throws ObjetoNaoExisteException{
			Treinador t = repositorioTreinador.procurar(cpf);
			if(t != null){
				repositorioTreinador.remover(t);
			}else{
				throw new ObjetoNaoExisteException();
			}
			
		}

		public void cadastrarTreinador(Treinador treinador) throws ObjetoJaExisteException, UsuarioJaExisteException,IllegalArgumentException{
			if (treinador == null) {
				throw new IllegalArgumentException("Parametro invalido");
			} else if(CadastroPessoa.loginExiste(treinador.getLogin())){
				throw new UsuarioJaExisteException(treinador.getLogin());
			}else {
				Treinador treinadorRetornar;

				treinadorRetornar = this.repositorioTreinador.procurar(treinador.getCpf());

				if (treinadorRetornar == null) {
					repositorioTreinador.cadastrar(treinador);
				} else {
					throw new ObjetoJaExisteException(treinador);
				}
			}
		}

		public static void atualizarTreinador(Treinador treinador) throws ObjetoNaoExisteException,IllegalArgumentException {
			if (treinador == null) {
				throw new IllegalArgumentException("Parametro invalido");
			} else {
				Treinador treinadorRetornar;

				treinadorRetornar = repositorioTreinador.atualizar(treinador);

				if (treinadorRetornar == null) {
					throw new ObjetoNaoExisteException();
				}
			}
		}
		
		public Treinador procurarTreinador(long cpf) throws ObjetoNaoExisteException,IllegalArgumentException{
			if (cpf == 0) {
				throw new IllegalArgumentException("Parametro invalido");
			} else {
				Treinador treinadorRetornar = this.repositorioTreinador.procurar(cpf);;


				if (treinadorRetornar == null) {
					
				throw new ObjetoNaoExisteException();
				}
			return treinadorRetornar;
			}
			
		
	}
		
	/*---------------------------BANCO DE DADOS--------------------------------*/
	
	public void bcCadastraTreinador(Treinador treinador) throws SQLException, IllegalArgumentException, UsuarioJaExisteException, ObjetoJaExisteException{
		if (treinador == null) {
			throw new IllegalArgumentException("Parametro invalido");
		} else if(CadastroPessoa.loginExiste(treinador.getLogin())){
			throw new UsuarioJaExisteException(treinador.getLogin());
		}else {
			Treinador treinadorRetornar;

			treinadorRetornar = this.conexao.bdProcurar(treinador.getCpf());

			if (treinadorRetornar == null) {
				repositorioTreinador.bdCadastrar(treinador, conexao);
			} else {
				throw new ObjetoJaExisteException(treinador);
			}
		}
	}
		
		
		
}