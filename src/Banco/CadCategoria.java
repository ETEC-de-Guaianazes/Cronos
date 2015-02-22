package Banco;

import java.sql.*;

public class CadCategoria {

   private String codigoCategoria;
    private Statement meustate;
    private ResultSet resultset;

   public CadCategoria() {
        
    }//Fim do construtor

   public int cadastraCategoria(String categoria){
       try{
           meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           meustate.executeUpdate(categoria);
           System.out.println("Cadastro de categoria efetuado.");
           return 0;
       }
       catch(SQLException erro){
           System.out.println("Não foi possível cadastrar categoria.");
           erro.printStackTrace();
           return 1;
       }
   }//Fim cadastraCategoria

   public int alteraCategoria(String altera){
       try{
           meustate = Conexao.con.createStatement();
           int r = meustate.executeUpdate(altera);
           if(r==1){
               System.out.println("Alteração de categoria efetuada.");
           }
           return 0;
       }
       catch(SQLException erro){
           System.out.println("Não foi possível alterar categoria.");
           erro.printStackTrace();
           return 1;
       }
   }

   public int excluiCategoria(String exclui){
       try{
           meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           meustate.executeUpdate(exclui);
           System.out.println("Exclusão de categoria efetuada.");
           return 0;
       }
       catch(SQLException erro){           
           System.out.println("Não foi possível excluir a categoria.");
           erro.printStackTrace();
           return 1;
       }
   }

   public String getUltimoCodigoCategoria(){
       try{
           meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           resultset = meustate.executeQuery("SELECT cod_categoria FROM tbl_categoria");
           resultset.last();
           codigoCategoria = resultset.getString("cod_categoria");
           System.out.println("Código da categoria obtido com sucesso.");           
       }
       catch(SQLException erro){
           System.out.println("Erro ao obter código da categoria.");
           erro.printStackTrace();
       }
       return codigoCategoria;
   }//Fim getUltimoCodigoCategoria()

   public String getCodigoCategoria(String categoria){
       try{
           meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           resultset = meustate.executeQuery("SELECT cod_categoria FROM tbl_categoria WHERE categoria LIKE '"+categoria+"'");
           codigoCategoria = resultset.getString("cod_categoria");
           System.out.println("Código da categoria obtido com sucesso.");           
       }
       catch(SQLException erro){
           System.out.println("Erro ao obter código da categoria.");
           erro.printStackTrace();        
       }
       return codigoCategoria;
   }//Fim getCodigoCategoria()

   public boolean possuiProdutos(String nome_categoria){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT tbl_categoria.cod_categoria, tbl_produto.cod_categoria " +
            "FROM tbl_categoria INNER JOIN tbl_produto ON tbl_categoria.cod_categoria = tbl_produto.cod_categoria " +
                    "WHERE tbl_categoria.categoria LIKE '"+nome_categoria+"'");
            if(resultset.next()==true)
                return true;
            else
                return false;
        }
        catch(SQLException erro){
            System.out.println("Erro verificar por produtos em categoria.");
            erro.printStackTrace();
            return false;
        }
    }//Fim possuiProdutos()

}//Fim classe
