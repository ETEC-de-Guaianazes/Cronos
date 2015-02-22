/*
 * dialogVenda.java
 *
 * Created on 10/05/2010, 15:21:05
 */
package frontEnd;

import Banco.CadMovimentacao;
import Banco.CadProduto;
import Banco.CadServico;
import Banco.Conexao;
import Validacoes.Validacao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class dialogVenda extends javax.swing.JDialog {

    public String cod_funcionario, cod_cliente, cod_venda, cod_tipo_pagamento;
    public DefaultTableModel mdlNota;
    private Conexao con = new Conexao();
    private CadProduto cadPro = new CadProduto();
    private CadServico cadser = new CadServico();
    private JTable tabelaVirtualNota;
    private CadMovimentacao cadmov = new CadMovimentacao();
    private GregorianCalendar calendario = new GregorianCalendar();
    private String nomecolunas[] = {"Parcela", "Valor (R$)", "Dt. vencimento"};
    private DefaultTableModel modeloTabelaParcelas;
    private double total = 0, valorParcela = 0;
    private int Careto = 0, progresso = 0;
    private Date data = new Date();
    private Comum cmm = new Comum();
    private Validacao valida = new Validacao();
    private CadProduto cad = new CadProduto();
    private DateFormat sdf;

    /** Creates new form dialogVenda */
    public dialogVenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        painel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbtipoPagamento = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        lblValorTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        txtParcelas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtEntrada = new javax.swing.JTextField();
        rbParcelado = new javax.swing.JRadioButton();
        rbAVista = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Finalizar venda");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        painel.setLayout(null);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel1.setText("Selecione o tipo de pagamento:");
        painel.add(jLabel1);
        jLabel1.setBounds(10, 40, 180, 16);

        cmbtipoPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<selecione>" }));
        cmbtipoPagamento.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbtipoPagamentoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        painel.add(cmbtipoPagamento);
        cmbtipoPagamento.setBounds(190, 40, 140, 23);

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14));
        jLabel4.setText("Valor total: R$");
        painel.add(jLabel4);
        jLabel4.setBounds(10, 10, 100, 19);

        lblValorTotal.setFont(new java.awt.Font("sansserif", 1, 14));
        lblValorTotal.setText("   ");
        painel.add(lblValorTotal);
        lblValorTotal.setBounds(110, 10, 210, 19);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Parcela", "Valor", "Dt de vencimento"
            }
        ));
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jScrollPane1.setViewportView(tabela);

        painel.add(jScrollPane1);
        jScrollPane1.setBounds(20, 170, 310, 90);

        txtParcelas.setText("1");
        txtParcelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtParcelasKeyReleased(evt);
            }
        });
        painel.add(txtParcelas);
        txtParcelas.setBounds(110, 140, 80, 23);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel2.setText("Nº de parcelas:");
        painel.add(jLabel2);
        jLabel2.setBounds(20, 140, 90, 16);

        btnCalcular.setFont(new java.awt.Font("sansserif", 1, 11)); // NOI18N
        btnCalcular.setText("CALCULAR");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        painel.add(btnCalcular);
        btnCalcular.setBounds(190, 140, 100, 20);

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        painel.add(btnFinalizar);
        btnFinalizar.setBounds(240, 70, 90, 26);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel3.setText("Entrada:");
        painel.add(jLabel3);
        jLabel3.setBounds(60, 110, 50, 16);

        txtEntrada.setText("0,00");
        txtEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEntradaKeyReleased(evt);
            }
        });
        painel.add(txtEntrada);
        txtEntrada.setBounds(110, 110, 80, 24);

        buttonGroup1.add(rbParcelado);
        rbParcelado.setFont(new java.awt.Font("sansserif", 1, 12));
        rbParcelado.setText("Parcelado");
        rbParcelado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbParceladoActionPerformed(evt);
            }
        });
        painel.add(rbParcelado);
        rbParcelado.setBounds(120, 70, 80, 24);

        buttonGroup1.add(rbAVista);
        rbAVista.setFont(new java.awt.Font("sansserif", 1, 12));
        rbAVista.setSelected(true);
        rbAVista.setText("À vista");
        rbAVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAVistaActionPerformed(evt);
            }
        });
        painel.add(rbAVista);
        rbAVista.setBounds(10, 70, 70, 24);

        getContentPane().add(painel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Janela aberta
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        cad.getListaCombo(cmbtipoPagamento, modelo, "SELECT * FROM tbl_tipo_pagamento");
        this.setSize(350, 140);
        btnFinalizar.setLocation(250, 70);
        criarTabelaParcelas();

    }//GEN-LAST:event_formWindowOpened

    private void cmbtipoPagamentoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbtipoPagamentoPopupMenuWillBecomeInvisible
        con.Conecta();
        cod_tipo_pagamento = cadmov.getCodigoTipoPagamento(cmbtipoPagamento.getSelectedItem().toString());
        con.Fecha();
    }//GEN-LAST:event_cmbtipoPagamentoPopupMenuWillBecomeInvisible

    @SuppressWarnings("static-access")
    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed

        total = Double.parseDouble(lblValorTotal.getText().replaceAll(",", "."));
        total -= Double.parseDouble(txtEntrada.getText().replaceAll(",", "."));
        valorParcela = total / Integer.parseInt(txtParcelas.getText().replaceAll(" ", ""));
        String conteudo[] = new String[4];
        criarTabelaParcelas();

        for (int i = 1; i <= Integer.parseInt(txtParcelas.getText().replaceAll(" ", "")); i++) {
            conteudo[0] = "" + (i);
            conteudo[1] = String.format("%.2f", valorParcela);
            calendario.setTime(new Date());
            calendario.add(GregorianCalendar.MONTH, i);
            SimpleDateFormat sData = new SimpleDateFormat("dd/MM/yyyy");
            data = calendario.getTime();
            conteudo[2] = sData.format(data);
            modeloTabelaParcelas.addRow(conteudo);
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void txtParcelasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtParcelasKeyReleased
        if (valida.isNumeric("" + evt.getKeyChar() + "") == false && (evt.getKeyCode() != KeyEvent.VK_UP) && (evt.getKeyCode() != KeyEvent.VK_DOWN) && (evt.getKeyCode() != KeyEvent.VK_LEFT) && (evt.getKeyCode() != KeyEvent.VK_RIGHT)) {
            try {
                Careto = txtParcelas.getCaretPosition();
                txtParcelas.setText(txtParcelas.getText().replaceAll("[" + evt.getKeyChar() + ".,]", ""));
                txtParcelas.setCaretPosition(Careto);
            } catch (IllegalArgumentException e) {
            }
        }
    }//GEN-LAST:event_txtParcelasKeyReleased

    private void txtEntradaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntradaKeyReleased
        Careto = txtEntrada.getCaretPosition();
        if (valida.isNumeric("" + evt.getKeyChar() + "") == false) {
            txtEntrada.setText(txtEntrada.getText().replaceAll("" + evt.getKeyChar() + "", ""));
        } else {
            try {
                txtEntrada.setText(String.format("%.2f", Double.parseDouble(txtEntrada.getText().replaceAll(",", "."))));
            } catch (IllegalArgumentException e) {
            }
        }
        txtEntrada.setCaretPosition(Careto);
    }//GEN-LAST:event_txtEntradaKeyReleased

    private void rbParceladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbParceladoActionPerformed
        this.setSize(350, 340);
        btnFinalizar.setLocation(250, 270);
    }//GEN-LAST:event_rbParceladoActionPerformed

    private void rbAVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAVistaActionPerformed
        this.setSize(350, 140);
        btnFinalizar.setLocation(250, 70);
    }//GEN-LAST:event_rbAVistaActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        //Venda à vista
        if (rbAVista.isSelected() == true) {
            sdf = new SimpleDateFormat("hh:mm:ss");
            String sHora = sdf.format(new Date());
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            String sData = sdf.format(new Date());
            progresso = 0;
            con.Conecta();
            progresso += cadmov.cadastraVenda(lblValorTotal.getText().replaceAll(",", "."), sData, sHora, cod_funcionario, cod_cliente, cadmov.getCodigoTipoPagamento(cmbtipoPagamento.getSelectedItem().toString()), "vista");
            cod_venda = cadmov.getLastCodigoVenda();
            tabelaVirtualNota = new JTable();
            tabelaVirtualNota.setModel(mdlNota);
            for (int i = 0; i < tabelaVirtualNota.getRowCount(); i++) {
                if (tabelaVirtualNota.getValueAt(i, 0).toString().equals("Produto")) {
                    progresso += cadmov.cadastraVendaProduto(cadmov.getLastCodigoVenda(), cadPro.getCodigoProduto(tabelaVirtualNota.getValueAt(i, 2).toString()), tabelaVirtualNota.getValueAt(i, 1).toString());
                } else if (tabelaVirtualNota.getValueAt(i, 0).toString().equals("Serviço")) {
                    progresso += cadmov.cadastraVendaServico(cadser.getServico(tabelaVirtualNota.getValueAt(i, 2).toString()), cadmov.getLastCodigoVenda(), tabelaVirtualNota.getValueAt(i, 1).toString());
                }
            }
            if (progresso == 0) {
                JOptionPane.showMessageDialog(this, "Venda efetuada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                con.Fecha();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Foram encontrados " + progresso + " erro(s) durante a operação.", "Não efetuou a venda!", JOptionPane.ERROR_MESSAGE);
                con.Fecha();
            }
        } //Venda parcelada
        else {
            sdf = new SimpleDateFormat("hh:mm:ss");
            String sHora = sdf.format(new Date());
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            String sData = sdf.format(new Date());
            progresso = 0;
            con.Conecta();
            progresso += cadmov.cadastraVenda(txtEntrada.getText().replaceAll(",", "."), sData, sHora, cod_funcionario, cod_cliente, cadmov.getCodigoTipoPagamento(cmbtipoPagamento.getSelectedItem().toString()), "parcelado");
            cod_venda = cadmov.getLastCodigoVenda();
            tabelaVirtualNota = new JTable();
            tabelaVirtualNota.setModel(mdlNota);
            String codigodaVenda = cadmov.getLastCodigoVenda();
            for (int i = 0; i < tabelaVirtualNota.getRowCount(); i++) {
                if (tabelaVirtualNota.getValueAt(i, 0).toString().equals("Produto")) {
                    progresso += cadmov.cadastraVendaProduto(codigodaVenda, cadPro.getCodigoProduto(tabelaVirtualNota.getValueAt(i, 2).toString()), tabelaVirtualNota.getValueAt(i, 1).toString());
                } else if (tabelaVirtualNota.getValueAt(i, 0).toString().equals("Serviço")) {
                    progresso += cadmov.cadastraVendaServico(cadser.getServico(tabelaVirtualNota.getValueAt(i, 2).toString()), codigodaVenda, tabelaVirtualNota.getValueAt(i, 1).toString());
                }
            }
            for (int i = 0; i < tabela.getRowCount(); i++) {
                try {
                    sData = sdf.format(Comum.formataData(tabela.getValueAt(i, 2).toString()));
                } catch (Exception ex) {
                }
                progresso += cadmov.cadastraParcela(tabela.getValueAt(i, 1).toString().replaceAll(",", "."), sData, codigodaVenda, tabela.getValueAt(i, 0).toString());
            }
            if (progresso == 0) {
                JOptionPane.showMessageDialog(this, "Venda efetuada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                con.Fecha();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Foram encontrados " + progresso + " erro(s) durante a operação.", "Não efetuou a venda!", JOptionPane.ERROR_MESSAGE);
                con.Fecha();
            }
        }

    }//GEN-LAST:event_btnFinalizarActionPerformed

    public void criarTabelaParcelas() {

        modeloTabelaParcelas = new DefaultTableModel(nomecolunas, 0) {

            @Override
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                if (vColIndex == 0) {
                    return true;
                }
                return false;
            }
        };
        tabela.setModel(modeloTabelaParcelas);
        tabela.setCellSelectionEnabled(false);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabela.setColumnSelectionAllowed(false);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.setForeground(Color.BLACK);
        tabela.setIntercellSpacing(new Dimension(0, 1));
        tabela.setAutoCreateRowSorter(true);
        tabela.setShowHorizontalLines(true);
        tabela.setShowVerticalLines(false);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setRowSelectionAllowed(true);
        tabela.setAutoCreateColumnsFromModel(true);
        tabela.setShowGrid(true);
        tabela.setOpaque(false);
        System.out.println("Tabela atualizada.");

    }//Fim criarTabelaNota()
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbtipoPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblValorTotal;
    private javax.swing.JPanel painel;
    private javax.swing.JRadioButton rbAVista;
    private javax.swing.JRadioButton rbParcelado;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtParcelas;
    // End of variables declaration//GEN-END:variables
}
