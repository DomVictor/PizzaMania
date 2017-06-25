package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.Cadastro;
import model.LoginDAO;

public class FormLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	public static String cadastro;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin frame = new FormLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
		
	public FormLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(300, 250, 363, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio:");
		lblNewLabel.setBounds(10, 78, 115, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setBounds(22, 123, 67, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(99, 75, 238, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
			
		txtSenha = new JPasswordField();
		txtSenha.setToolTipText("");
		txtSenha.setBounds(99, 117, 238, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					if(txtUsuario.getText().equals(null) || txtSenha.getText().equals(null))
					{
						JOptionPane.showMessageDialog(null, "Usuario ou Senha não preenchidos! Tente novamente.");
					}
					else
					{
					LoginDAO ld = new LoginDAO();
					Cadastro cadastro = new Cadastro();
					cadastro = ld.ListLogin(txtUsuario.getText(), txtSenha.getText());
						if(cadastro != null)
						{
							if(cadastro.getNivel() == 2)
							{
							FormUsuario usu = new FormUsuario(cadastro);
							usu.setVisible(true);
							usu.setExtendedState(MAXIMIZED_BOTH);
							}
							else
							{
							FormAdm adm = new FormAdm();
							adm.setVisible(true);
							adm.setExtendedState(MAXIMIZED_BOTH);
							}
						}
						else 
						{
							JOptionPane.showMessageDialog(null, "Verifique o usuário e a senha");
						}
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		);
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEntrar.setBounds(245, 162, 96, 32);
		contentPane.add(btnEntrar);
	}
}