package codigo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaceGrafica.IG_Cadastrar_Pessoal;
import interfaceGrafica.IG_Erros;
import modelo.Estatica;

public class CO_Usuarios {

	
	//Método - Verificar ID [Botão]
	public boolean verificaID(String idDisponivel) {
		
		//Condicional [For avançado]
		for(Usuarios u : dados) {
			if(idDisponivel.equals(u.usuario)) {
				return false;
			}
		}
		//Retornando
		return true;
		
		}
		
	//Método - Validar dados [JFrame Usuario]
	public void verificaUsuario() {
		
		//Variaveis
		int erroUsuario = 0;
		
		//0 = Sem erros
		//Erro 1 = Campo em branco
		//Erro 2 = ID já cadastrado
		//Erro 3 = As senhas não coincidem
		
		//Erro 1 - Campo em branco
		if(Estatica.novoUsuario("") || senha.equals("") || confirmaSenha.equals("")) {
			erroUsuario = 1;
			Acao.mensagemErro = "Não deixe nenhum campo em branco";
			
			IG_Erros IE = new IG_Erros();
				IE.setVisible(true);
			
		}
		
		//Erro 2 - ID já cadastrado
		for(Usuarios u : dados) {
			if(usuario.equals(u.usuario)) {
				erroUsuario = 2;
				Acao.mensagemErro = "ID já cadastrada";
				
				IG_Erros IE = new IG_Erros();
				IE.setVisible(true);
			}
		}
		
		//Erro 3 - Senhas não coincidem
		if(!senha.equals(confirmaSenha)) {
			erroUsuario = 3;
			Acao.mensagemErro = "As senhas não coincidem";
					
			IG_Erros IE = new IG_Erros();
			IE.setVisible(true);
		}
		
		//0 - Indo para o próximo JFrame
		if(erroUsuario == 0) {
			IG_Cadastrar_Pessoal ICP = new IG_Cadastrar_Pessoal();
			
			ICP.setVisible(true);
		}
	}
	
	//Método - Validar dados [JFrame Dados Pessoais]
	public void verificaPessoal(boolean termoSelecionado) {
		
		//Variaveis
		int erroPessoal = 0;
		
		//0 = Sem erros
		//Erro 1 = Campos em branco
		//Erro 2 = Caixa não selecionada
	
		//Erro 1 - Campos em branco
		if(nome.equals("") || sobrenome.equals("") || dataNascimento.equals("") || email.equals("")) {
			erroPessoal = 1;
			Acao.mensagemErro = "Não deixe nenhum campo em branco";
			
			IG_Erros IE = new IG_Erros();
			IE.setVisible(true);
			
		}
		
		//Erro 2 - Caixa não selecionada
		if(termoSelecionado == false) {
			erroPessoal = 2;
			Acao.mensagemErro ="Marque a caixa do termo que você não leu";
			
			IG_Erros IE = new IG_Erros();
			IE.setVisible(true);
		}
		
		//0 - Cadastrando e indo para o proximo JFrame
		if(erroPessoal == 0) {
			cadastrar();
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
		}
	}
	
	//Método para cadastrar
	public void cadastrar() {
		u.add(set)
		dados.add(this);
	}
	
	}

