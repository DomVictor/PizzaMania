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
	
	public void PegaCadastro() throws SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			Login lo = new Login();
			String cocores = "select c.id_cadastro, c.nome, c.cpf_cnpj, "
					+ "c.id_img, c.email, c.sobre, c.telefone, c.telefone_2, "
					+ "c.ativo, e.cep, e.numero, x.logradouro, x.bairro, x.cidade, x.uf "
					+ "from cadastro c join endereco e "
					+ "on c.id_endereco = e.id_endereco "
					+ "join tabelacep x on x.cep = e.cep "
					+ "where c.id_cadastro = " + lo.getCadastro();
			conn = ConnectionFactory.getConnection();
			System.out.println(cocores);
			stmt = conn.prepareStatement(cocores);
			rs = stmt.executeQuery();

				Cadastro Cadastro = new Cadastro();
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
	
	public boolean updateCadastro(Cadastro cad) throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;
		Statement statement2 = null;
		
		String insert = "UPDATE CADASTRO SET "
				+ "NOME = '" + cad.getNome() + "', "
				+ "CPF_CNPJ = " + cad.getCnpj() + ", "
				+ "EMAIL = '" + cad.getEmail() + "', "
				+ "SOBRE = '" + cad.getSobre() + "', "
				+ "TELEFONE = " + cad.getTelefone() + ", "
				+ "TELEFONE_2 = " + cad.getTelefone2() + ", "
				+ "ID_ENDERECO = SEQ_ENDERECO.CURRVAL, "
				+ "ATIVO = 1 "
				+ "WHERE ID_CADASTRO = " + cad.getId(); 
		
				String insert2 = 
				" INSERT INTO ENDERECO (ID_ENDERECO, CEP, NUMERO, COMPLEMENTO, REFERENCIA, ATIVO) VALUES("
				+ "SEQ_ENDERECO.NEXTVAL, '"
				+ cad.getCep() + "', '"
				+ cad.getNumero() + "', '"
				+ cad.getCompl() + "', '"
				+ cad.getRefe() + "', "
				+ "'1')";

		try {
			dbConnection = ConnectionFactory.getConnection();
			statement = dbConnection.createStatement();
			statement2 = dbConnection.createStatement();

			System.out.println(insert);
			statement.executeUpdate(insert2);
			statement.close();
			statement2.executeUpdate(insert);
			System.out.println("Record inserted!");
			return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
				statement.close();
				dbConnection.close();
				statement2.close();
		}
		return false;
	}


}
