package codigo;

import javax.swing.JOptionPane;

import interfaceGrafica.IG_ADM_Principal;
import modelo.Estatica;
import modelo.MO_Usuarios;

public class CO_Login {
	
	
	//Método - Criando usuario do ADM
	public void usuarioADM() {
		
	//Adicionando o ADM
	MO_Usuarios MOU = new MO_Usuarios();
		
		//Criando o usuario ADM
		MOU.setUsuario("admin");
		MOU.setSenha("admin");
		MOU.setNome("admin");
		MOU.setSobrenome("admin");
		MOU.setDataNascimento("20/05/1996");
		MOU.setEmail("admin");
		MOU.setPoderAcesso(0);
		MOU.setChaveRecuperacao("admin");

		//Adicionando ao ArrayList
		MO_Usuarios.dados.add(MOU);
	
	}
	
	//Método - Validando o Login
	public void validaLogin(String usuario, String senha) {

		//Verificar possíveis erros
		Estatica.erroLogin = 0; //Na classe IG_Login, a classe Acao é instanciando fora do botão, logo toda vez que o botao for clicado o valor de erro nao sera alterado para 0;
		
			//Campos em branco
			if(usuario.equals("") || senha.equals("")) {
				Estatica.erroLogin = 1;
				Estatica.mensagemErro = "Não deixe nenhum campo em branco";
			}
		
		//Verificar se usúario ja está cadastrado
		for(int validador = 0; validador < MO_Usuarios.dados.size() ; validador++) {
		
				//Verificando o Usuário
			if(usuario.equals(MO_Usuarios.dados.get(validador).getUsuario())) {
				
					//Verificando a Senha
				if(senha.equals(MO_Usuarios.dados.get(validador).getSenha())) {
					
						//Verificando o poder de acesso [Administrador]
					if(MO_Usuarios.dados.get(validador).getPoderAcesso() == 0) {
						
						IG_ADM_Principal adm = new IG_ADM_Principal();
						adm.setVisible(true);
						
					
						//Verificando o poder de acesso [GM]
					}else if(MO_Usuarios.dados.get(validador).getPoderAcesso() == 1) {
						JOptionPane.showMessageDialog(null, "GM Logado");
						
						//Verificando o poder de acesso [Player]
					}else if(MO_Usuarios.dados.get(validador).getPoderAcesso() == 2) {
						JOptionPane.showMessageDialog(null, "Player Logado");
						
					}
					
				}
			}
		}
	}
	
	
	
	

	
	
	}

