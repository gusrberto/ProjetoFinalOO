package modelo;

/**
 * Classe que armazena todos os objetos do programa, além de possuir um método
 * para pré-cadastrar dados.
 * 
 * @author Gustavo, Felipe
 * @since 2023
 * @version 1.0
 */

public class Dados {
	// Atributos
	private Canal[] canais = new Canal[40];
	private Programa[] programas = new Programa[40];
	private Diretor[] diretores = new Diretor[40];
	private Usuario[] usuario = new Usuario[1];
	private int qtdCanais = 0;
	private int qtdProgramas = 0;
	private int qtdDiretores = 0;
	private int qtdUsuarios = 0;
	
	// Métodos
	
	/**
	 * Cria dados pré-cadastrados para o programa.
	 */
	
	public void dadosPreCadastrados() {
		boolean[] dias = {false, true, false, true, true, false, false};
		
		for (int i = 0; i < 3; i++) {
			diretores[i] = new Diretor("Diretor " + (i+1), 30, 10);
			canais[i] = new Canal("Canal " + (i+1), "Emissora " + (i+1), (i+1), "Todos", 0, false, new Programa[30]);
			programas[i] = new Programa("Programa " + (i+1), dias, 12, 30, "Genero " + (i+1), "Livre", 90, 12, 2, canais[i].getNome(), i,
					diretores[i]);
			adicionarCanal(canais[i], qtdCanais);
			adicionarDiretor(diretores[i], qtdDiretores);
			adicionarPrograma(programas[i], qtdProgramas, canais[i]);
		}
	}
	
	/**
	 * Retorna o objeto Canal a partir de seu nome.
	 * 
	 * @param nomeCanal 
	 * @return Canal Objeto da classe canal
	 */
	
	public Canal encontraCanal(String nomeCanal) {
		for (int i = 0; i < qtdCanais; i++) {
			if (canais[i].getNome().compareTo(nomeCanal) == 0) {
				return canais[i];
			}
		}
		return null;
	}
	
	/**
	 * Adiciona um usuário a classe Dados.
	 * 
	 * @param u Objeto da classe Usuario
	 * @param pos Posição do objeto na array de usuario
	 */
	
	public void adicionarUsuario(Usuario u, int pos) {
		this.usuario[pos] = u;
		qtdUsuarios++;
	}
	
	/**
	 * Adiciona um canal a classe Dados.
	 * 
	 * @param c Objeto da classe Canal
	 * @param pos Posição do objeto na array de canais
	 */
	
	public void adicionarCanal(Canal c, int pos) {
		this.canais[pos] = c;
		if (pos == qtdCanais) {
			qtdCanais++;
		}
	}
	
	/**
	 * Adiciona um programa a classe Dados.
	 * 
	 * @param p Objeto da classe Programa
	 * @param pos Posição do objeto na array de programas
	 * @param c Objeto da classe Canal
	 */
	
	public void adicionarPrograma(Programa p, int pos, Canal c) {
		this.programas[pos] = p;
		c.adicionarPrograma(p, c.getQtdProgramas()); // Adiciona o programa a classe Canal
		if (pos == qtdProgramas) {
			qtdProgramas++;
		}
	}
	
	/**
	 * Adiciona um diretor a classe Dados.
	 * 
	 * @param d Objeto da classe diretor
	 * @param pos Posição do objeto na array de diretores
	 */
	
	public void adicionarDiretor(Diretor d, int pos) {
		this.diretores[pos] = d;
		if (pos == qtdDiretores) {
			qtdDiretores++;
		}
	}
	
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
		
		public Diretor[] getDiretor() {
			return diretores;
		}
		
		public void setDiretor(Diretor[] diretor) {
			this.diretores = diretor;
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
		
		public int getQtdDiretores() {
			return qtdDiretores;
		}
		
		public void setQtdDiretores(int qtdDiretores) {
			this.qtdDiretores = qtdDiretores;
		}
		
		public int getQtdUsuarios() {
			return qtdUsuarios;
		}
		
		public void setQtdUsuarios(int qtdUsuarios) {
			this.qtdUsuarios = qtdUsuarios;
		}
}
