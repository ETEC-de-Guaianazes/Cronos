package Validacoes;

public class Validacao {

    private String mensagem;

    public Validacao(){        
    }//Construtor

    public void setMensagem(String msg){
        mensagem = msg;
    }//Fim setMensagem

    //Valida Nome
    public boolean validaNome(String nome){
        if (nome.length()>2 && isNumeric(nome)==false)
         return true;
        else{
         return false;}
    }//Fim validaNome

    public boolean validaEmail(String email){
        if (email.length()>=5)
            return true;
        else
            return false;
    }//Fim validaEmail

    //Função IsNumeric
    public boolean isNumeric(String texto){
        try {
            Integer.parseInt(texto);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }//Fim isNumeric

    //Função IsNumeric
    public boolean isDouble(String texto){
        try {
            Double.parseDouble(texto);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }//Fim isDouble

    //Valida telefone
    public boolean validaTelefone(String telefone){
        if(telefone.length()>7){
            return true;
        }
        else{
            return false;
        }
    }//Fim validatelefone

    //Valida numero (endereço)
    public boolean validaNumero(String numero){
        numero = numero.replaceAll(" ", "");
        if (isNumeric(numero)==true && numero.length()>=1){
            return true;
        }
        else
            return false;
    }//Fim valida numero

/*----------------- Valida CPF/CNPJ ----------------------------------------------
 * ;) walew galera do
      http://www.forumweb.com.br/foruns/index.php?/topic/17293-metodo-valida-cpf-ou-cnpj/
 */

    public boolean valida_Cpf(String cpf){
        //------- Rotina para CPF
        cpf = cpf.replace('.', ' ');
        cpf = cpf.replace('-',' ');
        cpf = cpf.replaceAll(" ","");
        if (cpf.length() == 11 ){
            int     d1, d2;
            int     digito1, digito2, resto;
            int     digitoCPF;
            String  nDigResult;
            d1 = d2 = 0;
            digito1 = digito2 = resto = 0;
            for (int n_Count = 1; n_Count < cpf.length() -1; n_Count++){
                digitoCPF = Integer.valueOf (cpf.substring(n_Count -1, n_Count)).intValue();
                //--------- Multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.
                d1 = d1 + ( 11 - n_Count ) * digitoCPF;
                //--------- Para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.
                d2 = d2 + ( 12 - n_Count ) * digitoCPF;
            }
            //--------- Primeiro resto da divisão por 11.
            resto = (d1 % 11);
            //--------- Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
            if (resto < 2)
                digito1 = 0;
            else
              digito1 = 11 - resto;
            d2 += 2 * digito1;
            //--------- Segundo resto da divisão por 11.
            resto = (d2 % 11);
            //--------- Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
            if (resto < 2)
                digito2 = 0;
            else
                digito2 = 11 - resto;
            //--------- Digito verificador do CPF que está sendo validado.
            String nDigVerific = cpf.substring (cpf.length()-2, cpf.length());
            //--------- Concatenando o primeiro resto com o segundo.
            nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
            //--------- Comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
            return nDigVerific.equals(nDigResult);
        }        
        else
            return false;
    }//Fim validaCpf
    
    /*----------------- Valida CNPJ ------------------------------------------*/
    public boolean validaCnpj(String cnpj){
        cnpj = cnpj.replace('.', ' ');
        cnpj = cnpj.replace('-',' ');
        cnpj = cnpj.replaceAll(" ","");
        cnpj = cnpj.replaceAll("/","");
        if (cnpj.length() == 14){
            int soma = 0, dig;
            String cnpj_calc = cnpj.substring(0,12);
            char[] chr_cnpj = cnpj.toCharArray();
            //--------- Primeira parte
            for( int i = 0; i < 4; i++ )
                if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )
                    soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
            for( int i = 0; i < 8; i++ )
                if ( chr_cnpj[i+4]-48 >=0 && chr_cnpj[i+4]-48 <=9 )
                    soma += (chr_cnpj[i+4] - 48) * (10 - (i + 1));
            dig = 11 - (soma % 11);
            cnpj_calc += ( dig == 10 || dig == 11 ) ?
                "0" : Integer.toString(dig);
            //--------- Segunda parte
            soma = 0;
            for ( int i = 0; i < 5; i++ )
                if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )
                    soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
            for ( int i = 0; i < 8; i++ )
                if ( chr_cnpj[i+5]-48 >=0 && chr_cnpj[i+5]-48 <=9 )
                    soma += (chr_cnpj[i+5] - 48) * (10 - (i + 1));
            dig = 11 - (soma % 11);
            cnpj_calc += ( dig == 10 || dig == 11 ) ?
                "0" : Integer.toString(dig);
            return cnpj.equals(cnpj_calc);
        }
        else
            return false;
    }//Fim valida CNPJ
    
    //------------- REMOVE ACENTUAÇÃO -------------------------
    public String semAcento(String passa){
      passa = passa.replaceAll("[ÂÀÁÄÃ]","A");
      passa = passa.replaceAll("[âãàáä]","a");
      passa = passa.replaceAll("[ÊÈÉË]","E");
      passa = passa.replaceAll("[êèéë]","e");
      passa = passa.replaceAll("ÎÍÌÏ","I");
      passa = passa.replaceAll("îíìï","i");
      passa = passa.replaceAll("[ÔÕÒÓÖ]","O");
      passa = passa.replaceAll("[ôõòóö]","o");
      passa = passa.replaceAll("[ÛÙÚÜ]","U");
      passa = passa.replaceAll("[ûúùü]","u");
      passa = passa.replaceAll("Ç","C");
      passa = passa.replaceAll("ç","c");
      passa = passa.replaceAll("[ýÿ]","y");
      passa = passa.replaceAll("Ý","Y");
      passa = passa.replaceAll("ñ","n");
      passa = passa.replaceAll("Ñ","N");
      passa = passa.replaceAll("[´`~^'<>\\|/]","");
      return passa;
   }//Fim semAcento()
    
    //------------ MOSTRA MENSAGEM ----------------------------
    public String getMensagem(){
        return mensagem;
    }//Fim getMensagem

}//Fim da classe
