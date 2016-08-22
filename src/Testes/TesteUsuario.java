package Testes;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Jogo.Jogo;
import Jogo.Luta;
import Jogo.Plataforma;
import Jogo.RPG;
import Usuario.Noob;
import Usuario.Usuario;
import Usuario.Veterano;

public class TesteUsuario {
	Usuario igor;

	@Before
	public void setup() throws Exception {
		igor = new Noob("Igordl", "Igor-dl");

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
	public void TestUsuarioExcepition(){
		
		try{
		Usuario usuario1 = new Noob(" ", "usuario.1");
		}catch(Exception e){
			assertEquals("Nome nao pode ser nulo ou vazio", e.getMessage());
		}
		
		try{
			Usuario usuario2 = new Veterano("Usuario2", " ");
			}catch(Exception e){
				assertEquals("Login nao pode ser nulo ou vazio", e.getMessage());
			}
		try{
			Usuario usuario3 = new Noob("usuario3", "usuario.3");
			usuario3.addDinheiro(-10);
			}catch(Exception e){
				assertEquals("Nao eh possivel valor negativo", e.getMessage());
			}
		try{
			Usuario usuario4 = new Noob("usuario4", "usuario.4");
			usuario4.compraJogo(-5);
		}catch(Exception e){
			assertEquals("Nao eh possivel valor negativo", e.getMessage());
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
