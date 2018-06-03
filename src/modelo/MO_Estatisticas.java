package modelo;

import java.util.ArrayList;

public class MO_Estatisticas {

	private String estUsuario;
	private String estNome;
	private String estData;
	private String estHora;
	private int estChar;
	
	
	public String getEstUsuario() {
		return estUsuario;
	}
	public void setEstUsuario(String estUsuario) {
		this.estUsuario = estUsuario;
	}
	public String getEstNome() {
		return estNome;
	}
	public void setEstNome(String estNome) {
		this.estNome = estNome;
	}
	public String getEstData() {
		return estData;
	}
	public void setEstData(String estData) {
		this.estData = estData;
	}
	public String getEstHora() {
		return estHora;
	}
	public void setEstHora(String estHora) {
		this.estHora = estHora;
	}
	public int getEstChar() {
		return estChar;
	}
	public void setEstChar(int estChar) {
		this.estChar = estChar;
	}



	//ArrayList
	public static ArrayList<MO_Estatisticas> dados = new ArrayList<>();
}
