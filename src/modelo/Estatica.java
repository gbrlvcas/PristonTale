package modelo;

public class Estatica {

	
	/*
	 * Aqui está todas as variaveis que serão usadas para validação
	 * e por fim os dados da mesma serão passadas para os metodos
	 * mágicos para que possam serem cadastradas
	 */
	
	//Variaveis de verificação de erro
	public static int erroLogin = 0;
	public static String mensagemErro = "";
	
	//Variaveis [JFrame - Cadastro Usuario]
	public static String novoUsuario;
	public static String novaSenha;
	public static String confirmaSenha;
	
	//Variaveis [JFrame - Cadastro pessoal]
	public static String novoNome;
	public static String novoSobrenome;
	public static String novaDatanascimento;
	public static String novoEmail;
}
