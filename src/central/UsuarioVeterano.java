package central;

public class UsuarioVeterano extends Usuario{

	public UsuarioVeterano(String nome) throws Exception {
		super(nome);
		
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
		x2p += totalCompra() * x2pVeterano;
	}

}
