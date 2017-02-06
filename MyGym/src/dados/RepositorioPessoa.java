package dados;

import java.util.ArrayList;

import classesBasicas.Aula;
import classesBasicas.Pessoa;

public class RepositorioPessoa implements IRepositorioPessoa{
	
	private static RepositorioPessoa repositorioLogin;
	private ArrayList<Pessoa> listaPessoas;

	public RepositorioPessoa() {
		listaPessoas = new ArrayList<Pessoa>();
	}
	
	public static IRepositorioPessoa getInstance() {
		if (repositorioLogin == null) {
			repositorioLogin = new RepositorioPessoa();
		}

		return repositorioLogin;
	}
	
	private ArrayList<Pessoa> getListaPessoas(){
		listaPessoas.addAll(RepositorioAdministrador.getInstance().getLista());
		listaPessoas.addAll(RepositorioCliente.getInstance().getLista()); // Adiciona a lista de cliente na lista de pessoa
		listaPessoas.addAll(RepositorioTreinador.getInstance().getLista()); // Adiciona a lesta de Treinador na lista de pessoa
		
		
		return listaPessoas;
	}
	
	
	@Override
	public Pessoa procurar(String email, String senha) {
		for (Pessoa pessoa : getListaPessoas()) {
			if(pessoa.getLogin().getUsuario().equals(email) && pessoa.getLogin().getSenha().equals(senha)){
				return pessoa;
			}
		}
		return null;
	}	
	
	
	@Override
	public boolean procurarLoginExistente(String usuario) {
	
		for (Pessoa pessoa : getListaPessoas()) {
			if(pessoa.getLogin().getUsuario().equals(usuario)){
				return true;
			}
		}
		return false;
	}
	
public boolean procurarCpfExistente(long cpf) {
		
		for (Pessoa pessoa : getListaPessoas()) {
			if(pessoa.getCpf() == cpf){
				return true;
			}
		}
		return false;
	}

@Override
public boolean procurarLogin(String Usuario) {
	// TODO Auto-generated method stub
	return false;
}
	






}
