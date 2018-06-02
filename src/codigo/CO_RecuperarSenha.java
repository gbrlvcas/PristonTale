package codigo;

import interfaceGrafica.IG_Erros;
import modelo.Estatica;
import modelo.MO_Usuarios;

public class CO_RecuperarSenha {

	//Método - Verificar chave [Botão]
	public boolean verificaChave(String usuarioVerifica, String chaveVerifica) {
		
		//Condicional [For avançado]
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
	
	
	//Método - Validar e alterar a senha
	public void alterarSenha() {
		
		//Variaveis
		Estatica.erroRecuperar = 0;
		
		//0 = Sem erros
		//Erro 1 = Campo em branco
		//Erro 2 = As senhas não coincidem
		//Erro 3 = Chave de recuperação incorreta
		
		//Erro 1 - Campo em branco
		if(Estatica.verificaUsuario.equals("")
		|| Estatica.verificaChave.equals("")
		|| Estatica.alterarSenha.equals("")
		|| Estatica.confirmaSenha.equals("")) {
			
			Estatica.erroRecuperar = 1;
			Estatica.mensagemErro = "Não deixe nenhum campo em branco";
			
			IG_Erros IE = new IG_Erros();
			IE.setVisible(true);
			
		}
		
		//Erro 2 - As senha não coincidem
		if(!Estatica.alterarSenha.equals(Estatica.confirmaSenha)) {
			
			Estatica.erroRecuperar = 2;
			Estatica.mensagemErro = "As senhas não coincidem";
			
			IG_Erros IGE = new IG_Erros();
			IGE.setVisible(true);
		}
		
		//Erro 3 - Chave de recuperação incorreta
		for(MO_Usuarios MOU : MO_Usuarios.dados) {
			if(Estatica.verificaUsuario.equals(MOU.getUsuario())) {
				if(!Estatica.verificaChave.equals(MOU.getChaveRecuperacao())) {
					
					Estatica.erroRecuperar = 3;
					Estatica.mensagemErro = "Chave de recuperação incorreta";
					
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
