package codigo;

import javax.swing.JOptionPane;

import interfaceGrafica.IG_Erros;
import interfaceGrafica.IG_Pessoal;
import interfaceGrafica.IG_Usuario;
import modelo.Estatica;
import modelo.MO_Usuarios;

public class CO_Cadastro {

	
	//M�todo - Verificar ID [Bot�o]
	public boolean verificaID(String idDisponivel) {
		
		//Condicional [For avan�ado]
		for(MO_Usuarios MOU : MO_Usuarios.dados) {
			if(idDisponivel.equals(MOU.getUsuario())) {
				return false;
			}
		}
		//Retornando
		return true;
		
		}
	
		
	//M�todo - Validar dados [JFrame Usuario]
	public void verificaUsuario() {
		
		//Instanciando [Package: modelo / Classe: Estatica]
		Estatica EST = new Estatica();
		
		//Variaveis
		int erroUsuario = 0;
		
		//0 = Sem erros
		//Erro 1 = Campo em branco
		//Erro 2 = ID j� cadastrado
		//Erro 3 = As senhas n�o coincidem
		
		//Erro 1 - Campo em branco
		if(Estatica.novoUsuario.equals("") || Estatica.novaSenha.equals("") || Estatica.confirmaSenha.equals("")) {
			
			erroUsuario = 1;
			EST.mensagemErro = "N�o deixe nenhum campo em branco";
			
			IG_Erros IE = new IG_Erros();
				IE.setVisible(true);
			
		}
		
		//Erro 2 - ID j� cadastrado
		for(MO_Usuarios MOU : MO_Usuarios.dados) {
			if(Estatica.novoUsuario.equals(MOU.getUsuario())) {
				
				erroUsuario = 2;
				EST.mensagemErro = "ID j� cadastrada";
				
				IG_Erros IE = new IG_Erros();
				IE.setVisible(true);
			}
		}
		
		//Erro 3 - Senhas n�o coincidem
		if(!Estatica.novaSenha.equals(Estatica.confirmaSenha)) {
			
			erroUsuario = 3;
			EST.mensagemErro = "As senhas n�o coincidem";
					
			IG_Erros IE = new IG_Erros();
			IE.setVisible(true);
		}
		
		//0 - Indo para o pr�ximo JFrame
		if(erroUsuario == 0) {
			
			//Fechando o JFrame [Usuario]
			IG_Usuario IGU = new IG_Usuario();
			IGU.dispose();
			
			//Abrindo o JFrame [Pessoal]
			IG_Pessoal IGP = new IG_Pessoal();
			IGP.setVisible(true);
		}
		
	}
	
	
	//M�todo - Validar dados [JFrame Dados Pessoais]
	public void verificaPessoal(boolean termoSelecionado) {
		
		//Instanciando [Package: modelo / Classe: Estatica]
		Estatica EST = new Estatica();
				
		//Variaveis
		int erroPessoal = 0;
		
		//0 = Sem erros
		//Erro 1 = Campos em branco
		//Erro 2 = Caixa n�o selecionada
	
		//Erro 1 - Campos em branco
		if(Estatica.novoNome.equals("") || Estatica.novoSobrenome.equals("") || Estatica.novaDatanascimento.equals("") || Estatica.novoEmail.equals("")) {
			erroPessoal = 1;
			EST.mensagemErro = "N�o deixe nenhum campo em branco";
			
			IG_Erros IE = new IG_Erros();
			IE.setVisible(true);
			
		}
		
		//Erro 2 - Caixa n�o selecionada
		if(termoSelecionado == false) {
			erroPessoal = 2;
			EST.mensagemErro ="Marque a caixa do termo que voc� n�o leu";
			
			IG_Erros IE = new IG_Erros();
			IE.setVisible(true);
		}
		
		//0 - Cadastrando e indo para o proximo JFrame
		if(erroPessoal == 0) {
			cadastrar();
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
		}
	}
	
	//M�todo para cadastrar [Est� sendo usado na variavel anterior]
	public void cadastrar() {
		
		//Instanciando [Package: modelo / Classe: MO_Usuarios]
		MO_Usuarios MOU = new MO_Usuarios();
		
		
		  //Atribuindo valores das variaveis estaticas, para os m�todo magicos
		  MOU.setUsuario(Estatica.novoUsuario);
		  MOU.setSenha(Estatica.novaSenha);
		  MOU.setNome(Estatica.novoNome);
		  MOU.setSobrenome(Estatica.novoSobrenome);
		  MOU.setDataNascimento(Estatica.novaDatanascimento);
		  MOU.setEmail(Estatica.novoEmail);
		  MOU.setPoderAcesso(2);
		  
		  System.out.println(MOU);
		  
		  //Adicionar ao vetor
		  MO_Usuarios.dados.add(MOU);

	}
	
	}

