package Banco;

import java.text.SimpleDateFormat;
import java.sql.*;

public class CadMovimentacao {

    public SimpleDateFormat sdf;
    public boolean Administrador;
    private String nomeLogin, NomeCompleto, codigoCompra;
    private Conexao con = new Conexao();
    private Statement meustate;
    private ResultSet resultset;
    //Fim declarações

    public void setNomeCompleto(String nomePassado) {
        NomeCompleto = nomePassado;
    }

    public String getNomeCompleto() {
        return NomeCompleto;
    }

    public CadMovimentacao() {
    }//Construtor

    public int cadastraCompra(String valor, String data, String hora, int codF) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("INSERT INTO tbl_compra(VALOR_TOTAL,DATA_COMPRA,HORA," +
                    "COD_FUNCIONARIO)VALUES(" + valor + ",'" + data + "','" + hora + "'," + codF + ")");
            System.out.println("Cadastro de compra efetuado.");
            return 0;
        } catch (SQLException erro) {
            System.out.println("Não foi possível efetuar o cadastro de compra.");
            erro.printStackTrace();
            return 1;
        }
    }//Fim cadastraCompra()

    public String getLastCodigoCompra() {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT cod_compra FROM tbl_compra");
            resultset.last();
            codigoCompra = resultset.getString("cod_compra");
            System.out.println("Código da compra obtido com sucesso.");

        } catch (SQLException erro) {
            System.out.println("Erro ao obter código da compra.");
            erro.printStackTrace();
        }
        return codigoCompra;
    }//Fim getLastCodigoCompra()

    public int cadastraVenda(String valortotal, String data, String hora, String codFuncionario, String codCliente, String codTipoPagamento, String modo_pagamento) {
        //  con.Conecta();
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("INSERT INTO tbl_venda(VALOR_TOTAL,DATA_VENDA,HORA,COD_FUNCIONARIO,COD_CLIENTE,COD_TIPO_PAGAMENTO,MODO_PAGAMENTO)" +
                    "VALUES(" + valortotal + ",'" + data + "','" + hora + "'," + codFuncionario + "," + codCliente + "," + codTipoPagamento + ",'" + modo_pagamento + "')");
            System.out.println("Cadastro de venda efetuado.");
            //     con.Fecha();
            return 0;
        } catch (SQLException erro) {
            System.out.println("Não foi possível efetuar o cadastro de venda.");
            erro.printStackTrace();
            //    con.Fecha();
            return 1;
        }
    }//Fim cadastraVenda

    public int cadastraVendaProduto(String cod_venda, String cod_produto, String quantidade) {
        // con.Conecta();
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("insert into tbl_venda_produto(cod_venda,cod_produto,quantidade)" +
                    "VALUES(" + cod_venda + "," + cod_produto + "," + quantidade + ")");
            System.out.println("Cadastro de venda de produto efetuado.");
            //     con.Fecha();
            return 0;
        } catch (SQLException erro) {
            System.out.println("Não foi possível efetuar o cadastro de venda de produto.");
            erro.printStackTrace();
            //     con.Fecha();
            return 1;
        }
    }//Fim cadastraVendaProduto

    public int cadastraVendaServico(String cod_servico, String cod_venda, String quantidade) {
        // con.Conecta();
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("insert into tbl_venda_servico(cod_servico,cod_venda,quantidade)" +
                    "VALUES(" + cod_servico + "," + cod_venda + "," + quantidade + ")");
            System.out.println("Cadastro de venda de servico efetuado.");
            //    con.Fecha();
            return 0;
        } catch (SQLException erro) {
            System.out.println("Não foi possível efetuar o cadastro de venda de servico.");
            erro.printStackTrace();
            //   con.Fecha();
            return 1;
        }
    }//Fim cadastraVendaProduto

    public int cadastraParcela(String valor, String data_vencimento, String cod_venda, String numero_parcela) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("INSERT INTO tbl_parcela(valor,data_vencimento,cod_venda,numero_parcela)VALUES(" +
                    valor + ",'" + data_vencimento + "'," + cod_venda + "," + numero_parcela + ")");
            System.out.println("Cadastro de parcela efetuado.");
            return 0;
        } catch (SQLException erro) {
            System.out.println("Não foi possível efetuar o cadastro de parcela.");
            erro.printStackTrace();
            return 1;
        }
    }//Fim cadastraParcela()

    public void cadastraTipoPagamento(String valor, String descricao) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("INSERT INTO tbl_tipo_pagamento(VALOR_TOTAL," +
                    "DESCRICAO)VALUES(" + valor + ",'" + descricao + "')");
            System.out.println("Cadastro de tipo de pagamento efetuado.");
        } catch (SQLException erro) {
            System.out.println("Não foi possível efetuar o cadastro de tipo de pagamento.");
            erro.printStackTrace();
        }
    }//fimtipopagamento

    public String getLastCodigoVenda() {
        con.Conecta();
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_venda");
            resultset.last();
            codigoCompra = resultset.getString("cod_venda");
            System.out.println("Codigo da venda obtido com sucesso.");

        } catch (SQLException erro) {
            System.out.println("Erro ao obter código da venda.");
            erro.printStackTrace();
        }
        //con.Fecha();
        return codigoCompra;
    }//Fim getLastCodigoCompra()

    public void cadastraCompraProduto(String compra, String produto, String quant, String estoquei) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("INSERT INTO tbl_compra_produto(COD_COMPRA,COD_PRODUTO,QUANTIDADE)VALUES(" +
                    compra + "," + produto + "," + quant + ")");
            int tot = Integer.parseInt(quant) + Integer.parseInt(estoquei);
            AtualizaCompras(tot, produto);
            System.out.println("Cadastro produto compra efetuado");
        } catch (SQLException erro) {
            System.out.println("Não foi possível efetuar o cadastro produto compra.");
            erro.printStackTrace();
        }

    }//Fim cadastraCompraProduto()

    public void AtualizaCompras(int unidades, String codprod) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("Update tbl_produto SET unidades_em_estoque = " + unidades + " where tbl_produto.cod_produto = " + codprod);
            System.out.println("Atualização de estoque efetuada.");
        } catch (SQLException erro) {
            System.out.println("Não foi possível efetuar a atualização de estoque.");
            erro.printStackTrace();
        }
    }//Fim cadastraCompraProduto()

    public int cadastraOrcamento(String data, String hora, String codCliente, String valortotal) {
        try {
            meustate = Conexao.con.createStatement();
            meustate.executeUpdate("INSERT INTO tbl_orcamento(DATA_ORCAMENTO,HORA_ORCAMENTO,COD_CLIENTE, VALOR_TOTAL)VALUES('" +
                    data + "','" + hora + "'," + codCliente + "," + valortotal + ")");
            System.out.println("Cadastro de orcamento efetuado.");
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Não deu pra cadastrar n tabela orçamento");
            return 1;
        }
    }

    public String getLastCodigoOrcamento() {
        String codigoOrcamento = "";
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT cod_Orcamento FROM tbl_orcamento");
            resultset.last();
            codigoOrcamento = resultset.getString("cod_Orcamento");
            System.out.println("Codigo dao orcamento obtido com sucesso.");

        } catch (SQLException erro) {
            System.out.println("Erro ao obter código do orcamento.");
            erro.printStackTrace();
        }
        return codigoOrcamento;
    }//Fim getLastCodigoOrçamento

    public int cadastraOrcamentoProduto(String codOrcamento, String codProduto, String quantidade) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("INSERT INTO tbl_orcamento_produto(COD_ORCAMENTO,COD_PRODUTO,QUANTIDADE)VALUES(" + codProduto + "," + codOrcamento + "," + quantidade + ")");
            System.out.println("Cadastro de orcamento produto efetuado.");
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }

    public int cadastraOrcamentoServico(String codOrcamento, String codServico, String quantidade) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("INSERT INTO tbl_orcamento_servico(COD_ORCAMENTO,COD_SERVICO,QUANTIDADE)VALUES(" + codServico + "," + codOrcamento + "," + quantidade + ")");
            System.out.println("Cadastro de orcamento servico efetuado.");
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }

    public String getCodigoTipoPagamento(String descricao_pagamento) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_tipo_pagamento WHERE descricao LIKE '" + descricao_pagamento + "'");
            resultset.next();
            descricao_pagamento = resultset.getString("cod_tipo_pagamento");
        } catch (SQLException e) {
            e.printStackTrace();
            descricao_pagamento = "nada";
        }
        return descricao_pagamento;
    }

    public void AtualizaEstoque(int unidades, String codProduto) {
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("Update tbl_produto SET unidades_em_estoque = " + unidades + " where tbl_produto.cod_produto = " + codProduto);
            System.out.println("Atualização de estoque efetuada.");
        } catch (SQLException erro) {
            System.out.println("Não foi possível efetuar a atualização de estoque.");
            erro.printStackTrace();
        }
    }

    public String getQtdeEstoque(String produto) {
        String QtdeEstoque = "";
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_produto where nome_produto like '" + produto + "'");
            resultset.next();
            QtdeEstoque = resultset.getString("unidades_em_estoque");
            System.out.println("unidades_em_estoque obtido com sucesso.");
        } catch (SQLException erro) {
            System.out.println("Erro ao obter unidades_em_estoque.");
            erro.printStackTrace();
        }
        return QtdeEstoque;
    }//Fim getLastCodigoCompra()

//*****************************************PARTE DE CAIXA *****************************
    public void AbreCaixa(String valorinicial, String data, String horaabertura, Integer funcionario) {
        con.Conecta();
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //TODO arrumar
            meustate.executeUpdate("Insert Into tbl_caixa (valor_inicial,valor_final, data_caixa, hora_abertura, cod_funcionario) values (" +
                    valorinicial + "," + valorinicial + ",'" + data + "','" + horaabertura + "', " + funcionario + ")");
            System.out.println("Foi possível inserir os valores");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        con.Fecha();
    }

    public void AtualizaCaixa(double valor, boolean tipo) {
        double valorcaixa;
        con.Conecta();
        if (tipo == true) {
            try {
                meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                resultset = meustate.executeQuery("Select * from tbl_caixa");
                resultset.last();
                valorcaixa = resultset.getDouble("valor_final");
                String Hora = resultset.getString("hora_abertura");
                Hora = Hora.substring(11);
                String dia = resultset.getString("data_caixa");
                dia = dia.substring(0, 10).replaceAll("-", "/");
                double novo = valorcaixa + valor;
                meustate.executeUpdate("UPDATE tbl_caixa SET valor_final = " + novo + " where hora_abertura = '" + Hora + "' and data_caixa = '" + dia + "'");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                resultset = meustate.executeQuery("Select * from tbl_caixa");
                resultset.last();
                valorcaixa = resultset.getDouble("valor_final");
                String Hora = resultset.getString("hora_abertura");
                Hora = Hora.substring(11);
                String dia = resultset.getString("data_caixa");
                dia = dia.substring(0, 10).replaceAll("-", "/");
                double novo = valorcaixa - valor;
                meustate.executeUpdate("UPDATE tbl_caixa SET valor_final = " + novo + " where hora_abertura = '" + Hora + "' and data_caixa = '" + dia + "'");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        con.Fecha();
    }

    public String pegavalorcaixa() {
        String caixa = "";
        con.Conecta();
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("Select * from tbl_caixa");
            resultset.last();
            caixa = resultset.getString("valor_final");
            System.out.println("Foi possível obter o valor");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        con.Fecha();
        return caixa;
    }

    public String pegaorigemEntrada(String entrada) {
        String origem = "";
        con.Conecta();
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("Select * from tbl_origem_entrada where descricao_entrada = '" + entrada + "'");
            resultset.next();
            origem = resultset.getString("cod_origem_entrada");
            System.out.println("Foi possível obter a origem da entrada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        con.Fecha();
        return origem;
    }

    public void cadastraEntrada(String dia, String valor, String origem, int funcionario) {

        con.Conecta();

        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("Insert Into tbl_entrada (data_entrada,valor,cod_origem,cod_funcionario) values ('" + dia + "','" + valor + "'," + origem + ", " + funcionario + ")");
            System.out.println("Cadastro de entrada efetuado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        con.Fecha();
    }

    public String pegaorigemSaida(String saida) {
        String origem = "";
        con.Conecta();
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("Select * from tbl_origem_saida where descricao_saida = '" + saida + "'");
            resultset.next();
            origem = resultset.getString("cod_origem_saida");
            System.out.println("Foi possível obter a origem da saída");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        con.Fecha();
        return origem;
    }

    public void cadastraSaida(String dia, String valor, String origem, int funcionario) {
        con.Conecta();
        try {
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("Insert Into tbl_saida (data_saida,valor,cod_origem,cod_funcionario) values ('" + dia + "','" + valor + "'," + origem + ", " + funcionario + ")");
            System.out.println("Cadastro de saída efetuado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        con.Fecha();
    }
//*********************************fIM DA PARTE DE CAIXA*********************************************8
}//Fim Classe CadMovimentacao()

