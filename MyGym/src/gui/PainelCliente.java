package gui;
import gui.AdministracaoDeTelas;
import gui.AreaRestrita;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import classesBasicas.Aula;
import classesBasicas.Cliente;
import classesBasicas.Treino;
import negocios.MyGymFachada;

public class PainelCliente extends JPanel {
	
	public static JPanel 
	painelExibirTreino,
	painelExibirAula,
	painelCliente;
 

public PainelCliente(){

	painelExibirTreino = exibirTreino(null);
	painelCliente = painelCliente(null);
	painelExibirAula = exibirAula(null);
	
	}
	
	public static JPanel inicio() {
		return null;
	}

 private static JMenuBar MenuCliente(final Cliente c) {
	JMenuBar menuBar = new JMenuBar();
	menuBar.setBounds(0, 0, 710, 30);
		
		JMenu mnTreino = new JMenu("Menu");
		mnTreino.setBounds(0, 0, 107, 22);
		menuBar.add(mnTreino);
		
		JMenuItem mntmInicio = new JMenuItem("Início");
		mnTreino.add(mntmInicio);
		
		mntmInicio.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) { 
            	AdministracaoDeTelas.trocarTelas(AreaRestrita.painel, painelCliente(c));
            }    
		});
		
		JMenuItem mntmCadastrarTreino = new JMenuItem("Treinos");
		mnTreino.add(mntmCadastrarTreino);
		
		mntmCadastrarTreino.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) { 
            	AdministracaoDeTelas.trocarTelas(AreaRestrita.painel, exibirTreino(c));
            }    
		});
		
		JMenuItem mntmAula = new JMenuItem("Aulas Extras");
		mnTreino.add(mntmAula);
		
		mntmAula.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) { 
            	AdministracaoDeTelas.trocarTelas(AreaRestrita.painel, exibirAula(c));
            }    
		});
		
		menuBar.setVisible(true);

		return menuBar;
			
		}
		
 public static JPanel painelCliente(Cliente c){
		JPanel painel = new JPanel();
		painel.setBounds(0, 0, 710, 400);
		painel.setLayout(null);
		
		painel.add(MenuCliente(c));
		
		AdministracaoDeTelas.logoAdd(painel);
		
		JLabel lblOla = new JLabel("Seja bem-vindo novamente,");
		lblOla.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblOla.setBounds(10, 60, 661, 45);
		painel.add(lblOla);
		
		JLabel lblNome = new JLabel(c.getNome());
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNome.setBounds(10, 109, 661, 45);
		painel.add(lblNome);
		
		JLabel lblNewLabel_1 = new JLabel("Email: " + c.getEmail() );
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 165, 319, 32);
		painel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Acesso: " + c.getLogin().getDataUltimoAcesso());
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 231, 302, 20);
		painel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Login: " + c.getLogin().getUsuario());
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 280, 496, 26);
		painel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone: " + c.getTelefone() );
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(10, 340, 547, 20);
		painel.add(lblNewLabel_4);
		
		painel.setVisible(true);
		return painel;
		
 }
 


public static JPanel exibirTreino(Cliente c){
	
		
		JPanel painel = new JPanel();
		painel.setBounds(0, 0, 710, 400);
		painel.setLayout(null);
		
		painel.add(MenuCliente(c));
		
		AdministracaoDeTelas.logoAdd(painel);
		
		JLabel lblNewLabel = new JLabel("Treinos:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 112, 154, 43);
		painel.add(lblNewLabel);
		
		String registro ="";
		
		ArrayList<Treino> listaTreino = MyGymFachada.getInstance().procurarTreinoPeloCliente(c);
		String resultado = "";
		if(listaTreino.size() == 0){
			resultado = "Nenhum treino cadastrado";
		}else{
			for (Treino treino : listaTreino) {
				resultado += "Nome do Treino:" + treino.getNomeTreino() + "\n" + "Exercício: "+treino.getNomeExercicio()+"\n"+ 
							 "Repetições: "+treino.getRepeticao()+"\n"+
							 "___________________________________________________________\n";
			}
		}
		TextArea areaRegistros = new TextArea(""+resultado);
		areaRegistros.setEditable(false);
		areaRegistros.setBackground(new Color(255,255,255));
		areaRegistros.setBounds(0, 161, 694, 427);
		painel.add(areaRegistros);
		
		return painel;
 }

public static JPanel exibirAula(Cliente c){
	
	
	JPanel painel = new JPanel();
	painel.setBounds(0, 0, 710, 400);
	painel.setLayout(null);
	
	painel.add(MenuCliente(c));
	
	AdministracaoDeTelas.logoAdd(painel);
	
	JLabel lblNewLabel = new JLabel("Aulas Extras:");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
	lblNewLabel.setBounds(10, 112, 200, 43);
	painel.add(lblNewLabel);
	
	String registro ="";
	ArrayList<Aula> listaAula = MyGymFachada.getInstance().listaAulas();
	
	String resultado = "";
	if(listaAula.size() == 0){
		resultado = "Nenhuma Aula cadastrada";
	}else{
		for (Aula aula : listaAula) {
			resultado += "Nome do Treino : " + aula.getNomeDaAula() + "-" + " Dia da Aula: "+aula.getDiaDaSemana()+ 
						 " às : "+ aula.getHoraDaAula() +"\n"+
						 "___________________________________________________________\n";
		}
	}
	TextArea areaRegistros = new TextArea(""+resultado);
	areaRegistros.setEditable(false);
	areaRegistros.setBackground(new Color(255,255,255));
	areaRegistros.setBounds(0, 161, 694, 427);
	painel.add(areaRegistros);
	
	return painel;
}


 
}