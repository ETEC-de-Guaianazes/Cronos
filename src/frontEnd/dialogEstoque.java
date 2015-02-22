package frontEnd;

import java.awt.event.KeyEvent;
import java.sql.*;
import Banco.*;

public class dialogEstoque extends javax.swing.JDialog {
    private Comum cmm = new Comum(); ;
    private String  sql ="SELECT tbl_produto.nome_produto as \"Produto\",tbl_produto.unidades_em_estoque as \"Unidades em estoque\", tbl_produto.unidades_reposicao as \"Repor em\" FROM tbl_produto";
    Conexao con = new Conexao();
    private Statement meustate;
    private ResultSet resultset;


    public dialogEstoque(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void atualizarTabela(){

        cmm.criarTabela(sql, tabela);
        tabela.setAutoResizeMode(1);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        cmbNivel = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEstoque = new javax.swing.JTextField();
        txtReposicao = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JButton();
        btnComprar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(980, 310));
        jPanel1.setLayout(new java.awt.BorderLayout());

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Controle de entoque"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        tabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        tabela.getColumnModel().getColumn(0).setResizable(false);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(980, 110));
        jPanel2.setLayout(null);

        cmbNivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Abaixo do nível", "Acima do nível" }));
        cmbNivel.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbNivelPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel2.add(cmbNivel);
        cmbNivel.setBounds(70, 0, 190, 26);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setText("Selecione:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 0, 70, 16);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(" Alterar "));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setText("Nível de reposição:");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setText("Quantidade atual em estoque:");

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtReposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAlterar)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtReposicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar)))
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(10, 30, 610, 80);

        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        jPanel2.add(btnComprar);
        btnComprar.setBounds(280, 0, 80, 28);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        atualizarTabela();
    }//GEN-LAST:event_formWindowOpened

    private void cmbNivelPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbNivelPopupMenuWillBecomeInvisible
        if(cmbNivel.getSelectedIndex()==0){
            sql = "SELECT tbl_produto.nome_produto as \"Produto\",tbl_produto.unidades_em_estoque as \"Unidades em estoque\", tbl_produto.unidades_reposicao as \"Repor em\" FROM tbl_produto" ;
            atualizarTabela();
        }
        else if(cmbNivel.getSelectedIndex()==1){
            sql = "SELECT tbl_produto.nome_produto as \"Produto\",tbl_produto.unidades_em_estoque as \"Unidades em estoque\", tbl_produto.unidades_reposicao as \"Repor em\" FROM tbl_produto where tbl_produto.unidades_em_estoque < tbl_produto.unidades_reposicao";
            atualizarTabela();
        }
        else if(cmbNivel.getSelectedIndex()==2){
            sql = "SELECT tbl_produto.nome_produto as \"Produto\",tbl_produto.unidades_em_estoque as \"Unidades em estoque\", tbl_produto.unidades_reposicao as \"Repor em\" FROM tbl_produto where tbl_produto.unidades_em_estoque >= tbl_produto.unidades_reposicao";
            atualizarTabela();
        }
    }//GEN-LAST:event_cmbNivelPopupMenuWillBecomeInvisible

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        sincronizarTabela();
    }//GEN-LAST:event_tabelaMouseClicked

    private void tabelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyReleased
       if ((evt.getKeyCode() ==  KeyEvent.VK_UP)  || (evt.getKeyCode() ==  KeyEvent.VK_DOWN) || (evt.getKeyCode() == KeyEvent.VK_ENTER)) {
            sincronizarTabela();
        }
    }//GEN-LAST:event_tabelaKeyReleased

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        frameCompra frm = new frameCompra();
        frm.setVisible(true);
        frm.setSize(400,400);
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        con.Conecta();
        try{
                        meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                        meustate.executeUpdate("UPDATE tbl_produto SET unidades_em_estoque = '"+txtEstoque.getText()+"', unidades_reposicao ='"+txtReposicao.getText()+"' where nome_produto = '"+tabela.getValueAt(tabela.getSelectedRow(), 0)+"'");
                        
                    }
                    catch(SQLException erro){
                        System.out.println("Erro ao obter quantidade.");
                        erro.printStackTrace();
                    }
        con.Fecha();
        txtEstoque.setText("");
        txtReposicao.setText("");
        atualizarTabela();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void sincronizarTabela(){
        txtEstoque.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        txtReposicao.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
    }

    /**
    * @param args the command line arguments
    */
    //public static void main(String args[]) {
       // java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dialogEstoque dialog = new dialogEstoque(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
       // });
   // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JComboBox cmbNivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtEstoque;
    private javax.swing.JTextField txtReposicao;
    // End of variables declaration//GEN-END:variables

}
