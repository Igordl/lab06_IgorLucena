package Usuario;

import java.util.HashSet;

import Jogo.FactoryJogos;
import Jogo.Jogo;

public abstract class Usuario {
	protected String nome;
	protected String login;
	protected double dinheiro;
	protected int x2p;
	protected HashSet<Jogo> jogos;
	protected FactoryJogos factoryJogos;

	public Usuario(String nome, String login) throws Exception {
		verificaNomeInvalido(nome, login);
		this.nome = nome;
		this.login = login;
		this.jogos = new HashSet<>();
		this.factoryJogos = new FactoryJogos();
	}

	public void registraJogada(String nomeJogo, int scoreJogada, boolean zerou) {
		for (Jogo jogo : jogos) {
			if (nomeJogo.equalsIgnoreCase(jogo.getNome())) {
				jogo.registraJogada(scoreJogada, zerou);
			}
		}
	}

	public abstract boolean addJogo(Jogo jogo);
	
	public abstract boolean addJogo(String nome, double preco , String tipo) throws Exception ;
	

	public boolean removeJogo(Jogo jogo) {
		if (!jogos.contains(jogo)) {
			jogos.remove(jogo);
			return true;
		}
		return false;
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

	public void compraJogo(double precoJogo) {
		this.dinheiro -= precoJogo;
	}
	public void addDinheiro(double valor){
		this.dinheiro += valor;
	}
	public void setDinheiro(double valor) {
		this.dinheiro = valor;
	}
	public HashSet<Jogo> getJogos() {
		return jogos;
	}

	private void verificaNomeInvalido(String nome, String login) throws Exception {
		if (nome == null || nome.trim().equals("")) {
			throw new Exception("Nome nao pode ser nulo ou vazio");
		}
		if (login == null || login.trim().equals("")) {
			throw new Exception("Login nao pode ser nulo ou vazio");
		}
	}
}
