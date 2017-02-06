package classesBasicas;

	public class Aula extends Entidade{
		
		private String nomeAula;
		private String diaDaSemana;
		private String horaDaAula;
		
		public Aula(String aula, String diaDaSemana, String horaDaAula){
			setNomeAula(aula);
			setDiaDaSemana(diaDaSemana);
			setHoraAula(horaDaAula);
		}
		
		public void setNomeAula(String nomeAula){
			this.nomeAula = nomeAula;
		}
		
		public void setDiaDaSemana(String diaDaSemana){
			this.diaDaSemana = diaDaSemana;
		}
		
		public void setHoraAula(String horaDaAula){
			this.horaDaAula = horaDaAula;
		}
		
		public String getNomeDaAula(){
			return nomeAula;
		}
		public String getDiaDaSemana(){
			return diaDaSemana;
		}
		public String getHoraDaAula() {
			return horaDaAula;
		}
		
		
		public String toString() {
			
			return "\nNome Aula: " + this.nomeAula + "\nDia da semana: " + this.diaDaSemana + "\nHora: " +  this.horaDaAula;
		}

}
