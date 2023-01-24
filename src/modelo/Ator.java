package modelo;

public class Ator extends Pessoa {
	// Atributos
	private String papel;
	
	// Construtor
	public Ator(String nome, int idade, String papel) {
		this.nome = nome;
		this.idade = idade;
		this.papel = papel;
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
	
	public void setPapel(String papel) {
		this.papel = papel;
	}
	
	public String getPapel() {
		return papel;
	}
}


