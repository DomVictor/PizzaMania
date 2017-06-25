package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import methods.ScreenSize;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class FormPizzaria extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPizzaria frame = new FormPizzaria();
					frame.setVisible(true);
					frame.setExtendedState(MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormPizzaria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, ScreenSize.getScreenWidth(), ScreenSize.getScreenHeight());
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovoCadastro = new JLabel("Novo Cadastro");
		lblNovoCadastro.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNovoCadastro.setBounds(29, 11, 270, 47);
		contentPane.add(lblNovoCadastro);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNome.setBounds(29, 119, 106, 31);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setBounds(108, 120, 616, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCnpj.setBounds(896, 122, 100, 25);
		contentPane.add(lblCnpj);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_1.setBounds(962, 119, 305, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEmail.setBounds(29, 210, 94, 30);
		contentPane.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_2.setBounds(117, 210, 415, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTelefone.setBounds(576, 210, 148, 30);
		contentPane.add(lblTelefone);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_3.setBounds(687, 210, 196, 30);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTelefone_1 = new JLabel("Telefone 2:");
		lblTelefone_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTelefone_1.setBounds(931, 210, 148, 30);
		contentPane.add(lblTelefone_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_4.setColumns(10);
		textField_4.setBounds(1073, 210, 196, 30);
		contentPane.add(textField_4);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCep.setBounds(29, 309, 94, 30);
		contentPane.add(lblCep);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_5.setColumns(10);
		textField_5.setBounds(90, 309, 210, 30);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_6.setColumns(10);
		textField_6.setBounds(485, 310, 452, 30);
		contentPane.add(textField_6);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblRua.setBounds(429, 309, 148, 30);
		contentPane.add(lblRua);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNmero.setBounds(1030, 309, 148, 30);
		contentPane.add(lblNmero);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_7.setColumns(10);
		textField_7.setBounds(1136, 310, 131, 30);
		contentPane.add(textField_7);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblComplemento.setBounds(29, 404, 210, 30);
		contentPane.add(lblComplemento);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_8.setColumns(10);
		textField_8.setBounds(200, 404, 452, 30);
		contentPane.add(textField_8);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblBairro.setBounds(741, 404, 148, 30);
		contentPane.add(lblBairro);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_9.setColumns(10);
		textField_9.setBounds(833, 404, 434, 30);
		contentPane.add(textField_9);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCidade.setBounds(29, 486, 210, 30);
		contentPane.add(lblCidade);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_10.setColumns(10);
		textField_10.setBounds(125, 486, 452, 30);
		contentPane.add(textField_10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEstado.setBounds(683, 486, 100, 30);
		contentPane.add(lblEstado);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 22));
		comboBox.setBounds(781, 486, 84, 30);
		contentPane.add(comboBox);
		
		JLabel lblSobre = new JLabel("Sobre:");
		lblSobre.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSobre.setBounds(29, 566, 210, 30);
		contentPane.add(lblSobre);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textArea.setBounds(117, 566, 1223, 152);
		contentPane.add(textArea);
	}
}
