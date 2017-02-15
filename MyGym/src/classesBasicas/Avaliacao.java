package classesBasicas;

import java.io.Serializable;

public class Avaliacao implements Serializable{
	// Anamnese
	private String objetivo;
	private String praticaExercicio;
	private String medicamento;
	private String estadoCirurgia;
	private String doencaFamiliar;
	private String observacoes;

	// Coronariano
	private int idade;
	private String sexo;
	private double peso;
	private String exercicioFisico;
	private String historicoFamiliar;
	private String tabagismo;
	private String observacoes2;

	public Avaliacao(String objetivo, String praticaExercicio,
			String medicamento, String estadoCirurgia, String doencaFamiliar,
			String observacoes, int idade, String sexo, double peso,
			String exercicioFisico, String historicoFamiliar, String tabagismo,
			String observacoes2) {

		setObjetivo(objetivo);
		setPraticaExercicio(praticaExercicio);
		setMedicamento(medicamento);
		setEstadoCirurgia(estadoCirurgia);
		setDoencaFamiliar(doencaFamiliar);
		setObservacoes(observacoes2);
		setIdade(idade);
		setSexo(sexo);
		setPeso(peso);
		setExercicioFisico(exercicioFisico);
		setHistoricoFamiliar(historicoFamiliar);
		setTabagismo(tabagismo);
		setObservacoes2(observacoes2);

	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public void setPraticaExercicio(String praticaExercicio) {
		this.praticaExercicio = praticaExercicio;
	}

	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}

	public void setEstadoCirurgia(String estadoCirurgia) {
		this.estadoCirurgia = estadoCirurgia;
	}

	public void setDoencaFamiliar(String doencaFamiliar) {
		this.doencaFamiliar = doencaFamiliar;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setPeso(double peso) {
		this.peso = peso;

	}

	public void setExercicioFisico(String exercicioFisico) {
		this.exercicioFisico = exercicioFisico;
	}

	public void setHistoricoFamiliar(String historicoFamiliar) {
		this.historicoFamiliar = historicoFamiliar;
	}

	public void setTabagismo(String tabagismo) {
		this.tabagismo = tabagismo;
	}

	public void setObservacoes2(String observacoes2) {
		this.observacoes2 = observacoes2;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public String getPraticaExercicio() {
		return praticaExercicio;
	}

	public String getMedicamento() {
		return medicamento;
	}

	public String getEstadoCirurgia() {
		return estadoCirurgia;
	}

	public String getDoencaFamiliar() {
		return doencaFamiliar;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public int getIdade() {
		return idade;
	}

	public String getSexo() {
		return sexo;
	}

	public double getPeso() {
		return peso;
	}

	public String getExercicioFisico() {
		return exercicioFisico;
	}

	public String getHistoricoFamiliar() {
		return historicoFamiliar;
	}

	public String getTabagismo() {
		return tabagismo;
	}

	public String toString() {

		return "ANAMNESE\n\n" + "Objetivos rela��o � atividade f�sica?\n"
				+ this.objetivo + "\nPratica Atividade f�sica atualmente?\n"
				+ this.praticaExercicio
				+ "\nUtiliza algum tipo de medicamento?\n " + this.medicamento
				+ "\nJ� passou por alguma cirurgia?\n" + this.estadoCirurgia
				+ "\nDoen�a na f�milia?\n" + this.doencaFamiliar
				+ "\nObserva��es:\n" + this.observacoes
				+ "\n\nRISCOS CORONARIANO\n\n" + "Idade:\n" + this.idade
				+ "\nSexo:\n" + this.sexo + "\nPeso:\n" + this.peso
				+ "\nExerc�cio F�sico:\n" + this.exercicioFisico
				+ "\nHist�rico Familiar\n" + this.historicoFamiliar
				+ "\nTabagismo:\n" + this.tabagismo + "\nObserva��es\n"
				+ this.observacoes2;
	}

}
