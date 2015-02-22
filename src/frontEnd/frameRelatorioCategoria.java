

package frontEnd;


public class frameRelatorioCategoria extends javax.swing.JInternalFrame {

    
    public frameRelatorioCategoria() {
        initComponents();
    }
//JScrollPane scrollPane = new JScrollPane(textArea);
//
//setPreferredSize(new Dimension(450, 110));
//
//add(scrollPane, BorderLayout.CENTER);
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Relatório de Categorias");

        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setVerticalScrollBar(jScrollBar1);

        jPanel2.setPreferredSize(new java.awt.Dimension(100, 500));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel2.setText("Produtos:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(50, 230, 60, 20);
        jPanel2.add(jScrollBar1);
        jScrollBar1.setBounds(780, 0, 15, 270);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel1.setText("Categoria:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(40, 20, 70, 20);

        jTextField2.setText("jTextField1");
        jPanel2.add(jTextField2);
        jTextField2.setBounds(110, 20, 290, 28);

        jTextField1.setText("jTextField1");
        jPanel2.add(jTextField1);
        jTextField1.setBounds(120, 230, 290, 28);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jComboBox2);
        jComboBox2.setBounds(410, 20, 230, 26);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(420, 230, 230, 26);

        jButton1.setText("Selecionar");
        jPanel2.add(jButton1);
        jButton1.setBounds(650, 20, 87, 30);

        jButton2.setText("Cancelar");
        jPanel2.add(jButton2);
        jButton2.setBounds(670, 230, 78, 30);

        jScrollPane1.setViewportView(jPanel2);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

}
