package controle;

import modelo.*;

public class ControleDados {
	// Atributos
	private Dados dados = new Dados();
	
	
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
	
	public boolean criarCanal(String[] dadosCanal) {
		if (!dadosCanal[3].matches("[0-9]+")) {
			return false;
		} else {
			Canal c = new Canal(dadosCanal[1], dadosCanal[2],
					  Integer.parseInt(dadosCanal[3]), dadosCanal[4], 0);
			dados.adicionarCanal(c, Integer.parseInt(dadosCanal[0]));
			return true;
		}
	}
	
}
