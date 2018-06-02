package codigo;

import java.util.Random;

import interfaceGrafica.IG_Dados;
import interfaceGrafica.IG_Erros;
import interfaceGrafica.IG_Pessoal;
import modelo.Estatica;
import modelo.MO_Usuarios;

public class CO_Cadastro {

	//Atributos
	public int erroUsuario = 0;
	public int erroPessoal = 0;
	
	//Método - Verificar ID [Botão]
	public boolean verificaID(String idDisponivel) {
		
		//Condicional [For avançado]
		for(MO_Usuarios MOU : MO_Usuarios.dados) {
			if(idDisponivel.equals(MOU.getUsuario())) {
				return false;
			}
		}
		//Retornando
		return true;
		
		}
	
		
	//Método - Validar dados [JFrame Usuario]
	public void verificaUsuario() {
		
		//Instanciando [Package: modelo / Classe: Estatica]
		Estatica EST = new Estatica();
		
		//Variaveis
		erroUsuario = 0;
		
		//0 = Sem erros
		//Erro 1 = Campo em branco
		//Erro 2 = ID já cadastrado
		//Erro 3 = As senhas não coincidem
		
		//Erro 1 - Campo em branco
		if(Estatica.novoUsuario.equals("") || Estatica.novaSenha.equals("") || Estatica.confirmaSenha.equals("")) {
			
			erroUsuario = 1;
			EST.mensagemErro = "Não deixe nenhum campo em branco";
			
			IG_Erros IE = new IG_Erros();
				IE.setVisible(true);
			
		}
		
		//Erro 2 - ID já cadastrado
		for(MO_Usuarios MOU : MO_Usuarios.dados) {
			if(Estatica.novoUsuario.equals(MOU.getUsuario())) {
				
				erroUsuario = 2;
				EST.mensagemErro = "ID já cadastrada";
				
				IG_Erros IE = new IG_Erros();
				IE.setVisible(true);
			}
		}
		
		//Erro 3 - Senhas não coincidem
		if(!Estatica.novaSenha.equals(Estatica.confirmaSenha)) {
			
			erroUsuario = 3;
			EST.mensagemErro = "As senhas não coincidem";
					
			IG_Erros IE = new IG_Erros();
			IE.setVisible(true);
		}
		
		//0 - Indo para o próximo JFrame
		if(erroUsuario == 0) {
			
			//Abrindo o JFrame [Pessoal]
			IG_Pessoal IGP = new IG_Pessoal();
			IGP.setVisible(true);
		}
		
	}
	
	
	//Método - Validar dados [JFrame Dados Pessoais]
	public void verificaPessoal(boolean termoSelecionado) {
		
		//Instanciando [Package: modelo / Classe: Estatica]
		Estatica EST = new Estatica();
				
		//Variaveis
		erroPessoal = 0;
		
		//0 = Sem erros
		//Erro 1 = Campos em branco
		//Erro 2 = Caixa não selecionada
	
		//Erro 1 - Campos em branco
		if(Estatica.novoNome.equals("") || Estatica.novoSobrenome.equals("") || Estatica.novaDatanascimento.equals("") || Estatica.novoEmail.equals("")) {
			erroPessoal = 1;
			EST.mensagemErro = "Não deixe nenhum campo em branco";
			
			IG_Erros IE = new IG_Erros();
			IE.setVisible(true);
			
		}
		
		//Erro 2 - Caixa não selecionada
		if(termoSelecionado == false) {
			erroPessoal = 2;
			EST.mensagemErro ="Marque a caixa do termo que você não leu";
			
			IG_Erros IE = new IG_Erros();
			IE.setVisible(true);
		}
		
		//0 - Cadastrando, gerando a chave e indo para o proximo JFrame
		if(erroPessoal == 0) {
			cadastrar();
			
			chaveRecuperacao();
			
			IG_Dados IGD = new IG_Dados();
			IGD.setVisible(true);
		}
	}
	
	//Método - Gerar chave de recuperação
	public void chaveRecuperacao() {
		
		//Variaveis
		String chaveRecuperacao = "";
		
		//Gerador randomico
		Random gerador = new Random();
		
		//Usando o for para gerar
		for(int gera = 0 ; gera < 7 ; gera++) {
		
			chaveRecuperacao+= gerador.nextInt(10);
			
		}
		
		Estatica.chaveRecuperacao = chaveRecuperacao;
		
	}
	
	//Método para cadastrar [Está sendo usado na variavel anterior]
	public void cadastrar() {
		
		//Instanciando [Package: modelo / Classe: MO_Usuarios]
		MO_Usuarios MOU = new MO_Usuarios();
		
		
		  //Atribuindo valores das variaveis estaticas, para os método magicos
		  MOU.setUsuario(Estatica.novoUsuario);
		  MOU.setSenha(Estatica.novaSenha);
		  MOU.setNome(Estatica.novoNome);
		  MOU.setSobrenome(Estatica.novoSobrenome);
		  MOU.setDataNascimento(Estatica.novaDatanascimento);
		  MOU.setEmail(Estatica.novoEmail);
		  MOU.setPoderAcesso(2);
		  MOU.setChaveRecuperacao(Estatica.chaveRecuperacao);
		  
		  System.out.println(MOU);
		  
		  //Adicionar ao vetor
		  MO_Usuarios.dados.add(MOU);

	}
	
	}

