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

public class IG_Dados_RecuperarSenha extends JFrame {

	private JPanel pnlCadastro;
	public static String novoUsuario;
	public static String novaSenha;
	public static String confirmaSenha;
	
	//JFrame - Janela do cadastro =========================================================================================================
	
	public IG_Dados_RecuperarSenha() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 368);
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
		
		JLabel lblSenhaAlteraCom = new JLabel("Senha alterada com sucesso!");
		lblSenhaAlteraCom.setForeground(new Color(34, 139, 34));
		lblSenhaAlteraCom.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenhaAlteraCom.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenhaAlteraCom.setBounds(15, 178, 420, 20);
		pnlCadastro.add(lblSenhaAlteraCom);
		
		
		//Novo Usuario 
		JLabel lblNovoLogin = new JLabel("Login:");
		lblNovoLogin.setBounds(20, 214, 48, 24);
		lblNovoLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlCadastro.add(lblNovoLogin);
		
		JLabel lblUsuario = new JLabel(Estatica.verificaUsuario);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(183, 214, 227, 24);
		pnlCadastro.add(lblUsuario);
		
		JLabel lblNovaSenha = new JLabel("Nova Senha:");
		lblNovaSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNovaSenha.setBounds(20, 254, 120, 24);
		pnlCadastro.add(lblNovaSenha);
			
		JLabel lblSenhaAlterada = new JLabel(Estatica.alterarSenha);
		lblSenhaAlterada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenhaAlterada.setBounds(183, 254, 227, 24);
		pnlCadastro.add(lblSenhaAlterada);
			
			
			

			//Linha separadora
			JSeparator spdDados = new JSeparator();
			spdDados.setBounds(10, 301, 430, 2);
			pnlCadastro.add(spdDados);
		
			//Botão [Confirmar]
			JButton btnConfirmar = new JButton("Voltar Login");
			btnConfirmar.setForeground(Color.WHITE);
			btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnConfirmar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			btnConfirmar.setBackground(Color.DARK_GRAY);
			btnConfirmar.setBounds(157, 319, 133, 35);
			pnlCadastro.add(btnConfirmar);
			
				//Ação do botão [Confirmar]
				btnConfirmar.addMouseListener(new MouseAdapter() {
					
					//Função botão [Clique / Sair]
					@Override
					public void mouseClicked(MouseEvent e) {
					
					dispose();
					IG_Login IGL = new IG_Login();
					IGL.setVisible(true);
					
						
					}
					
					//Função Botão [Passar por cima / Mudar cor]
					@Override
					public void mouseEntered(MouseEvent e) {
						btnConfirmar.setBackground(Color.WHITE);
						btnConfirmar.setForeground(Color.DARK_GRAY);
						
					}
					
					//Função Botão [Sair de cima / Mudar cor]
					@Override
					public void mouseExited(MouseEvent e) {
						btnConfirmar.setBackground(Color.DARK_GRAY);
						btnConfirmar.setForeground(Color.WHITE);
						
					}
				});


		
	}
}
