package codigo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaceGrafica.IG_Cadastrar_Pessoal;
import interfaceGrafica.IG_Erros;
import modelo.Estatica;

public class CO_Usuarios {

	
	//M�todo - Verificar ID [Bot�o]
	public boolean verificaID(String idDisponivel) {
		
		//Condicional [For avan�ado]
		for(Usuarios u : dados) {
			if(idDisponivel.equals(u.usuario)) {
				return false;
			}
		}
		//Retornando
		return true;
		
		}
		
	//M�todo - Validar dados [JFrame Usuario]
	public void verificaUsuario() {
		
		//Variaveis
		int erroUsuario = 0;
		
		//0 = Sem erros
		//Erro 1 = Campo em branco
		//Erro 2 = ID j� cadastrado
		//Erro 3 = As senhas n�o coincidem
		
		//Erro 1 - Campo em branco
		if(Estatica.novoUsuario("") || senha.equals("") || confirmaSenha.equals("")) {
			erroUsuario = 1;
			Acao.mensagemErro = "N�o deixe nenhum campo em branco";
			
			IG_Erros IE = new IG_Erros();
				IE.setVisible(true);
			
		}
		
		//Erro 2 - ID j� cadastrado
		for(Usuarios u : dados) {
			if(usuario.equals(u.usuario)) {
				erroUsuario = 2;
				Acao.mensagemErro = "ID j� cadastrada";
				
				IG_Erros IE = new IG_Erros();
				IE.setVisible(true);
			}
		}
		
		//Erro 3 - Senhas n�o coincidem
		if(!senha.equals(confirmaSenha)) {
			erroUsuario = 3;
			Acao.mensagemErro = "As senhas n�o coincidem";
					
			IG_Erros IE = new IG_Erros();
			IE.setVisible(true);
		}
		
		//0 - Indo para o pr�ximo JFrame
		if(erroUsuario == 0) {
			IG_Cadastrar_Pessoal ICP = new IG_Cadastrar_Pessoal();
			
			ICP.setVisible(true);
		}
	}
	
	//M�todo - Validar dados [JFrame Dados Pessoais]
	public void verificaPessoal(boolean termoSelecionado) {
		
		//Variaveis
		int erroPessoal = 0;
		
		//0 = Sem erros
		//Erro 1 = Campos em branco
		//Erro 2 = Caixa n�o selecionada
	
		//Erro 1 - Campos em branco
		if(nome.equals("") || sobrenome.equals("") || dataNascimento.equals("") || email.equals("")) {
			erroPessoal = 1;
			Acao.mensagemErro = "N�o deixe nenhum campo em branco";
			
			IG_Erros IE = new IG_Erros();
			IE.setVisible(true);
			
		}
		
		//Erro 2 - Caixa n�o selecionada
		if(termoSelecionado == false) {
			erroPessoal = 2;
			Acao.mensagemErro ="Marque a caixa do termo que voc� n�o leu";
			
			IG_Erros IE = new IG_Erros();
			IE.setVisible(true);
		}
		
		//0 - Cadastrando e indo para o proximo JFrame
		if(erroPessoal == 0) {
			cadastrar();
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
		}
	}
	
	//M�todo para cadastrar
	public void cadastrar() {
		u.add(set)
		dados.add(this);
	}
	
	}

