package codigo;

import java.util.Random;

import javax.swing.JOptionPane;

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
	
	
	//Método - Validar cadastro [Usuario]
	public void validarUsuario(String novoUsuario, String novaSenha, String confirmaSenha) {
		
		//Verificar possíveis erros
		
		//Erro 0 = Sem erros
		//Erro 1 = Campo em branco
		//Erro 2 = ID já cadastrado
		//Erro 3 = As senhas não coincidem
		
			//Campos em branco
			if(novoUsuario.equals("") || novaSenha.equals("") || confirmaSenha.equals("")) {
				erroCadastro = 1;
				mensagemErro = "Não deixe nenhum campo em branco";
				
			}
			
			//Verificar se ID ja existe
			for(int validador = 0 ; validador < Usuarios.dados.size() ; validador++) {
				
				if(novoUsuario.equals(Usuarios.dados.get(validador).getUsuario())) {
					erroCadastro = 2;
					mensagemErro = "Essa ID ja está sendo usada";
				}
				
			//Verificar se as senhas estão iguais
				if(!novaSenha.equals(confirmaSenha)) {
					erroCadastro = 3;
					mensagemErro = "As senhas não coincidem";
				}
			}
	}
	
	
	//Método - Validar cadastro [Dados pessoais]
	public void validarDadosPessoais(String nomeUsuario, String sobrenomeUsuario, String datanascimentoUsuario, String emailUsuario, boolean termoSelecionado) {
		
			//Campos em branco
			if(nomeUsuario.equals("") || sobrenomeUsuario.equals("") || datanascimentoUsuario.equals("") || emailUsuario.equals("")) {
				erroCadastro = 1;
				mensagemErro = "Não deixe nenhum campo em branco";
				
			}
			
			//Verificar se a caixa de termo foi selecionada
			if(termoSelecionado == false) {
				erroCadastro = 2;
				mensagemErro = "Confirme os termos que você não leu";
			}
	}
	
	
	//Método - Cadastrar o usuario no sistema
	public void cadastraPlayer(String novoUsuario, String novaSenha, String confirmaSenha, String nomeUsuario, String sobrenomeUsuario, String datanascimentoUsuario, String emailUsuario) {
		
		//Instanciando a classe Usuarios
		Usuarios usu = new Usuarios();
		
		//Capturando os valores das variaveis
		usu.setUsuario(novoUsuario);
		usu.setSenha(novaSenha);
		usu.setNome(nomeUsuario);
		usu.setSobrenome(sobrenomeUsuario);
		usu.setDataNascimento(datanascimentoUsuario);
		usu.setEmail(emailUsuario);
		usu.setPoderAcesso(2);
		
		//Gerando código do usuario
		Random codigoUsuario = new Random();
		usu.setChaveAcesso(codigoUsuario.nextInt(99999));
	
		//Adicionando os dados ao vetor
		Usuarios.dados.add(usu);
		
		}
	
	
	}

