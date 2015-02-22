package frontEnd;

import Banco.*;
import Validacoes.Validacao;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class frameProduto extends javax.swing.JInternalFrame {

    private Conexao con = new Conexao();
    private DefaultComboBoxModel mdlCategoria, mdlFornecedor, mdlFabricante;
    private CadProduto cadPro = new CadProduto();
    private String campo, msg, sql, codigoFabricante, codigoFornecedor, codigoCategoria;
    private Comum cmm = new Comum();
    private int progresso = 0, Careto = 0;
    private Validacao vld = new Validacao();

    /** Creates new form frameProduto */
    public frameProduto() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrp = new javax.swing.ButtonGroup();
        painel = new javax.swing.JPanel();
        painelUnidades = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtReposicao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEstoque = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cmbPesquisa = new javax.swing.JComboBox();
        txtPesquisa = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnInserir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbFornecedor = new javax.swing.JComboBox();
        cmbFabricante = new javax.swing.JComboBox();
        cmbCategoria = new javax.swing.JComboBox();
        btnFornecedor = new javax.swing.JButton();
        btnFabricante = new javax.swing.JButton();
        btnCategoria = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtGarantia = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtValorCompra = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        rbImprimirTodos = new javax.swing.JRadioButton();
        rbIndividualImprimir = new javax.swing.JRadioButton();
        btnImprimir = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lblSelecionado = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setTitle("PRODUTO");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/produto_icone.png"))); // NOI18N
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

        painel.setMaximumSize(new java.awt.Dimension(0, 285));
        painel.setMinimumSize(new java.awt.Dimension(0, 285));
        painel.setOpaque(false);
        painel.setPreferredSize(new java.awt.Dimension(835, 277));
        painel.setLayout(null);

        painelUnidades.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Unidades ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        painelUnidades.setOpaque(false);
        painelUnidades.setLayout(null);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel3.setText("Repor em:");
        painelUnidades.add(jLabel3);
        jLabel3.setBounds(190, 20, 70, 16);

        txtReposicao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtReposicaoFocusGained(evt);
            }
        });
        txtReposicao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtReposicaoKeyReleased(evt);
            }
        });
        painelUnidades.add(txtReposicao);
        txtReposicao.setBounds(260, 14, 70, 23);

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel4.setText("Em estoque:");
        painelUnidades.add(jLabel4);
        jLabel4.setBounds(20, 20, 80, 16);

        txtEstoque.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEstoqueFocusGained(evt);
            }
        });
        txtEstoque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEstoqueKeyReleased(evt);
            }
        });
        painelUnidades.add(txtEstoque);
        txtEstoque.setBounds(100, 14, 80, 23);

        painel.add(painelUnidades);
        painelUnidades.setBounds(0, 170, 350, 50);

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel6.setText("Fabricante:");
        painel.add(jLabel6);
        jLabel6.setBounds(540, 40, 80, 16);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "  Pesquisa ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        cmbPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "Descrição", "Valor original", "Valor de venda", "Garantia", "Unidades em estoque", "Nível de reposição" }));
        cmbPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPesquisaActionPerformed(evt);
            }
        });
        jPanel2.add(cmbPesquisa);
        cmbPesquisa.setBounds(20, 20, 180, 23);

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });
        jPanel2.add(txtPesquisa);
        txtPesquisa.setBounds(200, 20, 260, 23);

        painel.add(jPanel2);
        jPanel2.setBounds(360, 220, 480, 60);

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
        btnNovo.setBounds(360, 110, 90, 50);

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
        btnInserir.setBounds(470, 110, 90, 50);

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
        painel.add(btnCancelar);
        btnCancelar.setBounds(580, 170, 90, 50);

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
        painel.add(btnLimpar);
        btnLimpar.setBounds(470, 170, 90, 50);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/stop_icone.png"))); // NOI18N
        btnExcluir.setMnemonic('E');
        btnExcluir.setText("Excluir");
        btnExcluir.setToolTipText("Excluir");
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.setPreferredSize(new java.awt.Dimension(71, 26));
        btnExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        painel.add(btnExcluir);
        btnExcluir.setBounds(360, 170, 90, 50);

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel7.setText("Fornecedor: ");
        painel.add(jLabel7);
        jLabel7.setBounds(540, 10, 80, 16);

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel8.setText("Categoria:");
        painel.add(jLabel8);
        jLabel8.setBounds(550, 70, 70, 16);

        cmbFornecedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<fornecedor>" }));
        cmbFornecedor.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cmbFornecedorPopupMenuWillBecomeVisible(evt);
            }
        });
        painel.add(cmbFornecedor);
        cmbFornecedor.setBounds(620, 10, 140, 23);

        cmbFabricante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<fabricante>" }));
        cmbFabricante.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cmbFabricantePopupMenuWillBecomeVisible(evt);
            }
        });
        painel.add(cmbFabricante);
        cmbFabricante.setBounds(620, 40, 140, 23);

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<categoria>" }));
        cmbCategoria.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cmbCategoriaPopupMenuWillBecomeVisible(evt);
            }
        });
        painel.add(cmbCategoria);
        cmbCategoria.setBounds(620, 70, 140, 23);

        btnFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/inserir_icone.png"))); // NOI18N
        btnFornecedor.setBorderPainted(false);
        btnFornecedor.setContentAreaFilled(false);
        btnFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFornecedorActionPerformed(evt);
            }
        });
        painel.add(btnFornecedor);
        btnFornecedor.setBounds(760, 10, 30, 24);

        btnFabricante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/inserir_icone.png"))); // NOI18N
        btnFabricante.setBorderPainted(false);
        btnFabricante.setContentAreaFilled(false);
        btnFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFabricanteActionPerformed(evt);
            }
        });
        painel.add(btnFabricante);
        btnFabricante.setBounds(760, 40, 30, 24);

        btnCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/inserir_icone.png"))); // NOI18N
        btnCategoria.setBorderPainted(false);
        btnCategoria.setContentAreaFilled(false);
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });
        painel.add(btnCategoria);
        btnCategoria.setBounds(760, 70, 30, 24);

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel9.setText("Garantia (em meses):");
        painel.add(jLabel9);
        jLabel9.setBounds(360, 90, 130, 16);

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
        painel.add(txtGarantia);
        txtGarantia.setBounds(490, 84, 50, 23);

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/alterar_icone.png"))); // NOI18N
        btnAlterar.setMnemonic('A');
        btnAlterar.setText("Alterar");
        btnAlterar.setToolTipText("Alterar");
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
        btnAlterar.setBounds(580, 110, 90, 50);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Produto ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        jPanel4.setLayout(null);

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel10.setText("Código: ");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(20, 20, 45, 16);

        txtCod.setEditable(false);
        txtCod.setText("<auto>");
        txtCod.setToolTipText("Código do produto.\nNão pode ser alterado.");
        txtCod.setEnabled(false);
        jPanel4.add(txtCod);
        txtCod.setBounds(80, 10, 50, 23);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel1.setText("Nome:");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(30, 46, 36, 16);

        txtNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomeFocusGained(evt);
            }
        });
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });
        jPanel4.add(txtNome);
        txtNome.setBounds(80, 40, 250, 23);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel2.setText("Descrição: ");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(10, 70, 70, 16);

        txtDescricao.setColumns(18);
        txtDescricao.setRows(4);
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
        jScrollPane1.setViewportView(txtDescricao);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(80, 70, 250, 90);

        painel.add(jPanel4);
        jPanel4.setBounds(0, 0, 350, 170);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Valor ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        jPanel5.setLayout(null);

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel11.setText("De compra:");
        jPanel5.add(jLabel11);
        jLabel11.setBounds(20, 20, 70, 16);

        txtValorCompra.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtValorCompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorCompraFocusGained(evt);
            }
        });
        txtValorCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValorCompraKeyReleased(evt);
            }
        });
        jPanel5.add(txtValorCompra);
        txtValorCompra.setBounds(90, 14, 70, 23);

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel5.setText("De venda:");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(30, 50, 60, 16);

        txtValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
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
        jPanel5.add(txtValor);
        txtValor.setBounds(90, 44, 70, 23);

        painel.add(jPanel5);
        jPanel5.setBounds(350, 0, 170, 80);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Navegação ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
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
        btnPrimeiro.setBounds(10, 20, 80, 36);

        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/anterior.png"))); // NOI18N
        btnAnterior.setToolTipText("Resgistro anterior");
        btnAnterior.setPreferredSize(new java.awt.Dimension(90, 36));
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnterior);
        btnAnterior.setBounds(90, 20, 70, 36);

        btnProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/proximo.png"))); // NOI18N
        btnProximo.setToolTipText("Resgistro posterior");
        btnProximo.setPreferredSize(new java.awt.Dimension(90, 36));
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });
        jPanel1.add(btnProximo);
        btnProximo.setBounds(160, 20, 70, 36);

        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ultimo.png"))); // NOI18N
        btnUltimo.setToolTipText("Último registro");
        btnUltimo.setPreferredSize(new java.awt.Dimension(90, 36));
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });
        jPanel1.add(btnUltimo);
        btnUltimo.setBounds(230, 20, 80, 36);

        painel.add(jPanel1);
        jPanel1.setBounds(0, 220, 320, 60);

        getContentPane().add(painel, java.awt.BorderLayout.PAGE_START);

        jPanel3.setMaximumSize(new java.awt.Dimension(10, 40));
        jPanel3.setMinimumSize(new java.awt.Dimension(10, 40));
        jPanel3.setPreferredSize(new java.awt.Dimension(10, 40));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        btnGrp.add(rbImprimirTodos);
        rbImprimirTodos.setFont(new java.awt.Font("sansserif", 1, 12));
        rbImprimirTodos.setSelected(true);
        rbImprimirTodos.setText("Todos");
        jPanel3.add(rbImprimirTodos);

        btnGrp.add(rbIndividualImprimir);
        rbIndividualImprimir.setFont(new java.awt.Font("sansserif", 1, 12));
        rbIndividualImprimir.setText("Individual");
        jPanel3.add(rbIndividualImprimir);

        btnImprimir.setFont(new java.awt.Font("sansserif", 1, 12));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/imprimir_icone.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        jPanel3.add(btnImprimir);

        jLabel12.setText("Selecionado:");
        jPanel3.add(jLabel12);

        lblSelecionado.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jPanel3.add(lblSelecionado);

        jLabel13.setText("Total:");
        jPanel3.add(jLabel13);

        lblTotal.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jPanel3.add(lblTotal);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produtos"
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
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            Careto = txtNome.getCaretPosition();
            cmm.getParaMaiuscula(txtNome);
            txtNome.setCaretPosition(Careto);
            pesquisarTabela("tbl_produto.nome_produto LIKE '" + txtNome.getText() + "%'");
        }
}//GEN-LAST:event_txtNomeKeyReleased

    private void pesquisarTabela(String campo) {
        sql = "SELECT tbl_produto.cod_produto AS Código, tbl_produto.nome_produto AS Produto, " +
                "tbl_produto.descricao AS \"Descrição\", tbl_produto.valor_original AS \"Valor original\", " +
                "tbl_produto.valor AS \"Valor de venda\", tbl_produto.garantia AS Garantia, " +
                "tbl_produto.unidades_em_estoque AS \"Em estoque\", tbl_produto.unidades_reposicao AS \"Repor em\", " +
                "tbl_categoria.categoria AS Categoria, tbl_fabricante.fabricante AS Fabricante, " +
                "tbl_fornecedor.nome_fornecedor AS Fornecedor FROM tbl_fornecedor INNER JOIN (tbl_fabricante " +
                "INNER JOIN (tbl_categoria INNER JOIN tbl_produto ON tbl_categoria.cod_categoria = tbl_produto.cod_categoria)" +
                " ON tbl_fabricante.cod_fabricante = tbl_produto.cod_fabricante) ON tbl_fornecedor.cod_fornecedor = tbl_produto.cod_fornecedor " +
                "WHERE " + campo;
        cmm.criarTabelaProduto(sql, tabela);
        lblTotal.setText(""+tabela.getRowCount());
    }

    private int validaTudo() {
        progresso = 0;
        msg = "";
        if (txtNome.getText().replaceAll(" ", "").length() < 1) {
            msg += "Nome do produto;\n";
            txtNome.setBackground(Color.red);
            progresso += 1;
        }
        if (txtDescricao.getText().replaceAll(" ", "").length() < 1) {
            msg += "Decrição do produto;\n";
            txtDescricao.setBackground(Color.red);
            progresso += 1;
        }
        if (vld.isNumeric(txtEstoque.getText().replaceAll(" ", "")) == false) {
            msg += "Unidades em estoque;\n";
            txtEstoque.setBackground(Color.red);
            progresso += 1;
        }
        if (vld.isNumeric(txtReposicao.getText().replaceAll(" ", "")) == false) {
            msg += "Repor em;\n";
            txtReposicao.setBackground(Color.red);
            progresso += 1;
        }
        if (vld.isDouble(txtValorCompra.getText().replaceAll(" ", "").replaceAll(",", ".")) == false) {
            msg += "Valor de compra;\n";
            txtValorCompra.setBackground(Color.red);
            progresso += 1;
        }
        if (vld.isDouble(txtValor.getText().replaceAll(" ", "").replaceAll(",", ".")) == false) {
            msg += "Valor de venda;\n";
            txtValor.setBackground(Color.red);
            progresso += 1;
        }
        if (vld.isNumeric(txtGarantia.getText().replaceAll(" ", "")) == false) {
            msg += "Garantia;\n";
            txtGarantia.setBackground(Color.red);
            progresso += 1;
        }
        return progresso;
    }//Fim validaTudo()

    private void cancelar() {
        Limpar();
        setHabilitaTudo(false);
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
        cmbPesquisa.setEnabled(true);
    }//Fim cancelar()

    private void Limpar() {
        txtNome.setText("");
        txtNome.setBackground(Color.white);
        txtValor.setText("");
        txtValor.setBackground(Color.white);
        txtGarantia.setText("");
        txtGarantia.setBackground(Color.white);
        txtDescricao.setText("");
        txtDescricao.setBackground(Color.white);
        txtEstoque.setText("");
        txtEstoque.setBackground(Color.white);
        txtReposicao.setText("");
        txtReposicao.setBackground(Color.white);
        txtPesquisa.setText("");
        txtValorCompra.setText("");
        txtValorCompra.setBackground(Color.white);
    }//Fim Limpar()

    private void setHabilitaTudo(boolean verdade) {
        txtDescricao.setEnabled(verdade);
        txtEstoque.setEnabled(verdade);
        txtGarantia.setEnabled(verdade);
        txtNome.setEnabled(verdade);
        txtReposicao.setEnabled(verdade);
        txtValor.setEnabled(verdade);
        txtValorCompra.setEnabled(verdade);
        cmbCategoria.setEnabled(verdade);
        cmbFabricante.setEnabled(verdade);
        cmbFornecedor.setEnabled(verdade);
        btnCategoria.setEnabled(verdade);
        btnFabricante.setEnabled(verdade);
        btnFornecedor.setEnabled(verdade);
    }//Fim setHabilitaTudo()

    private void sincronizarTabela() {
        lblSelecionado.setText(""+(tabela.getSelectedRow()+1));
        txtCod.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
        txtNome.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        txtDescricao.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
        txtValorCompra.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
        txtValor.setText(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());
        txtGarantia.setText(tabela.getValueAt(tabela.getSelectedRow(), 5).toString());
        txtEstoque.setText(tabela.getValueAt(tabela.getSelectedRow(), 6).toString());
        txtReposicao.setText(tabela.getValueAt(tabela.getSelectedRow(), 7).toString());
        cmbCategoria.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 8).toString());
        cmbFabricante.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 9).toString());
        cmbFornecedor.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 10).toString());
        setHabilitaTudo(false);
        btnExcluir.setEnabled(true);
        btnAlterar.setEnabled(true);
        btnNovo.setEnabled(true);
        btnLimpar.setEnabled(false);
        btnInserir.setEnabled(false);
        btnCancelar.setEnabled(false);
    }//Fim sincronizarTabela()

    private void atualizarTabela() {
        sql = "SELECT tbl_produto.cod_produto AS Código, tbl_produto.nome_produto AS Produto, " +
                "tbl_produto.descricao AS \"Descrição\", tbl_produto.valor_original AS \"Valor original\", " +
                "tbl_produto.valor AS \"Valor de venda\", tbl_produto.garantia AS Garantia, " +
                "tbl_produto.unidades_em_estoque AS \"Em estoque\", tbl_produto.unidades_reposicao AS \"Repor em\", " +
                "tbl_categoria.categoria AS Categoria, tbl_fabricante.fabricante AS Fabricante, " +
                "tbl_fornecedor.nome_fornecedor AS Fornecedor FROM tbl_fornecedor INNER JOIN (tbl_fabricante " +
                "INNER JOIN (tbl_categoria INNER JOIN tbl_produto ON tbl_categoria.cod_categoria = tbl_produto.cod_categoria)" +
                " ON tbl_fabricante.cod_fabricante = tbl_produto.cod_fabricante) ON tbl_fornecedor.cod_fornecedor = tbl_produto.cod_fornecedor";
        cmm.criarTabelaProduto(sql, tabela);
        lblTotal.setText(""+tabela.getRowCount());
    }

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
        cmbPesquisa.setEnabled(false);
}//GEN-LAST:event_btnNovoActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        if (validaTudo() == 0) {
            pesquisarTabela("tbl_produto.nome_produto LIKE '" + txtNome.getText() + "'");
            if (tabela.getRowCount() < 1) {
                try {
                    con.Conecta();
                    cadPro = new CadProduto();
                    progresso = 0;
                    codigoFabricante = cadPro.getCodigoFabricante(cmbFabricante.getSelectedItem().toString());
                    codigoFornecedor = cadPro.getCodigoFornecedor(cmbFornecedor.getSelectedItem().toString());
                    codigoCategoria = cadPro.getCodigoCategoria(cmbCategoria.getSelectedItem().toString());
                    sql = "INSERT INTO tbl_produto (UNIDADES_EM_ESTOQUE,UNIDADES_REPOSICAO,DESCRICAO,VALOR,GARANTIA," +
                            "COD_FORNECEDOR,COD_FABRICANTE,COD_CATEGORIA,NOME_PRODUTO,valor_original)VALUES(" + txtEstoque.getText() + "," +
                            txtReposicao.getText() + ",'" + txtDescricao.getText() + "'," + txtValor.getText().replaceAll(",", ".") + "," + txtGarantia.getText() +
                            "," + codigoFornecedor + "," + codigoFabricante + "," + codigoCategoria + ",'" + txtNome.getText() + "'," + txtValorCompra.getText().replaceAll(",", ".") + ")";
                    progresso += cadPro.cadastraProduto(sql);
                    if (progresso == 0) {
                        JOptionPane.showMessageDialog(null, "Produto inserido com sucesso!", "Operação bem-sucedida!", JOptionPane.INFORMATION_MESSAGE);
                        con.Fecha();
                        atualizarTabela();
                        cancelar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Operação executada com " + progresso + " erro(s).", "Não foi possível cadastrar.", JOptionPane.ERROR_MESSAGE);
                        con.Fecha();
                    }
                    atualizarTabela();
                } catch (Error e) {
                    JOptionPane.showMessageDialog(null, "Erro ao efetuar cadastro.\n" + e, "Erro!", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                    con.Fecha();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ha um produto cadastrado com este nome.\nEscolha outro nome para este produto.", "Nome indisponível!", JOptionPane.WARNING_MESSAGE);
                txtNome.setBackground(Color.red);
                txtNome.grabFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, msg, "Preencha o(s) seguinte(s) corretamente:", JOptionPane.WARNING_MESSAGE);
        }
}//GEN-LAST:event_btnInserirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        Limpar();
}//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            con.Conecta();
            cadPro = new CadProduto();
            progresso = 0;
            sql = "DELETE FROM tbl_produto WHERE nome_produto = '" + txtNome.getText() + "'";
            progresso += cadPro.excluiProduto(sql);
            if (progresso == 0) {
                JOptionPane.showMessageDialog(this, "Produto removido com sucesso!", "Operação bem-sucedida!", JOptionPane.INFORMATION_MESSAGE);
                con.Fecha();
                atualizarTabela();
                cancelar();
            } else {
                JOptionPane.showMessageDialog(this, "Operação executada com " + progresso + " erro(s).", "Não foi possível excluir.", JOptionPane.ERROR_MESSAGE);
                con.Fecha();
            }
        } catch (Error e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir produto.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
}//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        frmCadCategoria frm = new frmCadCategoria(null, true);
        frm.setSize(800, 650);
        frm.setLocationRelativeTo(this);
        frm.setVisible(true);
        frm.setModal(true);
}//GEN-LAST:event_btnCategoriaActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        atualizarCombos();
        atualizarTabela();
        cancelar();
    }//GEN-LAST:event_formInternalFrameOpened

    private void atualizarCombos() {
        cadPro = new CadProduto();
        sql = "SELECT * FROM tbl_fabricante";
        mdlFabricante = new DefaultComboBoxModel();
        cadPro.getListaCombo(cmbFabricante, mdlFabricante, sql);
        sql = "SELECT * FROM tbl_fornecedor";
        mdlFornecedor = new DefaultComboBoxModel();
        cadPro.getListaCombo(cmbFornecedor, mdlFornecedor, sql);
        sql = "SELECT * FROM tbl_categoria";
        mdlCategoria = new DefaultComboBoxModel();
        cadPro.getListaCombo(cmbCategoria, mdlCategoria, sql);
    }

    private void btnFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFornecedorActionPerformed
        frmCadFornecedor frm = new frmCadFornecedor(null, true);
        frm.setSize(800, 650);
        frm.setLocationRelativeTo(this);
        frm.setVisible(true);
        frm.setModal(true);
    }//GEN-LAST:event_btnFornecedorActionPerformed

    private void btnFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFabricanteActionPerformed
        frmCadFabricante frm = new frmCadFabricante(null, true);
        frm.setSize(800, 650);
        frm.setLocationRelativeTo(this);
        frm.setVisible(true);
        frm.setModal(true);
    }//GEN-LAST:event_btnFabricanteActionPerformed

    private void cmbFornecedorPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbFornecedorPopupMenuWillBecomeVisible
        cadPro = new CadProduto();
        sql = "SELECT * FROM tbl_fornecedor";
        mdlFornecedor = new DefaultComboBoxModel();
        cadPro.getListaCombo(cmbFornecedor, mdlFornecedor, sql);
    }//GEN-LAST:event_cmbFornecedorPopupMenuWillBecomeVisible

    private void cmbFabricantePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbFabricantePopupMenuWillBecomeVisible
        cadPro = new CadProduto();
        sql = "SELECT * FROM tbl_fabricante";
        mdlFabricante = new DefaultComboBoxModel();
        cadPro.getListaCombo(cmbFabricante, mdlFabricante, sql);
    }//GEN-LAST:event_cmbFabricantePopupMenuWillBecomeVisible

    private void cmbCategoriaPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbCategoriaPopupMenuWillBecomeVisible
        cadPro = new CadProduto();
        sql = "SELECT * FROM tbl_categoria";
        mdlCategoria = new DefaultComboBoxModel();
        cadPro.getListaCombo(cmbCategoria, mdlCategoria, sql);
    }//GEN-LAST:event_cmbCategoriaPopupMenuWillBecomeVisible

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (btnAlterar.isSelected() == true) {
            setHabilitaTudo(true);
            btnAlterar.setToolTipText("Salvar");
            btnAlterar.setText("Salvar");
            btnAlterar.setMnemonic('S');
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
            cmbPesquisa.setEnabled(false);
        } else {
            if (validaTudo() == 0) {
                try {
                    progresso = 0;
                    con.Conecta();
                    cadPro = new CadProduto();
                    codigoFabricante = cadPro.getCodigoFabricante(cmbFabricante.getSelectedItem().toString());
                    codigoFornecedor = cadPro.getCodigoFornecedor(cmbFornecedor.getSelectedItem().toString());
                    codigoCategoria = cadPro.getCodigoCategoria(cmbCategoria.getSelectedItem().toString());
                    sql = "UPDATE tbl_produto SET unidades_em_estoque=" + txtEstoque.getText() + "," +
                            "unidades_reposicao=" + txtReposicao.getText() + "," +
                            "descricao='" + txtDescricao.getText() + "'," +
                            "valor=" + txtValor.getText().replaceAll(",", ".") + "," +
                            "valor_original=" + txtValorCompra.getText().replaceAll(",", ".") + "," +
                            "garantia=" + txtGarantia.getText() + "," +
                            "cod_fornecedor=" + codigoFornecedor + "," +
                            "cod_fabricante=" + codigoFabricante + "," +
                            "cod_categoria=" + codigoCategoria + "," +
                            "nome_produto='" + txtNome.getText() +
                            "' WHERE cod_produto =" + txtCod.getText();
                    progresso += cadPro.alteraProduto(sql);
                    if (progresso == 0) {
                        JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!", "Operação bem-sucedida!", JOptionPane.INFORMATION_MESSAGE);
                        con.Fecha();
                        atualizarTabela();
                        cancelar();
                    } else {
                        JOptionPane.showMessageDialog(this, "Operação executada com " + progresso + " erro(s).", "Não foi possível atualizar.", JOptionPane.ERROR_MESSAGE);
                        btnAlterar.setSelected(true);
                        con.Fecha();
                    }
                } catch (Error e) {
                    JOptionPane.showMessageDialog(this, "Erro ao efetuar alteração.");
                    e.printStackTrace();
                    con.Fecha();
                }
            } else {
                JOptionPane.showMessageDialog(this, msg, "Preencha o(s) seguinte(s) corretamente:", JOptionPane.WARNING_MESSAGE);
            }
        }
}//GEN-LAST:event_btnAlterarActionPerformed

    private void txtValorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyReleased
        Careto = txtValor.getCaretPosition();
        if (vld.isNumeric("" + evt.getKeyChar() + "") == false) {
            txtValor.setText(txtValor.getText().replaceAll("[." + evt.getKeyChar() + ",]", ""));
        } else {
            try {
                txtValor.setText(String.format("%.2f", Double.parseDouble(txtValor.getText().replaceAll(",", "."))));
            } catch (IllegalArgumentException e) {
            }
        }
        txtValor.setCaretPosition(Careto);
    }//GEN-LAST:event_txtValorKeyReleased

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (evt.getClickCount() >= 0) {
            sincronizarTabela();
        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void tabelaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseReleased
        if (evt.getClickCount() >= 0) {
            sincronizarTabela();
        }
    }//GEN-LAST:event_tabelaMouseReleased

    private void tabelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyReleased
        if ((evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
            sincronizarTabela();
        }
    }//GEN-LAST:event_tabelaKeyReleased

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

    private void txtDescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescricaoKeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            try {
                Careto = txtDescricao.getCaretPosition();

                txtDescricao.setText(vld.semAcento(txtDescricao.getText().toUpperCase()));

                txtDescricao.setCaretPosition(Careto);
            } catch (IllegalArgumentException e) {
            }
        }
    }//GEN-LAST:event_txtDescricaoKeyReleased

    private void txtValorCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorCompraKeyReleased
        try {
            Careto = txtValorCompra.getCaretPosition();
            if (vld.isNumeric("" + evt.getKeyChar() + "") == false && ("" + evt.getKeyChar()).equals(".") == false && ("" + evt.getKeyChar()).equals(",") == false) {
                txtValorCompra.setText(txtValorCompra.getText().replaceAll("" + evt.getKeyChar(), ""));
            } else {
                txtValorCompra.setText(String.format("%.2f", Double.parseDouble(txtValorCompra.getText().replaceAll(",", "."))));
            }
            txtValorCompra.setCaretPosition(Careto);
        } catch (IllegalArgumentException e) {
        }
    }//GEN-LAST:event_txtValorCompraKeyReleased

    private void txtEstoqueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstoqueKeyReleased
        try {
            if (vld.isDouble("" + evt.getKeyChar() + "") == false && (evt.getKeyCode() != KeyEvent.VK_UP) && (evt.getKeyCode() != KeyEvent.VK_DOWN) && (evt.getKeyCode() != KeyEvent.VK_LEFT) && (evt.getKeyCode() != KeyEvent.VK_RIGHT)) {
                Careto = txtEstoque.getCaretPosition();

                txtEstoque.setText(txtEstoque.getText().replaceAll("" + evt.getKeyChar() + "", ""));

                txtEstoque.setCaretPosition(Careto);
            }
        } catch (IllegalArgumentException e) {
        }

    }//GEN-LAST:event_txtEstoqueKeyReleased

    private void txtReposicaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReposicaoKeyReleased
        if (vld.isNumeric("" + evt.getKeyChar() + "") == false && (evt.getKeyCode() != KeyEvent.VK_UP) && (evt.getKeyCode() != KeyEvent.VK_DOWN) && (evt.getKeyCode() != KeyEvent.VK_LEFT) && (evt.getKeyCode() != KeyEvent.VK_RIGHT)) {
            Careto = txtReposicao.getCaretPosition();
            txtReposicao.setText(txtReposicao.getText().replaceAll("" + evt.getKeyChar() + "", ""));
            txtReposicao.setCaretPosition(Careto);
        }
    }//GEN-LAST:event_txtReposicaoKeyReleased

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

    private void txtNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusGained
        txtNome.setBackground(Color.white);
    }//GEN-LAST:event_txtNomeFocusGained

    private void txtDescricaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescricaoFocusGained
        txtDescricao.setBackground(Color.white);
    }//GEN-LAST:event_txtDescricaoFocusGained

    private void txtEstoqueFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEstoqueFocusGained
        txtEstoque.setBackground(Color.white);
    }//GEN-LAST:event_txtEstoqueFocusGained

    private void txtReposicaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtReposicaoFocusGained
        txtReposicao.setBackground(Color.white);
    }//GEN-LAST:event_txtReposicaoFocusGained

    private void txtValorCompraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorCompraFocusGained
        txtValorCompra.setBackground(Color.white);
    }//GEN-LAST:event_txtValorCompraFocusGained

    private void txtValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorFocusGained
        txtValor.setBackground(Color.white);
    }//GEN-LAST:event_txtValorFocusGained

    private void txtGarantiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGarantiaFocusGained
        txtGarantia.setBackground(Color.white);
    }//GEN-LAST:event_txtGarantiaFocusGained

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        pesquisarTabela(campo);
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void cmbPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPesquisaActionPerformed
        if (cmbPesquisa.getSelectedIndex() == 0) {
            campo = "tbl_produto.nome_produto LIKE '" + txtPesquisa.getText() + "%'";
        }
        if (cmbPesquisa.getSelectedIndex() == 1) {
            campo = "tbl_produto.descricao LIKE '" + txtPesquisa.getText() + "%'";
        }
        if (cmbPesquisa.getSelectedIndex() == 2) {
            campo = "tbl_produto.valor_original='" + txtPesquisa.getText() + "'";
        }
        if (cmbPesquisa.getSelectedIndex() == 3) {
            campo = "tbl_produto.valor='" + txtPesquisa.getText() + "'";
        }
        if (cmbPesquisa.getSelectedIndex() == 4) {
            campo = "tbl_produto.garantia=" + txtPesquisa.getText();
        }
        if (cmbPesquisa.getSelectedIndex() == 5) {
            campo = "tbl_produto.unidades_em_estoque=" + txtPesquisa.getText();
        }
        if (cmbPesquisa.getSelectedIndex() == 6) {
            campo = "tbl_produto.unidades_reposicao=" + txtPesquisa.getText();
        }
    }//GEN-LAST:event_cmbPesquisaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAlterar;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFabricante;
    private javax.swing.JButton btnFornecedor;
    private javax.swing.ButtonGroup btnGrp;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox cmbCategoria;
    private javax.swing.JComboBox cmbFabricante;
    private javax.swing.JComboBox cmbFornecedor;
    private javax.swing.JComboBox cmbPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSelecionado;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel painel;
    private javax.swing.JPanel painelUnidades;
    private javax.swing.JRadioButton rbImprimirTodos;
    private javax.swing.JRadioButton rbIndividualImprimir;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtEstoque;
    private javax.swing.JTextField txtGarantia;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtReposicao;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtValorCompra;
    // End of variables declaration//GEN-END:variables
}
