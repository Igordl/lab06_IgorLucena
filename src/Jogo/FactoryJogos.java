package Jogo;

public class FactoryJogos {
	
	public FactoryJogos() {
	}
	public Jogo factoryJogo(String nome, double preco, String tipo) throws Exception {

		if (tipo.equalsIgnoreCase("RPG")) {
			return new RPG(nome, preco);
		} else if (tipo.equalsIgnoreCase("Luta")) {
			return new Luta(nome, preco);
		} else if (tipo.equalsIgnoreCase("Plataforma")) {
			return new Plataforma(nome, preco);
		}
		return null;
	}
}
