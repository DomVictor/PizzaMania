package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Cadastro;
import methods.ScreenSize;
import model.BdCadastro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FormPizzaria1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCnpj;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtTelefone2;
	private JTextField txtCep;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;

	Cadastro cadastro;
	private JTextField textField;
	
	public FormPizzaria1()
	{
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
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtNome.setBounds(108, 120, 616, 30);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCnpj.setBounds(896, 122, 100, 25);
		contentPane.add(lblCnpj);
		
		txtCnpj = new JTextField();
		txtCnpj.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtCnpj.setBounds(962, 119, 305, 30);
		contentPane.add(txtCnpj);
		txtCnpj.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEmail.setBounds(29, 210, 94, 30);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtEmail.setBounds(117, 210, 415, 30);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTelefone.setBounds(576, 210, 148, 30);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtTelefone.setBounds(687, 210, 196, 30);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblTelefone_1 = new JLabel("Telefone 2:");
		lblTelefone_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTelefone_1.setBounds(931, 210, 148, 30);
		contentPane.add(lblTelefone_1);
		
		txtTelefone2 = new JTextField();
		txtTelefone2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtTelefone2.setColumns(10);
		txtTelefone2.setBounds(1073, 210, 196, 30);
		contentPane.add(txtTelefone2);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCep.setBounds(29, 309, 94, 30);
		contentPane.add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtCep.setColumns(10);
		txtCep.setBounds(90, 309, 210, 30);
		contentPane.add(txtCep);
		
		txtRua = new JTextField();
		txtRua.setEditable(false);
		txtRua.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtRua.setColumns(10);
		txtRua.setBounds(485, 310, 452, 30);
		contentPane.add(txtRua);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblRua.setBounds(429, 309, 148, 30);
		contentPane.add(lblRua);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNmero.setBounds(1030, 309, 148, 30);
		contentPane.add(lblNmero);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtNumero.setColumns(10);
		txtNumero.setBounds(1136, 310, 131, 30);
		contentPane.add(txtNumero);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblComplemento.setBounds(29, 404, 210, 30);
		contentPane.add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(200, 404, 452, 30);
		contentPane.add(txtComplemento);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblBairro.setBounds(741, 404, 148, 30);
		contentPane.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setEditable(false);
		txtBairro.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtBairro.setColumns(10);
		txtBairro.setBounds(833, 404, 434, 30);
		contentPane.add(txtBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCidade.setBounds(29, 486, 210, 30);
		contentPane.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setEditable(false);
		txtCidade.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtCidade.setColumns(10);
		txtCidade.setBounds(125, 486, 452, 30);
		contentPane.add(txtCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEstado.setBounds(683, 486, 100, 30);
		contentPane.add(lblEstado);
		
		JLabel lblSobre = new JLabel("Sobre:");
		lblSobre.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSobre.setBounds(29, 566, 210, 30);
		contentPane.add(lblSobre);
		
		JTextArea txtSobre = new JTextArea();
		txtSobre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtSobre.setBounds(117, 566, 1223, 152);
		contentPane.add(txtSobre);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(772, 486, 86, 31);
		contentPane.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Cadastro novoCad = new Cadastro();
				novoCad.setId(cadastro.getId());
				String nome = txtNome.getText();
				novoCad.setNome(nome);
				String cnpj = txtCnpj.getText();
				novoCad.setCnpj(cnpj);
				String email = txtEmail.getText();
				novoCad.setEmail(email);
				String telefone = txtTelefone.getText();
				novoCad.setTelefone(telefone);
				String telefone2 = txtTelefone2.getText();
				novoCad.setTelefone2(telefone2);
				String cep = txtCep.getText();
				novoCad.setCep(cep);
				String rua = txtRua.getText();
				novoCad.setRua(rua);
				String numero = txtNumero.getText();
				novoCad.setNumero(numero);
				String bairro = txtBairro.getText();
				novoCad.setBairro(bairro);
				String cidade = txtCidade.getText();
				novoCad.setCidade(cidade);
				String estado = textField.getText();
				novoCad.setEstado(estado);
				String sobre = txtSobre.getText();
				novoCad.setSobre(sobre);
				try {
					BdCadastro ca = new BdCadastro();
					if(ca.novoCadastro(novoCad) != false)
					{
						JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso");
						cadastro = new Cadastro();
						cadastro = novoCad;
					}
					
					else
					{
						JOptionPane.showMessageDialog(null, "ERRO\nOcorreu algum erro, tente novamente!");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
						
						
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnSalvar.setBounds(1162, 11, 178, 54);
		contentPane.add(btnSalvar);
	}
	
	
	
	
	
	//  jhsdvoibdsv
	//vkjdsbvlkjbdsv
	// dvdsvsdvdsv
	//dsvdsvsdv
	//dhfvdojbv
	///fdshflds
	//fdsfugsdpof
	
	
	
	public FormPizzaria1(Cadastro ca) {
		cadastro = ca;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, ScreenSize.getScreenWidth(), ScreenSize.getScreenHeight());
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovoCadastro = new JLabel("Alterar Cadastro");
		lblNovoCadastro.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNovoCadastro.setBounds(29, 11, 270, 47);
		contentPane.add(lblNovoCadastro);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNome.setBounds(29, 119, 106, 31);
		contentPane.add(lblNome);
		
		txtNome = new JTextField(cadastro.getNome());
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtNome.setBounds(108, 120, 616, 30);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCnpj.setBounds(896, 122, 100, 25);
		contentPane.add(lblCnpj);
		
		txtCnpj = new JTextField(cadastro.getCnpj());
		txtCnpj.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtCnpj.setBounds(962, 119, 305, 30);
		contentPane.add(txtCnpj);
		txtCnpj.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEmail.setBounds(29, 210, 94, 30);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField(cadastro.getEmail());
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtEmail.setBounds(117, 210, 415, 30);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTelefone.setBounds(576, 210, 148, 30);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField(cadastro.getTelefone());
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtTelefone.setBounds(687, 210, 196, 30);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblTelefone_1 = new JLabel("Telefone 2:");
		lblTelefone_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTelefone_1.setBounds(931, 210, 148, 30);
		contentPane.add(lblTelefone_1);
		
		txtTelefone2 = new JTextField(cadastro.getTelefone2());
		txtTelefone2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtTelefone2.setColumns(10);
		txtTelefone2.setBounds(1073, 210, 196, 30);
		contentPane.add(txtTelefone2);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCep.setBounds(29, 309, 94, 30);
		contentPane.add(lblCep);
		
		txtCep = new JTextField(cadastro.getCep());
		txtCep.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtCep.setColumns(10);
		txtCep.setBounds(90, 309, 210, 30);
		contentPane.add(txtCep);
		
		txtRua = new JTextField(cadastro.getRua());
		txtRua.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtRua.setEditable(false);
		txtRua.setColumns(10);
		txtRua.setBounds(485, 310, 452, 30);
		contentPane.add(txtRua);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblRua.setBounds(429, 309, 148, 30);
		contentPane.add(lblRua);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNmero.setBounds(1030, 309, 148, 30);
		contentPane.add(lblNmero);
		
		txtNumero = new JTextField(cadastro.getNumero());
		txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtNumero.setColumns(10);
		txtNumero.setBounds(1136, 310, 131, 30);
		contentPane.add(txtNumero);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblComplemento.setBounds(29, 404, 210, 30);
		contentPane.add(lblComplemento);
		
		txtComplemento = new JTextField(cadastro.getCompl());
		txtComplemento.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(200, 404, 452, 30);
		contentPane.add(txtComplemento);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblBairro.setBounds(741, 404, 148, 30);
		contentPane.add(lblBairro);
		
		txtBairro = new JTextField(cadastro.getBairro());
		txtBairro.setEditable(false);
		txtBairro.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtBairro.setColumns(10);
		txtBairro.setBounds(833, 404, 434, 30);
		contentPane.add(txtBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCidade.setBounds(29, 486, 210, 30);
		contentPane.add(lblCidade);
		
		txtCidade = new JTextField(cadastro.getCidade());
		txtCidade.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtCidade.setColumns(10);
		txtCidade.setEditable(false);
		txtCidade.setBounds(125, 486, 452, 30);
		contentPane.add(txtCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEstado.setBounds(683, 486, 100, 30);
		contentPane.add(lblEstado);
		
		JLabel lblSobre = new JLabel("Sobre:");
		lblSobre.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSobre.setBounds(29, 566, 210, 30);
		contentPane.add(lblSobre);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textArea.setBounds(117, 566, 1223, 152);
		contentPane.add(textArea);
		

		textField = new JTextField(cadastro.getEstado());
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setBounds(772, 486, 86, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Cadastro novoCad = new Cadastro();
				novoCad.setId(cadastro.getId());
				String nome = txtNome.getText();
				novoCad.setNome(nome);
				String cnpj = txtCnpj.getText();
				novoCad.setCnpj(cnpj);
				String email = txtEmail.getText();
				novoCad.setEmail(email);
				String telefone = txtTelefone.getText();
				novoCad.setTelefone(telefone);
				String telefone2 = txtTelefone2.getText();
				novoCad.setTelefone2(telefone2);
				String cep = txtCep.getText();
				novoCad.setCep(cep);
				String rua = txtRua.getText();
				novoCad.setRua(rua);
				String numero = txtNumero.getText();
				novoCad.setNumero(numero);
				String bairro = txtBairro.getText();
				novoCad.setBairro(bairro);
				String cidade = txtCidade.getText();
				novoCad.setCidade(cidade);
				String estado = textField.getText();
				novoCad.setEstado(estado);
				String sobre = textArea.getText();
				novoCad.setSobre(sobre);
				try {
					BdCadastro ca = new BdCadastro();
					if(ca.updateCadastro(novoCad) != false)
					{
						JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");
						cadastro = new Cadastro();
						cadastro = novoCad;
						dispose();
					}
					
					else
					{
						JOptionPane.showMessageDialog(null, "ERRO\nOcorreu algum erro, tente novamente!");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnSalvar.setBounds(1162, 11, 178, 54);
		contentPane.add(btnSalvar);
	}
}