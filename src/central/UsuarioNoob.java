package central;

public class UsuarioNoob extends Usuario{

	public UsuarioNoob(String nome) throws Exception {
		super(nome);
		
	}
	public boolean addJogo(Jogo jogo){
		double descontoNoob = -0.1;
		if(!jogos.contains(jogo)){
			double desconto = jogo.getPreco() * descontoNoob;
			setDinheiro(jogo.getPreco() + desconto);
			jogos.add(jogo);
			return true;
		}
		return false;
	}
	
	public void setX2p(){
		int x2pNoob = 10;
		x2p += totalCompra() * x2pNoob;
	}
	
	public void registraJogada(String nomeJogo, int scoreJogada, boolean zerou){
		for (Jogo jogo : jogos) {
			if(nomeJogo.equalsIgnoreCase(jogo.getNome())){
				jogo.registraJogada(scoreJogada, zerou);
			}
		}
	}

}
