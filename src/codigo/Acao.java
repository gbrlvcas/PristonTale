package codigo;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import interfaceGrafica.IG_Cadastrar_Pessoal;
import interfaceGrafica.IG_Cadastrar_Usuario;
import interfaceGrafica.IG_Principal_ADM;

public class Acao {
	
	//Atributos
	public static String mensagemErro = ""; //Variavel que ser� usada para exibir a mensagem de erros em todas inferfaces
	public static int erroLogin = 0;
	public static int erroCadastro = 0;

	
	//M�todo - Criando usuario do ADM
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
	
	//M�todo - Validando o Login
	public void validaLogin(String usuario, String senha) {

		//Verificar poss�veis erros
		erroLogin = 0; //Na classe IG_Login, a classe Acao � instanciando fora do bot�o, logo toda vez que o botao for clicado o valor de erro nao sera alterado para 0;
		
			//Campos em branco
			if(usuario.equals("") || senha.equals("")) {
				erroLogin = 1;
				mensagemErro = "N�o deixe nenhum campo em branco";
			}
		
		//Verificar se us�ario ja est� cadastrado
		for(int validador = 0; validador < Usuarios.dados.size() ; validador++) {
		
				//Verificando o Usu�rio
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

