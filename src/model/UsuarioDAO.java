package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import control.Avaliacao;
import control.Login;
import control.Produto;

public class UsuarioDAO 

{
	public static void FormLoad()
	{	
	}
	public ArrayList<Produto> RetornaProdutos(int id_cadastro){
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Produto> lista = new ArrayList<Produto>();
		
		try {
			Login Login = new Login();
			stmt = conn.prepareStatement("select * from produto where id_cadastro = " + id_cadastro);
			rs = stmt.executeQuery();
			Produto produto = new Produto();
			while(rs.next()){
				produto = new Produto();
				produto.setId_produto(rs.getInt("ID_PRODUTO"));
				produto.setId_cadastro(rs.getInt("ID_CADASTRO"));
				produto.setId_categ(rs.getInt("ID_CATEG"));
				produto.setDescricao(rs.getString("DESCRICAO"));
				produto.setNome(rs.getString("NOME"));
				produto.setPreco(rs.getDouble("PRECO"));
				produto.setId_img(rs.getInt("ID_IMG"));			
				lista.add(produto);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lista;
	}
	
	public ArrayList<Avaliacao> RetornaAvaliacao(int id){
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Avaliacao> lista = new ArrayList<Avaliacao>();
		
		try {
			stmt = conn.prepareStatement("select * from avaliacao where id_cadastro = " + id);
			rs = stmt.executeQuery();
			Avaliacao avaliacao = new Avaliacao();
			while(rs.next()){
				avaliacao = new Avaliacao();
				avaliacao.setIdAvaliacao(rs.getInt("ID_AVALIACAO"));
				avaliacao.setIdCadastro(rs.getInt("ID_CADASTRO"));
				avaliacao.setEmail(rs.getString("EMAIL"));
				avaliacao.setAvaliacao(rs.getString("AVAL"));
				avaliacao.setDataAvaliacao(rs.getDate("DATA_AVAL"));
				avaliacao.setNota(rs.getString("NOTA"));	
				lista.add(avaliacao);
			}
			
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
