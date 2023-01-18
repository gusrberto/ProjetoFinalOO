package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import controle.*;

public class TelaCadastro implements ActionListener {
	private JFrame janela;
	private JLabel titulo;
	private JLabel labelNome, labelIdade, labelNick;
	private JLabel labelEmissora, labelNumero, labelPublico, labelFavorito;
	private JLabel labelDias, labelHorario, labelGenero, labelClassificacao, labelDuracao;
	private JTextField txtNome, txtIdade, txtNick;
	private JTextField txtNomeCanal, txtEmissora, txtNumero, txtPublico;
	private JTextField txtNomePrograma, txtHorario, txtGenero, txtClassificacao, txtDuracao;
	private JButton botaoAddElenco, botaoContinuar, botaoExcluir;
	private JCheckBox checkDom, checkSeg, checkTer, checkQua, checkQui, checkSex, checkSab, checkFav;
	private String[] vetorAux = new String[10];
	private int tp, posicao;
	private static ControleDados dados;
	private String jframeS;
	
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
		
			txtNome = new JTextField(150);
			txtIdade = new JTextField(50);
			txtNick = new JTextField(150);
			botaoContinuar = new JButton("Continuar");
			labelNome = new JLabel("Nome: ");
			labelIdade = new JLabel("Idade: ");
			labelNick = new JLabel("Nickname: ");
		
			labelNome.setBounds(40, 80, 150, 20);
			txtNome.setBounds(105, 80, 150, 20);
			labelIdade.setBounds(40, 110, 150, 20);
			txtIdade.setBounds(105, 110, 150, 20);
			labelNick.setBounds(40, 140, 150, 20);
			txtNick.setBounds(105, 140, 150, 20);
		
			botaoContinuar.setBounds(270, 210, 100, 40);
			
			this.janela.add(titulo);
			
			this.janela.add(labelIdade);
			this.janela.add(labelNick);
			this.janela.add(labelNome);
			this.janela.add(txtNome);
			this.janela.add(txtIdade);
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
				checkFav = new JCheckBox();
				
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
			labelFavorito.setBounds(40, 170, 150, 20);
			checkFav.setBounds(140, 165, 40, 30);
			
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
	 	if (tipo == 3){
			janela = new JFrame(jframeS); 
			
			labelDias = new JLabel("Dias de Exibição: ");
			labelNome = new JLabel("Nome: ");
			labelHorario = new JLabel("Horario de Exibição: ");
			labelGenero = new JLabel("Genero: ");
			labelClassificacao = new JLabel("Classificação Indicativa: ");
			labelDuracao = new JLabel("Duração: "); 
			txtNomePrograma = new JTextField(150);
			txtHorario = new JTextField(150);
			txtGenero = new JTextField(150);
			txtClassificacao = new JTextField(150);
			txtDuracao = new JTextField(150);
			checkDom = new JCheckBox("D");
			checkSeg = new JCheckBox("S");
			checkTer = new JCheckBox("T");
			checkQua = new JCheckBox("Q");
			checkQui = new JCheckBox("Q");
			checkSex = new JCheckBox("S");
			checkSab = new JCheckBox("S");
			botaoAddElenco = new JButton("Adicionar Elenco");
			botaoContinuar = new JButton("Criar");
			
			
			labelDias.setBounds(40, 20, 150, 20);
			
			labelNome.setBounds(40, 50, 150, 20);
			txtNomePrograma.setBounds(180, 50, 150, 20);
			
			labelHorario.setBounds(40, 80, 150, 20);
			txtHorario.setBounds(180, 80, 150, 20);
			
			labelGenero.setBounds(40, 110, 150, 20);
			txtGenero.setBounds(180, 110, 150, 20);
			
			labelClassificacao.setBounds(40, 140, 150, 20);
			txtClassificacao.setBounds(180, 140, 150, 20);
			
			labelDuracao.setBounds(40, 170, 150, 20);
			txtDuracao.setBounds(180, 170, 150, 20);
			
			checkDom.setBounds(140, 15, 40, 30);
			checkSeg.setBounds(180, 15, 40, 30);
			checkTer.setBounds(220, 15, 40, 30);
			checkQua.setBounds(260, 15, 40, 30);
			checkQui.setBounds(300, 15, 40, 30);
			checkSex.setBounds(340, 15, 40, 30);
			checkSab.setBounds(380, 15, 40, 30);
			
			botaoAddElenco.setBounds(40, 210, 150, 40);
			botaoContinuar.setBounds(270, 210, 100, 40);
			
			this.janela.add(labelDias);
			this.janela.add(labelNome);
			this.janela.add(labelHorario);
			this.janela.add(labelGenero);
			this.janela.add(labelClassificacao);
			this.janela.add(labelDuracao);
			this.janela.add(txtNomePrograma);
			this.janela.add(txtHorario);
			this.janela.add(txtGenero);
			this.janela.add(txtClassificacao);
			this.janela.add(txtDuracao);
			this.janela.add(botaoAddElenco);
			this.janela.add(botaoContinuar);
			
			this.janela.add(checkDom);
			this.janela.add(checkSeg);
			this.janela.add(checkTer);
			this.janela.add(checkQua);
			this.janela.add(checkQui);
			this.janela.add(checkSex);
			this.janela.add(checkSab);
			
			this.janela.setLayout(null);
			this.janela.setSize(450, 300);
			this.janela.setVisible(true);
			
			botaoContinuar.addActionListener(this);
			botaoAddElenco.addActionListener(this);	
			
		 
		 
		}

	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == botaoContinuar) {
			try {
				boolean aux;
				if (tp == 1) {
					vetorAux[0] = Integer.toString(dados.getQtdUsuarios());
				} else if (tp == 2) {
					vetorAux[0] = Integer.toString(dados.getQtdCanais());
				} else if (tp == 3) {
					vetorAux[0] = Integer.toString(dados.getQtdProgramas());
				} else {
					vetorAux[0] = Integer.toString(posicao);
				}
				
				if (tp == 1) { // Login Usuário
					vetorAux[1] = txtNome.getText();
					vetorAux[2] = txtIdade.getText();
					vetorAux[3] = txtNick.getText();
					aux = dados.loginUsuario(vetorAux);
				} else if (tp == 2 || tp == 5) { // Cria ou edita o canal
					vetorAux[1] = txtNomeCanal.getText();
					vetorAux[2] = txtEmissora.getText();
					vetorAux[3] = txtNumero.getText();
					vetorAux[4] = txtPublico.getText();
					aux = dados.criarCanal(vetorAux);
				} else {
					aux = false;
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
				
			} catch (NullPointerException erroNulo) {
				mensagemErroLogin();
			} catch (NumberFormatException erroFormat) {
				mensagemErroLogin();
			}
		}
		
	}
	
	public void mensagemSucessoLogin() {
		JOptionPane.showMessageDialog(null, "Login bem-sucedido!", null,
									  JOptionPane.INFORMATION_MESSAGE);
		this.janela.dispose();
	}
	
	public void mensagemErroLogin() {
		JOptionPane.showMessageDialog(null, "ERRO NO LOGIN!\n" + "Verifique as informações.",
									  null, JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Cadastro bem-sucedido!", null,
									  JOptionPane.INFORMATION_MESSAGE);
		this.janela.dispose();
	}
	
	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null, "ERRO NO CADASTRO!\n" + "Verifique as informações.",
				                      null, JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemSucessoEdicao() {
		JOptionPane.showMessageDialog(null, "Dados atualizados!", null,
				                      JOptionPane.INFORMATION_MESSAGE);
		this.janela.dispose();
	}
}
