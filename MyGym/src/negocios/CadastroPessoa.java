package negocios;

import java.util.Calendar;
import java.util.Date;

import classesBasicas.Administrador;
import classesBasicas.Cliente;
import classesBasicas.Entidade;
import classesBasicas.Login;
import classesBasicas.Pessoa;
import classesBasicas.Treinador;
import dados.IRepositorioPessoa;
import dados.RepositorioCliente;
import dados.RepositorioPessoa;
import excecoes.ObjetoNaoExisteException;
import excecoes.SenhaNaoExisteException;
import excecoes.UsuarioOuSenhaIncorretosException;
import gui.PainelAdministrador;
import gui.PainelCliente;

public class CadastroPessoa {
	
	private static IRepositorioPessoa repositorioLogin;
	
	public CadastroPessoa() {
		this.repositorioLogin = RepositorioPessoa.getInstance();
	}
	
	public Pessoa procurarLogin(String usuario,String senha) throws UsuarioOuSenhaIncorretosException, ObjetoNaoExisteException{
		
		
		if (usuario.equals(null) && senha.equals(null)) {
			throw new IllegalArgumentException("Parametro invalido");
		} else {
			Pessoa pessoaRetornar = this.repositorioLogin.procurar(usuario,senha);
			
			if (pessoaRetornar == null) {
				throw new UsuarioOuSenhaIncorretosException();
			}else{
			
								
				if(pessoaRetornar instanceof Treinador ){
					Treinador t = (Treinador) pessoaRetornar; 					
					if(!t.getLogin().getDataUltimoAcesso().equals(dataHoje())){
						t.getLogin().incrementarAcessos();
						CadastroTreinador.atualizarTreinador(t);
					}				
				}else if(pessoaRetornar instanceof Cliente ){
					Cliente c = (Cliente) pessoaRetornar;
					if(!c.getLogin().getDataUltimoAcesso().equals(dataHoje())){
						c.getLogin().incrementarAcessos();
						CadastroCliente.atualizarCliente(c);
					}
				}else if(pessoaRetornar instanceof Administrador){
					Administrador a = (Administrador) pessoaRetornar;
					if(!a.getLogin().getDataUltimoAcesso().equals(dataHoje())){
						a.getLogin().incrementarAcessos();
						CadastroAdministrador.atualizarAdministrador(a);
					}
				}
				return pessoaRetornar;
			}
		}
		
	}
	
	private String dataHoje(){
		return Calendar.getInstance().get(Calendar.DATE)+"/"+
			   (Calendar.getInstance().get(Calendar.MONTH)+1)+"/"+
			   Calendar.getInstance().get(Calendar.YEAR);
	}
		public static boolean loginExiste(Login l){
			if (l == null) {
				throw new IllegalArgumentException("Parametro invalido");
			} else {
			
				if (repositorioLogin.procurarLoginExistente(l.getUsuario())) {
					return true;
				}else{
					return false;
				}
			}
			
		}
		
	public boolean procurarLoginExiste(String usuario){
		
		return repositorioLogin.procurarLoginExistente(usuario);
	}

	public boolean procurarCpfExiste(Long cpf) {
		
		return repositorioLogin.procurarCpfExistente(cpf);
	}


	
	}

	