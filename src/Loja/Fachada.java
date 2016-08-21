package Loja;

import java.util.HashSet;

import Jogo.Jogo;
import Usuario.Usuario;

public class Fachada {
	protected final String FIM_DE_LINHA = System.lineSeparator();
	private HashSet<Usuario> usuarios;

	public Fachada() {
		usuarios = new HashSet<>();
	}
	
	public void vendeJogo(String login, Jogo jogo){
		for (Usuario usuario : usuarios) {
			if(usuario.getLogin().equalsIgnoreCase(login)){
				usuario.addJogo(jogo);
			}
		}
		
	}
	public void addUsuario(Usuario usuario){
		usuarios.add(usuario);
	}
	
	public void addDinheiroToUsuario(String login, double valor){
		for (Usuario usuario : usuarios) {
			if(usuario.getLogin().equalsIgnoreCase(login)){
				usuario.addDinheiro(valor);
			}
		}
	}
	public String toString(){
		String retorno = "=== Central P2-CG ===" + FIM_DE_LINHA;
		for (Usuario usuario : usuarios) {
			retorno += FIM_DE_LINHA + usuario.toString();
		}
		retorno += FIM_DE_LINHA + FIM_DE_LINHA + "--------------------------------------------";
		return retorno;
	}
}
