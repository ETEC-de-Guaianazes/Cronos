/*
 *  Classe responsável pelo cadastro de
 *  Clientes
 */
package Banco;

import java.sql.*;
import javax.swing.DefaultListModel;

/*
 * Classe responsável pela interação
 * nível 2 <==> database
 */
// Declarações públicas
public class CadFuncionario {

    private String codigoEndereco, codigoFuncionario;
    private Conexao con = new Conexao();
    private Statement meustate;
    private ResultSet resultset;

    public CadFuncionario() {
    }//Fim do construtor

    public int CadastraEndereco(String queri) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate(queri);
            System.out.println("Cadastro de endereço efetuado.");
            return 0;
        } catch (SQLException erro) {
            System.out.println("Não foi possível cadastrar endereço.");
            erro.printStackTrace();
            return 1;
        }
    }

    public String pegaCodigoEndereco() {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_endereco_funcionario");
            resultset.last();
            codigoEndereco = resultset.getString("cod_endereco");
            System.out.println("Código do endereço obtido com sucesso.");
        } catch (SQLException erro) {
            System.out.println("Erro ao obter código do endereço para cadastro de cliente.");
            erro.printStackTrace();
        }
        return codigoEndereco;
    }

    public String getCodigoEndereco(String cod) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_funcionario WHERE cod_funcionario=" + cod);
            resultset.next();
            codigoEndereco = resultset.getString("cod_endereco");
            System.out.println("Código do endereço via funcionario obtido com sucesso.");
        } catch (SQLException erro) {
            System.out.println("Erro ao obter código do endereço via funcionario.");
            erro.printStackTrace();
        }
        return codigoEndereco;
    }//Fim getCodigoEndereco()

    public int excluirEndereco(String cod) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("DELETE FROM tbl_endereco_funcionario WHERE cod_endereco=" + cod);
            System.out.println("Endereço de funcionario excluído com sucesso.");
            return 0;
        } catch (SQLException e) {
            System.out.println("Não foi possível excluir endereço de funcionario.");
            e.printStackTrace();
            return 1;
        }
    }//Fim excluirEndereco()

    public int cadastraFuncionario(String queri) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate(queri);
            System.out.println("Cadastro de funcionário efetuado.");
            return 0;
        } catch (SQLException erro) {
            System.out.println("Problemas ao efetuar o cadastro de funcionário.");
            erro.printStackTrace();
            return 1;
        }
    }//cadastraFuncionario

    public int alteraFuncionario(String queri) {
        try {
            meustate = Conexao.con.createStatement();
            meustate.executeUpdate(queri);
            System.out.println("Alteração de funcionário efetuada.");
            return 0;
        } catch (SQLException erro) {
            System.out.println("Problemas ao efetuar a alteração de funcionário.");
            erro.printStackTrace();
            return 1;
        }
    }//alteraFuncionario

    public int alteraEndereco(String queri) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate(queri);
            System.out.println("Alteração de endereço de funcionário efetuada.");
            return 0;
        } catch (SQLException erro) {
            System.out.println("Problemas ao efetuar a alteração de endereço de funcionário.");
            erro.printStackTrace();
            return 1;
        }
    }//alteraEndereco()

    public String pegaCodigoFuncionario() {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_funcionario");
            resultset.last();
            codigoFuncionario = resultset.getString("cod_funcionario");
            System.out.println("Código do funcionário obtido com sucesso.");
        } catch (SQLException erro) {
            System.out.println("Erro ao obter código do funcionário para cadastro de telefone.");
            erro.printStackTrace();
        }
        return codigoFuncionario;
    }

    public String CodigoFuncionario(String cpf) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_funcionario where cpf = '" + cpf + "'");
            resultset.next();
            codigoFuncionario = resultset.getString("cod_funcionario");
            System.out.println("Código do funcionário obtido com sucesso.");
        } catch (SQLException erro) {
            System.out.println("Erro ao obter código do funcionário para cadastro de telefone.");
            erro.printStackTrace();
        }
        return codigoFuncionario;
    }

    //--------------- Telefone do cliente ------------------------------------------
    public int cadastraTelefone(String cod, String telefone, String tipo) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("INSERT INTO tbl_telefone_func(COD_FUNCIONARIO,TELEFONE,TIPO_TELEFONE)VALUES(" + cod + ",'" + telefone + "','" + tipo + "')");
            System.out.println("Cadastro de telefone efetuado.");
            return 0;
        } catch (SQLException erro) {
            System.out.println("Não foi possível efetuar o cadastro de telefone.");
            erro.printStackTrace();
            return 1;
        }
    }//Fim cadastraTelefone()

    public int excluirTelefone(String cod) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("DELETE FROM tbl_telefone_func WHERE cod_funcionario=" + cod);
            System.out.println("Telefone de cliente excluído com sucesso.");
            return 0;
        } catch (SQLException e) {
            System.out.println("Não foi possível excluir telefone de funcionario.");
            e.printStackTrace();
            return 1;
        }
    }//Fim excluirTelefone()

    public void selecionarTelefones(String cod, DefaultListModel listaTelefone, DefaultListModel listaTipo) {
        con.Conecta();
        listaTelefone.removeAllElements();
        listaTipo.removeAllElements();
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_telefone_func WHERE cod_funcionario=" + cod + "");
            while (resultset.next()) {
                listaTelefone.addElement(resultset.getString("telefone"));
                listaTipo.addElement(resultset.getString("tipo_telefone"));
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao carregar telefones na lista");
            erro.printStackTrace();
        }
        con.Fecha();
    }//selecionarTelefones()

    public int excluirFuncionario(String cod) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("DELETE FROM tbl_funcionario WHERE cod_funcionario=" + cod);
            System.out.println("funcionario excluído com sucesso.");
            return 0;
        } catch (SQLException e) {
            System.out.println("Não foi possível excluir funcionario.");
            e.printStackTrace();
            return 1;
        }
    }//excluiFuncionario

    public String getLastCodigoFuncionario() {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT cod_funcionario FROM tbl_funcionario");
            resultset.last();
            codigoFuncionario = resultset.getString("cod_funcionario");
            System.out.println("Código do cliente obtido com sucesso.");
        } catch (SQLException erro) {
            System.out.println("Erro ao obter código do cliente para cadastro de telefone.");
            erro.printStackTrace();
        }
        return codigoFuncionario;
    }//Fim getLastCodigoCliente()

    public boolean possuiVendas(String cod) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_venda WHERE cod_funcionario=" + cod + "");
            if (resultset.next() == true) {
                return true;
            } else {
                return false;
            }            
        } catch (SQLException erro) {
            erro.printStackTrace();
            return false;
        }
    }//Fim possuiVendas()

    public boolean possuiCompras(String cod) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_compra WHERE cod_funcionario=" + cod + "");
            if (resultset.next() == true) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
            return false;
        }
    }//Fim possuiCompras()

    public boolean possuiCaixa(String cod) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_caixa WHERE cod_funcionario=" + cod + "");
            if (resultset.next() == true) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
            return false;
        }
    }//Fim possuiCaixa()

    public boolean possuiEntrada(String cod) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_entrada WHERE cod_funcionario=" + cod + "");
            if (resultset.next() == true) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
            return false;
        }
    }//Fim possuiCaixa()

    public boolean possuiSaida(String cod) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_saida WHERE cod_funcionario=" + cod + "");
            if (resultset.next() == true) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
            return false;
        }
    }//Fim possuiCaixa()

    public String pegaLogin(String codFunc){
        String loginFunc="";
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_funcionario WHERE cod_funcionario=" + codFunc);
            resultset.next();
            loginFunc = resultset.getString("login");
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return loginFunc;
    }//Fim pegaLogin()

    public String pegaSenha(String codFunc){
        String senhaFunc="";
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_funcionario WHERE cod_funcionario=" + codFunc);
            resultset.next();
            senhaFunc = resultset.getString("senha");
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return senhaFunc;
    }//Fim pegaSenha()

}//Fim da classe CadCliente

