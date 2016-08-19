package Jogo;

public class Luta extends Jogo {
	

	public Luta(String nome, double preco) throws Exception {
		super(nome, preco);

	}

	public int registraJogada(int scoreJogada, boolean zerou) {
		int taxaX2pJogada = 1000;
		setQntJogadas();
		if (scoreJogada > this.getMaxScore()) {
			setMaxScore(scoreJogada);
		}
		if (zerou) {
			setQntZeradas();
		}
		return (scoreJogada / taxaX2pJogada);
	}

}
