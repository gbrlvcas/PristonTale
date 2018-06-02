package interfaceGrafica;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import codigo.CO_Login;
import modelo.Estatica;
import modelo.MO_Usuarios;


public class IG_Login extends JFrame {

	private JPanel pnlLogin;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

//JFrame - Janela do login =========================================================================================================
	
	public IG_Login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 300);
		pnlLogin = new JPanel();
		pnlLogin.setBounds(new Rectangle(0, 0, 400, 300));
		pnlLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(pnlLogin);
		pnlLogin.setLayout(null);
		
//Imagem do cursor ==================================================================================================================
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Image image = toolkit.getImage(getClass().getResource("/PT_Mouse.png"));
	    Point hotspot = new Point(0,0);
		Cursor cursor = toolkit.createCustomCursor(image, hotspot, "PT_Mouse");
		setCursor(cursor);
		
	
//Componentes =======================================================================================================================
		
		//Instanciando [Classe: Acao]
		CO_Login a = new CO_Login();
			
			//Instanciando [Classe: Acao / Método: usuarioADM]
			if(MO_Usuarios.dados.isEmpty()) {
				a.usuarioADM();
		
		}
			
		
		//Login
		JLabel lblLogin = new JLabel("USUARIO");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogin.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblLogin.setOpaque(true);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogin.setBounds(159, 74, 85, 28);
		pnlLogin.add(lblLogin);
		
		txtUsuario = new JTextField();
		txtUsuario.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtUsuario.setBounds(126, 109, 150, 25);
		pnlLogin.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		//Senha
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSenha.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblSenha.setOpaque(true);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenha.setBounds(168, 145, 67, 28);
		pnlLogin.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtSenha.setBounds(126, 180, 150, 25);
		pnlLogin.add(txtSenha);
		
		
		//Botão [Login]
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(Color.DARK_GRAY);
		btnLogin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLogin.setBounds(155, 231, 93, 36);
		pnlLogin.add(btnLogin);
		
		//Ação do botão [Login]
		btnLogin.addMouseListener(new MouseAdapter() {
			
			//Função botão [Clique / Logar]
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Pegar os dados digitados
				String usuario = txtUsuario.getText().toString();
				String senha = new String(txtSenha.getPassword());
				
				//Instanciando [Package: codigo / Classe: Acao / Método: validaUsuario]
				a.validaLogin(usuario, senha);
				

				
				//Condicional
				if(Estatica.erroLogin == 1) {
					
					//Instanciando [Classe:IG_Erros]
					IG_Erros erros = new IG_Erros();
					erros.setVisible(true);
					
					}

				}
			
				//Função Botão [Passar por cima / Mudar cor]
				@Override
				public void mouseEntered(MouseEvent e) {
					btnLogin.setBackground(Color.WHITE);
					btnLogin.setForeground(Color.DARK_GRAY);
					
				}
				
				//Função Botão [Sair de cima / Mudar cor]
				@Override
				public void mouseExited(MouseEvent e) {
					btnLogin.setBackground(Color.DARK_GRAY);
					btnLogin.setForeground(Color.WHITE);
					
				}
				
				
			
		});
				
		
		//Botão [Sair]
		JButton btnSair = new JButton("SAIR");
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSair.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSair.setBackground(Color.DARK_GRAY);
		btnSair.setBounds(324, 11, 67, 28);
		pnlLogin.add(btnSair);
		
		//Ação do botão [Sair]
		btnSair.addMouseListener(new MouseAdapter() {
			
			//Função Botão [Clique / Sair]
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
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
		
		
		//Informação sobre a versão atual do sistema
		JLabel lblVerso = new JLabel("Vers\u00E3o 1.7");
		lblVerso.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVerso.setBounds(173, 286, 57, 14);
		pnlLogin.add(lblVerso);
		
		//JLabel [Cadastrar nova conta]
		JLabel lblNovoUsuario = new JLabel("Criar conta");
		lblNovoUsuario.setForeground(Color.WHITE);
		lblNovoUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNovoUsuario.setBounds(29, 264, 77, 18);
		pnlLogin.add(lblNovoUsuario);
		
		//Função Label [Clique / Cadastrar] 
		lblNovoUsuario.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//Instanciando [Classe: IG_Cadastrar]
				IG_Usuario IGU = new IG_Usuario();
				IGU.setVisible(true);
				dispose();
			
			}
			
			//Função Botão [Passar por cima / Aumentar fonte]
			@Override
			public void mouseEntered(MouseEvent arg0) {
			lblNovoUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
			
			}
			
			//Função Botão [Sair de cima / Diminuir fonte]
			@Override
			public void mouseExited(MouseEvent arg0) {
			lblNovoUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
		});
		
		
		//JLabel [Recuperar senha]
		JLabel lblRecuperarSenha = new JLabel("Esqueci a senha");
		lblRecuperarSenha.setForeground(Color.WHITE);
		lblRecuperarSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRecuperarSenha.setBounds(268, 264, 112, 18);
		pnlLogin.add(lblRecuperarSenha);
		
		//Ação do botão [Recuperar senha]
		lblRecuperarSenha.addMouseListener(new MouseAdapter() {
			
			//Função Label [Clique / Cadastrar]
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//Instanciando [Classe: IG_Cadastrar]
				IG_RecuperarSenha IGR = new IG_RecuperarSenha();
				IGR.setVisible(true);
				
			
			}
			
			
			//Função Botão [Passar por cima / Aumentar fonte]
			@Override
			public void mouseEntered(MouseEvent arg0) {
			lblRecuperarSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
			
			}
			
			//Função Botão [Sair de cima / Diminuir fonte]
			@Override
			public void mouseExited(MouseEvent arg0) {
			lblRecuperarSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
			}
			
		});
		
		//Background
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(getClass().getResource("/BG_Login.jpg")));
		lblBackground.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblBackground.setBounds(0, 0, 400, 300);
		lblBackground.setCursor(cursor);
		pnlLogin.add(lblBackground);
		
		
	    
	}
}
