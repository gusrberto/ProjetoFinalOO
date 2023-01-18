package modelo;

public class Programa {
	// Atributos
	private String nome;
	private boolean[] diaDeExibicao = new boolean[7];
	private int horarioDeExibicao;
	private String genero;
	private String classificacaoIndicativa;
	private Ator[] elenco = new Ator[30];
	private int tamElenco = 0;
	private int duracao;
	
	// Construtor
	public Programa() {
		super();
	}
	
	public Programa(String nome, boolean[] diaDeExibicao, int horarioDeExibicao,
			String genero, int duracao, int tamElenco) {
		this.nome = nome;
		this.diaDeExibicao = diaDeExibicao;
		this.horarioDeExibicao = horarioDeExibicao;
		this.genero = genero;
		this.duracao = duracao;
		this.tamElenco = tamElenco;
	}
	
	// to String
	public String toString() {
		return "Nome do programa: " + nome +"\nDia de Exibicao: " + diaDeExibicao + " as " + 
				horarioDeExibicao + " horas" + "\nGenero: " + genero +
				"\nClassificacao Indicativa: " + classificacaoIndicativa + "\nDuracao: " + duracao + " minutos"
				+ "\nTamanho do elenco: " + tamElenco;
	}
	// Gets e Sets
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setDiaDeExibicao(boolean[] diaDeExibicao) {
		this.diaDeExibicao = diaDeExibicao;
	}
	
	public boolean[] getDiaDeExibicao() {
		return diaDeExibicao;
	}
	
	public void setHorarioDeExibicao(int horarioDeExibicao) {
		this.horarioDeExibicao = horarioDeExibicao;
	}
	
	public int getHorarioDeExibicao() {
		return horarioDeExibicao;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setClassIndicativa(String classInd) {
		this.classificacaoIndicativa = classInd;
	}
	
	public String getClassIndicativa() {
		return classificacaoIndicativa;
	}	
	
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	public void setTamElenco(int tamElenco) {
		this.tamElenco = tamElenco;
	}
	
	public int getTamElenco() {
		return tamElenco;
	}
	
	public void setElenco(Ator[] func) {
		this.elenco = func;
	}
	
	public Ator[] getElenco() {
		return this.elenco;
	}
	
	
	// Métodos
	public void adicionarAtor(Ator f) {
		elenco[this.getTamElenco()] = f;
		this.setTamElenco(this.getTamElenco()+1);
	}
	
	public void listarElenco() {
		System.out.println("--------ELENCO (" + this.getNome() + ")--------");
		for (int i = 0; i < this.getTamElenco(); i++) {
			System.out.println(elenco[i].getNome() + ", " + elenco[i].getIdade() + " anos" +
			" - " + elenco[i].getFuncao());
		}
		System.out.println("---------------------------------------");
	}
	
}

