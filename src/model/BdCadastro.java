package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import control.Cadastro;
import control.Login;
import view.FormLogin;

public class BdCadastro {
	
	public static void PegaCadastro() throws SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			String cocores = "select c.id_cadastro, c.nome, c.cpf_cnpj, "
					+ "c.id_img, c.email, c.sobre, c.telefone, c.telefone_2, "
					+ "c.ativo, e.cep, e.numero, x.logradouro, x.bairro, x.cidade, x.uf "
					+ "from cadastro c join endereco e "
					+ "on c.id_endereco = e.id_endereco "
					+ "join tabelacep x on x.cep = e.cep "
					+ "where c.id_cadastro = " + Login.getCadastro();
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(cocores);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				Cadastro.setBairro(rs.getString("bairro"));
				Cadastro.setCep(rs.getString("cep"));
				Cadastro.setCidade(rs.getString("cidade"));
				Cadastro.setNome(rs.getString("nome"));
				Cadastro.setCnpj(rs.getString("cpf_cnpj"));
				Cadastro.setEmail(rs.getString("email"));
				Cadastro.setEstado(rs.getString("uf"));
				Cadastro.setNumero(rs.getString("numero"));
				Cadastro.setRua(rs.getString("logradouro"));
				Cadastro.setSobre(rs.getString("sobre"));
				Cadastro.setTelefone(rs.getString("telefone"));
				Cadastro.setTelefone2(rs.getString("telefone_2"));
				Cadastro.setForm();
				
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();

		} 
		finally
		{
			try 
			{
				ConnectionFactory.closeConnection(conn, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void updateCadastro() throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;

		String insert = "UPDATE CADASTRO SET "
				+ "NOME = '" + Cadastro.getNome() + "', "
				+ "CPF_CNPJ = " + Cadastro.getCnpj() + ", "
				+ "EMAIL = '" + Cadastro.getEmail() + "', "
				+ "SOBRE = '" + Cadastro.getSobre() + "', "
				+ "TELEFONE = " + Cadastro.getTelefone() + ", "
				+ "TELEFONE_2 = " + Cadastro.getTelefone2() + ", "
				+ "ATIVO = '1' "
				+ "WHERE ID_CADASTRO = " + Login.getCadastro(); 
		
				String insert2 = 
				" UPDATE ENDERECO SET"
				+ " CEP = " + Cadastro.getCep()
				+ ", NUMERO = " + Cadastro.getNumero()
				+ " WHERE ID_ENDERECO = " + Login.getIdEnd();

		try {
			dbConnection = ConnectionFactory.getConnection();
			statement = dbConnection.createStatement();

			System.out.println(insert);
			statement.executeUpdate(insert);
			statement.executeUpdate(insert2);
			System.out.println("Record inserted!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {
			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		
	}


}
