package control;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.UsuarioDAO;

public class Avaliacao 
{	
	private static int idAvaliacao;
	private static String email;
	private static String avaliacao;
	private static Date dataAvaliacao;
	private static String nota;
	private static int idCadastro;
	
	public static TableModel AtualizaTabelaAvaliacao(){
		UsuarioDAO usuario = new UsuarioDAO();
		ArrayList<Avaliacao> listap = usuario.RetornaAvaliacao();
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
	
	public static int getIdAvaliacao() {
		return idAvaliacao;
	}
	public static void setIdAvaliacao(int idAvaliacao) {
		Avaliacao.idAvaliacao = idAvaliacao;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		Avaliacao.email = email;
	}
	public static String getAvaliacao() {
		return avaliacao;
	}
	public static void setAvaliacao(String avaliacao) {
		Avaliacao.avaliacao = avaliacao;
	}
	public static Date getDataAvaliacao() {
		return dataAvaliacao;
	}
	public static void setDataAvaliacao(Date dataAvaliacao) {
		Avaliacao.dataAvaliacao = dataAvaliacao;
	}
	public static String getNota() {
		return nota;
	}
	public static void setNota(String nota) {
		Avaliacao.nota = nota;
	}
	public static int getIdCadastro() {
		return idCadastro;
	}
	public static void setIdCadastro(int idCadastro) {
		Avaliacao.idCadastro = idCadastro;
	}
	

}
