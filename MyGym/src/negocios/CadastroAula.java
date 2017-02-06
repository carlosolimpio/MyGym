package negocios;

import java.util.ArrayList;

import classesBasicas.Aula;
import classesBasicas.Treinador;
import dados.IRepositorioAulas;
import dados.IRepositorioTreinador;
import dados.RepositorioAulas;
import dados.RepositorioTreinador;
import excecoes.ObjetoJaExisteException;
import excecoes.ObjetoNaoExisteException;


public class CadastroAula {

		private IRepositorioAulas repositorioAula;

		public CadastroAula() {
			this.repositorioAula = RepositorioAulas.getInstance();
		}
		
		
		public void removerAula(String nome) throws ObjetoNaoExisteException{
			
			Aula aula = repositorioAula.procurar(nome.toLowerCase());
			  if(aula != null){
			  repositorioAula.remover(aula);
			}else{
				throw new ObjetoNaoExisteException();
			}
		}

		public void cadastrarAulas(Aula aula) throws ObjetoJaExisteException,IllegalArgumentException{
			if (aula == null) {
				throw new IllegalArgumentException("Parametro invalido");
			} else {
				Aula AulaRetornar;

				AulaRetornar = this.repositorioAula.procurar(aula.getNomeDaAula().toLowerCase());

				if (AulaRetornar == null) {
					repositorioAula.cadastrar(aula);
				} else {
					throw new ObjetoJaExisteException(aula);
				}
			}
		}

		public void atualizarAulas(Aula aula) throws ObjetoNaoExisteException,IllegalArgumentException {
			if (aula == null) {
				throw new IllegalArgumentException("Parametro invalido");
			} else {
				Aula aulaRetornar;

				aulaRetornar = this.repositorioAula.atualizar(aula);

				if (aulaRetornar == null) {
					throw new ObjetoNaoExisteException();
				}
			}
		}
		
		public Aula procurarAula(String nome )throws ObjetoNaoExisteException, IllegalArgumentException{
			if (nome.equals("")) {
				throw new IllegalArgumentException("Parametro invalido");
			} else {
				Aula aulaRetornar = this.repositorioAula.procurar(nome.toLowerCase());


				if (aulaRetornar == null) {
					
				throw new ObjetoNaoExisteException();
				}
				return aulaRetornar;
			}
		
	}
		public ArrayList<Aula> listaDeAulas(){
			return this.repositorioAula.listaAulas();
			
		}
}

