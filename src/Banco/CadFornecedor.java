package Banco;

import java.sql.*;

public class CadFornecedor {
    public String codigoContato, codigoFornecedor, codigoEndereco;
    public Integer codendereco,codcontato;
    private Statement meustate;
    private ResultSet resultset;

    public CadFornecedor(){       
    }//Fim construtor

    public int cadastraContato(String contato){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("INSERT INTO tbl_contato (NOME)VALUES('"+contato+"')");
            System.out.println("Cadastro de contato efetuado.");
            return 0;
        }
        catch(SQLException erro){
            System.out.println("Não foi possível cadastrar contato.");
            erro.printStackTrace();
            return 1;
        }
    }//Fim cadastra contato

    public String getCodigoContato(){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT cod_contato FROM tbl_contato");
            resultset.last();
            codigoContato = resultset.getString("cod_contato");
            System.out.println("Código do contato obtido com sucesso.");
        }
        catch(SQLException erro){
            System.out.println("Erro ao obter código do contato para cadastro de fornecedor.");
            erro.printStackTrace();
        }
        return codigoContato;
    }

    public int cadastraTelefone(String cod_contato, String fone){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("INSERT INTO tbl_telefone_cont(COD_CONTATO, TELEFONE)VALUES("+cod_contato+",'"+fone+"')");
            System.out.println("Cadastro de telefone efetuado.");
            return 0;
        }
        catch(SQLException erro){
            System.out.println("Não foi possível cadastrar telefone.");
            erro.printStackTrace();
            return 1;
        }
    }//Fim cadastra telefone

    public int cadastraFornecedor(String nome, String cnpj, String cod_contato, String cod_endereco){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate("INSERT INTO tbl_fornecedor(NOME_FORNECEDOR, CNPJ, COD_CONTATO, COD_ENDERECO)VALUES('"+nome+"','"+cnpj+"',"+cod_contato+","+cod_endereco+")");
            System.out.println("Cadastro de fornecedor efetuado.");
            return 0;
        }
        catch(SQLException erro){
            System.out.println("Não foi possível cadastrar fornecedor.");
            erro.printStackTrace();
            return 1;
        }
    }//Fim cadastra fornecedor

    public String getUltimoCodigoFornecedor(){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM tbl_fornecedor");
            resultset.last();
            codigoFornecedor = resultset.getString("cod_fornecedor");
            System.out.println("Código do fornecedor obtido com sucesso.");
        }
        catch(SQLException erro){
            System.out.println("Erro ao obter código do fornecedor.");
            erro.printStackTrace();
        }
        return codigoFornecedor;
    }//Fim getUltimoCodigoFornecedor()

    public boolean possuiProdutos(String cnpj_fornecedor){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT tbl_fornecedor.cod_fornecedor, tbl_produto.cod_fornecedor " +
                    "FROM tbl_fornecedor INNER JOIN tbl_produto ON tbl_fornecedor.cod_fornecedor = tbl_produto.cod_fornecedor " +
                    "WHERE tbl_fornecedor.cnpj LIKE '"+cnpj_fornecedor+"'");
            if(resultset.next()==true)
                return true;
            else
                return false;
        }
        catch(SQLException erro){
            System.out.println("Erro ao obter código do fornecedor.");
            erro.printStackTrace();
            return false;
        }
    }//Fim possuiProdutos()

    public int CadastraEndereco(String qwery){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            meustate.executeUpdate(qwery);
            System.out.println("Cadastro de endereço efetuado.");
            return 0;
        }
        catch(SQLException erro){
            System.out.println("Não foi possível cadastrar endereço.");
            erro.printStackTrace();
            return 1;
        }
    }//Fim CadastraEndereco()

    public String pegaCodigoEndereco(){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT cod_endereco FROM tbl_endereco_fornecedor");
            resultset.last();
            codigoEndereco = resultset.getString("cod_endereco");
            System.out.println("Código do endereço obtido com sucesso.");
        }
        catch(SQLException erro){
            System.out.println("Erro ao obter código do endereço para cadastro de fornecedor.");
            erro.printStackTrace();
        }
        return codigoEndereco;
    }//Fim pegaCodigoEndereco()

    public int pegaendereco(String CNPJ){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT cod_endereco FROM tbl_fornecedor WHERE CNPJ = '"+CNPJ+"'");
            while (resultset.next()){
                codendereco = resultset.getInt("cod_endereco");
            }
            return 0;
        }
        catch(SQLException erro){
            System.out.println("Não foi possível selecionar endereço para exclusão");
            erro.printStackTrace();
            return 1;
        }
    }//Fim pegaendereco()
    
    public int pegacontato(String CNPJ){
        try{
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT cod_contato FROM tbl_fornecedor WHERE CNPJ = '"+CNPJ+"'");
            while (resultset.next()){
                codcontato = resultset.getInt("cod_contato");
            }
            return 0;
        }
        catch(SQLException erro){
            System.out.println("Não foi possível selecionar endereço para exclusão");
            erro.printStackTrace();
            return 1;
        }
    }//Fim pegacontato()
    
    public int retornacodcontato(){
        //esse método retorna o código de contato, que é usado para carregar a lista de telefones ao sincronizar tabela
        //também é usado para fazer alteração
        return codcontato;
    }//Fim retornacodcontato()
        
    public int excluiendereco(){
        try{
            meustate = Conexao.con.createStatement();
            meustate.executeUpdate("DELETE * FROM tbl_endereco_fornecedor WHERE cod_endereco = "+codendereco);
            System.out.println("Endereço excluído");
            return 0;
        }
        catch(SQLException erro){
            System.out.println("Não foi possível excluir endereço");
            erro.printStackTrace();
            return 1;
        }
    }//Fim excluiendereco()
    
    public int excluirtelefones(){
        try{
            meustate = Conexao.con.createStatement();
            meustate.executeUpdate("DELETE FROM tbl_telefone_cont WHERE cod_contato = "+codcontato);
            System.out.println("Telefones excluídos");
            return 0;
        }
        catch(SQLException erro){
            System.out.println("Não foi possível excluir telefones");
            erro.printStackTrace();
            return 1;
        }
    }//Fim excluirtelefones()
    
    public int excluirfornecedores(){
        try{
            meustate = Conexao.con.createStatement();
            meustate.executeUpdate("DELETE FROM tbl_fornecedor WHERE cod_contato = "+codcontato);
            System.out.println("Fornecedor excluído");
            return 0;
        }
        catch(SQLException erro){
            System.out.println("Não foi possível excluir fornecedor");
            erro.printStackTrace();
            return 1;
        }
    }//Fim excluirfornecedores ()
    
    public int excluicontato(){
        try{
            meustate = Conexao.con.createStatement();
            meustate.executeUpdate("DELETE FROM tbl_contato WHERE cod_contato = "+codcontato);
            System.out.println("Contato excluído");
            return 0;
        }
        catch(SQLException erro){
            System.out.println("Não foi possível excluir contato de fornecedor");
            erro.printStackTrace();
            return 1;
        }
    }//Fim excluicontato()
        
    public int alterarendereco(String rua, String numero, String bairro, String complemento, String cep, String cidade, String estado ){
        try{
            meustate = Conexao.con.createStatement();
            meustate.executeUpdate("UPDATE TBL_ENDERECO_FORNECEDOR SET RUA = '"+rua+"', NUMERO = "+numero+", BAIRRO = '"+bairro+"', COMPLEMENTO = '"+complemento+"', " +
                    "CEP = '"+cep+"', CIDADE = '"+cidade+"', ESTADO = '"+estado+"' WHERE cod_endereco = "+codendereco);
            System.out.println("Endereço alterado");
            return 0;
        }
        catch(SQLException erro){
            System.out.println("Não foi possível alterar endereço");
            erro.printStackTrace();
            return 1;
        }
    }//Fim alterarendereco()
    
    public int alterarfornecedores(String nome, String cnpj){
        try{
            meustate = Conexao.con.createStatement();
            meustate.executeUpdate("UPDATE TBL_FORNECEDOR SET NOME_FORNECEDOR='"+nome+"', CNPJ ='"+cnpj+"'" +
                    "WHERE cod_contato="+codcontato);
            System.out.println("Fornecedor alterado");
            return 0;
        }
        catch(SQLException erro){
            System.out.println("Não foi possível alterar fornecedor");
            erro.printStackTrace();
            return 1;
        }
    }//Fim alterarfornecedores()

    public int alterarcontato(String nomecontato){
        try{
            meustate = Conexao.con.createStatement();
            meustate.executeUpdate("UPDATE TBL_CONTATO SET NOME = '"+nomecontato+"' WHERE cod_contato = "+codcontato);
            System.out.println("Contato alterado");
            return 0;
        }
        catch(SQLException erro){
            System.out.println("Não foi possível alterar contato de fornecedor");
            erro.printStackTrace();
            return 1;
        }
    }//Fim alterarcontato()
}//Fim classe