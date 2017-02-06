package excecoes;

import classesBasicas.Entidade;



public class ObjetoJaExisteException extends Exception {
	
	private Entidade objeto;

	public ObjetoJaExisteException(Entidade obj) {

		super("Não foi possível cadastrar, objeto já existe"
				+ obj.toString() + "\n");
		this.setObjeto(obj);
	}

	public Entidade getObjeto() {
		return objeto;
	}

	public void setObjeto(Entidade objeto) {
		this.objeto = objeto;
	}

}
