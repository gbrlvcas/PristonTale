package codigo;

public class Acao {

	
	//Validando os usuarios
	public void validarUsuario() {
		
	//Adicionando o ADM
	Usuarios usu = new Usuarios();
		
		//Criando o usuario ADM
		usu.setUsuario("admin");
		usu.setSenha("admin");
		usu.setPoderAcesso("0");
		
		//Adicionando ao ArrayList
		Usuarios.dados.add(usu);
		
		
	
	}
	
	
	
	
	
	
	
	
}
