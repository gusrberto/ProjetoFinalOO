package view;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import controle.*;

/**

Classe com todas as telas de menu

@author Gustavo, Felipe
@since 2023
@version 1.0
*/
public class TelaMenu implements ActionListener {
	private static JFrame janela;
	private static JLabel titulo;
	private static JButton entrar;
	private static JButton canal;
	private static JButton programa;
	private static JButton usuario;
	public static ControleDados dados = new ControleDados();
	
/**
Método para criação dos menus  
@param tipo Tipo de tela
*/
	
	public TelaMenu(int tipo) {
		janela = new JFrame("Programação da TV");
		
		if (tipo == 1){ 
			
			titulo = new JLabel("Menu Login");
			entrar = new JButton("Entrar");
			
			janela.add(titulo);
			janela.add(entrar);
			
			titulo.setBounds(170, 20, 150, 30);		
			entrar.setBounds(190, 120, 100, 30);
		}
		
		if(tipo == 2){
			
			titulo = new JLabel("Menu Principal");
			canal = new JButton("Canal");	
			programa = new JButton("Programa");
			usuario = new JButton("Usuario");
			
			janela.add(titulo);
			janela.add(canal);
			janela.add(programa);
			janela.add(usuario);
			
			titulo.setBounds(150, 20, 250, 30);
			canal.setBounds(190, 80, 100, 30);
			programa.setBounds(190, 120, 100, 30);
			usuario.setBounds(190, 160, 100, 30);
			
			usuario.addActionListener(this);
			canal.addActionListener(this);
			programa.addActionListener(this);
			janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		titulo.setFont(new Font("Arial", Font.BOLD, 25));
				
		janela.setLayout(null);
		janela.setSize(500, 300);
		janela.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		TelaMenu menu = new TelaMenu(1); // criaçao da primeira tela 
		
		entrar.addActionListener(menu);
	}

	public void actionPerformed(ActionEvent e) {  // metodo para captar ação do usuario
		Object src = e.getSource();
	
	// chamada de tela baseado no clique em determinado botao
		if (src == entrar) {
			new TelaCadastro().cadastrar(1, dados, 0);
			janela.setVisible(false);
		}
		
		if (src == canal) {
			new TelaInfo().exibirInfo(2, dados);
		}
		
		if (src == programa) {
			new TelaInfo().exibirInfo(3, dados);
		}
		
		if (src == usuario) {
			new TelaInfo().exibirInfo(1, dados);
		}
		
	}

}
