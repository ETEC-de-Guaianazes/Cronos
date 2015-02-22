/*
 *  Classe responsável pelo cadastro de
 *  Clientes
 */

package Banco;

import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/*
 * Classe responsável pela interação
 * nível 2 <==> database
 */

public class CadCliente {

    //Declarações públicas
    private String codigoEndereco, codigoCliente;
    private Conexao con = new Conexao();
    private Statement meustate;
    private ResultSet resultset;
    //Fim declarações

    public CadCliente() {
    }//Fim do construtor

//############################# Métodos ########################################
//-------------- Endereco ------------------------------------------------------
    public int CadastraEndereco(String queri){
        try{
                meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		meustate.executeUpdate(queri);
                System.out.println("Cadastro de endereço efetuado.");
                return 0;
	     }

	catch(SQLException erro){
		System.out.println("Não foi possível cadastrar endereço.");
                erro.printStackTrace();
                return 1;
        }
    }//Fim CadastraEndereco()

    public int alteraEndereco(String queri){
        try{
                meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		meustate.executeUpdate(queri);
                System.out.println("Alteração de endereço efetuada.");
                return 0;
	     }

	catch(SQLException erro){
		System.out.println("Não foi possível alterar endereço.");
                erro.printStackTrace();
                return 1;
        }
    }//Fim alteraEndereco()

    public String getLastCodigoEndereco(){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT cod_endereco FROM tbl_endereco_cliente");
            resultset.last();
            codigoEndereco = resultset.getString("cod_endereco");
            System.out.println("Ultimo codigo de endereco de cliente obtido com sucesso.");
        }
        catch(SQLException erro){
            System.out.println("Erro ao obter ultimo codigo de endereco de cliente.");
            erro.printStackTrace();
        }
        return codigoEndereco;
    }//Fim getLastCodigoEndereco()

    public String getCodigoEndereco(String cod){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_cliente WHERE cod_cliente="+cod);
            resultset.next();
            codigoCliente = resultset.getString("cod_cliente");
            System.out.println("Codigo do endereço via cliente obtido com sucesso.");
        }
        catch(SQLException erro){
            System.out.println("Erro ao obter codigo do endereço via cliente.");
            erro.printStackTrace();
        }
        return codigoCliente;
    }//Fim getCodigoEndereco()

    public int excluirEndereco(String cod){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("DELETE FROM tbl_endereco_cliente WHERE cod_endereco="+cod);
            System.out.println("Endereço de cliente excluído com sucesso.");
            return 0;
        }
        catch(SQLException e){
            System.out.println("Não foi possível excluir endereço de cliente.");
            e.printStackTrace();
            return 1;
        }
    }//Fim excluirEndereco()

    //--------------- Cliente ------------------------------------------------------
    public int cadastraCliente(String queri){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate(queri);
            System.out.println("Cadastro de cliente efetuado.");
            return 0;
        }
        catch(SQLException erro){
            System.out.println("Problemas ao efetuar o cadastro de cliente.");
            erro.printStackTrace();
            return 1;
        }
    }//cadastraCliente

    public int alteraCliente(String queri){
        try{
                meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		int r = meustate.executeUpdate(queri);
                if (r==1)
                System.out.println("Alteração de cliente efetuada.");
                return 0;
	     }
        catch(SQLException erro){
            System.out.println("Problemas ao efetuar a alteração de cliente.");
            erro.printStackTrace();
            return 1;
        }
    }//alteraCliente()

    public int excluirCliente(String cod){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("DELETE FROM tbl_cliente WHERE cod_cliente="+cod);
            System.out.println("Cliente excluído com sucesso.");
            return 0;
        }
        catch(SQLException e){
            System.out.println("Não foi possível excluir cliente.");
            e.printStackTrace();
            return 1;
        }
    }//cadastraCliente

    public String getLastCodigoCliente(){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT cod_cliente FROM tbl_cliente");
            while (resultset.next()){
                resultset.last();
                codigoCliente = resultset.getString("cod_cliente");
            }
            System.out.println("Ultimo codigo de cliente obtido com sucesso.");
        }
        catch(SQLException erro){
            System.out.println("Erro ao obter o ultimo codigo de cliente.");
            erro.printStackTrace();
        }
        return codigoCliente;
    }//Fim getLastCodigoCliente()

    public String CodigoCliente(String cpf){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_cliente where CPF = '"+cpf+"'");

            while (resultset.next()){
              codigoCliente = resultset.getString("cod_cliente");
            }
            System.out.println("codigo de cliente obtido com sucesso.");
        }
        catch(SQLException erro){
            System.out.println("Erro ao obter o codigo de cliente.");
            erro.printStackTrace();
        }
        return codigoCliente;
    }//Fim getLastCodigoCliente()


//--------------- Telefone do cliente ------------------------------------------
    public int cadastraTelefone(String cod, String telefone, String tipo){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("INSERT INTO tbl_telefone_cli(COD_CLIENTE,TELEFONE,TIPO_TELEFONE)VALUES("+cod+",'"+telefone+"','"+tipo+"')");
            System.out.println("Cadastro de telefone efetuado.");
            return 0;
	}
	catch(SQLException erro){
            System.out.println("Não foi possível efetuar o cadastro de telefone.");
            erro.printStackTrace();
            return 1;
        }
    }//Fim cadastraTelefone()

    public int excluirTelefone(String cod){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("DELETE FROM tbl_telefone_cli WHERE cod_cliente="+cod);
            System.out.println("Telefone de cliente excluído com sucesso.");
            return 0;
        }
        catch(SQLException e){
            System.out.println("Não foi possível excluir telefone de cliente.");
            e.printStackTrace();
            return 1;
        }
    }//Fim excluirTelefone()

    public void selecionarTelefones(String cod, DefaultListModel listaTelefone, DefaultListModel listaTipo){
       con.Conecta();
       listaTelefone.removeAllElements();
       listaTipo.removeAllElements();
       try{
           meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           resultset = meustate.executeQuery("SELECT * FROM tbl_telefone_cli WHERE cod_cliente="+cod+"");
           while (resultset.next()){
               listaTelefone.addElement(resultset.getString("telefone"));
               listaTipo.addElement(resultset.getString("tipo_telefone"));
           }
       }
       catch(SQLException erro){
           System.out.println("Erro ao carregar telefones na lista");
           erro.printStackTrace();
       }
       con.Fecha();
    }//selecionarTelefones()

    public boolean possuiVendas(String cod){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_venda WHERE cod_cliente="+cod+"");
            if(resultset.next()==true)
                return true;
            else
                return false;
        }
        catch(SQLException erro){
            return false;
        }
    }//Fim possuiVendas()

    public void setListaComboCliente(DefaultComboBoxModel modelo, JComboBox combo,
            JComboBox combocpf, DefaultComboBoxModel modelocpf, JComboBox comboCod,
            DefaultComboBoxModel modeloCod){
        con.Conecta();
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("Select * from tbl_cliente ORDER BY nome");
            modelo.removeAllElements();
            if(resultset.next()==true){
                resultset = meustate.executeQuery("Select * from tbl_cliente ORDER BY nome");
                while(resultset.next()){
                    modelo.addElement(resultset.getString("nome"));
                    modelocpf.addElement(resultset.getString("cpf"));
                    modeloCod.addElement(resultset.getString("cod_cliente"));
                }
            }
            else{
                modelo.addElement("Inexistente");
                modelocpf.addElement("111.111.111-11");
                modeloCod.addElement("-1");
            }
        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro na obtenção da lista.");
            erro.printStackTrace();
        }
        con.Fecha();
        combo.setModel(modelo);
        combocpf.setModel(modelocpf);
        comboCod.setModel(modeloCod);
    }

}//Fim da classe CadCliente
