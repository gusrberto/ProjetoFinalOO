package modelo;

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
    public Canal() {
    	super();
    }
    
    public Canal(String nome, String emissora, int numCanal, String publicoAlvo,
    		int qtdProgramas, boolean favorito) {
    	this.nome = nome;
    	this.emissora = emissora;
    	this.numeroCanal = numCanal;
    	this.publicoAlvo = publicoAlvo;
    	this.qtdProgramas = qtdProgramas;
    	this.favorito = favorito;
    }
    
    // to String
    public String toString() {
    	return "Nome do canal: " + nome + "\nEmissora: " + emissora +
    			"\nNumero do canal: " + numeroCanal + "\nPublico Alvo: " + publicoAlvo;
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
    // Métodos
    public void adicionarPrograma(Programa p) {
    	programas[this.getQtdProgramas()] = p;
    	this.setQtdProgramas(this.getQtdProgramas()+1);
    }
    
    public void listarProgramacao() {
    	System.out.println("--------PROGRAMACAO DIARIA (" + this.getNome() + ")--------");
    	for (int i = 0; i < this.getQtdProgramas(); i++) {
    		System.out.println(programas[i].getNome() + " - " + 
    		programas[i].getHorarioDeExibicao() + " horas");
    	}
    	System.out.println("------------------------------------------");
    }
}

