package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import control.Login;
import control.Produto;

public class UsuarioDAO 

{
	public static void FormLoad()
	{	
	}
	public ArrayList<Produto> RetornaProdutos(){
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Produto> lista = new ArrayList<Produto>();
		
		try {
			stmt = conn.prepareStatement("select * from produto");
			rs = stmt.executeQuery();
			Produto produto = new Produto();
			while(rs.next()){
				produto.setId_produto(rs.getInt("ID_PRODUTO"));
				produto.setId_cadastro(rs.getInt("ID_CADASTRO"));
				produto.setId_categ(rs.getInt("ID_CATEG"));
				produto.setDescricao(rs.getString("DESCRICAO"));
				produto.setNome(rs.getString("NOME"));
				produto.setPreco(rs.getDouble("PRECO"));
				produto.setId_img(rs.getInt("ID_IMG"));				
			}
			JOptionPane.showMessageDialog(null,produto.getNome());
			lista.add(produto);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return lista;
	}
	
	

}
