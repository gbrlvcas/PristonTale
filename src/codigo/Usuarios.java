package codigo;

import java.util.ArrayList;

public class Usuarios {

	//Informações sobre o poder de acesso
	//Poder acesso = 0 : ADM
	//Poder acesso = 1 : GM
	//Poder acesso = 2 : Player
	
	
	//Atributos
	private String usuario;
	private String senha;
	private String nome;
	private String sobrenome;
	private String dataNascimento;
	private String email;
	private int poderAcesso;
	private int chaveAcesso;
	
	
	
//Métodos mágicos
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPoderAcesso() {
		return poderAcesso;
	}
	public void setPoderAcesso(int poderAcesso) {
		this.poderAcesso = poderAcesso;
	}
	public int getChaveAcesso() {
		return chaveAcesso;
	}
	public void setChaveAcesso(int chaveAcesso) {
		this.chaveAcesso = chaveAcesso;
	}




	//ArrayList
	public static ArrayList<Usuarios> dados = new ArrayList<>();//
}
