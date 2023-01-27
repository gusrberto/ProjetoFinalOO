package modelo;

public class Diretor extends Pessoa {
	// Atributos
	private int trabalhosProduzidos;
	
	// Construtor
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


