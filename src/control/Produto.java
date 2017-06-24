package control;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.UsuarioDAO;

public class Produto {
	private  int id_produto;
	private  int id_cadastro;
	private  int id_img;
	private  Image img;
	private  int id_categ;
	private  String nome;
	private  String descricao;
	private  double preco;

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public int getId_cadastro() {
		return id_cadastro;
	}

	public void setId_cadastro(int id_cadastro) {
		this.id_cadastro = id_cadastro;
	}

	public int getId_img() {
		return id_img;
	}

	public void setId_img(int id_img) {
		this.id_img = id_img;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public int getId_categ() {
		return id_categ;
	}

	public void setId_categ(int id_categ) {
		this.id_categ = id_categ;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	

	


	
}
