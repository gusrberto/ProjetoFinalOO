package view;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import controle.*;
/**
Classe com as informações das telas de busca e exibição 
*/
public class TelaFunc implements ActionListener{
    private static ControleDados dados; 
    private JFrame janela;
    private JLabel labelPrograma, labelDia, labelCanal;
    private JButton botaoBuscar, botaoExibir;
    private JTextField txtNome;
    private JComboBox comboDia, comboCanal;
/**
Metodo para criação das telas de busca e exibição
@param tipo de tela
*/
	public void TelaFuncionalidade(int tipo, ControleDados d){
		dados = d;
		
        if(tipo == 1){
            janela = new JFrame("Buscar Programa");
            labelPrograma = new JLabel("Programa: ");
            txtNome = new JTextField(150);
            botaoBuscar = new JButton("Buscar");

            labelPrograma.setBounds(30, 50, 100, 20);
            txtNome.setBounds(100, 50, 160, 20);
            botaoBuscar.setBounds(100, 90, 100, 30);

			this.janela.add(labelPrograma);
			this.janela.add(botaoBuscar);
			this.janela.add(labelPrograma);
            this.janela.add(txtNome);

			this.janela.setLayout(null);
			this.janela.setSize(320, 200);
			this.janela.setVisible(true);

            botaoBuscar.addActionListener(this);
        }

        if(tipo == 2){
            
            String[] dias = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sáb"};
            
            janela = new JFrame("Exibir Programação Diária");
            labelDia = new JLabel("Dia: ");
            labelCanal = new JLabel("Canal: ");
            botaoExibir = new JButton("Exibir Programação");
            comboDia = new JComboBox<>(dias);
            
            String[] nomeCanais = new String[dados.getQtdCanais()];
            
            for (int i = 0; i < dados.getQtdCanais(); i++) {
            	nomeCanais[i] = dados.getCanais()[i].getNome();
            }
            
            comboCanal = new JComboBox<>(nomeCanais);

            labelDia.setBounds(70, 40, 100, 30);
            labelCanal.setBounds(160, 40, 100, 30);
            botaoExibir.setBounds(110, 130, 160, 30);
            comboDia.setBounds(95, 45, 60, 20);
            comboCanal.setBounds(200, 45, 100, 20);

			this.janela.add(labelDia);
			this.janela.add(labelCanal);
			this.janela.add(botaoExibir);
            this.janela.add(comboDia);
            this.janela.add(comboCanal);

           	this.janela.setLayout(null);
			this.janela.setSize(400, 250);
			this.janela.setVisible(true); 

            botaoExibir.addActionListener(this);
            comboDia.addActionListener(this);
			comboCanal.addActionListener(this);
        }        


    }
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == botaoBuscar) {
			String nomePrograma;
			int i;
			
			try {
				nomePrograma = txtNome.getText();
				i = dados.buscarPrograma(nomePrograma);
				
				if (txtNome.getText().isBlank()) {
					mensagemErroBusca();
				} else {
					if (i == -1) {
						mensagemErroBusca();
					} else {
						new TelaInfo().exibirInfo(4, dados, i, 0);
					}
				}
				
			} catch (NullPointerException erroNulo) {
				mensagemErroBusca();
			} catch (NumberFormatException erroFormat) {
				mensagemErroBusca();
			}
		}
		
		if (src == botaoExibir) {
			boolean aux = false;
			int indCanal, indDia;
			
			try {
				indDia = comboDia.getSelectedIndex();
				indCanal = comboCanal.getSelectedIndex();
				
				aux = dados.verificacaoProgDiaria(indCanal, indDia);
				
				if (aux) {
					new TelaInfo().exibirInfo(5, dados, indCanal, indDia);
				} else {
					mensagemErroExibicao();
				}
				
			} catch (NullPointerException erroNulo) {
				mensagemErroExibicao();
			} catch (NumberFormatException erroFormat) {
				mensagemErroExibicao();
			}
		}
		
	}
	
	public void mensagemErroBusca() {
		JOptionPane.showMessageDialog(null, "ERRO NA BUSCA!\n" + "Verifique as informações", null,
									  JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemErroExibicao() {
		JOptionPane.showMessageDialog(null, "ERRO NA EXIBIÇÃO!\n" + "Verifique as informações", null,
				  JOptionPane.ERROR_MESSAGE);
	}

}
