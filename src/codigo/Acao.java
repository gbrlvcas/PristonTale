package codigo;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import interfaceGrafica.IG_Cadastrar_Pessoal;
import interfaceGrafica.IG_Cadastrar_Usuario;
import interfaceGrafica.IG_Principal_ADM;

public class Acao {
	
	//Atributos
	public static String mensagemErro = ""; //Variavel que será usada para exibir a mensagem de erros em todas inferfaces
	public int erroLogin = 0;
	public int erroCadastro = 0;

	
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
	
	
	//Método - Validando o Login
	public void validaLogin(String usuario, String senha) {

		//Verificar possíveis erros
		erroLogin = 0; //Na classe IG_Login, a classe Acao é instanciando fora do botão, logo toda vez que o botao for clicado o valor de erro nao sera alterado para 0;
		
			//Campos em branco
			if(usuario.equals("") || senha.equals("")) {
				erroLogin = 1;
				mensagemErro = "Não deixe nenhum campo em branco";
			}
		
		//Verificar se usúario ja está cadastrado
		for(int validador = 0; validador < Usuarios.dados.size() ; validador++) {
		
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
	
	//Método - Verificar disponibilidade do ID
	public boolean idDisponivel (String idDisponivel) {
	
		//Variavel
		boolean verificaID = false;
		
			//Verificando os ID's
			for(int analisa = 0 ; analisa < Usuarios.dados.size() ; analisa++) {
				if(idDisponivel.equals(Usuarios.dados.get(analisa).getUsuario())) {
					verificaID = true;
				}
				
			}
			
			//Retornar
			return verificaID;
	}

	
	//Método - Validar cadastro [Usuario]
	public void validarUsuario() {
		
		
		//Verificar possíveis erros
		erroCadastro = 0;
		
		//Erro 0 = Sem erros
		//Erro 1 = Campo em branco
		//Erro 2 = ID já cadastrado
		//Erro 3 = As senhas não coincidem
		
			//Campos em branco
			if(IG_Cadastrar_Usuario.novoUsuario.equals("") || IG_Cadastrar_Usuario.novaSenha.equals("") || IG_Cadastrar_Usuario.confirmaSenha.equals("")) {
				erroCadastro = 1;
				mensagemErro = "Não deixe nenhum campo em branco";
				
			}
			
			//Verificar se ID ja existe
			for(int validador = 0 ; validador < Usuarios.dados.size() ; validador++) {
				
				if(IG_Cadastrar_Usuario.novoUsuario.equals(Usuarios.dados.get(validador).getUsuario())) {
					erroCadastro = 2;
					mensagemErro = "Essa ID ja está sendo usada";
				}
				
			//Verificar se as senhas estão iguais
				if(!IG_Cadastrar_Usuario.novaSenha.equals(IG_Cadastrar_Usuario.confirmaSenha)) {
					erroCadastro = 3;
					mensagemErro = "As senhas não coincidem";
				}
			}
	}
	
	
	//Método - Validar cadastro [Dados pessoais]
	public void validarDadosPessoais() {
		
			//Campos em branco 
			if(IG_Cadastrar_Pessoal.nomeUsuario.equals("") || IG_Cadastrar_Pessoal.sobrenomeUsuario.equals("") || IG_Cadastrar_Pessoal.datanascimentoUsuario.equals("") || IG_Cadastrar_Pessoal.emailUsuario.equals("")) {
				
				erroCadastro = 1;
				mensagemErro = "Não deixe nenhum campo em branco";
				
			}
			
			//Verificar se a caixa de termo foi selecionada
			if(IG_Cadastrar_Pessoal.termoSelecionado == false) {
				erroCadastro = 2;
				mensagemErro = "Confirme os termos que você não leu";
			}
	}
	
	
	//Método - Cadastrar o usuario no sistema
	public void cadastraPlayer() {
		
		//Instanciando a classe Usuarios
		Usuarios usu = new Usuarios();
		
		
		//Capturando os valores das variaveis
		usu.setUsuario(IG_Cadastrar_Usuario.novoUsuario);
		usu.setSenha(IG_Cadastrar_Usuario.novaSenha);
		usu.setNome(IG_Cadastrar_Pessoal.nomeUsuario);
		usu.setSobrenome(IG_Cadastrar_Pessoal.sobrenomeUsuario);
		usu.setDataNascimento(IG_Cadastrar_Pessoal.datanascimentoUsuario);
		usu.setEmail(IG_Cadastrar_Pessoal.emailUsuario);
		usu.setPoderAcesso(2);
		
		System.out.println(IG_Cadastrar_Usuario.novoUsuario);
		System.out.println(IG_Cadastrar_Usuario.novaSenha);
		System.out.println(IG_Cadastrar_Pessoal.nomeUsuario);
		System.out.println(IG_Cadastrar_Pessoal.sobrenomeUsuario);
		System.out.println(IG_Cadastrar_Pessoal.datanascimentoUsuario);
		System.out.println(IG_Cadastrar_Pessoal.emailUsuario);
		
		
		
		//Gerando código do usuario
		Random codigoUsuario = new Random();
		usu.setChaveAcesso(codigoUsuario.nextInt(99999));
		System.out.println(codigoUsuario);
		
		//Adicionando os dados ao vetor
		Usuarios.dados.add(usu);
		
		
		}
	
	
	}

