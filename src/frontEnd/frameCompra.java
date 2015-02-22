package frontEnd;

import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import Banco.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import Validacoes.Validacao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;

public class frameCompra extends javax.swing.JInternalFrame {

    private String sql, sqlf = "SELECT * FROM tbl_fornecedor ORDER BY nome_fornecedor", forn = "", cat = "", marc = "", prod = "";
    private String nomecolunas[] = {"Qtde.", "Produto", "Valor unitário", "Valor total"};
    private String totalS, estoque;
    public sessao codfunc2;
    private CadMovimentacao cadmov = new CadMovimentacao();
    private SimpleDateFormat sdf;
    private Comum cmm = new Comum();
    private Validacao valida = new Validacao();
    private double total = 0, unitario = 0;
    private DefaultComboBoxModel mdlCategoria, mdlFabricante, mdlFornecedor;
    private CadProduto cadPro;
    private dlgQuantidade frmQtde;
    private DefaultTableModel modelonota;
    Conexao con = new Conexao();
    private int Careto = 0, tem = 0, linha = 0, quantidade = 0;
    private Statement meustate;
    private ResultSet resultset;

    public frameCompra() {
        initComponents();
    }

    private void atualizaFornecedor(String sql) {
        cadPro = new CadProduto();
        mdlFornecedor = new DefaultComboBoxModel();
        cadPro.getListaCombo(cmbFornecedor, mdlFornecedor, sql);
    }

    private void atualizarCombos() {
        cadPro = new CadProduto();
        sql = "SELECT * FROM tbl_fabricante";
        mdlFabricante = new DefaultComboBoxModel();
        cadPro.getListaCombo2(cmbFabricante, mdlFabricante, sql);
        sql = "SELECT * FROM tbl_categoria";
        mdlCategoria = new DefaultComboBoxModel();
        cadPro.getListaCombo2(cmbCategoria, mdlCategoria, sql);
    }

    private void atualizarTabela(String fornecedor, String categoria, String marca, String produto) {
        sql = "SELECT tbl_produto.cod_produto AS \"Código\", tbl_produto.nome_produto AS Produto, " +
                "tbl_produto.descricao AS \"Descrição\", tbl_produto.valor_original AS \"Valor de Compra\"," +
                " tbl_produto.valor AS \"Valor de Venda\", tbl_produto.unidades_em_estoque AS Estoque, " +
                "tbl_produto.unidades_reposicao AS \"Repor em:\", tbl_fabricante.fabricante AS \"Fabricante\", tbl_categoria.categoria AS Categoria, " +
                "tbl_fornecedor.nome_fornecedor AS Fornecedor FROM tbl_categoria INNER JOIN " +
                "(tbl_fornecedor INNER JOIN (tbl_fabricante INNER JOIN tbl_produto " +
                "ON tbl_fabricante.cod_fabricante = tbl_produto.cod_fabricante) ON " +
                "tbl_fornecedor.cod_fornecedor = tbl_produto.cod_fornecedor) ON " +
                "tbl_categoria.cod_categoria = tbl_produto.cod_categoria WHERE tbl_fornecedor.nome_fornecedor LIKE '" + fornecedor + "%' AND tbl_categoria.categoria LIKE '" + categoria + "%' AND tbl_fabricante.fabricante LIKE '" + marca + "%' AND tbl_produto.nome_produto LIKE '" + produto + "%'";
        cmm.criarTabelaProduto(sql, tabela);
        tabela.setAutoResizeMode(2);
    }

    private void sincronizarProduto() {
        lblProduto.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        lblValorUnit.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblProduto = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        cmbFabricante = new javax.swing.JComboBox();
        cmbFornecedor = new javax.swing.JComboBox();
        txtPesqFornecedor = new javax.swing.JTextField();
        btnSelecionar = new javax.swing.JButton();
        btnNovoProduto = new javax.swing.JButton();
        btnNovoFornecedor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblValorUnit = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblValorTotal = new javax.swing.JLabel();
        btnMenos = new javax.swing.JButton();
        btnCompra = new javax.swing.JButton();
        btnMais = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaNota = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtQTDE = new javax.swing.JTextField();

        setTitle("COMPRA");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/compra_icone.png"))); // NOI18N
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 140));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel1.setText("Produto:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 10, 100, 29);

        lblProduto.setFont(new java.awt.Font("Tahoma", 0, 24));
        lblProduto.setPreferredSize(new java.awt.Dimension(100, 44));
        jPanel1.add(lblProduto);
        lblProduto.setBounds(120, 10, 590, 30);

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel5.setText("Nome do Produto:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 110, 110, 20);

        txtNomeProduto.setEnabled(false);
        txtNomeProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeProdutoKeyReleased(evt);
            }
        });
        jPanel1.add(txtNomeProduto);
        txtNomeProduto.setBounds(130, 104, 250, 26);

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel6.setText("Categoria:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(390, 110, 58, 20);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel3.setText("Fornecedor: ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 70, 71, 20);

        cmbCategoria.setEnabled(false);
        cmbCategoria.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbCategoriaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel1.add(cmbCategoria);
        cmbCategoria.setBounds(450, 105, 100, 26);

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel9.setText("Fabricante:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(560, 110, 70, 20);

        cmbFabricante.setEnabled(false);
        cmbFabricante.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbFabricantePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel1.add(cmbFabricante);
        cmbFabricante.setBounds(630, 105, 140, 26);

        cmbFornecedor.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cmbFornecedorPopupMenuWillBecomeVisible(evt);
            }
        });
        cmbFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFornecedorActionPerformed(evt);
            }
        });
        jPanel1.add(cmbFornecedor);
        cmbFornecedor.setBounds(340, 64, 260, 26);

        txtPesqFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesqFornecedorKeyReleased(evt);
            }
        });
        jPanel1.add(txtPesqFornecedor);
        txtPesqFornecedor.setBounds(90, 64, 240, 28);

        btnSelecionar.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/selecionar_icone.png"))); // NOI18N
        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSelecionar);
        btnSelecionar.setBounds(610, 60, 120, 40);

        btnNovoProduto.setFont(new java.awt.Font("sansserif", 1, 12));
        btnNovoProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/inserir_icone.png"))); // NOI18N
        btnNovoProduto.setText("Produto");
        btnNovoProduto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProdutoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNovoProduto);
        btnNovoProduto.setBounds(730, 10, 120, 40);

        btnNovoFornecedor.setFont(new java.awt.Font("sansserif", 1, 12));
        btnNovoFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/inserir_icone.png"))); // NOI18N
        btnNovoFornecedor.setText("Fornecedor");
        btnNovoFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoFornecedorActionPerformed(evt);
            }
        });
        jPanel1.add(btnNovoFornecedor);
        btnNovoFornecedor.setBounds(730, 60, 121, 40);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Tabela de Produtos"
            }
        ));
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

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setPreferredSize(new java.awt.Dimension(370, 250));
        jPanel3.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel8.setText("Unit: R$");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(490, 80, 90, 40);

        lblValorUnit.setFont(new java.awt.Font("Tahoma", 0, 24));
        lblValorUnit.setText("0,00");
        jPanel3.add(lblValorUnit);
        lblValorUnit.setBounds(580, 80, 270, 40);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel10.setText("Total: R$");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(480, 130, 100, 29);

        lblValorTotal.setFont(new java.awt.Font("Tahoma", 0, 24));
        lblValorTotal.setText("0,00");
        jPanel3.add(lblValorTotal);
        lblValorTotal.setBounds(580, 130, 270, 30);

        btnMenos.setFont(new java.awt.Font("sansserif", 1, 12));
        btnMenos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/remover_icone.png"))); // NOI18N
        btnMenos.setText("Remover");
        btnMenos.setEnabled(false);
        btnMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosActionPerformed(evt);
            }
        });
        jPanel3.add(btnMenos);
        btnMenos.setBounds(740, 20, 110, 40);

        btnCompra.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/compra_icone.png"))); // NOI18N
        btnCompra.setText("Comprar");
        btnCompra.setEnabled(false);
        btnCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCompraMouseClicked(evt);
            }
        });
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraActionPerformed(evt);
            }
        });
        jPanel3.add(btnCompra);
        btnCompra.setBounds(610, 190, 120, 40);

        btnMais.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnMais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/inserir_icone.png"))); // NOI18N
        btnMais.setText("Adicionar");
        btnMais.setEnabled(false);
        btnMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaisActionPerformed(evt);
            }
        });
        jPanel3.add(btnMais);
        btnMais.setBounds(630, 20, 110, 40);

        btnCancelar.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar_icone.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelar);
        btnCancelar.setBounds(730, 190, 120, 40);

        tabelaNota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Qtde.", "Produto", "Valor unitário", "Valor total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaNota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaNotaMouseClicked(evt);
            }
        });
        tabelaNota.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabelaNotaFocusGained(evt);
            }
        });
        tabelaNota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaNotaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaNota);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(20, 20, 450, 210);

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel7.setText("QTDE:");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(480, 30, 40, 20);

        txtQTDE.setText("1");
        txtQTDE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQTDEKeyReleased(evt);
            }
        });
        jPanel3.add(txtQTDE);
        txtQTDE.setBounds(520, 30, 70, 30);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeProdutoKeyReleased
        if (txtNomeProduto.getText().length() != 0) {
            prod = txtNomeProduto.getText();
        } else {
            prod = "";
        }
        atualizarTabela(forn, cat, marc, prod);
}//GEN-LAST:event_txtNomeProdutoKeyReleased

    private void txtPesqFornecedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqFornecedorKeyReleased
        sqlf = "SELECT * FROM tbl_fornecedor WHERE nome_fornecedor LIKE '" + txtPesqFornecedor.getText() + "%' ORDER BY nome_fornecedor";
        atualizaFornecedor(sqlf);
        forn = cmbFornecedor.getSelectedItem().toString();
        atualizarTabela(forn, cat, marc, prod);
}//GEN-LAST:event_txtPesqFornecedorKeyReleased

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        sincronizarProduto();
        tabelaNota.clearSelection();
        btnMais.setEnabled(true);
        btnMenos.setEnabled(false);
}//GEN-LAST:event_tabelaMouseClicked

    private void btnMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosActionPerformed
        cmm.indiceTabelaNota = tabelaNota.getSelectedRow();
        alterarQtde(false);
}//GEN-LAST:event_btnMenosActionPerformed

    private void btnCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCompraMouseClicked
}//GEN-LAST:event_btnCompraMouseClicked

    private void btnMaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaisActionPerformed
        tem = 0;
        linha = 1;
        btnCompra.setEnabled(true);
        if (lblProduto.getText().length() != 0 && btnMenos.isEnabled() == false) {
            for (int I = 0; I < tabelaNota.getRowCount(); I++) {
                if (tabela.getValueAt(tabela.getSelectedRow(), 1).toString().equals(tabelaNota.getValueAt(I, 1).toString()) == true) {
                    linha = I;
                    tem++;
                }
            }
            if (tem > 0) {
                tabelaNota.setValueAt(Integer.parseInt(tabelaNota.getValueAt(linha, 0).toString()) + Integer.parseInt(txtQTDE.getText()), linha, 0);
                unitario = Integer.parseInt(tabelaNota.getValueAt(linha, 0).toString()) * Double.parseDouble(tabela.getValueAt(tabela.getSelectedRow(), 3).toString().replaceAll(",", "."));
                totalS = String.format("%.2f", unitario);
                tabelaNota.setValueAt(totalS, linha, 3);
                total = 0;
                for (int I = 0; I < tabelaNota.getRowCount(); I++) {
                    total += Double.parseDouble(tabelaNota.getValueAt(I, 3).toString().replaceAll(",", "."));
                }
                totalS = String.format("%.2f", total);
                lblValorTotal.setText(totalS);
                txtQTDE.setText("1");
            } else if (tem == 0) {
                unitario = Integer.parseInt(txtQTDE.getText()) * Double.parseDouble(tabela.getValueAt(tabela.getSelectedRow(), 3).toString().replaceAll(",", "."));
                String conteudo[] = new String[4];
                conteudo[0] = txtQTDE.getText();
                conteudo[1] = lblProduto.getText();
                conteudo[2] = tabela.getValueAt(tabela.getSelectedRow(), 3).toString();
                totalS = String.format("%.2f", unitario);
                conteudo[3] = totalS;
                modelonota.addRow(conteudo);
                total = 0;
                for (int I = 0; I < tabelaNota.getRowCount(); I++) {
                    total += Double.parseDouble(tabelaNota.getValueAt(I, 3).toString().replaceAll(",", "."));
                }
                totalS = String.format("%.2f", total);
                lblValorTotal.setText(totalS);
                txtQTDE.setText("1");
            }
        } else if (btnMenos.isEnabled() == true) {
            cmm.indiceTabelaNota = tabelaNota.getSelectedRow();
            alterarQtde(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto.");
        }
}//GEN-LAST:event_btnMaisActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        atualizaFornecedor(sqlf);
        atualizarCombos();
        jScrollPane1.setVisible(false);
        criarTabelaNota(tabelaNota);

    }//GEN-LAST:event_formInternalFrameOpened

    public void alterarQtde(boolean aumentar) {
        frmQtde = new dlgQuantidade(null, true);
        if (aumentar == true) {
            frmQtde.QtdeInicial = Integer.parseInt(tabelaNota.getValueAt(cmm.indiceTabelaNota, 0).toString());
            frmQtde.setSize(250, 57);
            frmQtde.setLocationRelativeTo(this);
            frmQtde.btnqtde.setText("ADICIONAR");
            frmQtde.setTitle("Adicionar quantos:");
            frmQtde.setVisible(true);
            frmQtde.setModal(true);
            if (frmQtde.Qtde > 0) {
                tabelaNota.setValueAt(frmQtde.Qtde, cmm.indiceTabelaNota, 0);
                quantidade = Integer.parseInt(tabelaNota.getValueAt(cmm.indiceTabelaNota, 0).toString());
                unitario = Double.parseDouble(tabelaNota.getValueAt(cmm.indiceTabelaNota, 2).toString().replaceAll(",", "."));
                total = quantidade * unitario;
                totalS = String.format("%.2f", total);
                tabelaNota.setValueAt(totalS, cmm.indiceTabelaNota, 3);
                total = 0;
                for (int I = 0; I < tabelaNota.getRowCount(); I++) {
                    total += Double.parseDouble(tabelaNota.getValueAt(I, 3).toString().replaceAll(",", "."));
                }
                totalS = String.format("%.2f", total);
                lblValorTotal.setText(totalS);
                txtQTDE.setText("1");
            } else if (frmQtde.Qtde == -1) {
            }
        } else {
            if (Integer.parseInt(tabelaNota.getValueAt(tabelaNota.getSelectedRow(), 0).toString()) > 1) {
                frmQtde.btnqtde.setText("REMOVER");
                frmQtde.setTitle("Remover quantos:");
                frmQtde.QtdeInicial = Integer.parseInt(tabelaNota.getValueAt(cmm.indiceTabelaNota, 0).toString());
                frmQtde.setLocationRelativeTo(this);
                frmQtde.setVisible(true);
                frmQtde.setModal(true);
                if (frmQtde.Qtde == 0) {
                    if (JOptionPane.showConfirmDialog(this, "Deseja realmente remover o item selecionado?\n" +
                            " *Esta operação não poderá ser desfeita\n" +
                            " caso seja executada.", "Atenção!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        modelonota.removeRow(cmm.indiceTabelaNota);
                        lblValorUnit.setText("0,00");
                        tabelaNota.clearSelection();
                    }
                } else if (frmQtde.Qtde == -1) {
                } else {
                    tabelaNota.setValueAt(frmQtde.Qtde, cmm.indiceTabelaNota, 0);
                    quantidade = Integer.parseInt(tabelaNota.getValueAt(cmm.indiceTabelaNota, 0).toString());
                    unitario = Double.parseDouble(tabelaNota.getValueAt(cmm.indiceTabelaNota, 2).toString().replaceAll(",", "."));
                    total = quantidade * unitario;
                    totalS = String.format("%.2f", total);
                    tabelaNota.setValueAt(totalS, cmm.indiceTabelaNota, 3);
                }
            } else if (Integer.parseInt(tabelaNota.getValueAt(tabelaNota.getSelectedRow(), 0).toString()) == 1) {
                if (JOptionPane.showConfirmDialog(this, "Deseja realmente remover o item selecionado?\n" +
                        " *Esta operação não poderá ser desfeita\n" +
                        " caso seja executada.", "Atenção!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(this, "Indice: " + cmm.indiceTabelaNota);
                    modelonota.removeRow(cmm.indiceTabelaNota);
                    lblValorUnit.setText("0,00");
                    tabelaNota.clearSelection();
                }
            }
            total = 0;
            for (int I = 0; I < tabelaNota.getRowCount(); I++) {
                total += Double.parseDouble(tabelaNota.getValueAt(I, 3).toString().replaceAll(",", "."));
            }
            totalS = String.format("%.2f", total);
            lblValorTotal.setText(totalS);
            txtQTDE.setText("1");
        }
    }//Fim alterarQtde()

    private void cmbFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFornecedorActionPerformed
        //TODO deletar
    }//GEN-LAST:event_cmbFornecedorActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed

        if (cmbFornecedor.getSelectedItem().toString().equals("Inexistente")) {
            JOptionPane.showMessageDialog(this, "Selecione um fornecedor corretamente.", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            cmbFornecedor.setEnabled(false);
            txtPesqFornecedor.setEnabled(false);
            btnNovoProduto.setEnabled(false);
            btnSelecionar.setEnabled(false);
            btnNovoFornecedor.setEnabled(false);
            btnCancelar.setEnabled(true);
            txtNomeProduto.setEnabled(true);
            cmbCategoria.setEnabled(true);
            cmbFabricante.setEnabled(true);
            txtQTDE.setEnabled(true);
            txtPesqFornecedor.setText(cmbFornecedor.getSelectedItem().toString());
            jScrollPane1.setVisible(true);
            forn = cmbFornecedor.getSelectedItem().toString();
            if (cmbCategoria.getSelectedIndex() != 0) {
                cat = cmbCategoria.getSelectedItem().toString();
            }
            if (cmbFabricante.getSelectedIndex() != 0) {
                marc = cmbFabricante.getSelectedItem().toString();
            }
            atualizarTabela(forn, cat, marc, prod);
            criarTabelaNota(tabelaNota);
        }
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void cmbFornecedorPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbFornecedorPopupMenuWillBecomeVisible
        //TODO deletar evento
    }//GEN-LAST:event_cmbFornecedorPopupMenuWillBecomeVisible

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Deseja realmente cancelar a compra?\n" +
                " *Esta operação não poderá ser desfeita\n" +
                " caso seja executada.", "Atenção!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
            cancelar();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cancelar() {
        cmbFornecedor.setEnabled(true);
        txtPesqFornecedor.setEnabled(true);
        btnNovoProduto.setEnabled(true);
        btnSelecionar.setEnabled(true);
        btnNovoFornecedor.setEnabled(true);
        btnCompra.setEnabled(false);
        btnCancelar.setEnabled(false);
        txtNomeProduto.setEnabled(false);
        cmbCategoria.setEnabled(false);
        cmbFabricante.setEnabled(false);
        txtQTDE.setEnabled(false);
        lblProduto.setText("");
        lblValorTotal.setText("");
        lblValorUnit.setText("");
        txtPesqFornecedor.setText("");
        jScrollPane1.setVisible(false);
        btnMenos.setEnabled(false);
        btnMais.setEnabled(false);
        total = 0;
        tabelaNota.setModel(new DefaultTableModel(0, 0));
        forn = "";
        cat = "";
        marc = "";
        atualizarTabela(forn, cat, marc, prod);
        atualizaFornecedor(sqlf);
    }

    private void btnNovoFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoFornecedorActionPerformed
        frmCadFornecedor frm = new frmCadFornecedor(null, true);
        frm.setSize(800, 600);
        frm.setVisible(true);
        atualizaFornecedor(sqlf);
    }//GEN-LAST:event_btnNovoFornecedorActionPerformed

    private void btnNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProdutoActionPerformed
        frmCadProduto frmProd = new frmCadProduto(null, true);
        frmProd.setSize(830, 600);
        frmProd.setVisible(true);
        frmProd.setResizable(false);
        frmProd.setLocationRelativeTo(this);

    }//GEN-LAST:event_btnNovoProdutoActionPerformed

    private void cmbFabricantePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbFabricantePopupMenuWillBecomeInvisible
        if (cmbFabricante.getSelectedIndex() != 0) {
            marc = cmbFabricante.getSelectedItem().toString();
        } else {
            marc = "";
        }
        atualizarTabela(forn, cat, marc, prod);
    }//GEN-LAST:event_cmbFabricantePopupMenuWillBecomeInvisible

    private void cmbCategoriaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbCategoriaPopupMenuWillBecomeInvisible
        if (cmbCategoria.getSelectedIndex() != 0) {
            cat = cmbCategoria.getSelectedItem().toString();
        } else {
            cat = "";
        }
        atualizarTabela(forn, cat, marc, prod);
    }//GEN-LAST:event_cmbCategoriaPopupMenuWillBecomeInvisible

    private void tabelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyReleased
        if ((evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
            sincronizarProduto();
            tabelaNota.clearSelection();
            btnMais.setEnabled(true);
            btnMenos.setEnabled(false);
        }
    }//GEN-LAST:event_tabelaKeyReleased

    private void tabelaNotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaNotaMouseClicked
        cmm.indiceTabelaNota = tabelaNota.getSelectedRow();
        tabela.clearSelection();
        lblValorUnit.setText(tabelaNota.getValueAt(tabelaNota.getSelectedRow(), 2).toString());
        lblProduto.setText("");
        btnMais.setEnabled(true);
        btnMenos.setEnabled(true);
    }//GEN-LAST:event_tabelaNotaMouseClicked

    private void tabelaNotaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabelaNotaFocusGained
        btnMenos.setEnabled(true);
    }//GEN-LAST:event_tabelaNotaFocusGained

    private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed
        if (tabelaNota.getRowCount() > 0) {
            if (JOptionPane.showConfirmDialog(null, "Deseja realmente efetuar esta compra?", "Atenção!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                sdf = new SimpleDateFormat("hh:mm:ss");
                String sHora = sdf.format(new Date());
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                String sData = sdf.format(new Date());
                int cod = codfunc2.getCodigoFuncionario();
                con.Conecta();
                cadmov.cadastraCompra(lblValorTotal.getText(), sData, sHora, cod);
                for (int i = 0; i < tabelaNota.getRowCount(); i++) {
                    try {
                        meustate = Conexao.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                        resultset = meustate.executeQuery("SELECT * from tbl_produto where cod_produto = " + cadPro.getCodigoProduto(tabelaNota.getValueAt(i, 1).toString()));
                        resultset.next();
                        estoque = resultset.getString("unidades_em_estoque");
                    } catch (SQLException erro) {
                        System.out.println("Erro ao obter quantidade.");
                        erro.printStackTrace();
                    }
                    cadmov.cadastraCompraProduto(cadmov.getLastCodigoCompra(), cadPro.getCodigoProduto(tabelaNota.getValueAt(i, 1).toString()), tabelaNota.getValueAt(i, 0).toString(), estoque);
                }
                con.Fecha();
                if (cmbCategoria.getSelectedIndex() != 0) {
                    cat = cmbCategoria.getSelectedItem().toString();
                }
                if (cmbFabricante.getSelectedIndex() != 0) {
                    marc = cmbFabricante.getSelectedItem().toString();

                }
                cmbFornecedor.setEnabled(true);
                txtPesqFornecedor.setEnabled(true);
                btnNovoProduto.setEnabled(true);
                btnSelecionar.setEnabled(true);
                btnNovoFornecedor.setEnabled(true);
                btnCompra.setEnabled(false);
                btnCancelar.setEnabled(false);
                txtNomeProduto.setEnabled(false);
                cmbCategoria.setEnabled(false);
                cmbFabricante.setEnabled(false);
                txtQTDE.setEnabled(false);
                lblProduto.setText("");
                lblValorTotal.setText("");
                lblValorUnit.setText("");
                txtPesqFornecedor.setText("");
                jScrollPane1.setVisible(false);
                btnMenos.setEnabled(false);
                btnMais.setEnabled(false);
                total = 0;
                tabelaNota.setModel(new DefaultTableModel(0, 0));
                forn = "";
                cat = "";
                marc = "";
                atualizarTabela(forn, cat, marc, prod);
                atualizaFornecedor(sqlf);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não exitem produtos na lista de compra.", "Erro na compra", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnCompraActionPerformed

    private void txtQTDEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQTDEKeyReleased
        if (valida.isNumeric("" + evt.getKeyChar() + "") == false && (evt.getKeyCode() != KeyEvent.VK_UP) && (evt.getKeyCode() != KeyEvent.VK_DOWN) && (evt.getKeyCode() != KeyEvent.VK_LEFT) && (evt.getKeyCode() != KeyEvent.VK_RIGHT)) {
            Careto = txtQTDE.getCaretPosition();
            txtQTDE.setText(txtQTDE.getText().replaceAll("" + evt.getKeyChar() + "", ""));
            txtQTDE.setCaretPosition(Careto);
        }
    }//GEN-LAST:event_txtQTDEKeyReleased

    private void tabelaNotaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaNotaKeyReleased
        if ((evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
            cmm.indiceTabelaNota = tabelaNota.getSelectedRow();
            tabela.clearSelection();
            lblValorUnit.setText("0,00");
            lblProduto.setText("");
            btnMais.setEnabled(true);
            btnMenos.setEnabled(true);
        }
    }//GEN-LAST:event_tabelaNotaKeyReleased

    // Esse método cria e insere um modelo de tabela com dados
    // advindos de um banco de dados, através da instrução passada
    public void criarTabelaNota(JTable tabela) {
        // proíbe edição de celulas
        modelonota = new DefaultTableModel(nomecolunas, 0) {

            @Override
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                if (vColIndex == 0) {
                    return true;
                }
                return false;
            }
        };
        tabela.setModel(modelonota);
        tabela.setCellSelectionEnabled(false);
        tabela.setAutoResizeMode(0);
        tabela.setColumnSelectionAllowed(false);
        tabela.getTableHeader().setReorderingAllowed(false);
        //tabela.setBackground(Color.WHITE);
        tabela.setForeground(Color.BLACK);
        tabela.setSelectionBackground(new Color(57, 105, 138));
        tabela.setSelectionForeground(Color.WHITE);
        //tabela.setGridColor(Color.GRAY);
        tabela.setAutoCreateRowSorter(true);
        tabela.setShowHorizontalLines(true);
        tabela.setShowVerticalLines(true);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setRowSelectionAllowed(true);
        tabela.setIntercellSpacing(new Dimension(1, 1));
        tabela.setAutoCreateColumnsFromModel(true);
        tabela.setShowGrid(true);
        tabela.setOpaque(false);
        tabela.getTableHeader().setFont(new java.awt.Font("sansserif", 1, 12));
        System.out.println("Tabela atualizada.");
    }//Fim criarTabelaNota()
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCompra;
    private javax.swing.JButton btnMais;
    private javax.swing.JButton btnMenos;
    private javax.swing.JButton btnNovoFornecedor;
    private javax.swing.JButton btnNovoProduto;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JComboBox cmbCategoria;
    private javax.swing.JComboBox cmbFabricante;
    private javax.swing.JComboBox cmbFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JLabel lblValorUnit;
    private javax.swing.JTable tabela;
    private javax.swing.JTable tabelaNota;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtPesqFornecedor;
    private javax.swing.JTextField txtQTDE;
    // End of variables declaration//GEN-END:variables
}
