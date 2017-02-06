package negocios;


import java.util.ArrayList;

import classesBasicas.Cliente;
import dados.IRepositorioCliente;
import dados.RepositorioCliente;
import excecoes.ObjetoJaExisteException;
import excecoes.ObjetoNaoExisteException;
import excecoes.UsuarioJaExisteException;


public class CadastroCliente {

		private static IRepositorioCliente repositorioCliente;

		public CadastroCliente() {
			this.repositorioCliente = RepositorioCliente.getInstance();
		}
		
		
		public void removerCliente(long cpf ) throws ObjetoNaoExisteException {
			Cliente cliente = repositorioCliente.procurar(cpf);
			if(cliente!= null){
				CadastroTreino.removerTreinoPeloCliente(cliente);
				repositorioCliente.remover(cliente);
				
			}else{
				throw new ObjetoNaoExisteException();
			}
		
		}

		public void cadastrarCliente(Cliente cliente) throws ObjetoJaExisteException, UsuarioJaExisteException,IllegalArgumentException{
			if (cliente == null) {
				throw new IllegalArgumentException("Parametro invalido");
			}else if(CadastroPessoa.loginExiste(cliente.getLogin())){
				throw new UsuarioJaExisteException(cliente.getLogin());
			 } else {
				Cliente clienteRetornar;

				clienteRetornar = this.repositorioCliente.procurar(cliente.getCpf());

				if (clienteRetornar == null) {
					repositorioCliente.cadastrar(cliente);
				} else  {
					throw new ObjetoJaExisteException(cliente);
				}
			}
		}

		public static void atualizarCliente(Cliente cliente) throws ObjetoNaoExisteException,IllegalArgumentException{
			if (cliente == null) {
				throw new IllegalArgumentException("Parametro invalido");
			} else {
				Cliente clienteRetornar;

				clienteRetornar = repositorioCliente.atualizar(cliente);

				if (clienteRetornar == null) {
					throw new ObjetoNaoExisteException();
				}
			}
		}
		
		public Cliente procurarCliente(long cpf) throws ObjetoNaoExisteException,IllegalArgumentException{
			if (cpf == 0) {
				throw new IllegalArgumentException("Parametro invalido");
			} else {
				Cliente clienteRetornar = this.repositorioCliente.procurar(cpf);
				if (clienteRetornar == null) {
				
				throw new ObjetoNaoExisteException();
				}
				
				return clienteRetornar;
			}
		
	}


		public ArrayList<Cliente> listaClientesTreinador(long cpf) throws IllegalArgumentException{
			if(cpf == 0){
				
				throw new IllegalArgumentException("Parametro invalido");
			}else{
				return repositorioCliente.listaClientesTreinador(cpf);
			}
		}
}