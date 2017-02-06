package negocios;

import classesBasicas.Administrador;
import dados.IRepositorioAdministrador;
import dados.RepositorioAdministrador;
import excecoes.ObjetoJaExisteException;
import excecoes.ObjetoNaoExisteException;
import excecoes.UsuarioJaExisteException;

public class CadastroAdministrador {
	
	private static IRepositorioAdministrador repositorioAdministrador;

	public CadastroAdministrador() {
		this.repositorioAdministrador = RepositorioAdministrador.getInstance();
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
}


