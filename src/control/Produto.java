package control;

import java.awt.Image;

public class Produto {
	private static int id_produto;
	private static int id_cadastro;
	private static int id_img;
	private static Image img;
	private static int id_categ;
	private static String nome;
	private static String descricao;
	private static double preco;
	
	
	public static int getId_produto() {
		return id_produto;
	}
	public static void setId_produto(int id_produto) {
		Produto.id_produto = id_produto;
	}
	public static int getId_cadastro() {
		return id_cadastro;
	}
	public static void setId_cadastro(int id_cadastro) {
		Produto.id_cadastro = id_cadastro;
	}
	public static int getId_img() {
		return id_img;
	}
	public static void setId_img(int id_img) {
		Produto.id_img = id_img;
	}
	public static Image getImg() {
		return img;
	}
	public static void setImg(Image img) {
		Produto.img = img;
	}
	public static int getId_categ() {
		return id_categ;
	}
	public static void setId_categ(int id_categ) {
		Produto.id_categ = id_categ;
	}
	public static String getNome() {
		return nome;
	}
	public static void setNome(String nome) {
		Produto.nome = nome;
	}
	public static String getDescricao() {
		return descricao;
	}
	public static void setDescricao(String descricao) {
		Produto.descricao = descricao;
	}
	public static double getPreco() {
		return preco;
	}
	public static void setPreco(double preco) {
		Produto.preco = preco;
	}

	
}
