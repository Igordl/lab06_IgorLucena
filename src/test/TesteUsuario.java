package test;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import jogo.Jogo;
import jogo.Luta;
import jogo.Plataforma;
import jogo.RPG;
import usuario.Noob;
import usuario.Usuario;
import usuario.Veterano;

public class TesteUsuario {

	private Usuario igor;

	private Jogo skyrim;
	private Jogo trine;
	private Jogo superSmash;

	@Before
	public void setUpUser() throws Exception {

		igor = new Noob("Igordl", "Igor-dl");

	}

	@Before
	public void setUpGame() throws Exception {

		skyrim = new RPG("Skyrim", 40.0);
		trine = new Plataforma("Trine", 0.0);
		superSmash = new Luta("Super Smash", 60.0);

	}

	@Test
	public void testUsuario() throws Exception {

		Jogo jogoLOL = new RPG("Lol", 10.0);
		Jogo jogoSF = new Luta("Street Fighter", 20.0);
		Jogo jogoMario = new Plataforma("Mario World", 65.5);

		igor.addDinheiro(10.0);

		assertEquals(10.0, igor.getDinheiro(), 0.05);
		assertTrue(igor.addJogo(jogoLOL));
		assertEquals(1.0, igor.getDinheiro(), 0.05);
		assertEquals(100, igor.getX2p());
		assertTrue(igor.registraJogada("Lol", 875, false));
		assertEquals(110, igor.getX2p());

		assertFalse(igor.addJogo(jogoSF));

		igor.addDinheiro(17.0);

		assertEquals(18.0, igor.getDinheiro(), 0.05);
		assertTrue(igor.addJogo(jogoSF));
		assertEquals(310, igor.getX2p());
		assertTrue(igor.registraJogada("Street Fighter", 79586, true));
		assertEquals(389, igor.getX2p());
		assertEquals(0.0, igor.getDinheiro(), 0.05);

		igor.addDinheiro(60.0);

		assertEquals(60.0, igor.getDinheiro(), 0.05);
		assertTrue(igor.addJogo(jogoMario));
		assertEquals(1039, igor.getX2p());
		assertTrue(igor.registraJogada("Mario World", 356, true));
		assertEquals(1059, igor.getX2p());
		assertEquals(1.00, igor.getDinheiro(), 0.05);

	}

	@Test
	public void TestUsuarioWithException() {

		try {
			Usuario usuario1 = new Noob(" ", "usuario.1");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo ou vazio", e.getMessage());
		}

		try {
			Usuario usuario2 = new Veterano("Usuario2", " ");
		} catch (Exception e) {
			assertEquals("Login nao pode ser nulo ou vazio", e.getMessage());
		}
		try {
			Usuario usuario3 = new Noob("usuario3", "usuario.3");
			usuario3.addDinheiro(-10);
		} catch (Exception e) {
			assertEquals("Nao eh possivel valor negativo", e.getMessage());
		}
		try {
			Usuario usuario4 = new Noob("usuario4", "usuario.4");
			usuario4.compraJogo(-5);
		} catch (Exception e) {
			assertEquals("Nao eh possivel valor negativo", e.getMessage());
		}

	}

	@Test
	public void testRegistraJogada() throws Exception {

		igor.addDinheiro(100.0);

		igor.addJogo(skyrim);
		igor.addJogo(superSmash);

		assertTrue(igor.registraJogada("Skyrim", 230, false));
		assertTrue(igor.registraJogada("Super Smash", 1000, true));

	}

	@Test
	public void testAddAndRemoveJogo() throws Exception {

		igor.addDinheiro(120.0);

		igor.addJogo(skyrim);
		igor.addJogo(superSmash);

		assertTrue(igor.getJogos().contains(skyrim));
		assertTrue(igor.getJogos().contains(superSmash));

		igor.removeJogo(skyrim);
		igor.removeJogo(superSmash);

		assertFalse(igor.getJogos().contains(skyrim));
		assertFalse(igor.getJogos().contains(superSmash));

	}

	@Test
	public void testAddX2p() throws Exception {

		igor.addDinheiro(200.0);

		igor.addJogo(skyrim);

		igor.registraJogada("Skyrim", 1000, false);

		assertEquals(410, igor.getX2p());

		igor.addJogo(superSmash);

		igor.registraJogada("Super Smash", 1230, true);

		assertEquals(1011, igor.getX2p());

		igor.addJogo(trine);

		igor.registraJogada("Trine", 22300, true);

		assertEquals(1031, igor.getX2p());

	}

	@Test
	public void testEqualsObject() throws Exception {

		Usuario otherUser = new Noob("Igordl", "Igor-dl");

		assertTrue(otherUser.equals(igor));
		assertTrue(igor.equals(otherUser));

		Usuario otherUser2 = new Noob("Igordl", "Igordl");
		assertFalse(otherUser2.equals(igor));
		assertFalse(otherUser2.equals(otherUser));

	}

}
