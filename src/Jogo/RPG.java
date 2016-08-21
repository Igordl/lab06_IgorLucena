package Jogo;

public class RPG extends Jogo {
	
	public RPG(String nome, double preco) throws Exception {
		super(nome, preco);
		super.tipo = "RPG";
		
	}
	public int registraJogada(int scoreJogada, boolean zerou){
		int x2pJogada = 10;
		setQntJogadas();
		if(scoreJogada > this.getMaxScore()){
			setMaxScore(scoreJogada);
		}
		if(zerou){
			setQntZeradas();
		}
		return x2pJogada;
	}

}
