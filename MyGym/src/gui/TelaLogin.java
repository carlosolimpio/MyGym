package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import util.Seguranca;
import negocios.CadastroPessoa;
import negocios.IMyGymFachada;
import negocios.MyGymFachada;
import classesBasicas.Cliente;
import classesBasicas.Pessoa;
import classesBasicas.Treinador;
import dados.RepositorioPessoa;
import excecoes.ObjetoNaoExisteException;
import excecoes.SenhaNaoExisteException;
import excecoes.UsuarioOuSenhaIncorretosException;
import java.awt.Color;

public class TelaLogin extends JFrame{

	private JTextField textFieldLogin;
	private JPasswordField textFieldSenha;
	private AreaRestrita painel;

	public TelaLogin() {
		super("My Gym - Login");
		initialize();
	}
	private void initialize() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogin.setBounds(23, 62, 97, 25);
		this.getContentPane().add(lblLogin);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(23, 89, 180, 20);
		this.getContentPane().add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenha.setBounds(20, 120, 78, 25);
		this.getContentPane().add(lblSenha);
		
		textFieldSenha = new JPasswordField();
		textFieldSenha.setBounds(20, 147, 100, 20);
		this.getContentPane().add(textFieldSenha);
		textFieldSenha.setColumns(10);
	
		JButton btnOk = new JButton("entrar");
		btnOk.setBounds(130, 146, 73, 23);
		btnOk.setMnemonic('\n'); 
		this.getContentPane().add(btnOk);
		
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldLogin.getText().equals("") || textFieldSenha.getText().equals("")){
					JOptionPane.showMessageDialog(TelaLogin.this, "Digite seu login e sua senha");
				}else{
				Pessoa p;
					try {
						p = MyGymFachada.getInstance().logar(textFieldLogin.getText().toLowerCase(), Seguranca.md5(textFieldSenha.getText()));
						AdministracaoDeTelas.getAreaRestrita().carregarTela(p);
						AdministracaoDeTelas.administracaoDeTelas(TelaLogin.this, AdministracaoDeTelas.getAreaRestrita());// olhar metodo
					} catch (UsuarioOuSenhaIncorretosException e2) {
						JOptionPane.showMessageDialog(TelaLogin.this, e2.getMessage());
					} catch (ObjetoNaoExisteException e1) {
						JOptionPane.showMessageDialog(TelaLogin.this, e1.getMessage());
					}
				}
					
			}
		});
		
		JLabel lblMygym = new JLabel("MyGym");
		lblMygym.setForeground(new Color(165, 42, 42));
		lblMygym.setHorizontalAlignment(SwingConstants.CENTER);
		lblMygym.setFont(new Font("Stencil Std", Font.PLAIN, 50));
		lblMygym.setBounds(213, 77, 211, 60);
		getContentPane().add(lblMygym);
		
		JLabel lblSlogan = new JLabel("No pain no gain!");
		lblSlogan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlogan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSlogan.setBounds(213, 132, 211, 20);
		getContentPane().add(lblSlogan);
		
		
		
	}
}
