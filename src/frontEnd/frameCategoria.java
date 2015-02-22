package frontEnd;

import Banco.CadCategoria;
import Banco.Conexao;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class frameCategoria extends javax.swing.JInternalFrame {

    private Conexao con = new Conexao();
    private Comum cmm = new Comum();

    ;
    private String sql, codigo;
    private CadCategoria cadCat;
    private int Careto = 0, progresso = 0;

    private void Limpar() {
        txtCategoria.setText("");
        codigo = "<auto>";
        tabela.clearSelection();
        lblSelecionado.setText("0");
    }//Fim Limpar

    /** Creates new form frameCategoria */
    public frameCategoria() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrp = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnInserir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        txtCategoria = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        txtConCategoria = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnImprimir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblSelecionado = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setTitle("CATEGORIA");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/categoria_icone.png"))); // NOI18N
        setOpaque(false);
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

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 200));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(null);

        btnInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/inserir_icone.png"))); // NOI18N
        btnInserir.setMnemonic('I');
        btnInserir.setText("Inserir");
        btnInserir.setToolTipText("Inserir");
        btnInserir.setEnabled(false);
        btnInserir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInserir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });
        jPanel1.add(btnInserir);
        btnInserir.setBounds(440, 10, 90, 50);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar_icone.png"))); // NOI18N
        btnCancelar.setMnemonic('C');
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setPreferredSize(new java.awt.Dimension(71, 26));
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(540, 70, 90, 50);

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/limpar_icone.png"))); // NOI18N
        btnLimpar.setMnemonic('L');
        btnLimpar.setText("Limpar");
        btnLimpar.setToolTipText("Limpar");
        btnLimpar.setEnabled(false);
        btnLimpar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLimpar.setPreferredSize(new java.awt.Dimension(71, 26));
        btnLimpar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpar);
        btnLimpar.setBounds(440, 70, 90, 50);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/stop_icone.png"))); // NOI18N
        btnExcluir.setMnemonic('E');
        btnExcluir.setText("Excluir");
        btnExcluir.setToolTipText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.setPreferredSize(new java.awt.Dimension(71, 26));
        btnExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluir);
        btnExcluir.setBounds(340, 70, 90, 50);

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/novo_icone.png"))); // NOI18N
        btnNovo.setMnemonic('N');
        btnNovo.setText("Novo");
        btnNovo.setToolTipText("Novo");
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovo.setPreferredSize(new java.awt.Dimension(71, 26));
        btnNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNovo);
        btnNovo.setBounds(340, 10, 90, 50);

        txtCategoria.setEnabled(false);
        txtCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCategoriaKeyReleased(evt);
            }
        });
        jPanel1.add(txtCategoria);
        txtCategoria.setBounds(80, 60, 240, 23);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel1.setText("Categoria:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 60, 70, 20);

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/alterar_icone.png"))); // NOI18N
        btnAlterar.setMnemonic('A');
        btnAlterar.setText("Alterar");
        btnAlterar.setToolTipText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlterar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/alterar_icone.png"))); // NOI18N
        btnAlterar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar_icone.png"))); // NOI18N
        btnAlterar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar_icone.png"))); // NOI18N
        btnAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAlterar);
        btnAlterar.setBounds(540, 10, 90, 50);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "  Pesquisa ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 11))); // NOI18N
        jPanel2.setLayout(null);

        txtConCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConCategoriaKeyReleased(evt);
            }
        });
        jPanel2.add(txtConCategoria);
        txtConCategoria.setBounds(90, 16, 330, 23);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel2.setText("Categoria:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 20, 70, 16);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(340, 150, 440, 50);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Navegação ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        jPanel4.setMaximumSize(new java.awt.Dimension(350, 100));
        jPanel4.setMinimumSize(new java.awt.Dimension(350, 100));
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(380, 180));
        jPanel4.setLayout(null);

        btnPrimeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/primeiro.png"))); // NOI18N
        btnPrimeiro.setToolTipText("Primeiro registro");
        btnPrimeiro.setPreferredSize(new java.awt.Dimension(90, 36));
        btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroActionPerformed(evt);
            }
        });
        jPanel4.add(btnPrimeiro);
        btnPrimeiro.setBounds(10, 20, 80, 36);

        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/anterior.png"))); // NOI18N
        btnAnterior.setToolTipText("Resgistro anterior");
        btnAnterior.setPreferredSize(new java.awt.Dimension(90, 36));
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        jPanel4.add(btnAnterior);
        btnAnterior.setBounds(90, 20, 70, 36);

        btnProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/proximo.png"))); // NOI18N
        btnProximo.setToolTipText("Resgistro posterior");
        btnProximo.setPreferredSize(new java.awt.Dimension(90, 36));
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });
        jPanel4.add(btnProximo);
        btnProximo.setBounds(160, 20, 70, 36);

        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ultimo.png"))); // NOI18N
        btnUltimo.setToolTipText("Último registro");
        btnUltimo.setPreferredSize(new java.awt.Dimension(90, 36));
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });
        jPanel4.add(btnUltimo);
        btnUltimo.setBounds(230, 20, 80, 36);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(0, 130, 320, 70);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setMaximumSize(new java.awt.Dimension(10, 40));
        jPanel3.setMinimumSize(new java.awt.Dimension(10, 40));
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(10, 41));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        btnImprimir.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/imprimir_icone.png"))); // NOI18N
        btnImprimir.setMnemonic('p');
        btnImprimir.setText("Imprimir");
        btnImprimir.setMaximumSize(new java.awt.Dimension(104, 40));
        btnImprimir.setPreferredSize(new java.awt.Dimension(104, 40));
        jPanel3.add(btnImprimir);

        jLabel3.setText("Total:");
        jPanel3.add(jLabel3);

        lblSelecionado.setFont(new java.awt.Font("Dialog", 0, 12));
        jPanel3.add(lblSelecionado);

        jLabel5.setText("Selecionado:");
        jPanel3.add(jLabel5);

        lblTotal.setFont(new java.awt.Font("Dialog", 0, 12));
        jPanel3.add(lblTotal);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(453, 353));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Categorias"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaMouseReleased(evt);
            }
        });
        tabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tabela);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        Limpar();
}//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        con.Conecta();
        cadCat = new CadCategoria();
        if (cadCat.possuiProdutos(txtCategoria.getText()) == false) {
            con.Fecha();
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta categoria?\n" +
                    "*Esta operação não poderá ser desfeita\n" +
                    "caso seja executada.", "Atenção!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    con.Conecta();
                    progresso = 0;
                    sql = "DELETE FROM tbl_categoria WHERE categoria = '" + txtCategoria.getText() + "'";
                    progresso += cadCat.excluiCategoria(sql);
                    if (progresso == 0) {
                        JOptionPane.showMessageDialog(this, "Categoria removida com sucesso!", "Operação bem-sucedida!", JOptionPane.INFORMATION_MESSAGE);
                        con.Fecha();
                        atualizarTabela();
                        cancelar();
                    } else {
                        JOptionPane.showMessageDialog(this, "Operação executada com " + progresso + " erro(s).", "Não foi possível excluir.", JOptionPane.ERROR_MESSAGE);
                        con.Fecha();
                    }
                } catch (Error e) {
                    JOptionPane.showMessageDialog(this, "Erro excluir cadastro.", "Erro", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                    con.Fecha();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Existem produtos cadastrados que dependem desta categoria.\n" +
                    "Remova-os antes de continuar com esta operação.", "Esta categoria não pode ser removida!", JOptionPane.WARNING_MESSAGE);
            con.Fecha();
            cancelar();
        }
}//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        Limpar();
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnNovo.setEnabled(false);
        btnLimpar.setEnabled(true);
        btnInserir.setEnabled(true);
        btnCancelar.setEnabled(true);
        setHabilitaTudo(true);
        tabela.setEnabled(false);
        btnPrimeiro.setEnabled(false);
        btnProximo.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnUltimo.setEnabled(false);
        tabela.clearSelection();
        lblSelecionado.setText("0");
        txtConCategoria.setEnabled(false);
        txtCategoria.grabFocus();
}//GEN-LAST:event_btnNovoActionPerformed

    private void txtConCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConCategoriaKeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            Careto = txtConCategoria.getCaretPosition();
            cmm.getParaMaiuscula(txtConCategoria);
            txtConCategoria.setCaretPosition(Careto);
            pesquisarTabela(txtConCategoria.getText());
        }
}//GEN-LAST:event_txtConCategoriaKeyReleased

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (evt.getClickCount() >= 0) {
            sincronizarTabela();
        }
}//GEN-LAST:event_tabelaMouseClicked

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        btnInserir.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnNovo.setEnabled(true);
        btnLimpar.setEnabled(false);
        btnCancelar.setEnabled(false);
        tabela.clearSelection();
        lblSelecionado.setText("0");
        setHabilitaTudo(false);
        atualizarTabela();
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoriaKeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            Careto = txtCategoria.getCaretPosition();
            cmm.getParaMaiuscula(txtCategoria);
            txtCategoria.setCaretPosition(Careto);
            pesquisarTabela(txtCategoria.getText());
        }
}//GEN-LAST:event_txtCategoriaKeyReleased

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        if (txtCategoria.getText().replaceAll(" ", "").length() == 0) {
            JOptionPane.showMessageDialog(this, "Digite a categoria corretamente", "Atenção!", JOptionPane.WARNING_MESSAGE);
            txtCategoria.grabFocus();
        } else if (tabela.getRowCount() < 1) {
            try {
                con.Conecta();
                cadCat = new CadCategoria();
                progresso = 0;
                sql = "INSERT INTO tbl_categoria (Categoria)VALUES('" +
                        txtCategoria.getText() + "')";
                progresso += cadCat.cadastraCategoria(sql);
                if (progresso == 0) {
                    JOptionPane.showMessageDialog(this, "Categoria incluída com sucesso!", "Operação bem-sucedida!", JOptionPane.INFORMATION_MESSAGE);
                    con.Fecha();
                    atualizarTabela();
                    cancelar();
                } else {
                    JOptionPane.showMessageDialog(this, "Operação executada com " + progresso + " erro(s).", "Não foi possível incluir.", JOptionPane.ERROR_MESSAGE);
                    con.Fecha();
                }
            } catch (Error e) {
                JOptionPane.showMessageDialog(this, "Erro ao efetuar cadastro.");
                e.printStackTrace();
                con.Fecha();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Insira uma nova categoria.", "Este categoria já existe!", JOptionPane.WARNING_MESSAGE);
            txtCategoria.setText("");
            txtCategoria.grabFocus();
        }
}//GEN-LAST:event_btnInserirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (btnAlterar.isSelected() == true) {
            txtCategoria.setEnabled(true);
            btnCancelar.setEnabled(true);
            btnAlterar.setEnabled(true);
            btnInserir.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnNovo.setEnabled(false);
            btnLimpar.setEnabled(false);
            tabela.setEnabled(false);
            btnPrimeiro.setEnabled(false);
            btnProximo.setEnabled(false);
            btnAnterior.setEnabled(false);
            btnUltimo.setEnabled(false);
            tabela.clearSelection();
            lblSelecionado.setText("0");
            txtConCategoria.setEnabled(false);
            btnAlterar.setToolTipText("Salvar");
            btnAlterar.setText("Salvar");
            btnAlterar.setMnemonic('S');
        } else {
            if (txtCategoria.getText().replaceAll(" ", "").length() == 0) {
                JOptionPane.showMessageDialog(this, "Digite a categoria corretamente", "Atenção!", JOptionPane.WARNING_MESSAGE);
                txtCategoria.grabFocus();
            } else if ((tabela.getRowCount() > 0 && tabela.getValueAt(0,1).toString().equals(txtCategoria.getText())==true) || tabela.getRowCount()<1) {
                try {
                    con.Conecta();
                    cadCat = new CadCategoria();
                    progresso = 0;
                    sql = "UPDATE tbl_categoria SET categoria = '" + txtCategoria.getText() +
                            "' WHERE cod_categoria=" + codigo;
                    progresso += cadCat.alteraCategoria(sql);
                    if (progresso == 0) {
                        JOptionPane.showMessageDialog(this, "Categoria atualizada com sucesso!", "Operação bem-sucedida!", JOptionPane.INFORMATION_MESSAGE);
                        con.Fecha();
                        atualizarTabela();
                        cancelar();
                    } else {
                        JOptionPane.showMessageDialog(this, "Operação executada com " + progresso + " erro(s).", "Não foi possível atualizar.", JOptionPane.ERROR_MESSAGE);
                        con.Fecha();
                        btnAlterar.setSelected(true);
                    }
                } catch (Error e) {
                    JOptionPane.showMessageDialog(this, "Erro ao efetuar alteração.","Erro",JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                    con.Fecha();
                    btnAlterar.setSelected(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Insira uma nova categoria.", "Esta categoria já existe!", JOptionPane.WARNING_MESSAGE);
                txtCategoria.setText("");
                txtCategoria.grabFocus();
            }
        }
}//GEN-LAST:event_btnAlterarActionPerformed

    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
        cmm.Primeiro(tabela);
        sincronizarTabela();
}//GEN-LAST:event_btnPrimeiroActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        cmm.Anterior(tabela);
        sincronizarTabela();
}//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        cmm.Proximo(tabela);
        sincronizarTabela();
}//GEN-LAST:event_btnProximoActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        cmm.Ultimo(tabela);
        sincronizarTabela();
}//GEN-LAST:event_btnUltimoActionPerformed

    private void tabelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyReleased
        if ((evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
            sincronizarTabela();
        }
    }//GEN-LAST:event_tabelaKeyReleased

    private void tabelaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseReleased
        sincronizarTabela();
    }//GEN-LAST:event_tabelaMouseReleased

    private void cancelar() {
        Limpar();
        txtCategoria.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnInserir.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnAlterar.setSelected(false);
        btnAlterar.setToolTipText("Alterar");
        btnAlterar.setText("Alterar");
        btnAlterar.setMnemonic('A');
        btnExcluir.setEnabled(false);
        btnLimpar.setEnabled(false);
        btnNovo.setEnabled(true);
        tabela.clearSelection();
        lblSelecionado.setText("0");
        tabela.setEnabled(true);
        btnPrimeiro.setEnabled(true);
        btnProximo.setEnabled(true);
        btnAnterior.setEnabled(true);
        btnUltimo.setEnabled(true);
        txtConCategoria.setEnabled(true);
    }

    private void atualizarTabela() {
        sql = "SELECT tbl_categoria.cod_categoria as Código,tbl_categoria.categoria AS " +
                "Categoria FROM tbl_categoria ORDER BY tbl_categoria.categoria";
        cmm.criarTabela(sql, tabela);        
        tabela.setAutoResizeMode(1);
        lblTotal.setText(""+tabela.getRowCount());
    }

    private void pesquisarTabela(String campo) {
        sql = "SELECT tbl_categoria.cod_categoria as Código," +
                "tbl_categoria.categoria as Categoria FROM tbl_categoria " +
                "WHERE tbl_categoria.categoria LIKE '" + campo + "%' ORDER BY tbl_categoria.categoria";
        cmm.criarTabela(sql, tabela);
        lblTotal.setText(""+tabela.getRowCount());
        tabela.setAutoResizeMode(1);
    }

    private void sincronizarTabela() {
        lblSelecionado.setText(""+(tabela.getSelectedRow()+1));
        codigo = tabela.getValueAt(tabela.getSelectedRow(), 0).toString();
        txtCategoria.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        btnAlterar.setEnabled(true);
        btnAlterar.setSelected(false);
        btnExcluir.setEnabled(true);
        btnNovo.setEnabled(true);
        btnLimpar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnInserir.setEnabled(false);        
    }

    private void setHabilitaTudo(boolean verdade) {
        txtCategoria.setEnabled(verdade);
    }//Fim setHabilitaTudo

    //public static void main(String args[]) {
    //    java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
        frmCadCategoria dialog = new frmCadCategoria(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {

            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
    }
    // });
    //}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAlterar;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnUltimo;
    private javax.swing.ButtonGroup btngrp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSelecionado;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtConCategoria;
    // End of variables declaration//GEN-END:variables
}
