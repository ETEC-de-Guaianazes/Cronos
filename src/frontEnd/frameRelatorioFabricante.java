/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frame.java
 *
 * Created on 04/06/2010, 15:17:25
 */

package frontEnd;

/**
 *
 * @author Andre
 */
public class frameRelatorioFabricante extends javax.swing.JInternalFrame {

    /** Creates new form frame */
    public frameRelatorioFabricante() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setTitle("Relatório de Fabricantes");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setText("Fabricante:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 70, 20);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setText("Produtos:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 40, 60, 20);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(380, 40, 260, 26);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(380, 10, 260, 26);

        jButton1.setText("Selecionar");
        getContentPane().add(jButton1);
        jButton1.setBounds(653, 10, 87, 30);

        jTextField1.setText("jTextField1");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(80, 40, 290, 28);

        jTextField2.setText("jTextField1");
        getContentPane().add(jTextField2);
        jTextField2.setBounds(80, 10, 290, 28);

        jButton2.setText("Cancelar");
        getContentPane().add(jButton2);
        jButton2.setBounds(740, 10, 78, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

}