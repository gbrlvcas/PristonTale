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
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import codigo.CO_Cadastro;
import codigo.CO_RecuperarSenha;
import modelo.Estatica;

public class IG_RecuperarSenha extends JFrame {

	private JPanel pnlCadastro;
	private JTextField txtLogin;
	private JTextField txtChaveRecuperacao;
	private JPasswordField txtConfirmaSenha;
	public static String novoUsuario;
	public static String novaSenha;
	public static String confirmaSenha;
	private JPasswordField txtNovaSenha;
	
	//JFrame - Janela do cadastro =========================================================================================================
	
	public IG_RecuperarSenha() {
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
		
		
		//Cabeçalho
		JLabel lblCabecalho = new JLabel("");
		lblCabecalho.setIcon(new ImageIcon(getClass().getResource("/BG_RecuperarSenha.jpg")));
		lblCabecalho.setBounds(0, 0, 450, 126);
		pnlCadastro.add(lblCabecalho);
				
			
//Componentes =======================================================================================================================
		

		//Informações sobre os campos abaixo [Cadastro dos dados da conta]
		JLabel lblDadosConta = new JLabel("Altere a sua senha no Priston Tale\r\n");
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
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtLogin.setBounds(190, 178, 200, 24);
		pnlCadastro.add(txtLogin);
		txtLogin.setColumns(10);
		
		
		//Nova Senha
		JLabel lblChaveRecuperacao = new JLabel("Chave de Recupera\u00E7\u00E3o:");
		lblChaveRecuperacao.setBounds(20, 205, 162, 24);
		lblChaveRecuperacao.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlCadastro.add(lblChaveRecuperacao);
		
		txtChaveRecuperacao = new JTextField();
		txtChaveRecuperacao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtChaveRecuperacao.setBounds(190, 205, 200, 24);
		txtChaveRecuperacao.setColumns(10);
		pnlCadastro.add(txtChaveRecuperacao);
		
		
		//Label com imagem [Certo e Errado]
		JLabel lblMostrarDisponibilidade = new JLabel("");
		lblMostrarDisponibilidade.setBounds(394, 208, 20, 20);
		pnlCadastro.add(lblMostrarDisponibilidade);
		
		JButton btnVerificarChave = new JButton("Verificar chave");
		btnVerificarChave.setForeground(Color.WHITE);
		btnVerificarChave.setBackground(Color.DARK_GRAY);
		btnVerificarChave.setBounds(190, 233, 200, 20);
		pnlCadastro.add(btnVerificarChave);
		
		//Função botão [Verificar]
		btnVerificarChave.addMouseListener(new MouseAdapter() {
			@Override
			
			//Ação botão [Clique / Verificar Chave]
			public void mouseClicked(MouseEvent arg0) {
				
				//Capturando os dados
				String usuarioVerifica = txtLogin.getText().toString();
				String chaveVerifica = txtChaveRecuperacao.getText().toString();
				
				//Instanciando [Package: codigo / Classe: CO_RecuperarSenha]
				CO_RecuperarSenha COR = new CO_RecuperarSenha();
				COR.verificaChave(usuarioVerifica, chaveVerifica);
				
				//Condicional [Pegar o resultado o método acima e validar]
				if(COR.verificaChave(usuarioVerifica, chaveVerifica) == true) {
					
					lblMostrarDisponibilidade.setIcon(new ImageIcon(getClass().getResource("/ICN_Positivo.png")));
					
				}else {
					
					lblMostrarDisponibilidade.setIcon(new ImageIcon(getClass().getResource("/ICN_Negativo.png")));
					
					}
			}
		});
		
		
		

		//Linha separadora
		JSeparator spdDados = new JSeparator();
		spdDados.setBounds(10, 263, 430, 2);
		pnlCadastro.add(spdDados);
		
		JLabel lblNovaSenha = new JLabel("Nova Senha:");
		lblNovaSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNovaSenha.setBounds(20, 280, 120, 24);
		pnlCadastro.add(lblNovaSenha);
		
		txtNovaSenha = new JPasswordField();
		txtNovaSenha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtNovaSenha.setColumns(10);
		txtNovaSenha.setBounds(190, 280, 200, 24);
		pnlCadastro.add(txtNovaSenha);
		
		
		//Confirmar nova senha
		JLabel lblConfirmaSenha = new JLabel("Confirma Senha:");
		lblConfirmaSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConfirmaSenha.setBounds(20, 316, 120, 24);
		pnlCadastro.add(lblConfirmaSenha);
		
		txtConfirmaSenha = new JPasswordField();
		txtConfirmaSenha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtConfirmaSenha.setColumns(10);
		txtConfirmaSenha.setBounds(190, 316, 200, 24);
		pnlCadastro.add(txtConfirmaSenha);
		
		
		//Linha Separadora
		JSeparator spdNovosDados = new JSeparator();
		spdNovosDados.setBounds(10, 356, 430, 2);
		pnlCadastro.add(spdNovosDados);
		
		
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
		
			//Botão [Alterar senha]
			JButton btnAlterarSenha = IG_Erros IGE = new IG_Erros();
			IGE.setVisible(true);new JButton("Alterar Senha");
			btnAlterarSenha.setForeground(Color.WHITE);
			btnAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnAlterarSenha.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			btnAlterarSenha.setBackground(Color.DARK_GRAY);
			btnAlterarSenha.setBounds(257, 399, 133, 35);
			pnlCadastro.add(btnAlterarSenha);
			
				//Ação do botão [Prosseguir]
				btnAlterarSenha.addMouseListener(new MouseAdapter() {
					
					//Função botão [Clique / Sair]
					@Override
					public void mouseClicked(MouseEvent e) {
					
					//Pegar os dados digitado
					Estatica.verificaUsuario = txtLogin.getText();
					Estatica.verificaChave = txtChaveRecuperacao.getText();
					Estatica.alterarSenha = new String(txtNovaSenha.getPassword());
					Estatica.confirmaSenha = new String(txtConfirmaSenha.getPassword());
					
					//Instanciando [Package: codigo / Classe: CO_RecuperarSenha]
					CO_RecuperarSenha COR = new CO_RecuperarSenha();
					COR.alterarSenha();
					
					
					
						
					}
					
					//Função Botão [Passar por cima / Mudar cor]
					@Override
					public void mouseEntered(MouseEvent e) {
						btnAlterarSenha.setBackground(Color.WHITE);
						btnAlterarSenha.setForeground(Color.DARK_GRAY);
						
					}
					
					//Função Botão [Sair de cima / Mudar cor]
					@Override
					public void mouseExited(MouseEvent e) {
						btnAlterarSenha.setBackground(Color.DARK_GRAY);
						btnAlterarSenha.setForeground(Color.WHITE);
						
					}
				});


		
	}
}
