package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import methods.ScreenSize;
import view2.PainelPrincipal_Administrador;

import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;

public class FormAdm extends JFrame {

	PainelPrincipal_Administrador painelPrincipal_Administrador = new PainelPrincipal_Administrador();
	
	
	private JPanel contentPane;
	
	
	final static String PPA = "Painel Principal";
	private JTable table;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAdm frame = new FormAdm();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("unused")
	private void selectedPanel(String g){
		 CardLayout cl = (CardLayout)(contentPane.getLayout());
		    cl.show(contentPane, g);
	}
	
	public FormAdm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, ScreenSize.getScreenWidth(), ScreenSize.getScreenHeight());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnPizzarias = new JButton("Pizzarias");
		menuBar.add(btnPizzarias);
		
		JButton btnAvaliaes = new JButton("Avalia\u00E7\u00F5es");
		menuBar.add(btnAvaliaes);
		
		contentPane.add(painelPrincipal_Administrador, PPA);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 110, 1320, 545);
		painelPrincipal_Administrador.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Pizzarias");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 11, 186, 46);
		painelPrincipal_Administrador.add(lblNewLabel);
		
		JButton btnNovoCadastro = new JButton("Novo Cadastro");
		btnNovoCadastro.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnNovoCadastro.setBounds(1124, 53, 206, 46);
		painelPrincipal_Administrador.add(btnNovoCadastro);
		
	}
}
