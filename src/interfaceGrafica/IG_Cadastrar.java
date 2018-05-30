package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class IG_Cadastrar extends JFrame {

	private JPanel pnlCadastro;
	private JTextField txtNovoLogin;
	private JTextField txtNovaSenha;
	private JTextField txtConfirmaSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IG_Cadastrar frame = new IG_Cadastrar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IG_Cadastrar() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 547);
		pnlCadastro = new JPanel();
		pnlCadastro.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlCadastro);
		pnlCadastro.setLayout(null);
		
		JLabel lblDadosConta = new JLabel("Criando nova conta no Priston Tale");
		lblDadosConta.setBounds(10, 131, 430, 24);
		lblDadosConta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDadosConta.setForeground(Color.WHITE);
		lblDadosConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosConta.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblDadosConta.setOpaque(true);
		lblDadosConta.setBackground(Color.DARK_GRAY);
		pnlCadastro.add(lblDadosConta);
		
		JSeparator spdLogin = new JSeparator();
		spdLogin.setBounds(10, 213, 430, 2);
		pnlCadastro.add(spdLogin);
		
		txtNovoLogin = new JTextField();
		txtNovoLogin.setBounds(166, 178, 200, 24);
		pnlCadastro.add(txtNovoLogin);
		txtNovoLogin.setColumns(10);
		
		JLabel lblNovoLogin = new JLabel("Login:");
		lblNovoLogin.setBounds(20, 176, 48, 24);
		lblNovoLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlCadastro.add(lblNovoLogin);
		
		txtConfirmaSenha = new JTextField();
		txtConfirmaSenha.setColumns(10);
		txtConfirmaSenha.setBounds(166, 295, 200, 24);
		pnlCadastro.add(txtConfirmaSenha);
		
		JSeparator spdSenha = new JSeparator();
		spdSenha.setBounds(10, 276, 430, 2);
		pnlCadastro.add(spdSenha);
		
		JLabel lblNovaSenha = new JLabel("Senha:");
		lblNovaSenha.setBounds(20, 232, 48, 24);
		lblNovaSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlCadastro.add(lblNovaSenha);
		
		txtNovaSenha = new JTextField();
		txtNovaSenha.setBounds(166, 232, 200, 24);
		txtNovaSenha.setColumns(10);
		pnlCadastro.add(txtNovaSenha);
		
		JLabel lblConfirmaSenha = new JLabel("Confirma Senha:");
		lblConfirmaSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConfirmaSenha.setBounds(20, 295, 120, 24);
		pnlCadastro.add(lblConfirmaSenha);
		
		JLabel lblCadastrarDadosPessoas = new JLabel("Cadastrar dados pessoas");
		lblCadastrarDadosPessoas.setOpaque(true);
		lblCadastrarDadosPessoas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarDadosPessoas.setForeground(Color.WHITE);
		lblCadastrarDadosPessoas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCadastrarDadosPessoas.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblCadastrarDadosPessoas.setBackground(Color.DARK_GRAY);
		lblCadastrarDadosPessoas.setBounds(10, 372, 430, 24);
		pnlCadastro.add(lblCadastrarDadosPessoas);
	}
}
