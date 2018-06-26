package codigo;

import java.time.LocalDateTime;

import javax.swing.table.DefaultTableModel;

import modelo.Estatica;
import modelo.MO_Estatisticas;

public class CO_ADM {

	//Método - Ultimo login feito pelo usuario/
	public void ultimoLogin(String usuario) {
		
		//Dados temporais
		LocalDateTime tempo = LocalDateTime.now();
		
		int dia = tempo.getDayOfMonth();
		int mes = tempo.getMonthValue();
		int ano = tempo.getYear();
		int hora = tempo.getHour();
		int minuto = tempo.getMinute();
		
		//Formatando os dados 
		String formataHora = String.valueOf(hora);
			if(formataHora.length() == 1) {
				formataHora = "0" + formataHora;
			}
			
		String formataMinuto = String.valueOf(minuto);
			if(formataMinuto.length() == 1) {
				formataMinuto = "0" + formataMinuto;
		}

		String formataDia = String.valueOf(dia);
			if(formataDia.length() == 1) {
				formataDia = "0" + formataDia;
			}
			
			String formataMes = String.valueOf(mes);
			if(formataMes.length() == 1) {
				formataMes = "0" + formataMes;
			}
			
			
		
		//Concatenando os dados [Tempo]
		String ultimoLogin = formataHora+":"+formataMinuto+" - "+formataDia+"/"+formataMes+"/"+ano;
		
		//Adicionando aos métodos magicos
		for(int indice = 0 ; indice < MO_Estatisticas.dados.size() ; indice++) {
			if(usuario.equals(MO_Estatisticas.dados.get(indice).getEstUsuario())) {
				MO_Estatisticas.dados.get(indice).setUltimoLogin(ultimoLogin);
			}
		}
		
			
	}
	
	//Método - Gravar dados no ArrayList [Cadastro]
	public void gravarEstatisticas() {
	
		//Dados temporais
		LocalDateTime tempo = LocalDateTime.now();
		
		int dia = tempo.getDayOfMonth();
		int mes = tempo.getMonthValue();
		int ano = tempo.getYear();
		int hora = tempo.getHour();
		int minuto = tempo.getMinute();
		int segundos = tempo.getSecond();
		
		//Formatando os dados 
		String formataHora = String.valueOf(hora);
			if(formataHora.length() == 1) {
				formataHora = "0" + formataHora;
		}
		
		String formataMinuto = String.valueOf(minuto);
			if(formataMinuto.length() == 1) {
				formataMinuto = "0" + formataMinuto;
		}
		
		String formataSegundos = String.valueOf(segundos);
			if(formataSegundos.length() == 1) {
				formataSegundos = "0" + formataSegundos;
		}
		
			
		String formataDia = String.valueOf(dia);
			if(formataDia.length() == 1) {
				formataDia = "0" + formataDia;
			}
			
			String formataMes = String.valueOf(mes);
			if(formataMes.length() == 1) {
				formataMes = "0" + formataMes;
			}
		
		//Concatenando os dados [Tempo]
		String data = formataDia+"/"+formataMes+"/"+ano;
		String horario = formataHora+":"+formataMinuto+":"+formataSegundos;
		
		//Adicionando aos métodos mágicos
		MO_Estatisticas MOE = new MO_Estatisticas();
		MOE.setEstNome(Estatica.novoNome);
		MOE.setEstUsuario(Estatica.novoUsuario);
		MOE.setEstData(data);
		MOE.setEstHora(horario);
		
		//Adicionando ao ArrayList
		MO_Estatisticas.dados.add(MOE);
			
	}
	
	
	//Método - Tabela estatisticas
	public DefaultTableModel ListarEstatisticas() {
		
		//Modelo de tabela
		DefaultTableModel modeloEstatisticas = new DefaultTableModel();
		modeloEstatisticas.addColumn("Nome");
		modeloEstatisticas.addColumn("Usuario");
		modeloEstatisticas.addColumn("Data criação");
		modeloEstatisticas.addColumn("Hora criação");
		modeloEstatisticas.addColumn("Ultimo login");
		//modeloEstatisticas.addColumn("Chars");
		
		//Adicionando os dados a tabela
		for(int indice = 0 ; indice < MO_Estatisticas.dados.size() ; indice++) {
			modeloEstatisticas.addRow(new Object[] {
					MO_Estatisticas.dados.get(indice).getEstNome(),
					MO_Estatisticas.dados.get(indice).getEstUsuario(),
					MO_Estatisticas.dados.get(indice).getEstData(),
					MO_Estatisticas.dados.get(indice).getEstHora(),
					MO_Estatisticas.dados.get(indice).getUltimoLogin()
			
			});
		}
		
		//Retornar o modelo
		return modeloEstatisticas;
	}
}
