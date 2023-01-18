package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;

public class TelaInfo implements ActionListener, ListSelectionListener {
	private JFrame janela;
	private JButton botaoAtualizar, botaoCriarCanal, botaoExibir, botaoAtualizarCanal;
	private JLabel titulo;
	private JLabel labelSubTitulo;
	private JLabel labelCanaisFav;	
	private JList<String> listaCanaisFav;
	private String[] listaCanaisFavoritos = new String[50];
	private String[] listaCanais = new String[50];
	private static ControleDados dados;
	private static ControleUsuario userDados;
	private JList<String> listaNomes;
	
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
			
			botaoAtualizar = new JButton("Atualizar");
			botaoAtualizar.setBounds(290, 220, 85, 30);
			
			labelCanaisFav = new JLabel("Canais Favoritos");
			labelCanaisFav.setFont(new Font("Arial", Font.BOLD, 15));
			labelCanaisFav.setBounds(30, 90, 300, 20);
			
			listaCanaisFav = new JList<String>(listaCanaisFavoritos);
			listaCanaisFav.setBounds(30, 120, 250, 130);
			listaCanaisFav.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaCanaisFav.setVisibleRowCount(10);
			
			this.janela.add(titulo);
			this.janela.add(labelSubTitulo);
			this.janela.add(labelCanaisFav);
			this.janela.add(listaCanaisFav);
			this.janela.add(botaoAtualizar);
			
			this.janela.setLayout(null);
			this.janela.setSize(400, 300);
			this.janela.setVisible(true);
			
			botaoAtualizar.addActionListener(this);
		}
		if(tipo == 2){
			janela = new JFrame("Canal");
			
			titulo = new JLabel("Canais Existentes");
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(30, 15, 300, 30);
			
			listaNomes = new JList<String>(listaCanais);
			listaNomes.setBounds(30, 60, 250, 105);
			listaNomes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaNomes.setVisibleRowCount(10);
			
			botaoExibir = new JButton("Exibir Programação Diaria");
			botaoCriarCanal = new JButton("Criar Canal");
			botaoAtualizarCanal = new JButton("Atualizar");
			
			botaoCriarCanal.setBounds(30, 175, 100, 30);
			botaoExibir.setBounds(140, 175, 200, 30);
			botaoAtualizarCanal.setBounds(270, 225, 100, 30);			
			
			this.janela.add(titulo);
			this.janela.add(listaNomes);
			this.janela.add(botaoExibir);
			this.janela.add(botaoCriarCanal);
			this.janela.add(botaoAtualizarCanal);
		
			this.janela.setLayout(null);
			this.janela.setSize(400, 300);
			this.janela.setVisible(true);
			
			botaoAtualizarCanal.addActionListener(this);
			botaoCriarCanal.addActionListener(this);
			botaoExibir.addActionListener(this);
			listaNomes.addListSelectionListener(this);
		}	
	}
	
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == botaoCriarCanal) {
			new TelaCadastro().cadastrar(2, dados, 0);
		}
		
		if (src == botaoAtualizarCanal) {
			listaNomes.setListData(new ControleCanais(dados).getListaNomes());
			listaNomes.updateUI();
		}
		
	}

	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if (src == listaNomes && e.getValueIsAdjusting()) {
			new TelaCadastro().cadastrar(5, dados, listaNomes.getSelectedIndex());
		}
	}
	
}
