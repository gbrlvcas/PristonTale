package codigo;

import interfaceGrafica.IG_Erros;
import modelo.Estatica;
import modelo.MO_Usuarios;

public class CO_RecuperarSenha {

	//M�todo - Verificar chave [Bot�o]
	public boolean verificaChave(String usuarioVerifica, String chaveVerifica) {
		
		//Condicional [For avan�ado]
		for(MO_Usuarios MOU : MO_Usuarios.dados) {
			if(usuarioVerifica.equals(MOU.getUsuario())) {
				if(chaveVerifica.equals(MOU.getChaveRecuperacao())) {
					return true;
				}
			}
		}
		//Retornando
		return false;
	}
	
	
	//M�todo - Validar e alterar a senha
	public void alterarSenha() {
		
		//Variaveis
		Estatica.erroRecuperar = 0;
		
		//0 = Sem erros
		//Erro 1 = Campo em branco
		//Erro 2 = As senhas n�o coincidem
		//Erro 3 = Chave de recupera��o incorreta
		
		//Erro 1 - Campo em branco
		if(Estatica.verificaUsuario.equals("")
		|| Estatica.verificaChave.equals("")
		|| Estatica.alterarSenha.equals("")
		|| Estatica.confirmaSenha.equals("")) {
			
			Estatica.erroRecuperar = 1;
			Estatica.mensagemErro = "N�o deixe nenhum campo em branco";
			
			IG_Erros IE = new IG_Erros();
			IE.setVisible(true);
			
		}
		
		//Erro 2 - As senha n�o coincidem
		if(!Estatica.alterarSenha.equals(Estatica.confirmaSenha)) {
			
			Estatica.erroRecuperar = 2;
			Estatica.mensagemErro = "As senhas n�o coincidem";
			
			IG_Erros IGE = new IG_Erros();
			IGE.setVisible(true);
		}
		
		//Erro 3 - Chave de recupera��o incorreta
		for(MO_Usuarios MOU : MO_Usuarios.dados) {
			if(Estatica.verificaUsuario.equals(MOU.getUsuario())) {
				if(!Estatica.verificaChave.equals(MOU.getChaveRecuperacao())) {
					
					Estatica.erroRecuperar = 3;
					Estatica.mensagemErro = "Chave de recupera��o incorreta";
					
					IG_Erros IGE = new IG_Erros();
					IGE.setVisible(true);
				}
			}
		}
		
		
		//0 - Cadastrar a nova senha
		if(Estatica.erroRecuperar == 0) {
			
			for(MO_Usuarios MOU : MO_Usuarios.dados) {
				if(Estatica.verificaUsuario.equals(MOU.getUsuario())) {
					MOU.setSenha(Estatica.alterarSenha);
			}
			}
		}
	}
}
