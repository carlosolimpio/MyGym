package dados;

import java.util.ArrayList;

import classesBasicas.Cliente;
import classesBasicas.Pessoa;



	public class RepositorioCliente extends Repositorio<Cliente> implements IRepositorioCliente{
		
		private static RepositorioCliente repositorioCliente;
		private ArrayList<Cliente> listaClientes;
		private ArrayList<String> listaDeClientesTreinador;

		public RepositorioCliente() {
			super("Cliente");
		}
		
		public static IRepositorioCliente getInstance() {
			if (repositorioCliente == null) {
				repositorioCliente = new RepositorioCliente();
			}

			return repositorioCliente;
		}
		
		@Override
		public void cadastrar(Cliente cliente) {
			super.cadastrar(cliente); // chama repositorio para cadastrar um objeto
		}
		
		@Override
		public void remover(Cliente cliente) {
			
			super.remover(cliente); // chama repositorio para remover um objeto
		}
		
		@Override
		public Cliente procurar(long cpf) {
			for (Cliente cliente : super.getLista()) {
				if(cliente.getCpf() == cpf){
					return cliente;
				}
			}
			return null;
		}
		
		@Override
		public Cliente atualizar(Cliente cliente) {
			
			return super.atualizar(cliente); // chama repositorio para atualizar um objeto
		}
		
		public ArrayList<Cliente> getLitaCliente(){

			listaClientes.addAll(RepositorioCliente.getInstance().getLista()); // Adiciona a lista de cliente na lista de pessoa
		
			return listaClientes;
		}
		
	
			
			@Override
			public ArrayList<Cliente> listaClientesTreinador(long cpf) {
				ArrayList<Cliente> listaDeClientesTreinador = new ArrayList<Cliente>();
				for(Cliente c : super.getLista()){
					if(c.getTreinador().getCpf() == cpf){
						listaDeClientesTreinador.add(c);
					}
				}
				return listaDeClientesTreinador;
			}		
		}
	


