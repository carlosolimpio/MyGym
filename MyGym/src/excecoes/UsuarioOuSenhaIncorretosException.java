package excecoes;

public class UsuarioOuSenhaIncorretosException extends Exception{
	public UsuarioOuSenhaIncorretosException(){
		
		super("Usuário e/ou senha incorretos");
	}

}
