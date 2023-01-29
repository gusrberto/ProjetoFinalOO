package testes;

import static org.junit.jupiter.api.Assertions.*;
import controle.*;
import modelo.*;
import org.junit.jupiter.api.Test;

/**
 * Classe que faz testes unitários de 3 métodos do programa ("Criar Canal", "Criar Programa"
 * e "Verificar Programação Diária").
 * 
 * @author Gustavo, Felipe
 * @since 2023
 * @version 1.0
 */

class TesteUnitario {
	
	@Test
	void testCriarCanal() {
		String[] s1 = new String[10];
		String[] s2 = new String[10];
		boolean[] b1 = {false, true, false, true, true, false, false};
		boolean fav1, fav2;
		Diretor d1 = new Diretor("José", 25, 10);
		Programa p1 = new Programa("Jornal Nacional", b1, 21, 30, "Notícias", "Livre", 120, 21, 2, "Globo", 0, d1);
		Programa[] arrP = new Programa[1];
		
		s1[0] = "0";
		s1[1] = "Globo";
		s1[2] = "Rede Globo";
		s1[3] = "dez"; // Valor incorreto
		s1[4] = "Todos";
		s1[5] = "0";
		fav1 = true;
		
		s2[0] = "0";
		s2[1] = "Globo";
		s2[2] = "Rede Globo";
		s2[3] = "10"; // Valor correto
		s2[4] = "Todos";
		s2[5] = "0";
		fav2 = true;
		
		assertFalse(new ControleDados().criarCanal(s1, fav1, arrP));
		assertTrue(new ControleDados().criarCanal(s2, fav2, arrP));
	}
	
	@Test
	void testCriarPrograma() {
		ControleDados cd = new ControleDados();
		String[] s1 = {"0", "Globo Esporte", "vinte", "trinta", "Esportes", "Livre", "meia hora", "20", "2", "Globo",
		"0"}; // Valores incorretos
		String[] s2 = {"0", "Globo Esporte", "20", "30", "Esportes", "Livre", "30", "20", "2", "Globo",
		"0"}; // Valores corretos
		boolean[] b1 = {false, true, false, true, true, false, false};
		Programa[] arrP = new Programa[1];
		Canal c1 = new Canal("Globo", "Rede Globo", 10, "Todos", 0, false, arrP);
		Diretor d1 = new Diretor("José", 25, 10);
		
		cd.getDados().adicionarCanal(c1, 0);

		assertFalse(cd.criarPrograma(s1, b1, d1));
		assertTrue(cd.criarPrograma(s2, b1, d1));
	}
	
	@Test
	void testVerificarProgDiaria() {
		ControleDados cd = new ControleDados();
		Diretor d1 = new Diretor("José", 25, 10);
		boolean[] b1 = {false, true, false, true, true, false, false}; // Dom Seg Ter Qua Qui Sex Sáb
		Programa[] arrP = new Programa[1];
		Canal c1 = new Canal("Globo", "Rede Globo", 10, "Todos", 0, false, arrP);
		Programa p1 = new Programa("Jornal Nacional", b1, 21, 30, "Notícias", "Livre", 120, 21, 2, "Globo", 0, d1);
		
		cd.getDados().adicionarCanal(c1, 0);
		cd.getDados().adicionarPrograma(p1, 0, c1);
		
		assertFalse(new ControleDados().verificacaoProgDiaria(0, 2)); // Não há programas sendo transmitidos na terça
		assertTrue(new ControleDados().verificacaoProgDiaria(0, 4)); // Há ao menos um programa sendo transmitido na quinta
	}
	
}
