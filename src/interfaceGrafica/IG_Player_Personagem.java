package interfaceGrafica;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import codigo.CO_Player;
import modelo.Estatica;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;


public class IG_Player_Personagem extends JFrame {

	private JPanel pnlADM;
	private JTextField txtNickname;

//JFrame - Janela do ADM ===========================================================================================================
		
	public IG_Player_Personagem() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 500);
		pnlADM = new JPanel();
		pnlADM.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlADM);
		setLocationRelativeTo(null);
		pnlADM.setLayout(null);
		
//Imagem do cursor e Background ==================================================================================================================
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Image image = toolkit.getImage(getClass().getResource("/PT_Mouse.png"));
		Point hotspot = new Point(0,0);
	    Cursor cursor = toolkit.createCustomCursor(image, hotspot, "PT_Mouse");
		setCursor(cursor);
		

		//Background
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(getClass().getResource("/BG_Player.jpg")));
		lblBackground.setBounds(0, 0, 668, 118);
		pnlADM.add(lblBackground);

		//Mensagem de boas vindas
		CO_Player COP = new CO_Player();
			COP.boasVindas();
		JLabel lblBoasvindas = new JLabel(Estatica.msgBoasVindas);
		lblBoasvindas.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBoasvindas.setBounds(10, 126, 643, 20);
		pnlADM.add(lblBoasvindas);
		
		//Personagem
		JLabel lblCriarPersonagem = new JLabel("Criar Personagem");
		lblCriarPersonagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblCriarPersonagem.setOpaque(true);
		lblCriarPersonagem.setBackground(Color.DARK_GRAY);
		lblCriarPersonagem.setForeground(Color.WHITE);
		lblCriarPersonagem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCriarPersonagem.setBounds(8, 162, 172, 27);
		pnlADM.add(lblCriarPersonagem);
		
		JLabel lblNewLabel = new JLabel("Nickname");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(21, 205, 69, 20);
		pnlADM.add(lblNewLabel);
		
		txtNickname = new JTextField();
		txtNickname.setBounds(21, 228, 146, 26);
		pnlADM.add(txtNickname);
		txtNickname.setColumns(10);
		
		//Label com imagem [Certo e Errado]
		JLabel lblMostrarDisponibilidade = new JLabel("");
		lblMostrarDisponibilidade.setBounds(170, 231, 20, 20);
		pnlADM.add(lblMostrarDisponibilidade);
		
		//Botão [Verificar Nick]
		JButton btnVerificarNick = new JButton("Verificar Nick");
		btnVerificarNick.setBackground(Color.DARK_GRAY);
		btnVerificarNick.setForeground(Color.WHITE);
		btnVerificarNick.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVerificarNick.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVerificarNick.setBounds(21, 260, 146, 20);
		pnlADM.add(btnVerificarNick);
		
		//Ação do botão [Verificar ID]
		btnVerificarNick.addMouseListener(new MouseAdapter() {
			
			//Ação do botão [Verificar]
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
			//Pegar nick digitado
			String nickDisponivel = txtNickname.getText();
			
			//Instanciando [Package: codigo / Classe: CO_Player]
			CO_Player COP = new CO_Player();
			
				//Chamando o método para verificar o Nick
				COP.verificaNick(nickDisponivel);
				
			//Condicional [Pegar o resultado do método acima e validar]
			if(COP.verificaNick(nickDisponivel) == true) {
				
				lblMostrarDisponibilidade.setIcon(new ImageIcon(getClass().getResource("/ICN_Positivo.png")));
				
			}else{
				
				lblMostrarDisponibilidade.setIcon(new ImageIcon(getClass().getResource("/ICN_Negativo.png")));
			}
			
			}
			
			//Função Botão [Passar por cima / Mudar cor]
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVerificarNick.setBackground(Color.WHITE);
				btnVerificarNick.setForeground(Color.DARK_GRAY);
				
			}
			
			//Função Botão [Sair de cima / Mudar cor]
			@Override
			public void mouseExited(MouseEvent e) {
				btnVerificarNick.setBackground(Color.DARK_GRAY);
				btnVerificarNick.setForeground(Color.WHITE);
				
			}
		});
		
		
		
		JLabel lblClasse = new JLabel("Classe");
		lblClasse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClasse.setBounds(21, 295, 69, 20);
		pnlADM.add(lblClasse);
		
		JComboBox<String> comboClasses = new JComboBox();
		comboClasses.setBounds(21, 316, 146, 26);
		pnlADM.add(comboClasses);
		
		comboClasses.addItem("Escolha sua classe");
		comboClasses.addItem("Knight");
		comboClasses.addItem("Pikeman");
		comboClasses.addItem("Atalanta");
		comboClasses.addItem("Archer");
		comboClasses.addItem("Sacer");
		comboClasses.addItem("Mechanician");
		comboClasses.addItem("Mage");
		comboClasses.addItem("Fighter");
		
		//Imagem das classes
		JLabel lblClasses = new JLabel("");
		lblClasses.setBounds(21, 349, 60, 60);
		pnlADM.add(lblClasses);
		
		//Imagem das raças
		JLabel lblRaca = new JLabel("");
		lblRaca.setBounds(107, 349, 60, 60);
		pnlADM.add(lblRaca);
		
			//Ação de pegar os dados selecionados na ComboBox
			comboClasses.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						//Pegando a seleção da combobox e alterando a imagem
						String classe = comboClasses.getSelectedItem().toString();
		
						
						//Condicional para alterar imagem das classes
						switch(classe) {
						case "Knight":
							lblClasses.setIcon(new ImageIcon(getClass().getResource("/Classes/ICN_Knight.png")));
							lblRaca.setIcon(new ImageIcon(getClass().getResource("/Classes/ICN_Morions.png")));
						break;
						case "Pikeman":
							lblClasses.setIcon(new ImageIcon(getClass().getResource("/Classes/ICN_Pikeman.png")));
							lblRaca.setIcon(new ImageIcon(getClass().getResource("/Classes/ICN_Tempskrons.png")));
							break;
						case "Atalanta":
							lblClasses.setIcon(new ImageIcon(getClass().getResource("/Classes/ICN_Atalanta.png")));
							lblRaca.setIcon(new ImageIcon(getClass().getResource("/Classes/ICN_Morions.png")));
							break;
						case "Archer":
							lblClasses.setIcon(new ImageIcon(getClass().getResource("/Classes/ICN_Archer.png")));
							lblRaca.setIcon(new ImageIcon(getClass().getResource("/Classes/ICN_Tempskrons.png")));
							break;
						case "Sacer":
							lblClasses.setIcon(new ImageIcon(getClass().getResource("/Classes/ICN_Sacer.png")));
							lblRaca.setIcon(new ImageIcon(getClass().getResource("/Classes/ICN_Morions.png")));
							break;
						case "Mechanician":
							lblClasses.setIcon(new ImageIcon(getClass().getResource("/Classes/ICN_Mechanician.png")));
							lblRaca.setIcon(new ImageIcon(getClass().getResource("/Classes/ICN_Tempskrons.png")));
							break;
						case "Mage":
							lblClasses.setIcon(new ImageIcon(getClass().getResource("/Classes/ICN_Mage.png")));
							lblRaca.setIcon(new ImageIcon(getClass().getResource("/Classes/ICN_Morions.png")));
							break;
						case "Fighter":
							lblClasses.setIcon(new ImageIcon(getClass().getResource("/Classes/ICN_Fighter.png")));
							lblRaca.setIcon(new ImageIcon(getClass().getResource("/Classes/ICN_Tempskrons.png")));
							break;
							
						
						}
						
					}
				});

				
		//Botão [Sair]
		JButton btnSair = new JButton("SAIR");
		btnSair.setBounds(0, 470, 668, 30);
		pnlADM.add(btnSair);
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSair.setBorder(null);
		btnSair.setBackground(Color.DARK_GRAY);
		
		//Ação do botão [Sair]
		btnSair.addMouseListener(new MouseAdapter() {
			
			//Função Botão [Clique / Sair]
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				
				//Instanciando [Classe: IG_Login]
				IG_Login IGL = new IG_Login();
				IGL.setVisible(true);
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
	
		
		
	}
}
