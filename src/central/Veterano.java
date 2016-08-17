package central;

public class Veterano extends Usuario{

	public Veterano(String nome, String login) throws Exception {
		super(nome, login);
		
	}
	public boolean addJogo(Jogo jogo){
		double descontoVeterano = -0.2;
		if(!jogos.contains(jogo)){
			double desconto = jogo.getPreco() * descontoVeterano;
			setDinheiro(jogo.getPreco() + desconto);
			jogos.add(jogo);
			return true;
		}
		return false;
	}
	public void setX2p(){
		int x2pVeterano = 10;
		x2p += totalComprado() * x2pVeterano;
	}

}
