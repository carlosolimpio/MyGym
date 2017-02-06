package classesBasicas;

import java.io.Serializable;
import java.util.Calendar;

public class Login implements Serializable{

	private String login;
	private String senha;
	private int acessos;
	private String dataUltimoAcesso;
	
	public Login(String login, String senha) {
		
		setLogin(login);
		setSenha(senha);
		atualizarDataUltimoAcesso();
		acessos = 1;
	}
	
	public String getUsuario() {
		return login;
	}
	public String getSenha() {
		return senha;
	}
	public void setLogin(String login) {
		this.login = login.toLowerCase();
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void incrementarAcessos(){
		this.acessos++;
		atualizarDataUltimoAcesso();
	}
	
	public int getAcessos(){
		return this.acessos;
	}
	
	public String getDataUltimoAcesso(){
		return this.dataUltimoAcesso;
	} 
	
	private void atualizarDataUltimoAcesso(){
		this.dataUltimoAcesso = Calendar.getInstance().get(Calendar.DATE)+"/"+
								(Calendar.getInstance().get(Calendar.MONTH)+1)+"/"+
								Calendar.getInstance().get(Calendar.YEAR);
	}

}
