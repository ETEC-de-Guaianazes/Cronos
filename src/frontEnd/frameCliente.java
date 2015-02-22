/*
 * frameCliente.java
 *
 * Created on 01/05/2010, 11:54:36
 */
package frontEnd;

import Banco.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import Validacoes.Validacao;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.DefaultListModel;

public class frameCliente extends javax.swing.JInternalFrame {

    private CadCliente cadcli;
    private String campoPesquisa, sql, msg, estado, telefonis, tipus;
    private DefaultListModel listaTelefone, listaTipo;
    private Validacao validar = new Validacao();
    private int Careto, validacaoResultado, progresso;
    private Conexao con = new Conexao();
    private Comum cmm = new Comum();

    // Metódo validador
    private int validaTudo() {
        msg = "";
        validacaoResultado = 0;
        if (validar.validaNome(txtNome.getText().replaceAll(" ", "")) == false) {
            msg += "Nome;\n";
            validacaoResultado = 1;
            txtNome.setBackground(Color.red);
        }
        if (txtRg.getText().replaceAll(" ", "").length() < 6) {
            msg += "RG;\n";
            validacaoResultado = 1;
            txtRg.setBackground(Color.red);
        }
        if (validar.valida_Cpf(txtCpf.getText()) == false) {
            msg += "CPF;\n";
            validacaoResultado = 1;
            txtCpf.setBackground(Color.red);
        }
        if (txtNasc.getDate().after(new Date()) && txtNasc.getDate().equals(new Date())) {
            msg = msg + "Data de nascimento;\n";
            validacaoResultado = 1;
            txtNasc.setBackground(Color.red);
        }
        if (lstTelefone.getModel().getSize() < 1) {
            msg += "Telefone;\n";
            validacaoResultado = 1;
            lstTelefone.setBackground(Color.red);
            lstTipo.setBackground(Color.red);
        }
        if (txtEmail.getText().replaceAll(" ", "").equals("") == false && txtEmail.getText().replaceAll(" ", "").length() > 0) {
            if (validar.validaEmail(txtEmail.getText()) == false) {
                msg += "E-mail;\n";
                validacaoResultado = 1;
                txtEmail.setBackground(Color.red);
            }
        }
        //Endereço
        if (txtRua.getText().length() < 3) {
            msg += "Logradouro;\n";
            validacaoResultado = 1;
            txtRua.setBackground(Color.red);
        }
        if (validar.validaNumero(txtNumero.getText()) == false) {
            msg += "Número;\n";
            validacaoResultado = 1;
            txtNumero.setBackground(Color.red);
        }
        if (validar.validaNome(txtBairro.getText().replaceAll(" ", "")) == false) {
            msg += "Bairro;\n";
            validacaoResultado = 1;
            txtBairro.setBackground(Color.red);
        }
        if (txtCep.getText().replaceAll("[_-]", "").replaceAll(" ", "").equals("") == false && txtCep.getText().replaceAll("[_-]", "").replaceAll(" ", "").length() > 0) {
            if (txtCep.getText().replaceAll("[_-]", "").replaceAll(" ", "").length() < 8) {
                msg += "CEP;\n";
                validacaoResultado = 1;
                txtCep.setBackground(Color.red);
            }
        }
        if (txtCidade.getText().replaceAll(" ", "").length() < 4) {
            msg += "Cidade;\n";
            validacaoResultado = 1;
            txtCidade.setBackground(Color.red);
        }
        return validacaoResultado;
    }//Fim validaTudo

    private void setHabilitaTudo(boolean verdade) {
        //Informações pessoais
        txtNome.setEnabled(verdade);
        txtCpf.setEnabled(verdade);
        txtRg.setEnabled(verdade);
        txtEmail.setEnabled(verdade);
        txtNasc.setEnabled(verdade);
        //Formas de contato
        txtTelefone.setEnabled(verdade);
        lstTelefone.setEnabled(verdade);
        lstTipo.setEnabled(verdade);
        cmbTipo.setEnabled(verdade);
        cmbEstado.setEnabled(verdade);
        btnSubir.setEnabled(verdade);
        btnAdicionar.setEnabled(verdade);
        //Endereço
        txtNumero.setEnabled(verdade);
        txtRua.setEnabled(verdade);
        txtBairro.setEnabled(verdade);
        txtCep.setEnabled(verdade);
        txtCidade.setEnabled(verdade);
        txtComplemento.setEnabled(verdade);

    }

    private void Limpar() {
        txtCod.setText("<auto>");
        txtNome.setText("");
        txtRg.setText("");
        txtCpf.setText("");
        txtRua.setText("");
        txtNumero.setText("");
        txtBairro.setText("");
        txtComplemento.setText("");
        txtCep.setText("");
        txtTelefone.setText("");
        txtCidade.setText("");
        cmbEstado.setSelectedIndex(0);
        cmbTipo.setSelectedIndex(0);
        txtEmail.setText("");
        txtNasc.setDate(new Date());
        ((DefaultListModel) (lstTelefone.getModel())).clear();
        ((DefaultListModel) (lstTipo.getModel())).clear();
        tabela.clearSelection();
        lblSelecionado.setText("0");
        txtNome.setBackground(Color.white);
        txtRg.setBackground(Color.white);
        txtCpf.setBackground(Color.white);
        txtNasc.setBackground(Color.white);
        lstTelefone.setBackground(Color.white);
        lstTipo.setBackground(Color.white);
        txtEmail.setBackground(Color.white);
        txtRua.setBackground(Color.white);
        txtNumero.setBackground(Color.white);
        txtBairro.setBackground(Color.white);
        txtCidade.setBackground(Color.white);
        txtCep.setBackground(Color.white);

    }

    /** Creates new form frameCliente */
    public frameCliente() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpImprimir = new javax.swing.ButtonGroup();
        painel = new javax.swing.JPanel();
        painelPessoais = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblCod = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        lblRg = new javax.swing.JLabel();
        txtRg = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        lblNasc = new javax.swing.JLabel();
        txtNasc = new com.toedter.calendar.JDateChooser();
        txtCpf = new javax.swing.JFormattedTextField();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstTelefone = new javax.swing.JList();
        cmbTipo = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstTipo = new javax.swing.JList();
        btnAdicionar = new javax.swing.JButton();
        btnSubir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        painelEndereco = new javax.swing.JPanel();
        lblRua = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        lblComplemento = new javax.swing.JLabel();
        lblCep = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox();
        txtNumero = new javax.swing.JFormattedTextField();
        txtCep = new javax.swing.JFormattedTextField();
        txtComplemento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        btnInserir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cmbPesquisa = new javax.swing.JComboBox();
        txtPesquisa = new javax.swing.JFormattedTextField();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        rbImprimirTodos = new javax.swing.JRadioButton();
        rbIndividualImprimir = new javax.swing.JRadioButton();
        btnImprimir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblSelecionado = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CLIENTE");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cliente_icone.png"))); // NOI18N
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

        painel.setMaximumSize(new java.awt.Dimension(800, 361));
        painel.setMinimumSize(new java.awt.Dimension(800, 360));
        painel.setOpaque(false);
        painel.setPreferredSize(new java.awt.Dimension(800, 360));
        painel.setRequestFocusEnabled(false);
        painel.setLayout(null);

        painelPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Informações pessoais ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 0, 12))); // NOI18N
        painelPessoais.setOpaque(false);
        painelPessoais.setLayout(null);

        lblNome.setFont(new java.awt.Font("sansserif", 1, 12));
        lblNome.setText("Nome:");
        painelPessoais.add(lblNome);
        lblNome.setBounds(30, 60, 50, 16);

        lblCod.setFont(new java.awt.Font("sansserif", 1, 12));
        lblCod.setText("Código:");
        painelPessoais.add(lblCod);
        lblCod.setBounds(20, 30, 50, 16);

        txtCod.setText("<auto>");
        txtCod.setEnabled(false);
        painelPessoais.add(txtCod);
        txtCod.setBounds(80, 24, 160, 22);

        lblRg.setFont(new java.awt.Font("sansserif", 1, 12));
        lblRg.setText("RG:");
        painelPessoais.add(lblRg);
        lblRg.setBounds(30, 90, 19, 16);

        txtRg.setToolTipText("Registro geral");
        txtRg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRgFocusGained(evt);
            }
        });
        painelPessoais.add(txtRg);
        txtRg.setBounds(80, 84, 180, 22);

        lblCpf.setFont(new java.awt.Font("sansserif", 1, 12));
        lblCpf.setText("CPF:");
        painelPessoais.add(lblCpf);
        lblCpf.setBounds(30, 120, 30, 16);

        lblNasc.setFont(new java.awt.Font("sansserif", 1, 12));
        lblNasc.setText("Dt. nascimento:");
        painelPessoais.add(lblNasc);
        lblNasc.setBounds(30, 150, 90, 16);

        txtNasc.setMaxSelectableDate(new Date());
        txtNasc.setMinSelectableDate(new java.util.Date(-2208973944000L));
        txtNasc.setOpaque(false);
        txtNasc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNascFocusGained(evt);
            }
        });
        painelPessoais.add(txtNasc);
        txtNasc.setBounds(130, 144, 170, 22);

        txtCpf.setToolTipText("Cadastro de pessoa física");
        txtCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCpfFocusGained(evt);
            }
        });
        painelPessoais.add(txtCpf);
        txtCpf.setBounds(80, 114, 180, 22);

        txtNome.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNome.setToolTipText("Nome completo");
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
        painelPessoais.add(txtNome);
        txtNome.setBounds(80, 54, 270, 22);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel3.setText("Telefone: ");
        painelPessoais.add(jLabel3);
        jLabel3.setBounds(20, 180, 60, 16);

        txtTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefoneFocusGained(evt);
            }
        });
        painelPessoais.add(txtTelefone);
        txtTelefone.setBounds(80, 174, 130, 22);

        lstTelefone.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 0));
        lstTelefone.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstTelefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstTelefoneMouseClicked(evt);
            }
        });
        lstTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lstTelefoneKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(lstTelefone);

        painelPessoais.add(jScrollPane2);
        jScrollPane2.setBounds(80, 195, 130, 50);

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Residencial", "Comercial", "Celular" }));
        cmbTipo.setAutoscrolls(true);
        cmbTipo.setPreferredSize(new java.awt.Dimension(63, 20));
        painelPessoais.add(cmbTipo);
        cmbTipo.setBounds(210, 174, 100, 22);

        jScrollPane3.setPreferredSize(new java.awt.Dimension(259, 130));

        lstTipo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstTipo.setFocusable(false);
        lstTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstTipoMouseClicked(evt);
            }
        });
        lstTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lstTipoKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(lstTipo);

        painelPessoais.add(jScrollPane3);
        jScrollPane3.setBounds(210, 195, 100, 50);

        btnAdicionar.setFont(new java.awt.Font("sansserif", 1, 12));
        btnAdicionar.setText("+");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        painelPessoais.add(btnAdicionar);
        btnAdicionar.setBounds(310, 174, 50, 22);

        btnSubir.setFont(new java.awt.Font("sansserif", 1, 12));
        btnSubir.setText("^");
        btnSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirActionPerformed(evt);
            }
        });
        painelPessoais.add(btnSubir);
        btnSubir.setBounds(310, 195, 50, 22);

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel4.setText("E-mail:");
        painelPessoais.add(jLabel4);
        jLabel4.setBounds(30, 260, 38, 16);

        txtEmail.setMaximumSize(new java.awt.Dimension(230, 22));
        txtEmail.setMinimumSize(new java.awt.Dimension(230, 22));
        txtEmail.setNextFocusableComponent(txtRua);
        txtEmail.setPreferredSize(new java.awt.Dimension(230, 22));
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        painelPessoais.add(txtEmail);
        txtEmail.setBounds(80, 254, 230, 22);

        painel.add(painelPessoais);
        painelPessoais.setBounds(0, 0, 370, 290);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "  Navegação ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 0, 12))); // NOI18N
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
        jPanel1.setBounds(0, 290, 320, 70);

        painelEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "  Endereço ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 0, 12))); // NOI18N
        painelEndereco.setOpaque(false);
        painelEndereco.setLayout(null);

        lblRua.setFont(new java.awt.Font("sansserif", 1, 12));
        lblRua.setText("Logradouro:");
        painelEndereco.add(lblRua);
        lblRua.setBounds(20, 30, 80, 16);

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
        txtRua.setBounds(100, 24, 260, 22);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel1.setText("Nº:");
        painelEndereco.add(jLabel1);
        jLabel1.setBounds(30, 60, 30, 16);

        lblBairro.setFont(new java.awt.Font("sansserif", 1, 12));
        lblBairro.setText("Bairro:");
        painelEndereco.add(lblBairro);
        lblBairro.setBounds(140, 60, 50, 16);

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
        txtBairro.setBounds(190, 54, 170, 22);

        lblComplemento.setFont(new java.awt.Font("sansserif", 1, 12));
        lblComplemento.setText("Complemento:");
        painelEndereco.add(lblComplemento);
        lblComplemento.setBounds(20, 90, 90, 16);

        lblCep.setFont(new java.awt.Font("sansserif", 1, 12));
        lblCep.setText("CEP:");
        painelEndereco.add(lblCep);
        lblCep.setBounds(190, 90, 40, 16);

        lblEstado.setFont(new java.awt.Font("sansserif", 1, 12));
        lblEstado.setText("Estado:");
        painelEndereco.add(lblEstado);
        lblEstado.setBounds(20, 120, 50, 16);

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cmbEstado.setPreferredSize(new java.awt.Dimension(46, 20));
        painelEndereco.add(cmbEstado);
        cmbEstado.setBounds(70, 114, 100, 22);

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
        txtNumero.setBounds(50, 54, 80, 22);

        txtCep.setMinimumSize(new java.awt.Dimension(250, 20));
        txtCep.setPreferredSize(new java.awt.Dimension(150, 20));
        txtCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCepFocusGained(evt);
            }
        });
        painelEndereco.add(txtCep);
        txtCep.setBounds(220, 84, 140, 22);

        txtComplemento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtComplementoKeyReleased(evt);
            }
        });
        painelEndereco.add(txtComplemento);
        txtComplemento.setBounds(110, 84, 60, 22);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel2.setText("Cidade: ");
        painelEndereco.add(jLabel2);
        jLabel2.setBounds(190, 120, 50, 16);

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
        txtCidade.setBounds(240, 114, 120, 22);

        painel.add(painelEndereco);
        painelEndereco.setBounds(370, 0, 380, 160);

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
        btnInserir.setBounds(500, 170, 90, 60);

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
        btnLimpar.setBounds(500, 240, 90, 60);

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
        btnCancelar.setBounds(610, 240, 90, 60);

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
        btnExcluir.setBounds(390, 240, 90, 60);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "  Pesquisa ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 0, 12))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        cmbPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "RG", "CPF", "Data de nascimento", "Telefone", "CEP", "Estado" }));
        cmbPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPesquisaActionPerformed(evt);
            }
        });
        jPanel2.add(cmbPesquisa);
        cmbPesquisa.setBounds(10, 20, 120, 22);

        txtPesquisa.setPreferredSize(new java.awt.Dimension(127, 26));
        jPanel2.add(txtPesquisa);
        txtPesquisa.setBounds(130, 20, 230, 22);

        painel.add(jPanel2);
        jPanel2.setBounds(370, 300, 380, 60);

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/novo_icone.png"))); // NOI18N
        btnNovo.setMnemonic('N');
        btnNovo.setText("Novo");
        btnNovo.setToolTipText("Novo");
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovo.setOpaque(false);
        btnNovo.setPreferredSize(new java.awt.Dimension(71, 26));
        btnNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        painel.add(btnNovo);
        btnNovo.setBounds(390, 170, 90, 60);

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
        btnAlterar.setBounds(610, 170, 90, 60);

        getContentPane().add(painel, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setHorizontalScrollBar(new javax.swing.JScrollBar(0));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(453, 200));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Clientes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tabela.setMinimumSize(new java.awt.Dimension(60, 50));
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
        jScrollPane1.setViewportView(tabela);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.setMaximumSize(new java.awt.Dimension(10, 40));
        jPanel3.setMinimumSize(new java.awt.Dimension(10, 40));
        jPanel3.setPreferredSize(new java.awt.Dimension(10, 40));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        grpImprimir.add(rbImprimirTodos);
        rbImprimirTodos.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        rbImprimirTodos.setSelected(true);
        rbImprimirTodos.setText("Todos");
        jPanel3.add(rbImprimirTodos);

        grpImprimir.add(rbIndividualImprimir);
        rbIndividualImprimir.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        rbIndividualImprimir.setText("Individual");
        jPanel3.add(rbIndividualImprimir);

        btnImprimir.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/imprimir_icone.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setPreferredSize(new java.awt.Dimension(110, 40));
        jPanel3.add(btnImprimir);

        jLabel5.setText("Selecionado:");
        jPanel3.add(jLabel5);

        lblSelecionado.setFont(new java.awt.Font("Dialog", 0, 12));
        jPanel3.add(lblSelecionado);

        jLabel6.setText("Total:");
        jPanel3.add(jLabel6);

        lblTotal.setFont(new java.awt.Font("Dialog", 0, 12));
        jPanel3.add(lblTotal);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        if (validaTudo() == 0) {
            pesquisarTabela("tbl_cliente.cpf LIKE '" + txtCpf.getText() + "'");
            if (tabela.getRowCount() < 1) {
                try {
                    con.Conecta();
                    cadcli = new CadCliente();
                    progresso = 0;
                    sql = "INSERT INTO tbl_endereco_cliente(RUA,NUMERO,BAIRRO,COMPLEMENTO,CEP,ESTADO,CIDADE)VALUES('" + txtRua.getText() +
                            "'," + txtNumero.getText().replaceAll(" ", "") + ",'" + txtBairro.getText() + "','" + txtComplemento.getText() + "','" + txtCep.getText() +
                            "','" + cmbEstado.getSelectedItem().toString() + "','" + txtCidade.getText() + "')";

                    progresso += cadcli.CadastraEndereco(sql);
                    DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                    txtNasc.getDate();
                    String sData = fmt.format(txtNasc.getDate());//formata a data em um String seguindo a máscara.
                    sql = "INSERT INTO TBL_CLIENTE(NOME,COD_ENDERECO,RG,CPF,DATANASC,EMAIL)VALUES('" +
                            txtNome.getText() + "'," + cadcli.getLastCodigoEndereco() + ",'" + txtRg.getText() + "','" + txtCpf.getText() + "','" + sData +
                            "','" + txtEmail.getText() + "')";

                    progresso += cadcli.cadastraCliente(sql);
                    String codCli = cadcli.getLastCodigoCliente();
                    for (int i = 0; i < listaTelefone.size(); i++) {
                        telefonis = (String) listaTelefone.get(i);
                        tipus = (String) listaTipo.get(i);
                        progresso += cadcli.cadastraTelefone(codCli, telefonis, tipus);
                    }
                    if (progresso == 0) {
                        JOptionPane.showMessageDialog(this, "Cliente inserido com sucesso!", "Operação bem-sucedida!", JOptionPane.INFORMATION_MESSAGE);
                        con.Fecha();
                        atualizarTabela();
                        cancelar();
                    } else {
                        JOptionPane.showMessageDialog(this, "Operação executada com " + progresso + " erro(s).", "Não foi possível cadastrar.", JOptionPane.ERROR_MESSAGE);
                        con.Fecha();
                    }
                } catch (Error erro) {
                    JOptionPane.showMessageDialog(this, "Não foi possível cadastrar.", "Atenção!!!", JOptionPane.ERROR_MESSAGE);
                    erro.printStackTrace();
                    con.Fecha();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Um cliente já foi cadastrado com este CPF.", "Atenção!", JOptionPane.WARNING_MESSAGE);
                txtCpf.setBackground(Color.red);
                txtCpf.grabFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, msg, "Preencha o(s) seguinte(s) corretamente:", JOptionPane.WARNING_MESSAGE);
        }
}//GEN-LAST:event_btnInserirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        Limpar();
}//GEN-LAST:event_btnLimparActionPerformed

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
        btnAlterar.setToolTipText("Alterar");
        btnAlterar.setText("Alterar");
        btnAlterar.setMnemonic('A');
        btnAlterar.setSelected(false);
        cmbPesquisa.setEnabled(true);
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Limpar();
        cancelar();
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        con.Conecta();
        cadcli = new CadCliente();
        if (cadcli.possuiVendas(txtCod.getText()) == false) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir este cliente?\n" +
                    "*Esta operação não poderá ser desfeita\n" +
                    "caso seja executada.", "Atenção!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    progresso = 0;
                    String cod = cadcli.getCodigoEndereco(txtCod.getText());
                    progresso += cadcli.excluirCliente(txtCod.getText());
                    progresso += cadcli.excluirEndereco(cod);
                    progresso += cadcli.excluirTelefone(txtCod.getText());
                    if (progresso == 0) {
                        JOptionPane.showMessageDialog(this, "Sucesso ao excluir cliente.", "Removido com sucesso", JOptionPane.INFORMATION_MESSAGE);
                        con.Fecha();
                    } else {
                        JOptionPane.showMessageDialog(this, progresso + " erro(s) encontrados durante a operação.", "Erro!", JOptionPane.ERROR_MESSAGE);

                    }
                    con.Fecha();
                    cancelar();
                    atualizarTabela();
                } catch (Error er) {
                    JOptionPane.showMessageDialog(this, "Não foi possível a exclusão.", "Erro!", JOptionPane.ERROR_MESSAGE);
                    er.printStackTrace();
                    con.Fecha();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Este cliente possui vendas cadastradas em seu nome.\n" +
                    "Remova-as anter de continuar com esta operação.", "Este cliente não pode ser removido!", JOptionPane.WARNING_MESSAGE);
        }
}//GEN-LAST:event_btnExcluirActionPerformed

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
        cmm.setFormataNumero("#######", txtNumero, "0123456789", ' ');
        cmm.setFormataNumero("(##)####-####", txtTelefone, "0123456789", ' ');
        cmm.setFormataNumero("#####-###", txtCep, "0123456789", ' ');
        cmm.setFormataNumero("###.###.###-##", txtCpf, "0123456789", ' ');
        listaTelefone = new DefaultListModel();
        lstTelefone.setModel(listaTelefone);
        listaTipo = new DefaultListModel();
        lstTipo.setModel(listaTipo);
        atualizarTabela();
        cancelar();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if (txtTelefone.getText().replaceAll("_-", "").replaceAll(" ", "").length() == 13) {
            listaTelefone.addElement(txtTelefone.getText());
            listaTipo.addElement(cmbTipo.getSelectedItem().toString());
            lstTelefone.setBackground(Color.white);
            lstTipo.setBackground(Color.white);
            txtTelefone.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Preencha com um telefone válido.");
            txtTelefone.grabFocus();
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirActionPerformed
        txtTelefone.setText(lstTelefone.getSelectedValue().toString());
        int indice = lstTelefone.getSelectedIndex();
        lstTipo.setSelectedIndex(indice);
        cmbTipo.setSelectedItem(lstTipo.getSelectedValue().toString());
        if (indice > -1) {
            ((DefaultListModel) (lstTelefone.getModel())).remove(indice);
            ((DefaultListModel) (lstTipo.getModel())).remove(indice);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um telefone para editá-lo");
        }
    }//GEN-LAST:event_btnSubirActionPerformed

    private void lstTipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstTipoMouseClicked
        lstTelefone.setSelectedIndex(lstTipo.getSelectedIndex());
    }//GEN-LAST:event_lstTipoMouseClicked

    private void lstTelefoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstTelefoneMouseClicked
        lstTipo.setSelectedIndex(lstTelefone.getSelectedIndex());
    }//GEN-LAST:event_lstTelefoneMouseClicked

    private void lstTipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lstTipoKeyReleased
        if ((evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
            lstTelefone.setSelectedIndex(lstTipo.getSelectedIndex());
        }
    }//GEN-LAST:event_lstTipoKeyReleased

    private void lstTelefoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lstTelefoneKeyReleased
        if ((evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
            lstTipo.setSelectedIndex(lstTelefone.getSelectedIndex());
        }
    }//GEN-LAST:event_lstTelefoneKeyReleased

    private void tabelaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseReleased
        if (evt.getClickCount() >= 0) {
            sincronizarTabela();
        }
    }//GEN-LAST:event_tabelaMouseReleased

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            Careto = txtNome.getCaretPosition();
            cmm.getParaMaiuscula(txtNome);
            txtNome.setCaretPosition(Careto);
            pesquisarTabela("tbl_cliente.nome LIKE '" + txtNome.getText() + "%'");
        }
    }//GEN-LAST:event_txtNomeKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            Careto = txtEmail.getCaretPosition();
            cmm.getParaMinuscula(txtEmail);
            txtEmail.setCaretPosition(Careto);
        }
    }//GEN-LAST:event_txtEmailKeyReleased

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

    private void txtCidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCidadeKeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            Careto = txtCidade.getCaretPosition();
            cmm.getParaMaiuscula(txtCidade);
            txtCidade.setCaretPosition(Careto);
        }
    }//GEN-LAST:event_txtCidadeKeyReleased

    private void alterarCliente() {
        try {
            con.Conecta();
            cadcli = new CadCliente();
            progresso = 0;
            String cod = cadcli.getCodigoEndereco(txtCod.getText());
            sql = "UPDATE TBL_ENDERECO_CLIENTE SET RUA='" + txtRua.getText() +
                    "', NUMERO=" + txtNumero.getText().replaceAll(" ", "") + ", BAIRRO='" + txtBairro.getText() +
                    "', COMPLEMENTO='" + txtComplemento.getText() + "', CEP='" + txtCep.getText() +
                    "', ESTADO='" + cmbEstado.getSelectedItem().toString() + "', CIDADE='" + txtCidade.getText() +
                    "' WHERE COD_ENDERECO=" + cod + "";
            progresso += cadcli.alteraEndereco(sql);

            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            String sData = fmt.format(txtNasc.getDate());//formata a data em um String seguindo a máscara.

            sql = "UPDATE TBL_CLIENTE SET NOME='" + txtNome.getText() + "', RG='" + txtRg.getText() + "', CPF='" + txtCpf.getText() + "', DATANASC='" + sData +
                    "', EMAIL='" + txtEmail.getText() + "' WHERE COD_CLIENTE=" + txtCod.getText();
            progresso += cadcli.alteraCliente(sql);
            cadcli.excluirTelefone(txtCod.getText());
            String codCli = txtCod.getText();
            for (int i = 0; i < listaTelefone.size(); i++) {
                telefonis = (String) listaTelefone.get(i);
                tipus = (String) listaTipo.get(i);
                progresso += cadcli.cadastraTelefone(codCli, telefonis, tipus);
            }
            if (progresso == 0) {
                JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso.", "Sucesso ao atualizar", JOptionPane.INFORMATION_MESSAGE);
                cancelar();
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
            cmbPesquisa.setEnabled(false);
        } else {
            if (validaTudo() == 0) {
                pesquisarTabela("tbl_cliente.cpf LIKE '" + txtCpf.getText() + "'");
                cmm.Proximo(tabela);
                if (tabela.getRowCount() < 1) {
                    alterarCliente();
                } else if (txtCod.getText().replaceAll(" ", "").equals(tabela.getValueAt(0, 0).toString().replaceAll(" ", "")) == true) {
                    alterarCliente();
                } else {
                    JOptionPane.showMessageDialog(this, "Um cliente já foi cadastrado com este CPF.", "Atenção!", JOptionPane.WARNING_MESSAGE);
                    txtCpf.setBackground(Color.red);
                    txtCpf.grabFocus();
                    btnAlterar.setSelected(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, msg, "Preencha o(s) seguinte(s) campo(s) corretamente:", JOptionPane.WARNING_MESSAGE);
                btnAlterar.setSelected(true);
            }
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

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
        txtNome.grabFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void txtComplementoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComplementoKeyReleased
        txtComplemento.setText(txtComplemento.getText().toUpperCase());
    }//GEN-LAST:event_txtComplementoKeyReleased

    private void txtNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyReleased
        try {
            Careto = txtNumero.getCaretPosition();
            if (validar.isNumeric("" + evt.getKeyChar() + "") == false) {
                txtNumero.setText(txtNumero.getText().replaceAll("" + evt.getKeyChar() + "", ""));
            } else {
                txtNumero.setText(String.format("%.2f", Double.parseDouble(txtNumero.getText().replaceAll(",", "."))));

            }
            txtNumero.setCaretPosition(Careto);
        } catch (IllegalArgumentException e) {
        }
    }//GEN-LAST:event_txtNumeroKeyReleased

    private void txtNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusGained
        txtNome.setBackground(Color.white);
    }//GEN-LAST:event_txtNomeFocusGained

    private void txtRgFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRgFocusGained
        txtRg.setBackground(Color.white);
    }//GEN-LAST:event_txtRgFocusGained

    private void txtCpfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCpfFocusGained
        txtCpf.setBackground(Color.white);
    }//GEN-LAST:event_txtCpfFocusGained

    private void txtNascFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNascFocusGained
        txtNasc.setBackground(Color.white);
    }//GEN-LAST:event_txtNascFocusGained

    private void txtTelefoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefoneFocusGained
        txtTelefone.setBackground(Color.white);
    }//GEN-LAST:event_txtTelefoneFocusGained

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        txtEmail.setBackground(Color.white);
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtRuaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRuaFocusGained
        txtRua.setBackground(Color.white);
    }//GEN-LAST:event_txtRuaFocusGained

    private void txtNumeroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroFocusGained
        txtNumero.setBackground(Color.white);
    }//GEN-LAST:event_txtNumeroFocusGained

    private void txtBairroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBairroFocusGained
        txtBairro.setBackground(Color.white);
    }//GEN-LAST:event_txtBairroFocusGained

    private void txtCepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCepFocusGained
        txtCep.setBackground(Color.white);
    }//GEN-LAST:event_txtCepFocusGained

    private void txtCidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCidadeFocusGained
        txtCidade.setBackground(Color.white);
    }//GEN-LAST:event_txtCidadeFocusGained

    private void cmbPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPesquisaActionPerformed
    }//GEN-LAST:event_cmbPesquisaActionPerformed

    private void sincronizarTabela() {
        lblSelecionado.setText("" + (tabela.getSelectedRow() + 1));
        txtCod.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
        txtNome.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        txtRg.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
        txtCpf.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
        try {
            txtNasc.setDate(Comum.formataData(tabela.getValueAt(tabela.getSelectedRow(), 4).toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            txtEmail.setText(tabela.getValueAt(tabela.getSelectedRow(), 5).toString());
        } catch (NullPointerException e) {
            txtEmail.setText("");
        }
        txtRua.setText(tabela.getValueAt(tabela.getSelectedRow(), 6).toString());
        txtNumero.setText(tabela.getValueAt(tabela.getSelectedRow(), 7).toString());
        txtBairro.setText(tabela.getValueAt(tabela.getSelectedRow(), 8).toString());
        try {
            txtComplemento.setText(tabela.getValueAt(tabela.getSelectedRow(), 9).toString());
        } catch (NullPointerException e) {
            txtComplemento.setText("");
        }
        try {
            txtCep.setText(tabela.getValueAt(tabela.getSelectedRow(), 10).toString());
        } catch (NullPointerException e) {
            txtCep.setText("");
        }
        txtCidade.setText(tabela.getValueAt(tabela.getSelectedRow(), 11).toString());
        estado = tabela.getValueAt(tabela.getSelectedRow(), 12).toString();
        cmbEstado.setSelectedIndex(cmm.indexEstado(estado));
        try {
            cadcli.selecionarTelefones(txtCod.getText(), listaTelefone, listaTipo);
        } catch (NullPointerException e) {
            ((DefaultListModel) (lstTelefone.getModel())).clear();
            ((DefaultListModel) (lstTipo.getModel())).clear();
        }
        setHabilitaTudo(false);
        btnExcluir.setEnabled(true);
        btnAlterar.setEnabled(true);
        btnNovo.setEnabled(true);
        btnLimpar.setEnabled(false);
        btnInserir.setEnabled(false);
        btnCancelar.setEnabled(false);

    }//Fim sincronizarTabela      	

    //--------------- Atualizar Tabela ---------------------------------------------------
    private void atualizarTabela() {
        sql = "SELECT tbl_cliente.cod_cliente AS Código,tbl_cliente.nome AS Nome, tbl_cliente.rg AS RG," +
                "tbl_cliente.cpf AS CPF, tbl_cliente.datanasc AS Nascimento, tbl_cliente.email AS \"E-Mail\"," +
                "tbl_endereco_cliente.rua AS Logradouro," +
                "tbl_endereco_cliente.numero AS Número, tbl_endereco_cliente.bairro AS Bairro," +
                "tbl_endereco_cliente.complemento AS Complemento, tbl_endereco_cliente.cep AS CEP," +
                "tbl_endereco_cliente.cidade AS Cidade, tbl_endereco_cliente.estado AS Estado " +
                "FROM (tbl_endereco_cliente INNER JOIN tbl_cliente ON " +
                "tbl_endereco_cliente.cod_endereco = tbl_cliente.cod_endereco) ORDER BY tbl_cliente.nome";
        cmm.criarTabela(sql, tabela);
        lblTotal.setText("" + tabela.getRowCount());
    }//Fim atualizarTabela()

    private void pesquisarTabela(String campo) {
        sql = "SELECT tbl_cliente.cod_cliente AS Código,tbl_cliente.nome AS Nome, tbl_cliente.rg AS RG," +
                "tbl_cliente.cpf AS CPF, tbl_cliente.datanasc AS Nascimento, tbl_cliente.email AS \"E-Mail\"," +
                "tbl_endereco_cliente.rua AS Logradouro," +
                "tbl_endereco_cliente.numero AS Número, tbl_endereco_cliente.bairro AS Bairro," +
                "tbl_endereco_cliente.complemento AS Complemento, tbl_endereco_cliente.cep AS CEP," +
                "tbl_endereco_cliente.cidade AS Cidade, tbl_endereco_cliente.estado AS Estado " +
                "FROM (tbl_endereco_cliente INNER JOIN tbl_cliente ON " +
                "tbl_endereco_cliente.cod_endereco = tbl_cliente.cod_endereco) " +
                "WHERE " + campo + " ORDER BY tbl_cliente.nome";
        cmm.criarTabela(sql, tabela);
        lblTotal.setText("" + tabela.getRowCount());
    }//Fim pesquisarTabela()
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
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
    private javax.swing.JButton btnSubir;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbPesquisa;
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.ButtonGroup grpImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCod;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNasc;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRg;
    private javax.swing.JLabel lblRua;
    private javax.swing.JLabel lblSelecionado;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JList lstTelefone;
    private javax.swing.JList lstTipo;
    private javax.swing.JPanel painel;
    private javax.swing.JPanel painelEndereco;
    private javax.swing.JPanel painelPessoais;
    private javax.swing.JRadioButton rbImprimirTodos;
    private javax.swing.JRadioButton rbIndividualImprimir;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private com.toedter.calendar.JDateChooser txtNasc;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtNumero;
    private javax.swing.JFormattedTextField txtPesquisa;
    private javax.swing.JTextField txtRg;
    private javax.swing.JTextField txtRua;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
