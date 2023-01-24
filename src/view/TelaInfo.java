package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;

/**

Classe com todas as telas de Informações

@author Gustavo, Felipe
@since 2023
@version 1.0
*/
public class TelaInfo implements ActionListener, ListSelectionListener {
	private JFrame janela;
	private JButton botaoCriarCanal, botaoExibir, botaoCriarPrograma;
	private JButton botaoAtualizarPerfil, botaoAtualizarCanal, botaoAtualizarProgramas;
	private JLabel titulo;
	private JLabel labelSubTitulo;
	private JLabel labelCanaisFav;	
	private JList<String> listaCanaisFav;
	private String[] listaCanaisFavoritos = new String[50];
	private String[] listaCanais = new String[50];
	private String[] listaProgramas = new String[50];
	private static ControleDados dados;
	private static ControleUsuario userDados;
	private JList<String> listaNomesCanais, listaNomesProgramas;
	
/**
Metodo para criaçao das telas contendo as informaçoes
@param tipo de tela
@param d - variavel da classe de controle contendo os dados  
*/
	
	public void exibirInfo(int tipo, ControleDados d) {
		dados = d;
		userDados = new ControleUsuario(dados);
		
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
		if(tipo == 2){
			janela = new JFrame("Canal");
			
			titulo = new JLabel("Canais Existentes");
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(30, 15, 300, 30);
			
			listaCanais = new ControleCanais(dados).getListaNomes();
			listaNomesCanais = new JList<String>(listaCanais);
			listaNomesCanais.setBounds(30, 60, 250, 105);
			listaNomesCanais.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaNomesCanais.setVisibleRowCount(10);
			
			botaoExibir = new JButton("Exibir Programação Diaria");
			botaoCriarCanal = new JButton("Criar Canal");
			botaoAtualizarCanal = new JButton("Atualizar");
			
			botaoCriarCanal.setBounds(30, 175, 100, 30);
			botaoExibir.setBounds(140, 175, 200, 30);
			botaoAtualizarCanal.setBounds(270, 225, 100, 30);			
			
			this.janela.add(titulo);
			this.janela.add(listaNomesCanais);
			this.janela.add(botaoExibir);
			this.janela.add(botaoCriarCanal);
			this.janela.add(botaoAtualizarCanal);
		
			this.janela.setLayout(null);
			this.janela.setSize(400, 300);
			this.janela.setVisible(true);
			
			botaoAtualizarCanal.addActionListener(this);
			botaoCriarCanal.addActionListener(this);
			botaoExibir.addActionListener(this);
			listaNomesCanais.addListSelectionListener(this);
		}	
		if(tipo == 3){
			janela = new JFrame("Programas");
			
			titulo = new JLabel("Programas Existentes");
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(30, 15, 300, 30);
			
			listaProgramas = new ControleProgramas(dados).getListaNomes();
			listaNomesProgramas = new JList<String>(listaProgramas);
			listaNomesProgramas.setBounds(30, 60, 250, 105);
			listaNomesProgramas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaNomesProgramas.setVisibleRowCount(10);
			
			botaoExibir = new JButton("Buscar Programa Especifico");
			botaoCriarPrograma = new JButton("Criar Programa");
			botaoAtualizarProgramas = new JButton("Atualizar");
			
			botaoCriarPrograma.setBounds(30, 175, 130, 30);
			botaoExibir.setBounds(170, 175, 200, 30);
			botaoAtualizarProgramas.setBounds(270, 225, 100, 30);
			
			this.janela.add(titulo);
			this.janela.add(listaNomesProgramas);
			this.janela.add(botaoExibir);
			this.janela.add(botaoCriarPrograma);
			this.janela.add(botaoAtualizarProgramas);
		
			this.janela.setLayout(null);
			this.janela.setSize(400, 300);
			this.janela.setVisible(true);
			
			botaoAtualizarProgramas.addActionListener(this);
			botaoCriarPrograma.addActionListener(this);
			botaoExibir.addActionListener(this);
			listaNomesProgramas.addListSelectionListener(this);
		}
	}			
	
	public void actionPerformed(ActionEvent e) { // metodo para captar ação do usuario
		Object src = e.getSource();
	
		if (src == botaoCriarCanal) {
			new TelaCadastro().cadastrar(2, dados, 0);
		}
		
		if (src == botaoCriarPrograma) {
			new TelaCadastro().cadastrar(3, dados, 0);
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


	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if (src == listaNomesCanais && e.getValueIsAdjusting()) {
			new TelaCadastro().cadastrar(5, dados, listaNomesCanais.getSelectedIndex());
		}
		
		if (src == listaNomesProgramas && e.getValueIsAdjusting()) {
			new TelaCadastro().cadastrar(6, dados, listaNomesProgramas.getSelectedIndex());
		}
	}
	
	
	
}
