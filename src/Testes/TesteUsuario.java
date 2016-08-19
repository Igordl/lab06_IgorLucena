package Testes;

import org.junit.Assert;
import org.junit.Before;

import Usuario.Noob;
import Usuario.Usuario;

public class TesteUsuario {
	Usuario usuario;
	@Before
	private void setup() throws Exception {

	}

	public void testUsuario() throws Exception {
		usuario = new Noob("Igor", "Igordl");
		usuario.addDinheiro(100);
		Assert.assertEquals(100.0, usuario.getDinheiro(), 0.05);
		
	}
}
