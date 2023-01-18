package controle;

import modelo.*;

public class ControleUsuario {
	// Atributos
	private Usuario[] u;
	private int qtdUsuarios;
	
	// Construtor
	public ControleUsuario(ControleDados d) {
		u = d.getUsuario();
		qtdUsuarios = d.getQtdUsuarios();
	}
	
	// Gets e Sets
	public int getQtdUsuarios() {
		return qtdUsuarios;
	}
	
	public void setQtdUsuarios(int qtdUsuarios) {
		this.qtdUsuarios = qtdUsuarios;
	}
	
	public String getNomeUsuario(int i) {
		return u[i].getNome();
	}
	
	public String getIdadeUsuario(int i) {
		String sIdade = String.valueOf(u[i].getIdade());
		return sIdade;
	}
	
	public String getApelido(int i) {
		return u[i].getApelido();
	}

}
