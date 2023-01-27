package modelo;

/**
 * Classe abstrata que contém os atributos de pessoa.
 * 
 * @author Gustavo, Felipe
 * @since 2023
 * @version 1.0
 */

public abstract class Pessoa {
	// Atributos
	protected String nome;
	protected int idade;
	
	// Construtor
	public Pessoa() {
		super();
	}
	// Gets e Sets
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public int getIdade() {
		return idade;
	}
}

