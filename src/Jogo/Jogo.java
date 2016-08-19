
package Jogo;

import java.util.HashSet;

public abstract class Jogo {
	
	protected String nome;
	protected double preco;
	protected int maxScore;
	protected int qntJogadas;
	protected int qntZeradas;
	protected HashSet<Jogabilidade> jogabilidade;
	
	public Jogo(String nome, double preco) throws Exception {
	verificaCricaoInvalida(nome, preco);
	this.nome = nome;
	this.preco = preco;
	jogabilidade = new HashSet<>();
	}
	
	
	public abstract int registraJogada(int scoreJogada, boolean zerou);
	
	
	public void addJogabilidade(Jogabilidade tipoJogabiliade){
		jogabilidade.add(tipoJogabiliade);
	}
	
	public void removeJogabilidade(Jogabilidade tipoJogabiliade){
		jogabilidade.remove(tipoJogabiliade);
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	public int getQntJogadas() {
		return qntJogadas;
	}

	public void setQntJogadas() {
		int jogada = 1;
		this.qntJogadas += jogada;
	}

	public int getQntZeradas() {
		return qntZeradas;
	}

	public void setQntZeradas() {
		int zerou = 1;
		this.qntZeradas += zerou;
	}

	private void verificaCricaoInvalida(String nome, double preco) throws Exception {
		if(nome == null || nome.trim().equals("")){
			throw new Exception("Nome nao pode ser nulo ou vazio");
		}
		if(preco < 0){
			throw new Exception("Preco nao pode ser negativo");
		}
	}
}
