package dados;

import java.util.Calendar;
import java.util.Date;

import classesBasicas.Presenca;
import classesBasicas.Treinador;

public class RepositorioPresenca {

	private Presenca[] presenca;
	private int proxima;

	public RepositorioPresenca(int tamanho) {

		this.presenca = new Presenca[tamanho];
		this.proxima = 0;
	}
	
	private int procurarIndice(long cpf) {

		int i = 0;

		boolean achou = false;

		while ((!achou) && (i < this.proxima)) {

			if (cpf == this.presenca[i].getCliente().getCpf()) {

				achou = true;

			} else {

				i = i + 1;

			}

		}

		return i;

	}
	
	private void duplicaArrayPresenca() {

		if (this.presenca != null && this.presenca.length > 0) {

			Presenca[] arrayDuplicado = new Presenca[this.presenca.length * 2];

			for (int i = 0; i < this.presenca.length; i++) {

				arrayDuplicado[i] = this.presenca[i];

			}

			this.presenca = arrayDuplicado;

		}

	}
	
	public boolean existe(long cpf) {

		boolean existe = false;

		int indice = this.procurarIndice(cpf);

		if (indice != proxima) {

			existe = true;

		}

		return existe;

	}
	
	public void cadastrar(Presenca p) {

		this.presenca[this.proxima] = p;

		this.proxima = this.proxima + 1;

		if (this.proxima == this.presenca.length) {

			this.duplicaArrayPresenca();

		}

	}
	
	public Presenca procurar(long cpf) {

		int i = this.procurarIndice(cpf);

		Presenca resultado = null;

		if (i != this.proxima) {

			resultado = this.presenca[i];

		}

		return resultado;

	}

	public void remover(long cpf) {

		int i = this.procurarIndice(cpf);

		if (i != this.proxima) {

			this.presenca[i] = this.presenca[this.proxima - 1];

			this.presenca[this.proxima - 1] = null;

			this.proxima = this.proxima - 1;

		} else {

		}
	}
	

	public Presenca[] exibirPresenca(){
		return this.presenca;
	}
	
}
	