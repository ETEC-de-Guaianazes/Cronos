package frontEnd;

import Banco.*;
import Validacoes.Validacao;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import java.sql.*;
import javax.swing.ListSelectionModel;

public class frameFornecedor extends javax.swing.JInternalFrame {

    public CadFornecedor cadFor;
    public String sql;
    private Conexao con = new Conexao();
    private Statement meustate;
    private ResultSet resultset;
    private DefaultListModel listaTelefone = new DefaultListModel();
    private String CNPJ, estado, telefone, msg;
    private Comum cmm = new Comum();
    private Validacao vld = new Validacao();
    private int Careto = 0, progresso = 0;

    /** Creates new form frameFornecedor */
    public frameFornecedor() {
        initComponents();
        btnInserir.setEnabled(false);
        btnCancelar.setEnabled(false);
        lstTel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void setHabilitaTudo(boolean verdade) {
        //Fornecedor
        txtNome.setEnabled(verdade);
        txtCnpj.setEnabled(verdade);
        //Contato
        txtNomeContato.setEnabled(verdade);
        txtTelefoneContato.setEnabled(verdade);
        lstTel.setEnabled(verdade);
        btnTel.setEnabled(verdade);
        btnSelecionaTel.setEnabled(verdade);
        //Endereço
        txtBairro.setEnabled(verdade);
        txtCep.setEnabled(verdade);
        txtCidade.setEnabled(verdade);
        txtNumero.setEnabled(verdade);
        txtRua.setEnabled(verdade);
        txtComplemento.setEnabled(verdade);
        cmbEstado.setEnabled(verdade);

    }

    private void Limpar() {
        txtCep.setText("");
        txtCidade.setText("");
        txtCnpj.setText("");
        txtComplemento.setText("");
        txtNome.setText("");
        txtNomeContato.setText("");
        txtNumero.setText("");
        txtRua.setText("");
        txtTelefoneContato.setText("");
        txtBairro.setText("");
        txtNome.setBackground(Color.white);
        txtCnpj.setBackground(Color.white);
        txtNomeContato.setBackground(Color.white);
        lstTel.setBackground(Color.white);
        txtBairro.setBackground(Color.white);
        txtCep.setBackground(Color.white);
        txtNumero.setBackground(Color.white);
        txtRua.setBackground(Color.white);
        txtCidade.setBackground(Color.white);
        cmbEstado.setSelectedIndex(0);
        ((DefaultListModel) (lstTel.getModel())).clear();
    }

    private int validaTudo() {
        progresso = 0;
        msg = "";
        if (txtNome.getText().replaceAll(" ", "").length() < 3) {
            msg += "Nome do fornecedor;\n";
            progresso += 1;
            txtNome.setBackground(Color.red);
        }
        if (vld.validaCnpj(txtCnpj.getText()) == false) {
            msg += "CNPJ;\n";
            progresso += 1;
            txtCnpj.setBackground(Color.red);
        }
        if (vld.validaNome(txtNomeContato.getText()) == false) {
            msg += "Nome do contato;\n";
            progresso += 1;
            txtNomeContato.setBackground(Color.red);
        }
        if (lstTel.getModel().getSize() < 1) {
            msg += "Telefone;\n";
            progresso = 1;
            lstTel.setBackground(Color.red);
        }
        if (vld.validaNome(txtRua.getText()) == false) {
            msg += "Logradouro;\n";
            progresso += 1;
            txtRua.setBackground(Color.red);
        }
        if (vld.isNumeric(txtNumero.getText().replaceAll("_ ", "")) == false) {
            msg += "Número;\n";
            progresso += 1;
            txtNumero.setBackground(Color.red);
        }
        if (vld.validaNome(txtBairro.getText()) == false) {
            msg += "Bairro;\n";
            progresso += 1;
            txtBairro.setBackground(Color.red);
        }
        if (txtCep.getText().replaceAll("[_-]", "").replaceAll(" ", "").equals("") == false && txtCep.getText().replaceAll("[_-]", "").replaceAll(" ", "").length() > 0) {
            if (txtCep.getText().replaceAll("[_-]", "").replaceAll(" ", "").length() < 8) {
                msg += "CEP;\n";
                progresso = 1;
                txtCep.setBackground(Color.red);
            }
        }
        if (vld.validaNome(txtCidade.getText()) == false) {
            msg += "Cidade;\n";
            progresso += 1;
            txtCidade.setBackground(Color.red);
        }
        return progresso;
    }//Fim validaTudo()

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bntgrp = new javax.swing.ButtonGroup();
        painel = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        painelEndereco = new javax.swing.JPanel();
        lblRua = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        lblComplemento = new javax.swing.JLabel();
        lblCep = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox();
        txtComplemento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JFormattedTextField();
        txtCep = new javax.swing.JFormattedTextField();
        txtNumero = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JFormattedTextField();
        txtNome = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        painelContato = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeContato = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnTel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstTel = new javax.swing.JList();
        txtTelefoneContato = new javax.swing.JFormattedTextField();
        btnSelecionaTel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cmbcampos = new javax.swing.JComboBox();
        txtPesquisa = new javax.swing.JTextField();
        btnInserir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        painelImpressao = new javax.swing.JPanel();
        btnImprimir = new javax.swing.JButton();
        rbIndividualImprimir = new javax.swing.JRadioButton();
        rbImprimirTodos = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        lblSelecionado = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setTitle("FORNECEDOR");
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

        painel.setPreferredSize(new java.awt.Dimension(0, 330));
        painel.setLayout(null);

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
        btnCancelar.setBounds(560, 220, 90, 50);

        painelEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Endereço ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        painelEndereco.setOpaque(false);
        painelEndereco.setLayout(null);

        lblRua.setFont(new java.awt.Font("sansserif", 1, 12));
        lblRua.setText("Logradouro:");
        painelEndereco.add(lblRua);
        lblRua.setBounds(20, 30, 70, 16);

        txtRua.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRuaFocusGained(evt);
            }
        });
        txtRua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRuaKeyReleased(evt);
            }
        });
        painelEndereco.add(txtRua);
        txtRua.setBounds(100, 24, 310, 23);

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel5.setText("Nº:");
        painelEndereco.add(jLabel5);
        jLabel5.setBounds(30, 60, 30, 16);

        lblBairro.setFont(new java.awt.Font("sansserif", 1, 12));
        lblBairro.setText("Bairro:");
        painelEndereco.add(lblBairro);
        lblBairro.setBounds(150, 60, 38, 16);

        txtBairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBairroFocusGained(evt);
            }
        });
        txtBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBairroKeyReleased(evt);
            }
        });
        painelEndereco.add(txtBairro);
        txtBairro.setBounds(200, 54, 210, 23);

        lblComplemento.setFont(new java.awt.Font("sansserif", 1, 12));
        lblComplemento.setText("Complemento:");
        painelEndereco.add(lblComplemento);
        lblComplemento.setBounds(20, 90, 90, 16);

        lblCep.setFont(new java.awt.Font("sansserif", 1, 12));
        lblCep.setText("CEP:");
        painelEndereco.add(lblCep);
        lblCep.setBounds(250, 90, 26, 16);

        lblEstado.setFont(new java.awt.Font("sansserif", 1, 12));
        lblEstado.setText("Estado:");
        painelEndereco.add(lblEstado);
        lblEstado.setBounds(20, 120, 50, 16);

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        painelEndereco.add(cmbEstado);
        cmbEstado.setBounds(70, 114, 100, 23);

        txtComplemento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtComplementoKeyReleased(evt);
            }
        });
        painelEndereco.add(txtComplemento);
        txtComplemento.setBounds(110, 84, 80, 23);

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel6.setText("Cidade: ");
        painelEndereco.add(jLabel6);
        jLabel6.setBounds(190, 120, 50, 16);

        txtCidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCidadeFocusGained(evt);
            }
        });
        txtCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCidadeKeyReleased(evt);
            }
        });
        painelEndereco.add(txtCidade);
        txtCidade.setBounds(240, 114, 170, 23);

        txtCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCepFocusGained(evt);
            }
        });
        painelEndereco.add(txtCep);
        txtCep.setBounds(280, 84, 130, 23);

        txtNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumeroFocusGained(evt);
            }
        });
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroKeyReleased(evt);
            }
        });
        painelEndereco.add(txtNumero);
        txtNumero.setBounds(50, 54, 90, 23);

        painel.add(painelEndereco);
        painelEndereco.setBounds(320, 0, 430, 160);

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
        btnExcluir.setBounds(350, 220, 90, 50);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Fornecedor ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel3.setText("Nome:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 30, 36, 16);

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel4.setText("CNPJ:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 70, 34, 16);

        txtCnpj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCnpjFocusGained(evt);
            }
        });
        txtCnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCnpjKeyReleased(evt);
            }
        });
        jPanel1.add(txtCnpj);
        txtCnpj.setBounds(60, 66, 240, 23);

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
        jPanel1.add(txtNome);
        txtNome.setBounds(60, 26, 240, 23);

        painel.add(jPanel1);
        jPanel1.setBounds(0, 0, 320, 100);

        jButton1.setText("Imprimir");
        painel.add(jButton1);
        jButton1.setBounds(640, 560, 100, 30);

        painelContato.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Contato ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        painelContato.setOpaque(false);
        painelContato.setLayout(null);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel1.setText("Nome:");
        painelContato.add(jLabel1);
        jLabel1.setBounds(40, 30, 36, 16);

        txtNomeContato.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomeContatoFocusGained(evt);
            }
        });
        txtNomeContato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeContatoKeyReleased(evt);
            }
        });
        painelContato.add(txtNomeContato);
        txtNomeContato.setBounds(80, 26, 220, 23);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel2.setText("Telefone:");
        painelContato.add(jLabel2);
        jLabel2.setBounds(20, 70, 70, 16);

        btnTel.setText("+");
        btnTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelActionPerformed(evt);
            }
        });
        painelContato.add(btnTel);
        btnTel.setBounds(240, 66, 50, 23);

        jScrollPane2.setViewportView(lstTel);

        painelContato.add(jScrollPane2);
        jScrollPane2.setBounds(80, 90, 160, 60);
        painelContato.add(txtTelefoneContato);
        txtTelefoneContato.setBounds(80, 66, 160, 23);

        btnSelecionaTel.setText("^");
        btnSelecionaTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionaTelActionPerformed(evt);
            }
        });
        painelContato.add(btnSelecionaTel);
        btnSelecionaTel.setBounds(240, 90, 50, 23);

        painel.add(painelContato);
        painelContato.setBounds(0, 100, 320, 160);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Pesquisa ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        jPanel2.setLayout(null);

        cmbcampos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código", "Nome", "CNPJ", "Contato", "Rua", " " }));
        jPanel2.add(cmbcampos);
        cmbcampos.setBounds(20, 20, 150, 23);

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });
        jPanel2.add(txtPesquisa);
        txtPesquisa.setBounds(170, 20, 250, 23);

        painel.add(jPanel2);
        jPanel2.setBounds(320, 270, 440, 60);

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
        painel.add(btnInserir);
        btnInserir.setBounds(460, 170, 90, 50);

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
        btnNovo.setBounds(350, 170, 90, 50);

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
        btnLimpar.setBounds(460, 220, 90, 50);

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/alterar_icone.png"))); // NOI18N
        btnAlterar.setMnemonic('E');
        btnAlterar.setText("Editar");
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
        btnAlterar.setBounds(560, 170, 90, 50);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Navegação ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        jPanel3.setMaximumSize(new java.awt.Dimension(350, 100));
        jPanel3.setMinimumSize(new java.awt.Dimension(350, 100));
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(380, 180));
        jPanel3.setLayout(null);

        btnPrimeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/primeiro.png"))); // NOI18N
        btnPrimeiro.setToolTipText("Primeiro registro");
        btnPrimeiro.setPreferredSize(new java.awt.Dimension(90, 36));
        btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroActionPerformed(evt);
            }
        });
        jPanel3.add(btnPrimeiro);
        btnPrimeiro.setBounds(10, 20, 80, 36);

        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/anterior.png"))); // NOI18N
        btnAnterior.setToolTipText("Resgistro anterior");
        btnAnterior.setPreferredSize(new java.awt.Dimension(90, 36));
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        jPanel3.add(btnAnterior);
        btnAnterior.setBounds(90, 20, 70, 36);

        btnProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/proximo.png"))); // NOI18N
        btnProximo.setToolTipText("Resgistro posterior");
        btnProximo.setPreferredSize(new java.awt.Dimension(90, 36));
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });
        jPanel3.add(btnProximo);
        btnProximo.setBounds(160, 20, 70, 36);

        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ultimo.png"))); // NOI18N
        btnUltimo.setToolTipText("Último registro");
        btnUltimo.setPreferredSize(new java.awt.Dimension(90, 36));
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });
        jPanel3.add(btnUltimo);
        btnUltimo.setBounds(230, 20, 80, 36);

        painel.add(jPanel3);
        jPanel3.setBounds(0, 260, 320, 70);

        getContentPane().add(painel, java.awt.BorderLayout.PAGE_START);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Fornecedores"
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
        });
        tabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        painelImpressao.setPreferredSize(new java.awt.Dimension(10, 40));
        painelImpressao.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        btnImprimir.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/imprimir_icone.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setPreferredSize(new java.awt.Dimension(104, 40));
        painelImpressao.add(btnImprimir);

        bntgrp.add(rbIndividualImprimir);
        rbIndividualImprimir.setFont(new java.awt.Font("sansserif", 1, 12));
        rbIndividualImprimir.setText("Individual");
        painelImpressao.add(rbIndividualImprimir);

        bntgrp.add(rbImprimirTodos);
        rbImprimirTodos.setFont(new java.awt.Font("sansserif", 1, 12));
        rbImprimirTodos.setSelected(true);
        rbImprimirTodos.setText("Todos");
        painelImpressao.add(rbImprimirTodos);

        jLabel7.setText("Selecionado:");
        painelImpressao.add(jLabel7);

        lblSelecionado.setFont(new java.awt.Font("Dialog", 0, 12));
        painelImpressao.add(lblSelecionado);

        jLabel8.setText("Total:");
        painelImpressao.add(jLabel8);

        lblTotal.setFont(new java.awt.Font("Dialog", 0, 12));
        painelImpressao.add(lblTotal);

        getContentPane().add(painelImpressao, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        Limpar();
}//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (cadFor.possuiProdutos(CNPJ) == false) {
            con.Fecha();
            if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este fornecedor?\n" +
                    "*Esta operação não poderá ser desfeita\n" +
                    "caso seja executada.", "Atenção!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                cadFor = new CadFornecedor();
                con.Conecta();
                try {
                    con.Conecta();
                    progresso = 0;
                    CNPJ = (tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
                    cadFor.pegaendereco(CNPJ);
                    cadFor.pegacontato(CNPJ);
                    progresso += cadFor.excluirtelefones();
                    progresso += cadFor.excluirfornecedores();
                    progresso += cadFor.excluicontato();
                    progresso += cadFor.excluiendereco();
                    if (progresso == 0) {
                        JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso!", "Operação bem-sucedida!", JOptionPane.INFORMATION_MESSAGE);
                        con.Fecha();
                        atualizarTabela();
                        cancelar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Operação executada com " + progresso + " erro(s).\n" +
                                "Remova todos os produtos relacionados a\n" +
                                "este fornecedor para prosseguir.", "Não foi possível remover.", JOptionPane.ERROR_MESSAGE);
                        con.Fecha();
                        btnAlterar.setSelected(true);
                    }
                } catch (Error erro) {
                    JOptionPane.showMessageDialog(null, "Não foi possível remover.\n" + erro, "Erro!", JOptionPane.ERROR_MESSAGE);
                    erro.printStackTrace();
                    con.Fecha();
                    btnAlterar.setSelected(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Existem produtos cadastrados que dependem deste fornecedor.\n" +
                        "Remova-os antes de continuar com esta operação.", "Este fornecedor não pode ser removido!", JOptionPane.WARNING_MESSAGE);
                cancelar();
            }
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
        cmbcampos.setEnabled(false);
        txtNome.grabFocus();
}//GEN-LAST:event_btnNovoActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        if (validaTudo() == 0) {
            try {
                con.Conecta();
                cadFor = new CadFornecedor();
                progresso = 0;
                sql = "INSERT INTO tbl_endereco_fornecedor (RUA, NUMERO, BAIRRO, COMPLEMENTO," +
                        "CEP, CIDADE, ESTADO) VALUES ('" + txtRua.getText() + "'," + txtNumero.getText().replaceAll(" ", "") + ", '" + txtBairro.getText() + "', '" +
                        txtComplemento.getText() + "', '" + txtCep.getText() + "', '" + txtCidade.getText() + "', '" + cmbEstado.getSelectedItem().toString() + "')";
                progresso += cadFor.CadastraEndereco(sql);
                progresso += cadFor.cadastraContato(txtNomeContato.getText());
                for (int i = 0; i < listaTelefone.size(); i++) {
                    telefone = (String) listaTelefone.get(i);
                    progresso += cadFor.cadastraTelefone(cadFor.getCodigoContato(), telefone);
                }
                progresso += cadFor.cadastraFornecedor(txtNome.getText(), txtCnpj.getText(), cadFor.getCodigoContato(), cadFor.pegaCodigoEndereco());
                if (progresso == 0) {
                    JOptionPane.showMessageDialog(null, "Fornecedor inserido com sucesso!", "Operação bem-sucedida!", JOptionPane.INFORMATION_MESSAGE);
                    con.Fecha();
                    atualizarTabela();
                    cancelar();
                } else {
                    JOptionPane.showMessageDialog(null, "Operação executada com " + progresso + " erro(s).", "Não foi possível cadastrar.", JOptionPane.ERROR_MESSAGE);
                    con.Fecha();
                }
            } catch (Error erro) {
                JOptionPane.showMessageDialog(null, "Não foi possível cadastrar.", "Atenção!!!", JOptionPane.ERROR_MESSAGE);
                erro.printStackTrace();
                con.Fecha();
            }
        } else {
            JOptionPane.showMessageDialog(null, msg, "Preencha o(s) seguinte(s) corretamente:", JOptionPane.WARNING_MESSAGE);
        }
}//GEN-LAST:event_btnInserirActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
}//GEN-LAST:event_txtPesquisaKeyReleased

    private void btnSelecionaTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionaTelActionPerformed
        txtTelefoneContato.setText(lstTel.getSelectedValue().toString());
        int indice = lstTel.getSelectedIndex();
        if (indice > -1) {
            ((DefaultListModel) (lstTel.getModel())).remove(indice);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um telefone para editá-lo");
        }
}//GEN-LAST:event_btnSelecionaTelActionPerformed

    private void btnTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelActionPerformed
        if (txtTelefoneContato.getText().replaceAll("_-", "").replaceAll(" ", "").length() == 13) {
            listaTelefone.addElement(txtTelefoneContato.getText());
            lstTel.setBackground(Color.white);
            txtTelefoneContato.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Preencha com um telefone válido.");
            txtTelefoneContato.grabFocus();
        }
}//GEN-LAST:event_btnTelActionPerformed

    private void tabelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyReleased
        if ((evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
            sincronizarTabela();
        }
}//GEN-LAST:event_tabelaKeyReleased

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (evt.getClickCount() >= 0) {
            sincronizarTabela();
        }
}//GEN-LAST:event_tabelaMouseClicked

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        cmm.setFormataNumero("(##)####-####", txtTelefoneContato, "0123456789", ' ');
        cmm.setFormataNumero("#####-###", txtCep, "0123456789", ' ');
        cmm.setFormataNumero("##.###.###/####.##", txtCnpj, "0123456789", ' ');
        lstTel.setModel(listaTelefone);
        cancelar();
        atualizarTabela();
    }//GEN-LAST:event_formInternalFrameOpened

    private void cancelar() {
        Limpar();
        setHabilitaTudo(false);
        btnCancelar.setEnabled(false);
        btnInserir.setEnabled(false);
        btnAlterar.setEnabled(false);
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
        cmbcampos.setEnabled(true);
    }

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
            cmbcampos.setEnabled(false);
        } else {
            if (validaTudo() == 0) {
                try {
                    con.Conecta();
                    cadFor = new CadFornecedor();
                    progresso = 0;
                    cadFor.pegaendereco(CNPJ);
                    cadFor.pegacontato(CNPJ);
                    progresso += cadFor.excluirtelefones();
                    for (int i = 0; i < listaTelefone.size(); i++) {
                        telefone = (String) listaTelefone.get(i);
                        progresso += cadFor.cadastraTelefone("" + cadFor.retornacodcontato() + "", telefone);
                    }
                    progresso += cadFor.alterarcontato(txtNomeContato.getText());
                    progresso += cadFor.alterarfornecedores(txtNome.getText(), txtCnpj.getText());
                    progresso += cadFor.alterarendereco(txtRua.getText(), txtNumero.getText(), txtBairro.getText(), txtComplemento.getText(), txtCep.getText(), txtCidade.getText(), cmbEstado.getSelectedItem().toString());
                    if (progresso == 0) {
                        JOptionPane.showMessageDialog(this, "Fornecedor atualizado com sucesso.", "Sucesso ao atualizar", JOptionPane.INFORMATION_MESSAGE);
                        cancelar();
                        btnAlterar.setToolTipText("Alterar");
                        btnAlterar.setText("Alterar");
                        btnAlterar.setMnemonic('A');
                        atualizarTabela();
                        con.Fecha();
                    } else {
                        JOptionPane.showMessageDialog(this, progresso + " erro(s) encontrados durante a operação.", "Não foi possível alterar!", JOptionPane.ERROR_MESSAGE);
                        con.Fecha();
                        btnAlterar.setSelected(true);
                    }
                } catch (Error erro) {
                    JOptionPane.showMessageDialog(this, "Não foi possível alterar.", "Erro!", JOptionPane.ERROR_MESSAGE);
                    erro.printStackTrace();
                    con.Fecha();
                    btnAlterar.setSelected(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, msg, "Preencha o(s) seguinte(s) corretamente:", JOptionPane.WARNING_MESSAGE);
                btnAlterar.setSelected(true);
            }
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            Careto = txtNome.getCaretPosition();
            cmm.getParaMaiuscula(txtNome);
            txtNome.setCaretPosition(Careto);
            pesquisarTabela("tbl_fornecedor.nome_fornecedor LIKE '" + txtNome.getText() + "%'");
        }
    }//GEN-LAST:event_txtNomeKeyReleased

    private void txtNomeContatoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeContatoKeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            Careto = txtNomeContato.getCaretPosition();
            cmm.getParaMaiuscula(txtNomeContato);
            txtNomeContato.setCaretPosition(Careto);
        }
    }//GEN-LAST:event_txtNomeContatoKeyReleased

    private void txtRuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRuaKeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            Careto = txtRua.getCaretPosition();
            cmm.getParaMaiuscula(txtRua);
            txtRua.setCaretPosition(Careto);
        }
    }//GEN-LAST:event_txtRuaKeyReleased

    private void txtBairroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBairroKeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            Careto = txtBairro.getCaretPosition();
            cmm.getParaMaiuscula(txtBairro);
            txtBairro.setCaretPosition(Careto);
        }
    }//GEN-LAST:event_txtBairroKeyReleased

    private void txtComplementoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComplementoKeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            Careto = txtComplemento.getCaretPosition();
            cmm.getParaMaiuscula(txtComplemento);
            txtComplemento.setCaretPosition(Careto);
        }
    }//GEN-LAST:event_txtComplementoKeyReleased

    private void txtCidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCidadeKeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            Careto = txtCidade.getCaretPosition();
            cmm.getParaMaiuscula(txtCidade);
            txtCidade.setCaretPosition(Careto);
        }
    }//GEN-LAST:event_txtCidadeKeyReleased

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

    private void txtCnpjKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCnpjKeyReleased
        pesquisarTabela("tbl_fornecedor.cnpj LIKE '" + txtCnpj.getText() + "'");
    }//GEN-LAST:event_txtCnpjKeyReleased

    private void txtNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusGained
        txtNome.setBackground(Color.white);
    }//GEN-LAST:event_txtNomeFocusGained

    private void txtCnpjFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCnpjFocusGained
        txtCnpj.setBackground(Color.white);
    }//GEN-LAST:event_txtCnpjFocusGained

    private void txtNomeContatoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeContatoFocusGained
        txtNomeContato.setBackground(Color.white);
    }//GEN-LAST:event_txtNomeContatoFocusGained

    private void txtRuaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRuaFocusGained
        txtRua.setBackground(Color.white);
    }//GEN-LAST:event_txtRuaFocusGained

    private void txtBairroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBairroFocusGained
        txtBairro.setBackground(Color.white);
    }//GEN-LAST:event_txtBairroFocusGained

    private void txtCepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCepFocusGained
        txtCep.setBackground(Color.white);
    }//GEN-LAST:event_txtCepFocusGained

    private void txtCidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCidadeFocusGained
        txtCidade.setBackground(Color.white);
    }//GEN-LAST:event_txtCidadeFocusGained

    private void txtNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyReleased
        if (vld.isNumeric("" + evt.getKeyChar() + "") == false && (evt.getKeyCode() != KeyEvent.VK_UP) && (evt.getKeyCode() != KeyEvent.VK_DOWN) && (evt.getKeyCode() != KeyEvent.VK_LEFT) && (evt.getKeyCode() != KeyEvent.VK_RIGHT)) {
            Careto = txtNumero.getCaretPosition();
            txtNumero.setText(txtNumero.getText().replaceAll("" + evt.getKeyChar() + "", ""));
            txtNumero.setCaretPosition(Careto);
        }
    }//GEN-LAST:event_txtNumeroKeyReleased

    private void txtNumeroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroFocusGained
        txtNumero.setBackground(Color.white);
    }//GEN-LAST:event_txtNumeroFocusGained

    private void sincronizarTabela() {
        lblSelecionado.setText(""+(tabela.getSelectedRow()+1));
        txtNome.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
        txtCnpj.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        txtRua.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
        txtCep.setText(tabela.getValueAt(tabela.getSelectedRow(), 6).toString());
        txtNumero.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
        txtComplemento.setText(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());
        estado = tabela.getValueAt(tabela.getSelectedRow(), 7).toString();
        cmbEstado.setSelectedIndex(cmm.indexEstado(estado));
        selecionarTelefones();
        txtCidade.setText(tabela.getValueAt(tabela.getSelectedRow(), 9).toString());
        txtNomeContato.setText(tabela.getValueAt(tabela.getSelectedRow(), 8).toString());
        txtBairro.setText(tabela.getValueAt(tabela.getSelectedRow(), 5).toString());
        setHabilitaTudo(false);
        btnExcluir.setEnabled(true);
        btnAlterar.setEnabled(true);
        btnNovo.setEnabled(true);
        btnLimpar.setEnabled(false);
        btnInserir.setEnabled(false);
        btnCancelar.setEnabled(false);
    }//Fim sincronizarTabela()

    public void selecionarTelefones() {
        ((DefaultListModel) (lstTel.getModel())).clear();
        con.Conecta();
        cadFor = new CadFornecedor();
        CNPJ = (tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        cadFor.pegacontato(CNPJ);
        Integer Contato = cadFor.retornacodcontato();
        sql = "SELECT telefone FROM tbl_telefone_cont WHERE cod_contato = " + Contato;
        try {
            meustate = Conexao.con.createStatement();
            resultset = meustate.executeQuery(sql);
            while (resultset.next()) {
                listaTelefone.addElement(resultset.getString("telefone"));
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao carregar telefones na lista");
            erro.printStackTrace();
        }
        con.Fecha();
    }//Fim selecionarTelefones()

    private void pesquisarTabela(String campo) {
        sql = "SELECT tbl_fornecedor.nome_fornecedor AS Fornecedor, tbl_fornecedor.CNPJ AS CNPJ, tbl_endereco_fornecedor.rua AS Logradouro, tbl_endereco_fornecedor.numero AS Numero, " +
                "tbl_endereco_fornecedor.complemento AS Complemento, tbl_endereco_fornecedor.bairro AS Bairro, tbl_endereco_fornecedor.cep AS CEP, tbl_endereco_fornecedor.estado AS Estado, " +
                "tbl_contato.nome AS Contato, tbl_endereco_fornecedor.cidade AS Cidade FROM tbl_endereco_fornecedor INNER JOIN " +
                "((tbl_contato INNER JOIN tbl_fornecedor ON tbl_contato.cod_contato = tbl_fornecedor.cod_contato) " +
                ") ON tbl_endereco_fornecedor.cod_endereco = tbl_fornecedor.cod_endereco WHERE " + campo;
        cmm.criarTabela(sql, tabela);
        lblTotal.setText(""+tabela.getRowCount());
    }//Fim pesquisarTabela()

    private void atualizarTabela() {
        sql = "SELECT tbl_fornecedor.nome_fornecedor AS Fornecedor, tbl_fornecedor.CNPJ AS CNPJ, tbl_endereco_fornecedor.rua AS Logradouro, tbl_endereco_fornecedor.numero AS Numero, " +
                "tbl_endereco_fornecedor.complemento AS Complemento, tbl_endereco_fornecedor.bairro AS Bairro, tbl_endereco_fornecedor.cep AS CEP, tbl_endereco_fornecedor.estado AS Estado, " +
                "tbl_contato.nome AS Contato, tbl_endereco_fornecedor.cidade AS Cidade FROM tbl_endereco_fornecedor INNER JOIN " +
                "((tbl_contato INNER JOIN tbl_fornecedor ON tbl_contato.cod_contato = tbl_fornecedor.cod_contato) " +
                ") ON tbl_endereco_fornecedor.cod_endereco = tbl_fornecedor.cod_endereco";
        cmm.criarTabela(sql, tabela);
        lblTotal.setText(""+tabela.getRowCount());
    }//Fim atualizarTabela()
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bntgrp;
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
    private javax.swing.JButton btnSelecionaTel;
    private javax.swing.JButton btnTel;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbcampos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblRua;
    private javax.swing.JLabel lblSelecionado;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JList lstTel;
    private javax.swing.JPanel painel;
    private javax.swing.JPanel painelContato;
    private javax.swing.JPanel painelEndereco;
    private javax.swing.JPanel painelImpressao;
    private javax.swing.JRadioButton rbImprimirTodos;
    private javax.swing.JRadioButton rbIndividualImprimir;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JFormattedTextField txtCidade;
    private javax.swing.JFormattedTextField txtCnpj;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JFormattedTextField txtNome;
    private javax.swing.JTextField txtNomeContato;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtRua;
    private javax.swing.JFormattedTextField txtTelefoneContato;
    // End of variables declaration//GEN-END:variables
}
