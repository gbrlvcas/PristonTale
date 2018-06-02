package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import codigo.Acao;
import modelo.Estatica;

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
		
		//Instanciando [Pacakge: Código / Classe: Ação]
		Estatica EST = new Estatica();
		
		//Mensagem cabeçalho
		JLabel lblOcorreuAlgumErro = new JLabel("Ocorreu algum erro");
		lblOcorreuAlgumErro.setBackground(Color.DARK_GRAY);
		lblOcorreuAlgumErro.setOpaque(true);
		lblOcorreuAlgumErro.setForeground(Color.WHITE);
		lblOcorreuAlgumErro.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOcorreuAlgumErro.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcorreuAlgumErro.setBounds(0, 0, 340, 20);
		contentPane.add(lblOcorreuAlgumErro);
		
		//Mensagem de erro
		JLabel lblErros = new JLabel(EST.mensagemErro);
		lblErros.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblErros.setHorizontalAlignment(SwingConstants.CENTER);
		lblErros.setBounds(15, 36, 310, 29);
		contentPane.add(lblErros);
		
		//Botão [Entendi]
		JButton btnEntendi = new JButton("Entendi");
		btnEntendi.setForeground(Color.WHITE);
		btnEntendi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEntendi.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnEntendi.setBackground(Color.DARK_GRAY);
		btnEntendi.setBounds(108, 92, 115, 29);
		contentPane.add(btnEntendi);
		
		//Ação do botão [Entendi]
		btnEntendi.addMouseListener(new MouseAdapter() {
			
			//Função Botão [Clique / Sair]
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
			
			//Função Botão [Passar por cima / Mudar cor]
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEntendi.setBackground(Color.WHITE);
				btnEntendi.setForeground(Color.DARK_GRAY);
				
			}
			
			//Função Botão [Sair de cima / Mudar cor]
			@Override
			public void mouseExited(MouseEvent e) {
				btnEntendi.setBackground(Color.DARK_GRAY);
				btnEntendi.setForeground(Color.WHITE);
				
			}
			
		});
	}

}
