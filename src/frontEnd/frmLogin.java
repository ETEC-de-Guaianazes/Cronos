package frontEnd;

import Banco.Conexao;
import Banco.sessao;
import java.sql.*;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class frmLogin extends javax.swing.JFrame {

    private Comum cmm = new Comum();
    private sessao SessaoLogin = new sessao();
    private Conexao con = new Conexao();
    private Statement meustate;
    private ResultSet resultset;
    public sessao Sessao = new sessao();
    private int Careto=0;

    /** Creates new form frmLogin */
    public frmLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        txtLogin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        ckAdm = new javax.swing.JCheckBox();
        btnCancelar = new javax.swing.JButton();
        btnLogar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cronos - Login");
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        painel.setLayout(null);

        txtLogin.setText("ALPHA");
        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLoginKeyReleased(evt);
            }
        });
        painel.add(txtLogin);
        txtLogin.setBounds(70, 20, 160, 20);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel1.setText("LOGIN:");
        painel.add(jLabel1);
        jLabel1.setBounds(20, 20, 50, 16);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel2.setText("SENHA:");
        painel.add(jLabel2);
        jLabel2.setBounds(20, 70, 50, 16);

        txtSenha.setText("BLEND");
        txtSenha.setNextFocusableComponent(ckAdm);
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSenhaKeyReleased(evt);
            }
        });
        painel.add(txtSenha);
        txtSenha.setBounds(70, 70, 160, 20);

        ckAdm.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        ckAdm.setSelected(true);
        ckAdm.setText("ADMINISTRADOR");
        ckAdm.setNextFocusableComponent(btnLogar);
        painel.add(ckAdm);
        ckAdm.setBounds(20, 104, 130, 24);

        btnCancelar.setFont(new java.awt.Font("sansserif", 1, 12));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/login_sair.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        painel.add(btnCancelar);
        btnCancelar.setBounds(290, 90, 40, 40);

        btnLogar.setFont(new java.awt.Font("sansserif", 1, 12));
        btnLogar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/login_entrar.png"))); // NOI18N
        btnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogarActionPerformed(evt);
            }
        });
        painel.add(btnLogar);
        btnLogar.setBounds(240, 90, 40, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logar.png"))); // NOI18N
        painel.add(jLabel3);
        jLabel3.setBounds(240, 10, 96, 80);

        getContentPane().add(painel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyReleased
        if ((evt.getKeyCode() !=  KeyEvent.VK_UP) && (evt.getKeyCode() !=  KeyEvent.VK_DOWN) && (evt.getKeyCode() !=  KeyEvent.VK_RIGHT) && (evt.getKeyCode() !=  KeyEvent.VK_LEFT)){
            cmm.getParaMaiuscula(txtLogin);
        }
    }//GEN-LAST:event_txtLoginKeyReleased

    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogarActionPerformed
        login();
    }//GEN-LAST:event_btnLogarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setSize(347,160);
    }//GEN-LAST:event_formWindowOpened

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
            Sessao.sair();
            System.exit(0);
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            Careto = txtSenha.getCaretPosition();
            cmm.getParaMaiuscula(txtSenha);
            txtSenha.setCaretPosition(Careto);
        }
    }//GEN-LAST:event_txtSenhaKeyReleased


    private void login(){
        try{
            con.Conecta();
            meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultset = meustate.executeQuery("SELECT * FROM TBL_FUNCIONARIO WHERE LOGIN='"+txtLogin.getText()+"'");
            if(resultset.next()==true){
                if (txtSenha.getText().equals(resultset.getString("SENHA"))){
                    int cod = Integer.parseInt(resultset.getString("cod_funcionario"));
                    String login = resultset.getString("login");
                    String nome_completo = resultset.getString("nome_funcionario");
                    boolean adM;
                    if(resultset.getString("administrador").equals("1")==true && ckAdm.isSelected()==true){
                        adM = true;
                    }
                    else if(resultset.getString("administrador").equals("1")==false && ckAdm.isSelected()==true){
                        JOptionPane.showMessageDialog(null,"Você não possui privilégios de administrador.","Atenção!",JOptionPane.WARNING_MESSAGE);
                        adM = false;
                    }
                    else{
                        adM = false;
                    }
                    SessaoLogin.iniciar(cod, login, nome_completo, adM);
                    con.Fecha();
                    telaPrincipal frm = new telaPrincipal();
                    frm.Sessao = SessaoLogin;
                    frm.setExtendedState(6);
                    frm.setVisible(true);
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Senha incorreta!","Título",JOptionPane.WARNING_MESSAGE);
                    txtSenha.setText("");
                    txtSenha.grabFocus();
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Usuário inexistente.","Atenção",JOptionPane.WARNING_MESSAGE);
                txtSenha.setText("");
                txtLogin.grabFocus();
            }
            con.Fecha();
        }
        catch(SQLException erro){
            erro.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLogar;
    private javax.swing.JCheckBox ckAdm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel painel;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables

}
