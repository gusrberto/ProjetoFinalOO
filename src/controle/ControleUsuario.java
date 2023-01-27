package controle;

import modelo.*;

/**
 * Classe que controla os atributos da classe Usuario utilizando-se da classe ControleDados.
 * 
 * @author Gustavo, Felipe
 * @since 2023
 * @version 1.0
 */

public class ControleUsuario {
	// Atributos
	private Usuario[] u;
	private int qtdUsuarios;
	
	// Construtor
	
	/**
	 * Cria um objeto da classe ControleUsuario a partir de um objeto da classe ControleDados,
	 * contém informações do usuário.
	 * 
	 * @param d Objeto da classe ControleDados
	 */
	
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
