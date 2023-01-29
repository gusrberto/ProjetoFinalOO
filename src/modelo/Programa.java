package modelo;

/**
 * Classe que contém os atributos de programa.
 * 
 * @author Gustavo, Felipe
 * @since 2023
 * @version 1.0
 */

public class Programa {
	// Atributos
	private String nome;
	private boolean[] diaDeExibicao = new boolean[7];
	private int horarioDeExibicao;
	private int minExibicao;
	private String genero;
	private String classificacaoIndicativa;
	private Diretor diretor;
	private int duracao;
	private int indexHrs, indexMin, indexCanal;
	private String canal;
	
	// Construtor
	
	/**
	 * Cria um objeto da classe Programa.
	 * 
	 * @param nome do programa
	 * @param diaDeExibicao Array boolean com uma posição para cada dia da semana
	 * @param horarioDeExibicao do programa
	 * @param minExibicao do programa
	 * @param genero do programa
	 * @param classInd do programa
	 * @param duracao do programa (em minutos)
	 * @param indexHrs Posição das horas selecionadas no comboBox
	 * @param indexMin Posição dos minutos selecionados no comboBox
	 * @param canal Nome do canal que o programa será transmitido
	 * @param indexCanal Posição do nome do canal selecionado no comboBox
	 * @param diretor do programa
	 */
	
	public Programa(String nome, boolean[] diaDeExibicao, int horarioDeExibicao,
					int minExibicao, String genero, String classInd, int duracao, int indexHrs,
					int indexMin, String canal, int indexCanal, Diretor diretor) {
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
		this.diretor = diretor;
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
	
	public void setDiretor(Diretor d) {
		this.diretor = d;
	}
	
	public Diretor getDiretor() {
		return diretor;
	}
	
	
}

