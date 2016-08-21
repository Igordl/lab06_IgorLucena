package Usuario;

public class FactoryUsuario {
	
	public FactoryUsuario() {
	}
	
	public Usuario factoryUsuario(String nome, String login, String tipo) throws Exception{
		if(tipo.equalsIgnoreCase("Noob")){
			return new Noob(nome, login);
		}
		else if(tipo.equalsIgnoreCase("Veterano")){
			return new Veterano(nome, login);
		}
		return null;
	}

}
