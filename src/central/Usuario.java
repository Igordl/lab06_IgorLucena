package central;

import java.util.HashSet;

public class Usuario {
	protected String nome;
	protected String login;
	protected double dinheiro;
	protected int x2p;
	protected HashSet<Jogo> jogos;

	public Usuario(String nome, String login) throws Exception {
		verificaNomeInvalido(nome, login);
		this.nome = nome;
		this.login = login;
		this.jogos = new HashSet<>();
	}

	public void registraJogada(String nomeJogo, int scoreJogada, boolean zerou) {
		for (Jogo jogo : jogos) {
			if (nomeJogo.equalsIgnoreCase(jogo.getNome())) {
				jogo.registraJogada(scoreJogada, zerou);
			}
		}
	}

	public boolean addJogo(Jogo jogo) {
		if (!jogos.contains(jogo)) {
			if (getDinheiro() >= jogo.getPreco()) {
				setDinheiro(jogo.getPreco());
				jogos.add(jogo);
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean removeJogo(Jogo jogo) {
		if (!jogos.contains(jogo)) {
			jogos.remove(jogo);
			return true;
		}
		return false;
	}

	public int totalComprado() {
		int total = 0;
		for (Jogo jogo : jogos) {
			total += (int) jogo.getPreco();
		}
		return total;
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

	private void verificaNomeInvalido(String nome, String login) throws Exception {
		if (nome == null || nome.trim().equals("")) {
			throw new Exception("Nome nao pode ser nulo ou vazio");
		}
		if (login == null || login.trim().equals("")) {
			throw new Exception("Login nao pode ser nulo ou vazio");
		}
	}
}
