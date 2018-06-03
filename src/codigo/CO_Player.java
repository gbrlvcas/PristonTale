package codigo;

import modelo.Estatica;

import modelo.MO_Usuarios;

public class CO_Player {

	//Método - Boas vindas ao Player
	public void boasVindas() {
		
		//Condicional
		for(MO_Usuarios MOU : MO_Usuarios.dados) {
			if(Estatica.usuarioLogado.equals(MOU.getUsuario())){
				
				Estatica.msgBoasVindas = "Olá "+MOU.getNome()+" "+MOU.getSobrenome()+", Seja Bem vindo ao Priston Tale";
				
			}
		}

	}
}
