package modelo;

/**
 * Classe que contém os atributos do diretor e herda de Pessoa.
 * 
 * @author Gustavo, Felipe
 * @since 2023
 * @version 1.0
 */

public class Diretor extends Pessoa {
	// Atributos
	private int trabalhosProduzidos;
	
	// Construtor
	
	/**
	 * Cria um objeto da classe Diretor.
	 * 
	 * @param nome do diretor
	 * @param idade do diretor
	 * @param trabalhosProduzidos Qtd de trabalhos produzidos pelo diretor
	 */
	
	public Diretor(String nome, int idade, int trabalhosProduzidos) {
		this.nome = nome;
		this.idade = idade;
		this.trabalhosProduzidos = trabalhosProduzidos;
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
	
	public void setTrabalhosProduzidos(int trabalhosProduzidos) {
		this.trabalhosProduzidos = trabalhosProduzidos;
	}
	
	public int getTrabalhosProduzidos() {
		return trabalhosProduzidos;
	}
}


