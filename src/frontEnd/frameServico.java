/*
 * frameServico.java
 *
 * Created on 01/05/2010, 12:13:07
 */
package frontEnd;

import Banco.CadServico;
import Banco.Conexao;
import Validacoes.Validacao;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class frameServico extends javax.swing.JInternalFrame {

    private Conexao con = new Conexao();
    private String sql, campo, msg = "";
    private CadServico cadSer;
    private Comum cmm = new Comum();
    private int progresso = 0, Careto = 0;
    private Validacao vld = new Validacao();

    public frameServico() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bntGrp = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        btnImprimir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblSelecionado = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnInserir = new javax.swing.JButton();
        txtGarantia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPrazo = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        cmbCampo = new javax.swing.JComboBox();
        txtPesquisa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();

        setTitle("SERVIÇO");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/servico_icone.png"))); // NOI18N
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

        jPanel3.setMaximumSize(new java.awt.Dimension(10, 40));
        jPanel3.setMinimumSize(new java.awt.Dimension(10, 40));
        jPanel3.setPreferredSize(new java.awt.Dimension(10, 40));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        btnImprimir.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/imprimir_icone.png"))); // NOI18N
        btnImprimir.setMnemonic('p');
        btnImprimir.setText("Imprimir");
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

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setHorizontalScrollBar(new javax.swing.JScrollBar(0));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(453, 200));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "SERVIÇOS"
            }
        ));
        tabela.setMinimumSize(new java.awt.Dimension(60, 50));
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

        jPanel1.setPreferredSize(new java.awt.Dimension(100, 195));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(null);

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
        btnCancelar.setBounds(640, 70, 90, 50);

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
        btnLimpar.setBounds(530, 70, 90, 50);

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
        btnExcluir.setBounds(420, 70, 90, 50);

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
        btnNovo.setBounds(420, 10, 90, 50);

        btnInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/inserir_icone.png"))); // NOI18N
        btnInserir.setMnemonic('I');
        btnInserir.setText("Inserir");
        btnInserir.setToolTipText("Inserir");
        btnInserir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInserir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });
        jPanel1.add(btnInserir);
        btnInserir.setBounds(530, 10, 90, 50);

        txtGarantia.setToolTipText("Garantia em meses");
        txtGarantia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtGarantiaFocusGained(evt);
            }
        });
        txtGarantia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGarantiaKeyReleased(evt);
            }
        });
        jPanel1.add(txtGarantia);
        txtGarantia.setBounds(120, 100, 70, 23);

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel4.setText("Garantia (meses):");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 100, 101, 16);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel3.setText("Prazo (dias):");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 74, 71, 16);

        txtPrazo.setToolTipText("Dias de prazo");
        txtPrazo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrazoFocusGained(evt);
            }
        });
        txtPrazo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrazoKeyReleased(evt);
            }
        });
        jPanel1.add(txtPrazo);
        txtPrazo.setBounds(90, 70, 60, 23);

        txtValor.setToolTipText("valor (em reais R$)");
        txtValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorFocusGained(evt);
            }
        });
        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValorKeyReleased(evt);
            }
        });
        jPanel1.add(txtValor);
        txtValor.setBounds(210, 70, 60, 23);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Valor:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(160, 74, 40, 16);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel1.setText("Descrição:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 44, 70, 16);

        txtDescricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescricaoFocusGained(evt);
            }
        });
        txtDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescricaoKeyReleased(evt);
            }
        });
        jPanel1.add(txtDescricao);
        txtDescricao.setBounds(90, 40, 200, 23);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "  Pesquisa ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 0, 12))); // NOI18N
        jPanel2.setLayout(null);

        cmbCampo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Valor", "Prazo", "Garantia", "Descrição" }));
        jPanel2.add(cmbCampo);
        cmbCampo.setBounds(10, 20, 110, 23);

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });
        jPanel2.add(txtPesquisa);
        txtPesquisa.setBounds(120, 20, 270, 23);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(420, 130, 410, 60);

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel5.setText("Código:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 14, 50, 16);

        txtCod.setEditable(false);
        txtCod.setText("<auto>");
        txtCod.setEnabled(false);
        jPanel1.add(txtCod);
        txtCod.setBounds(90, 10, 50, 23);

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
        btnAlterar.setBounds(640, 10, 90, 50);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Navegação ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 0, 12))); // NOI18N
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
        jPanel4.setBounds(0, 120, 320, 70);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Limpar() {
        txtCod.setText("");
        txtDescricao.setText("");
        txtDescricao.setBackground(Color.white);
        txtGarantia.setText("");
        txtGarantia.setBackground(Color.white);
        txtPrazo.setText("");
        txtPrazo.setBackground(Color.white);
        txtValor.setText("");
        txtValor.setBackground(Color.white);
    }

    private int validaTudo() {
        progresso = 0;
        msg = "";
        if (txtDescricao.getText().length() < 1) {
            progresso += 1;
            msg += "Descrição;";
            txtDescricao.setBackground(Color.red);
        }
        if (vld.isNumeric(txtPrazo.getText()) == false) {
            progresso += 1;
            msg += "Prazo;";
            txtPrazo.setBackground(Color.red);
        }
        if (vld.isDouble(txtValor.getText().replaceAll(",", ".")) == false) {
            progresso += 1;
            msg += "Valor;";
            txtValor.setBackground(Color.red);
        }
        if (vld.isNumeric(txtGarantia.getText()) == false) {
            progresso += 1;
            msg += "Garantia;";
            txtGarantia.setBackground(Color.red);
        }
        return progresso;
    }

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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        Limpar();
}//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        con.Conecta();
        cadSer = new CadServico();
        if (cadSer.possuiOrcamento(txtCod.getText()) == false && cadSer.possuiVendas(txtCod.getText()) == false) {
            con.Fecha();           
            if (JOptionPane.showConfirmDialog(this, "Deseja realmente excluir este serviço?\n" +
                    "*Esta operação não poderá ser desfeita\n" +
                    "caso seja executada.", "Atenção!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                btnExcluir.setEnabled(false);
                try {
                    progresso = 0;
                    progresso += cadSer.excluiServico(txtCod.getText());
                    if (progresso == 0) {
                        JOptionPane.showMessageDialog(this, "Serviço removido com sucesso!", "Operação bem-sucedida!", JOptionPane.INFORMATION_MESSAGE);
                        con.Fecha();
                        atualizarTabela();
                        cancelar();
                    } else {
                        JOptionPane.showMessageDialog(this, "Operação executada com " + progresso + " erro(s).", "Não foi possível excluir.", JOptionPane.ERROR_MESSAGE);
                        con.Fecha();
                    }
                } catch (Error e) {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir serviço.");
                    e.printStackTrace();
                    con.Fecha();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma categoria a ser excluida.");
                btnExcluir.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Existem orçamentos e/ou vendas que foram efetuadas deste serviço.\n" +
                    "Remova-os antes de continuar com esta operação.", "Este serviço não pode ser removido!", JOptionPane.WARNING_MESSAGE);
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
        txtPesquisa.setEnabled(false);
}//GEN-LAST:event_btnNovoActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        if (cmbCampo.getSelectedIndex() == 0) {
            campo = "valor = '" + txtPesquisa.getText() + "'";
        } else if (cmbCampo.getSelectedIndex() == 1) {
            campo = "prazo=" + txtPesquisa.getText();
        } else if (cmbCampo.getSelectedIndex() == 2) {
            campo = "garantia=" + txtPesquisa.getText();
        } else if (cmbCampo.getSelectedIndex() == 3) {
            campo = "descricao LIKE '" + txtPesquisa.getText() + "'%";
        }
        pesquisarTabela(campo);
}//GEN-LAST:event_txtPesquisaKeyReleased

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        if (tabela.getRowCount() < 1) {
            if (validaTudo() == 0) {
                try {
                    con.Conecta();
                    cadSer = new CadServico();
                    progresso = 0;
                    progresso += cadSer.cadastraServico(txtDescricao.getText(), txtValor.getText(), txtPrazo.getText(), txtGarantia.getText());
                    if (progresso == 0) {
                        JOptionPane.showMessageDialog(this, "Serviço incluído com sucesso!", "Operação bem-sucedida!", JOptionPane.INFORMATION_MESSAGE);
                        con.Fecha();
                        atualizarTabela();
                        cancelar();
                    } else {
                        JOptionPane.showMessageDialog(this, "Operação executada com " + progresso + " erro(s).", "Não foi possível incluir.", JOptionPane.ERROR_MESSAGE);
                        con.Fecha();
                    }
                } catch (Error erro) {
                    JOptionPane.showMessageDialog(this, "Não foi possível cadastrar.");
                    erro.printStackTrace();
                    con.Fecha();
                }
            } else {
                JOptionPane.showMessageDialog(this, msg, "Preencha o(s) seguinte(s) corretamente:", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Insira uma nova descrição para este serviço.", "Este serviço já existe!", JOptionPane.WARNING_MESSAGE);
            txtDescricao.setText("");
            txtDescricao.grabFocus();
        }
}//GEN-LAST:event_btnInserirActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        cancelar();
        atualizarTabela();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (btnAlterar.isSelected() == true) {
            setHabilitaTudo(true);
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
            cmbCampo.setEnabled(false);
            btnAlterar.setToolTipText("Salvar");
            btnAlterar.setText("Salvar");
            btnAlterar.setMnemonic('S');
        } else {

            if (validaTudo() == 0) {
                try {
                    con.Conecta();
                    cadSer = new CadServico();
                    progresso = 0;
                    progresso += cadSer.alteraServico(txtCod.getText(), txtDescricao.getText(), txtValor.getText(), txtPrazo.getText(), txtGarantia.getText());
                    if (progresso == 0) {
                        JOptionPane.showMessageDialog(this, "Serviço atualizado com sucesso!", "Operação bem-sucedida!", JOptionPane.INFORMATION_MESSAGE);
                        con.Fecha();
                        atualizarTabela();
                        cancelar();
                        btnAlterar.setToolTipText("Alterar");
                        btnAlterar.setText("Alterar");
                        btnAlterar.setMnemonic('A');
                    } else {
                        JOptionPane.showMessageDialog(this, "Operação executada com " + progresso + " erro(s).", "Não foi possível atualizar.", JOptionPane.ERROR_MESSAGE);
                        con.Fecha();
                        btnAlterar.setSelected(true);
                    }
                } catch (Error e) {
                    JOptionPane.showMessageDialog(this, "Erro ao alterar serviço.");
                    e.printStackTrace();
                    con.Fecha();
                }
            } else {
                JOptionPane.showMessageDialog(this, msg, "Preencha o(s) seguinte(s) corretamente:", JOptionPane.WARNING_MESSAGE);
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

    private void txtValorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyReleased
        try {
            Careto = txtValor.getCaretPosition();
            if (vld.isNumeric("" + evt.getKeyChar() + "") == false) {
                txtValor.setText(txtValor.getText().replaceAll("" + evt.getKeyChar() + "", ""));
            } else {
                txtValor.setText(String.format("%.2f", Double.parseDouble(txtValor.getText().replaceAll(",", "."))));
            }
            txtValor.setCaretPosition(Careto);
        } catch (IllegalArgumentException e) {
        }
    }//GEN-LAST:event_txtValorKeyReleased

    private void txtGarantiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGarantiaKeyReleased
        if (vld.isNumeric("" + evt.getKeyChar() + "") == false && (evt.getKeyCode() != KeyEvent.VK_UP) && (evt.getKeyCode() != KeyEvent.VK_DOWN) && (evt.getKeyCode() != KeyEvent.VK_LEFT) && (evt.getKeyCode() != KeyEvent.VK_RIGHT)) {
            try {
                Careto = txtGarantia.getCaretPosition();
                txtGarantia.setText(txtGarantia.getText().replaceAll("" + evt.getKeyChar() + "", ""));
                txtGarantia.setCaretPosition(Careto);
            } catch (IllegalArgumentException e) {
            }
        }
    }//GEN-LAST:event_txtGarantiaKeyReleased

    private void txtPrazoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrazoKeyReleased
        if (vld.isNumeric("" + evt.getKeyChar() + "") == false && (evt.getKeyCode() != KeyEvent.VK_UP) && (evt.getKeyCode() != KeyEvent.VK_DOWN) && (evt.getKeyCode() != KeyEvent.VK_LEFT) && (evt.getKeyCode() != KeyEvent.VK_RIGHT)) {
            try {
                Careto = txtPrazo.getCaretPosition();
                txtPrazo.setText(txtPrazo.getText().replaceAll("" + evt.getKeyChar() + "", ""));

                txtPrazo.setCaretPosition(Careto);

            } catch (IllegalArgumentException e) {
            }
        }
    }//GEN-LAST:event_txtPrazoKeyReleased

    private void txtDescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescricaoKeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            Careto = txtDescricao.getCaretPosition();
            cmm.getParaMaiuscula(txtDescricao);
            txtDescricao.setCaretPosition(Careto);
            pesquisarTabela("tbl_servico.descricao LIKE '" + txtDescricao.getText() + "'");
        }
    }//GEN-LAST:event_txtDescricaoKeyReleased

    private void txtDescricaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescricaoFocusGained
        txtDescricao.setBackground(Color.white);
    }//GEN-LAST:event_txtDescricaoFocusGained

    private void txtPrazoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrazoFocusGained
        txtPrazo.setBackground(Color.white);
    }//GEN-LAST:event_txtPrazoFocusGained

    private void txtValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorFocusGained
        txtValor.setBackground(Color.white);
    }//GEN-LAST:event_txtValorFocusGained

    private void txtGarantiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGarantiaFocusGained
        txtGarantia.setBackground(Color.white);
    }//GEN-LAST:event_txtGarantiaFocusGained

    private void setHabilitaTudo(boolean verdade) {
        txtDescricao.setEnabled(verdade);
        txtGarantia.setEnabled(verdade);
        txtPrazo.setEnabled(verdade);
        txtValor.setEnabled(verdade);
    }

    private void cancelar() {
        Limpar();
        setHabilitaTudo(false);
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
        txtPesquisa.setEnabled(true);
        cmbCampo.setEnabled(true);

    }

    private void atualizarTabela() {
        sql = "SELECT tbl_servico.cod_servico AS Código,tbl_servico.descricao AS Descrição," +
                "tbl_servico.valor AS Valor, tbl_servico.prazo AS Prazo, tbl_servico.garantia AS Garantia " +
                "FROM tbl_servico";
        cmm.criarTabelaServico(sql, tabela);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        lblTotal.setText(""+tabela.getRowCount());
    }

    private void pesquisarTabela(String campo) {
        sql = "SELECT tbl_servico.cod_servico AS Código,tbl_servico.descricao AS Descrição," +
                "tbl_servico.valor AS Valor, tbl_servico.prazo AS Prazo, tbl_servico.garantia AS Garantia " +
                "FROM tbl_servico WHERE " + campo;
        cmm.criarTabelaServico(sql, tabela);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        lblTotal.setText(""+tabela.getRowCount());
    }

    private void sincronizarTabela() {
        lblSelecionado.setText(""+(tabela.getSelectedRow()+1));
        txtCod.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
        txtDescricao.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        txtValor.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
        txtPrazo.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
        txtGarantia.setText(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());
        btnExcluir.setEnabled(true);
        btnAlterar.setEnabled(true);
        btnNovo.setEnabled(true);
        btnLimpar.setEnabled(false);
        btnInserir.setEnabled(false);
        btnCancelar.setEnabled(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bntGrp;
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
    private javax.swing.JComboBox cmbCampo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSelecionado;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtGarantia;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtPrazo;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
