package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import util.Seguranca;
import classesBasicas.Administrador;
import classesBasicas.Login;
import excecoes.ObjetoJaExisteException;
import excecoes.UsuarioJaExisteException;
import negocios.MyGymFachada;

public class AdministracaoDeTelas {
	private static TelaLogin telaLogin;
	private static AreaRestrita areaRestrita;

	public AdministracaoDeTelas() {
		this.telaLogin = new TelaLogin();
		this.areaRestrita = new AreaRestrita();
	}

	public static TelaLogin getTelaLogin() {

		return telaLogin;
	}

	

	public static AreaRestrita getAreaRestrita() {

		return areaRestrita;
	}

	public static void administracaoDeTelas(Window fecha, Window abre) {
		if (fecha == null) {
			abre.setVisible(true);

		} else {
			fecha.setVisible(false);
			abre.setVisible(true);

		}
	}
	
	public static void logoAdd(JPanel painel){
		JLabel lblMygym = new JLabel("MyGym");
		lblMygym.setForeground(new Color(165, 42, 42));
		lblMygym.setHorizontalAlignment(SwingConstants.CENTER);
		lblMygym.setFont(new Font("Stencil Std", Font.PLAIN, 50));
		lblMygym.setBounds(473, 51, 211, 60);
		painel.add(lblMygym);
		
		JLabel lblSlogan = new JLabel("No pain no gain!");
		lblSlogan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlogan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSlogan.setBounds(473, 107, 211, 20);
		painel.add(lblSlogan);
	}

	public static void trocarTelas(Container f, JPanel p){
		f.removeAll();
		f.add(p);
		f.revalidate();
		f.repaint();
	}
	
	private static void initAdm(){
		try {
			MyGymFachada.getInstance().cadastraAdministrador(new Administrador("Adm", 1189997445, new Login("adm",Seguranca.md5("adm"))));
		} catch (ObjetoJaExisteException | UsuarioJaExisteException e) {
		}
	}

	public static void main(String[] args) {
		try {
			new AdministracaoDeTelas();
			initAdm();
			administracaoDeTelas(null, telaLogin);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
