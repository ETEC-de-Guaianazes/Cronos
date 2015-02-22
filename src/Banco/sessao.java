package Banco;

public class sessao {

    private int codigoFunc;
    private String loginFunc,nomeFunc;
    private boolean Direitos;
    private boolean caixaaberto;

    public sessao(){}//Fim construtor

    public void iniciar(int cod_Funcionario, String login_funcionario, String nome_funcionario, boolean direitos){
        caixaaberto = false;
        codigoFunc = cod_Funcionario;
        loginFunc = login_funcionario;
        nomeFunc = nome_funcionario;
        Direitos = direitos;
    }//Fim iniciar

    public int getCodigoFuncionario(){
        return codigoFunc;
    }

    public String getLoginFuncionario(){
        return loginFunc;
    }

    public String getnomeFuncionario(){
        return nomeFunc;
    }

    public boolean getDireito(){
        return Direitos;
    }

    public boolean getCaixaaberto(){
        return caixaaberto;
    }

    public void CaixaA(){
        caixaaberto = true;
    }

    public void CaixaF(){
        caixaaberto = false;
    }

    public void sair(){
        codigoFunc = 0;
        loginFunc = "";
        nomeFunc = "";
        Direitos = false;
    }//Fim sair
    
}//Fim classe
