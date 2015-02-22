package frontEnd;

import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import Banco.*;

public class frameRelatorioCliente extends javax.swing.JInternalFrame {

    private DefaultComboBoxModel mdlCliente;
    private CadProduto cadPro;
    private String sqlc= "SELECT * FROM tbl_cliente ORDER BY nome";

    public frameRelatorioCliente() {
        initComponents();
    }

    private void atualizaClientes(String sql){
        cadPro = new CadProduto();
        mdlCliente = new DefaultComboBoxModel();
        cadPro.getListaCombo(cmbCliente, mdlCliente, sql);
     }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        lblRg = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblRua = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        txtNome = new javax.swing.JTextField();
        txtRG = new javax.swing.JTextField();
        txtLogradouro = new javax.swing.JTextField();
        txtbairro = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNasc = new com.toedter.calendar.JDateChooser();
        txtNasc1 = new com.toedter.calendar.JDateChooser();
        txtNasc2 = new com.toedter.calendar.JDateChooser();
        cmbCliente = new javax.swing.JComboBox();
        cmbEstado = new javax.swing.JComboBox();

        setTitle("Relatório de Clientes");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        lblNome.setFont(new java.awt.Font("sansserif", 1, 12));
        lblNome.setText("Nome:");
        getContentPane().add(lblNome);
        lblNome.setBounds(20, 15, 40, 16);

        lblRg.setFont(new java.awt.Font("sansserif", 1, 12));
        lblRg.setText("RG:");
        getContentPane().add(lblRg);
        lblRg.setBounds(270, 45, 30, 16);

        lblCpf.setFont(new java.awt.Font("sansserif", 1, 12));
        lblCpf.setText("CPF:");
        getContentPane().add(lblCpf);
        lblCpf.setBounds(20, 45, 30, 16);

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel4.setText("até");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(540, 160, 20, 16);

        lblRua.setFont(new java.awt.Font("sansserif", 1, 12));
        lblRua.setText("Logradouro:");
        getContentPane().add(lblRua);
        lblRua.setBounds(20, 75, 80, 16);

        lblBairro.setFont(new java.awt.Font("sansserif", 1, 12));
        lblBairro.setText("Bairro:");
        getContentPane().add(lblBairro);
        lblBairro.setBounds(20, 105, 40, 16);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel2.setText("Cidade: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(218, 105, 50, 16);

        lblEstado.setFont(new java.awt.Font("sansserif", 1, 12));
        lblEstado.setText("Estado:");
        getContentPane().add(lblEstado);
        lblEstado.setBounds(402, 105, 50, 16);

        txtCpf.setToolTipText("Cadastro de pessoa física");
        getContentPane().add(txtCpf);
        txtCpf.setBounds(60, 40, 200, 26);

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });
        getContentPane().add(txtNome);
        txtNome.setBounds(60, 10, 300, 26);
        getContentPane().add(txtRG);
        txtRG.setBounds(300, 40, 200, 26);
        getContentPane().add(txtLogradouro);
        txtLogradouro.setBounds(90, 70, 410, 26);
        getContentPane().add(txtbairro);
        txtbairro.setBounds(60, 100, 150, 26);
        getContentPane().add(txtCidade);
        txtCidade.setBounds(260, 100, 140, 28);
        getContentPane().add(txtemail);
        txtemail.setBounds(61, 130, 220, 26);

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel5.setText("E-mail:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 135, 38, 16);

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel6.setText("Cadastrado em:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 160, 90, 16);

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel7.setText("Cadastrado de:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(280, 160, 90, 16);

        txtNasc.setMaxSelectableDate(new Date());
        txtNasc.setMinSelectableDate(new java.util.Date(-2208973944000L));
        txtNasc.setOpaque(false);
        getContentPane().add(txtNasc);
        txtNasc.setBounds(560, 155, 170, 26);

        txtNasc1.setMaxSelectableDate(new Date());
        txtNasc1.setMinSelectableDate(new java.util.Date(-2208973944000L));
        txtNasc1.setOpaque(false);
        getContentPane().add(txtNasc1);
        txtNasc1.setBounds(110, 155, 170, 26);

        txtNasc2.setMaxSelectableDate(new Date());
        txtNasc2.setMinSelectableDate(new java.util.Date(-2208973944000L));
        txtNasc2.setOpaque(false);
        getContentPane().add(txtNasc2);
        txtNasc2.setBounds(370, 155, 170, 26);

        getContentPane().add(cmbCliente);
        cmbCliente.setBounds(370, 10, 370, 26);

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        getContentPane().add(cmbEstado);
        cmbEstado.setBounds(450, 100, 50, 26);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        atualizaClientes(sqlc);
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
       sqlc = "SELECT * FROM tbl_cliente WHERE nome LIKE '"+txtNome.getText()+"%' ORDER BY nome";
        atualizaClientes(sqlc);
    }//GEN-LAST:event_txtNomeKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbCliente;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRg;
    private javax.swing.JLabel lblRua;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtLogradouro;
    private com.toedter.calendar.JDateChooser txtNasc;
    private com.toedter.calendar.JDateChooser txtNasc1;
    private com.toedter.calendar.JDateChooser txtNasc2;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRG;
    private javax.swing.JTextField txtbairro;
    private javax.swing.JTextField txtemail;
    // End of variables declaration//GEN-END:variables

}
