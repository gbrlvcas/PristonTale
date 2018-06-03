package codigo;

import java.time.LocalDateTime;

import javax.swing.table.DefaultTableModel;

import modelo.Estatica;
import modelo.MO_Estatisticas;

public class CO_ADM {

	//Método - Gravar dados no ArrayList
	public void gravarEstatisticas() {
	
		//Dados temporais
		LocalDateTime tempo = LocalDateTime.now();
		
		int dia = tempo.getDayOfMonth();
		int mes = tempo.getMonthValue();
		int ano = tempo.getYear();
		int hora = tempo.getHour();
		int minutos = tempo.getMinute();
		int segundos = tempo.getSecond();
		
		//Concatenando os dados [Tempo]
		String data = dia+"/"+mes+"/"+ano;
		String horario = hora+":"+minutos+":"+segundos;
		
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
		//modeloEstatisticas.addColumn("Chars");
		
		//Adicionando os dados a tabela
		for(int indice = 0 ; indice < MO_Estatisticas.dados.size() ; indice++) {
			modeloEstatisticas.addRow(new Object[] {
					MO_Estatisticas.dados.get(indice).getEstNome(),
					MO_Estatisticas.dados.get(indice).getEstUsuario(),
					MO_Estatisticas.dados.get(indice).getEstData(),
					MO_Estatisticas.dados.get(indice).getEstHora()
			
			});
		}
		
		//Retornar o modelo
		return modeloEstatisticas;
	}
}
