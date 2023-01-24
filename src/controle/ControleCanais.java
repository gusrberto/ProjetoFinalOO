package controle;

import modelo.*;

public class ControleCanais {
	// Atributos
	private Canal[] c;
	private int qtdCanais;
	
	// Construtor
	public ControleCanais(ControleDados d) {
		c = d.getCanais();
		qtdCanais = d.getQtdCanais();
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
	
	
}
