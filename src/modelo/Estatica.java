package modelo;

public class Estatica {

	
	/*
	 * Aqui est� todas as variaveis que ser�o usadas para valida��o
	 * e por fim os dados da mesma ser�o passadas para os metodos
	 * m�gicos para que possam serem cadastradas
	 */
	
	//Variaveis para todas classes
	public static String mensagemErro = "";
	public static String confirmaSenha;
	
	//Variaveis [JFrame - Login]
	public static int erroLogin = 0;
	
	//Variaveis [JFrame - Cadastro Usuario]
	public static int erroUsuario = 0;
	public static String novoUsuario;
	public static String novaSenha;


	//Variaveis [JFrame - Cadastro pessoal]
	public static int erroPessoal = 0;
	public static String novoNome;
	public static String novoSobrenome;
	public static String novaDatanascimento;
	public static String novoEmail;
	
	//Variavel [Chave recupera��o]
	public static String chaveRecuperacao;
	
	//Variaveis [JFrame - Recuperar senha]
	public static int erroRecuperar;
	public static String verificaUsuario;
	public static String verificaChave;
	public static String alterarSenha;
	

	
}
