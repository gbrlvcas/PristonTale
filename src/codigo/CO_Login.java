package codigo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import interfaceGrafica.IG_ADM_Principal;
import interfaceGrafica.IG_ADM_R;
import interfaceGrafica.IG_Player_Principal;
import javazoom.jl.player.Player;
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
	
	//Método - #ralfTeam
	public void ralfTeam(String usuario, String senha) {
		
		//Usuario especial para o prof Ralfinho
		if(usuario.equals("ralf") && senha.equals("ralfteam")) {
			
			
			IG_ADM_Principal IGA = new IG_ADM_Principal();
			IGA.setVisible(true);
			
			IG_ADM_R IGAR = new IG_ADM_R();
			IGAR.setVisible(true);
			tocaSom();

			
			//Timer para poder iniciar e terminar o JFrame especial #RALFteam
			final Timer tempo = new Timer (35000, new ActionListener() {
				
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					IGAR.dispose();

				}
			});
			
			tempo.start();
		
			
		}	
		
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
						
						//Liberando acesso ao painel do ADM
						IG_ADM_Principal IGA = new IG_ADM_Principal();
						IGA.setVisible(true);
						
						

						//Verificando o poder de acesso [GM]
					}else if(MO_Usuarios.dados.get(validador).getPoderAcesso() == 1) {
						JOptionPane.showMessageDialog(null, "GM Logado");
						
						//Verificando o poder de acesso [Player]
					}else if(MO_Usuarios.dados.get(validador).getPoderAcesso() == 2) {
						
						//Liberando acesso ao painel do Player
						IG_Player_Principal IGPP = new IG_Player_Principal();
						IGPP.setVisible(true);
						
						//Gravar a ultima vez que o jogador entrou
						CO_ADM COA = new CO_ADM();
						COA.ultimoLogin(usuario);
					}
					
				}
			}
		}
	}

	//Metodo - Torcar um som
	public void tocaSom() {
		new Thread() {
			
			@Override
			public void run() {
				
				try {
					FileInputStream in;
					
					in = new FileInputStream("resources\\SND_R.mp3");
					
					Player p = new Player(in);
					
					p.play();
					}catch (Exception e) {
					
					}
			}
		}.start();
		

	

	}
	
	
	}

