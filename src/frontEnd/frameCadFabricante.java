/*
 * frameCadFabricante.java
 *
 * Created on 01/05/2010, 11:38:00
 */
package frontEnd;

import Banco.CadFabricante;
import Banco.Conexao;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Programador
 */
public class frameCadFabricante extends javax.swing.JInternalFrame {

    private CadFabricante cadFab;
    private int progresso, Careto;
    private String sql;
    private Conexao con = new Conexao();
    private Comum cmm = new Comum();

    private void Limpar() {
        txtFabricante.setText("");
        txtCod.setText("");
        tabela.clearSelection();
        lblSelecionado.setText("0");
    }

    /** Creates new form frameCadFabricante */
    public frameCadFabricante() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFabricante = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnInserir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtPesquisa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnImprimir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblSelecionado = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("FABRICANTE");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fabricante_icone.png"))); // NOI18N
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

        painel.setMaximumSize(new java.awt.Dimension(0, 100));
        painel.setMinimumSize(new java.awt.Dimension(0, 100));
        painel.setPreferredSize(new java.awt.Dimension(0, 200));
        painel.setLayout(null);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel1.setText("Fabricante:");
        painel.add(jLabel1);
        jLabel1.setBounds(20, 60, 70, 20);

        txtFabricante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFabricanteKeyReleased(evt);
            }
        });
        painel.add(txtFabricante);
        txtFabricante.setBounds(90, 54, 240, 23);

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
        painel.add(btnNovo);
        btnNovo.setBounds(350, 10, 90, 50);

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
        painel.add(btnInserir);
        btnInserir.setBounds(450, 10, 90, 50);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar_icone.png"))); // NOI18N
        btnCancelar.setMnemonic('C');
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setPreferredSize(new java.awt.Dimension(71, 26));
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        painel.add(btnCancelar);
        btnCancelar.setBounds(550, 70, 90, 50);

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/limpar_icone.png"))); // NOI18N
        btnLimpar.setMnemonic('L');
        btnLimpar.setText("Limpar");
        btnLimpar.setToolTipText("Limpar");
        btnLimpar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLimpar.setPreferredSize(new java.awt.Dimension(71, 26));
        btnLimpar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        painel.add(btnLimpar);
        btnLimpar.setBounds(450, 70, 90, 50);

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
        painel.add(btnExcluir);
        btnExcluir.setBounds(350, 70, 90, 50);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "  Pesquisa ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        jPanel2.setLayout(null);

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });
        jPanel2.add(txtPesquisa);
        txtPesquisa.setBounds(90, 14, 230, 23);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel3.setText("Fabricante: ");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 20, 70, 16);

        painel.add(jPanel2);
        jPanel2.setBounds(340, 150, 340, 50);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel2.setText("Código:");
        painel.add(jLabel2);
        jLabel2.setBounds(20, 20, 50, 16);

        txtCod.setEditable(false);
        txtCod.setText("<auto>");
        txtCod.setEnabled(false);
        painel.add(txtCod);
        txtCod.setBounds(90, 20, 50, 28);

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
        painel.add(btnAlterar);
        btnAlterar.setBounds(550, 10, 90, 50);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Navegação ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(350, 100));
        jPanel1.setMinimumSize(new java.awt.Dimension(350, 100));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(380, 180));
        jPanel1.setLayout(null);

        btnPrimeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/primeiro.png"))); // NOI18N
        btnPrimeiro.setToolTipText("Primeiro registro");
        btnPrimeiro.setPreferredSize(new java.awt.Dimension(90, 36));
        btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrimeiro);
        btnPrimeiro.setBounds(20, 20, 80, 36);

        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/anterior.png"))); // NOI18N
        btnAnterior.setToolTipText("Resgistro anterior");
        btnAnterior.setPreferredSize(new java.awt.Dimension(90, 36));
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnterior);
        btnAnterior.setBounds(100, 20, 70, 36);

        btnProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/proximo.png"))); // NOI18N
        btnProximo.setToolTipText("Resgistro posterior");
        btnProximo.setPreferredSize(new java.awt.Dimension(90, 36));
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });
        jPanel1.add(btnProximo);
        btnProximo.setBounds(170, 20, 70, 36);

        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ultimo.png"))); // NOI18N
        btnUltimo.setToolTipText("Último registro");
        btnUltimo.setPreferredSize(new java.awt.Dimension(90, 36));
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });
        jPanel1.add(btnUltimo);
        btnUltimo.setBounds(240, 20, 80, 36);

        painel.add(jPanel1);
        jPanel1.setBounds(0, 140, 340, 70);

        getContentPane().add(painel, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.focus"));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Fabricantes"
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
        tabela.setAutoscrolls(false);
        tabela.setOpaque(false);
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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

        jPanel3.setMaximumSize(new java.awt.Dimension(10, 40));
        jPanel3.setMinimumSize(new java.awt.Dimension(10, 40));
        jPanel3.setPreferredSize(new java.awt.Dimension(10, 40));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        btnImprimir.setFont(new java.awt.Font("sansserif", 1, 12));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/imprimir_icone.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnImprimir.setMaximumSize(new java.awt.Dimension(104, 40));
        btnImprimir.setPreferredSize(new java.awt.Dimension(104, 40));
        jPanel3.add(btnImprimir);

        jLabel9.setText("Selecionado:");
        jPanel3.add(jLabel9);

        lblSelecionado.setFont(new java.awt.Font("Dialog", 0, 12));
        jPanel3.add(lblSelecionado);

        jLabel10.setText("Total:");
        jPanel3.add(jLabel10);

        lblTotal.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jPanel3.add(lblTotal);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        Limpar();
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnNovo.setEnabled(false);
        btnLimpar.setEnabled(true);
        btnInserir.setEnabled(true);
        btnCancelar.setEnabled(true);
        txtFabricante.setEnabled(true);
        tabela.setEnabled(false);
        btnPrimeiro.setEnabled(false);
        btnProximo.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnUltimo.setEnabled(false);
        tabela.clearSelection();
        lblSelecionado.setText("0");
        txtPesquisa.setEnabled(false);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        if (txtFabricante.getText().replaceAll(" ", "").length() > 0) {
            if (tabela.getRowCount() < 1) {
                try {
                    con.Conecta();
                    cadFab = new CadFabricante();
                    progresso = 0;
                    progresso += cadFab.cadastraFabricante(txtFabricante.getText());
                    if (progresso == 0) {
                        JOptionPane.showMessageDialog(this, "Fabricante cadastrado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        con.Fecha();
                        cancelar();
                        atualizarTabela();
                    } else {
                        JOptionPane.showMessageDialog(this, "Erro encontrado ao tentar cadastrar fabricante.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Error erro) {
                    JOptionPane.showMessageDialog(this, "Não foi possível cadastrar.", "Erro!", JOptionPane.ERROR_MESSAGE);
                    erro.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Insira um novo fabricante.", "Este fabricante já existe!", JOptionPane.WARNING_MESSAGE);
                txtFabricante.setText("");
                txtFabricante.grabFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "O campo Fabricante não pode ficar em branco!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            txtFabricante.grabFocus();
        }

}//GEN-LAST:event_btnInserirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        Limpar();
}//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        cadFab = new CadFabricante();
        con.Conecta();
        if (cadFab.possuiProdutos(txtFabricante.getText()) == false) {
            con.Fecha();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir este fabricante?\n" +
                    "*Esta operação não poderá ser desfeita\n" +
                    "caso seja executada.", "Atenção!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    con.Conecta();
                    progresso = 0;
                    progresso += cadFab.excluirFabricante(txtFabricante.getText());
                    if (progresso == 0) {
                        JOptionPane.showMessageDialog(this, "Fabricante excluído.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        con.Fecha();
                        cancelar();
                        atualizarTabela();
                    } else {
                        JOptionPane.showMessageDialog(this, "Erro encontrado ao tentar excluir fabricante.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Error erro) {
                    JOptionPane.showMessageDialog(this, "Não foi possível cadastrar.");
                    erro.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Existem produtos cadastrados que dependem deste fabricante.\n" +
                    "Remova-os antes de continuar com esta operação.", "Este fabricante não pode ser removido!", JOptionPane.WARNING_MESSAGE);
            cancelar();
        }
}//GEN-LAST:event_btnExcluirActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            Careto = txtPesquisa.getCaretPosition();
            cmm.getParaMaiuscula(txtPesquisa);
            txtPesquisa.setCaretPosition(Careto);
            pesquisarTabela(txtPesquisa.getText());
        }
}//GEN-LAST:event_txtPesquisaKeyReleased

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (btnAlterar.isSelected() == true) {
            txtFabricante.setEnabled(true);
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
            txtPesquisa.setEnabled(false);
            btnAlterar.setToolTipText("Salvar");
            btnAlterar.setText("Salvar");
            btnAlterar.setMnemonic('S');
        } else {
            if (txtFabricante.getText().replaceAll(" ", "").length() > 0) {
                if (tabela.getRowCount() < 1 || tabela.getValueAt(0,1).toString().equals(txtFabricante.getText())==true) {
                    try {
                        con.Conecta();
                        cadFab = new CadFabricante();
                        progresso = 0;
                        progresso += cadFab.alteraFabricante(txtFabricante.getText(), txtCod.getText());
                        if (progresso == 0) {
                            JOptionPane.showMessageDialog(this, "Fabricante alterado.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                            con.Fecha();
                            cancelar();
                            atualizarTabela();
                            btnAlterar.setToolTipText("Alterar");
                            btnAlterar.setText("Alterar");
                            btnAlterar.setMnemonic('A');
                            btnAlterar.setSelected(false);
                        } else {
                            JOptionPane.showMessageDialog(this, "Erro encontrado ao tentar alterar fabricante.", "Erro", JOptionPane.ERROR_MESSAGE);
                            btnAlterar.setSelected(false);
                        }
                    } catch (Error er) {
                        System.out.print("Não foi possível alterar fabricante.");
                        er.printStackTrace();
                        btnAlterar.setSelected(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Insira um novo fabricante.", "Este fabricante já existe!", JOptionPane.WARNING_MESSAGE);
                    txtFabricante.setText("");
                    txtFabricante.grabFocus();
                    btnAlterar.setSelected(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "O campo Fabricante não pode ficar em branco!", "Atenção!", JOptionPane.WARNING_MESSAGE);
                txtFabricante.grabFocus();
                btnAlterar.setSelected(false);
            }
        }
}//GEN-LAST:event_btnAlterarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (evt.getClickCount() >= 0) {
            sincronizarTabela();
        }
}//GEN-LAST:event_tabelaMouseClicked

    private void tabelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyReleased
        if ((evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
            sincronizarTabela();
        }
}//GEN-LAST:event_tabelaKeyReleased

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        cancelar();
        atualizarTabela();
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtFabricanteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFabricanteKeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            Careto = txtFabricante.getCaretPosition();
            cmm.getParaMaiuscula(txtFabricante);
            txtFabricante.setCaretPosition(Careto);
            pesquisarTabela(txtFabricante.getText());
        }
    }//GEN-LAST:event_txtFabricanteKeyReleased

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

    private void cancelar() {
        Limpar();
        txtFabricante.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnInserir.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnAlterar.setSelected(false);
        btnAlterar.setText("Alterar");
        btnAlterar.setToolTipText("Alterar");
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
        txtPesquisa.setEnabled(true);

    }

    private void pesquisarTabela(String Campo) {
        sql = "SELECT tbl_fabricante.cod_fabricante AS Código, " +
                "tbl_fabricante.fabricante AS Fabricante FROM tbl_fabricante " +
                "WHERE fabricante LIKE '" + Campo + "%' ORDER BY fabricante";
        cmm.criarTabela(sql, tabela);
        tabela.setAutoResizeMode(3);
        lblTotal.setText(""+tabela.getRowCount());
    }//Fim atualizarTabela

    private void atualizarTabela() {
        sql = "SELECT tbl_fabricante.cod_fabricante AS Código," +
                "tbl_fabricante.fabricante AS Fabricante " +
                "FROM tbl_fabricante ORDER BY fabricante";
        cmm.criarTabela(sql, tabela);
        tabela.setAutoResizeMode(3);
        lblTotal.setText(""+tabela.getRowCount());
    }//Fim pesquisarTabela

    private void sincronizarTabela() {
        lblSelecionado.setText(""+(tabela.getSelectedRow()+1));
        txtCod.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
        txtFabricante.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        txtFabricante.setEnabled(false);
        btnExcluir.setEnabled(true);
        btnAlterar.setEnabled(true);
        btnNovo.setEnabled(true);
        btnLimpar.setEnabled(false);
        btnInserir.setEnabled(false);
        btnCancelar.setEnabled(false);
    }
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSelecionado;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel painel;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtFabricante;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
