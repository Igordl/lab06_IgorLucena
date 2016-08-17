package central;

public class Noob extends Usuario{

	public Noob(String nome, String login) throws Exception {
		super(nome, login);
		
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
		x2p += totalComprado() * x2pNoob;
	}
	
	

}
