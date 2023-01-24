package modelo;

public class Dados {
	// Atributos
	private Canal[] canais = new Canal[40];
	private Programa[] programas = new Programa[40];
	private Ator[] atores = new Ator[40];
	private Usuario[] usuario = new Usuario[1];
	private int qtdCanais = 0;
	private int qtdProgramas = 0;
	private int qtdAtores = 0;
	private int qtdUsuarios = 0;
	
	// Gets e Sets
	public Canal[] getCanais() {
		return canais;
	}
	
	public void setCanais(Canal[] canais) {
		this.canais = canais;
	}
	
	public Programa[] getProgramas() {
		return programas;
	}
	
	public void setProgramas(Programa[] programas) {
		this.programas = programas;
	}
	
	public int getIndexCanal(int i) {
		return programas[i].getIndexCanal();
	}
	
	public void setIndexCanal(int i) {
		this.programas[i].setIndexCanal(i);
	}
	
	public Ator[] getAtores() {
		return atores;
	}
	
	public void setAtores(Ator[] atores) {
		this.atores = atores;
	}
	
	public Usuario[] getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario[] usuario) {
		this.usuario = usuario;
	}
	
	public int getQtdCanais() {
		return qtdCanais;
	}
	
	public void setQtdCanais(int qtdCanais) {
		this.qtdCanais = qtdCanais;
	}
	
	public int getQtdProgramas() {
		return qtdProgramas;
	}
	
	public void setQtdProgramas(int qtdProgramas) {
		this.qtdProgramas = qtdProgramas;
	}
	
	public int getQtdAtores() {
		return qtdAtores;
	}
	
	public void setQtdAtores(int qtdAtores) {
		this.qtdAtores = qtdAtores;
	}
	
	public int getQtdUsuarios() {
		return qtdUsuarios;
	}
	
	public void setQtdUsuarios(int qtdUsuarios) {
		this.qtdUsuarios = qtdUsuarios;
	}
	
	// Métodos
	public void dadosPreCadastrados() {
		boolean[] dias = {false, true, false, true, true, false, false};
		
		for (int i = 0; i < 3; i++) {
			canais[i] = new Canal("Canal " + (i+1), "Emissora " + (i+1), (i+1), "Todos", 0, false);
			programas[i] = new Programa("Programa " + (i+1), dias, 12, 30, "Genero " + (i+1), "Livre", 90, 12, 2, canais[i].getNome(), i);
		}
		qtdCanais = 3;
		qtdProgramas = 3;
	}
	
	public void adicionarUsuario(Usuario u, int pos) {
		this.usuario[pos] = u;
		qtdUsuarios++;
	}
	
	public void adicionarCanal(Canal c, int pos) {
		this.canais[pos] = c;
		if (pos == qtdCanais) {
			qtdCanais++;
		}
	}
	
	public void adicionarPrograma(Programa p, int pos) {
		this.programas[pos] = p;
		if (pos == qtdProgramas) {
			qtdProgramas++;
		}
	}
	
	public void adicionarAtor(Ator a, int pos) {
		this.atores[pos] = a;
		if (pos == qtdAtores) {
			qtdAtores++;
		}
	}
}
