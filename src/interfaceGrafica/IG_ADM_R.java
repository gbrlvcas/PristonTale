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

public class IG_ADM_R extends JFrame {

	private JPanel pnlADM;

//JFrame - Janela do ADM ===========================================================================================================
		
	public IG_ADM_R() {
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
	    Image image = toolkit.getImage(getClass().getResource("/PT_MouseRALF.png"));
		Point hotspot = new Point(0,0);
	    Cursor cursor = toolkit.createCustomCursor(image, hotspot, "PT_Mouse");
		setCursor(cursor);
		

		//Background
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\Gbrlvcas\\Desktop\\Programacao\\PristonTale\\resources\\BG_R.gif"));
		lblBackground.setBounds(0, 0, 668, 500);
		pnlADM.add(lblBackground);
	
		
		
	}
}
