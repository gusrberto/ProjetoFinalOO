package controle;

import modelo.*;

/**
 * Classe que controla os atributos da classe Programa utilizando-se da classe ControleDados,
 * contém um método de listagem relacionado a classe Programa.
 * 
 * @author Gustavo, Felipe
 * @since 2023
 * @version 1.0
 */

public class ControleProgramas {
	// Atributos
	private Programa[] p;
	private Diretor[] dt;
	private int qtdProgramas;
	
	// Construtor
	
	/**
	 * Cria um objeto da classe ControleProgramas a partir de um objeto da classe ControleDados,
	 * contém informações de programas e diretor.
	 * 
	 * @param d Objeto da classe ControleDados
	 */
	
	public ControleProgramas(ControleDados d) {
		p = d.getProgramas();
		dt = d.getDiretor();
		qtdProgramas = d.getQtdProgramas();
	}
	
	// Métodos
	
	/**
	 * Retorna a lista de nomes dos programas cadastrados.
	 * 
	 * @return String[]
	 */
	
	public String[] getListaNomes() {
		String[] s = new String[qtdProgramas];
		for (int i = 0; i < qtdProgramas; i++) {
			s[i] = p[i].getNome();
		}
		return s;
	}
	
	// Gets e Sets
		public int getQtdProgramas() {
			return qtdProgramas;
		}
		
		public void setQtdProgramas(int qtdProgramas) {
			this.qtdProgramas = qtdProgramas;
		}
		
		public String getNomeProg(int i) {
			return p[i].getNome();
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
		
		public String getNomeDiretor(int i) {
			return dt[i].getNome();
		}
		
		public String idadeDiretor(int i) {
			return String.valueOf(dt[i].getIdade());
		}
		
		public String getTrabProduzidos(int i) {
			return String.valueOf(dt[i].getTrabalhosProduzidos());
		}
	
}
