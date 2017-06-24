package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Produto;
import methods.ScreenSize;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;




public class FormProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField textField;
	private JTextField txtR;
	private Produto produto;
	private ArrayList<Produto> produtoa;
	
	
	public FormProduto(Produto produto1, ArrayList<Produto> produtoa1) {
		
		
		produto = produto1;
		produtoa = produtoa1;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, ScreenSize.getScreenWidth(), ScreenSize.getScreenHeight()-30);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("Alterar Produto");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblId.setBounds(24, 11, 313, 46);
		contentPane.add(lblId);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(24, 154, 88, 30);
		contentPane.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtId.setBounds(64, 156, 121, 30);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblCategoria = new JLabel("CATEGORIA:");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCategoria.setBounds(24, 257, 151, 30);
		contentPane.add(lblCategoria);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 21));
		comboBox.setBounds(176, 257, 270, 30);
		contentPane.add(comboBox);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNome.setBounds(24, 340, 107, 30);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textField.setBounds(112, 340, 1189, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDescrio = new JLabel("DESCRI\u00C7\u00C3O:");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDescrio.setBounds(24, 418, 161, 30);
		contentPane.add(lblDescrio);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 21));
		textArea.setBounds(176, 418, 1125, 248);
		contentPane.add(textArea);
		
		JLabel lblPreo = new JLabel("PRE\u00C7O:");
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPreo.setBounds(911, 257, 187, 30);
		contentPane.add(lblPreo);
		
		txtR = new JTextField();
		txtR.setText("R$");
		txtR.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtR.setBounds(1017, 257, 284, 30);
		contentPane.add(txtR);
		txtR.setColumns(10);
	}
}
