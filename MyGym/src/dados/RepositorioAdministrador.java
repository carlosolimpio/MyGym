package dados;
import classesBasicas.Administrador;

public class RepositorioAdministrador extends Repositorio<Administrador> implements IRepositorioAdministrador{

	private static RepositorioAdministrador repositorioAdministrador;
	
	public RepositorioAdministrador() {
		super("Administrador");
		
	}
		public static IRepositorioAdministrador getInstance() {
			if (repositorioAdministrador == null) {
				repositorioAdministrador = new RepositorioAdministrador();
			}

			return repositorioAdministrador;
		}
		 
		@Override
		public void cadastrar(Administrador administrador) {
			super.cadastrar(administrador); // chama repositorio para cadastrar um objeto
		}
		
		@Override
		public void remover(Administrador administrador) {
			super.remover(administrador); // chama repositorio para remover um objeto
		}
		
		@Override
		public Administrador procurar(long cpf) {
			for (Administrador administrador : super.getLista()) {
				if(administrador.getCpf() == cpf){
					return administrador;
				}
			}
			return null;
		}
		
		@Override
		public Administrador atualizar(Administrador administrador) {
			
			return super.atualizar(administrador); // chama repositorio para atualizar um objeto
		}

		
		

	}


