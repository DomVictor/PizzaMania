package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import control.Cadastro;
import control.Login;

public class LoginDAO 
{
	public Cadastro ListLogin(String usuario, String senha) throws SQLException
	{
		
		// Just to test GitHub
		
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;

			try
			{	
				stmt = conn.prepareStatement("Select u.usuario, u.senha, u.privilegio, u.id_cadastro"
						+ " from  usuario u where u.usuario = '" + usuario + "' and u.senha = '" + senha+"'");
				rs = stmt.executeQuery();
				Login login = new Login();
				Cadastro cadastro = new Cadastro();
				
				while(rs.next())
				{
					if(rs.getString("USUARIO") == null){
							JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos! Tente novamente.");
							return null;
					}
					else {
					login.setUsuario(rs.getString("USUARIO"));
					login.setSenha(rs.getString("SENHA"));
					login.setNivel(Integer.valueOf(rs.getString("PRIVILEGIO")));
					login.setCadastro(Integer.valueOf(rs.getString("ID_CADASTRO")));
					}
				}
			
				if (login.getUsuario() != null)
				{
					stmt.close();
					stmt = conn.prepareStatement("SELECT C.ID_CADASTRO, C.CPF_CNPJ, I.ID_IMG, C.NOME, C.EMAIL, C.SOBRE, C.TELEFONE, E.CEP, C.TELEFONE_2, CE.LOGRADOURO, E.NUMERO, E.COMPLEMENTO, CE.BAIRRO,  E.REFERENCIA, CE.CIDADE, CE.UF, E.LAT, E.LNG, AVG(A.NOTA)AS NOTA "
		                    + "FROM CADASTRO C "
		                    + "INNER JOIN ENDERECO E "
		                    + "ON E.ID_ENDERECO = C.ID_ENDERECO "
		                    + "INNER JOIN AVALIACAO A "
		                    + "ON A.ID_CADASTRO = C.ID_CADASTRO "
		                    + "INNER JOIN TABELACEP CE "
		                    + "ON E.CEP = CE.CEP "
		                    + "INNER JOIN IMAGEM I "
		                    + "ON I.ID_IMG = C.ID_IMG "
		                    + "WHERE C.ATIVO = 1 AND C.ID_CADASTRO =' "
		                    + login.getCadastro() + "' "
		                    + "GROUP BY C.ID_CADASTRO, C.CPF_CNPJ, I.ID_IMG, C.NOME, E.CEP, C.EMAIL, C.SOBRE, C.TELEFONE, C.TELEFONE_2, CE.LOGRADOURO, E.NUMERO, E.COMPLEMENTO, CE.BAIRRO,  E.REFERENCIA, CE.CIDADE, CE.UF, E.LAT, E.LNG"
);
					rs = stmt.executeQuery();
					while(rs.next())
					{
						cadastro.setBairro(rs.getString("BAIRRO"));
						cadastro.setCep(rs.getString("CEP"));
						cadastro.setCidade(rs.getString("CIDADE"));
						cadastro.setCnpj(rs.getString("CPF_CNPJ"));
						cadastro.setCompl(rs.getString("COMPLEMENTO"));
						cadastro.setEmail(rs.getString("EMAIL"));
						cadastro.setLat(rs.getBoolean("LAT"));
						cadastro.setEstado(rs.getString("UF"));
						cadastro.setId(rs.getInt("ID_CADASTRO"));
						cadastro.setId_img(rs.getInt("ID_IMG"));
						cadastro.setLng(rs.getBoolean("LNG"));
						cadastro.setNome(rs.getString("NOME"));
						cadastro.setNota(rs.getDouble("NOTA"));
						cadastro.setNumero(rs.getString("NUMERO"));
						cadastro.setRefe(rs.getString("REFERENCIA"));
						cadastro.setRua(rs.getString("LOGRADOURO"));
						cadastro.setTelefone(rs.getString("TELEFONE"));
						cadastro.setSobre(rs.getString("SOBRE"));
						cadastro.setTelefone2(rs.getString("TELEFONE_2"));
					}
					return cadastro;
				}
				
			}
			catch(SQLException e)
			{
				Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, e);
			}
			finally
			{
				ConnectionFactory.closeConnection(conn, stmt, rs);
			}
			return null;
			
		}
		
}
