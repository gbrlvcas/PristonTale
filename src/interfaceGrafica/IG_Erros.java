package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import codigo.Acao;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class IG_Erros extends JFrame {

	private JPanel contentPane;

//JFrame - Janela de Erros =========================================================================================================	
	
	public IG_Erros() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 137);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
//Componentes =======================================================================================================================
		
		//Instanciando [Pacakge: C�digo / Classe: A��o]
		Acao a = new Acao();
		
		//Mensagem cabe�alho
		JLabel lblOcorreuAlgumErro = new JLabel("Ocorreu algum erro");
		lblOcorreuAlgumErro.setBackground(Color.DARK_GRAY);
		lblOcorreuAlgumErro.setOpaque(true);
		lblOcorreuAlgumErro.setForeground(Color.WHITE);
		lblOcorreuAlgumErro.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOcorreuAlgumErro.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcorreuAlgumErro.setBounds(0, 0, 340, 20);
		contentPane.add(lblOcorreuAlgumErro);
		
		//Mensagem de erro
		JLabel lblErros = new JLabel(a.mensagemErro);
		lblErros.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblErros.setHorizontalAlignment(SwingConstants.CENTER);
		lblErros.setBounds(15, 36, 310, 29);
		contentPane.add(lblErros);
		
		//Bot�o [Entendi]
		JButton btnEntendi = new JButton("Entendi");
		btnEntendi.setForeground(Color.WHITE);
		btnEntendi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEntendi.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnEntendi.setBackground(Color.DARK_GRAY);
		btnEntendi.setBounds(108, 92, 115, 29);
		contentPane.add(btnEntendi);
		
		//A��o do bot�o [Entendi]
		btnEntendi.addMouseListener(new MouseAdapter() {
			
			//Fun��o Bot�o [Clique / Sair]
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
			
			//Fun��o Bot�o [Passar por cima / Mudar cor]
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEntendi.setBackground(Color.WHITE);
				btnEntendi.setForeground(Color.DARK_GRAY);
				
			}
			
			//Fun��o Bot�o [Sair de cima / Mudar cor]
			@Override
			public void mouseExited(MouseEvent e) {
				btnEntendi.setBackground(Color.DARK_GRAY);
				btnEntendi.setForeground(Color.WHITE);
				
			}
			
		});
	}

}
