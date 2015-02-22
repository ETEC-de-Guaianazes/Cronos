package Banco;

import java.sql.*;

public class CadServico {

    public Conexao con = new Conexao();
    private Statement meustate;
    private String codServico;
    private ResultSet resultset;

    public CadServico() {
    }//Fim do construtor

    public int cadastraServico(String descricao, String valor, String prazo, String garantia) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("INSERT INTO tbl_servico(DESCRICAO, VALOR, PRAZO, GARANTIA)VALUES('" + descricao + "'," + valor.replaceAll(",",".") + "," + prazo + "," + garantia + ")");
            return 0;
        } catch (SQLException erro) {
            System.out.println("Erro ao efetuar cadastro de servico.\n" + erro);
            return 1;
        }
    }//Fim cadastraServico()

    public String getCodServico() {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT cod_servico FROM tbl_servico");
            resultset.last();
            codServico = resultset.getString("cod_servico");
            System.out.println("Código do serviço obtido com sucesso.");
        } catch (SQLException erro) {
            System.out.println("Erro ao obter código do serviço.\n" + erro);
        }
        return codServico;
    }//Fim getCodServico()

    public String getServico(String servico) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT cod_servico FROM tbl_servico WHERE descricao like '" + servico + "'");
            resultset.next();
            codServico = resultset.getString("cod_servico");
            System.out.println("Código do serviço obtido com sucesso.");
        } catch (SQLException erro) {
            System.out.println("Erro ao obter código do serviço.\n" + erro);
        }
        return codServico;
    }

    public int excluiServico(String cod) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("DELETE FROM tbl_servico WHERE cod_servico=" + cod + "");
            System.out.println("Exclusão de serviço efetuada.");
            return 0;
        } catch (SQLException erro) {
            System.out.println("Não foi possível excluir serviço.");
            return 1;
        }
    }//Fim excluiServico

    public int alteraServico(String cod, String descricao, String valor, String prazo, String garantia) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("UPDATE tbl_servico SET descricao='" + descricao +
                    "', valor=" + valor.replaceAll(",",".") + ", prazo=" + prazo + ", garantia=" + garantia + " WHERE cod_servico=" + cod);
            System.out.println("Alteração de serviço efetuada.");
            return 0;
        } catch (SQLException erro) {
            System.out.println("Não foi possível alterar serviço.\n" + erro);
            return 1;
        }
    }//Fim alteraServico

    public boolean possuiVendas(String servico) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_venda_servico WHERE tbl_venda_servico.cod_servico=" + servico);
            if (resultset.next() == true) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }//Fim possuiVendas()

    public boolean possuiOrcamento(String servico) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM  tbl_orcamento_servico WHERE  tbl_orcamento_servico.cod_Servico=" + servico);
            if (resultset.next() == true) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }//Fim possuiOrcamento()
}//Fim da classe

