package modelo;

public class Ator extends Pessoa {
	// Atributos
	private String funcao;
	
	// Construtor
	public Ator(String nome, int idade, String funcao) {
		this.nome = nome;
		this.idade = idade;
		this.funcao = funcao;
	}
	
	// Gets e Sets
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public String getFuncao() {
		return funcao;
	}
}


