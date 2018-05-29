package codigo;

import java.util.ArrayList;

public class Usuarios {

	//Atributos
	private String usuario;
	private String senha;
	private String poderAcesso;
	
	//Métodos magicos
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPoderAcesso() {
		return poderAcesso;
	}
	public void setPoderAcesso(String poderAcesso) {
		this.poderAcesso = poderAcesso;
	}
	
	
	//ArrayList
	public static ArrayList<Usuarios> dados = new ArrayList<>();
}
