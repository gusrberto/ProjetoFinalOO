package controle;

import java.util.Arrays;

import modelo.*;

/**
 * Classe que controla os atributos da classe canal utilizando-se da classe ControleDados,
 * além de conter métodos de listagem relacionados a classe Canal.
 * 
 * @author Gustavo, Felipe
 * @since 2023
 * @version 1.0
 */

public class ControleCanais {
	// Atributos
	private Canal[] c;
	private Programa[] p;
	private int qtdCanais;
	private int qtdProgramas;
	
	// Construtor
	
	/**
	 * Cria um objeto da classe ControleCanais a partir de um objeto da classe ControleDados,
	 * contém as informações de canal e programa.
	 * 
	 * @param d Objeto da classe de ControleDados
	 */
	
	public ControleCanais(ControleDados d) {
		c = d.getCanais();
		p = d.getProgramas();
		qtdCanais = d.getQtdCanais();
		qtdProgramas = d.getQtdProgramas();
	}
	
	// Gets e Sets
	public int getQtdCanais() {
		return qtdCanais;
	}
	
	public void setQtdCanais(int qtdCanais) {
		this.qtdCanais = qtdCanais;
	}
	
	public String getNomeCanal(int i) {
		return c[i].getNome();
	}
	
	public String getEmissora(int i) {
		return c[i].getEmissora();
	}
	
	public String getNumCanal(int i) {
		String sNumCanal = String.valueOf(c[i].getNumCanal());
		return sNumCanal;
	}
	
	public String getPublicoAlvo(int i) {
		return c[i].getPublicoAlvo();
	}
	
	public String getFavorito(int i) {
		String sFavorito = String.valueOf(c[i].getFavorito());
		return sFavorito;
	}
	
	public boolean getFav(int i) {
		return c[i].getFavorito();
	}
	
	// Métodos
	
	/**
	 * Retorna a lista de nomes dos canais cadastrados.
	 * 
	 * @return String[]
	 */
	
	public String[] getListaNomes() {
		String[] s = new String[qtdCanais];
		for (int i = 0; i < qtdCanais; i++) {
			s[i] = c[i].getNome();
		}
		return s;
	}
	
	/**
	 * Retorna a lista de nomes dos canais que tem a checkBox "Favorito" marcada.
	 * 
	 * @return String[]
	 */
	
	public String[] getListaFavoritos() {
		String[] s = new String[qtdCanais];
		for (int i = 0; i < qtdCanais; i++) {
			if (c[i].getFavorito() == true) {
				s[i] = c[i].getNome();
			}
		}
		return s;
	}
	
	/**
	 * Recebe dois índices e retorna uma array de String ordenada pelo horário contendo em cada posição o horário
	 * e o nome do programa que é exibido naquele dia.
	 * 
	 * @param indexCanal Posição da opção do canal no comboBox
	 * @param indexDia Posição do dia no qual a programação irá ser exibida no comboBox
	 * @return String[]
	 */
	
	public String[] exibirProgDiaria(int indexCanal, int indexDia) {
		String nomeCanal = c[indexCanal].getNome();
		
		int j = 0, m = 0;
		
		for (int k = 0; k < qtdProgramas; k++) { // Verifica a quantidade de programas afim de definir o tamanho da array de retorno
			if (p[k].getCanal().compareTo(nomeCanal) == 0 &&
					p[k].getDiaDeExibicao()[indexDia]) {
				m++;
			}
		}
		
		String[] progDia = new String[m];
		
		for (int i = 0; i < qtdProgramas; i++) { // Salva em cada posição da array o horário e o nome do programa
			if (p[i].getCanal().compareTo(nomeCanal) == 0 &&
					p[i].getDiaDeExibicao()[indexDia]) {
				progDia[j] = String.format("%02d", p[i].getHorarioDeExibicao()) + ":" +
						 	String.format("%02d", p[i].getMinExibicao()) + "       " +
						 	p[i].getNome();
				j++;
			}
		}
		
		Arrays.sort(progDia); // Ordena a array
		
		return progDia;
	}
	
}
