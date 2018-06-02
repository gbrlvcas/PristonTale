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
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import codigo.CO_Cadastro;
import modelo.Estatica;
import modelo.MO_Usuarios;

import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class IG_Dados_Cadastro extends JFrame {

	private JPanel pnlCadastro;
	
	//JFrame - Janela do cadastro [Usuario] =========================================================================================================
	
	public IG_Dados_Cadastro() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 519);
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
		lblCabecalho.setIcon(new ImageIcon(getClass().getResource("/BG_Cadastrar.jpg")));
		lblCabecalho.setBounds(0, 0, 450, 126);
		pnlCadastro.add(lblCabecalho);
				
			
//Componentes =======================================================================================================================
		
		//Informações sobre os campos abaixo [Cadastro dos dados pessoais]
		JLabel lblDadosConta = new JLabel("Seus dados cadastrados");
		lblDadosConta.setBounds(10, 131, 430, 24);
		lblDadosConta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDadosConta.setForeground(Color.WHITE);
		lblDadosConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosConta.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblDadosConta.setOpaque(true);
		lblDadosConta.setBackground(Color.DARK_GRAY);
		pnlCadastro.add(lblDadosConta);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(10, 168, 63, 24);
		pnlCadastro.add(lblUsuario);
		
		JLabel lblMostraUsuario = new JLabel(Estatica.novoUsuario);
		lblMostraUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMostraUsuario.setBounds(198, 168, 209, 24);
		pnlCadastro.add(lblMostraUsuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(10, 195, 63, 24);
		pnlCadastro.add(lblSenha);
		
		JLabel lblMostraSenha = new JLabel(Estatica.novaSenha);
		lblMostraSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMostraSenha.setBounds(198, 195, 209, 24);
		pnlCadastro.add(lblMostraSenha);
		
		JLabel lblChaveDeRecuperao = new JLabel("Chave de recupera\u00E7\u00E3o:");
		lblChaveDeRecuperao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChaveDeRecuperao.setBounds(10, 223, 161, 24);
		pnlCadastro.add(lblChaveDeRecuperao);
		
		JLabel lblMostraChave = new JLabel(Estatica.chaveRecuperacao);
		lblMostraChave.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMostraChave.setBounds(198, 223, 209, 24);
		pnlCadastro.add(lblMostraChave);
		
		JTextArea txtrGuardaSuaChave = new JTextArea();
		txtrGuardaSuaChave.setBorder(new LineBorder(UIManager.getColor("CheckBox.shadow")));
		txtrGuardaSuaChave.setWrapStyleWord(true);
		txtrGuardaSuaChave.setEditable(false);
		txtrGuardaSuaChave.setFont(new Font("Calibri", Font.BOLD, 14));
		txtrGuardaSuaChave.setForeground(Color.RED);
		txtrGuardaSuaChave.setLineWrap(true);
		txtrGuardaSuaChave.setText("Guarde a sua chave de recupera\u00E7\u00E3o em algum local seguro, pois caso esque\u00E7a a senha, precisara desta chave para recupera-la");
		txtrGuardaSuaChave.setBounds(10, 250, 430, 35);
		pnlCadastro.add(txtrGuardaSuaChave);
		
		//Linha de separação
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 301, 430, 2);
		pnlCadastro.add(separator);
		
		
		//Nome do usuario
		JLabel lblNomeUsuario = new JLabel("Nome:");
		lblNomeUsuario.setBounds(10, 314, 48, 24);
		lblNomeUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlCadastro.add(lblNomeUsuario);
		
		JLabel lblMostraNome = new JLabel(Estatica.novoNome);
		lblMostraNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMostraNome.setBounds(211, 314, 209, 24);
		pnlCadastro.add(lblMostraNome);
		
		
		//Sobrenome do usuario
		JLabel lblSobrenomeUsuario = new JLabel("Sobrenome:");
		lblSobrenomeUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSobrenomeUsuario.setBounds(10, 343, 86, 24);
		pnlCadastro.add(lblSobrenomeUsuario);
		
		//Formatação do campo Data de nascimento
		MaskFormatter mascaraData = null;
		try {
			
			mascaraData = new MaskFormatter("##/##/####");
			
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "Falha");
		}
		
		JLabel lblMostraSobrenoome = new JLabel(Estatica.novoSobrenome);
		lblMostraSobrenoome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMostraSobrenoome.setBounds(211, 343, 209, 24);
		pnlCadastro.add(lblMostraSobrenoome);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDataDeNascimento.setBounds(10, 376, 148, 24);
		pnlCadastro.add(lblDataDeNascimento);
		
		JLabel lblMostraDataNascimento = new JLabel(Estatica.novaDatanascimento);
		lblMostraDataNascimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMostraDataNascimento.setBounds(211, 376, 209, 24);
		pnlCadastro.add(lblMostraDataNascimento);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(10, 408, 148, 24);
		pnlCadastro.add(lblEmail);
		
		JLabel lblMostraEmail = new JLabel(Estatica.novoEmail);
		lblMostraEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMostraEmail.setBounds(211, 408, 209, 24);
		pnlCadastro.add(lblMostraEmail);
		
		
		//Botão [Voltar para tela de login]
		JButton btnEntendi = new JButton("Voltar Login");
		btnEntendi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEntendi.setForeground(Color.WHITE);
		btnEntendi.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEntendi.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnEntendi.setBackground(Color.DARK_GRAY);
		btnEntendi.setBounds(166, 468, 120, 35);
		pnlCadastro.add(btnEntendi);


		//Ação do botão [Voltar para tela login]
		btnEntendi.addMouseListener(new MouseAdapter() {
			
			//Função botão [Clique / Sair]
			@Override
			public void mouseClicked(MouseEvent e) {
			
				//Fechar componente
				dispose();
				
					//Voltar para tela de login
					IG_Login IGL = new IG_Login();
					IGL.setVisible(true);
				

			}
			
			//Função Botão [Passar por cima / Mudar cor]
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEntendi.setBackground(Color.WHITE);
				btnEntendi.setForeground(Color.DARK_GRAY);
				
			}
			
			//Função Botão [Sair de cima / Mudar cor]
			@Override
			public void mouseExited(MouseEvent e) {
				btnEntendi.setBackground(Color.DARK_GRAY);
				btnEntendi.setForeground(Color.WHITE);
				
			}
		});


		
	}
}
