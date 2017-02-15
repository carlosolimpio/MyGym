package gui;



import java.awt.Container;

import classesBasicas.Administrador;
import classesBasicas.Cliente;
import classesBasicas.Pessoa;
import classesBasicas.Treinador;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import negocios.IMyGymFachada;


public class AreaRestrita extends JFrame{
	
	private PainelAdministrador painelAdminstrador;
	private PainelCliente painelCliente;
	private PainelTreinador painelTreinador;
	public static Container painel;
	
	public AreaRestrita() {
		painelAdminstrador = new PainelAdministrador();
		painel = this.getContentPane();
		this.setBounds(0, 0, 710, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
public void carregarTela(Pessoa p ){
	if(p instanceof Treinador ){
		Treinador t = (Treinador)p; 
		
		painel.add(painelTreinador.painelTreinador(t));
	
		
	}else if(p instanceof Cliente ){
		Cliente c = (Cliente) p;
		painel.add(PainelCliente.painelCliente(c));
		
	}else if(p instanceof Administrador){
		Administrador a = (Administrador) p;
		painel.add(PainelAdministrador.painelAdministrador(a));
	
	}
}
}
