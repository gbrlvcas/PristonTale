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

import javax.swing.border.EmptyBorder;

import codigo.CO_Player;
import modelo.Estatica;


public class IG_Player_Personagem extends JFrame {

	private JPanel pnlADM;

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
