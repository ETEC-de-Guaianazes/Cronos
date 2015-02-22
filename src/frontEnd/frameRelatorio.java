
package frontEnd;


public class frameRelatorio extends javax.swing.JInternalFrame {

    public frameRelatorio() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpImpressao = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        cmbSelecionaRelatorio = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rbImprimirTodos = new javax.swing.JRadioButton();
        rbSelecionadosImprimir = new javax.swing.JRadioButton();
        rbIndividualImprimir = new javax.swing.JRadioButton();
        btnImprimir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        pnRelatorio = new javax.swing.JPanel();
        tabela = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setTitle("Relatórios");
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

        jPanel1.setBorder(null);
        jPanel1.setPreferredSize(new java.awt.Dimension(593, 50));

        cmbSelecionaRelatorio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Clientes", "Produtos", "Serviços", "Fabricantes", "Fornecedores", "Categorias", "Vendas", "Compras", "Funcionários" }));
        cmbSelecionaRelatorio.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbSelecionaRelatorioPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel1.setText("Selecione uma categoria de relatorio:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSelecionaRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(206, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbSelecionaRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(593, 40));

        grpImpressao.add(rbImprimirTodos);
        rbImprimirTodos.setFont(new java.awt.Font("sansserif", 1, 12));
        rbImprimirTodos.setSelected(true);
        rbImprimirTodos.setText("Todos");

        grpImpressao.add(rbSelecionadosImprimir);
        rbSelecionadosImprimir.setFont(new java.awt.Font("sansserif", 1, 12));
        rbSelecionadosImprimir.setText("Selecionados");

        grpImpressao.add(rbIndividualImprimir);
        rbIndividualImprimir.setFont(new java.awt.Font("sansserif", 1, 12));
        rbIndividualImprimir.setText("Individual");

        btnImprimir.setFont(new java.awt.Font("sansserif", 1, 12));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/imprimir_icone.png"))); // NOI18N
        btnImprimir.setText("Imprimir");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(rbImprimirTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(rbSelecionadosImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbIndividualImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(349, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbImprimirTodos)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbSelecionadosImprimir)
                        .addComponent(rbIndividualImprimir)))
                .addGap(12, 12, 12))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(new java.awt.BorderLayout());

        pnRelatorio.setOpaque(false);
        pnRelatorio.setPreferredSize(new java.awt.Dimension(774, 220));
        pnRelatorio.setLayout(new java.awt.BorderLayout());
        jPanel3.add(pnRelatorio, java.awt.BorderLayout.NORTH);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Selecione a categoria de relatório"
            }
        ));
        tabela.setViewportView(jTable1);

        jPanel3.add(tabela, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSelecionaRelatorioPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbSelecionaRelatorioPopupMenuWillBecomeInvisible
        pnRelatorio.removeAll();
        if(cmbSelecionaRelatorio.getSelectedIndex() == 0){
            pnRelatorio.setVisible(false);
        }
        else
            pnRelatorio.setVisible(true);

        if (cmbSelecionaRelatorio.getSelectedIndex() == 1){
            frameRelatorioCliente frm = new frameRelatorioCliente();
            pnRelatorio.add(frm);
            frm.setVisible(true);
       }
       if (cmbSelecionaRelatorio.getSelectedIndex() == 2){
           frameRelatorioProduto frm = new frameRelatorioProduto();
           pnRelatorio.add(frm);
           frm.setVisible(true);
       }
       if (cmbSelecionaRelatorio.getSelectedIndex() == 3){
           frameRelatorioServicos frm = new frameRelatorioServicos();
           pnRelatorio.add(frm);
           frm.setVisible(true);
       }
       if (cmbSelecionaRelatorio.getSelectedIndex() == 4){
           frameRelatorioFabricante frm = new frameRelatorioFabricante();
           pnRelatorio.add(frm);
           frm.setVisible(true);
       }
       if (cmbSelecionaRelatorio.getSelectedIndex() == 5){
           frameRelatorioFornecedor frm = new frameRelatorioFornecedor();
           pnRelatorio.add(frm);
           frm.setVisible(true);
       }
       if (cmbSelecionaRelatorio.getSelectedIndex() == 6){
           frameRelatorioCategoria frm = new frameRelatorioCategoria();
           pnRelatorio.add(frm);
           frm.setVisible(true);
       }
       if (cmbSelecionaRelatorio.getSelectedIndex() == 7){
           frameRelatorioVendas frm = new frameRelatorioVendas();
           pnRelatorio.add(frm);
           frm.setVisible(true);
       }
       if (cmbSelecionaRelatorio.getSelectedIndex() == 8){
           frameRelatorioCompras frm = new frameRelatorioCompras();
           pnRelatorio.add(frm);
           frm.setVisible(true);
       }
       if (cmbSelecionaRelatorio.getSelectedIndex() == 9){
           frameRelatorioFuncionario frm = new frameRelatorioFuncionario();
           pnRelatorio.add(frm);
           frm.setVisible(true);
       }
    }//GEN-LAST:event_cmbSelecionaRelatorioPopupMenuWillBecomeInvisible

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        pnRelatorio.setVisible(false);
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JComboBox cmbSelecionaRelatorio;
    private javax.swing.ButtonGroup grpImpressao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pnRelatorio;
    private javax.swing.JRadioButton rbImprimirTodos;
    private javax.swing.JRadioButton rbIndividualImprimir;
    private javax.swing.JRadioButton rbSelecionadosImprimir;
    private javax.swing.JScrollPane tabela;
    // End of variables declaration//GEN-END:variables

}
