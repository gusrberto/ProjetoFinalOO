package controle;

import modelo.*;

public class ControleDados {
	// Atributos
	private Dados dados = new Dados();
	
	// Construtor
	public ControleDados() {
		dados.dadosPreCadastrados();
	}
	
	// Gets e Sets
	public Dados getDados() {
		return dados;
	}
	
	public void setDados(Dados dados) {
		this.dados = dados;
	}
	
	public Canal[] getCanais() {
		return this.dados.getCanais();
	}
	
	public Programa[] getProgramas() {
		return this.dados.getProgramas();
	}
	
	public Ator[] getAtores() {
		return this.dados.getAtores();
	}
	
	public Usuario[] getUsuario() {
		return this.dados.getUsuario();
	}
	
	public int getQtdCanais() {
		return this.dados.getQtdCanais();
	}
	
	public int getQtdProgramas() {
		return this.dados.getQtdProgramas();
	}
	
	public int getQtdAtores() {
		return this.dados.getQtdAtores();
	}
	
	public int getQtdUsuarios() {
		return this.dados.getQtdUsuarios();
	}
	
	// Métodos
	public boolean loginUsuario(String[] dadosUsuario) {
		if (!dadosUsuario[2].matches("[0-9]+")) {
			return false;
		} else {
			Usuario u = new Usuario(dadosUsuario[1], Integer.parseInt(dadosUsuario[2]),
						dadosUsuario[3], 0);
			dados.adicionarUsuario(u, Integer.parseInt(dadosUsuario[0]));
			return true;
		}
	}
	
	public boolean criarCanal(String[] dadosCanal, boolean favorito) {
		if (!dadosCanal[3].matches("[0-9]+")) {
			return false;
		} else {
			Canal c = new Canal(dadosCanal[1], dadosCanal[2],
					  Integer.parseInt(dadosCanal[3]), dadosCanal[4], 0,
					  favorito);
			dados.adicionarCanal(c, Integer.parseInt(dadosCanal[0]));
			return true;
		}
	}
	
	public boolean criarPrograma(String[] dadosPrograma, boolean[] dadosDias) {
		if (!dadosPrograma[2].matches("[0-9]+") || !dadosPrograma[3].matches("[0-9]+") ||
			!dadosPrograma[6].matches("[0-9]+")) {
			return false;
		} else {
			Programa p = new Programa(dadosPrograma[1], dadosDias,
						 Integer.parseInt(dadosPrograma[2]),
						 Integer.parseInt(dadosPrograma[3]), dadosPrograma[4],
						  dadosPrograma[5], Integer.parseInt(dadosPrograma[6]),
						  Integer.parseInt(dadosPrograma[7]), Integer.parseInt(dadosPrograma[8]), dadosPrograma[9],
						  Integer.parseInt(dadosPrograma[10]));
			dados.adicionarPrograma(p, Integer.parseInt(dadosPrograma[0]));
			return true;
		}
	}
	
	public void excluirPrograma(int i) {
		String programaExcluido = dados.getProgramas()[i].getNome();
		
		if (i == (dados.getQtdProgramas() - 1)) {
			dados.setQtdProgramas(getQtdProgramas() - 1); 
			dados.getProgramas()[dados.getQtdProgramas()] = null; 
		} else {
			int c = 0;
			while (dados.getProgramas()[c].getNome().compareTo(programaExcluido) != 0) {
				c++;
			}
			for (int j = c; j < dados.getQtdProgramas() - 1; j++) {
				dados.getProgramas()[j] = null;
				dados.getProgramas()[j] = dados.getProgramas()[j+1];
			}
			dados.getProgramas()[dados.getQtdProgramas()] = null;
			dados.setQtdProgramas(getQtdProgramas() - 1);
		}
	}
	
	public void excluirCanal(int i) {
		String canalExcluido = dados.getCanais()[i].getNome();
		String programaExcluido;
		
		for (int j = 0; j < dados.getQtdProgramas(); j++) {
			programaExcluido = dados.getProgramas()[j].getCanal();
			if (canalExcluido.compareTo(programaExcluido) == 0) {
				excluirPrograma(j);
				j--;
			}
		}
		
		if (i == (dados.getQtdCanais() - 1)) {
			dados.setQtdCanais(getQtdCanais() - 1); 
			dados.getCanais()[dados.getQtdCanais()] = null;
		} else {
			int c = 0;
			while (dados.getCanais()[c].getNome().compareTo(canalExcluido) != 0) {
				c++;
			}
			for (int k = c; k < dados.getQtdCanais() - 1; k++) {
				dados.getCanais()[k] = null;
				dados.getCanais()[k] = dados.getCanais()[k+1];
			}
			dados.getCanais()[dados.getQtdCanais()] = null;
			dados.setQtdCanais(getQtdCanais() - 1);
			for (int m = i; m < dados.getQtdCanais(); m++) {
				for (int n = 0; n < dados.getQtdProgramas(); n++) {
					if (dados.getCanais()[m].getNome().compareTo(dados.getProgramas()[n].getCanal()) == 0) {
						dados.getProgramas()[n].setIndexCanal(dados.getProgramas()[n].getIndexCanal() - 1);
					}
				}
			}
		}
		
	}
	
	public int buscarPrograma(String nomeProg) {
		for (int i = 0; i < dados.getQtdProgramas(); i++) {
			if (dados.getProgramas()[i].getNome().compareTo(nomeProg) == 0) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean verificacaoProgDiaria(int indexCanal, int indexDia) {
		String nomeCanal = dados.getCanais()[indexCanal].getNome();
		
		for (int i = 0; i < dados.getQtdProgramas(); i++) {
			if (dados.getProgramas()[i].getCanal().compareTo(nomeCanal) == 0 &&
				dados.getProgramas()[i].getDiaDeExibicao()[indexDia]) {
				return true;
			}
		}
		return false;
	}
	
}
