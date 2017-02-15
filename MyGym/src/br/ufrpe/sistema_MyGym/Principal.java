package br.ufrpe.sistema_MyGym;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import negocios.CadastroAula;
import negocios.CadastroCliente;
import negocios.CadastroPessoa;
import negocios.CadastroTreinador;
import negocios.CadastroTreino;
import classesBasicas.Aula;
import classesBasicas.Avaliacao;
import classesBasicas.Cliente;
import classesBasicas.Login;
import classesBasicas.Presenca;
import classesBasicas.Treinador;
import classesBasicas.Treino;
import excecoes.ObjetoJaExisteException;
import excecoes.ObjetoNaoExisteException;
import excecoes.UsuarioJaExisteException;

public class Principal {

	private static Scanner ler;
	private static CadastroAula cadastroAula = new CadastroAula();
	private static CadastroCliente cadastroCliente = new CadastroCliente();
	private static CadastroTreinador cadastroTreinador = new CadastroTreinador();
	private static CadastroTreino cadastroTreino = new CadastroTreino();
	private static CadastroPessoa cadastrarLogin = new CadastroPessoa();

	public Principal(CadastroAula cadastroAula, CadastroCliente cadastroCliente, CadastroTreinador cadastroTreinador) {

	}

	public static void main(String[] args) throws ObjetoNaoExisteException, UsuarioJaExisteException {
		 
       
       
        ler = new Scanner(System.in);
        int opcao;
   
		do{
            System.out.println("0- Sair \n1- Administrador \n2- Cliente \n3- Treinador \n");
            opcao = ler.nextInt();
            switch (opcao) {
            
            case 0: 
               	 
            	opcao = 0;

                break;

            case 1: // Menu Administrar
            	 	int opcao1;
                    do{
                        System.out.println("0-Voltar \n1-Administrar Cliente \n2-Administrar Treinador \n3-Administrar Aulas \n4-Administrar Mensalidades ");
                        opcao1 = ler.nextInt();
                        switch (opcao1) {
                        
                        case 0:
                        	opcao1 = 0;
                        	break;
 
                        case 1: // Administrar Cliente
                        		int opcao2; 
                                do{
	                                System.out.println("0- Voltar \n1-Cadastrar Cliente \n2-Remover Cliente \n3-Exibir Cliente \n4- Mensalidade- Pagar");
	                                opcao2 = ler.nextInt();
	                                switch (opcao2) {// Menu Administrar Cliente - 2
	                                case 0:
	                                	opcao2 = 0;
	                                	break;
	                                	
	                                case 1:// Cadastrar Cliente
	                                	
	                                        ler.nextLine();
	                                        System.out.println("-- CADASTRO CLIENTE -- \n\nNome: ");
	 
	                                        String nome = ler.nextLine();
	 
	                                        System.out.println("\nIdade: ");
	 
	                                        int idade = ler.nextInt();
	 
	                                        ler.nextLine();
	 
	                                        System.out.println("\nEndere�o: ");
	                                        String endereco;
	                                        endereco = ler.nextLine();
	 
	                                        System.out.println("\nCPF: ");
	                                        long cpf;
	                                        cpf = ler.nextLong();
	 
	                                        System.out.println("\nTelefone: ");
	                                        long telefone;
	                                        telefone = ler.nextLong();
	 
	                                        ler.nextLine();
	 
	                                        System.out.println("\nEmail: ");
	                                        String email;
	                                        email = ler.nextLine();
	                                        
	                                        System.out.println("\nTreinador CPF: ");
	                                        long cpfTreinador;
	                                        cpfTreinador = ler.nextLong();
	                                        
										
										try {
											Treinador treinador = cadastroTreinador.procurarTreinador(cpfTreinador);
									
	                                        
	                                        ler.nextLine();
	                                        
	                                        System.out.println("\n\n--CADASTRO CLIENTE (LOGIN)-- \nDigite nome de usuario: ");
	                                        String usuario;
	                                        usuario = ler.nextLine();
	                                  
	                                        System.out.println("\nDigite a senha: ");
	                                        String senha;
	                                        senha = ler.nextLine();
	                                
	                                        System.out.println("\n\n--CADASTRO CLIENTE (Avalia��o F�sica)-- \nANAMNESE\n\nObjetivos rela��o � atividade f�sica?\n");
	                                        String objetivo;
	                                        objetivo = ler.nextLine();
	 
	                                        System.out.println("Pratica Atividade f�sica atualmente?");
	                                        String atividadef;
	                                        atividadef = ler.nextLine();
	 
	                                        System.out.println("Utiliza algum tipo de medicamento?");
	                                        String medicamento;
	                                        medicamento = ler.nextLine();
	 
	                                        System.out.println("J� passou por alguma cirurgia?");
	                                        String cirurgia;
	                                        cirurgia = ler.nextLine();
	 
	                                        System.out.println("Doen�a na f�milia?");
	                                        String doenca;
	                                        doenca = ler.nextLine();
	 
	                                        System.out.println("Observa��es:");
	                                        String obs;
	                                        obs = ler.nextLine();
	                                        
	                                        Date dataAtual = new Date();
	                                        Calendar dataFinal = Calendar.getInstance();
	                                        dataFinal.setTime(dataAtual);
	                                        boolean k =true;
	                                        while(k){
	                                        	System.out.println("Escolha um plano: \n1 - mensal \n2 - semestral \n3 - anual");
	                                        	int tipoDePlano = ler.nextInt();
	                                        	if(tipoDePlano == 1){
	                                        		//plano mensal
	                                        		dataFinal.set(Calendar.MONTH, dataFinal.get(Calendar.MONTH)+2);
	                                        		k = false;
	                                        	}else if(tipoDePlano == 2){
	                                        		//Plano semestral
	                                        		dataFinal.set(Calendar.MONTH, dataFinal.get(Calendar.MONTH)+7);
	                                        		k = false;
	                                        	}else if(tipoDePlano == 3){
	                                        		//plano anual
	                                        		dataFinal.set(Calendar.MONTH, dataFinal.get(Calendar.MONTH)+13);
	                                        		k = false;
	                                        	}else{
	                                        		System.out.println("Op��o indisponivel!");
	                                        	}
	                                        }
	 
	                                        System.out.println("\n\n--CADASTRO CLIENTE (Avalia��o F�sica)-- \nRISCOS CORONARIANO\n\nIdade:");
	                                        int idade1;
	                                        idade1 = ler.nextInt();
	 
	                                        ler.nextLine();
	                                        System.out.println("Sexo:");
	                                        String sexo;
	                                        sexo = ler.nextLine();
	 
	                                        System.out.println("Peso:");
	                                        float peso;
	                                        peso = ler.nextFloat();
	 
	                                        ler.nextLine();
	                                        System.out.println("Exerc�cio F�sico:");
	                                        String exercicioF;
	                                        exercicioF = ler.nextLine();
	 
	                                        System.out.println("Hist�rico Fam�liar:");
	                                        String historicoF;
	                                        historicoF = ler.nextLine();
	 
	                                        System.out.println("Tabagismo");
	                                        String tabagismo;
	                                        tabagismo = ler.nextLine();
	 
	                                        System.out.println("Observa��es:");
	                                        String obs2;
	                                        obs2 = ler.nextLine();
	                                        
	                                        Login login = new Login (usuario, senha);
	 
	                                        Avaliacao avaliacao = new Avaliacao(objetivo, atividadef,
	                                                        medicamento, cirurgia, doenca, obs, idade1, sexo,
	                                                        peso, exercicioF, historicoF, tabagismo, obs2);
	 
	                                        Cliente cliente = new Cliente(nome, endereco, idade, cpf,
	                                                        telefone, email,login, avaliacao, treinador);
	 
										try {
											cadastroCliente.cadastrarCliente(cliente);
										} catch (UsuarioJaExisteException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
									
										} catch (ObjetoJaExisteException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										} catch (ObjetoNaoExisteException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
	                                        System.out.println(cadastroCliente.procurarCliente(cpf));
	                                        
	                                 
	                                        break;
	                                case 2:// Remover Cliente
	                                        System.out.println("Digite CPF do cliente que voc� deseja remover");
	                                        long cpf1;
	                                        cpf1 = ler.nextLong();
	 
	                                       cadastroCliente.removerCliente(cpf1);
	 
	                                        break;
	 
	                                case 3:// Exibir Cliente
	                                        System.out.println("Digite CPF do cliente que voc� deixar exibir os dados");
	                                        long cpf2;
	                                        cpf2 = ler.nextLong();
	 
	                                        System.out.println(cadastroCliente.procurarCliente(cpf2));
	 
	                                        break;
	                                case 4:
	                                	System.out.println("Digite CPF do Cliente: ");
	                                	
	                                	break;
	 
	                                default:
	                                        System.out.println("Op��o inv�lda");
	                                        break;
	 
	                                }
                                }while(opcao2 != 0);
 
                                break;
                        case 2:// Administrar Treinador
                        		int opcao3;
                                
                                do{
	                                	System.out.println("0- Voltar \n1-Cadastrar Treinador \n2-Remover Treinador \n3-Exibir Treinador");
		                                opcao3 = ler.nextInt();
		                                switch (opcao3) {
		                                case 0:
		                                	opcao3 = 0;
	                                        break;
	                                        
		                                case 1: 
		                                String nomeTreinador;
		                                ler.nextLine();
		                                System.out.println("Nome: ");
		                                nomeTreinador = ler.nextLine();
		        
		                                System.out.println("CPF: ");
		                                long cpf;
		                                cpf = ler.nextLong();
		                                ler.nextLine();
		                              
		                                System.out.println("Digite um usuario");
		                                String usuario = ler.nextLine();
		                                System.out.println("Digite uma senha");
		                                String senha = ler.nextLine();
		                                
		                                Login login = new Login(usuario,senha);
		                                
		                                
		                                Treinador treinador = new Treinador(nomeTreinador,cpf,login);
		                                
											try {
												if(!cadastrarLogin.loginExiste(login)){	
												cadastroTreinador.cadastrarTreinador(treinador);
												}
											} catch (ObjetoJaExisteException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
		                                
		                                        break;
		                                case 2:
		                                        System.out.println("Digite o CPF do Treinador que voc� deseja remover");
		                                        long cpfT;
		                                        cpfT = ler.nextLong();
		                                        		                                        
		                                        cadastroTreinador.removerTreinador(cpfT);
		                                        
		                                        ler.nextLine();
		                                       
		                                        break;
		                                case 3:
		                                       
		                                        System.out.println("Digite o CPF Treinador que voc� deseja exibir");
		                                        long cpfT2;
		                                        cpfT2 = ler.nextLong();
		                                        System.out.println(cadastroTreinador.procurarTreinador(cpfT2));
		                                       
		                                       
		                                        break;
		                                       
		                                default:
		                                        System.out.println("opcao invalida");
		                                       
		                                        break;
		                                }
                                }while(opcao3 != 0);
                                break;
 
                        case 3: // Administrar Aulas
                        		int opcao4;

                                do{
	                                System.out.println("0- Voltar \n1-Cadastrar Aulas \n2-Remover Aulas \n3-Exibir Aulas");
	                                opcao4 = ler.nextInt();
	                                switch (opcao4) {
	                                
	                                case 0: 
	                                	opcao4 = 0;
                                        break;
	 
	                                case 1: 
	                                	// Cadastrar Aulas
	                            		Aula aula;
	                            		String nomeAula;
	                            		ler.nextLine();
	                            		System.out.println("Nome da aula: ");
	                            		nomeAula = ler.nextLine();
	                            	
	                            		System.out.println("Dia da semana que a aula ser� realizada: ");
	                            		String diaAula =ler.nextLine();
	                            		
	                            		System.out.println("Digite a hora da aula: ");
	                            		String horaAula = ler.nextLine();
	                            		
	                            		aula = new Aula(nomeAula, diaAula, horaAula); 
	                            		try {
											cadastroAula.cadastrarAulas(aula);
										} catch (ObjetoJaExisteException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
	                                	
	                                	
	                             
	                                	System.out.println(cadastroAula.procurarAula(aula.getNomeDaAula()));
	                                	
	 
	                                        break;
	                                case 2: 
	                                	System.out.println("Digite o nome da aula a ser removida: ");
	                                	String nomeAulaRemover = ler.nextLine();
	                                	Aula aulaRemover = cadastroAula.procurarAula(nomeAulaRemover);
	                                	if(aulaRemover != null){
	                                		//cadastroAula.removerCliente(nomeAulaRemover);
	                                	}else{
	                                		System.out.println("Aula n�o encontrada");
	                                	}
	                                        break;
	                                	
	                                        
	                                case 3:
	                                
	                                	/*Aula[] aulas;
	                                	//aulas = cadastroAula.exibir();
	                                	int i = 0;

	                            		while (aulas[i] != null) {

	                            			System.out.println("nome da aula: "+ aulas[i].getNomeDaAula()+ "\nDia: " + aulas[i].getDiaDaSemana() + "\nHora: " + aulas[i].getHoraDaAula());
	                            			i++;
	                            		}
	                                	
	                                        break;
	                                        */

	                                default:
	                                	System.out.println("Opcao invalida");
	                                        break;
	                                }
	                                } while (opcao4 != 0);
	                                	break;
                                case 4:
	                                	
                               /* Calendar dataHoje = Calendar.getInstance();
                                Cliente clienteExibirMensalidade[];
                                //clienteExibirMensalidade = cadastroCliente.exibir();
  
                        		int i = 0;
                     		dataHoje = Calendar.getInstance();
                     		Calendar dataHojeMaisUmMes = Calendar.getInstance();
                     		dataHojeMaisUmMes.set(Calendar.MONTH, dataHojeMaisUmMes.get(Calendar.MONTH +6));
                     		System.out.println("Clientes proximos a vencer o plano: ");
                     		
                     		while (clienteExibirMensalidade[i] != null) {
                     			if(dataHojeMaisUmMes.before(clienteExibirMensalidade[i].getDataFinal())){
                     				System.out.println("Nome do cliente: "+ clienteExibirMensalidade[i].getNome() + "\tData de vencimento: " + clienteExibirMensalidade[i].getDataFinal().get(Calendar.DAY_OF_MONTH) + "/" + clienteExibirMensalidade[i].getDataFinal().get(Calendar.MONTH) + "/" + clienteExibirMensalidade[i].getDataFinal().get(Calendar.YEAR));
                     				i++;
                     			}else{
                     				i++;
                     			}
                     		}*/
                     		
                     		break;
	                   
                     		
                        default:
 
                                System.out.println("Op��o � invalida");
                                break;
                        }
                        
                    }while(opcao1 != 0);

                    break;

            case 2: // Menu Cliente

            	int opcao3; 
                do{
                    System.out.println("0- Voltar \n1-Exibir Treino \n2- TOP 10 (Melhores Clientes) ");
                    opcao3 = ler.nextInt();
                    switch (opcao3) {// Menu Administrar Cliente - 2
                    case 0:
                    	opcao3 = 0;
                    	break;
                    	
                    case 1:
                        
                        System.out.println("Digite o CPF: ");
                        String nome = ler.nextLine();
                       Treino treinoExibir = cadastroTreino.procurarTreino(nome);
                       // System.out.println("Nome: " + treinoExibir.getCliente().getNome());
                       // Treino treino[];
                      // treino = cadastroTreino.exibir();
                		// i = 0;

                		//while (treino[i] != null ) {

                			//if(treinoExibir.getCliente().getCpf() == treino[i].getCliente().getCpf()){
                			//	System.out.println("Nome do exercicio: "+ treino[i].getNomeExercicio() + "\tReticoes: " + treino[i].getRepeticao());
                			//	i++;
                			//}else{
                			//	i++;
                			//}
                		//}
                        
                       // Date data = new Date();
                        //Presenca presenca = new Presenca(treinoExibir.getCliente(), treinoExibir, data);
                      
                            

                            break;
                    case 2://  exibe lista do TOP 10
                            
                            break;

                    

                    default:
                            System.out.println("Op��o inv�lda");
                            break;

                    }
                }while(opcao3 != 0);

                    break;
                    
            case 3: // Menu Treinador
            	
            	int opcao4; 
                do{
                    System.out.println("0- Voltar \n1-Cadastrar Treino \n2-Lista Alunos ");
                    opcao4 = ler.nextInt();
                    switch (opcao4) {// Menu Administrar Treino 
                    case 0:
                    	opcao4 = 0;
                    	break;
                    	
                    case 1:// Cadastrar Treino
                    	 System.out.println("Digite o CPF do Cliente para criar um treino: ");
                    	 long cpfCliente = ler.nextLong();
                    	 ler.nextLine();
                    	 
                    	 Cliente clienteCriarTreino;
                    	 
                    	 clienteCriarTreino = cadastroCliente.procurarCliente(cpfCliente);
                    	 System.out.println("Nome do Cliente: " + clienteCriarTreino.getNome());
                    	 System.out.println("\nNome do Treino: ");
                    	 String nomeTreino = ler.nextLine();
                    	 
                    	 int i = 1;
                    	 while(i !=0 ){
                   
                         	
                         	System.out.println("\nNome do exercicio: ");
                         	String nomeExercicio = ler.nextLine();
                         	
                         	
                         	System.out.println("\nRepeticoes: ");
                         	int repeticoes = ler.nextInt();
                         	
                         	ler.nextLine();
                    	 	Treino treino = new Treino(nomeTreino, nomeExercicio,repeticoes, clienteCriarTreino);
                    	 	try {
								cadastroTreino.cadastrarTreino(treino);
							} catch (ObjetoJaExisteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                    	 	System.out.println("Para cadastrar outro exercicio digite 1 ou digite 0 para sair");
                    	 	i = ler.nextInt();
                    	 }
                    
                            break;
               
                    case 2://  exibe lista do TOP 10
                            
                            break;

                    

					default:
						System.out.println("Op��o inv�lda");
                            break;

                    }
                }while(opcao4!= 0);

                    break;
         
		
		}
	
		} while(opcao!=0);
		
	}
}
