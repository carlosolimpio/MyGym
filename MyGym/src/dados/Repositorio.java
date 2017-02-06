package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

import classesBasicas.Administrador;
import classesBasicas.Entidade;

public abstract class Repositorio<E extends Entidade> {
	
	private ArrayList<E> repositorio;
	
	private String nomeRepositorio;
	
	public Repositorio(String nome){
		this.nomeRepositorio = nome;
		this.repositorio = this.lerDoArquivo();
	}

	private ArrayList<E> lerDoArquivo() {
		ArrayList<E> repositorioLocal = null;

		File file = new File(this.nomeRepositorio + ".txt");
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;

		try {

			fileInputStream = new FileInputStream(file);
			objectInputStream = new ObjectInputStream(fileInputStream);
			Object object = objectInputStream.readObject();

			repositorioLocal =  (ArrayList<E>) object;
		} catch (Exception exception) {
			repositorioLocal = new ArrayList<E>();
		} finally {
			if (objectInputStream != null) {
				try {
					objectInputStream.close();
				} catch (IOException e) {
					/* Silent exception */
				}
			}
		}

		return repositorioLocal;
	}
	
	protected void salvarNoArquivo() {
		File file = new File(this.nomeRepositorio + ".txt");
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;

		try {
			fileOutputStream = new FileOutputStream(file);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(repositorio);
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			if (objectOutputStream != null) {
				try {
					objectOutputStream.close();
				} catch (Exception e) {
					/* Silent exception */
				}
			}
		}
	}
	
	public ArrayList<E> getLista() {
		return this.repositorio;
	}

	public void cadastrar(E entidade) {
		if (repositorio.size() > 0) {
			entidade.setId(repositorio.get(repositorio.size() - 1).getId() + 1);
		} else {
			entidade.setId(1);
		}
		
		entidade.setDataCriacao(new Date());
			
		repositorio.add(entidade);
		salvarNoArquivo();
	}

	public void remover(E entidade) {
		repositorio.remove(entidade);
		salvarNoArquivo();
	}

	public E procurar(int id) {
		for (E entidade: repositorio) {
			if (entidade.getId() == id) {
				return entidade;
			}
		}

		return null;
	}

	public E atualizar(E entidade) {
		E aux = null;
		
		for (int i = 0; i < repositorio.size(); i++) {
			if (repositorio.get(i).getId() == entidade.getId()) {
				repositorio.set(i, entidade);				
				aux = repositorio.get(i);
			}
		}
		
		salvarNoArquivo();
		
		return aux;
	}

	

}
