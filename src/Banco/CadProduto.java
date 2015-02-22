package Banco;

import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class CadProduto {
    
    Conexao con = new Conexao();
    private Statement meustate;
    private ResultSet resultset;
    private String codProduto;
    public String[] cpf;
    
    public CadProduto(){
        
    }//Fim construtor

    public int cadastraProduto(String sql){
        try{
            meustate = Conexao.con.createStatement();
            meustate.executeUpdate(sql);
            System.out.println("Cadastro de produto efetuado.");
            con.Fecha();
            return 0;
        }
        catch(SQLException erro){
            System.out.println("Não foi possível efetuar o cadastro de produto.");
            erro.printStackTrace();
            return 1;
        }
    }//Fim cadastraProduto

    public void getListaCombo2(JComboBox combo, DefaultComboBoxModel modelo, String sql){
        con.Conecta();
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery(sql);
            modelo.removeAllElements();
            modelo.addElement("Todas");
            while(resultset.next()){
                modelo.addElement(resultset.getString(2));
            }
        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro na obtenção da lista.");
            erro.printStackTrace();
        }
        con.Fecha();
        combo.setModel(modelo);
    }

    public int excluiProduto(String sql){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate(sql);
            System.out.println("Exclusão de produto efetuada.");
            return 0;

        }
        catch(SQLException erro){
            System.out.println("Não foi possível efetuar a exclusão do produto.");
            erro.printStackTrace();
            return 1;
        }
    }

    public int alteraProduto(String sql){
        try{
            meustate = Conexao.con.createStatement();
            meustate.executeUpdate(sql);
            System.out.println("Alteração de produto efetuada.");
            return 0;
        }
        catch(SQLException erro){
            System.out.println("Não foi possível efetuar a alteração do produto.");
            erro.printStackTrace();
            return 1;
        }
    }

    public String getCodigoProduto(String nome_produto){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_produto WHERE nome_produto LIKE '"+nome_produto+"'");
            resultset.next();
            codProduto = resultset.getString("cod_produto");
            System.out.println("Código do produto obtido com sucesso.");
        }
        catch(SQLException erro){
            System.out.println("Erro ao obter código do produto.");
            erro.printStackTrace();
        }
        return codProduto;
    }//Fim getCodigoProduto

    public void getListaCombo(JComboBox combo, DefaultComboBoxModel modelo, String sql){
        con.Conecta();
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery(sql);
            modelo.removeAllElements();
            if(resultset.next()==true){
                resultset = meustate.executeQuery(sql);
                while(resultset.next()){
                    modelo.addElement(resultset.getString(2));
                    //(resultset.getString(5));
                }
            }
            else{
                modelo.addElement("Inexistente");
            }
        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro na obtenção da lista.");
            erro.printStackTrace();
        }
        con.Fecha();
        combo.setModel(modelo);
    }

    public String getCodigoFabricante(String fabricante){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_fabricante WHERE fabricante LIKE '"+fabricante+"'");
            resultset.next();
            codProduto = resultset.getString("cod_fabricante");
            System.out.println("Código do fabricante obtido com sucesso.");
        }
        catch(SQLException erro){
            System.out.println("Erro ao obter código do fabricante.");
            erro.printStackTrace();
        }
        return codProduto;
    }//Fim getCodigoFabricante()

    public String getCodigoCategoria(String categoria){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_categoria WHERE categoria LIKE '"+categoria+"'");
            resultset.next();
            codProduto = resultset.getString("cod_categoria");
            System.out.println("Código da categoria obtido com sucesso.");
        }
        catch(SQLException erro){
            System.out.println("Erro ao obter código da categoria.");
            erro.printStackTrace();
        }
        return codProduto;
    }//Fim getCodigoCategoria()

    public String getCodigoFornecedor(String fornecedor){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_fornecedor WHERE nome_fornecedor LIKE '"+fornecedor+"'");
            resultset.next();
            codProduto = resultset.getString("cod_fornecedor");
            System.out.println("Código de fornecedor obtido com sucesso.");
        }
        catch(SQLException erro){
            System.out.println("Erro ao obter código do fornecedor.");
            erro.printStackTrace();
        }
        return codProduto;
    }//Fim getCodigoCategoria()
}//Fim classe