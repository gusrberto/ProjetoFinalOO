package modelo;

/**
 * Classe que contém os atributos do usuário e herda de Pessoa.
 * 
 * @author Gustavo, Felipe
 * @since 2023
 * @version 1.0
 */

public class Usuario extends Pessoa {
	// Atributos
	private String nickname;
	
	// Construtor
	
	/**
	 * Cria um objeto da classe Usuario.
	 * 
	 * @param nome do usuário
	 * @param idade do usuário
	 * @param nickname do usuário
	 */
	
	public Usuario(String nome, int idade, String nickname) {
		this.nome = nome;
		this.idade = idade;
		this.nickname = nickname;
	}
	
	// Gets e Sets
	public void setApelido(String nickname) {
		this.nickname = nickname;
	}
	
	public String getApelido() {
		return nickname;
	}
	
}
