package codigo;

import javax.swing.JOptionPane;

import interfaceGrafica.IG_Login;
import interfaceGrafica.IG_Principal_ADM;

public class Acao {

	
	//Método - Criando usuario do ADM
	public void usuarioADM() {
		
	//Adicionando o ADM
	Usuarios usu = new Usuarios();
		
		//Criando o usuario ADM
		usu.setUsuario("admin");
		usu.setSenha("admin");
		usu.setPoderAcesso(0);

		//Adicionando ao ArrayList
		Usuarios.dados.add(usu);
	
	}
	
	//Método - Validando os usuarios
	public void validaUsuario(String usuario, String senha) {
		
		for(int validador = 0; validador < Usuarios.dados.size() ; validador++) {
			
			//Verificar se usúario ja está cadastrado
			
				//Verificando o Usuário
			if(usuario.equals(Usuarios.dados.get(validador).getUsuario())) {
				
					//Verificando a Senha
				if(senha.equals(Usuarios.dados.get(validador).getSenha())) {
					
						//Verificando o poder de acesso [Administrador]
					if(Usuarios.dados.get(validador).getPoderAcesso() == 0) {
						
						IG_Principal_ADM adm = new IG_Principal_ADM();
						adm.setVisible(true);
						
					
						//Verificando o poder de acesso [GM]
					}else if(Usuarios.dados.get(validador).getPoderAcesso() == 1) {
						JOptionPane.showMessageDialog(null, "GM Logado");
						
						//Verificando o poder de acesso [Player]
					}else if(Usuarios.dados.get(validador).getPoderAcesso() == 2) {
						JOptionPane.showMessageDialog(null, "Player Logado");
						
					}
					
				}
			}
		}
	}
	
	
	
	
	
	
	
	
}
