package view;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import control.Avaliacao;
import control.Cadastro;
import control.Produto;
import methods.ScreenSize;
import model.BdCadastro;
import model.LoginDAO;
import model.UsuarioDAO;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.AbstractTableModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class FormUsuario extends JFrame {

	private static JPanel contentPane;
	Cadastro cadastro = new Cadastro();
	Produto produto = new Produto();

	PainelPrincipal_Usuario PainelPrincipal_Usuario = new PainelPrincipal_Usuario();
	PanelProdutos panelProdutos = new PanelProdutos();
	Painel2 painel2 = new Painel2();
	PanelCadastroView_Usuario PanelCadastroView_Usuario = new PanelCadastroView_Usuario();
	PanelCadastroEdit_Usuario PanelCadastroEdit_Usuario = new PanelCadastroEdit_Usuario();
	Panel4 panel4 = new Panel4();
	Panel5 panel5 = new Panel5();
	 
	final static String PPU = "Painel Principal";
	final static String A = "Avaliações";
	final static String MP = "Meus Produtos";
	final static String C = "Meu Cadastro";
	final static String NL = "Nem Lembro";
	final static String CE = "Cadastro Edit";
	
	private JTextField txtCnpj;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtTelefone2;
	private JTextField txtCep;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtNome;
	private JTextArea txaSobre;
	private JTable table;
	private JTable table_1;
	public static String lblxNome;
	private JTextField txtEstado;

	ArrayList<Produto> listap;
	ArrayList<Produto> produtoa = new ArrayList<Produto>();
	
	public TableModel AtualizaTabelaProdutos(){
		UsuarioDAO usuario = new UsuarioDAO();
		listap = new ArrayList<Produto>();
		listap = usuario.RetornaProdutos(cadastro.getId(), 1);
		List<String[]> lista = new ArrayList<>();
		String[] colunas = {"ID", "NOME", "CATEGORIA", "PRECO"};
		Produto produto = new Produto();
		for(int i = 0; i < listap.size(); i++){
			produto = listap.get(i);
			lista.add(new String[]{String.valueOf(produto.getId_produto()), String.valueOf(produto.getNome()), String.valueOf(produto.getId_categ()), "R$ " + String.valueOf(produto.getPreco())});
		}
		DefaultTableModel model = new DefaultTableModel(lista.toArray(new String[lista.size()][]), colunas);
		return model;		
	}
	public  TableModel AtualizaTabelaAvaliacao(){
		UsuarioDAO usuario = new UsuarioDAO();
		ArrayList<Avaliacao> listap = usuario.RetornaAvaliacao(cadastro.getId());
		List<String[]> lista = new ArrayList<>();
		String[] colunas = {"ID", "NOTA", "EMAIL", "AVALIACAO"};
		Avaliacao avaliacao = new Avaliacao();
		for(int i = 0; i < listap.size(); i++){
			avaliacao = listap.get(i);
			lista.add(new String[]{String.valueOf(avaliacao.getIdAvaliacao()), String.valueOf(avaliacao.getNota()), 
			String.valueOf(avaliacao.getEmail()), String.valueOf(avaliacao.getAvaliacao())});
		}
		DefaultTableModel model = new DefaultTableModel(lista.toArray(new String[lista.size()][]), colunas);
		return model;		
	}
	
	
	public String getLblxNome() {
		return lblxNome;
	}


	public static void setLblxNome(String lblxNome) {
		FormUsuario.lblxNome = lblxNome;
	}
	

	private void selectedPanel(String g){
		 CardLayout cl = (CardLayout)(contentPane.getLayout());
		    cl.show(contentPane, g);
	}
	
	public FormUsuario(Cadastro cad){
		cadastro = cad;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(0, 0, ScreenSize.getScreenWidth(), ScreenSize.getScreenHeight());

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnAvaliacoes = new JButton("Avaliações");
		btnAvaliacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedPanel(PPU);
			}
		});
		menuBar.add(btnAvaliacoes);
		
		JButton btnProdutos = new JButton("Meus Produtos");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedPanel(A);
			}
		});
		menuBar.add(btnProdutos);
		
		JButton btnCadastro = new JButton("Meu Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedPanel(C);
			}
		});
		menuBar.add(btnCadastro);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		contentPane.add(PainelPrincipal_Usuario, PPU);
		
		JLabel lblNomeA = new JLabel("Nome Pizzaria - Avalia\u00E7\u00F5es");
		lblNomeA.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNomeA.setBounds(10, 11, 982, 31);
		PainelPrincipal_Usuario.add(lblNomeA);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 101, 810, 549);
		PainelPrincipal_Usuario.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(AtualizaTabelaAvaliacao());
		scrollPane_1.setViewportView(table);
		
		
		
		JLabel lblAvaliaoGeral = new JLabel("Avalia\u00E7\u00E3o Geral: 4,7");
		lblAvaliaoGeral.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAvaliaoGeral.setBounds(1157, 12, 233, 22);
		PainelPrincipal_Usuario.add(lblAvaliaoGeral);
		
		JLabel lblNewLabel = new JLabel("Filtrar:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 76, 70, 14);
		PainelPrincipal_Usuario.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mais recentes", "Mais altas", "Mais baixas"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(57, 74, 111, 20);
		PainelPrincipal_Usuario.add(comboBox);
		
		JButton btnNewButton = new JButton("Responder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(1052, 611, 134, 39);
		PainelPrincipal_Usuario.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(830, 101, 500, 499);
		PainelPrincipal_Usuario.add(panel_1);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(1196, 611, 134, 39);
		PainelPrincipal_Usuario.add(btnNewButton_1);
		contentPane.add(panelProdutos, A);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblProdutos.setBounds(10, 11, 178, 32);
		panelProdutos.add(lblProdutos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 1066, 545);
		panelProdutos.add(scrollPane);
		
		table_1 = new JTable();
		table_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				produto.setId_produto((int) table_1.getValueAt(table_1.getSelectedRow(), 0));
			}
			
		});
		table_1.setModel(AtualizaTabelaProdutos());
		scrollPane.setViewportView(table_1);
		
		
		
		JButton button = new JButton("Alterar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UsuarioDAO ud = new UsuarioDAO();
				produtoa = ud.RetornaProdutos(cadastro.getId(), 0);
				FormProduto pr = new FormProduto(produto, produtoa);
				pr.setExtendedState(MAXIMIZED_BOTH);
				pr.setVisible(true);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 25));
		button.setBounds(1135, 127, 157, 53);
		panelProdutos.add(button);
		
		JButton button_1 = new JButton("Excluir");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_1.setBounds(1135, 272, 157, 53);
		panelProdutos.add(button_1);
		
		JButton button_2 = new JButton("Novo");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_2.setBounds(1135, 422, 157, 53);
		panelProdutos.add(button_2);
		
		JLabel lblFiltrar = new JLabel("Filtrar:");
		lblFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFiltrar.setBounds(16, 85, 81, 22);
		panelProdutos.add(lblFiltrar);
		
		JLabel lblId = new JLabel("");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblId.setBounds(904, 91, 81, 32);
		panelProdutos.add(lblId);
		
		JLabel lblNome = new JLabel("");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(900, 154, 120, 26);
		panelProdutos.add(lblNome);
		
		JLabel lblCategoria = new JLabel("");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCategoria.setBounds(946, 205, 120, 32);
		panelProdutos.add(lblCategoria);
		
		JLabel lblPreco = new JLabel("");
		lblPreco.setBounds(946, 285, 120, 32);
		panelProdutos.add(lblPreco);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(72, 85, 112, 24);
		panelProdutos.add(comboBox_1);
		contentPane.add(painel2, MP);
		contentPane.add(PanelCadastroView_Usuario, C);
		contentPane.add(PanelCadastroEdit_Usuario, CE);
		contentPane.add(panel4, NL);
		
		// 	-------------------------------------------
		// -----------------------------------------------
		// -------------------------------------------------
		// ---------------------------------------------------
		// ----------------------------------------------------
		// Panel Cadastro View Conteúdo
		JLabel lblNomePizzaria = new JLabel(lblxNome);
		lblNomePizzaria.setText(cadastro.getNome());
		lblNomePizzaria.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNomePizzaria.setBounds(273, 11, 739, 25);
		PanelCadastroView_Usuario.add(lblNomePizzaria);
		
		JLabel lblCnpj = new JLabel("Cnpj: " + cadastro.getCnpj());
		
		lblCnpj.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblCnpj.setBounds(304, 47, 268, 21);
		PanelCadastroView_Usuario.add(lblCnpj);
		
		JLabel lblEmail = new JLabel("E-mail: " + cadastro.getEmail());
		lblEmail.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblEmail.setBounds(304, 79, 268, 21);
		PanelCadastroView_Usuario.add(lblEmail);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 153));
		panel.setBounds(10, 11, 212, 214);
		PanelCadastroView_Usuario.add(panel);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEndereco.setBounds(34, 254, 150, 20);
		PanelCadastroView_Usuario.add(lblEndereco);
		
		JLabel lblRua = new JLabel("Rua: " + cadastro.getRua() + "N°: " + cadastro.getNumero() + " Bairro: " + cadastro.getBairro() + ".");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRua.setBounds(63, 285, 529, 20);
		PanelCadastroView_Usuario.add(lblRua);
		
		JLabel lblNumero = new JLabel("CEP: " + cadastro.getCep());
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumero.setBounds(63, 378, 151, 20);
		PanelCadastroView_Usuario.add(lblNumero);
		
		JLabel lblBairro = new JLabel("Complemento: " + cadastro.getCompl() + ". Referencia: " + cadastro.getRefe() + ".");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBairro.setBounds(63, 316, 529, 20);
		PanelCadastroView_Usuario.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade: " + cadastro.getCidade() + " Estado: " + cadastro.getEstado());
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCidade.setBounds(63, 347, 529, 20);
		PanelCadastroView_Usuario.add(lblCidade);
		
		JLabel lblSobre = new JLabel("Sobre sua pizzaria ");
		lblSobre.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSobre.setBounds(34, 433, 161, 21);
		PanelCadastroView_Usuario.add(lblSobre);
		
		JLabel lblTelefone = new JLabel("Telefone: " + cadastro.getTelefone());
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefone.setBounds(304, 111, 268, 20);
		PanelCadastroView_Usuario.add(lblTelefone);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText(cadastro.getNome());
				txtCnpj.setText(cadastro.getCnpj());
				txtEmail.setText(cadastro.getEmail());
				txtRua.setText(cadastro.getRua());
				txtBairro.setText(cadastro.getBairro());
				txtCidade.setText(cadastro.getCidade());
				txtEstado.setText(cadastro.getEstado());
				txtTelefone.setText(cadastro.getTelefone());
				txtTelefone2.setText(cadastro.getTelefone2());
				txtCep.setText(cadastro.getCep());
				txaSobre.setText(cadastro.getSobre());
				
				selectedPanel(CE);
				
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEditar.setBounds(1145, 616, 170, 46);
		PanelCadastroView_Usuario.add(btnEditar);
		
		JLabel label = new JLabel("Telefone 2: " + cadastro.getTelefone2());
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(304, 142, 268, 20);
		PanelCadastroView_Usuario.add(label);
		
		JLabel label_1 = new JLabel(cadastro.getSobre());
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(63, 465, 529, 198);
		PanelCadastroView_Usuario.add(label_1);
		
		JLabel label_2 = new JLabel("Nota: " + cadastro.getNota() + " estrelas.");
		label_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		label_2.setBounds(304, 173, 268, 21);
		PanelCadastroView_Usuario.add(label_2);
		
		
		// Panel Cadastro Edit Conteúdo
		JLabel lblNomePizzariaE = new JLabel("Nome: ");
		lblNomePizzariaE.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNomePizzariaE.setBounds(146, 21, 739, 25);
		PanelCadastroEdit_Usuario.add(lblNomePizzariaE);
		
		JLabel lblCnpjE = new JLabel("Cnpj: ");
		lblCnpjE.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblCnpjE.setBounds(150, 70, 100, 20);
		PanelCadastroEdit_Usuario.add(lblCnpjE);
		
		JLabel lblEmailE = new JLabel("E-mail:");
		lblEmailE.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblEmailE.setBounds(150, 110, 100, 20);
		PanelCadastroEdit_Usuario.add(lblEmailE);
		
		JPanel FotoPerfilE = new JPanel();
		FotoPerfilE.setBackground(new Color(0, 102, 153));
		FotoPerfilE.setBounds(6, 6, 130, 128);
		PanelCadastroEdit_Usuario.add(FotoPerfilE);
		
		JLabel lblEnderecoE = new JLabel("Endere\u00E7o:");
		lblEnderecoE.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEnderecoE.setBounds(6, 200, 150, 20);
		PanelCadastroEdit_Usuario.add(lblEnderecoE);
		
		JLabel lblRuaE = new JLabel("Rua:");
		lblRuaE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRuaE.setBounds(253, 255, 50, 20);
		PanelCadastroEdit_Usuario.add(lblRuaE);
		
		JLabel lblNumeroE = new JLabel("N\u00FAmero:");
		lblNumeroE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumeroE.setBounds(706, 255, 70, 20);
		PanelCadastroEdit_Usuario.add(lblNumeroE);
		
		JLabel lblCepE = new JLabel("CEP:");
		lblCepE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCepE.setBounds(6, 260, 46, 14);
		PanelCadastroEdit_Usuario.add(lblCepE);
		
		JLabel lblBairroE = new JLabel("Bairro:");
		lblBairroE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBairroE.setBounds(952, 255, 108, 20);
		PanelCadastroEdit_Usuario.add(lblBairroE);
		
		JLabel lblCidadeE = new JLabel("Cidade:");
		lblCidadeE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCidadeE.setBounds(6, 300, 94, 20);
		PanelCadastroEdit_Usuario.add(lblCidadeE);
		
		JLabel lblEstadoE = new JLabel("Estado:");
		lblEstadoE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEstadoE.setBounds(390, 300, 70, 20);
		PanelCadastroEdit_Usuario.add(lblEstadoE);
		
		JLabel lblSobreE = new JLabel("Sobre:");
		lblSobreE.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSobreE.setBounds(6, 404, 108, 25);
		PanelCadastroEdit_Usuario.add(lblSobreE);
		
		JLabel lblTelefoneE = new JLabel("Telefone:");
		lblTelefoneE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefoneE.setBounds(875, 76, 70, 20);
		PanelCadastroEdit_Usuario.add(lblTelefoneE);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
				String estado = txtEstado.getText();
				novoCad.setEstado(estado);
				String sobre = txaSobre.getText();
				novoCad.setSobre(sobre);
				try {
					BdCadastro ca = new BdCadastro();
					if(ca.updateCadastro(novoCad) != false)
					{
						JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");
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
				
				selectedPanel(C);
				
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSalvar.setBounds(1160, 601, 170, 46);
		PanelCadastroEdit_Usuario.add(btnSalvar);
		
		txtCnpj = new JTextField();
		txtCnpj.setEditable(false);
		txtCnpj.setBounds(195, 70, 298, 20);
		PanelCadastroEdit_Usuario.add(txtCnpj);
		txtCnpj.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(205, 110, 354, 20);
		PanelCadastroEdit_Usuario.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(949, 76, 274, 20);
		PanelCadastroEdit_Usuario.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblTelefone2E = new JLabel("Telefone 2:");
		lblTelefone2E.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefone2E.setBounds(875, 116, 85, 20);
		PanelCadastroEdit_Usuario.add(lblTelefone2E);
		
		txtTelefone2 = new JTextField();
		txtTelefone2.setBounds(970, 116, 253, 20);
		PanelCadastroEdit_Usuario.add(txtTelefone2);
		txtTelefone2.setColumns(10);
		
		txtCep = new JTextField();
		txtCep.setBounds(50, 257, 155, 20);
		PanelCadastroEdit_Usuario.add(txtCep);
		txtCep.setColumns(10);
		
		txtRua = new JTextField();
		txtRua.setEditable(false);
		txtRua.setBounds(293, 257, 359, 20);
		PanelCadastroEdit_Usuario.add(txtRua);
		txtRua.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(778, 257, 100, 20);
		PanelCadastroEdit_Usuario.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setEditable(false);
		txtBairro.setBounds(1007, 257, 298, 20);
		PanelCadastroEdit_Usuario.add(txtBairro);
		txtBairro.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setEditable(false);
		txtCidade.setBounds(67, 302, 253, 20);
		PanelCadastroEdit_Usuario.add(txtCidade);
		txtCidade.setColumns(10);
		
		txaSobre = new JTextArea();
		txaSobre.setBounds(6, 440, 1300, 137);
		PanelCadastroEdit_Usuario.add(txaSobre);
		
		txtNome = new JTextField();
		txtNome.setBounds(217, 21, 728, 26);
		PanelCadastroEdit_Usuario.add(txtNome);
		txtNome.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(450, 302, 46, 20);
		PanelCadastroEdit_Usuario.add(txtEstado);
		
	}
}
