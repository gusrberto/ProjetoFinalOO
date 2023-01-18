package modelo;

public class Usuario extends Pessoa {
	// Atributos
	private String nickname;
	private Canal[] canaisFavoritos = new Canal[30]; 
	private int qtdCanaisFav;
	
	// Construtor
	public Usuario(String nome, int idade, String nickname, int qtdCanaisFav) {
		this.nome = nome;
		this.idade = idade;
		this.nickname = nickname;
		this.qtdCanaisFav = qtdCanaisFav;
	}
	
	// Gets e Sets
	public void setApelido(String nickname) {
		this.nickname = nickname;
	}
	
	public String getApelido() {
		return nickname;
	}
	
	public void setCanaisFavoritos(Canal[] c) {
		this.canaisFavoritos = c;
	}
	
	public Canal[] getCanaisFavoritos() {
		return canaisFavoritos;
	}
	
	public void setQtdCanaisFav(int qtdCanais) {
		this.qtdCanaisFav = qtdCanais;
	}
	
	public int getQtdCanaisFav() {
		return qtdCanaisFav;
	}
	
	// Métodos
	public void adicionarCanalFavorito(Canal c) {
		canaisFavoritos[this.getQtdCanaisFav()] = c;
		this.setQtdCanaisFav(this.getQtdCanaisFav()+1);
	}
}
