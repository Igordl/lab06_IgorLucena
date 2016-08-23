package usuario;

import java.util.HashSet;
import java.util.Set;

import jogo.FactoryJogos;
import jogo.Jogo;

public abstract class Usuario {
	protected final String FIM_DE_LINHA = System.lineSeparator();
	protected String nome;
	protected String login;
	protected double dinheiro;
	protected int x2p;
	protected String tipo = null;
	protected Set<Jogo> jogos;
	protected FactoryJogos factoryJogos;

	public Usuario(String nome, String login) throws Exception {
		verificaNomeInvalido(nome, login);
		this.nome = nome;
		this.login = login;
		this.jogos = new HashSet<Jogo>();
		this.factoryJogos = new FactoryJogos();

	}

	public boolean registraJogada(String nomeJogo, int scoreJogada, boolean zerou) {
		for (Jogo jogo : jogos) {
			if (nomeJogo.equalsIgnoreCase(jogo.getNome())) {
				int x2pJogada = jogo.registraJogada(scoreJogada, zerou);
				addX2p(x2pJogada);
				return true;

			}
		}
		return false;
	}

	public abstract boolean addJogo(Jogo jogo) throws Exception;

	public abstract boolean addJogo(String nome, double preco, String tipo) throws Exception;

	public boolean removeJogo(Jogo jogo) {
		if (jogos.contains(jogo)) {
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

	public void addX2p(int x2p) {
		this.x2p += x2p;
	}

	public void compraJogo(double precoJogo) throws Exception {
		if(precoJogo < 0){
			throw new Exception("Nao eh possivel valor negativo");
		}
		this.dinheiro -= precoJogo;
	}

	public void addDinheiro(double valor) throws Exception {
		if(valor < 0){
			throw new Exception("Nao eh possivel valor negativo");
		}
		this.dinheiro += valor;
	}

	public void setDinheiro(double valor) {
		this.dinheiro = valor;
	}

	public HashSet<Jogo> getJogos() {
		return (HashSet<Jogo>) jogos;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getX2p() {
		return x2p;
	}

	public void setX2p(int x2p) {
		this.x2p = x2p;
	}

	public void setJogos(HashSet<Jogo> jogos) {
		this.jogos = jogos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Usuario) {
			Usuario outroObjeto = (Usuario) objeto;
			if (outroObjeto.getLogin().equalsIgnoreCase(login)) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		String retorno = getLogin() + FIM_DE_LINHA + getNome() + " - Jogador" + getTipo() + FIM_DE_LINHA
				+ "Lista de Jogos:";
		double valorTotal = 0.0;
		for (Jogo jogo : jogos) {
			retorno += FIM_DE_LINHA + jogo.toString();
			valorTotal += jogo.getPreco();
		}
		retorno += FIM_DE_LINHA + "Total de jogos: R$ " + valorTotal;
		return retorno;
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
