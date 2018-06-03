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

public class IG_Principal_ADM extends JFrame {

	private JPanel pnlADM;

//JFrame - Janela do ADM ===========================================================================================================
		
	public IG_Principal_ADM() {
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
		lblBackground.setIcon(new ImageIcon("C:\\Users\\Gbrlvcas\\Desktop\\Programacao\\PristonTale\\resources\\BG_ADM.jpg"));
		lblBackground.setBounds(0, 0, 668, 118);
		pnlADM.add(lblBackground);
	
//Componentes ====================================================================================================================================
		
		
		JPanel pnlPrincipal = new JPanel();
		pnlPrincipal.setBackground(new Color(255, 255, 240));
		pnlPrincipal.setBounds(0, 149, 668, 351);
		pnlADM.add(pnlPrincipal);
		pnlPrincipal.setLayout(new CardLayout(0, 0));
		
		JPanel pnlPadrao = new JPanel();
		pnlPrincipal.add(pnlPadrao, "Padrao");
		
		JPanel pnlEstatisticas = new JPanel();
		pnlPrincipal.add(pnlEstatisticas, "Estatisticas");
		pnlEstatisticas.setBackground(new Color(0, 0, 0));
		pnlEstatisticas.setForeground(new Color(0, 0, 0));
		pnlEstatisticas.setLayout(null);
		
		
		//Botão [Estatisticas
		JButton btnEstatisticas = new JButton("Estatisticas");
		btnEstatisticas.setBounds(0, 119, 99, 30);
		pnlADM.add(btnEstatisticas);
		btnEstatisticas.setMaximumSize(new Dimension(150, 200));
		btnEstatisticas.setForeground(Color.WHITE);
		btnEstatisticas.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEstatisticas.setBorder(null);
		btnEstatisticas.setBackground(Color.DARK_GRAY);
		
		btnEstatisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CardLayout estatisticas = (CardLayout) pnlPrincipal.getLayout();
				estatisticas.show(pnlPrincipal, "Estatisticas");
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
		
		btnEstatisticas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				
			}
		});
		
		
	}
}
