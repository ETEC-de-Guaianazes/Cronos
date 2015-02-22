package frontEnd;

import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import Banco.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class frameVenda extends javax.swing.JInternalFrame {

    //private Conexao con = new Conexao();
    private SimpleDateFormat sdf;
    private String sql, sqlc = "SELECT * FROM tbl_cliente ORDER BY nome";
    private CadMovimentacao cadmov = new CadMovimentacao();
    private Comum cmm = new Comum();
    private double total = 0, unitario = 0;
    private int quantidade = 0, estoque = 0, nivel = 0, qtd = 0, i = 0;
    public sessao codfunc;
    private DefaultComboBoxModel mdlCategoria, mdlFabricante, mdlCliente, mdlServico, mdlCpf, mdlcod;
    private CadProduto cadPro = new CadProduto();
    private CadCliente cadcli = new CadCliente();
    private CadServico cadser = new CadServico();
    private String forn = "", cat = "", marc = "", prod = "", cli = "", serv = "";
    private dlgQuantidade frmQtde;
    private String totalS;
    private int Careto = 0, add = 0, linha = 0;
    private DefaultTableModel modelonota;
    Conexao con = new Conexao();
    public String cod_tipo_pag = "";
    private String nomecolunas[] = {"Tipo", "Qtde.", "Produto", "Valor unitário", "Valor total"};

    public frameVenda() {
        initComponents();
    }

    private void atualizarTabela(String fornecedor, String categoria, String marca, String produto) {
        sql = "SELECT tbl_produto.cod_produto AS \"Código\", tbl_produto.nome_produto AS Produto, tbl_produto.descricao AS \"Descrição\"," +
                "tbl_produto.valor AS \"Valor de Venda\",tbl_produto.unidades_em_estoque AS \"Unidades em Estoque\",tbl_produto.unidades_reposicao AS \"Nível de reposição\"," +
                "tbl_fabricante.fabricante AS \"Fabricante\", tbl_categoria.categoria AS Categoria, tbl_fornecedor.nome_fornecedor AS Fornecedor FROM tbl_categoria INNER JOIN " +
                "(tbl_fornecedor INNER JOIN (tbl_fabricante INNER JOIN tbl_produto " +
                "ON tbl_fabricante.cod_fabricante = tbl_produto.cod_fabricante) ON " +
                "tbl_fornecedor.cod_fornecedor = tbl_produto.cod_fornecedor) ON " +
                "tbl_categoria.cod_categoria = tbl_produto.cod_categoria WHERE tbl_fornecedor.nome_fornecedor LIKE '" + fornecedor + "%' AND tbl_categoria.categoria LIKE '" + categoria + "%' AND tbl_fabricante.fabricante LIKE '" + marca + "%' AND tbl_produto.nome_produto LIKE '" + produto + "%'";
        cmm.criarTabelaProdutoVenda(sql, tabelaProdutos);
        tabelaProdutos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    private void atualizarTabelaServico(String servico) {
        sql = "SELECT tbl_servico.cod_servico AS \"Código\", tbl_servico.descricao AS \"Serviço\", tbl_servico.valor AS \"Valor do Serviço\", tbl_servico.prazo AS \"Prazo Estipulado\", tbl_servico.garantia AS \"Garantia\" FROM tbl_servico";
        cmm.criarTabelaServico(sql, tabelaProdutos);
        tabelaProdutos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    private void atualizaClientes() {
        mdlCliente = new DefaultComboBoxModel();
        mdlCpf = new DefaultComboBoxModel();
        mdlcod = new DefaultComboBoxModel();
        cadcli = new CadCliente();
        cadcli.setListaComboCliente(mdlCliente, cmbCliente, cmbCpf, mdlCpf, cmbCodigo, mdlcod);
    }

    private void atualizarCombos() {
        cadPro = new CadProduto();
        sql = "SELECT * FROM tbl_fabricante";
        mdlFabricante = new DefaultComboBoxModel();
        cadPro.getListaCombo2(cmbFabricante, mdlFabricante, sql);
        sql = "SELECT * FROM tbl_categoria";
        mdlCategoria = new DefaultComboBoxModel();
        cadPro.getListaCombo2(cmbCategoria, mdlCategoria, sql);
        sql = "SELECT * FROM tbl_servico";
        mdlServico = new DefaultComboBoxModel();
        cadPro.getListaCombo2(cmbServico, mdlServico, sql);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotoes = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        cmbCpf = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox();
        btnSelecionar = new javax.swing.JButton();
        lblProduto = new javax.swing.JLabel();
        lblServico = new javax.swing.JLabel();
        painelservico = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        cmbServico = new javax.swing.JComboBox();
        txtpesqServico = new javax.swing.JTextField();
        painelProduto = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        cmbFabricante = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txtPesqNome = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        cmbCodigo = new javax.swing.JComboBox();
        rbtProduto = new javax.swing.JRadioButton();
        rbtServico = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblValorUnit = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblValorTotal = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnVenda = new javax.swing.JButton();
        btnMais = new javax.swing.JButton();
        btnMenos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaNota = new javax.swing.JTable();
        btnOrcamento = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtQTDE = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();

        setTitle("VENDA");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/venda_icone.png"))); // NOI18N
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

        jPanel1.setPreferredSize(new java.awt.Dimension(100, 120));
        jPanel1.setLayout(null);

        cmbCpf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCpf.setEnabled(false);
        jPanel1.add(cmbCpf);
        cmbCpf.setBounds(210, 32, 150, 20);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setText("Cliente:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 10, 60, 20);

        cmbCliente.setPreferredSize(null);
        cmbCliente.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbClientePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel1.add(cmbCliente);
        cmbCliente.setBounds(400, 10, 340, 20);

        btnSelecionar.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSelecionar);
        btnSelecionar.setBounds(740, 10, 100, 22);

        lblProduto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblProduto.setText("_");
        lblProduto.setPreferredSize(new java.awt.Dimension(100, 44));
        jPanel1.add(lblProduto);
        lblProduto.setBounds(300, 30, 270, 40);

        lblServico.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblServico.setText("_");
        lblServico.setPreferredSize(new java.awt.Dimension(100, 44));
        jPanel1.add(lblServico);
        lblServico.setBounds(740, 30, 230, 40);

        painelservico.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N
        painelservico.setPreferredSize(new java.awt.Dimension(100, 280));
        painelservico.setLayout(null);

        jLabel15.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel15.setText("Serviço:");
        painelservico.add(jLabel15);
        jLabel15.setBounds(20, 10, 50, 20);

        cmbServico.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbServicoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        painelservico.add(cmbServico);
        cmbServico.setBounds(380, 10, 310, 22);

        txtpesqServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpesqServicoKeyReleased(evt);
            }
        });
        painelservico.add(txtpesqServico);
        txtpesqServico.setBounds(70, 10, 300, 22);

        jPanel1.add(painelservico);
        painelservico.setBounds(30, 120, 660, 30);

        painelProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        painelProduto.setLayout(null);

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setText("Produto:");
        painelProduto.add(jLabel5);
        jLabel5.setBounds(10, 10, 60, 20);

        txtNomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeProdutoActionPerformed(evt);
            }
        });
        txtNomeProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeProdutoKeyReleased(evt);
            }
        });
        painelProduto.add(txtNomeProduto);
        txtNomeProduto.setBounds(70, 10, 190, 22);

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel6.setText("Categoria:");
        painelProduto.add(jLabel6);
        jLabel6.setBounds(270, 10, 60, 20);

        cmbCategoria.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbCategoriaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        painelProduto.add(cmbCategoria);
        cmbCategoria.setBounds(330, 10, 180, 22);

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel9.setText("Marca:");
        painelProduto.add(jLabel9);
        jLabel9.setBounds(520, 10, 39, 20);

        cmbFabricante.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbFabricantePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        painelProduto.add(cmbFabricante);
        cmbFabricante.setBounds(570, 10, 170, 22);

        jPanel1.add(painelProduto);
        painelProduto.setBounds(0, 70, 880, 40);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel1.setText("CPF:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 40, 25, 16);

        txtPesqNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesqNomeKeyReleased(evt);
            }
        });
        jPanel1.add(txtPesqNome);
        txtPesqNome.setBounds(60, 10, 330, 22);

        lblCpf.setText("000.000.000-00");
        jPanel1.add(lblCpf);
        lblCpf.setBounds(60, 40, 100, 16);

        cmbCodigo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0" }));
        cmbCodigo.setEnabled(false);
        jPanel1.add(cmbCodigo);
        cmbCodigo.setBounds(390, 32, 90, 20);

        grupoBotoes.add(rbtProduto);
        rbtProduto.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        rbtProduto.setText("Produto:");
        rbtProduto.setOpaque(false);
        rbtProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtProdutoActionPerformed(evt);
            }
        });
        jPanel1.add(rbtProduto);
        rbtProduto.setBounds(160, 30, 140, 40);

        grupoBotoes.add(rbtServico);
        rbtServico.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        rbtServico.setText("Serviço:");
        rbtServico.setOpaque(false);
        rbtServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtServicoActionPerformed(evt);
            }
        });
        jPanel1.add(rbtServico);
        rbtServico.setBounds(580, 30, 130, 40);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setPreferredSize(new java.awt.Dimension(370, 300));
        jPanel3.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel10.setText("Valor Unit: R$ ");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(450, 80, 160, 30);

        lblValorUnit.setFont(new java.awt.Font("Tahoma", 0, 24));
        lblValorUnit.setText("0,00");
        jPanel3.add(lblValorUnit);
        lblValorUnit.setBounds(610, 80, 250, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel16.setText("Valor Total: R$");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(440, 140, 159, 29);

        lblValorTotal.setFont(new java.awt.Font("Tahoma", 0, 24));
        lblValorTotal.setText("0,00");
        jPanel3.add(lblValorTotal);
        lblValorTotal.setBounds(610, 140, 250, 30);

        btnCancelar.setFont(new java.awt.Font("sansserif", 1, 12));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar_icone.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelar);
        btnCancelar.setBounds(750, 220, 110, 60);

        btnVenda.setFont(new java.awt.Font("sansserif", 1, 12));
        btnVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/compra_icone.png"))); // NOI18N
        btnVenda.setText("Vender");
        btnVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVendaMouseClicked(evt);
            }
        });
        btnVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendaActionPerformed(evt);
            }
        });
        jPanel3.add(btnVenda);
        btnVenda.setBounds(630, 220, 110, 60);

        btnMais.setFont(new java.awt.Font("sansserif", 1, 12));
        btnMais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/inserir_icone.png"))); // NOI18N
        btnMais.setText("Adicionar");
        btnMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaisActionPerformed(evt);
            }
        });
        jPanel3.add(btnMais);
        btnMais.setBounds(600, 10, 120, 60);

        btnMenos.setFont(new java.awt.Font("sansserif", 1, 12));
        btnMenos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/remover_icone.png"))); // NOI18N
        btnMenos.setText("Remover");
        btnMenos.setEnabled(false);
        btnMenos.setPreferredSize(new java.awt.Dimension(77, 23));
        btnMenos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenosMouseClicked(evt);
            }
        });
        btnMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosActionPerformed(evt);
            }
        });
        jPanel3.add(btnMenos);
        btnMenos.setBounds(740, 10, 120, 60);

        tabelaNota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Qtde.", "Produto", "Valor unitário", "Valor total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        tabelaNota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaNotaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaNota);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(10, 10, 420, 280);

        btnOrcamento.setFont(new java.awt.Font("sansserif", 1, 12));
        btnOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar_icone.png"))); // NOI18N
        btnOrcamento.setText("Salvar orçamento");
        btnOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrcamentoActionPerformed(evt);
            }
        });
        jPanel3.add(btnOrcamento);
        btnOrcamento.setBounds(450, 220, 170, 60);

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel8.setText("QTDE:");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(440, 20, 40, 30);

        txtQTDE.setText("1");
        txtQTDE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQTDEKeyReleased(evt);
            }
        });
        jPanel3.add(txtQTDE);
        txtQTDE.setBounds(490, 20, 80, 22);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutosMouseClicked(evt);
            }
        });
        tabelaProdutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaProdutosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProdutos);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void habilitarProduto(boolean produtoHabilitado) {
        painelProduto.setVisible(produtoHabilitado);
        btnMais.setEnabled(false);
        btnMenos.setEnabled(false);
        lblServico.setEnabled(!produtoHabilitado);
        cmbServico.setEnabled(!produtoHabilitado);
        txtpesqServico.setEnabled(!produtoHabilitado);
        cmbServico.setEnabled(!produtoHabilitado);
        lblProduto.setEnabled(produtoHabilitado);
        txtNomeProduto.setEnabled(produtoHabilitado);
        cmbCategoria.setEnabled(produtoHabilitado);
        cmbFabricante.setEnabled(produtoHabilitado);
        txtQTDE.setEnabled(produtoHabilitado);
        txtQTDE.setEnabled(true);
        lblServico.setText("");
        if (produtoHabilitado == true) {
            painelProduto.setBounds(0, 70, 880, 90);
        } else {
            painelProduto.setBounds(0, 0, 0, 0);
        }
    }//Fim habilitarProduto()

    private void habilitarServico(boolean servicoHabilitado) {
        painelservico.setVisible(servicoHabilitado);
        btnMais.setEnabled(false);
        btnMenos.setEnabled(false);
        lblServico.setEnabled(servicoHabilitado);
        cmbServico.setEnabled(servicoHabilitado);
        txtpesqServico.setEnabled(servicoHabilitado);
        cmbServico.setEnabled(servicoHabilitado);
        lblProduto.setEnabled(!servicoHabilitado);
        txtNomeProduto.setEnabled(!servicoHabilitado);
        cmbCategoria.setEnabled(!servicoHabilitado);
        cmbFabricante.setEnabled(!servicoHabilitado);
        txtQTDE.setEnabled(servicoHabilitado);
        txtQTDE.setEnabled(true);
        lblProduto.setText("");
        if (servicoHabilitado == true) {
            painelservico.setBounds(0, 70, 880, 90);
        } else {
            painelservico.setBounds(0, 0, 0, 0);
        }
    }//Fim habilitarServico()

    private void HabilitarBotoes(boolean paineis) {
        rbtProduto.setEnabled(paineis);
        rbtServico.setEnabled(paineis);
    }

    private void sincronizarProduto() {
        lblProduto.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 1).toString());
        totalS = String.format("%.2f", Double.parseDouble(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 3).toString().replaceAll(",", ".")));
        lblValorUnit.setText(totalS);
        btnMais.setEnabled(true);
        btnMenos.setEnabled(false);
    }

    private void sincronizaServico() {
        lblServico.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 1).toString());
        totalS = String.format("%.2f", Double.parseDouble(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 2).toString().replaceAll(",", ".")));
        lblValorUnit.setText(totalS);
        btnMais.setEnabled(true);
        btnMenos.setEnabled(false);
    }

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        cancelar();
        cmbCpf.setVisible(false);
        cmbCodigo.setVisible(false);
        atualizarTabela(forn, cat, marc, prod);
        atualizaClientes();
        jScrollPane1.setVisible(false);
        criarTabelaNota(tabelaNota);
        lblCpf.setText(cmbCpf.getSelectedItem().toString());
        atualizarCombos();
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtNomeProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeProdutoKeyReleased
        if (txtNomeProduto.getText().length() != 0) {
            prod = txtNomeProduto.getText();
        } else {
            prod = "";
        }
        atualizarTabela(forn, cat, marc, prod);
}//GEN-LAST:event_txtNomeProdutoKeyReleased

    private void txtpesqServicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesqServicoKeyReleased
        atualizarTabelaServico("SELECT * FROM tbl_servico WHERE descricao LIKE '" + txtpesqServico.getText() + "%' ORDER BY descricao");
}//GEN-LAST:event_txtpesqServicoKeyReleased

    private void rbtServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtServicoActionPerformed
        atualizarTabelaServico(serv);
        atualizarCombos();
        habilitarServico(true);
        habilitarProduto(false);
        txtQTDE.setEditable(true);
        lblProduto.setText("");

}//GEN-LAST:event_rbtServicoActionPerformed

    private void btnMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosActionPerformed
        if (btnMenos.isEnabled() == true) {
            alterarQtde(false);
        }
}//GEN-LAST:event_btnMenosActionPerformed

    private void btnMaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaisActionPerformed

        if (rbtProduto.isSelected() == true && lblProduto.getText().length() != 0 && btnMenos.isEnabled() == false) {
            add = 0;
            linha = 1;
            estoque = Integer.parseInt(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 4).toString());
            nivel = Integer.parseInt(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 5).toString());
            qtd = Integer.parseInt(txtQTDE.getText().replaceAll(" ", ""));
            for (int I = 0; I < tabelaNota.getRowCount(); I++) {
                if (tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 1).toString().equals(tabelaNota.getValueAt(I, 2).toString()) == true && tabelaNota.getValueAt(I, 0).toString().equals("Produto")) {
                    linha = I;
                    add++;
                }
            }
            if (estoque > nivel && estoque != 0) {
                if (add > 0 && qtd <= estoque) {
                    tabelaNota.setValueAt(Integer.parseInt(tabelaNota.getValueAt(linha, 1).toString()) + Integer.parseInt(txtQTDE.getText()), linha, 1);
                    unitario = Integer.parseInt(tabelaNota.getValueAt(linha, 1).toString()) * Double.parseDouble(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 3).toString().replaceAll(",", "."));
                    totalS = String.format("%.2f", unitario);
                    tabelaNota.setValueAt(totalS, linha, 4);
                    total = 0;
                    for (int I = 0; I < tabelaNota.getRowCount(); I++) {
                        total += Double.parseDouble(tabelaNota.getValueAt(I, 4).toString().replaceAll(",", "."));
                    }

                    tabelaProdutos.setValueAt(Integer.parseInt(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 4).toString()) - Integer.parseInt(txtQTDE.getText()), tabelaProdutos.getSelectedRow(), 4);
                    estoque = Integer.parseInt(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 4).toString());
                    totalS = String.format("%.2f", total);
                    lblValorTotal.setText(totalS);
                    txtQTDE.setText("1");
                } else if (add == 0 && qtd <= estoque) {
                    unitario = Integer.parseInt(txtQTDE.getText()) * Double.parseDouble(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 3).toString().replaceAll(",", "."));
                    String conteudo[] = new String[5];
                    conteudo[0] = "Produto";
                    conteudo[1] = txtQTDE.getText();
                    conteudo[2] = tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 1).toString();
                    conteudo[3] = tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 3).toString();
                    totalS = String.format("%.2f", unitario);
                    conteudo[4] = totalS;
                    modelonota.addRow(conteudo);
                    total = 0;
                    for (int I = 0; I < tabelaNota.getRowCount(); I++) {
                        total += Double.parseDouble(tabelaNota.getValueAt(I, 4).toString().replaceAll(",", "."));
                    }
                    tabelaProdutos.setValueAt(Integer.parseInt(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 4).toString()) - Integer.parseInt(txtQTDE.getText()), tabelaProdutos.getSelectedRow(), 4);
                    estoque = Integer.parseInt(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 4).toString());
                    totalS = String.format("%.2f", total);
                    lblValorTotal.setText(totalS);
                    txtQTDE.setText("1");
                } else if (qtd > estoque) {
                    JOptionPane.showMessageDialog(this, "insira um produto menor ou igual " + estoque);
                    txtQTDE.setText("1");
                }
                con.Conecta();
                cadmov.AtualizaEstoque(Integer.parseInt(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 4).toString()), tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0).toString());
                con.Fecha();
            } else if (estoque <= nivel && estoque != 0 && qtd <= estoque) {
                if (JOptionPane.showConfirmDialog(this, "Você está adicionando um produto que já\n" +
                        " alcançou seu nível de reposição\n" +
                        " Deseja continuar?", "Atenção!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                    if (add > 0 && qtd <= estoque) {
                        tabelaNota.setValueAt(Integer.parseInt(tabelaNota.getValueAt(linha, 1).toString()) + Integer.parseInt(txtQTDE.getText()), linha, 1);
                        unitario = Integer.parseInt(tabelaNota.getValueAt(linha, 1).toString()) * Double.parseDouble(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 3).toString().replaceAll(",", "."));
                        totalS = String.format("%.2f", unitario);
                        tabelaNota.setValueAt(totalS, linha, 4);
                        total = 0;
                        for (int I = 0; I < tabelaNota.getRowCount(); I++) {
                            total += Double.parseDouble(tabelaNota.getValueAt(I, 4).toString().replaceAll(",", "."));
                        }
                        tabelaProdutos.setValueAt(Integer.parseInt(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 4).toString()) - Integer.parseInt(txtQTDE.getText()), tabelaProdutos.getSelectedRow(), 4);
                        estoque = Integer.parseInt(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 4).toString());
                        totalS = String.format("%.2f", total);
                        lblValorTotal.setText(totalS);
                        txtQTDE.setText("1");
                    } else if (add == 0 && qtd <= estoque) {
                        unitario = Integer.parseInt(txtQTDE.getText()) * Double.parseDouble(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 3).toString().replaceAll(",", "."));
                        String conteudo[] = new String[5];
                        conteudo[0] = "Produto";
                        conteudo[1] = txtQTDE.getText();
                        conteudo[2] = tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 1).toString();
                        conteudo[3] = tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 3).toString();
                        totalS = String.format("%.2f", unitario);
                        conteudo[4] = totalS;
                        modelonota.addRow(conteudo);
                        total = 0;
                        for (int I = 0; I < tabelaNota.getRowCount(); I++) {
                            total += Double.parseDouble(tabelaNota.getValueAt(I, 4).toString().replaceAll(",", "."));
                        }
                        tabelaProdutos.setValueAt(Integer.parseInt(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 4).toString()) - Integer.parseInt(txtQTDE.getText()), tabelaProdutos.getSelectedRow(), 4);
                        estoque = Integer.parseInt(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 4).toString());
                        totalS = String.format("%.2f", total);
                        lblValorTotal.setText(totalS);
                        txtQTDE.setText("1");
                    } else if (qtd > estoque) {
                        JOptionPane.showMessageDialog(this, "Insira um produto menor ou igual a " + estoque);
                        txtQTDE.setText("1");
                    }
                }
                con.Conecta();
                cadmov.AtualizaEstoque(Integer.parseInt(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 4).toString()), tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0).toString());
                con.Fecha();
            } else if (estoque == 0) {
                JOptionPane.showMessageDialog(this, "Seu nível de estoque é " + estoque + ". Você não pode vender mais esse produto.");
                estoque = Integer.parseInt(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 4).toString());
                txtQTDE.setText("1");
            }
        } else if (rbtServico.isSelected() == true && btnMenos.isEnabled() == false && lblServico.getText().length() != 0) {
            add = 0;
            linha = 0;
            for (int I = 0; I < tabelaNota.getRowCount(); I++) {
                if (tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 1).toString().equals(tabelaNota.getValueAt(I, 2).toString()) == true && tabelaNota.getValueAt(I, 0).toString().equals("Serviço")) {
                    linha = I;
                    add++;
                }
            }
            if (add > 0) {
                tabelaNota.setValueAt(Integer.parseInt(tabelaNota.getValueAt(linha, 1).toString()) + Integer.parseInt(txtQTDE.getText()), linha, 1);
                unitario = Integer.parseInt(tabelaNota.getValueAt(linha, 1).toString()) * Double.parseDouble(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 2).toString().replaceAll(",", "."));
                totalS = String.format("%.2f", unitario);
                tabelaNota.setValueAt(totalS, linha, 4);
                total = 0;
                for (int I = 0; I < tabelaNota.getRowCount(); I++) {
                    total += Double.parseDouble(tabelaNota.getValueAt(I, 4).toString().replaceAll(",", "."));
                }
                totalS = String.format("%.2f", total);
                lblValorTotal.setText(totalS);
                txtQTDE.setText("1");
            } else if (add == 0) {
                unitario = Integer.parseInt(txtQTDE.getText()) * Double.parseDouble(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 2).toString().replaceAll(",", "."));
                String conteudo[] = new String[5];
                conteudo[0] = "Serviço";
                conteudo[1] = txtQTDE.getText();
                conteudo[2] = tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 1).toString();
                conteudo[3] = tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 3).toString();

                totalS = String.format("%.2f", unitario);
                conteudo[4] = totalS;
                modelonota.addRow(conteudo);
                total = 0;
                for (int I = 0; I < tabelaNota.getRowCount(); I++) {
                    total += Double.parseDouble(tabelaNota.getValueAt(I, 4).toString().replaceAll(",", "."));
                }
                totalS = String.format("%.2f", total);
                lblValorTotal.setText(totalS);
                txtQTDE.setText("1");
            }
        }
}//GEN-LAST:event_btnMaisActionPerformed

    public void alterarQtde(boolean aumentar) {
        frmQtde = new dlgQuantidade(null, true);
        if (aumentar == true) {
            frmQtde.QtdeInicial = Integer.parseInt(tabelaNota.getValueAt(cmm.indiceTabelaNota, 1).toString());
            frmQtde.setSize(250, 57);
            frmQtde.setLocationRelativeTo(this);
            frmQtde.btnqtde.setText("ADICIONAR");
            frmQtde.setTitle("Adicionar quantos:");
            frmQtde.setVisible(true);
            frmQtde.setModal(true);
            if (frmQtde.Qtde > 0) {
                tabelaNota.setValueAt(frmQtde.Qtde, cmm.indiceTabelaNota, 1);
                quantidade = Integer.parseInt(tabelaNota.getValueAt(cmm.indiceTabelaNota, 1).toString());
                unitario = Double.parseDouble(tabelaNota.getValueAt(cmm.indiceTabelaNota, 3).toString().replaceAll(",", "."));
                total = quantidade * unitario;
                totalS = String.format("%.2f", total);
                tabelaNota.setValueAt(totalS, cmm.indiceTabelaNota, 4);
                total = 0;
                for (int I = 0; I < tabelaNota.getRowCount(); I++) {
                    total += Double.parseDouble(tabelaNota.getValueAt(I, 3).toString().replaceAll(",", "."));
                }
                totalS = String.format("%.2f", total);
                lblValorTotal.setText(totalS);
                txtQTDE.setText("1");
            } else if (frmQtde.Qtde == -1) {
            }
        } //---------------------- REMOVER ---------------------------------------
        else {
            cmm.indiceTabelaNota = tabelaNota.getSelectedRow();
            //Se selecionado
            if (cmm.indiceTabelaNota > -1) {
                frmQtde = new dlgQuantidade(null, true);
                frmQtde.QtdeInicial = Integer.parseInt(tabelaNota.getValueAt(cmm.indiceTabelaNota, 1).toString());
                frmQtde.setSize(250, 65);
                frmQtde.setTitle("Remover");
                frmQtde.btnqtde.setText("Remover");
                frmQtde.setLocationRelativeTo(this);


                quantidade = Integer.parseInt(tabelaNota.getValueAt(tabelaNota.getSelectedRow(), 1).toString());
                unitario = 0;
                int resposta = 0;


                if (quantidade > 1) {
                    frmQtde.setVisible(true);
                    if (frmQtde.Qtde == -1) {
                    } else {
                        int valor = frmQtde.QtdeInicial - frmQtde.Qtde;
                        if (valor < quantidade) {
                            tabelaNota.setValueAt(Integer.parseInt(tabelaNota.getValueAt(tabelaNota.getSelectedRow(), 1).toString()) - valor, tabelaNota.getSelectedRow(), 1);
                            unitario = Double.parseDouble(tabelaNota.getValueAt(tabelaNota.getSelectedRow(), 3).toString().replaceAll(",", "."));
                            int quantidade2 = Integer.parseInt(tabelaNota.getValueAt(tabelaNota.getSelectedRow(), 1).toString());
                            total -= (valor * unitario);
                            Double Vtotal = quantidade2 * unitario;
                            totalS = String.format("%.2f", Vtotal);
                            tabelaNota.setValueAt(totalS, tabelaNota.getSelectedRow(), 4);
                            con.Conecta();
                            int qdteEstoque = Integer.parseInt(cadmov.getQtdeEstoque(tabelaNota.getValueAt(tabelaNota.getSelectedRow(), 2).toString()));
                            cadmov.AtualizaEstoque(frmQtde.QTDE + qdteEstoque, cadPro.getCodigoProduto(tabelaNota.getValueAt(tabelaNota.getSelectedRow(), 2).toString()));
                            con.Fecha();
                            atualizarTabela(forn, cat, marc, prod);
                        }

                        if (valor == quantidade) {
                            if (JOptionPane.showConfirmDialog(this, "Deseja realmente cancelar a venda deste produto?\n" +
                                    " *Esta operação não poderá ser desfeita\n" +
                                    " caso seja executada.", "Atenção!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                                total -= Double.parseDouble(tabelaNota.getValueAt(tabelaNota.getSelectedRow(), 3).toString().replaceAll(",", ".")) * Integer.parseInt(tabelaNota.getValueAt(tabelaNota.getSelectedRow(), 1).toString());
                                con.Conecta();
                                int qdteEstoque = Integer.parseInt(cadmov.getQtdeEstoque(tabelaNota.getValueAt(tabelaNota.getSelectedRow(), 2).toString()));
                                cadmov.AtualizaEstoque(Integer.parseInt(tabelaNota.getValueAt(tabelaNota.getSelectedRow(), 1).toString()) + qdteEstoque, cadPro.getCodigoProduto(tabelaNota.getValueAt(tabelaNota.getSelectedRow(), 2).toString()));
                                con.Fecha();
                                modelonota.removeRow(tabelaNota.getSelectedRow());
                                atualizarTabela(forn, cat, marc, prod);
                            }
                        }
                        if (valor > quantidade) {
                            JOptionPane.showMessageDialog(this, "Não se pode remover uma quantidade superior a que foi vendida.");
                        }
                    }

                } else {
                    resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente cancelar a venda deste produto?\n" +
                            " *Esta operação não poderá ser desfeita\n" +
                            " caso seja executada.", "Atenção!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (resposta == JOptionPane.YES_OPTION) {
                        total -= Double.parseDouble(tabelaNota.getValueAt(tabelaNota.getSelectedRow(), 3).toString().replaceAll(",", ".")) * Integer.parseInt(tabelaNota.getValueAt(tabelaNota.getSelectedRow(), 1).toString());
                        con.Conecta();
                        int qdteEstoque = Integer.parseInt(cadmov.getQtdeEstoque(tabelaNota.getValueAt(tabelaNota.getSelectedRow(), 2).toString()));
                        cadmov.AtualizaEstoque(Integer.parseInt(tabelaNota.getValueAt(tabelaNota.getSelectedRow(), 1).toString()) + qdteEstoque, cadPro.getCodigoProduto(tabelaNota.getValueAt(tabelaNota.getSelectedRow(), 2).toString()));
                        con.Fecha();
                        modelonota.removeRow(tabelaNota.getSelectedRow());
                        atualizarTabela(forn, cat, marc, prod);
                    }
                }
                atualizarTabela(forn, cat, marc, prod);
                totalS = String.format("%.2f", total);
                lblValorTotal.setText(totalS);
                btnMenos.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(this, "Selecione um produto ou serviço a ser removido", "Atenção", 1);
            }
            atualizarTabela(forn, cat, marc, prod);
        }
        totalS = String.format("%.2f", total);
        lblValorTotal.setText(totalS);
        btnMenos.setEnabled(false);
    }//Fim alterarQtde()

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        if (cmbCliente.getSelectedItem().toString().equals("Inexistente")) {
            JOptionPane.showMessageDialog(this, "Selecione um Cliente coretamente.", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            habilitarProduto(true);
            rbtProduto.setSelected(true);
            HabilitarBotoes(true);
            btnSelecionar.setEnabled(false);
            tabelaProdutos.setVisible(true);
            txtPesqNome.setEnabled(false);
            cmbCliente.setEnabled(false);
            btnVenda.setEnabled(true);
            txtPesqNome.setEnabled(false);
            btnSelecionar.setEnabled(false);
            btnCancelar.setEnabled(true);
            jScrollPane1.setVisible(true);
            txtPesqNome.setText(cmbCliente.getSelectedItem().toString());
            cli = cmbCliente.getSelectedItem().toString();
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

    private void btnVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVendaMouseClicked
    }//GEN-LAST:event_btnVendaMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Deseja realmente cancelar a compra?\n" +
                " *Esta operação não poderá ser desfeita\n" +
                " caso seja executada.", "Atenção!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
            cancelar();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cancelar() {
        painelProduto.setVisible(false);
        painelservico.setVisible(false);
        btnSelecionar.setEnabled(true);
        btnMais.setEnabled(false);
        btnMenos.setEnabled(false);
        cmbServico.setEnabled(false);
        txtpesqServico.setEnabled(false);
        txtQTDE.setEnabled(false);
        rbtServico.setSelected(false);
        rbtProduto.setSelected(false);
        cmbCliente.setEnabled(true);
        txtPesqNome.setEnabled(true);
        btnCancelar.setEnabled(false);
        txtNomeProduto.setEnabled(false);
        cmbCategoria.setEnabled(false);
        cmbFabricante.setEnabled(false);
        txtQTDE.setEnabled(false);
        lblProduto.setText("");
        lblValorTotal.setText("");
        lblValorUnit.setText("");
        jScrollPane1.setVisible(false);
        total = 0;
        tabelaNota.setModel(new DefaultTableModel(0, 0));
        forn = "";
        cat = "";
        marc = "";
        atualizarTabela(forn, cat, marc, prod);
        HabilitarBotoes(false);
    }

    private void cmbCategoriaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbCategoriaPopupMenuWillBecomeInvisible
        if (cmbCategoria.getSelectedIndex() != 0) {
            cat = cmbCategoria.getSelectedItem().toString();
        } else {
            cat = "";
        }
        atualizarTabela(forn, cat, marc, prod);
    }//GEN-LAST:event_cmbCategoriaPopupMenuWillBecomeInvisible

    private void cmbFabricantePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbFabricantePopupMenuWillBecomeInvisible
        if (cmbFabricante.getSelectedIndex() != 0) {
            marc = cmbFabricante.getSelectedItem().toString();
        } else {
            marc = "";
        }
        atualizarTabela(forn, cat, marc, prod);
    }//GEN-LAST:event_cmbFabricantePopupMenuWillBecomeInvisible

    private void btnVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaActionPerformed
        dialogVenda dVenda = new dialogVenda(null, true);
        dVenda.lblValorTotal.setText(lblValorTotal.getText());
        dVenda.mdlNota = modelonota;
        dVenda.cod_cliente = cmbCodigo.getSelectedItem().toString();
        dVenda.cod_funcionario = "" + codfunc.getCodigoFuncionario();
        dVenda.setLocationRelativeTo(this);
        dVenda.setVisible(true);
    }//GEN-LAST:event_btnVendaActionPerformed

    private void cmbClientePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbClientePopupMenuWillBecomeInvisible
        cmbCpf.setSelectedIndex(cmbCliente.getSelectedIndex());
        cmbCodigo.setSelectedIndex(cmbCliente.getSelectedIndex());
        lblCpf.setText(cmbCpf.getItemAt(cmbCliente.getSelectedIndex()).toString());
    }//GEN-LAST:event_cmbClientePopupMenuWillBecomeInvisible

    private void cmbServicoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbServicoPopupMenuWillBecomeInvisible
        /*  if (cmbServico.getSelectedIndex()!=0){
        serv = cmbServico.getSelectedItem().toString();
        } else{
        serv ="";
        }
        atualizarTabela(serv);*/
    }//GEN-LAST:event_cmbServicoPopupMenuWillBecomeInvisible

    private void tabelaNotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaNotaMouseClicked
        cmm.indiceTabelaNota = tabelaNota.getSelectedRow();
        tabelaProdutos.clearSelection();
        btnMenos.setEnabled(true);
        btnMais.setEnabled(true);
}//GEN-LAST:event_tabelaNotaMouseClicked

    private void txtNomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeProdutoActionPerformed

    private void tabelaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutosMouseClicked
        if (rbtProduto.isSelected() == true) {
            sincronizarProduto();
        } else {
            sincronizaServico();
        }
        tabelaNota.clearSelection();
}//GEN-LAST:event_tabelaProdutosMouseClicked

    private void tabelaProdutosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaProdutosKeyReleased
        if ((evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
            sincronizarProduto();
        } else {
            sincronizaServico();
        }
        tabelaNota.clearSelection();
}//GEN-LAST:event_tabelaProdutosKeyReleased

    private void btnMenosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenosMouseClicked
        /*dialogQdte QT = new dialogQdte(null,true);
        QT.setSize(300,300);
        QT.setVisible(true);*/
    }//GEN-LAST:event_btnMenosMouseClicked

    private void rbtProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtProdutoActionPerformed
        atualizarTabela(forn, cat, marc, prod);
        atualizarCombos();
        habilitarProduto(true);
        habilitarServico(false);
        txtQTDE.setEditable(true);
        lblServico.setText("");
        //painelservico.setEnabled(false);
    }//GEN-LAST:event_rbtProdutoActionPerformed

    private void tabelaNotaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaNotaKeyReleased
        if ((evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
            sincronizarProduto();
        }
    }//GEN-LAST:event_tabelaNotaKeyReleased

    private void txtQTDEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQTDEKeyReleased
//  if(valida.isNumeric(""+evt.getKeyChar()+"")==false && (evt.getKeyCode() !=  KeyEvent.VK_UP) && (evt.getKeyCode() !=  KeyEvent.VK_DOWN)&& (evt.getKeyCode() !=  KeyEvent.VK_LEFT)&& (evt.getKeyCode() !=  KeyEvent.VK_RIGHT)){
//            Careto = txtQTDE.getCaretPosition();
//            txtQTDE.setText(txtQTDE.getText().replaceAll(""+evt.getKeyChar()+"",""));
//            txtQTDE.setCaretPosition(Careto);
//        }
    }//GEN-LAST:event_txtQTDEKeyReleased

    private void btnOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrcamentoActionPerformed
        sdf = new SimpleDateFormat("hh:mm:ss");
        String sHora = sdf.format(new Date());
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sData = sdf.format(new Date());
        con.Conecta();
        cadmov.cadastraOrcamento(sData, sHora, cmbCodigo.getSelectedItem().toString(), lblValorTotal.getText().replaceAll(",", "."));
        for (i = 0; i < tabelaNota.getRowCount(); i++) {
            if (tabelaNota.getValueAt(i, 0).toString().equals("Produto")) {
                cadmov.cadastraOrcamentoProduto(cadPro.getCodigoProduto(tabelaNota.getValueAt(i, 2).toString()), cadmov.getLastCodigoOrcamento(), tabelaNota.getValueAt(i, 1).toString());
            } else if (tabelaNota.getValueAt(i, 0).toString().equals("Serviço")) {
                cadmov.cadastraOrcamentoServico(cadser.getServico(tabelaNota.getValueAt(i, 2).toString()), cadmov.getLastCodigoOrcamento(), tabelaNota.getValueAt(i, 1).toString());
            }
        }
        con.Fecha();
        JOptionPane.showMessageDialog(null, "Orçamento armazenado com sucesso!", "Orçamento salvo", JOptionPane.INFORMATION_MESSAGE);
        cancelar();
    }//GEN-LAST:event_btnOrcamentoActionPerformed

    private void txtPesqNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqNomeKeyReleased
        // TODO deletar
    }//GEN-LAST:event_txtPesqNomeKeyReleased
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnMais;
    private javax.swing.JButton btnMenos;
    private javax.swing.JButton btnOrcamento;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JButton btnVenda;
    private javax.swing.JComboBox cmbCategoria;
    private javax.swing.JComboBox cmbCliente;
    private javax.swing.JComboBox cmbCodigo;
    private javax.swing.JComboBox cmbCpf;
    private javax.swing.JComboBox cmbFabricante;
    private javax.swing.JComboBox cmbServico;
    private javax.swing.ButtonGroup grupoBotoes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblServico;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JLabel lblValorUnit;
    private javax.swing.JPanel painelProduto;
    private javax.swing.JPanel painelservico;
    private javax.swing.JRadioButton rbtProduto;
    private javax.swing.JRadioButton rbtServico;
    private javax.swing.JTable tabelaNota;
    private javax.swing.JTable tabelaProdutos;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtPesqNome;
    private javax.swing.JTextField txtQTDE;
    private javax.swing.JTextField txtpesqServico;
    // End of variables declaration//GEN-END:variables
}
