package negocios;

import java.util.ArrayList;

import classesBasicas.Aula;
import classesBasicas.Cliente;
import classesBasicas.Pessoa;
import classesBasicas.Treinador;
import classesBasicas.Treino;
import excecoes.ObjetoJaExisteException;
import excecoes.ObjetoNaoExisteException;
import excecoes.SenhaNaoExisteException;
import excecoes.UsuarioJaExisteException;
import excecoes.UsuarioOuSenhaIncorretosException;


public interface IMyGymFachada {
	// CLIENTE 
	void cadastrarCliente(Cliente cliente) throws ObjetoJaExisteException, UsuarioJaExisteException,IllegalArgumentException;
	
	void removerCliente(Long cpf) throws ObjetoNaoExisteException;
	
	void atualizarCliente(Cliente cliente) throws ObjetoNaoExisteException,IllegalArgumentException;
	
	Cliente procurarCliente(long cpf) throws ObjetoNaoExisteException,IllegalArgumentException;
	
	// TREINADOR
	void cadastrarTreinador(Treinador treinador) throws ObjetoJaExisteException, UsuarioJaExisteException,IllegalArgumentException;
	
	void removerTreinador(Long cpf) throws ObjetoNaoExisteException;
	
	void atualizarTreinador(Treinador treinador ) throws ObjetoNaoExisteException,IllegalArgumentException;
	
	Treinador procurarTreinador(long cpf) throws ObjetoNaoExisteException,IllegalArgumentException;
	
	ArrayList<Cliente> listaClientesTreinador(long cpf);
	// AULAS
	void cadastrarAulas(Aula aulas) throws ObjetoJaExisteException,IllegalArgumentException;
	
	void removerAulas(String nome) throws ObjetoNaoExisteException;
	
	void atualizarAulas(Aula aula) throws ObjetoNaoExisteException,IllegalArgumentException;
	
	Aula procurarAulas(String nome ) throws ObjetoNaoExisteException,IllegalArgumentException;
	// TREINO
	// TREINO
	void cadastrarTreino(Treino treino) throws ObjetoJaExisteException;
	
	void removerTreino(String nome) throws ObjetoNaoExisteException;
	
	void atualizarTreino(Treino treino) throws ObjetoNaoExisteException;
	
	Treino procurarTreino(String nome ) throws ObjetoNaoExisteException;
	
	ArrayList<Treino> procurarTreinoPeloCliente(Cliente c);
	
	
	// LOGIN
	Pessoa logar(String usuario, String senha) throws UsuarioOuSenhaIncorretosException, ObjetoNaoExisteException,IllegalArgumentException;
	
	boolean procurarLoginExistente(String usuario);
	
	boolean procurarCpfExistente(Long cpf);
	
}
