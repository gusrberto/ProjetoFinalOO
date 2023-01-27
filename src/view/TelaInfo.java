package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;

/**
 * Classe com todas as telas de informações.
 * 
 * @author Gustavo, Felipe
 * @since 2023
 * @version 1.0
 */

public class TelaInfo implements ActionListener, ListSelectionListener {
	// Atributos
	private JFrame janela;
	private JButton botaoCriarCanal, botaoExibirProg, botaoBuscarProg, botaoCriarPrograma;
	private JButton botaoAtualizarPerfil, botaoAtualizarCanal, botaoAtualizarProgramas;
	private JLabel titulo, labelNomePrograma, labelGenero, labelClassInd, labelDuracao, labelCanal, labelHorario, labelDiasExib;
	private JLabel labelSubTitulo;
	private JLabel labelCanaisFav;	
	private JList<String> listaCanaisFav;
	private JList<String> listaExibirProg;
	private String[] listaCanaisFavoritos = new String[50];
	private String[] listaCanais = new String[50];
	private String[] listaProgramas = new String[50];
	private String[] listaExibirProgramacao = new String[50];
	private static ControleDados dados;
	private static ControleUsuario userDados;
	private JList<String> listaNomesCanais, listaNomesProgramas;
	private int posicao, posicao2;	
	
	/**
	 * Cria as telas contendo as informações cadastradas.
	 * 
	 * @param tipo de tela
	 * @param d Objeto da classe ControleDados
	 * @param pos Índice do canal/programa para busca
	 * @param pos2 Posição do dia de exibição na array
	 */
	
	public void exibirInfo(int tipo, ControleDados d, int pos, int pos2) {
		dados = d;
		userDados = new ControleUsuario(dados);
		posicao = pos;
		posicao2 = pos2;
		
		if (tipo == 1) {
			janela = new JFrame("Perfil");
			
			titulo = new JLabel("Perfil de " + userDados.getApelido(0));
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(30, 25, 300, 30);
			
			labelSubTitulo = new JLabel(userDados.getNomeUsuario(0) + ", " +
										userDados.getIdadeUsuario(0) + " anos");
			labelSubTitulo.setBounds(30, 50, 300, 20);
			
			botaoAtualizarPerfil = new JButton("Atualizar");
			botaoAtualizarPerfil.setBounds(290, 220, 85, 30);
			
			labelCanaisFav = new JLabel("Canais Favoritos");
			labelCanaisFav.setFont(new Font("Arial", Font.BOLD, 15));
			labelCanaisFav.setBounds(30, 90, 300, 20);
			
			listaCanaisFavoritos = new ControleCanais(dados).getListaFavoritos();
			listaCanaisFav = new JList<String>(listaCanaisFavoritos);
			listaCanaisFav.setBounds(30, 120, 250, 130);
			listaCanaisFav.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaCanaisFav.setVisibleRowCount(10);
			
			this.janela.add(titulo);
			this.janela.add(labelSubTitulo);
			this.janela.add(labelCanaisFav);
			this.janela.add(listaCanaisFav);
			this.janela.add(botaoAtualizarPerfil);
			
			this.janela.setLayout(null);
			this.janela.setSize(400, 300);
			this.janela.setVisible(true);
			
			botaoAtualizarPerfil.addActionListener(this);
		}
		
		if(tipo == 2) {
			janela = new JFrame("Canal");
			
			titulo = new JLabel("Canais Existentes");
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(30, 15, 300, 30);
			
			listaCanais = new ControleCanais(dados).getListaNomes();
			listaNomesCanais = new JList<String>(listaCanais);
			listaNomesCanais.setBounds(30, 60, 250, 105);
			listaNomesCanais.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaNomesCanais.setVisibleRowCount(10);
			
			botaoExibirProg = new JButton("Exibir Programação Diaria");
			botaoCriarCanal = new JButton("Criar Canal");
			botaoAtualizarCanal = new JButton("Atualizar");
			
			botaoCriarCanal.setBounds(30, 175, 100, 30);
			botaoExibirProg.setBounds(140, 175, 200, 30);
			botaoAtualizarCanal.setBounds(270, 225, 100, 30);			
			
			this.janela.add(titulo);
			this.janela.add(listaNomesCanais);
			this.janela.add(botaoExibirProg);
			this.janela.add(botaoCriarCanal);
			this.janela.add(botaoAtualizarCanal);
		
			this.janela.setLayout(null);
			this.janela.setSize(400, 300);
			this.janela.setVisible(true);
			
			botaoAtualizarCanal.addActionListener(this);
			botaoCriarCanal.addActionListener(this);
			botaoExibirProg.addActionListener(this);
			listaNomesCanais.addListSelectionListener(this);
		}
		
		if(tipo == 3) {
			janela = new JFrame("Programas");
			
			titulo = new JLabel("Programas Existentes");
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(30, 15, 300, 30);
			
			listaProgramas = new ControleProgramas(dados).getListaNomes();
			listaNomesProgramas = new JList<String>(listaProgramas);
			listaNomesProgramas.setBounds(30, 60, 250, 105);
			listaNomesProgramas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaNomesProgramas.setVisibleRowCount(10);
			
			botaoBuscarProg = new JButton("Buscar Programa Especifico");
			botaoCriarPrograma = new JButton("Criar Programa");
			botaoAtualizarProgramas = new JButton("Atualizar");
			
			botaoCriarPrograma.setBounds(30, 175, 130, 30);
			botaoBuscarProg.setBounds(170, 175, 200, 30);
			botaoAtualizarProgramas.setBounds(270, 225, 100, 30);
			
			this.janela.add(titulo);
			this.janela.add(listaNomesProgramas);
			this.janela.add(botaoBuscarProg);
			this.janela.add(botaoCriarPrograma);
			this.janela.add(botaoAtualizarProgramas);
		
			this.janela.setLayout(null);
			this.janela.setSize(400, 300);
			this.janela.setVisible(true);
			
			botaoAtualizarProgramas.addActionListener(this);
			botaoCriarPrograma.addActionListener(this);
			botaoBuscarProg.addActionListener(this);
			listaNomesProgramas.addListSelectionListener(this);
		}
		
		if (tipo == 4) {
			janela = new JFrame("Buscar Programa");
			String diasExib = "";
			
			if (dados.getProgramas()[posicao].getDiaDeExibicao()[0] == true) { // Montando a string dos dias de exibição
				diasExib = " Dom,";
			}
			if (dados.getProgramas()[posicao].getDiaDeExibicao()[1] == true) {
				diasExib = diasExib + " Seg,";
			}
			if (dados.getProgramas()[posicao].getDiaDeExibicao()[2] == true) {
				diasExib = diasExib + " Ter,";
			}
			if (dados.getProgramas()[posicao].getDiaDeExibicao()[3] == true) {
				diasExib = diasExib + " Qua,";
			}
			if (dados.getProgramas()[posicao].getDiaDeExibicao()[4] == true) {
				diasExib = diasExib + " Qui,";
			}
			if (dados.getProgramas()[posicao].getDiaDeExibicao()[5] == true) {
				diasExib = diasExib + " Sex,";
			}
			if (dados.getProgramas()[posicao].getDiaDeExibicao()[6] == true) {
				diasExib = diasExib + " Sáb,";
			}
			
			diasExib = diasExib.substring(0, diasExib.length()-1); // Remove a vírgula do final da string
			
			labelNomePrograma = new JLabel(dados.getProgramas()[posicao].getNome());
			labelNomePrograma.setFont(new Font("Arial", Font.BOLD, 20));
			labelDiasExib = new JLabel("Dias de exibição: " + diasExib);
			labelHorario = new JLabel("Horário: " + String.format("%02d", dados.getProgramas()[posicao].getHorarioDeExibicao()) + ":" +
										String.format("%02d", dados.getProgramas()[posicao].getMinExibicao()));
			labelDuracao = new JLabel("Duração: " + dados.getProgramas()[posicao].getDuracao() + " minutos");
			labelGenero = new JLabel("Gênero: " + dados.getProgramas()[posicao].getGenero());
			labelClassInd = new JLabel("Classificação Indicativa: " + dados.getProgramas()[posicao].getClassIndicativa());
			labelCanal = new JLabel("Canal de exibição: " + dados.getProgramas()[posicao].getCanal());
			
			labelNomePrograma.setBounds(40, 20, 250, 30);
			labelDiasExib.setBounds(40, 60, 300, 20);
			labelHorario.setBounds(40, 90, 250, 20);
			labelDuracao.setBounds(40, 120, 250, 20);
			labelGenero.setBounds(40, 150, 250, 20);
			labelClassInd.setBounds(40, 180, 250, 20);
			labelCanal.setBounds(40, 210, 250, 20);
			
			this.janela.add(labelNomePrograma);
			this.janela.add(labelDiasExib);
			this.janela.add(labelHorario);
			this.janela.add(labelDuracao);
			this.janela.add(labelGenero);
			this.janela.add(labelClassInd);
			this.janela.add(labelCanal);
			
			this.janela.setLayout(null);
			this.janela.setSize(450, 320);
			this.janela.setVisible(true);
		}
		if(tipo == 5){
			janela = new JFrame("Programação Diária");

			titulo = new JLabel(dados.getCanais()[posicao].getNome());
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			
			listaExibirProgramacao = new ControleCanais(dados).exibirProgDiaria(posicao, posicao2);
			listaExibirProg = new JList<String>(listaExibirProgramacao);

			titulo.setBounds(30, 15, 300, 30);
			listaExibirProg.setBounds(30, 60, 250, 105);
			listaExibirProg.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaExibirProg.setVisibleRowCount(10);
			
			this.janela.add(titulo);
			this.janela.add(listaExibirProg);

			this.janela.setLayout(null);
			this.janela.setSize(450, 320);
			this.janela.setVisible(true);
			
		}
	}			
	
	public void actionPerformed(ActionEvent e) { // Método para captar ação do usuário
		Object src = e.getSource();
	
		if (src == botaoCriarCanal) {
			new TelaCadastro().cadastrar(2, dados, 0);
		}
		
		if (src == botaoCriarPrograma) {
			new TelaCadastro().cadastrar(3, dados, 0);
		}
		
		if (src == botaoBuscarProg) {
			new TelaFunc().TelaFuncionalidade(1, dados);
		}
		
		if (src == botaoExibirProg) {
			new TelaFunc().TelaFuncionalidade(2, dados);
		}
		
		if (src == botaoAtualizarCanal) {
			listaNomesCanais.setListData(new ControleCanais(dados).getListaNomes());
			listaNomesCanais.updateUI();
		}
		
		if (src == botaoAtualizarProgramas) {
			listaNomesProgramas.setListData(new ControleProgramas(dados).getListaNomes());
			listaNomesProgramas.updateUI();
		}
		
		if (src == botaoAtualizarPerfil) {
			listaCanaisFav.setListData(new ControleCanais(dados).getListaFavoritos());
			listaCanaisFav.updateUI();
		}
		
	}


	public void valueChanged(ListSelectionEvent e) { // Método para captar ação do usuário na JList
		Object src = e.getSource();
		
		if (src == listaNomesCanais && e.getValueIsAdjusting()) {
			new TelaCadastro().cadastrar(5, dados, listaNomesCanais.getSelectedIndex());
		}
		
		if (src == listaNomesProgramas && e.getValueIsAdjusting()) {
			new TelaCadastro().cadastrar(6, dados, listaNomesProgramas.getSelectedIndex());
		}
	}
	
	
	
}
