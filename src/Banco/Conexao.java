// Pacote responsável pela comunicação com o Banco de dados
package Banco;

import java.sql.*;
import org.apache.derby.database.*;
import org.apache.derby.impl.db.BasicDatabase;

public class Conexao {

    //cria uma conexao chamada con
    public static Connection con;
    private Database dt = new BasicDatabase();

    //metodo construtor da classe Conexao
    public Conexao() {
    }//Fim conexao

    //metodo responsavel para se conectar ao bd
    public void Conecta() {
        try {
            //para carregar o driver
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            //jdbc - e o driver da sun responsavel pela conexao
            //Odbc - driver do microsoft access(varia de acordo com o bd usado)

            //estabelece uma conexao
            //con = DriverManager.getConnection("jdbc:odbc:BD");
            String url = "jdbc:derby:baseDados";
            con = DriverManager.getConnection(url, "cronos", "alphablend");
            System.out.println("Conexão realizada com sucesso.");
        } catch (SQLException ex) {
            System.out.println("Problemas na conexão com o banco de dados.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver JDBC-ODBC não encontrado");
        }
    }//Fim Conecta()

    public void Fecha() {
        try {
            //fecha a conexao
            con.close();
            System.out.println("Conexao finalizada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Problemas na conexão.");
        }
    }//Fim Fecha()

    public int backUpDatabase() throws SQLException {
        try {
            String sqlstmt = "CALL SYSCS_UTIL.SYSCS_BACKUP_DATABASE(?)";
            CallableStatement cs = con.prepareCall(sqlstmt);
            cs.setString(1, "C:/cronosBackup/");
            cs.execute();
            cs.close();
            return 0;
        } catch (Exception e) {
            System.out.println("Erro ao efetuar backup");
            return 1;
        }
    }

    public int restaurarDatabase() throws SQLException {
        String url = "";
        int erros =0;
        Fecha();
        try {
            url = "jdbc:derby:baseDados;user=cronos;password=alphablend;shutdown=true";
            con = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Problemas no desligamento do database.\n" + ex);
        }
        try {
            url = "jdbc:derby:baseDados;restoreFrom=C:/cronosBackup/baseDados";
            con = DriverManager.getConnection(url, "cronos", "alphablend");
            System.out.println("Restauraçao realizada com sucesso.");
            erros += 0;
        } catch (SQLException e) {
            System.out.println("Problemas na restauração.\n" + e);
            erros += 1;
        }
        return erros;
    }
}//Fim classe

