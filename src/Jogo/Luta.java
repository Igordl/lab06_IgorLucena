package Jogo;

public class Luta extends Jogo {
	

	public Luta(String nome, double preco) throws Exception {
		super(nome, preco);
		super.tipo = "Luta";

	}

	public int registraJogada(int scoreJogada, boolean zerou) {
		if(scoreJogada > 100000){
			scoreJogada = 100000;
		}
		int taxaX2pJogada = 1000;
		addJogada();
		if (scoreJogada > this.getMaxScore()) {
			setMaxScore(scoreJogada);
		}
		if (zerou) {
			addZerou();
		}
		return (scoreJogada / taxaX2pJogada);
	}

}
