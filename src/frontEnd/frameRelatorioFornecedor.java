/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frameRelatorioFornecedor.java
 *
 * Created on 04/06/2010, 15:11:02
 */

package frontEnd;

/**
 *
 * @author Andre
 */
public class frameRelatorioFornecedor extends javax.swing.JInternalFrame {

    /** Creates new form frameRelatorioFornecedor */
    public frameRelatorioFornecedor() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblRua = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        lblCep = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        txtNomeContato = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtCNPJ = new javax.swing.JTextField();
        txtLogradouro = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtCEP = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        cmbFornecedor = new javax.swing.JComboBox();
        txtTelefone = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox();

        setTitle("Relatório de Fornecedores");
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel3.setText("Nome:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 20, 36, 16);

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel4.setText("CNPJ:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 50, 34, 16);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel1.setText("Nome do contato:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 170, 100, 16);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel2.setText("Telefone:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 140, 70, 16);

        lblRua.setFont(new java.awt.Font("sansserif", 1, 12));
        lblRua.setText("Logradouro:");
        getContentPane().add(lblRua);
        lblRua.setBounds(20, 80, 70, 16);

        lblBairro.setFont(new java.awt.Font("sansserif", 1, 12));
        lblBairro.setText("Bairro:");
        getContentPane().add(lblBairro);
        lblBairro.setBounds(20, 110, 38, 16);

        lblCep.setFont(new java.awt.Font("sansserif", 1, 12));
        lblCep.setText("CEP:");
        getContentPane().add(lblCep);
        lblCep.setBounds(170, 110, 26, 16);

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel6.setText("Cidade: ");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(290, 110, 50, 16);

        lblEstado.setFont(new java.awt.Font("sansserif", 1, 12));
        lblEstado.setText("Estado:");
        getContentPane().add(lblEstado);
        lblEstado.setBounds(20, 140, 50, 16);
        getContentPane().add(txtNomeContato);
        txtNomeContato.setBounds(130, 160, 120, 28);
        getContentPane().add(txtNome);
        txtNome.setBounds(60, 10, 230, 28);
        getContentPane().add(txtCNPJ);
        txtCNPJ.setBounds(60, 40, 170, 28);
        getContentPane().add(txtLogradouro);
        txtLogradouro.setBounds(100, 70, 250, 28);
        getContentPane().add(txtBairro);
        txtBairro.setBounds(60, 100, 110, 28);
        getContentPane().add(txtCEP);
        txtCEP.setBounds(200, 100, 80, 28);
        getContentPane().add(txtCidade);
        txtCidade.setBounds(340, 100, 110, 28);

        cmbFornecedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbFornecedor);
        cmbFornecedor.setBounds(300, 10, 220, 26);
        getContentPane().add(txtTelefone);
        txtTelefone.setBounds(210, 130, 120, 28);

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        getContentPane().add(cmbEstado);
        cmbEstado.setBounds(70, 130, 60, 26);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblRua;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCEP;
    private javax.swing.JTextField txtCNPJ;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeContato;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

}
