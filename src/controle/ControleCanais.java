package controle;

import modelo.*;

public class ControleCanais {
	// Atributos
	private Canal[] c;
	private Programa[] p;
	private int qtdCanais;
	private int qtdProgramas;
	
	// Construtor
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
	public String[] getListaNomes() {
		String[] s = new String[qtdCanais];
		for (int i = 0; i < qtdCanais; i++) {
			s[i] = c[i].getNome();
		}
		return s;
	}
	
	public String[] getListaFavoritos() {
		String[] s = new String[qtdCanais];
		for (int i = 0; i < qtdCanais; i++) {
			if (c[i].getFavorito() == true) {
				s[i] = c[i].getNome();
			}
		}
		return s;
	}
	
	public String[] exibirProgDiaria(int indexCanal, int indexDia) {
		String nomeCanal = c[indexCanal].getNome();
		String[] progDia = new String[50];
		int j = 0;
		
		for (int i = 0; i < qtdProgramas; i++) {
			if (p[i].getCanal().compareTo(nomeCanal) == 0 &&
					p[i].getDiaDeExibicao()[indexDia]) {
				progDia[j] = String.format("%02d", p[i].getHorarioDeExibicao()) + ":" +
						 	String.format("%02d", p[i].getMinExibicao()) + "       " +
						 	p[i].getNome();
				j++;
			}
		}
		
		return progDia;
	}
	
}
