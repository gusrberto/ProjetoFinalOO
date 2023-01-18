package modelo;

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

