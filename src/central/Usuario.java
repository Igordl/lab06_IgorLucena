package central;

import java.util.HashSet;

public class Usuario {
	protected String nome;
	protected double dinheiro;
	protected int x2p;
	protected HashSet<Jogo> jogos;
	
	public Usuario(String nome) throws Exception {
	verificaNomeInvalido(nome);
	this.nome = nome;
	this.jogos = new HashSet<>();
	}
	
	public boolean addJogo(Jogo jogo){
		if(!jogos.contains(jogo)){
			setDinheiro(jogo.getPreco());
			jogos.add(jogo);
			return true;
		}
		return false;
	}
	public boolean removeJogo(Jogo jogo){
		if(!jogos.contains(jogo)){
			jogos.remove(jogo);
			return true;
		}
		return false;
	}
	
	public int totalCompra(){
		int total = 0;
		for (Jogo jogo : jogos) {
			total += (int) jogo.getPreco();
		}
		return  total;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(double precoJogo) {
		this.dinheiro -= precoJogo;
	}

	public HashSet<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(HashSet<Jogo> jogos) {
		this.jogos = jogos;
	}

	private void verificaNomeInvalido(String nome) throws Exception {
		if(nome == null || nome.trim().equals("")){
			throw new Exception("Nome nao pode ser nulo ou vazio");
		}
	}
}
