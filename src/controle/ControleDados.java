package controle;

import modelo.*;

/**
 * Classe que controla os dados cadastrados e contém os métodos de cadastro/edição.
 * 
 * @author Gustavo, Felipe
 * @since 2023
 * @version 1.0
 */

public class ControleDados {
	// Atributos
	private Dados dados = new Dados();
	
	// Construtor
	
	/**
	 * Cria um objeto da classe ControleDados a partir de um objeto da classe Dados,
	 * contém as informações dos dados cadastrados. Executa o método da classe Dados para gerar
	 * dados pré-cadastrados.
	 */
	
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
	
	public Diretor[] getAtores() {
		return this.dados.getDiretor();
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
	
	public int getQtdDiretores() {
		return this.dados.getQtdDiretores();
	}
	
	public int getQtdUsuarios() {
		return this.dados.getQtdUsuarios();
	}
	
	// Métodos
	
	/**
	 * Realiza o login do usuário.
	 * 
	 * @param dadosUsuario Vetor de string contendo as informações dadas pelo usuário na tela de login
	 * @return boolean
	 */
	
	public boolean loginUsuario(String[] dadosUsuario) {
		if (!dadosUsuario[2].matches("[0-9]+")) { // Verifica se no campo idade foi passado um número
			return false;
		} else {
			Usuario u = new Usuario(dadosUsuario[1], Integer.parseInt(dadosUsuario[2]),
						dadosUsuario[3]); // Instancia um novo usuário
			dados.adicionarUsuario(u, Integer.parseInt(dadosUsuario[0])); // Adiciona o usuário a Dados
			return true;
		}
	}
	
	/**
	 * Cria um canal a partir das informações passadas pelo usuário na TelaCadastro.
	 * 
	 * @param dadosCanal Vetor de string contendo as informações dadas pelo usuário no cadastro/edição do canal
	 * @param favorito Boolean que diz se a checkBox de favorito foi marcada
	 * @return boolean
	 */
	
	public boolean criarCanal(String[] dadosCanal, boolean favorito) {
		if (!dadosCanal[3].matches("[0-9]+")) { // Verifica se no campo número do canal foi passado um número
			return false;
		} else {
			Canal c = new Canal(dadosCanal[1], dadosCanal[2],
					  Integer.parseInt(dadosCanal[3]), dadosCanal[4], 0,
					  favorito); // Instancia um novo canal
			dados.adicionarCanal(c, Integer.parseInt(dadosCanal[0])); // Adiciona o canal a Dados
			return true;
		}
	}
	
	/**
	 * Cria um programa a partir das informações passadas pelo usuário na TelaCadastro.
	 * 
	 * @param dadosPrograma Vetor de string contendo as informações dadas pelo usuário no cadastro/edição do programa
	 * @param dadosDias Array de boolean com uma posição pra cada dia da semana para verificar os dias de exibição do programa
	 * @return boolean
	 */
	
	public boolean criarPrograma(String[] dadosPrograma, boolean[] dadosDias, Diretor diretor) {
		if (!dadosPrograma[2].matches("[0-9]+") || !dadosPrograma[3].matches("[0-9]+") ||
			!dadosPrograma[6].matches("[0-9]+") || !String.valueOf(diretor.getIdade()).matches("[0-9]+")
			|| !String.valueOf(diretor.getTrabalhosProduzidos()).matches("[0-9]+")) {
			// Verifica se nos campos horas, minutos, duração, idade e trab prod do diretor foi passado números
			return false;
		} else {
			Programa p = new Programa(dadosPrograma[1], dadosDias,
						 Integer.parseInt(dadosPrograma[2]),
						 Integer.parseInt(dadosPrograma[3]), dadosPrograma[4],
						  dadosPrograma[5], Integer.parseInt(dadosPrograma[6]),
						  Integer.parseInt(dadosPrograma[7]), Integer.parseInt(dadosPrograma[8]), dadosPrograma[9],
						  Integer.parseInt(dadosPrograma[10]), diretor); // Instancia um novo programa
			dados.adicionarPrograma(p, Integer.parseInt(dadosPrograma[0])); // Adiciona o programa a Dados
			return true;
		}
	}
	
	/**
	 * Exclui um determinado programa.
	 * 
	 * @param i Posição do programa na array de dados a ser excluído
	 */
	
	public void excluirPrograma(int i) {
		String programaExcluido = dados.getProgramas()[i].getNome();
		
		if (i == (dados.getQtdProgramas() - 1)) { // Caso o programa seja o último da array
			dados.setQtdProgramas(getQtdProgramas() - 1); 
			dados.getProgramas()[dados.getQtdProgramas()] = null; 
		} else { // Caso não seja o último da array
			int c = 0;
			while (dados.getProgramas()[c].getNome().compareTo(programaExcluido) != 0) { // Busca pelo programa a ser excluído
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
	
	/**
	 * Exclui um determinado canal junto de todos os programas transmitidos nele.
	 * 
	 * @param i Posição do canal na array de dados a ser excluído
	 */
	
	public void excluirCanal(int i) {
		String canalExcluido = dados.getCanais()[i].getNome();
		String programaExcluido;
		
		for (int j = 0; j < dados.getQtdProgramas(); j++) { // Exclusão de todos os programas transmitidos no canal
			programaExcluido = dados.getProgramas()[j].getCanal();
			if (canalExcluido.compareTo(programaExcluido) == 0) {
				excluirPrograma(j);
				j--;
			}
		}
		
		if (i == (dados.getQtdCanais() - 1)) { // Caso o canal seja o último da array
			dados.setQtdCanais(getQtdCanais() - 1); 
			dados.getCanais()[dados.getQtdCanais()] = null;
		} else { // Caso não seja o último da array
			int c = 0;
			while (dados.getCanais()[c].getNome().compareTo(canalExcluido) != 0) { // Busca pelo canal a ser excluído
				c++;
			}
			for (int k = c; k < dados.getQtdCanais() - 1; k++) {
				dados.getCanais()[k] = null;
				dados.getCanais()[k] = dados.getCanais()[k+1];
			}
			dados.getCanais()[dados.getQtdCanais()] = null;
			dados.setQtdCanais(getQtdCanais() - 1);
			for (int m = i; m < dados.getQtdCanais(); m++) {
				for (int n = 0; n < dados.getQtdProgramas(); n++) { // Altera a posição do index do comboBox nas informações do programa
					if (dados.getCanais()[m].getNome().compareTo(dados.getProgramas()[n].getCanal()) == 0) {
						dados.getProgramas()[n].setIndexCanal(dados.getProgramas()[n].getIndexCanal() - 1);
					}
				}
			}
		}
		
	}
	
	/**
	 * Retorna a posição do programa na array de dados a ser buscado.
	 * 
	 * @param nomeProg
	 * @return int Índice do programa caso encontrado e -1 caso não seja encontrado
	 */
	
	public int buscarPrograma(String nomeProg) {
		for (int i = 0; i < dados.getQtdProgramas(); i++) {
			if (dados.getProgramas()[i].getNome().compareTo(nomeProg) == 0) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Verifica se há programas sendo transmitidos no dia em que a exibição foi acionada.
	 * 
	 * @param indexCanal Posição da opção do canal no comboBox
	 * @param indexDia Posição do dia no qual a programação irá ser exibida no comboBox
	 * @return boolean
	 */
	
	public boolean verificacaoProgDiaria(int indexCanal, int indexDia) {
		String nomeCanal = dados.getCanais()[indexCanal].getNome();
		
		for (int i = 0; i < dados.getQtdProgramas(); i++) { // Verifica se o canal possui programas sendo transmitidos no dia
			if (dados.getProgramas()[i].getCanal().compareTo(nomeCanal) == 0 &&
				dados.getProgramas()[i].getDiaDeExibicao()[indexDia]) {
				return true;
			}
		}
		return false;
	}
	
}
