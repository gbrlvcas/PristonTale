package codigo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaceGrafica.IG_Cadastrar_Pessoal;
import interfaceGrafica.IG_Erros;

public class Usuarios {

	/*Informações sobre o poder de acesso
	Poder acesso = 0 : ADM
	Poder acesso = 1 : GM
	Poder acesso = 2 : Player
	*/
	
	//Atributos
	private String usuario;
	private String senha;
	private String confirmaSenha;
	private String nome;
	private String sobrenome;
	private String dataNascimento;
	private String email;
	private int poderAcesso;
	private int chaveAcesso;

	
	
	
//Métodos mágicos
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPoderAcesso() {
		return poderAcesso;
	}
	public void setPoderAcesso(int poderAcesso) {
		this.poderAcesso = poderAcesso;
	}
	public int getChaveAcesso() {
		return chaveAcesso;
	}
	public void setChaveAcesso(int chaveAcesso) {
		this.chaveAcesso = chaveAcesso;
	}

	//ArrayList
	public static ArrayList<Usuarios> dados = new ArrayList<>();
	
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
		if(usuario.equals("") || senha.equals("") || confirmaSenha.equals("")) {
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
		dados.add(this);
	}
	
	}

