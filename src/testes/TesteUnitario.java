package testes;

import static org.junit.jupiter.api.Assertions.*;
import controle.*;
import modelo.Diretor;

import org.junit.jupiter.api.Test;

class TesteUnitario {

	@Test
	void testCriarCanal() {
		String[] s1 = new String[10];
		String[] s2 = new String[10];
		boolean b1, b2;
		
		s1[0] = "0";
		s1[1] = "Globo";
		s1[2] = "Rede Globo";
		s1[3] = "dez"; // Valor incorreto
		s1[4] = "Todos";
		b1 = true;
		
		s2[0] = "0";
		s2[1] = "Globo";
		s2[2] = "Rede Globo";
		s2[3] = "10"; // Valor correto
		s2[4] = "Todos";
		b2 = true;
		
		assertFalse(new ControleDados().criarCanal(s1, b1));
		assertTrue(new ControleDados().criarCanal(s2, b2));
	}
	
	@Test
	void testCriarPrograma() {
		String[] s1 = {"0", "Globo Esporte", "vinte", "trinta", "Esportes", "Livre", "meia hora", "20", "2", "Globo",
		"3"}; // Valores incorretos
		String[] s2 = {"0", "Globo Esporte", "20", "30", "Esportes", "Livre", "30", "20", "2", "Globo",
		"3"}; // Valores corretos
		boolean[] b1 = {false, true, false, true, true, false, false};
		boolean[] b2 = {false, true, false, true, false, false, true};
		Diretor d1 = new Diretor("José", 25, 10);
		Diretor d2 = new Diretor("João", 42, 12);
		
		assertFalse(new ControleDados().criarPrograma(s1, b1, d1));
		assertTrue(new ControleDados().criarPrograma(s2, b2, d2));
		
	}
	
	/*
	@Test
	void testVerificacaoProgDiaria() {
		String nc1 = "Globo";
		String[] np = {"DF-TV", "Vale a pena ver de novo", "TV Globinho"};
		
		
	}
	*/
}
