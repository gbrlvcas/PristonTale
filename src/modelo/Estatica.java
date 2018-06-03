package modelo;

public class Estatica {

	
	/*
	 * Aqui está todas as variaveis que serão usadas para validação
	 * e por fim os dados da mesma serão passadas para os metodos
	 * mágicos para que possam serem cadastradas
	 */
	
	//Variaveis para todas classes
	public static String mensagemErro = "";
	public static String confirmaSenha;
	public static String usuarioLogado;
	
	//Variaveis [JFrame - Login]
	public static int erroLogin = 0;
	
	//Variaveis [JFrame - Cadastro - Usuario]
	public static int erroUsuario = 0;
	public static String novoUsuario;
	public static String novaSenha;


	//Variaveis [JFrame - Cadastro - Pessoal]
	public static int erroPessoal = 0;
	public static String novoNome;
	public static String novoSobrenome;
	public static String novaDatanascimento;
	public static String novoEmail;
	
	//Variaveis [JFrame - Cadastro - Dados]
	public static int mostrarDados = 0;

	
	//Variavel [Chave recuperação]
	public static String chaveRecuperacao;
	
	//Variaveis [JFrame - Recuperar senha]
	public static int erroRecuperar;
	public static String verificaUsuario;
	public static String verificaChave;
	public static String alterarSenha;
	
	//Variaveis [JFrame - Player - Personagem]
	public static String msgBoasVindas;
	
	

	
}
