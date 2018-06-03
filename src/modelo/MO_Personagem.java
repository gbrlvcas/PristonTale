package modelo;

import java.util.ArrayList;

public class MO_Personagem {


	//Variaveis
	private String msgBoasVindas;
	private String nomeChar;
	private String classeChar;
	private int nivelChar;
	private int statsForca;
	private int statsInteligencia;
	private int statsAgilidade;
	private int statsTalento;
	private int statsVitalidade;
	
	public String getMsgBoasVindas() {
		return msgBoasVindas;
	}
	public void setMsgBoasVindas(String msgBoasVindas) {
		this.msgBoasVindas = msgBoasVindas;
	}
	public String getNomeChar() {
		return nomeChar;
	}
	public void setNomeChar(String nomeChar) {
		this.nomeChar = nomeChar;
	}
	public String getClasseChar() {
		return classeChar;
	}
	public void setClasseChar(String classeChar) {
		this.classeChar = classeChar;
	}
	public int getNivelChar() {
		return nivelChar;
	}
	public void setNivelChar(int nivelChar) {
		this.nivelChar = nivelChar;
	}
	public int getStatsForca() {
		return statsForca;
	}
	public void setStatsForca(int statsForca) {
		this.statsForca = statsForca;
	}
	public int getStatsInteligencia() {
		return statsInteligencia;
	}
	public void setStatsInteligencia(int statsInteligencia) {
		this.statsInteligencia = statsInteligencia;
	}
	public int getStatsAgilidade() {
		return statsAgilidade;
	}
	public void setStatsAgilidade(int statsAgilidade) {
		this.statsAgilidade = statsAgilidade;
	}
	public int getStatsTalento() {
		return statsTalento;
	}
	public void setStatsTalento(int statsTalento) {
		this.statsTalento = statsTalento;
	}
	public int getStatsVitalidade() {
		return statsVitalidade;
	}
	public void setStatsVitalidade(int statsVitalidade) {
		this.statsVitalidade = statsVitalidade;
	}
	
	//ArrayList
	public static ArrayList<MO_Personagem> dados = new ArrayList<>();
	
	
	
	
}
