package gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.TextArea;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.security.ProtectionDomain;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;

import util.Seguranca;
import classesBasicas.Administrador;
import classesBasicas.Aula;
import classesBasicas.Avaliacao;
import classesBasicas.Cliente;
import classesBasicas.Login;
import classesBasicas.Treinador;
import excecoes.ObjetoJaExisteException;
import excecoes.ObjetoNaoExisteException;
import excecoes.UsuarioJaExisteException;
import negocios.MyGymFachada;


public class PainelAdministrador extends JPanel{

	
	
	private static Treinador t;

	
	public PainelAdministrador() {
			
	}
	
	public static JPanel inicio() {
		return null;
	}
	
	private static JMenuBar menuAdministrador(){
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 710, 30);		
		
		JMenu mnAdministrarCliente = new JMenu("Administrar Cliente");
		mnAdministrarCliente.setBounds(186, 176, 152, 22);
		menuBar.add(mnAdministrarCliente);

		
		JMenuItem mntmCadastrarCliente = new JMenuItem("Cadastrar Cliente");
		mnAdministrarCliente.add(mntmCadastrarCliente);
		
		mntmCadastrarCliente.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) { 
            	AdministracaoDeTelas.trocarTelas(AreaRestrita.painel,cadastrarCliente());
            }    
		});

		
		JMenuItem mntmExibirCliente = new JMenuItem("Exibir Cliente");
		mnAdministrarCliente.add(mntmExibirCliente);
		mntmExibirCliente.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) { 
            	AdministracaoDeTelas.trocarTelas(AreaRestrita.painel,procurarCliente());
            }    
		});
		
		JMenuItem mntmRemoverCliente = new JMenuItem("Remover Cliente");
		mnAdministrarCliente.add(mntmRemoverCliente);
		mntmRemoverCliente.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) { 
            	AdministracaoDeTelas.trocarTelas(AreaRestrita.painel,removerCliente());
            }    
		});
		
	
		JMenu mnAdministrarTreinador = new JMenu("Administrar Treinador");
		mnAdministrarTreinador.setBounds(162, 0, 165, 22);
		menuBar.add(mnAdministrarTreinador);
		
		JMenuItem mntmCadastrarTreinador = new JMenuItem("Cadastrar Treinador");
		mnAdministrarTreinador.add(mntmCadastrarTreinador);
		mntmCadastrarTreinador.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) { 
            	AdministracaoDeTelas.trocarTelas(AreaRestrita.painel, cadastrarTreinador());
            }    
		});  
		
		
		JMenuItem mntmExibirTreinador = new JMenuItem("Exibir Treinador");
		mnAdministrarTreinador.add(mntmExibirTreinador);
		mntmExibirTreinador.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) { 
            	AdministracaoDeTelas.trocarTelas(AreaRestrita.painel, procurarTreinador());
            }    
		}); 
		
		JMenuItem mntmRemoverTreinador = new JMenuItem("Remover Treinador");
		mnAdministrarTreinador.add(mntmRemoverTreinador);
		mntmRemoverTreinador.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) { 
            	AdministracaoDeTelas.trocarTelas(AreaRestrita.painel, removerTreinador());
            }    
		});
		
		JMenu mnAdministrarAulas = new JMenu("Administrar Aulas");
		mnAdministrarAulas.setBounds(337, 0, 140, 22);
		menuBar.add(mnAdministrarAulas);
		
		JMenuItem mntmCadastrarAulas = new JMenuItem("Cadastrar Aulas");
		mnAdministrarAulas.add(mntmCadastrarAulas);
		mntmCadastrarAulas.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) { 
            	AdministracaoDeTelas.trocarTelas(AreaRestrita.painel,cadastrarAula());
            }    
		});
		
		JMenuItem mntmExibirAulas = new JMenuItem("Exibir Aulas");
		mnAdministrarAulas.add(mntmExibirAulas);
		mntmExibirAulas.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) { 
            	AdministracaoDeTelas.trocarTelas(AreaRestrita.painel,procurarAula());
            }    
		});
		
		JMenuItem mntmRemoverAulas = new JMenuItem("Remover Aulas");
		mnAdministrarAulas.add(mntmRemoverAulas);
		mntmRemoverAulas.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) { 
            	AdministracaoDeTelas.trocarTelas(AreaRestrita.painel,removerAula());
            }    
		});
		
		JMenu mnAdministrarAdministrador = new JMenu("Administrar Administrador");
		mnAdministrarAdministrador.setBounds(487, 0, 189, 22);
		menuBar.add(mnAdministrarAdministrador);
		
		JMenuItem mntmCadastrarAdministrador = new JMenuItem("Cadastrar Administrador");
		mnAdministrarAdministrador.add(mntmCadastrarAdministrador);
		mntmCadastrarAdministrador.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) { 
            	AdministracaoDeTelas.trocarTelas(AreaRestrita.painel,cadastrarAdministrador());
            }    
		});
		
		JMenuItem mntmExibirAdministrador = new JMenuItem("Exibir Administrador");
		mnAdministrarAdministrador.add(mntmExibirAdministrador);
		mntmExibirAdministrador.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) { 
            	AdministracaoDeTelas.trocarTelas(AreaRestrita.painel,procurarAdministrador());
            }    
		});
		
		JMenuItem mntmRemoverAdministrador = new JMenuItem("Remover Administrador");
		mnAdministrarAdministrador.add(mntmRemoverAdministrador);
		mntmRemoverAdministrador.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) { 
            	AdministracaoDeTelas.trocarTelas(AreaRestrita.painel,removerAdministrador());
            }    
		});
		
		menuBar.setVisible(true);

		return menuBar;
	}
			
	public static JPanel painelAdministrador(Administrador a){
		JPanel painel = new JPanel();
		painel.setBounds(0, 0, 710, 500);
		painel.setLayout(null);
		
		painel.add(menuAdministrador());
		
		AdministracaoDeTelas.logoAdd(painel);
		
		JLabel lblOla = new JLabel("Seja bem-vindo novamente,");
		lblOla.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblOla.setBounds(10, 60, 661, 45);
		painel.add(lblOla);
		
		JLabel lblNome = new JLabel(a.getNome());
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNome.setBounds(10, 109, 661, 45);
		painel.add(lblNome);
		
		JLabel lblNewLabel = new JLabel("CPF : " + a.getCpf());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 160, 319, 32);
		painel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Acesso: " + a.getLogin().getDataUltimoAcesso());
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 200, 302, 20);
		painel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Usuario : " + a.getLogin().getUsuario());
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 230, 319, 32);
		painel.add(lblNewLabel_3);
		
		
		painel.setVisible(true);
		
		return painel;
	}
	
	public static JPanel cadastrarTreinador(){
		
		final JTextField textFieldNome;
		final JTextField textFieldCPF;
		final JTextField textFieldUsuario;
		final JPasswordField textFieldSenha;
		
		JPanel painel = new JPanel();
		painel.setBounds(0, 0, 710, 500);
		painel.setLayout(null);
		
		painel.add(menuAdministrador());
		
		AdministracaoDeTelas.logoAdd(painel);
		
		JLabel lblTreinador = new JLabel("Cadastrar Treinador");
		lblTreinador.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblTreinador.setBounds(10, 41, 600, 25);
		painel.add(lblTreinador);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 79, 46, 14);
		painel.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(10, 104, 287, 20);
		painel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(10, 135, 75, 14);
		painel.add(lblNewLabel);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(10, 157, 123, 20);
		painel.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 196, 100, 14);
		painel.add(lblUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(10, 221, 178, 20);
		painel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 253, 46, 14);
		painel.add(lblSenha);
		
		textFieldSenha = new JPasswordField();
		textFieldSenha.setBounds(10, 288, 178, 20);
		painel.add(textFieldSenha);
		textFieldSenha.setColumns(10);
		
		JButton btnCancelar = new JButton("Limpar");
		btnCancelar.setBounds(10, 360, 89, 23);
		painel.add(btnCancelar);
		
		//Ação do Botão Cancelar Treinador 
		btnCancelar.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) {
            	textFieldNome.setText("");
            	textFieldCPF.setText("");
            	textFieldSenha.setText("");
            	textFieldUsuario.setText("");
            }});
		
		
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(184, 360, 89, 23);
		btnOk.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) {
         
	      if(textFieldCPF.getText().equals("") || textFieldNome.getText().equals("") || textFieldSenha.getText().equals("") || textFieldUsuario.getText().equals("")){
	    	  JOptionPane.showMessageDialog(null, "Digite todos os campos");
	      } else{
	            	try {
						MyGymFachada.getInstance().cadastrarTreinador(new Treinador(textFieldNome.getText().toLowerCase(), Long.parseLong(textFieldCPF.getText()), new Login(textFieldUsuario.getText().toLowerCase(), Seguranca.md5(textFieldSenha.getText()))));
					
	            	JOptionPane.showMessageDialog(null, "Treinador Cadastrado!");
	            	textFieldCPF.setText("");
	            	textFieldNome.setText("");
	            	textFieldSenha.setText("");
	            	textFieldUsuario.setText("");
	            	
            	}catch(NumberFormatException e){
            		JOptionPane.showMessageDialog(null, "Campo de CPF aceita apenas números");
            	}catch(ObjetoJaExisteException e){
            		JOptionPane.showMessageDialog(null, e.getMessage());
            	}
            	catch (UsuarioJaExisteException e) {
					JOptionPane.showMessageDialog(null, "Usuario Já Existe");
            }
	      }
		
            }});
		
		
		painel.add(btnOk);
		
		painel.setVisible(true);
		return painel;
		
		
	}
	
	public static JPanel removerTreinador(){
		
		final JTextField textFieldCpfRemover;
		
		JPanel painel = new JPanel();
		painel.setBounds(0, 0, 710, 500);
		painel.setLayout(null);
		
		painel.add(menuAdministrador());
		
		AdministracaoDeTelas.logoAdd(painel);
		
		JLabel lblTreinador = new JLabel("Remover Treinador");
		lblTreinador.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblTreinador.setBounds(10, 41, 300, 25);
		painel.add(lblTreinador);
		
		JLabel lblDigiteOCpf = new JLabel("Digite o CPF do Treinador que voc\u00EA deseja remover : ");
		lblDigiteOCpf.setBounds(10, 83, 700, 14);
		painel.add(lblDigiteOCpf);
		
		textFieldCpfRemover = new JTextField();
		textFieldCpfRemover.setBounds(10, 108, 213, 20);
		painel.add(textFieldCpfRemover);
		textFieldCpfRemover.setColumns(10);
		
		JButton btnCancelar = new JButton("Limpar");
		btnCancelar.setBounds(10, 159, 89, 23);
		painel.add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) {
            	textFieldCpfRemover.setText("");
            
            }});
		
		JButton btnConfirmar = new JButton("Ok");
		btnConfirmar.setBounds(138, 159, 89, 23);
		painel.add(btnConfirmar);
		btnConfirmar.addActionListener(new ActionListener() {  
			 public void actionPerformed(ActionEvent evt) {
		        	if(textFieldCpfRemover.getText().equals("")){
		        		JOptionPane.showMessageDialog(null, "Digite todos os campos");
		        	}else{
		        	try{
		             MyGymFachada.getInstance().removerTreinador(Long.parseLong(textFieldCpfRemover.getText().toString()));
		             JOptionPane.showMessageDialog(null, "Removido com sucesso");
		             textFieldCpfRemover.setText("");
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
	
	public static JPanel procurarTreinador(){

	final JTextField textFieldCpfProcurar;
	
	JPanel painel = new JPanel();
	painel.setBounds(0, 0, 710, 500);
	painel.setLayout(null);
	
	painel.add(menuAdministrador());
	
	AdministracaoDeTelas.logoAdd(painel);
	
	JLabel lblTreinador = new JLabel("Exibir Treinador");
	lblTreinador.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
	lblTreinador.setBounds(10, 41, 300, 25);
	painel.add(lblTreinador);
	
	JLabel lblDigiteOCpf = new JLabel("Digite o CPF do Treinador que voc\u00EA deseja exibir : ");
	lblDigiteOCpf.setBounds(10, 83, 700, 14);
	painel.add(lblDigiteOCpf);
	
	textFieldCpfProcurar = new JTextField();
	textFieldCpfProcurar.setBounds(10, 108, 213, 20);
	painel.add(textFieldCpfProcurar);
	textFieldCpfProcurar.setColumns(10);
	
	JButton btnCancelar = new JButton("Limpar");
	btnCancelar.setBounds(10, 159, 89, 23);
	painel.add(btnCancelar);
	
	btnCancelar.addActionListener(new ActionListener() {  
        @Override    
        public void actionPerformed(ActionEvent evt) {
        	textFieldCpfProcurar.setText("");
       
        }});
	
	JButton btnConfirmar = new JButton("Ok");
	btnConfirmar.setBounds(138, 159, 89, 23);
	btnConfirmar.addActionListener(new ActionListener() {  
        @Override    
        public void actionPerformed(ActionEvent evt) {
        	if(textFieldCpfProcurar.getText().equals("")){
        		JOptionPane.showMessageDialog(null, "Digite todos os campos");
        	}else{
        	try{
            	JOptionPane.showMessageDialog(null, MyGymFachada.getInstance().procurarTreinador(Long.parseLong(textFieldCpfProcurar.getText())).toString());
        	}catch(NumberFormatException e){
        		JOptionPane.showMessageDialog(null, "Campo de CPF aceita apenas números");
        		textFieldCpfProcurar.setText("");
        	} catch (ObjetoNaoExisteException e) {
        		JOptionPane.showMessageDialog(null, e.getMessage());
			}
        }
        }
	});
	painel.add(btnConfirmar);
	
	painel.setVisible(true);
	return painel;
	
	
}
	
	public static JPanel cadastrarCliente(){
		
		final JTextField textFieldNomeCliente;
		final JTextField textFieldEnderecoCliente;
		final JTextField textFieldIdadeCliente;
		final JTextField textFieldCpfCliente;
		final JTextField textFieldTelefoneCliente;
		final JTextField textFieldEmailCliente;
		final JTextField textFieldLoginCliente;
		final JPasswordField textFieldSenhaCliente;
		final JTextField textFieldCpfTreinadorCliente;
		
		JPanel painel = new JPanel();
		painel.setBounds(0, 0, 710, 500);
		painel.setLayout(null);
		
		painel.add(menuAdministrador());
		
		AdministracaoDeTelas.logoAdd(painel);
		
		JLabel lblCliente = new JLabel("Cadastrar Cliente");
		lblCliente.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblCliente.setBounds(10, 32, 300, 25);
		painel.add(lblCliente);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 68, 300, 14);
		painel.add(lblNome);
		
		textFieldNomeCliente = new JTextField();
		textFieldNomeCliente.setBounds(10, 82, 257, 20);
		painel.add(textFieldNomeCliente);
		textFieldNomeCliente.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o: ");
		lblEndereco.setBounds(10, 113, 300, 14);
		painel.add(lblEndereco);
		
		textFieldEnderecoCliente = new JTextField();
		textFieldEnderecoCliente.setBounds(10, 127, 257, 20);
		painel.add(textFieldEnderecoCliente);
		textFieldEnderecoCliente.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(10, 157, 300, 14);
		painel.add(lblIdade);
		
		textFieldIdadeCliente = new JTextField();
		textFieldIdadeCliente.setBounds(10, 172, 55, 20);
		painel.add(textFieldIdadeCliente);
		textFieldIdadeCliente.setColumns(10);
		
		JLabel lblCpfCliente = new JLabel("CPF:");
		lblCpfCliente.setBounds(10, 202, 300, 14);
		painel.add(lblCpfCliente);
		
		textFieldCpfCliente = new JTextField();
		textFieldCpfCliente.setBounds(10, 217, 126, 20);
		painel.add(textFieldCpfCliente);
		textFieldCpfCliente.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 246, 300, 14);
		painel.add(lblTelefone);
		
		textFieldTelefoneCliente = new JTextField();
		textFieldTelefoneCliente.setBounds(10, 262, 114, 20);
		painel.add(textFieldTelefoneCliente);
		textFieldTelefoneCliente.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 290, 300, 14);
		painel.add(lblEmail);
		
		textFieldEmailCliente = new JTextField();
		textFieldEmailCliente.setBounds(10, 307, 211, 20);
		painel.add(textFieldEmailCliente);
		textFieldEmailCliente.setColumns(10);
		
		final JLabel lblLogin = new JLabel("Usuário:");
		lblLogin.setBounds(10, 333, 300, 14);
		painel.add(lblLogin);
		
		textFieldLoginCliente = new JTextField();
		textFieldLoginCliente.setBounds(10, 349, 178, 20);
		painel.add(textFieldLoginCliente);
		textFieldLoginCliente.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 378, 300, 14);
		painel.add(lblSenha);
		
		textFieldSenhaCliente = new JPasswordField();
		textFieldSenhaCliente.setBounds(10, 393, 178, 20);
		painel.add(textFieldSenhaCliente);
		textFieldSenhaCliente.setColumns(10);
		
		final JLabel lblDigiteOCpf = new JLabel("Digite o CPF do Treinador: ");
		lblDigiteOCpf.setBounds(10, 420, 300, 14);
		painel.add(lblDigiteOCpf);
		
		textFieldCpfTreinadorCliente = new JTextField();
		textFieldCpfTreinadorCliente.setBounds(10, 438, 126, 20);
		painel.add(textFieldCpfTreinadorCliente);
		textFieldCpfTreinadorCliente.setColumns(10);
		
		final JButton btnIniciarAvaliacao = new JButton("Iniciar Avaliação");		
		btnIniciarAvaliacao.setBounds(10, 475, 180, 23);
		painel.add(btnIniciarAvaliacao);
		btnIniciarAvaliacao.addActionListener(new ActionListener() {   
            @Override    
            public void actionPerformed(ActionEvent evt) {
            	if(textFieldNomeCliente.getText().equals("") || textFieldCpfCliente.getText().equals("") ||  textFieldCpfTreinadorCliente.getText().equals("") || textFieldEmailCliente.getText().equals("") || textFieldEnderecoCliente.getText().equals("") || textFieldIdadeCliente.getText().equals("") || textFieldLoginCliente.getText().equals("") || textFieldSenhaCliente.getText().equals("") || textFieldTelefoneCliente.getText().equals("") ){
      	    	  
      	    	  JOptionPane.showMessageDialog(null, "Digite todos os campos");
      	      } else{

      	    	try{
      	    		  if((MyGymFachada.getInstance().procurarCpfExistente(Long.parseLong(textFieldCpfCliente.getText())))){
      	    			  JOptionPane.showMessageDialog(AdministracaoDeTelas.getAreaRestrita(), "Já existe um cadastro com este cpf");
      	    			  
      	    		  }else if(MyGymFachada.getInstance().procurarLoginExistente(textFieldLoginCliente.getText())){
          	    		  JOptionPane.showMessageDialog(AdministracaoDeTelas.getAreaRestrita(), "Já existe um usuário com este nome");

          	    	  }else if(Integer.parseInt(textFieldIdadeCliente.getText()) < 10 || Integer.parseInt(textFieldIdadeCliente.getText()) > 150){
          	    		  JOptionPane.showMessageDialog(AdministracaoDeTelas.getAreaRestrita(), "Cliente com idade incompatível");
          	    	  }else{
      	    			  t = MyGymFachada.getInstance().procurarTreinador(Long.parseLong(textFieldCpfTreinadorCliente.getText()));
	      	    		  if(JOptionPane.showConfirmDialog(AdministracaoDeTelas.getAreaRestrita(), "Confirmar Treinador: "+t.getNome()+"?", "Atenção!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
	      	    			  Cliente c = new Cliente(textFieldNomeCliente.getText(), textFieldEnderecoCliente.getText(), Integer.parseInt(textFieldIdadeCliente.getText()), Long.parseLong(textFieldCpfCliente.getText()), Long.parseLong(textFieldTelefoneCliente.getText()), textFieldEmailCliente.getText(), new Login(textFieldLoginCliente.getText(), Seguranca.md5(textFieldSenhaCliente.getText()) ), null, t);
	      	    			  AdministracaoDeTelas.trocarTelas(AreaRestrita.painel, avaliacaoCliente(c));
	      	    		  }else{
	      	    			textFieldCpfTreinadorCliente.setText("");
	      	    		  }
	      	    		  
      	    		  }      	    	  
    	    		  
    	    	  }catch(NumberFormatException e){
    	    		JOptionPane.showMessageDialog(null, "Campo CPF e idade aceitam apenas números");
    	    	  }catch(ObjetoNaoExisteException e){
    	    		JOptionPane.showMessageDialog(null, e.getMessage());
    	    	  }catch(IllegalArgumentException e ){
    	    		JOptionPane.showMessageDialog(null, e.getMessage());
    	    	  }

      	      }
            }});
		
		painel.setVisible(true);
		return painel;
	
	}
	
	public static JPanel avaliacaoCliente(final Cliente c){
		JPanel painel = new JPanel();
		painel.setBounds(0, 0, 710, 500);
		painel.setLayout(null);

		final JTextField 
			textFieldObjetivo,
		 	textFieldMedicamentos,
		 	textFieldIdadeAvaliacao,
		 	textFieldPesoAvaliacao,
		 	textFieldExerciciosFisicosAvaliacao,
		 	textFieldHistorioFamiliarAvaliacao;
		final TextArea textFieldDoencaFamiliar, textFieldObservacoes, textFieldObservacoesRiscosCoronariano;

		
		painel.add(menuAdministrador());
		
		JLabel lblCliente= new JLabel("Cliente");
		lblCliente.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblCliente.setBounds(10, 41, 178, 25);
		painel.add(lblCliente);
		
		JLabel lbltitulo = new JLabel("(Avalia\u00E7\u00E3o F\u00EDsica)-- ANAMNESE");
		lbltitulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbltitulo.setBounds(10, 71, 200, 14);
		painel.add(lbltitulo);
		
		JLabel lblObjetivo = new JLabel("Objetivos rela\u00E7\u00E3o \u00E0 atividade f\u00EDsica?");
		lblObjetivo.setBounds(10, 89, 250, 14);
		painel.add(lblObjetivo);
		
		textFieldObjetivo = new JTextField();
		textFieldObjetivo.setBounds(10, 108, 263, 20);
		painel.add(textFieldObjetivo);
		textFieldObjetivo.setColumns(10);
		
		JLabel lblPraticaAtividade = new JLabel("Pratica Atividade f\u00EDsica atualmente?");
		lblPraticaAtividade.setBounds(10, 134, 250, 14);
		painel.add(lblPraticaAtividade);
		
		ButtonGroup PraticaAtividade = new ButtonGroup();
		 
		final JRadioButton rdbtnSimPraticaAtividade = new JRadioButton("Sim");
		rdbtnSimPraticaAtividade.setBounds(6, 155, 60, 23);
		PraticaAtividade.add(rdbtnSimPraticaAtividade);
		painel.add(rdbtnSimPraticaAtividade);
		//
		
		final JRadioButton rdbtnNaoPraticaAtividade = new JRadioButton("N\u00E3o");
		rdbtnNaoPraticaAtividade.setBounds(72, 155, 95, 23);
		rdbtnNaoPraticaAtividade.setSelected(true);
		PraticaAtividade.add(rdbtnNaoPraticaAtividade);
		painel.add(rdbtnNaoPraticaAtividade);
		//
		
		JLabel lblMedicamentos = new JLabel("Digite os nomes dos medicamentos que voc\u00EA utiliza :");
		lblMedicamentos.setBounds(10, 185, 300, 14);
		painel.add(lblMedicamentos);
		
		textFieldMedicamentos = new JTextField();
		textFieldMedicamentos.setBounds(10, 204, 263, 20);
		painel.add(textFieldMedicamentos);
		textFieldMedicamentos.setColumns(10);
		
		JLabel lblCirurgia = new JLabel("J\u00E1 passou por alguma cirurgia?");
		lblCirurgia.setBounds(10, 231, 200, 14);
		painel.add(lblCirurgia);
		
		ButtonGroup algumaCirurgia = new ButtonGroup();
		final JRadioButton rdbtnSimCirugia = new JRadioButton("Sim");
		rdbtnSimCirugia.setBounds(6, 252, 60, 23);
		algumaCirurgia.add(rdbtnSimCirugia);
		painel.add(rdbtnSimCirugia);
		
		final JRadioButton rdbtnNaoCirurgia = new JRadioButton("N\u00E3o");
		rdbtnNaoCirurgia.setBounds(72, 252, 60, 23);
		rdbtnNaoCirurgia.setSelected(true);
		algumaCirurgia.add(rdbtnNaoCirurgia);
		painel.add(rdbtnNaoCirurgia);
		
		JLabel lblNewLabel = new JLabel("Alguma doen\u00E7a na fam\u00EDlia? Insira o nome delas: ");
		lblNewLabel.setBounds(10, 277, 300, 14);
		painel.add(lblNewLabel);
		
		final TextArea textAreaDoencaFamiliar = new TextArea();
		textAreaDoencaFamiliar.setBackground(new Color(255,255,255));
		textAreaDoencaFamiliar.setBounds(10, 292, 272, 54);
		painel.add(textAreaDoencaFamiliar);

		
		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservaes.setBounds(10, 357, 100, 14);
		painel.add(lblObservaes);
		
		textFieldObservacoes = new TextArea();
		textFieldObservacoes.setBackground(new Color(255,255,255));
		textFieldObservacoes.setBounds(10, 373, 272, 54);
		painel.add(textFieldObservacoes);
		
		JLabel lblavaliaoFsicaRiscos = new JLabel("(Avalia\u00E7\u00E3o F\u00EDsica)-- RISCOS CORONARIANO");
		lblavaliaoFsicaRiscos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblavaliaoFsicaRiscos.setBounds(360, 70, 254, 14);
		painel.add(lblavaliaoFsicaRiscos);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(360, 89, 44, 14);
		painel.add(lblIdade);
		
		textFieldIdadeAvaliacao = new JTextField(""+c.getIdade());
		textFieldIdadeAvaliacao.setBounds(360, 108, 86, 20);
		textFieldIdadeAvaliacao.setEnabled(false);
		painel.add(textFieldIdadeAvaliacao);
		textFieldIdadeAvaliacao.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(497, 89, 46, 14);
		painel.add(lblSexo);
	
	
		ButtonGroup sexoGroup = new ButtonGroup();
		 
		final JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(497, 108, 95, 23);
		rdbtnMasculino.setSelected(true);
		sexoGroup.add(rdbtnMasculino);
		painel.add(rdbtnMasculino);
		//
		
		final JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(497, 130, 95, 23);
		sexoGroup.add(rdbtnFeminino);
		painel.add(rdbtnFeminino);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(360, 134, 60, 14);
		painel.add(lblPeso);
		
		textFieldPesoAvaliacao = new JTextField();
		textFieldPesoAvaliacao.setBounds(360, 156, 86, 20);
		painel.add(textFieldPesoAvaliacao);
		textFieldPesoAvaliacao.setColumns(10);
		
		JLabel lblExerccioFsico = new JLabel("Exerc\u00EDcios F\u00EDsicos que voc\u00EA  pratica: ");
		lblExerccioFsico.setBounds(360, 185, 220, 14);
		painel.add(lblExerccioFsico);
		
		textFieldExerciciosFisicosAvaliacao = new JTextField();
		textFieldExerciciosFisicosAvaliacao.setBounds(360, 204, 212, 20);
		painel.add(textFieldExerciciosFisicosAvaliacao);
		textFieldExerciciosFisicosAvaliacao.setColumns(10);
		
		JLabel lblTabagismo = new JLabel("Tabagismo:");
		lblTabagismo.setBounds(360, 231, 69, 14);
		painel.add(lblTabagismo);
		
		ButtonGroup tabagismo = new ButtonGroup();
		
		final JRadioButton rdbtnSimTabagismo = new JRadioButton("Sim");
		rdbtnSimTabagismo.setBounds(360, 252, 53, 23);
		tabagismo.add(rdbtnSimTabagismo);
		painel.add(rdbtnSimTabagismo);
		//
		
		final JRadioButton rdbtnNaoTabagismo = new JRadioButton("N\u00E3o");
		rdbtnNaoTabagismo.setBounds(428, 252, 53, 23);
		rdbtnNaoTabagismo.setSelected(true);
		tabagismo.add(rdbtnNaoTabagismo);
		painel.add(rdbtnNaoTabagismo);
		//
		
		JLabel lblHistricoFamiliar = new JLabel("Hist\u00F3rico Familiar:");
		lblHistricoFamiliar.setBounds(360, 277, 200, 14);
		painel.add(lblHistricoFamiliar);
		
		textFieldHistorioFamiliarAvaliacao = new JTextField();
		textFieldHistorioFamiliarAvaliacao.setBounds(360, 292, 228, 25);
		painel.add(textFieldHistorioFamiliarAvaliacao);
		textFieldHistorioFamiliarAvaliacao.setColumns(10);
		
		JLabel lblObservacoesRiscoCoronariano = new JLabel("Observa\u00E7\u00F5es :");
		lblObservacoesRiscoCoronariano.setBounds(360, 328, 86, 14);
		painel.add(lblObservacoesRiscoCoronariano);
				
		textFieldObservacoesRiscosCoronariano = new TextArea();
		textFieldObservacoesRiscosCoronariano.setBackground(new Color(255,255,255));
		textFieldObservacoesRiscosCoronariano.setBounds(359, 345, 228, 54);
		painel.add(textFieldObservacoesRiscosCoronariano);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(360, 404, 89, 23);
		painel.add(btnCancelar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(445, 404, 140, 23);
		painel.add(btnCadastrar);
		//depois da ação do botao
		btnCadastrar.addActionListener(new ActionListener() {  
	        @Override    
	        public void actionPerformed(ActionEvent evt) {
	      textFieldPesoAvaliacao.setText(textFieldPesoAvaliacao.getText().replace(',', '.'));
	      if(textAreaDoencaFamiliar.getText().equals("") || textFieldExerciciosFisicosAvaliacao.getText().equals("") || textFieldHistorioFamiliarAvaliacao.getText().equals("") || textFieldIdadeAvaliacao.getText().equals("") || textFieldMedicamentos.getText().equals("") || textFieldObjetivo.getText().equals("") || textFieldObservacoes.getText().equals("") || textFieldObservacoesRiscosCoronariano.getText().equals("") || textFieldPesoAvaliacao.getText().equals("")){
	    	  JOptionPane.showMessageDialog(null, "Digite todos os campos");
	      } else if(Double.parseDouble(textFieldPesoAvaliacao.getText()) < 10 || Double.parseDouble(textFieldPesoAvaliacao.getText()) > 500){
	    	  JOptionPane.showMessageDialog(null, "Peso incompatível");
	      }else{
	  		
		  		String fumante = "";
		  		String sexo = "";
		  		String cirurgia ="";
		  		String atividadeFisica = "";
	            try {
	            	if(rdbtnSimTabagismo.isSelected()){
	            		fumante = "Sim";
	            	}else{
	            		fumante = "Não";
	            	}
	            	
	            	if(rdbtnSimPraticaAtividade.isSelected()){
	            		atividadeFisica = "Sim";
	            	}else{
	            		atividadeFisica = "Não";
	            	}
	            	
	            	if(rdbtnSimCirugia.isSelected()){
	            		cirurgia = "Sim";
	            	}else{
	            		cirurgia ="Não";
	            	}
	            	
	            	if(rdbtnMasculino.isSelected()){
	            		sexo = "Masculino";
	            	}else{
	            		sexo ="Feminino";
	            	}
					Avaliacao avaliacao = new Avaliacao(textFieldObjetivo.getText(), atividadeFisica, textFieldMedicamentos.getText(), cirurgia, textAreaDoencaFamiliar.getText(), textFieldObservacoes.getText(), Integer.parseInt(textFieldIdadeAvaliacao.getText()), sexo, Double.parseDouble(textFieldPesoAvaliacao.getText()), textFieldExerciciosFisicosAvaliacao.getText(), textFieldHistorioFamiliarAvaliacao.getText(), fumante, textFieldObservacoesRiscosCoronariano.getText());
					c.setAvaliacaofisica(avaliacao);
					MyGymFachada.getInstance().cadastrarCliente(c);
					JOptionPane.showMessageDialog(null, "Cliente Cadastrado!");
	            
	            }catch(NumberFormatException e){
	        		JOptionPane.showMessageDialog(null, "Campo aceita apenas números");
	        	} catch (ObjetoJaExisteException e) {
	        		JOptionPane.showMessageDialog(null, "Treinador não encontrado");
				} catch (UsuarioJaExisteException e) {
					JOptionPane.showMessageDialog(null, "Login já existe");
				}
	      }
		
	        }});
		
		painel.setVisible(true);
		return painel;
	}
	
	public static JPanel removerCliente(){
		
		final JTextField textFieldCpfRemoverCliente;
		
		JPanel painel = new JPanel();
		painel.setBounds(0, 0, 710, 500);
		painel.setLayout(null);
		
		painel.add(menuAdministrador());
		
		AdministracaoDeTelas.logoAdd(painel);
		
		JLabel lblCliente = new JLabel("Remover Cliente");
		lblCliente.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblCliente.setBounds(10, 41, 300, 25);
		painel.add(lblCliente);
		
		JLabel lblDigiteOCpfCliente = new JLabel("Digite o CPF do Cliente que voc\u00EA deseja remover : ");
		lblDigiteOCpfCliente.setBounds(10, 83, 700, 14);
		painel.add(lblDigiteOCpfCliente);
		
		textFieldCpfRemoverCliente = new JTextField();
		textFieldCpfRemoverCliente.setBounds(10, 108, 213, 20);
		painel.add(textFieldCpfRemoverCliente);
		textFieldCpfRemoverCliente.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 159, 89, 23);
		painel.add(btnCancelar);
		
		
		btnCancelar.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) {
            	textFieldCpfRemoverCliente.setText("");
            }});
		
		JButton btnConfirmar = new JButton("Ok");
		btnConfirmar.setBounds(138, 159, 89, 23);
		painel.add(btnConfirmar);
		btnConfirmar.addActionListener(new ActionListener() {  
		 public void actionPerformed(ActionEvent evt) {
	        	if(textFieldCpfRemoverCliente.getText().equals("")){
	        		JOptionPane.showMessageDialog(null, "Digite todos os campos");
	        	}else{
	        	try{
	             MyGymFachada.getInstance().removerCliente(Long.parseLong(textFieldCpfRemoverCliente.getText().toString()));
	             JOptionPane.showMessageDialog(null, "Removido com sucesso");
	             	textFieldCpfRemoverCliente.setText("");
	        	}catch(NumberFormatException e){
	        		JOptionPane.showMessageDialog(null, "Campo de CPF aceita apenas números");
	        	} catch (ObjetoNaoExisteException e) {
	        		JOptionPane.showMessageDialog(null, e.getMessage());
				}
	        }
	        }
		});
		
		
		if(lblDigiteOCpfCliente.getText().equals("")){
			
		}else{
			
		}
		painel.setVisible(true);
		return painel;
		
		
	}
	
	public static JPanel procurarCliente(){ // METODO PROCURAR
		
		 final JTextField textFieldCpfProcurarCliente;
		
		JPanel painel = new JPanel();
		painel.setBounds(0, 0, 710, 500);
		painel.setLayout(null);
		
		painel.add(menuAdministrador());
		
		AdministracaoDeTelas.logoAdd(painel);
		
		JLabel lblCliente= new JLabel("Exibir Cliente");
		lblCliente.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblCliente.setBounds(10, 41, 300, 25);
		painel.add(lblCliente);
		
		JLabel lblDigiteOCpfCliente = new JLabel("Digite o CPF do Cliente que voc\u00EA deseja exibir : ");
		lblDigiteOCpfCliente.setBounds(10, 83,700, 14);
		painel.add(lblDigiteOCpfCliente);
		
		textFieldCpfProcurarCliente = new JTextField();
		textFieldCpfProcurarCliente.setBounds(10, 108, 213, 20);
		painel.add(textFieldCpfProcurarCliente);
		textFieldCpfProcurarCliente.setColumns(10);
		
		JButton btnCancelar = new JButton("Limpar");
		btnCancelar.setBounds(10, 159, 89, 23);
		painel.add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) {
            	textFieldCpfProcurarCliente.setText("");
            }});
		
		JButton btnConfirmar = new JButton("Ok");
		btnConfirmar.setBounds(138, 159, 89, 23);
		painel.add(btnConfirmar);
		btnConfirmar.addActionListener(new ActionListener() {  
	        @Override    
	        public void actionPerformed(ActionEvent evt) {
	        	if(textFieldCpfProcurarCliente.getText().equals("")){
	        		JOptionPane.showMessageDialog(null, "Digite todos os campos");
	        	}else{
	        	try{
	            	JOptionPane.showMessageDialog(null, MyGymFachada.getInstance().procurarCliente((Long.parseLong(textFieldCpfProcurarCliente.getText().toString()))));
	            	textFieldCpfProcurarCliente.setText("");
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
	
	
	public static JPanel cadastrarAula(){
		
		final JTextField textFieldNomeDaAula;
		final JTextField textFieldDiaDaSemana;

		
		JPanel painel = new JPanel();
		painel.setBounds(0, 0, 710, 500);
		painel.setLayout(null);
		
		painel.add(menuAdministrador());
		
		AdministracaoDeTelas.logoAdd(painel);
		
		JLabel lblAulas= new JLabel("Cadastrar Aulas");
		lblAulas.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblAulas.setBounds(10, 41, 220, 25);
		painel.add(lblAulas);
		
		JLabel lblNomeDaAula = new JLabel("Nome:");
		lblNomeDaAula.setBounds(10, 75, 46, 14);
		painel.add(lblNomeDaAula);
		
		textFieldNomeDaAula = new JTextField();
		textFieldNomeDaAula.setBounds(10, 96, 220, 20);
		painel.add(textFieldNomeDaAula);
		textFieldNomeDaAula.setColumns(10);
		
		JLabel lblDiaDaSemana = new JLabel("Dia da semana que a aula ser\u00E1 realizada:");
		lblDiaDaSemana.setBounds(10, 127, 220, 14);
		painel.add(lblDiaDaSemana);
		
		final JComboBox<String> comboDias = new JComboBox();
		comboDias.setBackground(new Color(255,255,255));
		comboDias.setBounds(10, 152, 220, 20);
		comboDias.addItem("Domingo");
		comboDias.addItem("Segunda");
		comboDias.addItem("Terça");
		comboDias.addItem("Quarta");
		comboDias.addItem("Quinta");
		comboDias.addItem("Sexta");
		comboDias.addItem("Sábado");
		comboDias.setSelectedIndex(0);
		painel.add(comboDias);
		
		JLabel lblHora = new JLabel("Hora: ");
		lblHora.setBounds(10, 183, 56, 14);
		painel.add(lblHora);
		
		final JComboBox<String> comboHora = new JComboBox();
		comboHora.setBackground(new Color(255,255,255));
		comboHora.setBounds(10, 198, 46, 26);
		for(int i=5; i<=21; i++){
			comboHora.addItem(""+i);
		}
		comboHora.setSelectedIndex(0);
		painel.add(comboHora);
		
		final JComboBox<String> comboMinutos = new JComboBox();
		comboMinutos.setBackground(new Color(255,255,255));
		comboMinutos.setBounds(65, 198, 46, 26);
		comboMinutos.addItem("00");
		comboMinutos.addItem("30");
		comboMinutos.setSelectedIndex(0);
		painel.add(comboMinutos);
		
		JLabel labelMinutos = new JLabel("Minutos: ");
		labelMinutos.setBounds(65, 183, 60, 14);
		painel.add(labelMinutos);
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 257, 89, 23);
		painel.add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent evt) {
            	comboDias.setSelectedIndex(0);
            	comboHora.setSelectedIndex(0);
            	comboMinutos.setSelectedIndex(0);
            	textFieldNomeDaAula.setText("");

            }});
		
		JButton btnCadastrar = new JButton("Ok");
		btnCadastrar.setBounds(141, 257, 89, 23);
		painel.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent evt) {
	        	if(textFieldNomeDaAula.getText().equals("")){
	        		JOptionPane.showMessageDialog(null, "Digite todos os campos");
	        	}else{
	        	try{
	        		MyGymFachada.getInstance().cadastrarAulas(new Aula(textFieldNomeDaAula.getText().toLowerCase(), comboDias.getSelectedItem().toString(), comboHora.getSelectedItem().toString()+":"+comboMinutos.getSelectedItem().toString() ));
	        		JOptionPane.showMessageDialog(null, "Aula Cadastrada");
	        		comboDias.setSelectedIndex(0);
	            	comboHora.setSelectedIndex(0);
	            	comboMinutos.setSelectedIndex(0);
	            	textFieldNomeDaAula.setText("");
	        	}catch(NumberFormatException e){
	        		JOptionPane.showMessageDialog(null, "Campo aceita apenas números");
	        	} catch (ObjetoJaExisteException e) {
	        		JOptionPane.showMessageDialog(null, e.getMessage());
				}
	        }
	        }
		});
		
		painel.setVisible(true);		
		return painel;
	}
	
	public static JPanel removerAula(){
	
	final JTextField textFieldNomeRemoverAula;
	
	JPanel painel = new JPanel();
	painel.setBounds(0, 0, 710, 500);
	painel.setLayout(null);
	
	painel.add(menuAdministrador());
	
	AdministracaoDeTelas.logoAdd(painel);
	
	JLabel lblAula = new JLabel("Remover Aulas");
	lblAula.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
	lblAula.setBounds(10, 41, 300, 25);
	painel.add(lblAula);
	
	JLabel lblDigiteNomeAula = new JLabel("Digite o Nome da Aula que voc\u00EA deseja remover : ");
	lblDigiteNomeAula.setBounds(10, 83, 700, 14);
	painel.add(lblDigiteNomeAula);
	
	textFieldNomeRemoverAula = new JTextField();
	textFieldNomeRemoverAula.setBounds(10, 108, 213, 20);
	painel.add(textFieldNomeRemoverAula);
	textFieldNomeRemoverAula.setColumns(10);
	
	JButton btnCancelar = new JButton("Limpar");
	btnCancelar.setBounds(10, 159, 89, 23);
	painel.add(btnCancelar);
	
	btnCancelar.addActionListener(new ActionListener() {  
        @Override    
        public void actionPerformed(ActionEvent evt) {
        	textFieldNomeRemoverAula.setText("");
        
        }});
	
	JButton btnConfirmar = new JButton("Ok");
	btnConfirmar.setBounds(138, 159, 89, 23);
	painel.add(btnConfirmar);
	btnConfirmar.addActionListener(new ActionListener() {  
		 public void actionPerformed(ActionEvent evt) {
	        	if(textFieldNomeRemoverAula.getText().equals("")){
	        		JOptionPane.showMessageDialog(null, "Digite todos os campos");
	        	}else{
	        	try{
	             MyGymFachada.getInstance().removerAulas(textFieldNomeRemoverAula.getText().toLowerCase());
	             JOptionPane.showMessageDialog(null, "Removido com sucesso");
	             textFieldNomeRemoverAula.setText("");
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
	
	public static JPanel procurarAula(){
		
		final JTextField textFieldNomeProcurarAula;
		
		JPanel painel = new JPanel();
		painel.setBounds(0, 0, 710, 500);
		painel.setLayout(null);
		
		painel.add(menuAdministrador());
		
		AdministracaoDeTelas.logoAdd(painel);
		
		JLabel lblAula= new JLabel("Exibir Aulas");
		lblAula.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblAula.setBounds(10, 41, 300, 25);
		painel.add(lblAula);
		
		JLabel lblDigiteNomeAulaProcurar = new JLabel("Digite o Nome da Aula que voc\u00EA deseja exibir : ");
		lblDigiteNomeAulaProcurar.setBounds(10, 83, 700, 14);
		painel.add(lblDigiteNomeAulaProcurar);
		
		textFieldNomeProcurarAula = new JTextField();
		textFieldNomeProcurarAula.setBounds(10, 108, 213, 20);
		painel.add(textFieldNomeProcurarAula);
		textFieldNomeProcurarAula.setColumns(10);
		
		JButton btnCancelar = new JButton("Limpar");
		btnCancelar.setBounds(10, 159, 89, 23);
		painel.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) {
            	textFieldNomeProcurarAula.setText("");
            	
            }});
		
		JButton btnConfirmar = new JButton("Ok");
		btnConfirmar.setBounds(138, 159, 89, 23);
		painel.add(btnConfirmar);
		btnConfirmar.addActionListener(new ActionListener() {  
	        @Override    
	        public void actionPerformed(ActionEvent evt) {
	        	if(textFieldNomeProcurarAula.getText().equals("")){
	        		JOptionPane.showMessageDialog(null, "Digite todos os campos");
	        	
	        	}else{
	        	try{
	            	JOptionPane.showMessageDialog(null, MyGymFachada.getInstance().procurarAulas(textFieldNomeProcurarAula.getText().toLowerCase()));
	            	textFieldNomeProcurarAula.setText("");
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
	
	public static JPanel cadastrarAdministrador(){
		
		 final JTextField textFieldNomeAdministradorCadastrar;
		 final JTextField textFieldCpfAdministradorCadastrar;
		 final JTextField textFieldUsuarioAdministradorCadastrar;
		 final JPasswordField textFieldSenhaAdministradorCadastrar;
		
		
		JPanel painel = new JPanel();
		painel.setBounds(0, 0, 710, 500);
		painel.setLayout(null);
		
		painel.add(menuAdministrador());
		
		AdministracaoDeTelas.logoAdd(painel);
		
		JLabel lblAdministradorCadastrar= new JLabel("Cadastrar Administador");
		lblAdministradorCadastrar.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblAdministradorCadastrar.setBounds(10, 41, 300, 25);
		painel.add(lblAdministradorCadastrar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 83, 268, 14);
		painel.add(lblNome);
		
		textFieldNomeAdministradorCadastrar = new JTextField();
		textFieldNomeAdministradorCadastrar.setBounds(10, 108, 213, 20);
		painel.add(textFieldNomeAdministradorCadastrar);
		textFieldNomeAdministradorCadastrar.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 135, 75, 14);
		painel.add(lblCpf);
		
		textFieldCpfAdministradorCadastrar = new JTextField();
		textFieldCpfAdministradorCadastrar.setBounds(10, 157, 123, 20);
		painel.add(textFieldCpfAdministradorCadastrar);
		textFieldCpfAdministradorCadastrar.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setBounds(10, 196, 100, 14);
		painel.add(lblUsuario);
		
		textFieldUsuarioAdministradorCadastrar = new JTextField();
		textFieldUsuarioAdministradorCadastrar.setBounds(10, 221, 178, 20);
		painel.add(textFieldUsuarioAdministradorCadastrar);
		textFieldUsuarioAdministradorCadastrar.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 253, 46, 14);
		painel.add(lblSenha);
		
		textFieldSenhaAdministradorCadastrar = new JPasswordField();
		textFieldSenhaAdministradorCadastrar.setBounds(10, 288, 178, 20);
		painel.add(textFieldSenhaAdministradorCadastrar);
		textFieldSenhaAdministradorCadastrar.setColumns(10);
		
		JButton btnCancelar = new JButton("Limpar");
		btnCancelar.setBounds(10, 327, 89, 23);
		painel.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) {
            	textFieldCpfAdministradorCadastrar.setText("");
            	textFieldNomeAdministradorCadastrar.setText("");
            	textFieldSenhaAdministradorCadastrar.setText("");
            	textFieldUsuarioAdministradorCadastrar.setText("");
            }});
		
		JButton btnCadastrar = new JButton("Ok");
		btnCadastrar.setBounds(146, 327, 89, 23);
		painel.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) {
         
	      if(textFieldCpfAdministradorCadastrar.getText().equals("") || textFieldNomeAdministradorCadastrar.getText().equals("") || textFieldSenhaAdministradorCadastrar.getText().equals("") || textFieldUsuarioAdministradorCadastrar.getText().equals("")){
	    	  JOptionPane.showMessageDialog(null, "Digite todos os campos");
	      } else{
	            	
						try {
							MyGymFachada.getInstance().cadastraAdministrador(new Administrador(textFieldNomeAdministradorCadastrar.getText(), Long.parseLong(textFieldCpfAdministradorCadastrar.getText()), new Login(textFieldUsuarioAdministradorCadastrar.getText().toLowerCase(), Seguranca.md5(textFieldSenhaAdministradorCadastrar.getText())) ));
						
					
	            	JOptionPane.showMessageDialog(null, "Administrador Cadastrado!");
	            	textFieldCpfAdministradorCadastrar.setText("");
	            	textFieldNomeAdministradorCadastrar.setText("");
	            	textFieldSenhaAdministradorCadastrar.setText("");
	            	textFieldUsuarioAdministradorCadastrar.setText("");
						} catch (UsuarioJaExisteException e) {
	            	
            	}catch(NumberFormatException e){
            		JOptionPane.showMessageDialog(null, "Campo de CPF aceita apenas números");
            	}catch(ObjetoJaExisteException e){
            		JOptionPane.showMessageDialog(null, e.getMessage());
            	}
	      }
		
		}});
		
		return painel;
		
		
	}
	
	public static JPanel removerAdministrador(){
		
		final JTextField textFieldCpfRemoverAdministrador;
		
		JPanel painel = new JPanel();
		painel.setBounds(0, 0, 710, 500);
		painel.setLayout(null);
		
		painel.add(menuAdministrador());
		
		AdministracaoDeTelas.logoAdd(painel);
		
		JLabel lblAdministradorRemover = new JLabel("Remover Administrador");
		lblAdministradorRemover.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblAdministradorRemover.setBounds(10, 41, 300, 25);
		painel.add(lblAdministradorRemover);
		
		JLabel lblDigiteCpfAdministradorRemover = new JLabel("Digite o CPF do Administrador que voc\u00EA deseja remover : ");
		lblDigiteCpfAdministradorRemover.setBounds(10, 83, 700, 14);
		painel.add(lblDigiteCpfAdministradorRemover);
		
		textFieldCpfRemoverAdministrador = new JTextField();
		textFieldCpfRemoverAdministrador.setBounds(10, 108, 213, 20);
		painel.add(textFieldCpfRemoverAdministrador);
		textFieldCpfRemoverAdministrador.setColumns(10);
		
		JButton btnCancelar = new JButton("Limpar");
		btnCancelar.setBounds(10, 159, 89, 23);
		painel.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) {
            	textFieldCpfRemoverAdministrador.setText("");
         
            }});
		
		JButton btnConfirmar = new JButton("Ok");
		btnConfirmar.setBounds(138, 159, 89, 23);
		painel.add(btnConfirmar);
		btnConfirmar.addActionListener(new ActionListener() {  
			 public void actionPerformed(ActionEvent evt) {
		        	if(textFieldCpfRemoverAdministrador.getText().equals("")){
		        		JOptionPane.showMessageDialog(null, "Digite todos os campos");
		        	}else{
		        	try{
		             MyGymFachada.getInstance().removerAdministrador(Long.parseLong(textFieldCpfRemoverAdministrador.getText()));
		             JOptionPane.showMessageDialog(null, "Removido com sucesso");
		             textFieldCpfRemoverAdministrador.setText("");
		            	
		             
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
	
	public static JPanel procurarAdministrador(){
		
		final JTextField textFieldCpfProcurarAdministrador;
		
		JPanel painel = new JPanel();
		painel.setBounds(0, 0, 710, 500);
		painel.setLayout(null);
		
		painel.add(menuAdministrador());
		
		AdministracaoDeTelas.logoAdd(painel);
		
		JLabel lblAdministradorProcurar= new JLabel("Exibir Administrador");
		lblAdministradorProcurar.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblAdministradorProcurar.setBounds(10, 41, 300, 25);
		painel.add(lblAdministradorProcurar);
		
		JLabel lblDigiteCpfAdministradorProcurar = new JLabel("Digite o CPF do Administrador que voc\u00EA deseja exibir : ");
		lblDigiteCpfAdministradorProcurar.setBounds(10, 83, 700, 14);
		painel.add(lblDigiteCpfAdministradorProcurar);
		
		textFieldCpfProcurarAdministrador = new JTextField();
		textFieldCpfProcurarAdministrador.setBounds(10, 108, 213, 20);
		painel.add(textFieldCpfProcurarAdministrador);
		textFieldCpfProcurarAdministrador.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 159, 89, 23);
		painel.add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {  
            @Override    
            public void actionPerformed(ActionEvent evt) {
            	textFieldCpfProcurarAdministrador.setText("");
           
            }});
		
		JButton btnConfirmar = new JButton("Ok");
		btnConfirmar.setBounds(138, 159, 89, 23);
		painel.add(btnConfirmar);
		btnConfirmar.addActionListener(new ActionListener() {  
	        @Override    
	        public void actionPerformed(ActionEvent evt) {
	        	if(textFieldCpfProcurarAdministrador.getText().equals("")){
	        		JOptionPane.showMessageDialog(null, "Digite todos os campos");
	        	}else{
	        	try{
	            	JOptionPane.showMessageDialog(null, MyGymFachada.getInstance().procurarAdministrador(Long.parseLong(textFieldCpfProcurarAdministrador.getText())));
	            	textFieldCpfProcurarAdministrador.setText("");
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



}