package Usuario;

import Jogo.Jogo;

public class Veterano extends Usuario {

	public Veterano(String nome, String login) throws Exception {
		super(nome, login);
		super.x2p = 1000;

	}

	public boolean addJogo(Jogo jogo) {

		if (!jogos.contains(jogo)) {
			double taxaDescontoVeterano = -0.2;
			double desconto = jogo.getPreco() * taxaDescontoVeterano;
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
				double taxaDescontoVeterano = -0.2;
				double desconto = jogo.getPreco() * taxaDescontoVeterano;
				setDinheiro(jogo.getPreco() + desconto);
				jogos.add(jogo);
				adicionaX2p(jogo.getPreco());
				return true;
			}
			return false;
		}
		return false;
	}

	public void adicionaX2p(double precoJogo) {
		int x2pVeterano = 15;
		x2p += ((int) precoJogo) * x2pVeterano;
	}

}
