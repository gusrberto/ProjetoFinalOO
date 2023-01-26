package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JCheckBox;
import modelo.*;
import controle.*;

/**

Classe com todas as telas de cadastro

@author Gustavo, Felipe
@since 2023
@version 1.0
*/
public class TelaCadastro implements ActionListener {
	private JFrame janela;
	private JLabel titulo;
	private JLabel labelNome, labelIdade, labelNick, labelFuncao;
	private JLabel labelEmissora, labelNumero, labelPublico, labelFavorito;
	private JLabel labelDias, labelHorario, labelGenero, labelClassificacao, labelDuracao, labelDuraMin,labelHrs, labelMin, labelCanal;
	private JTextField txtNomeUsuario, txtNomeAtor, txtIdadeUsuario, txtIdadeAtor, txtNick, txtFuncao;
	private JTextField txtNomeCanal, txtEmissora, txtNumero, txtPublico;
	private JTextField txtNomePrograma, txtGenero, txtClassificacao, txtDuracao;
	private JButton botaoAddElenco, botaoContinuar, botaoExcluir;
	private JCheckBox checkDom, checkSeg, checkTer, checkQua, checkQui, checkSex, checkSab, checkFav;
	private JComboBox comboHoras, comboMin, comboCanal;
	private String[] vetorAux = new String[20];
	private boolean[] vetorAuxDias = new boolean[7];
	private boolean fav = false, erroDia;
	private int tp, posicao;
	private static ControleDados dados;
	private String jframeS;
	
/**
Metodo para criação das telas de cadastro
@param tipo de tela
@param d - variavel da classe de controle contendo os dados
@param pos - posição do objeto no vetor 	
*/
	public void cadastrar(int tipo, ControleDados d, int pos) {
		tp = tipo;
		dados = d;
		posicao = pos;
		
		if (tipo == 1) jframeS = "Login";
		if (tipo == 2) jframeS = "Cadastro Canal";
		if (tipo == 3 || tipo == 4) jframeS = "Cadastro Programa";
		if (tipo == 5) jframeS = "Informações Canal";
		if (tipo == 6 || tipo == 7) jframeS = "Informações Programa";
		
		
		if (tipo == 1) {
			janela = new JFrame(jframeS);
			titulo = new JLabel("Insira seus dados");
		
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
		    titulo.setBounds(120, 20, 200, 30);
		
			txtNomeUsuario = new JTextField(150);
			txtIdadeUsuario = new JTextField(50);
			txtNick = new JTextField(150);
			botaoContinuar = new JButton("Continuar");
			labelNome = new JLabel("Nome: ");
			labelIdade = new JLabel("Idade: ");
			labelNick = new JLabel("Nickname: ");
		
			labelNome.setBounds(40, 80, 150, 20);
			txtNomeUsuario.setBounds(105, 80, 150, 20);
			labelIdade.setBounds(40, 110, 150, 20);
			txtIdadeUsuario.setBounds(105, 110, 150, 20);
			labelNick.setBounds(40, 140, 150, 20);
			txtNick.setBounds(105, 140, 150, 20);
		
			botaoContinuar.setBounds(270, 210, 100, 40);
			
			this.janela.add(titulo);
			
			this.janela.add(labelIdade);
			this.janela.add(labelNick);
			this.janela.add(labelNome);
			this.janela.add(txtNomeUsuario);
			this.janela.add(txtIdadeUsuario);
			this.janela.add(txtNick);
			
			this.janela.add(botaoContinuar);
			
			this.janela.setLayout(null);
			this.janela.setSize(400, 300);
			this.janela.setVisible(true);
			
			botaoContinuar.addActionListener(this);		
		}
		
		if (tipo == 2 || tipo == 5) {
			janela = new JFrame(jframeS);
			
			labelNome = new JLabel("Nome do canal: ");
			labelEmissora = new JLabel("Emissora: ");
			labelNumero = new JLabel("Número do canal: ");
			labelPublico = new JLabel("Público alvo: ");
			labelFavorito = new JLabel("Favorito? ");
			if (tipo == 2) {
				txtNomeCanal = new JTextField(150);
				txtEmissora = new JTextField(150);
				txtNumero = new JTextField(50);
				txtPublico = new JTextField(150);
				checkFav = new JCheckBox();
				
				botaoContinuar = new JButton("Criar");
			}
			
			if (tipo == 5) {
				txtNomeCanal = new JTextField(dados.getCanais()[pos].getNome(), 150);
				txtEmissora = new JTextField(dados.getCanais()[pos].getEmissora(), 150);
				txtNumero = new JTextField(String.valueOf(dados.getCanais()[pos].getNumCanal()), 50);
				txtPublico = new JTextField(dados.getCanais()[pos].getPublicoAlvo(), 150);
				if (dados.getCanais()[pos].getFavorito() == true) {
					checkFav = new JCheckBox();
					checkFav.setSelected(true);
				} else {
					checkFav = new JCheckBox();
					checkFav.setSelected(false);
				}
				botaoExcluir = new JButton("Excluir");
				botaoContinuar = new JButton("Salvar");
				botaoExcluir.setBounds(150, 210, 100, 40);
			}
			
			labelNome.setBounds(40, 50, 150, 20);
			txtNomeCanal.setBounds(145, 50, 150, 20);
			labelEmissora.setBounds(40, 80, 150, 20);
			txtEmissora.setBounds(145, 80, 150, 20);
			labelNumero.setBounds(40, 110, 150, 20);
			txtNumero.setBounds(145, 110, 150, 20);
			labelPublico.setBounds(40, 140, 150, 20);
			txtPublico.setBounds(145, 140, 150, 20);
			labelFavorito.setBounds(40, 170, 200, 20);
			checkFav.setBounds(140, 165, 100, 30);
			
			botaoContinuar.setBounds(270, 210, 100, 40);
			
			this.janela.add(labelNome);
			this.janela.add(labelEmissora);
			this.janela.add(labelNumero);
			this.janela.add(labelPublico);
			this.janela.add(txtNomeCanal);
			this.janela.add(txtEmissora);
			this.janela.add(txtNumero);
			this.janela.add(txtPublico);
			this.janela.add(labelFavorito);
			this.janela.add(checkFav);
			this.janela.add(botaoContinuar);
			
			if (tipo == 5) this.janela.add(botaoExcluir);
			
			this.janela.setLayout(null);
			this.janela.setSize(400, 300);
			this.janela.setVisible(true);
			
			botaoContinuar.addActionListener(this);
			if (tipo == 5) botaoExcluir.addActionListener(this);
				
	}		
	 	if (tipo == 3 || tipo == 6){
			janela = new JFrame(jframeS); 
			
			String[] horas = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
					"13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
			
			String[] min = {"00", "15", "30", "45"};
			
			String[] nomeCanais = new String[dados.getQtdCanais()];
			
			for (int i = 0; i < dados.getQtdCanais(); i++) {
				nomeCanais[i] = dados.getCanais()[i].getNome();
			}
			
			labelDias = new JLabel("Dias de Exibição: ");
			labelNome = new JLabel("Nome: ");
			labelHorario = new JLabel("Horario de Exibição: ");
			labelGenero = new JLabel("Genero: ");
			labelClassificacao = new JLabel("Classificação Indicativa: ");
			labelDuracao = new JLabel("Duração: ");
			labelDuraMin = new JLabel("minutos");
			labelHrs = new JLabel("horas");
			labelMin = new JLabel("min");
			labelCanal = new JLabel("Canal: ");
			
			checkDom = new JCheckBox("D");
			checkSeg = new JCheckBox("S");
			checkTer = new JCheckBox("T");
			checkQua = new JCheckBox("Q");
			checkQui = new JCheckBox("Q");
			checkSex = new JCheckBox("S");
			checkSab = new JCheckBox("S");
			
			comboHoras = new JComboBox<>(horas);
			comboMin = new JComboBox<>(min);
			comboCanal = new JComboBox<>(nomeCanais);
			
			if (tipo == 3) {
				txtNomePrograma = new JTextField(150);
				txtGenero = new JTextField(150);
				txtClassificacao = new JTextField(150);
				txtDuracao = new JTextField(150);
				
				botaoContinuar = new JButton("Criar");
			}
			
			if (tipo == 6) {
				txtNomePrograma = new JTextField(dados.getProgramas()[pos].getNome(), 150);
				txtGenero = new JTextField(dados.getProgramas()[pos].getGenero(), 150);
				txtClassificacao = new JTextField(dados.getProgramas()[pos].getClassIndicativa(), 150);
				txtDuracao = new JTextField(String.valueOf(dados.getProgramas()[pos].getDuracao()), 150);
				
				comboHoras.setSelectedIndex(dados.getProgramas()[pos].getIndexHrs());
				comboMin.setSelectedIndex(dados.getProgramas()[pos].getIndexMin());
				comboCanal.setSelectedIndex(dados.getProgramas()[pos].getIndexCanal());
				
				if (dados.getProgramas()[pos].getDiaDeExibicao()[0] == true) checkDom.setSelected(true);
				if (dados.getProgramas()[pos].getDiaDeExibicao()[1] == true) checkSeg.setSelected(true);
				if (dados.getProgramas()[pos].getDiaDeExibicao()[2] == true) checkTer.setSelected(true);
				if (dados.getProgramas()[pos].getDiaDeExibicao()[3] == true) checkQua.setSelected(true);
				if (dados.getProgramas()[pos].getDiaDeExibicao()[4] == true) checkQui.setSelected(true);
				if (dados.getProgramas()[pos].getDiaDeExibicao()[5] == true) checkSex.setSelected(true);
				if (dados.getProgramas()[pos].getDiaDeExibicao()[6] == true) checkSab.setSelected(true);
				
				botaoContinuar = new JButton("Salvar");
				botaoExcluir = new JButton("Excluir");
				botaoExcluir.setBounds(230, 230, 80, 40);
			}
			
			botaoAddElenco = new JButton("Adicionar Radialista");
			
			labelDias.setBounds(40, 20, 150, 20);
			
			labelNome.setBounds(40, 50, 150, 20);
			txtNomePrograma.setBounds(180, 50, 150, 20);
			
			labelHorario.setBounds(40, 80, 150, 20);
			labelHrs.setBounds(225, 80, 150, 20);
			labelMin.setBounds(315, 80, 150, 20);
			
			labelGenero.setBounds(40, 110, 150, 20);
			txtGenero.setBounds(180, 110, 150, 20);
			
			labelClassificacao.setBounds(40, 140, 150, 20);
			txtClassificacao.setBounds(180, 140, 150, 20);
			
			labelDuracao.setBounds(40, 170, 150, 20);
			txtDuracao.setBounds(180, 170, 40, 20);
			labelDuraMin.setBounds(225, 170, 100, 20);
			
			labelCanal.setBounds(40, 200, 150, 20);
			
			checkDom.setBounds(140, 15, 40, 30);
			checkSeg.setBounds(180, 15, 40, 30);
			checkTer.setBounds(220, 15, 40, 30);
			checkQua.setBounds(260, 15, 40, 30);
			checkQui.setBounds(300, 15, 40, 30);
			checkSex.setBounds(340, 15, 40, 30);
			checkSab.setBounds(380, 15, 40, 30);
			
			comboHoras.setBounds(180, 80, 40, 20);
			comboMin.setBounds(270, 80, 40, 20);
			comboCanal.setBounds(180, 200, 150, 20);
			
			botaoAddElenco.setBounds(40, 230, 150, 40);
			botaoContinuar.setBounds(330, 230, 80, 40);
			
			this.janela.add(labelDias);
			this.janela.add(labelNome);
			this.janela.add(labelHorario);
			this.janela.add(labelGenero);
			this.janela.add(labelClassificacao);
			this.janela.add(labelDuracao);
			this.janela.add(labelDuraMin);
			this.janela.add(labelHrs);
			this.janela.add(labelMin);
			this.janela.add(labelCanal);
			this.janela.add(txtNomePrograma);
			this.janela.add(txtGenero);
			this.janela.add(txtClassificacao);
			this.janela.add(txtDuracao);
			this.janela.add(botaoAddElenco);
			this.janela.add(botaoContinuar);
			
			if (tipo == 6) this.janela.add(botaoExcluir);
			
			this.janela.add(checkDom);
			this.janela.add(checkSeg);
			this.janela.add(checkTer);
			this.janela.add(checkQua);
			this.janela.add(checkQui);
			this.janela.add(checkSex);
			this.janela.add(checkSab);
			
			this.janela.add(comboMin);
			this.janela.add(comboHoras);
			this.janela.add(comboCanal);
			
			this.janela.setLayout(null);
			this.janela.setSize(450, 320);
			this.janela.setVisible(true);
			
			botaoContinuar.addActionListener(this);
			botaoAddElenco.addActionListener(this);
			if (tipo == 6) botaoExcluir.addActionListener(this);
			comboHoras.addActionListener(this);
			comboMin.addActionListener(this);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == botaoContinuar) {
			try {
				boolean aux = false;
				if (tp == 1) { // Login Usuário
					vetorAux[0] = Integer.toString(dados.getQtdUsuarios());
				} else if (tp == 2) { // Cria o canal
					vetorAux[0] = Integer.toString(dados.getQtdCanais());
				} else if (tp == 3) { // Cria o programa
					vetorAux[0] = Integer.toString(dados.getQtdProgramas());
				} else { // Edita informações
					vetorAux[0] = Integer.toString(posicao);
				}
				
				if (tp == 1) { // Login Usuário
					vetorAux[1] = txtNomeUsuario.getText();
					vetorAux[2] = txtIdadeUsuario.getText();
					vetorAux[3] = txtNick.getText();
					if (!(txtNomeUsuario.getText().isBlank() || txtNick.getText().isBlank())) aux = dados.loginUsuario(vetorAux);
				} else if (tp == 2 || tp == 5) { // Cria ou edita o canal
					vetorAux[1] = txtNomeCanal.getText();
					vetorAux[2] = txtEmissora.getText();
					vetorAux[3] = txtNumero.getText();
					vetorAux[4] = txtPublico.getText();
					if (checkFav.isSelected()) fav = true;
					if (!(txtNomeCanal.getText().isBlank() || txtEmissora.getText().isBlank() ||
							txtPublico.getText().isBlank())) {
						aux = dados.criarCanal(vetorAux, fav);
					}
				} else if (tp == 3 || tp == 6) { // Cria ou edita o programa
					vetorAux[1] = txtNomePrograma.getText();
					vetorAux[2] = (String) comboHoras.getSelectedItem();
					vetorAux[3] = (String) comboMin.getSelectedItem();
					vetorAux[4] = txtGenero.getText();
					vetorAux[5] = txtClassificacao.getText();
					vetorAux[6] = txtDuracao.getText();	
					vetorAux[7] = String.valueOf(comboHoras.getSelectedIndex());
					vetorAux[8] = String.valueOf(comboMin.getSelectedIndex());
					vetorAux[9] = (String) comboCanal.getSelectedItem();
					vetorAux[10] = String.valueOf(comboCanal.getSelectedIndex());
					if (checkDom.isSelected()) vetorAuxDias[0] = true;
					if (checkSeg.isSelected()) vetorAuxDias[1] = true;
					if (checkTer.isSelected()) vetorAuxDias[2] = true;
					if (checkQua.isSelected()) vetorAuxDias[3] = true;
					if (checkQui.isSelected()) vetorAuxDias[4] = true;
					if (checkSex.isSelected()) vetorAuxDias[5] = true;
					if (checkSab.isSelected()) vetorAuxDias[6] = true;
					if (vetorAuxDias[0] == true || vetorAuxDias[1] == true || vetorAuxDias[2] == true ||
						vetorAuxDias[3] == true || vetorAuxDias[4] == true || vetorAuxDias[5] == true ||
						vetorAuxDias[0] == true) {
						if (!(txtNomePrograma.getText().isBlank() || txtGenero.getText().isBlank() ||
								txtClassificacao.getText().isBlank())) {
							aux = dados.criarPrograma(vetorAux, vetorAuxDias);
							erroDia = false;
						}
					} else {
						erroDia = true;
						mensagemErroDia();
					}
				}
				if (tp == 1) {
					if (aux) {
						mensagemSucessoLogin();
						new TelaMenu(2);
					} else {
						mensagemErroLogin();
					}
				}
				
				if (tp == 2 || tp == 5) {
					if (aux) {
						if (tp == 2) mensagemSucessoCadastro();
						if (tp == 5) mensagemSucessoEdicao();
					} else {
						mensagemErroCadastro();
					}
				}
				
				if (tp == 3 || tp == 6) {
					if (aux) {
						if (tp == 3) mensagemSucessoCadastro();
						if (tp == 6) mensagemSucessoEdicao();
					} else if (!aux && erroDia == false) {
						mensagemErroCadastro();
					}
				}
				
			} catch (NullPointerException erroNulo) {
				mensagemErroLogin();
			} catch (NumberFormatException erroFormat) {
				mensagemErroLogin();
			}
		}
		
		if (src == botaoExcluir) {
			if (tp == 5) {
				dados.excluirCanal(posicao);
				mensagemExclusaoCanal();
			}
			
			if (tp == 6) {
				dados.excluirPrograma(posicao);
				mensagemExclusaoPrograma();
			}
		}
		
	}
	
	// Mensagens de aviso de sucesso ou erro
	public void mensagemSucessoLogin() {
		JOptionPane.showMessageDialog(null, "Login bem-sucedido!", null,
									  JOptionPane.INFORMATION_MESSAGE);
		this.janela.dispose();
	}
	
	public void mensagemErroLogin() {
		JOptionPane.showMessageDialog(null, "ERRO NO LOGIN!\n" + "Verifique as informações e se os campos foram preenchidos.",
									  null, JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Cadastro bem-sucedido!", null,
									  JOptionPane.INFORMATION_MESSAGE);
		this.janela.dispose();
	}
	
	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null, "ERRO NO CADASTRO!\n" + "Verifique as informações e se os campos foram preenchidos.",
				                      null, JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemSucessoEdicao() {
		JOptionPane.showMessageDialog(null, "Dados atualizados!", null,
				                      JOptionPane.INFORMATION_MESSAGE);
		this.janela.dispose();
	}
	
	public void mensagemErroDia() {
		JOptionPane.showMessageDialog(null, "Escolha pelo menos um dia de exibição!", null,
									  JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemExclusaoPrograma() {
		JOptionPane.showMessageDialog(null, "Programa excluído com sucesso!", null,
									  JOptionPane.INFORMATION_MESSAGE);
		this.janela.dispose();
	}
	
	public void mensagemExclusaoCanal() {
		JOptionPane.showMessageDialog(null, "Canal junto de seus programas excluídos com sucesso!", null,
									  JOptionPane.INFORMATION_MESSAGE);
		this.janela.dispose();
	}
}
