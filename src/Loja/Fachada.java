package Loja;

import java.util.HashSet;

import Jogo.Jogo;
import Usuario.FactoryUsuario;
import Usuario.Noob;
import Usuario.Usuario;

public class Fachada {
	protected final String FIM_DE_LINHA = System.lineSeparator();
	private HashSet<Usuario> usuarios;
	private FactoryUsuario factoryUsuario;

	public Fachada() {
		usuarios = new HashSet<>();
		factoryUsuario = new FactoryUsuario();
	}

	public boolean vendeJogo(String login, Jogo jogo) throws Exception {
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equalsIgnoreCase(login)) {
				if (usuario.addJogo(jogo)) {
					return true;
				}
			}
		}
		return false;
	}
	public int qntJogosUsuario(String login) throws Exception {
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equalsIgnoreCase(login)) {
				return usuario.getJogos().size();
			}
		}
		return 0;
	}
	

	public boolean addUsuario(Usuario usuario) {
		if (!usuarios.contains(usuario)) {
			usuarios.add(usuario);
			return true;
		}
		return false;
	}

	public boolean addUsuario(String nome, String login) throws Exception {
		String tipo = "Noob";
		Usuario usuario = factoryUsuario.factoryUsuario(nome, login, tipo);
		if (!usuarios.contains(usuario)) {
			usuarios.add(usuario);
			return true;
		}
		return false;
	}

	public boolean removeUsuario(Usuario usuario) {
		if (usuarios.contains(usuario)) {
			usuarios.remove(usuario);
			return true;
		}
		return false;
	}

	public boolean removeUsuario(String login) {
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equalsIgnoreCase(login)) {
				usuarios.remove(usuario);
				return true;
			}
		}
		return false;
	}
	

	public boolean addDinheiro(String login, double valor) throws Exception {
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equalsIgnoreCase(login)) {
				usuario.addDinheiro(valor);
				return true;
			}
		}
		return false;
	}

	public boolean upgrade(String login) throws Exception {
		for (Usuario usuario : usuarios) {
			if (usuario.getX2p() >= 1000) {
				if (usuario.getLogin().equalsIgnoreCase(login)) {
					if (usuario instanceof Noob) {
						String tipo = "Veterano";
						Usuario novoUsuario = factoryUsuario.factoryUsuario(usuario.getNome(), login, tipo);
						novoUsuario.setDinheiro(usuario.getDinheiro());
						novoUsuario.setJogos(usuario.getJogos());
						novoUsuario.setX2p(usuario.getX2p());
						removeUsuario(usuario);
						addUsuario(novoUsuario);
						return true;
					} else {
						throw new Exception("Esse usuario jah eh veterano");
					}
				}

			}
		}
		return false;
	}

	public HashSet<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(HashSet<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String toString() {
		String retorno = "=== Central P2-CG ===" + FIM_DE_LINHA;
		for (Usuario usuario : usuarios) {
			retorno += FIM_DE_LINHA + usuario.toString();
		}
		retorno += FIM_DE_LINHA + FIM_DE_LINHA + "--------------------------------------------";
		return retorno;
	}
}
