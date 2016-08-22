package Testes;

import static org.junit.Assert.*;

import java.nio.channels.ReadPendingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Jogo.Jogabilidade;
import Jogo.Jogo;
import Jogo.Luta;
import Jogo.Plataforma;
import Jogo.RPG;

public class TesteJogo {

	Jogo LOL;
	Jogo Sonic;
	Jogo GTAV;

	@Before
	public void setUp() throws Exception {
		LOL = new RPG("League of Legends", 0.0);
		Sonic = new Plataforma("Sonic Heroes", 15.0);
		GTAV = new Luta("Grand Theft Auto V", 139.0);
	}

	@Test
	public void TestJogoRPG() {

		assertEquals("League of Legends", LOL.getNome());
		assertEquals("RPG", LOL.getTipo());
		assertEquals(10, LOL.registraJogada(259, false));
		assertEquals(0.0, LOL.getPreco(), 0.05);
		assertEquals(259, LOL.getMaxScore());
		assertEquals(0, LOL.getQntZeradas());
		assertEquals(1, LOL.getQntJogadas());
		assertEquals(10, LOL.registraJogada(534, true));
		assertEquals(534, LOL.getMaxScore());
		assertEquals(1, LOL.getQntZeradas());
		assertEquals(2, LOL.getQntJogadas());

	}

	@Test
	public void TestJogoPlataforma() {

		assertEquals("Sonic Heroes", Sonic.getNome());
		assertEquals("Plataforma", Sonic.getTipo());
		assertEquals(0, Sonic.registraJogada(1658, false));
		assertEquals(15.0, Sonic.getPreco(), 0.05);
		assertEquals(1658, Sonic.getMaxScore());
		assertEquals(0, Sonic.getQntZeradas());
		assertEquals(1, Sonic.getQntJogadas());
		assertEquals(20, Sonic.registraJogada(534, true));
		assertEquals(1658, Sonic.getMaxScore());
		assertEquals(1, Sonic.getQntZeradas());
		assertEquals(2, Sonic.getQntJogadas());
	}

	@Test
	public void TestJogoLuta() {

		assertEquals("Grand Theft Auto V", GTAV.getNome());
		assertEquals("Luta", GTAV.getTipo());
		assertEquals(43, GTAV.registraJogada(43598, false));
		assertEquals(139.0, GTAV.getPreco(), 0.05);
		assertEquals(43598, GTAV.getMaxScore());
		assertEquals(0, GTAV.getQntZeradas());
		assertEquals(1, GTAV.getQntJogadas());
		assertEquals(31, GTAV.registraJogada(31867, true));
		assertEquals(43598, GTAV.getMaxScore());
		assertEquals(1, GTAV.getQntZeradas());
		assertEquals(2, GTAV.getQntJogadas());
	}

	@Test
	public void TestJogoExceptions() {
		try {
			Jogo jogoRpg = new RPG(" ", 10.0);

			fail("Exception nome invalido");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio.", e.getMessage());
		}

		try {
			Jogo jogoRpg = new RPG("LoL", -10.0);

			fail("Exception preco invalido");
		} catch (Exception e) {
			assertEquals("Preco nao pode ser negativo.", e.getMessage());
		}

		try {
			Jogo jogoPlataforma = new Plataforma(" ", 25.0);

			fail("Exception nome invalido");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio.", e.getMessage());
		}

		try {
			Jogo jogoPlataforma = new Plataforma("Mario", -5.99);

			fail("Exception preco invalido");

		} catch (Exception e) {
			assertEquals("Preco nao pode ser negativo.", e.getMessage());
		}
		try {
			Jogo jogoLuta = new RPG(" ", 19.0);

			fail("Exception nome invalido");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio.", e.getMessage());
		}

		try {
			Jogo jogoLuta = new Luta("Street Fighter", -15.99);

			fail("Exception preco invalido");
		} catch (Exception e) {
			assertEquals("Preco nao pode ser negativo.", e.getMessage());
		}

	}

	@Test
	public void testAddJogabilidade() {
		
		LOL.addJogabilidade(Jogabilidade.ONLINE);
		LOL.addJogabilidade(Jogabilidade.COOPERATIVO);

		assertEquals(2, LOL.getJogabilidade().size());

		LOL.addJogabilidade(Jogabilidade.ONLINE);

		assertEquals(2, LOL.getJogabilidade().size());
		
		assertTrue(LOL.getJogabilidade().contains(Jogabilidade.ONLINE));
		assertTrue(LOL.getJogabilidade().contains(Jogabilidade.COOPERATIVO)); 

	}
}
