package codigo;

import javax.swing.JOptionPane;

public class Acao {

	
	//M�todo - Criando usuario do ADM
	public void usuarioADM() {
		
	//Adicionando o ADM
	Usuarios usu = new Usuarios();
		
		//Criando o usuario ADM
		usu.setUsuario("admin");
		usu.setSenha("admin");
		usu.setPoderAcesso("0");

		
		//Adicionando ao ArrayList
		Usuarios.dados.add(usu);
		
	}
	
	//M�todo - Validando os usuarios
	public void validaUsuario(String usuario, String senha) {
		
		for(int validador = 0; validador < Usuarios.dados.size() ; validador++) {
			
			//Verificar se us�ario ja est� cadastrado
			
				//Verificando o Usu�rio
			if(usuario.equals(Usuarios.dados.get(validador).getUsuario())) {
				
					//Verificando a Senha
				if(senha.equals(Usuarios.dados.get(validador).getSenha())) {
					
						//Verificando o poder de acesso [Administrador]
					if(Integer.parseInt(Usuarios.dados.get(validador).getPoderAcesso()) == 0) {
						JOptionPane.showMessageDialog(null, "Admin Logado");
						
						//Verificando o poder de acesso [GM]
					}else if(Integer.parseInt(Usuarios.dados.get(validador).getPoderAcesso()) == 1) {
						JOptionPane.showMessageDialog(null, "GM Logado");
						
						//Verificando o poder de acesso [Player]
					}else if(Integer.parseInt(Usuarios.dados.get(validador).getPoderAcesso()) == 2) {
						JOptionPane.showMessageDialog(null, "Player Logado");
						
					}
					
				}
			}
		}
	}
	
	
	
	
	
	
	
	
}
