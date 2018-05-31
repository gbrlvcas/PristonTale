package interfaceGrafica;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import codigo.Acao;
import codigo.Usuarios;
import javax.swing.JPasswordField;

public class IG_Cadastrar_Usuario extends JFrame {

	private JPanel pnlCadastro;
	private JTextField txtNovoLogin;
	private JPasswordField txtNovaSenha;
	private JPasswordField txtConfirmaSenha;

	//JFrame - Janela do cadastro =========================================================================================================
	
	public IG_Cadastrar_Usuario() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		pnlCadastro = new JPanel();
		pnlCadastro.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlCadastro);
		setLocationRelativeTo(null);
		pnlCadastro.setLayout(null);
		
//Imagem do cursor ==================================================================================================================
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(getClass().getResource("/PT_Mouse.png"));
		Point hotspot = new Point(0,0);
	    Cursor cursor = toolkit.createCustomCursor(image, hotspot, "PT_Mouse");
		setCursor(cursor);
				
			
//Componentes =======================================================================================================================
		
		//Informações sobre os campos abaixo [Cadastro dos dados da conta]
		JLabel lblDadosConta = new JLabel("Criando nova conta no Priston Tale");
		lblDadosConta.setBounds(10, 131, 430, 24);
		lblDadosConta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDadosConta.setForeground(Color.WHITE);
		lblDadosConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosConta.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblDadosConta.setOpaque(true);
		lblDadosConta.setBackground(Color.DARK_GRAY);
		pnlCadastro.add(lblDadosConta);
		
		
		//Novo Usuario 
		JLabel lblNovoLogin = new JLabel("Login:");
		lblNovoLogin.setBounds(20, 176, 48, 24);
		lblNovoLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlCadastro.add(lblNovoLogin);
		
		txtNovoLogin = new JTextField();
		txtNovoLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtNovoLogin.setBounds(166, 178, 200, 24);
		pnlCadastro.add(txtNovoLogin);
		txtNovoLogin.setColumns(10);
		
		
		//Label com imagem [Certo e Errado]
		JLabel lblMostrarDisponibilidade = new JLabel("");
		lblMostrarDisponibilidade.setBounds(371, 178, 20, 20);
		pnlCadastro.add(lblMostrarDisponibilidade);

		
		//Botão [Verificar ID]
		JButton btnVerificar = new JButton("Verificar ID");
		btnVerificar.setBackground(Color.DARK_GRAY);
		btnVerificar.setForeground(Color.WHITE);
		btnVerificar.setBounds(166, 203, 200, 20);
		pnlCadastro.add(btnVerificar);
		
		//Ação do botão [Verificar]
		btnVerificar.addMouseListener(new MouseAdapter() {
			
			//Função do botão [Clique / Verificar ID]
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			//Analisar disponibilidade [Exibe imagem correspondente ao resultado]
			String idDisponibilidade = txtNovoLogin.getText().toString().toLowerCase();
					
				for(int analisa = 0 ; analisa < Usuarios.dados.size() ; analisa++) {
					System.out.println(Usuarios.dados.get(analisa).getUsuario());
					if(idDisponibilidade.equals(Usuarios.dados.get(analisa).getUsuario())) {
						
						lblMostrarDisponibilidade.setIcon(new ImageIcon(getClass().getResource("/ICN_Erro.png")));
						
					}else {
						
						lblMostrarDisponibilidade.setIcon(new ImageIcon(getClass().getResource("/ICN_Correto.png")));
						
						}
					
					}
			}
			
				//Função Botão [Passar por cima / Mudar cor]
				@Override
				public void mouseEntered(MouseEvent e) {
					btnVerificar.setBackground(Color.WHITE);
					btnVerificar.setForeground(Color.DARK_GRAY);
					
				}
				
				//Função Botão [Sair de cima / Mudar cor]
				@Override
				public void mouseExited(MouseEvent e) {
					btnVerificar.setBackground(Color.DARK_GRAY);
					btnVerificar.setForeground(Color.WHITE);
					
				}
		});
		

		//Linha separadora
		JSeparator spdLogin = new JSeparator();
		spdLogin.setBounds(10, 234, 430, 2);
		pnlCadastro.add(spdLogin);
		
		
		//Nova Senha
		JLabel lblNovaSenha = new JLabel("Senha:");
		lblNovaSenha.setBounds(20, 265, 48, 24);
		lblNovaSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlCadastro.add(lblNovaSenha);
		
		txtNovaSenha = new JPasswordField();
		txtNovaSenha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtNovaSenha.setBounds(166, 265, 200, 24);
		txtNovaSenha.setColumns(10);
		pnlCadastro.add(txtNovaSenha);
		
		
		//Linha Separadora
		JSeparator spdSenha = new JSeparator();
		spdSenha.setBounds(10, 319, 430, 2);
		pnlCadastro.add(spdSenha);
		
		
		//Confirmar nova senha
		JLabel lblConfirmaSenha = new JLabel("Confirma Senha:");
		lblConfirmaSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConfirmaSenha.setBounds(20, 349, 120, 24);
		pnlCadastro.add(lblConfirmaSenha);
		
		txtConfirmaSenha = new JPasswordField();
		txtConfirmaSenha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtConfirmaSenha.setColumns(10);
		txtConfirmaSenha.setBounds(166, 349, 200, 24);
		pnlCadastro.add(txtConfirmaSenha);
		
		
		//Cabeçalho
		JLabel lblCabecalho = new JLabel("");
		lblCabecalho.setIcon(new ImageIcon(getClass().getResource("/BG_Cadastrar.jpg")));
		lblCabecalho.setBounds(0, 0, 450, 126);
		pnlCadastro.add(lblCabecalho);
		
		
		//Botão [Sair]
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(10, 399, 96, 35);
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSair.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSair.setBackground(Color.DARK_GRAY);
		pnlCadastro.add(btnSair);
		
		//Ação do botão [Sair]
		btnSair.addMouseListener(new MouseAdapter() {
			
			//Função botão [Clique / Sair]
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				IG_Login lgn = new IG_Login();
				lgn.setVisible(true);
			}
			
			//Função Botão [Passar por cima / Mudar cor]
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSair.setBackground(Color.WHITE);
				btnSair.setForeground(Color.DARK_GRAY);
				
			}
			
			//Função Botão [Sair de cima / Mudar cor]
			@Override
			public void mouseExited(MouseEvent e) {
				btnSair.setBackground(Color.DARK_GRAY);
				btnSair.setForeground(Color.WHITE);
				
			}
		});
		
		
		//Botão [Prosseguir com cadastro]
		JButton btnProsseguir = new JButton("Prosseguir >");
		btnProsseguir.setForeground(Color.WHITE);
		btnProsseguir.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnProsseguir.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnProsseguir.setBackground(Color.DARK_GRAY);
		btnProsseguir.setBounds(270, 399, 120, 35);
		pnlCadastro.add(btnProsseguir);


		//Ação do botão [Prosseguir]
		btnProsseguir.addMouseListener(new MouseAdapter() {
			
			//Função botão [Clique / Sair]
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Pegar os dados digitados
				String novoUsuario = txtNovoLogin.getText().toString().toLowerCase();
				String novaSenha = new String(txtNovaSenha.getPassword());
				String confirmaSenha = new String(txtConfirmaSenha.getPassword());			
				
				//Instanciando [Package:Codigo / Classe: Acao]
				Acao a = new Acao();
				a.validarUsuario(novoUsuario, novaSenha, confirmaSenha );
				
				//Condicional
				if(a.erroCadastro == 1 || a.erroCadastro == 2 || a.erroCadastro == 3) {
					
					//Instanciando [Classe:IG_Erros]
					IG_Erros erros = new IG_Erros();
					erros.setVisible(true);
			
				}else if(a.erroCadastro == 0) {
					IG_Cadastrar_Pessoal cadastroP = new IG_Cadastrar_Pessoal();
					cadastroP.setVisible(true);
					dispose();
					
					//Parametrizando as variaveis para cadastra-las
					a.cadastraPlayer(novoUsuario, novaSenha, confirmaSenha, confirmaSenha, confirmaSenha, confirmaSenha, confirmaSenha);
					
				}
				
				
			}
			
			//Função Botão [Passar por cima / Mudar cor]
			@Override
			public void mouseEntered(MouseEvent e) {
				btnProsseguir.setBackground(Color.WHITE);
				btnProsseguir.setForeground(Color.DARK_GRAY);
				
			}
			
			//Função Botão [Sair de cima / Mudar cor]
			@Override
			public void mouseExited(MouseEvent e) {
				btnProsseguir.setBackground(Color.DARK_GRAY);
				btnProsseguir.setForeground(Color.WHITE);
				
			}
		});


		
	}
}
