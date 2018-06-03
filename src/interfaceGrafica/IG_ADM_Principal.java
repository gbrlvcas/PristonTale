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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class IG_ADM_Principal extends JFrame {

	private JPanel pnlADM;

//JFrame - Janela do ADM ===========================================================================================================
		
	public IG_ADM_Principal() {
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
		
		
		//Botão [Estatisticas
		JButton btnPersonagens = new JButton("Personagens");
		btnPersonagens.setBounds(0, 119, 99, 30);
		pnlADM.add(btnPersonagens);
		btnPersonagens.setMaximumSize(new Dimension(150, 200));
		btnPersonagens.setForeground(Color.WHITE);
		btnPersonagens.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPersonagens.setBorder(null);
		btnPersonagens.setBackground(Color.DARK_GRAY);
		
		//Ação do botão [Clique / Mostrar estatisticas]
		btnPersonagens.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				
				IG_ADM_Estatisticas IGAE = new IG_ADM_Estatisticas();
				IGAE.setVisible(true);
				
			}
		});
		

		
		
		//Botão [Sair]
		JButton btnSair = new JButton("SAIR");
		btnSair.setBounds(569, 119, 99, 30);
		pnlADM.add(btnSair);
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSair.setBorder(null);
		btnSair.setBackground(Color.DARK_GRAY);
		
		JButton btnAlterarDados = new JButton("Alterar dados");
		btnAlterarDados.setMaximumSize(new Dimension(150, 200));
		btnAlterarDados.setForeground(Color.WHITE);
		btnAlterarDados.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAlterarDados.setBorder(null);
		btnAlterarDados.setBackground(Color.DARK_GRAY);
		btnAlterarDados.setBounds(100, 119, 99, 30);
		pnlADM.add(btnAlterarDados);
		
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
