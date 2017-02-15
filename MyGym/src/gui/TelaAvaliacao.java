package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.ldap.Rdn;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import negocios.MyGymFachada;
import classesBasicas.Avaliacao;
import excecoes.ObjetoJaExisteException;
import excecoes.UsuarioJaExisteException;


public class TelaAvaliacao extends JFrame{
	
	 private JTextField textFieldObjetivo;
	 private JTextField textFieldMedicamentos;
	 private JTextField textFieldDoencaFamiliar;
	 private JTextField textFieldObservacoes;
	 private JTextField textFieldIdadeAvaliacao;
	 private JTextField textFieldPesoAvaliacao;
	 private JTextField textFieldExerciciosFisicosAvaliacao;
	 private JTextField textFieldHistorioFamiliarAvaliacao;
	 private JTextField textFieldObservacoesRiscosCoronariano;
	  private String fumante = "";
	 private String sexo = "";
	 private String cirurgia ="";
	  private String atividadeFisica = "";
	 
	 
	 public TelaAvaliacao() {
			super("My Gym Cadastro Cliente- Avaliação");
			initialize();
		}
		private void initialize() {
	
	
	this.setBounds(0, 0, 710, 500);
	getContentPane().setLayout(null);
	
	JLabel lblCliente= new JLabel("Cliente");
	lblCliente.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
	lblCliente.setBounds(10, 11, 178, 25);
	getContentPane().add(lblCliente);
	
	JLabel lbltitulo = new JLabel("(Avalia\u00E7\u00E3o F\u00EDsica)-- ANAMNESE");
	lbltitulo.setFont(new Font("Tahoma", Font.BOLD, 11));
	lbltitulo.setBounds(10, 40, 178, 14);
	getContentPane().add(lbltitulo);
	
	JLabel lblObjetivo = new JLabel("Objetivos rela\u00E7\u00E3o \u00E0 atividade f\u00EDsica?");
	lblObjetivo.setBounds(10, 59, 178, 14);
	getContentPane().add(lblObjetivo);
	
	textFieldObjetivo = new JTextField();
	textFieldObjetivo.setBounds(10, 78, 263, 20);
	getContentPane().add(textFieldObjetivo);
	textFieldObjetivo.setColumns(10);
	
	JLabel lblPraticaAtividade = new JLabel("Pratica Atividade f\u00EDsica atualmente?");
	lblPraticaAtividade.setBounds(10, 104, 178, 14);
	getContentPane().add(lblPraticaAtividade);
	
	ButtonGroup PraticaAtividade = new ButtonGroup();
	 
	final JRadioButton rdbtnSimPraticaAtividade = new JRadioButton("Sim");
	rdbtnSimPraticaAtividade.setBounds(6, 125, 60, 23);
	PraticaAtividade.add(rdbtnSimPraticaAtividade);
	getContentPane().add(rdbtnSimPraticaAtividade);
	//
	
	final JRadioButton rdbtnNaoPraticaAtividade = new JRadioButton("N\u00E3o");
	rdbtnNaoPraticaAtividade.setBounds(72, 125, 95, 23);
	rdbtnNaoPraticaAtividade.setSelected(true);
	PraticaAtividade.add(rdbtnNaoPraticaAtividade);
	getContentPane().add(rdbtnNaoPraticaAtividade);
	//
	
	JLabel lblMedicamentos = new JLabel("Digite os nomes dos medicamentos que voc\u00EA utiliza :");
	lblMedicamentos.setBounds(10, 155, 263, 14);
	getContentPane().add(lblMedicamentos);
	
	textFieldMedicamentos = new JTextField();
	textFieldMedicamentos.setBounds(10, 174, 263, 20);
	getContentPane().add(textFieldMedicamentos);
	textFieldMedicamentos.setColumns(10);
	
	JLabel lblCirurgia = new JLabel("J\u00E1 passou por alguma cirurgia?");
	lblCirurgia.setBounds(10, 201, 157, 14);
	getContentPane().add(lblCirurgia);
	
	ButtonGroup algumaCirurgia = new ButtonGroup();
	final JRadioButton rdbtnSimCirugia = new JRadioButton("Sim");
	rdbtnSimCirugia.setBounds(6, 222, 60, 23);
	algumaCirurgia.add(rdbtnSimCirugia);
	getContentPane().add(rdbtnSimCirugia);
	
	final JRadioButton rdbtnNaoCirurgia = new JRadioButton("N\u00E3o");
	rdbtnNaoCirurgia.setBounds(72, 222, 60, 23);
	rdbtnNaoCirurgia.setSelected(true);
	algumaCirurgia.add(rdbtnNaoCirurgia);
	getContentPane().add(rdbtnNaoCirurgia);
	
	JLabel lblNewLabel = new JLabel("Alguma doen\u00E7a na fam\u00EDlia? Insira os nomes das Doen\u00E7as : ");
	lblNewLabel.setBounds(10, 247, 285, 14);
	getContentPane().add(lblNewLabel);
	
	textFieldDoencaFamiliar = new JTextField();
	textFieldDoencaFamiliar.setBounds(10, 262, 272, 54);
	getContentPane().add(textFieldDoencaFamiliar);
	textFieldDoencaFamiliar.setColumns(10);
	
	JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es:");
	lblObservaes.setBounds(10, 327, 78, 14);
	getContentPane().add(lblObservaes);
	
	textFieldObservacoes = new JTextField();
	textFieldObservacoes.setBounds(10, 343, 272, 54);
	getContentPane().add(textFieldObservacoes);
	textFieldObservacoes.setColumns(10);
	
	JLabel lblavaliaoFsicaRiscos = new JLabel("(Avalia\u00E7\u00E3o F\u00EDsica)-- RISCOS CORONARIANO");
	lblavaliaoFsicaRiscos.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblavaliaoFsicaRiscos.setBounds(360, 40, 254, 14);
	getContentPane().add(lblavaliaoFsicaRiscos);
	
	JLabel lblIdade = new JLabel("Idade:");
	lblIdade.setBounds(360, 59, 44, 14);
	getContentPane().add(lblIdade);
	
	textFieldIdadeAvaliacao = new JTextField();
	textFieldIdadeAvaliacao.setBounds(360, 78, 86, 20);
	getContentPane().add(textFieldIdadeAvaliacao);
	textFieldIdadeAvaliacao.setColumns(10);
	
	JLabel lblSexo = new JLabel("Sexo:");
	lblSexo.setBounds(497, 59, 46, 14);
	getContentPane().add(lblSexo);


	ButtonGroup sexoGroup = new ButtonGroup();
	 
	final JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
	rdbtnMasculino.setBounds(497, 78, 95, 23);
	rdbtnMasculino.setSelected(true);
	sexoGroup.add(rdbtnMasculino);
	getContentPane().add(rdbtnMasculino);
	//
	
	final JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
	rdbtnFeminino.setBounds(497, 100, 95, 23);
	sexoGroup.add(rdbtnFeminino);
	getContentPane().add(rdbtnFeminino);
	
	JLabel lblPeso = new JLabel("Peso:");
	lblPeso.setBounds(360, 104, 60, 14);
	getContentPane().add(lblPeso);
	
	textFieldPesoAvaliacao = new JTextField();
	textFieldPesoAvaliacao.setBounds(360, 126, 86, 20);
	getContentPane().add(textFieldPesoAvaliacao);
	textFieldPesoAvaliacao.setColumns(10);
	
	JLabel lblExerccioFsico = new JLabel("Exerc\u00EDcios F\u00EDsicos que voc\u00EA  pratica: ");
	lblExerccioFsico.setBounds(360, 155, 183, 14);
	getContentPane().add(lblExerccioFsico);
	
	textFieldExerciciosFisicosAvaliacao = new JTextField();
	textFieldExerciciosFisicosAvaliacao.setBounds(360, 174, 212, 20);
	getContentPane().add(textFieldExerciciosFisicosAvaliacao);
	textFieldExerciciosFisicosAvaliacao.setColumns(10);
	
	JLabel lblTabagismo = new JLabel("Tabagismo:");
	lblTabagismo.setBounds(360, 201, 69, 14);
	getContentPane().add(lblTabagismo);
	
	ButtonGroup tabagismo = new ButtonGroup();
	
	final JRadioButton rdbtnSimTabagismo = new JRadioButton("Sim");
	rdbtnSimTabagismo.setBounds(360, 222, 53, 23);
	tabagismo.add(rdbtnSimTabagismo);
	getContentPane().add(rdbtnSimTabagismo);
	//
	
	final JRadioButton rdbtnNaoTabagismo = new JRadioButton("N\u00E3o");
	rdbtnNaoTabagismo.setBounds(428, 222, 46, 23);
	rdbtnNaoTabagismo.setSelected(true);
	tabagismo.add(rdbtnNaoTabagismo);
	getContentPane().add(rdbtnNaoTabagismo);
	//
	
	JLabel lblHistricoFamiliar = new JLabel("Hist\u00F3rico Familiar:");
	lblHistricoFamiliar.setBounds(360, 247, 95, 14);
	getContentPane().add(lblHistricoFamiliar);
	
	textFieldHistorioFamiliarAvaliacao = new JTextField();
	textFieldHistorioFamiliarAvaliacao.setBounds(360, 262, 228, 25);
	getContentPane().add(textFieldHistorioFamiliarAvaliacao);
	textFieldHistorioFamiliarAvaliacao.setColumns(10);
	
	JLabel lblObservacoesRiscoCoronariano = new JLabel("Observa\u00E7\u00F5es :");
	lblObservacoesRiscoCoronariano.setBounds(360, 298, 86, 14);
	getContentPane().add(lblObservacoesRiscoCoronariano);
	
	textFieldObservacoesRiscosCoronariano = new JTextField();
	textFieldObservacoesRiscosCoronariano.setBounds(359, 315, 228, 54);
	getContentPane().add(textFieldObservacoesRiscosCoronariano);
	textFieldObservacoesRiscosCoronariano.setColumns(10);
	
	JButton btnCancelar = new JButton("Cancelar");
	btnCancelar.setBounds(360, 374, 89, 23);
	getContentPane().add(btnCancelar);
	
	JButton btnCadastrar = new JButton("Cadastrar");
	btnCadastrar.setBounds(499, 374, 89, 23);
	getContentPane().add(btnCadastrar);
	this.setVisible(true);
	//depois da ação do botao
	btnCadastrar.addActionListener(new ActionListener() {  
        @Override    
        public void actionPerformed(ActionEvent evt) {
     
      if(textFieldDoencaFamiliar.getText().equals("") || textFieldExerciciosFisicosAvaliacao.getText().equals("") || textFieldHistorioFamiliarAvaliacao.getText().equals("") || textFieldIdadeAvaliacao.getText().equals("") || textFieldMedicamentos.getText().equals("") || textFieldObjetivo.getText().equals("") || textFieldObservacoes.getText().equals("") || textFieldObservacoesRiscosCoronariano.getText().equals("") || textFieldPesoAvaliacao.getText().equals("")){
    	  JOptionPane.showMessageDialog(null, "Digite todos os campos");
      } else{
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
					Avaliacao avaliacao = new Avaliacao(textFieldObjetivo.getText(), atividadeFisica, textFieldMedicamentos.getText(), cirurgia, textFieldDoencaFamiliar.getText(), textFieldObservacoes.getText(), Integer.parseInt(textFieldIdadeAvaliacao.getText()), sexo, Double.parseDouble(textFieldPesoAvaliacao.getText()), textFieldExerciciosFisicosAvaliacao.getText(), textFieldHistorioFamiliarAvaliacao.getText(), fumante, textFieldObservacoesRiscosCoronariano.getText());
				
            	JOptionPane.showMessageDialog(null, "Avaliacao Cadastrada!");
            	
        	}catch(NumberFormatException e){
        		JOptionPane.showMessageDialog(null, "Campo aceita apenas números");
        	}
      }
	
        }});

	
	
	
	
		}
	
	
}
	