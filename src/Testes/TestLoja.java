package Testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Jogo.Jogo;
import Jogo.RPG;
import Loja.Fachada;

public class TestLoja {

	Fachada loja;

	@Before
	public void setUp() {
		loja = new Fachada();

	}

	@Test
	public void testLoja() throws Exception {

		Jogo jogo = new RPG("Lol", 10);
		assertEquals(0, loja.getUsuarios().size());
		assertTrue(loja.addUsuario("Igordl", "Igor.dl"));
		assertEquals(1, loja.getUsuarios().size());
		assertFalse(loja.vendeJogo("Igor.dl", jogo));
		assertTrue(loja.addDinheiro("Igor.dl", 9.0));
		assertTrue(loja.vendeJogo("Igor.dl", jogo));
		assertEquals(1, loja.qntJogosUsuario("Igor.dl"));

	}

	@Test
	public void testUpgrade() throws Exception {

		Jogo jogo = new RPG("Lol", 100);

		assertTrue(loja.addUsuario("Igordl", "Igor.dl"));
		assertFalse(loja.upgrade("Igor.dl"));
		assertTrue(loja.addDinheiro("Igor.dl", 90.0));
		assertTrue(loja.vendeJogo("Igor.dl", jogo));
		assertEquals(1, loja.qntJogosUsuario("Igor.dl"));
		assertEquals(1, loja.getUsuarios().size());
		assertTrue(loja.upgrade("Igor.dl"));
		assertEquals(1, loja.getUsuarios().size());
		
		try {
			assertFalse(loja.upgrade("Igor.dl"));
		} catch (Exception e) {
			assertEquals("Esse usuario jah eh veterano", e.getMessage());
		}
		assertFalse(loja.vendeJogo("Igor.dl", jogo));
	
		assertTrue(loja.removeUsuario("Igor.dl"));
		assertEquals(0, loja.getUsuarios().size());
	}

}
