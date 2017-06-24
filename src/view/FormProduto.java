package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Produto;
import methods.ScreenSize;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;




public class FormProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtPreco;
	private Produto produto = new Produto();

	
	
	public FormProduto(Produto produto1) {
		
		produto = new Produto();
		produto = produto1;
		
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
		txtId.setText(String.valueOf(produto.getId_produto()));
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblCategoria = new JLabel("CATEGORIA:");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCategoria.setBounds(24, 257, 151, 30);
		contentPane.add(lblCategoria);
		
		JComboBox cbCategoria = new JComboBox();
		cbCategoria.setFont(new Font("Tahoma", Font.PLAIN, 21));
		cbCategoria.setBounds(176, 257, 270, 30);
		contentPane.add(cbCategoria);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNome.setBounds(24, 340, 107, 30);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtNome.setBounds(112, 340, 1189, 30);
		txtNome.setText(produto.getNome());
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblDescrio = new JLabel("DESCRI\u00C7\u00C3O:");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDescrio.setBounds(24, 418, 161, 30);
		contentPane.add(lblDescrio);
		
		JTextArea txtDescricao = new JTextArea();
		txtDescricao.setFont(new Font("Monospaced", Font.PLAIN, 21));
		txtDescricao.setBounds(176, 418, 1125, 248);
		contentPane.add(txtDescricao);
		
		JLabel lblPreo = new JLabel("PRE\u00C7O:");
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPreo.setBounds(911, 257, 187, 30);
		contentPane.add(lblPreo);
		
		txtPreco = new JTextField();
		txtPreco.setText("R$");
		txtPreco.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtPreco.setBounds(1017, 257, 284, 30);
		txtPreco.setText(String.valueOf(produto.getPreco()));
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
	}
}
