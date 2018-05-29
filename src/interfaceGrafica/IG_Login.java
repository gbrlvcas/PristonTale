package interfaceGrafica;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class IG_Login extends JFrame {

	private JPanel pnlLogin;
	private JTextField textField;
	private JPasswordField passwordField;

	//JFrame - Janela do login
	public IG_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 340);
		pnlLogin = new JPanel();
		pnlLogin.setBounds(new Rectangle(0, 0, 400, 300));
		pnlLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(pnlLogin);
		pnlLogin.setLayout(null);
		
//Imagem do cursor ==================================================================================================================
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Image image = toolkit.getImage(getClass().getResource("/PT_Mouse.png"));
	    Point hotspot = new Point(0,0);
		Cursor cursor = toolkit.createCustomCursor(image, hotspot, "PT_Mouse");
		setCursor(cursor);
		
	
//Componentes =======================================================================================================================
		
		//Login
		JLabel lblLogin = new JLabel("USUARIO");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogin.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblLogin.setOpaque(true);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogin.setBounds(159, 74, 85, 28);
		pnlLogin.add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(126, 109, 150, 25);
		pnlLogin.add(textField);
		textField.setColumns(10);
		
		//Senha
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSenha.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblSenha.setOpaque(true);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenha.setBounds(168, 145, 67, 28);
		pnlLogin.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(126, 180, 150, 25);
		pnlLogin.add(passwordField);
		
		//Botão
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(155, 231, 93, 36);
		pnlLogin.add(btnNewButton);
		
		JLabel lblVerso = new JLabel("Vers\u00E3o 1.0");
		lblVerso.setBounds(315, 287, 58, 14);
		pnlLogin.add(lblVerso);
		
		//Background
		JLabel lblBackground = new JLabel("");
		lblBackground.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblBackground.setBounds(0, 0, 400, 300);
		lblBackground.setCursor(cursor);
		pnlLogin.add(lblBackground);
		
		
	    
	}
}
