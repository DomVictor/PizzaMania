package model;
import java.sql.*;

public class ConexaoOracle2 {
	
	public static void main(String[] args) {
                
        /*
         *	O driver JDBC do Oracle est� dispon�vel no seguinte endere�o:
         *	http://www.oracle.com/technetwork/database/features/jdbc/index-091264.html
         */

        // Configura��o dos par�metros de conex�o
        String server = "localhost";
        String port = "1521";               // Porta TCP padr�o do Oracle
        String database = "xe";

        // Configura��o dos par�metros de autentica��o
        String user = "tcc_pizzamania";
        String passwd = "123456";

        try {
            String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + database;

            // Abre-se a conex�o com o Banco de Dados
            Connection con = DriverManager.getConnection(url, user, passwd);

            // Cria-se Statement com base na conex�o con
            Statement stmt = con.createStatement();

            // Exemplo: cria-se uma tabela no Banco de Dados de Teste
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


