package gui;
 

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import classesBasicas.Aula;
import classesBasicas.Cliente;
import classesBasicas.Treinador;
import classesBasicas.Treino;
import negocios.MyGymFachada;
import excecoes.ObjetoJaExisteException;
import excecoes.ObjetoNaoExisteException;

public class PainelTreinador extends JPanel {
	
	public static JPanel 
	painelTreinador, 
	cadastrarTreino,
	removerTreino, 
	procurarTreino, 
	listaAlunos;
	

	
	public PainelTreinador(){
		painelTreinador = painelTreinador(null);
		cadastrarTreino = cadastrarTreino(null);
		removerTreino = removerTreino(null);
		procurarTreino = exibirTreino(null);
		listaAlunos = exibirListaDeClientes(null);
		
	}
	
	public static JPanel inicio() {
		return null;
	}

 private static JMenuBar MenuTreinador(final Treinador t) {
	JMenuBar menuBar = new JMenuBar();
	menuBar.setBounds(0, 0, 710, 30);
		
		JMenu mnTreino = new JMenu("Treino");
		mnTreino.setBounds(0, 0, 107, 22);
		menuBar.add(mnTreino);
		
		JMenuItem mntmCadastrarTreino = new JMenuItem("Cadastrar Treino");
		mnTreino.add(mntmCadastrarTreino);
		
		mntmCadastrarTreino.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) { 
            	AdministracaoDeTelas.trocarTelas(AreaRestrita.painel,cadastrarTreino(t));
            }    
		});
		
		JMenuItem mntmExibirTreino = new JMenuItem("Exibir Treino");
		mnTreino.add(mntmExibirTreino);
		mntmExibirTreino.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) { 
            	AdministracaoDeTelas.trocarTelas(AreaRestrita.painel, exibirTreino(t));
            }    
		});

		JMenuItem mntmRemoverTreino = new JMenuItem("Remover Treino");
		mnTreino.add(mntmRemoverTreino);
		
		mntmRemoverTreino.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) { 
            	AdministracaoDeTelas.trocarTelas(AreaRestrita.painel,removerTreino(t));
            }    
		});
		
		
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setBounds(0, 33, 107, 23);
		menuBar.add(btnClientes);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AdministracaoDeTelas.trocarTelas(AreaRestrita.painel,listaAulos(t));;
			}
		});
		
		menuBar.setVisible(true);

		return menuBar;
			
		}
 
 	public static JPanel painelTreinador(Treinador t){
		JPanel painel = new JPanel();
		painel.setBounds(0, 0, 710, 400);
		painel.setLayout(null);
		
		painel.add(MenuTreinador(t));
				
		AdministracaoDeTelas.logoAdd(painel);
		
		JLabel lblOla = new JLabel("Seja bem-vindo novamente,");
		lblOla.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblOla.setBounds(10, 60, 661, 45);
		painel.add(lblOla);
		
		JLabel lblNome = new JLabel(t.getNome());
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNome.setBounds(10, 109, 661, 45);
		painel.add(lblNome);
		
		JLabel lblNewLabel = new JLabel("CPF : " + t.getCpf());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 160, 319, 32);
		painel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Acesso: " + t.getLogin().getDataUltimoAcesso());
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 200, 302, 20);
		painel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Usuario : " + t.getLogin().getUsuario());
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 230, 319, 32);
		painel.add(lblNewLabel_3);
		
		

		
		painel.setVisible(true);
		
		return painel;
	}

 	public static JPanel cadastrarTreino(Treinador t){
		
		final JTextField textFieldCpfCadastroTreino;
		final JTextField textFieldNomeExercicio;
		final JTextField textFieldRepeticoes;
		final JTextField textFieldNomeTreino;
		
		JPanel painel = new JPanel();
		painel.setBounds(0, 0, 710, 400);
		painel.setLayout(null);
		
		painel.add(MenuTreinador(t));
		
		AdministracaoDeTelas.logoAdd(painel);
		
		JLabel lblTreinoCadastrar = new JLabel("Treino");
		lblTreinoCadastrar.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblTreinoCadastrar.setBounds(10, 41, 178, 25);
		painel.add(lblTreinoCadastrar);
		
		JLabel lblCpfClienteCadastrarTreino = new JLabel("Digite o CPF do Cliente para criar um treino:");
		lblCpfClienteCadastrarTreino.setBounds(10, 71, 350, 14);
		painel.add(lblCpfClienteCadastrarTreino);
		
		textFieldCpfCadastroTreino = new JTextField();
		textFieldCpfCadastroTreino.setBounds(10, 106, 205, 20);
		painel.add(textFieldCpfCadastroTreino);
		textFieldCpfCadastroTreino.setColumns(10);
		
		JLabel lblNomeDoTreino = new JLabel("Nome do Treino: ");
		lblNomeDoTreino.setBounds(10, 136, 200, 14);
		painel.add(lblNomeDoTreino);
		
		textFieldNomeTreino = new JTextField();
		textFieldNomeTreino.setBounds(10, 166, 205, 20);
		painel.add(textFieldNomeTreino);
		textFieldNomeTreino.setColumns(10);
		
		JLabel lblNomeDoExercicio = new JLabel("Nome do Exercicio:");
		lblNomeDoExercicio.setBounds(10, 196, 200, 14);
		painel.add(lblNomeDoExercicio);
		
		textFieldNomeExercicio = new JTextField();
		textFieldNomeExercicio.setBounds(10, 226, 153, 20);
		painel.add(textFieldNomeExercicio);
		textFieldNomeExercicio.setColumns(10);
		
		JLabel lblNmeroDeRepeties = new JLabel("N\u00FAmero de Repeti\u00E7\u00F5es:");
		lblNmeroDeRepeties.setBounds(10, 256, 200, 20);
		painel.add(lblNmeroDeRepeties);
		
		final JComboBox comboRep = new JComboBox();
		comboRep.setBackground(new Color(255,255,255));
		comboRep.setBounds(10, 286, 153, 20);
		for (int i = 5; i < 105; i++) {
			if(i%5 == 0){
				comboRep.addItem(""+i);
			}
		}
		
		comboRep.setSelectedIndex(0);
		painel.add(comboRep);
				
		JButton btnCancelar = new JButton("Limpar");
		btnCancelar.setBounds(10, 316, 89, 23);
		
		painel.add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {  
	        @Override       
	        public void actionPerformed(ActionEvent evt) {
		textFieldCpfCadastroTreino.setText("");
    	textFieldNomeExercicio.setText("");
    	textFieldNomeTreino.setText("");
    	comboRep.setSelectedIndex(0);
	        }
	    		});
    	
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(164, 316, 100, 23);
		painel.add(btnCadastrar);
		
		
		btnCadastrar.addActionListener(new ActionListener() {  
	        @Override       
	        public void actionPerformed(ActionEvent evt) {
	        	if(textFieldNomeExercicio.getText().equals("")|| textFieldCpfCadastroTreino.getText().equals("") || textFieldCpfCadastroTreino.getText().equals("")){
	        		JOptionPane.showMessageDialog(null, "Digite todos os campos");
	        	}else{
	     
	        		try {
						MyGymFachada.getInstance().cadastrarTreino(new Treino (textFieldNomeTreino.getText(), textFieldNomeExercicio.getText(), Integer.parseInt(comboRep.getSelectedItem().toString()), MyGymFachada.getInstance().procurarCliente(Long.parseLong(textFieldCpfCadastroTreino.getText()))));
						JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");
		            	textFieldCpfCadastroTreino.setText("");
		            	textFieldNomeExercicio.setText("");
		            	textFieldNomeTreino.setText("");
		            	comboRep.setSelectedIndex(0);
					} catch (ObjetoJaExisteException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}catch(NumberFormatException e){
	        		JOptionPane.showMessageDialog(null, "Campo de CPF aceita apenas números");
					} catch (ObjetoNaoExisteException e) {
	        		JOptionPane.showMessageDialog(null, e.getMessage());
					}
	        }
	        }
		});
	
		return painel;
		
	}
	
 	public static JPanel exibirTreino(Treinador t){
		
	 	final JTextField textFieldNomeTreinoProcurar;
		
		JPanel painel = new JPanel();
		painel.setBounds(0, 0, 710, 400);
		painel.setLayout(null);
		
		painel.add(MenuTreinador(t));
		
		AdministracaoDeTelas.logoAdd(painel);
		
		JLabel lblProcurarTreino= new JLabel("Treinador");
		lblProcurarTreino.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblProcurarTreino.setBounds(10, 11, 178, 25);
		painel.add(lblProcurarTreino);
		
		JLabel lblDigiteNomeTreinoProcurar = new JLabel("Digite o nome do Treino que voc\u00EA deseja exibir : ");
		lblDigiteNomeTreinoProcurar.setBounds(10, 53, 350, 14);
		painel.add(lblDigiteNomeTreinoProcurar);
		
		textFieldNomeTreinoProcurar = new JTextField();
		textFieldNomeTreinoProcurar.setBounds(10, 78, 213, 20);
		painel.add(textFieldNomeTreinoProcurar);
		textFieldNomeTreinoProcurar.setColumns(10);
		
		JButton btnCancelar = new JButton("Limpar");
		btnCancelar.setBounds(10, 129, 89, 23);
		painel.add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) {
            	textFieldNomeTreinoProcurar.setText("");
           
            }});
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(138, 129, 150, 23);
		painel.add(btnConfirmar);
		btnConfirmar.addActionListener(new ActionListener() {  
	        @Override    
	        public void actionPerformed(ActionEvent evt) {
	        	if(textFieldNomeTreinoProcurar.getText().equals("")){
	        		JOptionPane.showMessageDialog(null, "Digite todos os campos");
	        	}else{
	        	try{
	            	JOptionPane.showMessageDialog(null, MyGymFachada.getInstance().procurarTreino(textFieldNomeTreinoProcurar.getText()));
	            	textFieldNomeTreinoProcurar.setText("");
	        	}catch(NumberFormatException e){
	        		JOptionPane.showMessageDialog(null, "Campo de CPF aceita apenas números");
	        	} catch (ObjetoNaoExisteException e) {
	        		JOptionPane.showMessageDialog(null, e.getMessage());
				}
	        }
	        }
		});
		
		
		painel.setVisible(true);
		return painel;
	}
	
	public static JPanel removerTreino(Treinador t){
		
		final JTextField textFieldNomeRemoverTreino;
		
		JPanel painel = new JPanel();
		painel.setBounds(0, 0, 710, 400);
		painel.setLayout(null);
		
		painel.add(MenuTreinador(t));
		
		AdministracaoDeTelas.logoAdd(painel);
		
		JLabel lblTreino = new JLabel("Treino");
		lblTreino.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblTreino.setBounds(10, 11, 178, 25);
		painel.add(lblTreino);
		
		JLabel lblDigiteNomeTreino = new JLabel("Digite o Nome do Treino que voc\u00EA deseja remover : ");
		lblDigiteNomeTreino.setBounds(10, 53, 350, 14);
		painel.add(lblDigiteNomeTreino);
		
		textFieldNomeRemoverTreino = new JTextField();
		textFieldNomeRemoverTreino.setBounds(10, 78, 213, 20);
		painel.add(textFieldNomeRemoverTreino);
		textFieldNomeRemoverTreino.setColumns(10);
		
		JButton btnCancelar = new JButton("Limpar");
		btnCancelar.setBounds(10, 129, 89, 23);
		painel.add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {  
	        @Override    
	        public void actionPerformed(ActionEvent evt) {
	        	textFieldNomeRemoverTreino.setText("");
	        
	        }});
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(138, 129, 89, 23);
		painel.add(btnConfirmar);
		btnConfirmar.addActionListener(new ActionListener() {  
			 public void actionPerformed(ActionEvent evt) {
		        	if(textFieldNomeRemoverTreino.getText().equals("")){
		        		JOptionPane.showMessageDialog(null, "Digite todos os campos");
		        	}else{
		        	try{
		             MyGymFachada.getInstance().removerTreino(textFieldNomeRemoverTreino.getText().toLowerCase());
		             JOptionPane.showMessageDialog(null, "Removido com sucesso");
		             textFieldNomeRemoverTreino.setText("");
		        	}catch(NumberFormatException e){
		        		JOptionPane.showMessageDialog(null, "Campo aceita apenas números");
		        	} catch (ObjetoNaoExisteException e) {
		        		JOptionPane.showMessageDialog(null, e.getMessage());
					}
		        }
		        }
			});
		
		painel.setVisible(true);
		return painel;
		
	}
	
public static JPanel exibirListaDeClientes(Treinador t){
	
		
		JPanel painel = new JPanel();
		painel.setBounds(0, 0, 710, 400);
		painel.setLayout(null);
		
		painel.add(MenuTreinador(t));
		
		AdministracaoDeTelas.logoAdd(painel);
		
		JLabel lblNewLabel = new JLabel("Treinos:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 112, 154, 43);
		painel.add(lblNewLabel);
		
		String registro ="";
		
		ArrayList<Cliente> listaCliente = MyGymFachada.getInstance().listaClientesTreinador(t.getCpf());
		String resultado = "";
		if(listaCliente.size() == 0){
			resultado = "Nenhum Cliente cadastrado";
		}else{
			for (Cliente c : listaCliente) {
				resultado += "Nome do Cliente:" + c.getNome() + "\n" + "Cpf :" +c.getCpf()+"\n"+ 
							 "Telefone: "+c.getTelefone()+"\n"+
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
	
	public static JPanel listaAulos(final Treinador t){
		
	final JTextField textFieldCPFLista;
		
		JPanel painel = new JPanel();
		painel.setBounds(0, 0, 710, 400);
		painel.setLayout(null);
		
		painel.add(MenuTreinador(t));
		
		AdministracaoDeTelas.logoAdd(painel);
		
		JLabel lblInsiraCpf = new JLabel("Digite CPF:");
		lblInsiraCpf.setBounds(9, 70, 90, 14);
		painel.add(lblInsiraCpf);
		
		textFieldCPFLista = new JTextField();
		textFieldCPFLista.setBounds(10, 105, 174, 20);
		textFieldCPFLista.setColumns(10);
		painel.add(textFieldCPFLista);
		
		JButton btnLista = new JButton("Lista Cliente");
		btnLista.setBounds(10, 152, 129, 23);
		painel.add(btnLista);
		btnLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					AdministracaoDeTelas.trocarTelas(AreaRestrita.painel, exibirListaDeClientes(t));
					
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Preencha os campos Corretamente");
				}
				
			
			}
		});
		
	
		painel.setVisible(true);
		return painel;
	
	}
	}

