package dados;

import java.util.ArrayList;

import classesBasicas.Cliente;

public interface IRepositorioCliente {
	void cadastrar(Cliente cliente );

	void remover(Cliente cliente );
	
	Cliente atualizar(Cliente cliente);

	Cliente procurar(long cpf);

	ArrayList<Cliente> getLista();

	ArrayList<Cliente> listaClientesTreinador(long cpf);



}
