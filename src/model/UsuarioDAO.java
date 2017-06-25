package model;

import java.awt.Component;
import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

import control.Avaliacao;
import control.Categoria;
import control.Login;
import control.Produto;

public class UsuarioDAO 

{
	Produto produto = new Produto();


	public static void FormLoad()
	{	
	}
	public ArrayList<Produto> RetornaProdutos(int id, int func){
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Produto> lista = new ArrayList<Produto>();
		String lala;
		
		if(func == 1)
		{
			lala = "select * from produto where id_cadastro = " + id + " and ativo = '1'";
		}
		else
		{
			lala = "select * from produto where id_produto = " + id + " and ativo = '1'";
		}
		try {
			stmt = conn.prepareStatement(lala);
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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lista;
	}
	
	public void SalvaProduto(Produto produto1)
	{
		produto = produto1;
		
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String lala;
		Login lo = new Login();
		try
		{
		lala = "insert into produto ("
		+ " id_produto, id_cadastro, nome, descricao, id_categ, preco, ativo)"
		+ " values("
		+ "seq_produto.NEXTVAL, " + produto.getId_cadastro()
		+ ", '" + produto.getNome() + "', '" + produto.getDescricao() + "', " + produto.getId_categ() + ", " + produto.getPreco() + ", 1)";
				System.out.println(lala);
			stmt = conn.prepareStatement(lala);
			stmt.execute();
			JOptionPane.showMessageDialog(null, "Registro salvo");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	}
	
	public ArrayList<Produto> RetornaProduto(int id){
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Produto> lista = new ArrayList<Produto>();
		String lala;
		
		
			lala = "select * from produto where id_produto = " + id + " and ativo = '1'";
		try {
			stmt = conn.prepareStatement(lala);
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
				stmt.close();
				conn.close();
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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lista;
	}
	public void UpdateProduto(Produto produto1) {
		produto = produto1;
		
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String lala;
		
		try
		{
		lala = "Update produto set "
		+ "nome = '" + produto.getNome() + "' "
		+ ", descricao = '" + produto.getDescricao() 
		+ "', preco = " + produto.getPreco() 
		+ ", id_categ = " + produto.getId_categ()
		+ " where id_produto = " + produto.getId_produto() + "";
				
			stmt = conn.prepareStatement(lala);
			stmt.execute();
			JOptionPane.showMessageDialog(null, "Registro alterado");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void ExcluiProduto(Produto produto1) {
		produto = produto1;
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String lala;
		
		try
		{
		lala = "Update produto set "
		+ "ativo = 0"
		+ " where id_produto = " + produto.getId_produto() + "";
				
			stmt = conn.prepareStatement(lala);
			stmt.execute();
			JOptionPane.showMessageDialog(null, "Registro excluído");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public ArrayList<Categoria> pegaCategoria(int cad) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String lala;
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		
		lala = "Select * from categoria where id_cadastro = " + cad + " and ativo = 1 ";
		try {
			stmt = conn.prepareStatement(lala);
			rs = stmt.executeQuery();
			Categoria cat = new Categoria();
			
			while(rs.next()){
				cat.setIdCategoria(Integer.parseInt(rs.getString("id_categ")));
				cat.setNome(rs.getString("nome"));
				lista.add(cat);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lista;
		
	}
}
