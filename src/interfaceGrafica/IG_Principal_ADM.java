package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IG_Principal_ADM extends JFrame {

	private JPanel pnlADM;



	
	public IG_Principal_ADM() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 500);
		pnlADM = new JPanel();
		pnlADM.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlADM);
		setLocationRelativeTo(null);
		pnlADM.setLayout(null);
		
		JButton btnSair = new JButton("SAIR");
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
			
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSair.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSair.setBackground(Color.DARK_GRAY);
		btnSair.setBounds(10, 434, 99, 43);
		pnlADM.add(btnSair);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\104969\\Desktop\\Trabalho Programador\\20-Sistema-PristonTale\\resources\\BG_Principal.jpg"));
		lblBackground.setBounds(0, 0, 668, 500);
		pnlADM.add(lblBackground);
		
//Imagem do cursor ==================================================================================================================
		
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Image image = toolkit.getImage(getClass().getResource("/PT_Mouse.png"));
			Point hotspot = new Point(0,0);
		    Cursor cursor = toolkit.createCustomCursor(image, hotspot, "PT_Mouse");
		    setCursor(cursor);		
		    
//Componentes =======================================================================================================================
		    
		    
		    
		    
		    
		    
	}
}
