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

public class IG_Pessoal extends JFrame {

	private JPanel pnlCadastro;
	private JTextField txtNomeUsuario;
	private JFormattedTextField txtDataNascimento;
	private JTextField txtEmailUsuario;
	private JTextField txtSobrenomeUsuario;
	
	//JFrame - Janela do cadastro [Usuario] =========================================================================================================
	
	public IG_Pessoal() {
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
				
			
//Componentes =======================================================================================================================
		
		//Informa��es sobre os campos abaixo [Cadastro dos dados pessoais]
		JLabel lblDadosConta = new JLabel("Insira seus dados pessoais");
		lblDadosConta.setBounds(10, 131, 430, 24);
		lblDadosConta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDadosConta.setForeground(Color.WHITE);
		lblDadosConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosConta.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblDadosConta.setOpaque(true);
		lblDadosConta.setBackground(Color.DARK_GRAY);
		pnlCadastro.add(lblDadosConta);
		
		
		//Nome do usuario
		JLabel lblNomeUsuario = new JLabel("Nome:");
		lblNomeUsuario.setBounds(20, 176, 48, 24);
		lblNomeUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlCadastro.add(lblNomeUsuario);
		
		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtNomeUsuario.setBounds(166, 178, 200, 24);
		pnlCadastro.add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);
		
		
		//Linha Separadora
		JSeparator spdNome = new JSeparator();
		spdNome.setBounds(10, 208, 430, 2);
		pnlCadastro.add(spdNome);
		
		
		//Sobrenome do usuario
		JLabel lblSobrenomeUsuario = new JLabel("Sobrenome:");
		lblSobrenomeUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSobrenomeUsuario.setBounds(20, 216, 86, 24);
		pnlCadastro.add(lblSobrenomeUsuario);
		
		txtSobrenomeUsuario = new JTextField();
		txtSobrenomeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtSobrenomeUsuario.setColumns(10);
		txtSobrenomeUsuario.setBounds(166, 215, 200, 24);
		pnlCadastro.add(txtSobrenomeUsuario);
		
		JSeparator spdSobrenome = new JSeparator();
		spdSobrenome.setBounds(10, 247, 430, 2);
		pnlCadastro.add(spdSobrenome);
		

		//Data de nascimento do usuario
		JLabel lblDataNascimento = new JLabel("Data de Nacimento:");
		lblDataNascimento.setBounds(20, 256, 143, 24);
		lblDataNascimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlCadastro.add(lblDataNascimento);
		
		//Formata��o do campo Data de nascimento
		MaskFormatter mascaraData = null;
		try {
			
			mascaraData = new MaskFormatter("##/##/####");
			
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "Falha");
		}
		
		//Data de Nascimento
		txtDataNascimento = new JFormattedTextField(mascaraData);
		txtDataNascimento.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtDataNascimento.setBounds(166, 255, 96, 24);
		txtDataNascimento.setColumns(10);
		pnlCadastro.add(txtDataNascimento);
		
		//Linha de separa��o
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 288, 430, 2);
		pnlCadastro.add(separator);
		
		
		//Confirmar nova senha
		JLabel lblEmailUsuario = new JLabel("Email:");
		lblEmailUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmailUsuario.setBounds(20, 296, 120, 24);
		pnlCadastro.add(lblEmailUsuario);
		
		txtEmailUsuario = new JTextField();
		txtEmailUsuario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtEmailUsuario.setColumns(10);
		txtEmailUsuario.setBounds(166, 296, 200, 24);
		pnlCadastro.add(txtEmailUsuario);
		
		
		//Cabe�alho
		JLabel lblCabecalho = new JLabel("");
		lblCabecalho.setIcon(new ImageIcon(getClass().getResource("/BG_Cadastrar.jpg")));
		lblCabecalho.setBounds(0, 0, 450, 126);
		pnlCadastro.add(lblCabecalho);
		
		//Area onde est� escrito os termos
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 336, 405, 80);
		pnlCadastro.add(scrollPane);
		
		JTextArea txtrEu = new JTextArea();
		scrollPane.setViewportView(txtrEu);
		txtrEu.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		txtrEu.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrEu.setLineWrap(true);
		txtrEu.setText("Eu finjo que l\u00ED estes termos, e clico direto em confirmar, afinal n\u00E3o tem nada de interessante aqui nesse campo, se bem que se voc\u00EA ta lendo isso at\u00E9 aqui, provavelmente isso esta sendo interessante, o que contradiz com o que est\u00E1 escrito no inicio da mensagem.");
		txtrEu.setEditable(false);
		
		
		//Caixa de confirma��o de leitura
		JCheckBox chkTermos = new JCheckBox("Eu concordo com os termos que n\u00E3o l\u00ED, ou l\u00ED");
		chkTermos.setFont(new Font("Tahoma", Font.BOLD, 14));
		chkTermos.setBounds(35, 423, 377, 24);
		pnlCadastro.add(chkTermos);

		
		//Bot�o [Sair]
		JButton btnVoltar = new JButton("< Voltar");

		btnVoltar.setBounds(15, 468, 96, 35);
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVoltar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnVoltar.setBackground(Color.DARK_GRAY);
		pnlCadastro.add(btnVoltar);
		
		//A��o do bot�o [Sair]
		btnVoltar.addMouseListener(new MouseAdapter() {
			
			//Fun��o bot�o [Clique / Sair]
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				IG_Usuario IGU = new IG_Usuario();
				IGU.setVisible(true);

			}
			
			//Fun��o Bot�o [Passar por cima / Mudar cor]
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVoltar.setBackground(Color.WHITE);
				btnVoltar.setForeground(Color.DARK_GRAY);
				
			}
			
			//Fun��o Bot�o [Sair de cima / Mudar cor]
			@Override
			public void mouseExited(MouseEvent e) {
				btnVoltar.setBackground(Color.DARK_GRAY);
				btnVoltar.setForeground(Color.WHITE);
				
			}
		});
		
		
		//Bot�o [Prosseguir com cadastro]
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCadastrar.setBackground(Color.DARK_GRAY);
		btnCadastrar.setBounds(166, 468, 120, 35);
		pnlCadastro.add(btnCadastrar);


		//A��o do bot�o [Prosseguir]
		btnCadastrar.addMouseListener(new MouseAdapter() {
			
			//Fun��o bot�o [Clique / Sair]
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Instanciando [Package: Codigo / Classe: Usuarios]
				CO_Cadastro COU = new CO_Cadastro();
				
				//Pegar os dados digitados
				Estatica.novoNome = txtNomeUsuario.getText().toString();
				Estatica.novoSobrenome = txtSobrenomeUsuario.getText().toString();
				Estatica.novaDatanascimento = txtDataNascimento.getText().toString();
				Estatica.novoEmail = txtEmailUsuario.getText().toString();
				
				//Verificar se o termo foi selecionado
				boolean termoSelecionado = true;
					if(!chkTermos.isSelected()) {
						termoSelecionado = false;
					}
						
				
				//Instanciando [Package:Codigo / Classe:Usuarios / M�todo: ]
				COU.verificaPessoal(termoSelecionado);
				

			}
			
			//Fun��o Bot�o [Passar por cima / Mudar cor]
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCadastrar.setBackground(Color.WHITE);
				btnCadastrar.setForeground(Color.DARK_GRAY);
				
			}
			
			//Fun��o Bot�o [Sair de cima / Mudar cor]
			@Override
			public void mouseExited(MouseEvent e) {
				btnCadastrar.setBackground(Color.DARK_GRAY);
				btnCadastrar.setForeground(Color.WHITE);
				
			}
		});


		
	}
}
