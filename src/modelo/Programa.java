package modelo;

public class Programa {
	// Atributos
	private String nome;
	private boolean[] diaDeExibicao = new boolean[7];
	private int horarioDeExibicao;
	private int minExibicao;
	private String genero;
	private String classificacaoIndicativa;
	private Ator[] elenco = new Ator[30];
	private int duracao;
	private int indexHrs, indexMin, indexCanal;
	private String canal;
	
	// Construtor
	public Programa() {
		super();
	}
	
	public Programa(String nome, boolean[] diaDeExibicao, int horarioDeExibicao,
			int minExibicao, String genero, String classInd, int duracao, int indexHrs,
			int indexMin, String canal, int indexCanal) {
		this.nome = nome;
		this.diaDeExibicao = diaDeExibicao;
		this.horarioDeExibicao = horarioDeExibicao;
		this.minExibicao = minExibicao;
		this.genero = genero;
		this.duracao = duracao;
		this.classificacaoIndicativa = classInd;
		this.indexHrs = indexHrs;
		this.indexMin = indexMin;
		this.canal = canal;
		this.indexCanal = indexCanal;
	}
	
	// to String
	public String toString() {
		return "Nome do programa: " + nome +"\nDia de Exibicao: " + diaDeExibicao + " as " + 
				horarioDeExibicao + " horas" + "\nGenero: " + genero +
				"\nClassificacao Indicativa: " + classificacaoIndicativa + "\nDuracao: " + duracao + " minutos"
				+ "\nTamanho do elenco: ";
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
	
	public void setMinExibicao(int minExibicao) {
		this.minExibicao = minExibicao;
	}
	
	public int getMinExibicao() {
		return minExibicao;
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
	
	public void setElenco(Ator[] func) {
		this.elenco = func;
	}
	
	public Ator[] getElenco() {
		return this.elenco;
	}
	
	public void setIndexHrs(int indexHrs) {
		this.indexHrs = indexHrs;
	}
	
	public int getIndexHrs() {
		return indexHrs;
	}
	
	public void setIndexMin(int indexMin) {
		this.indexMin = indexMin;
	}
	
	public int getIndexMin() {
		return indexMin;
	}
	
	public void setIndexCanal(int indexCanal) {
		this.indexCanal = indexCanal;
	}
	
	public int getIndexCanal() {
		return indexCanal;
	}
	
	public void setCanal(String canal) {
		this.canal = canal;
	}
	
	public String getCanal() {
		return canal;
	}
	
	
}

