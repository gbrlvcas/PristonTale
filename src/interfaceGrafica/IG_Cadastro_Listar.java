package interfaceGrafica;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import codigo.CO_Cadastro;
import modelo.Estatica;


public class IG_Cadastro_Listar extends JFrame {

	private JPanel pnlPrincipal;
	
	
	//JFrame - Janela do cadastro =========================================================================================================
	
	public IG_Cadastro_Listar() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 551);
		pnlPrincipal = new JPanel();
		pnlPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlPrincipal);
		setLocationRelativeTo(null);
		pnlPrincipal.setLayout(null);
		
//Imagem do cursor, Background e Painel Principal ==================================================================================================================
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(getClass().getResource("/PT_Mouse.png"));
		Point hotspot = new Point(0,0);
	    Cursor cursor = toolkit.createCustomCursor(image, hotspot, "PT_Mouse");
		setCursor(cursor);

		//Cabeçalho
		JLabel lblCabecalho = new JLabel("");
		lblCabecalho.setIcon(new ImageIcon(getClass().getResource("/BG_Cadastrar.jpg")));
		lblCabecalho.setBounds(0, 0, 450, 126);
		pnlPrincipal.add(lblCabecalho);
						
		//Informações sobre o painel
		JLabel lblInfoDados = new JLabel("Seus dados cadastrados");
		lblInfoDados.setBounds(0, 127, 450, 24);
		pnlPrincipal.add(lblInfoDados);
		lblInfoDados.setOpaque(true);
		lblInfoDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoDados.setForeground(Color.WHITE);
		lblInfoDados.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInfoDados.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblInfoDados.setBackground(Color.DARK_GRAY);
						
		//Informar o ID
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 167, 63, 24);
		pnlPrincipal.add(lblUsuario);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
						
						
		JLabel lblInformaUsuario = new JLabel(Estatica.novoUsuario);
		lblInformaUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInformaUsuario.setBounds(198, 167, 209, 24);
		pnlPrincipal.add(lblInformaUsuario);
		lblInformaUsuario.setText(Estatica.novoUsuario);
						
						
								
		//Informar a senha
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 194, 63, 24);
		pnlPrincipal.add(lblSenha);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
								
		JLabel lblInformaSenha = new JLabel(Estatica.novaSenha);
		lblInformaSenha.setBounds(198, 194, 209, 24);
		pnlPrincipal.add(lblInformaSenha);
		lblInformaSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
								
		//Informar a chave
		JLabel lblChave = new JLabel("Chave de recupera\u00E7\u00E3o:");
		lblChave.setBounds(10, 222, 161, 24);
		pnlPrincipal.add(lblChave);
		lblChave.setFont(new Font("Tahoma", Font.BOLD, 14));
								
		JLabel lblInformaChave = new JLabel(Estatica.chaveRecuperacao);
		lblInformaChave.setBounds(198, 222, 209, 24);
		pnlPrincipal.add(lblInformaChave);
		lblInformaChave.setFont(new Font("Tahoma", Font.BOLD, 14));
								
		//Avisar sobre a chave
		JTextArea txtAvisoChave = new JTextArea();
		txtAvisoChave.setBounds(10, 249, 430, 35);
		pnlPrincipal.add(txtAvisoChave);
		txtAvisoChave.setWrapStyleWord(true);
		txtAvisoChave.setText("Guarde a sua chave de recupera\u00E7\u00E3o em algum local seguro, pois caso esque\u00E7a a senha, precisara desta chave para recupera-la");
		txtAvisoChave.setLineWrap(true);
		txtAvisoChave.setForeground(Color.RED);
		txtAvisoChave.setFont(new Font("Calibri", Font.BOLD, 14));
		txtAvisoChave.setEditable(false);
		txtAvisoChave.setBorder(new LineBorder(UIManager.getColor("CheckBox.shadow")));
								
		//Separador aviso
		JSeparator spdAvisoChave = new JSeparator();
		spdAvisoChave.setBounds(10, 300, 430, 2);
		pnlPrincipal.add(spdAvisoChave);
					
		
		//Informar o nome
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 313, 48, 24);
		pnlPrincipal.add(lblNome);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
								
		JLabel lblInformaNome = new JLabel(Estatica.novoNome);
		lblInformaNome.setBounds(211, 313, 209, 24);
		pnlPrincipal.add(lblInformaNome);
		lblInformaNome.setFont(new Font("Tahoma", Font.BOLD, 14));
					
		
		//Informar o sobrenome
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(10, 342, 86, 24);
		pnlPrincipal.add(lblSobrenome);
		lblSobrenome.setFont(new Font("Tahoma", Font.BOLD, 14));
								
		JLabel lblInformaSobrenome = new JLabel(Estatica.novoSobrenome);
		lblInformaSobrenome.setBounds(211, 342, 209, 24);
		pnlPrincipal.add(lblInformaSobrenome);
		lblInformaSobrenome.setFont(new Font("Tahoma", Font.BOLD, 14));
								
		
		//Informar a data de nascimento
		JLabel lblDatanascimento = new JLabel("Data de Nascimento:");
		lblDatanascimento.setBounds(10, 375, 148, 24);
		pnlPrincipal.add(lblDatanascimento);
		lblDatanascimento.setFont(new Font("Tahoma", Font.BOLD, 14));
								
		JLabel lblInformaDatanascimento = new JLabel(Estatica.novaDatanascimento);
		lblInformaDatanascimento.setBounds(211, 375, 209, 24);
		pnlPrincipal.add(lblInformaDatanascimento);
		lblInformaDatanascimento.setFont(new Font("Tahoma", Font.BOLD, 14));
								
		//Informar o email
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 407, 148, 24);
		pnlPrincipal.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
								
		JLabel lblInformaEmail = new JLabel(Estatica.novoEmail);
		lblInformaEmail.setBounds(211, 407, 209, 24);
		pnlPrincipal.add(lblInformaEmail);
		lblInformaEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
								
		//Botão [Voltar para tela de login]
		JButton btnLogin = new JButton("Voltar Login");
		btnLogin.setBounds(166, 467, 120, 35);
		pnlPrincipal.add(btnLogin);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLogin.setBackground(Color.DARK_GRAY);
						
								
								
		//Ação do botão [Clique / Voltar login]
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				IG_Login IGL = new IG_Login();
				IGL.setVisible(true);
		}
		});
		

	}
}
