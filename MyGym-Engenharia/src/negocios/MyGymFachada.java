package negocios;

import java.util.ArrayList;

import classesBasicas.Administrador;
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




public class MyGymFachada implements IMyGymFachada{
	private static MyGymFachada instance;
	private CadastroCliente cadastroCliente;
	private CadastroAula cadastroAula;
	private CadastroTreinador cadastroTreinador;
	private CadastroTreino cadastroTreino;
	private CadastroPessoa cadastroPessoa;
	private CadastroAdministrador cadastroAdministrador;
	
	public MyGymFachada(){
		cadastroCliente = new CadastroCliente();
		cadastroAula = new CadastroAula();
		cadastroTreinador = new CadastroTreinador();
		cadastroTreino = new CadastroTreino();
		cadastroPessoa = new CadastroPessoa();
		cadastroAdministrador = new CadastroAdministrador();
		
	}
	
	 public static MyGymFachada getInstance() {
	    	if (instance == null) {
				instance = new MyGymFachada();
			}
	    	return instance;
	    }
	 
	 //CADASTRO CLIENTE
	 public void cadastrarCliente(Cliente cliente) throws ObjetoJaExisteException, UsuarioJaExisteException,IllegalArgumentException{
	
		 cadastroCliente.cadastrarCliente(cliente);
	 }
	 
	 public void removerCliente(Long cpf) throws ObjetoNaoExisteException{
		 cadastroCliente.removerCliente(cpf);
	 }
	 public void atualizarCliente(Cliente cliente)throws ObjetoNaoExisteException,IllegalArgumentException{
		 
		 cadastroCliente.atualizarCliente(cliente);
	 }
	 
	 public Cliente procurarCliente(long cpf)throws ObjetoNaoExisteException,IllegalArgumentException{
		 return cadastroCliente.procurarCliente(cpf);
	 }
	 
	 // CADASTRO TREINADOR
	 public void cadastrarTreinador(Treinador treinador)throws  ObjetoJaExisteException, UsuarioJaExisteException, IllegalArgumentException{
		 cadastroTreinador.cadastrarTreinador(treinador);
	 }
	 public void removerTreinador(Long cpf) throws ObjetoNaoExisteException{
		 cadastroTreinador.removerTreinador(cpf);
	 }
	 public void atualizarTreinador(Treinador treinador )throws ObjetoNaoExisteException,IllegalArgumentException{
		 
		 cadastroTreinador.atualizarTreinador(treinador);
	 }

	 public ArrayList<Cliente> listaClientesTreinador(long cpf) {
			return cadastroCliente.listaClientesTreinador(cpf);
		}
	 
	 public Treinador procurarTreinador(long cpf)throws ObjetoNaoExisteException, IllegalArgumentException{
		 return cadastroTreinador.procurarTreinador(cpf);
	 }
	 // CADASTRO AULA
	 public void cadastrarAulas(Aula aulas)throws ObjetoJaExisteException,IllegalArgumentException{
		 cadastroAula.cadastrarAulas(aulas);
	 }
	 public void removerAulas(String nome) throws ObjetoNaoExisteException{
		 cadastroAula.removerAula(nome);
	 }
	 
	 public void atualizarAulas(Aula aulas )throws ObjetoNaoExisteException,IllegalArgumentException{
		 
		 cadastroAula.atualizarAulas(aulas);
	 }
	 
	 public ArrayList<Aula> listaAulas() {
		 return cadastroAula.listaDeAulas();
	 }
	 
	 public Aula procurarAulas(String nome)throws ObjetoNaoExisteException,IllegalArgumentException{
		 return cadastroAula.procurarAula(nome);
	 }
	 // CADASTRO TREINO 
	 public void cadastrarTreino(Treino treino)throws  ObjetoJaExisteException,IllegalArgumentException{
		 cadastroTreino.cadastrarTreino(treino);
	 }
	 public void removerTreino(String nomeTreino) throws ObjetoNaoExisteException{
		 cadastroTreino.removerTreino(nomeTreino);
	 }
	 
	 public void atualizarTreino(Treino treino)throws ObjetoNaoExisteException,IllegalArgumentException{
		 
		 cadastroTreino.atualizarTreino(treino);
	 }
	 
	 
	 public ArrayList<Treino> procurarTreinoPeloCliente(Cliente c ){
		 return cadastroTreino.procurarTreinoPeloCliente(c);
	 }
	 
	 public Treino procurarTreino(String nome )throws ObjetoNaoExisteException,IllegalArgumentException{
		 return cadastroTreino.procurarTreino(nome);
	 }
	 
	 // CADASTRO LOGIN 
	 public Pessoa logar(String usuario, String senha) throws UsuarioOuSenhaIncorretosException, ObjetoNaoExisteException{
		 return cadastroPessoa.procurarLogin(usuario, senha);
	 }
	 @Override
		public boolean procurarLoginExistente(String usuario) {
			
			return cadastroPessoa.procurarLoginExiste(usuario);
		}
	 public boolean procurarCpfExistente(Long cpf) {
			// TODO Auto-generated method stub
			return cadastroPessoa.procurarCpfExiste(cpf);
		}
	 
	// CADASTRO ADMINISTRADOR
	 
	 public void cadastraAdministrador(Administrador administrador)throws ObjetoJaExisteException, UsuarioJaExisteException,IllegalArgumentException{
		 cadastroAdministrador.cadastrarAdministrador(administrador);
	 }
	 public void removerAdministrador(Long cpf)throws ObjetoNaoExisteException{
		 cadastroAdministrador.removerAdministrador(cpf);
	 }
	 
	 public void atualizarAdministrador(Administrador administrador)throws ObjetoNaoExisteException,IllegalArgumentException{
		 cadastroAdministrador.atualizarAdministrador(administrador);
	 }
	 public Administrador procurarAdministrador(long cpf)throws ObjetoNaoExisteException, IllegalArgumentException{
		 return cadastroAdministrador.procurarAdministrador(cpf);
	 }





	}
	
	