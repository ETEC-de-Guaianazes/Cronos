package Banco;

import java.sql.*;

public class CadFabricante {

   private String codigoFabricante;
   private Statement meustate;
   private ResultSet resultset;

   public CadFabricante() {       
    }//Fim do construtor

   public int cadastraFabricante(String fabricante){
       try{
           meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           meustate.executeUpdate("INSERT INTO tbl_fabricante (FABRICANTE)VALUES('"+fabricante+"')");
           System.out.println("Cadastro de fabricante efetuado.");
           return 0;
       }
       catch(SQLException erro){
           System.out.println("Não foi possível cadastrar fabricante.");
           erro.printStackTrace();
           return 1;
       }
   }//Fim cadastraFabricante

   public String getCodigoUltimoFabricante(){
       try{
           meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           resultset = meustate.executeQuery("SELECT fabricante FROM tbl_fabricante");
           resultset.last();
           codigoFabricante = resultset.getString("cod_fabricante");
           System.out.println("Código de fabricante obtido com sucesso.");

       }
       catch(SQLException erro){
           System.out.println("Erro ao obter código do fabricante.");
           erro.printStackTrace();
       }
       return codigoFabricante;
   }//Fim getCodigoFabricante

   public String getCodigoFabricante(String nome_fabricante){
       try{
           meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           resultset = meustate.executeQuery("SELECT cod_fabricante FROM tbl_fabricante WHERE fabricante LIKE '"+nome_fabricante+"'");
           codigoFabricante = resultset.getString("cod_fabricante");
           System.out.println("Código de fabricante obtido com sucesso.");
       }
       catch(SQLException erro){
           System.out.println("Erro ao obter código do fabricante.");
           erro.printStackTrace();
       }
       return codigoFabricante;
   }

   public int alteraFabricante(String fabricante, String codigo){
       try{
           String s = "UPDATE tbl_fabricante SET FABRICANTE='"+
                   fabricante+"' WHERE cod_fabricante="+codigo+"";
           meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           meustate.executeUpdate(s);
           System.out.println("Alteração de fabricante efetuada.");
           return 0;
       }
       catch(SQLException erro){
           System.out.println("Não foi possível alterar fabricante.");
           erro.printStackTrace();
           return 1;
       }
   }//Fim alteraFabricante

   public int excluirFabricante(String fabricante){
       try{
           meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           meustate.executeUpdate("DELETE FROM tbl_fabricante WHERE fabricante='"+fabricante+"'");
           System.out.println("Exclusão de fabricante efetuado.");
           return 0;
       }
       catch(SQLException erro){
           System.out.println("Não foi possível excluir fabricante.");
           erro.printStackTrace();
           return 1;
       }   
   }//Fim excluirFabricante

   public boolean possuiProdutos(String nome_fabricante){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT tbl_fabricante.cod_fabricante, tbl_produto.cod_fabricante " +
                    "FROM tbl_fabricante INNER JOIN tbl_produto ON tbl_fabricante.cod_fabricante = tbl_produto.cod_fabricante " +
                    "WHERE tbl_fabricante.fabricante LIKE '"+nome_fabricante+"'");
            if(resultset.next()==true)
                return true;
            else
                return false;
        }
        catch(SQLException erro){
            System.out.println("Erro verificar por produtos em fabricante.");
            erro.printStackTrace();
            return false;
        }
    }//Fim possuiProdutos()
}//Fim classe
