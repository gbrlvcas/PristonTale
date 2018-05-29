package codigo;

import java.util.ArrayList;

public class Usuarios {

	//Informa��es sobre o poder de acesso
	//Poder acesso = 0 : ADM
	//Poder acesso = 1 : GM
	//Poder acesso = 2 : Player
	
	
	//Atributos
	private String usuario;
	private String senha;
	private String poderAcesso;
	
	//M�todos magicos
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
	public static ArrayList<Usuarios> dados = new ArrayList<>();//
}
