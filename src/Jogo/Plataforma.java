package Jogo;

public class Plataforma extends Jogo {
	

	public Plataforma(String nome, double preco) throws Exception {
		super(nome, preco);
		super.tipo = "Plataforma";

	}

	public int registraJogada(int scoreJogada, boolean zerou) {
		int x2pJogada = 20;
		int JogadaSemX2p = 0;
		setQntJogadas();
		if (scoreJogada > this.getMaxScore()) {
			setMaxScore(scoreJogada);
		}
		if (zerou) {
			setQntZeradas();
			return x2pJogada;
		}
		return JogadaSemX2p;
	}

}
