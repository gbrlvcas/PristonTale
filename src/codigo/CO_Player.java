package codigo;

import modelo.Estatica;
import modelo.MO_Personagem;
import modelo.MO_Usuarios;

public class CO_Player {

	//M�todo - Boas vindas ao Player
	public void boasVindas() {
		
		//Condicional
		for(MO_Usuarios MOU : MO_Usuarios.dados) {
			if(Estatica.usuarioLogado.equals(MOU.getUsuario())){
				
				Estatica.msgBoasVindas = "Ol� "+MOU.getNome()+" "+MOU.getSobrenome()+", Seja Bem vindo ao Priston Tale";
				
			}
		}

	}
	
	//M�todo - Verificar nickname
	public boolean verificaNick(String nickDisponivel) {
		
		//Condicional [For avan�ado]
		for(MO_Personagem MOP : MO_Personagem.dados) {
			if(nickDisponivel.equals(MOP.getNomeChar())) {
				return false;
			}
		}
		//Retornando
		return true;
	}
	
	
}
