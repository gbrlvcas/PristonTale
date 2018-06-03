package interfaceGrafica;

import java.awt.CardLayout;
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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import codigo.CO_ADM;
import codigo.CO_Cadastro;
import modelo.Estatica;


public class IG_Cadastro extends JFrame {

	private JPanel pnlPrincipal;
	private JTextField txtNovoLogin;
	private JPasswordField txtNovaSenha;
	private JPasswordField txtConfirmaSenha;
	private JTextField txtNovoNome;
	private JTextField txtNovoSobrenome;
	private JTextField txtNovoEmail;
	
	
	//JFrame - Janela do cadastro =========================================================================================================
	
	public IG_Cadastro() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 551);
		pnlPrincipal = new JPanel();
		pnlPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlPrincipal);
		setLocationRelativeTo(null);
		pnlPrincipal.setLayout(null);
		
//Imagem do cursor e Background ==================================================================================================================
		
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
			

		
//Componentes [Painel Usuario] ========================================================================================================================================
		
	
		//Painel Principal [CardLayout]
		JPanel pnlCadastro = new JPanel();
		pnlCadastro.setBounds(0, 126, 450, 425);
		pnlPrincipal.add(pnlCadastro);
		pnlCadastro.setLayout(new CardLayout(0, 0));
		
		//Painel Usuario [Dentro do CardLayout]
		JPanel pnlUsuario = new JPanel();
		pnlCadastro.add(pnlUsuario, "Painel Usuario");
		pnlUsuario.setLayout(null);

		//Informações sobre os campos abaixo [Cadastro dos dados da conta]
		JLabel lblInfoUsuarios = new JLabel("Criando nova conta no Priston Tale");
		lblInfoUsuarios.setBounds(0, 0, 450, 24);
		pnlUsuario.add(lblInfoUsuarios);
		lblInfoUsuarios.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInfoUsuarios.setForeground(Color.WHITE);
		lblInfoUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoUsuarios.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblInfoUsuarios.setOpaque(true);
		lblInfoUsuarios.setBackground(Color.DARK_GRAY);
		
		//Novo Usuario 
		JLabel lblNovoLogin = new JLabel("Login:");
		lblNovoLogin.setBounds(10, 40, 48, 24);
		pnlUsuario.add(lblNovoLogin);
		lblNovoLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtNovoLogin = new JTextField();
		txtNovoLogin.setBounds(156, 42, 200, 24);
		pnlUsuario.add(txtNovoLogin);
		txtNovoLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtNovoLogin.setColumns(10);
		
		
		//Label com imagem [Certo e Errado]
		JLabel lblMostrarDisponibilidade = new JLabel("");
		lblMostrarDisponibilidade.setBounds(361, 42, 20, 20);
		pnlUsuario.add(lblMostrarDisponibilidade);
		
				
				//Botão [Verificar ID]
				JButton btnVerificar = new JButton("Verificar ID");
				btnVerificar.setBounds(156, 67, 200, 20);
				pnlUsuario.add(btnVerificar);
				btnVerificar.setBackground(Color.DARK_GRAY);
				btnVerificar.setForeground(Color.WHITE);
				
				//Ação do botão [Verificar]
				btnVerificar.addMouseListener(new MouseAdapter() {
					
					//Função do botão [Clique / Verificar ID]
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
					//Analisar disponibilidade [Exibe imagem correspondente ao resultado]
						
						//Capturando o ID digitado
						String idDisponivel = txtNovoLogin.getText().toString().toLowerCase();
							
						//Instanciando [Package: Codigo / Classe: CO_Usuarios]
						CO_Cadastro COU = new CO_Cadastro();
						
							//Chamando o método para verificar o ID
							COU.verificaID(idDisponivel);
						
						//Condicional [Pegar o resultado o método acima e validar]
						if(COU.verificaID(idDisponivel) == true) {
							
							lblMostrarDisponibilidade.setIcon(new ImageIcon(getClass().getResource("/ICN_Positivo.png")));
							
						}else {
							
							lblMostrarDisponibilidade.setIcon(new ImageIcon(getClass().getResource("/ICN_Negativo.png")));
							
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
		spdLogin.setBounds(0, 98, 430, 2);
		pnlUsuario.add(spdLogin);
		
		
		//Nova Senha
		JLabel lblNovaSenha = new JLabel("Senha:");
		lblNovaSenha.setBounds(10, 129, 48, 24);
		pnlUsuario.add(lblNovaSenha);
		lblNovaSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtNovaSenha = new JPasswordField();
		txtNovaSenha.setBounds(156, 129, 200, 24);
		pnlUsuario.add(txtNovaSenha);
		txtNovaSenha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtNovaSenha.setColumns(10);
		
		
		//Linha Separadora
		JSeparator spdSenha = new JSeparator();
		spdSenha.setBounds(0, 183, 430, 2);
		pnlUsuario.add(spdSenha);
		
		
		//Confirmar nova senha
		JLabel lblConfirmaSenha = new JLabel("Confirma Senha:");
		lblConfirmaSenha.setBounds(10, 213, 120, 24);
		pnlUsuario.add(lblConfirmaSenha);
		lblConfirmaSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtConfirmaSenha = new JPasswordField();
		txtConfirmaSenha.setBounds(156, 213, 200, 24);
		pnlUsuario.add(txtConfirmaSenha);
		txtConfirmaSenha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtConfirmaSenha.setColumns(10);
		
		
		//Botão [Prosseguir com cadastro]
		JButton btnProsseguir = new JButton("Prosseguir >");
		btnProsseguir.setBounds(300, 263, 120, 35);
		pnlUsuario.add(btnProsseguir);
		btnProsseguir.setForeground(Color.WHITE);
		btnProsseguir.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnProsseguir.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnProsseguir.setBackground(Color.DARK_GRAY);
		
		
				//Ação do botão [Prosseguir]
				btnProsseguir.addMouseListener(new MouseAdapter() {
					
					//Função botão [Clique / Sair]
					@Override
					public void mouseClicked(MouseEvent e) {
						
						//Instanciando [Package: Codigo / Classe: Acao]
						CO_Cadastro COU = new CO_Cadastro();
						
						//Pegar os dados digitados
						Estatica.novoUsuario = txtNovoLogin.getText().toString().toLowerCase();
						Estatica.novaSenha = (new String(txtNovaSenha.getPassword()));
						Estatica.confirmaSenha = (new String(txtConfirmaSenha.getPassword()));			
						
						//Instanciando [Package:Codigo / Classe: Acao]
						COU.verificaUsuario();
						
						//Fechar componente caso não haja erro no cadastro, e direcionar para o proximo componente
						if(Estatica.erroUsuario == 0) {

							CardLayout pessoal = (CardLayout) pnlCadastro.getLayout();
							pessoal.show(pnlCadastro, "pessoal");
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
		
		
				
		//Botão [Sair]
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(20, 263, 96, 35);
		pnlUsuario.add(btnSair);
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSair.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSair.setBackground(Color.DARK_GRAY);
		
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

		
//Componentes [Painel Pessoal] ========================================================================================================================================	
		
		//Painel Pessoal [CardLayout]
		JPanel pnlPessoal = new JPanel();
		pnlCadastro.add(pnlPessoal, "pessoal");
		pnlPessoal.setLayout(null);
		
		//Informações sobre o Painel
		JLabel lblInfoPessoal = new JLabel("Insira seus dados pessoais");
		lblInfoPessoal.setOpaque(true);
		lblInfoPessoal.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoPessoal.setForeground(Color.WHITE);
		lblInfoPessoal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInfoPessoal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblInfoPessoal.setBackground(Color.DARK_GRAY);
		lblInfoPessoal.setBounds(0, 0, 450, 24);
		pnlPessoal.add(lblInfoPessoal);
		
		//Nome
		JLabel lblNovoNome = new JLabel("Nome:");
		lblNovoNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNovoNome.setBounds(10, 45, 48, 24);
		pnlPessoal.add(lblNovoNome);
		
		txtNovoNome = new JTextField();
		txtNovoNome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtNovoNome.setColumns(10);
		txtNovoNome.setBounds(156, 47, 200, 24);
		pnlPessoal.add(txtNovoNome);
		
		//Linha Separadora
		JSeparator spdNome = new JSeparator();
		spdNome.setBounds(0, 77, 430, 2);
		pnlPessoal.add(spdNome);
		
		//Sobrenome
		JLabel lblNovoSobrenome = new JLabel("Sobrenome:");
		lblNovoSobrenome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNovoSobrenome.setBounds(10, 85, 86, 24);
		pnlPessoal.add(lblNovoSobrenome);
		
		txtNovoSobrenome = new JTextField();
		txtNovoSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtNovoSobrenome.setColumns(10);
		txtNovoSobrenome.setBounds(156, 84, 200, 24);
		pnlPessoal.add(txtNovoSobrenome);
		
		//Linha Separadora
		JSeparator spdSobrenome = new JSeparator();
		spdSobrenome.setBounds(0, 116, 430, 2);
		pnlPessoal.add(spdSobrenome);
		
		//Data de Nascimento
		JLabel lblNovaDatanascimento = new JLabel("Data de Nascimento:");
		lblNovaDatanascimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNovaDatanascimento.setBounds(10, 125, 143, 24);
		pnlPessoal.add(lblNovaDatanascimento);
		
		//Formatação do campo Data de nascimento
		MaskFormatter mascaraData = null;
		try {
			
			mascaraData = new MaskFormatter("##/##/####");
			
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "Falha");
		}
		
		JSeparator spdDatanascimento = new JSeparator();
		spdDatanascimento.setBounds(0, 157, 430, 2);
		pnlPessoal.add(spdDatanascimento);
		
		//Data de Nascimento
		JFormattedTextField txtNovaDatanascimento = new JFormattedTextField(mascaraData);
		pnlPessoal.add(txtNovaDatanascimento);
		txtNovaDatanascimento.setHorizontalAlignment(SwingConstants.CENTER);
		txtNovaDatanascimento.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtNovaDatanascimento.setBounds(191, 124, 131, 24);
		txtNovaDatanascimento.setColumns(10);
		
		//Email
		JLabel lblNovoEmail = new JLabel("Email:");
		lblNovoEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNovoEmail.setBounds(10, 165, 120, 24);
		pnlPessoal.add(lblNovoEmail);
		
		txtNovoEmail = new JTextField();
		txtNovoEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtNovoEmail.setColumns(10);
		txtNovoEmail.setBounds(156, 165, 200, 24);
		pnlPessoal.add(txtNovoEmail);
		
		//Termos
		JScrollPane scrTermos = new JScrollPane();
		scrTermos.setBounds(20, 205, 405, 80);
		pnlPessoal.add(scrTermos);
		
		JTextArea txtrEu = new JTextArea();
		scrTermos.setViewportView(txtrEu);
		txtrEu.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		txtrEu.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrEu.setLineWrap(true);
		txtrEu.setText("Eu finjo que l\u00ED estes termos, e clico direto em confirmar, afinal n\u00E3o tem nada de interessante aqui nesse campo, se bem que se voc\u00EA ta lendo isso at\u00E9 aqui, provavelmente isso esta sendo interessante, o que contradiz com o que est\u00E1 escrito no inicio da mensagem.");
		txtrEu.setEditable(false);
		
		JCheckBox chkTermos = new JCheckBox("Eu concordo com os termos que n\u00E3o l\u00ED, ou l\u00ED");
		chkTermos.setFont(new Font("Tahoma", Font.BOLD, 14));
		chkTermos.setBounds(25, 292, 377, 24);
		pnlPessoal.add(chkTermos);
		
		//Botão [Sair]
		JButton btnVoltar = new JButton("< Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVoltar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnVoltar.setBackground(Color.DARK_GRAY);
		btnVoltar.setBounds(5, 337, 96, 35);
		pnlPessoal.add(btnVoltar);
		
		//Ação do botão [Sair]
		btnVoltar.addMouseListener(new MouseAdapter() {
			
			//Função botão [Clique / Sair]
			@Override
			public void mouseClicked(MouseEvent e) {
			
			CardLayout usuario = (CardLayout) pnlCadastro.getLayout();
			usuario.show(pnlCadastro, "Painel Usuario");
			
			}
			
			//Função Botão [Passar por cima / Mudar cor]
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVoltar.setBackground(Color.WHITE);
				btnVoltar.setForeground(Color.DARK_GRAY);
				
			}
			
			//Função Botão [Sair de cima / Mudar cor]
			@Override
			public void mouseExited(MouseEvent e) {
				btnVoltar.setBackground(Color.DARK_GRAY);
				btnVoltar.setForeground(Color.WHITE);
				
			}
		});
		
		
		//Botão [Prosseguir]
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCadastrar.setBackground(Color.DARK_GRAY);
		btnCadastrar.setBounds(156, 337, 120, 35);
		pnlPessoal.add(btnCadastrar);
		
		//Ação do botão [Prosseguir]
		btnCadastrar.addMouseListener(new MouseAdapter() {
					
			//Função botão [Clique / Prosseguir]
			@Override
			public void mouseClicked(MouseEvent e) {
						
				//Instanciando [Package: Codigo / Classe: Usuarios]
				CO_Cadastro COU = new CO_Cadastro();
						
				//Pegar os dados digitados
				Estatica.novoNome = txtNovoNome.getText().toString();
				Estatica.novoSobrenome = txtNovoSobrenome.getText().toString();
				Estatica.novaDatanascimento = txtNovaDatanascimento.getText().toString();
				Estatica.novoEmail = txtNovoEmail.getText().toString();
						
				//Verificar se o termo foi selecionado
				boolean termoSelecionado = true;
				if(!chkTermos.isSelected()) {
					termoSelecionado = false;
				}
								
						
				//Instanciando [Package:Codigo / Classe:Usuarios / Método: ]
				COU.verificaPessoal(termoSelecionado);

					//Fechar componente caso não haja erro no cadastro
						//Direcionar para o próximo componente
						if(Estatica.erroPessoal == 0) {
								dispose();
						IG_Cadastro_Listar IGCL = new IG_Cadastro_Listar();
							IGCL.setVisible(true);
					
							//Gravar dados para Estatisticas
							CO_ADM COA = new CO_ADM();
							COA.gravarEstatisticas();

					
					}
					
				}
					
				//Função Botão [Passar por cima / Mudar cor]
				@Override
				public void mouseEntered(MouseEvent e) {
					btnCadastrar.setBackground(Color.WHITE);
					btnCadastrar.setForeground(Color.DARK_GRAY);
						
				}
					
				//Função Botão [Sair de cima / Mudar cor]
				@Override
				public void mouseExited(MouseEvent e) {
					btnCadastrar.setBackground(Color.DARK_GRAY);
					btnCadastrar.setForeground(Color.WHITE);
						
				}
			});
		

		
	}
}
