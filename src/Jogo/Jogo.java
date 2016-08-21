
package Jogo;

import java.util.HashSet;

public abstract class Jogo {
	private final String FIM_DE_LINHA = System.lineSeparator();
	protected String nome;
	protected double preco;
	protected int maxScore;
	protected int qntJogadas;
	protected int qntZeradas;
	protected String tipo = null;
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

	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	


	public HashSet<Jogabilidade> getJogabilidade() {
		return jogabilidade;
	}


	public void setJogabilidade(HashSet<Jogabilidade> jogabilidade) {
		this.jogabilidade = jogabilidade;
	}

	public String toString(){
		String retorno = "+ " + getNome() +" - "+ getTipo();
		retorno += FIM_DE_LINHA + "==> Jogou "+ getQntJogadas() + "vez(es)";
		retorno += FIM_DE_LINHA + "==> Zerou "+ getQntZeradas() + "vez(es)";
		retorno += FIM_DE_LINHA + "==> Maior score: " + getMaxScore();
		return retorno;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jogabilidade == null) ? 0 : jogabilidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Jogo){
			Jogo outroObj = (Jogo) obj;
			if(outroObj.getNome().equalsIgnoreCase(nome)){
				if(outroObj.getJogabilidade().equals(jogabilidade)){
					return true;
				}
			}
		}
		return false;
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
