package classesBasicas;

import java.io.Serializable;
import java.util.Date;

	public class Entidade implements Serializable, Comparable<Entidade> {
		private static final long serialVersionUID = 1L;
		
		protected int id = -1;
		protected Date dataCriacao;

		public Entidade() {
			
		}
		
		public Entidade(int id, Date dataCriacao) {
			this.id = id;
			this.dataCriacao = dataCriacao;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Date getDataCriacao() {
			return dataCriacao;
		}

		public void setDataCriacao(Date dataCriacao) {
			this.dataCriacao = dataCriacao;
		}

		@Override
		public int compareTo(Entidade o) {
			return getDataCriacao().compareTo(o.getDataCriacao());
		}
}
