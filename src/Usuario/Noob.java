package Usuario;

import Jogo.Jogo;

public class Noob extends Usuario {

	public Noob(String nome, String login) throws Exception {
		super(nome, login);
		super.tipo = "Noob";
		super.x2p = 0;

	}

	public boolean addJogo(Jogo jogo) {

		if (!jogos.contains(jogo)) {
			double taxaDescontoNoob = -0.1;
			double desconto = jogo.getPreco() * taxaDescontoNoob;
			setDinheiro(jogo.getPreco() + desconto);
			jogos.add(jogo);
			adicionaX2p(jogo.getPreco());
			return true;
		}
		return false;
	}

	public boolean addJogo(String nome, double preco, String tipo) throws Exception {

		Jogo jogo = factoryJogos.factoryJogo(nome, preco, tipo);
		if (!jogos.contains(jogo)) {
			if (getDinheiro() >= jogo.getPreco()) {
				double taxaDescontoNoob = -0.1;
				double desconto = jogo.getPreco() * taxaDescontoNoob;
				compraJogo(jogo.getPreco() + desconto);
				jogos.add(jogo);
				adicionaX2p(jogo.getPreco());
				return true;
			}
			return false;
		}
		return false;
	}

	public void adicionaX2p(double precoJogo) {
		int x2pNoob = 10;
		x2p += ((int) precoJogo) * x2pNoob;
		// double temp = precoJogo - (precoJogo % 1);
	}
}
