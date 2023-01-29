package modelo;

/**
 * Classe que contém os atributos de canal.
 * 
 * @author Gustavo, Felipe
 * @since 2023
 * @version 1.0
 */

public class Canal {
	// Atributos
	private String nome;
    private String emissora;
    private int numeroCanal;
    private String publicoAlvo;
    private int qtdProgramas;
    private boolean favorito;
    private Programa[] programas = new Programa[30];
    
    // Construtor
    
    /**
     * Cria um objeto da classe Canal.
     * 
     * @param nome do canal
     * @param emissora do canal
     * @param numCanal Número do canal
     * @param publicoAlvo do canal
     * @param qtdProgramas cadastrados no canal
     * @param favorito Boolean que verifica se o canal foi favoritado
     * @param programas Array de objetos da classe programa
     */
    
    public Canal(String nome, String emissora, int numCanal, String publicoAlvo,
    		int qtdProgramas, boolean favorito, Programa[] programas) {
    	this.nome = nome;
    	this.emissora = emissora;
    	this.numeroCanal = numCanal;
    	this.publicoAlvo = publicoAlvo;
    	this.qtdProgramas = qtdProgramas;
    	this.favorito = favorito;
    	this.programas = programas;
    }
    
    // Métodos
    
    /**
     * Adiciona um programa a classe Canal.
     * 
     * @param p Objeto da classe Programa
     * @param pos Posição do objeto na array de programas
     */
    
    public void adicionarPrograma(Programa p, int pos) {
    	this.programas[pos] = p;
    	if (pos == qtdProgramas) {
			qtdProgramas++;
		}
    }
    
    // Gets e Sets
    public void setNome(String nome) {
    	this.nome = nome;
    }
    
    public String getNome() {
    	return nome;
    }
    
    public void setEmissora(String emissora) {
    	this.emissora = emissora;
    }
    
    public String getEmissora() {
    	return emissora;
    }
    
    public void setNumCanal(int numCanal) {
    	this.numeroCanal = numCanal;
    }
    
    public int getNumCanal() {
    	return numeroCanal;
    }
    
    public void setPublicoAlvo(String publicoAlvo) {
    	this.publicoAlvo = publicoAlvo;
    }
    
    public String getPublicoAlvo() {
    	return publicoAlvo;
    }
    
    public void setProgramas(Programa[] p) {
    	this.programas = p;
    }
    
    public Programa[] getProgramas() {
    	return programas;
    }
    
    public void setQtdProgramas(int qtdProgramas) {
    	this.qtdProgramas = qtdProgramas;
    }
    
    public int getQtdProgramas() {
    	return qtdProgramas;
    }
    
    public void setFavorito(boolean favorito) {
    	this.favorito = favorito;
    }
    
    public boolean getFavorito() {
    	return favorito;
    }
}

