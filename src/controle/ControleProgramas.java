package controle;

import modelo.*;

public class ControleProgramas {
	// Atributos
	private Programa[] p;
	private Ator[] a;
	private int qtdProgramas;
	private int tamElenco;
	
	// Construtor
	public ControleProgramas(ControleDados d) {
		p = d.getProgramas();
		a = d.getAtores();
		qtdProgramas = d.getQtdProgramas();
		tamElenco = d.getQtdAtores();
	}
	
	// Gets e Sets
	public int getQtdProgramas() {
		return qtdProgramas;
	}
	
	public void setQtdProgramas(int qtdProgramas) {
		this.qtdProgramas = qtdProgramas;
	}
	
	public int getTamElenco() {
		return tamElenco;
	}
	
	public void setTamElenco(int tamElenco) {
		this.tamElenco = tamElenco;
	}
	
	public String getNomeProg(int i) {
		return p[i].getNome();
	}
	
	public String[] getDiaDeExibicao(int i) {
		String[] sDiaExib = new String[7];
		for (int j = 0; j < 7; j++) {
			sDiaExib[j] = String.valueOf(p[i].getDiaDeExibicao()[j]);
		}
		return sDiaExib;
	}
	
	public boolean[] getDiaDeExib(int i) {
		boolean[] diaExib = new boolean[7];
		for (int j = 0; j < 7; j++) {
			diaExib[j] = p[i].getDiaDeExibicao()[j];
		}
		return diaExib;
	}
	
	public String getHoraExib(int i) {
		return String.valueOf(p[i].getHorarioDeExibicao());
	}
	
	public String getMinExib(int i) {
		return String.valueOf(p[i].getMinExibicao());
	}
	
	public String getGenero(int i) {
		return p[i].getGenero();
	}
	
	public String getClassInd(int i) {
		return p[i].getClassIndicativa();
	}
	
	public String getDuracao(int i) {
		return String.valueOf(p[i].getDuracao());
	}
	
	public String getNomeAtor(int i) {
		return a[i].getNome();
	}
	
	public String idadeAtor(int i) {
		return String.valueOf(a[i].getIdade());
	}
	
	public String getFuncaoAtor(int i) {
		return a[i].getPapel();
	}
	
	// Métodos
	public String[] getListaNomes() {
		String[] s = new String[qtdProgramas];
		for (int i = 0; i < qtdProgramas; i++) {
			s[i] = p[i].getNome();
		}
		return s;
	}
	
}
