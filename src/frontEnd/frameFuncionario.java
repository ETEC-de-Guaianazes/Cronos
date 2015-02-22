/*
 * frameFuncionario.java
 *
 * Created on 01/05/2010, 12:05:56
 */
package frontEnd;

import Banco.*;
import javax.swing.JOptionPane;
import Validacoes.Validacao;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class frameFuncionario extends javax.swing.JInternalFrame {

    private CadFuncionario cadfunc = new CadFuncionario();
    private String sql, msg, campo, telefonis, tipus, codEnd;
    private Validacao validar = new Validacao();
    private int progresso = 0, Careto = 0, adm = 0;
    private Conexao con = new Conexao();
    private DefaultListModel listaTelefone, listaTipo;
    private Comum cmm = new Comum();

    /** Creates new form frameFuncionario */
    public frameFuncionario() {
        initComponents();
    }

    // Metódo validador
    private int validaTudo() {
        msg = "";
        progresso = 0;
        if (validar.validaNome(txtNome.getText().replaceAll(" ", "")) == false) {
            msg += "Nome;\n";
            progresso++;
            txtNome.setBackground(Color.red);
        }
        if (txtRg.getText().replaceAll(" ", "").length() < 6) {
            msg += "RG;\n";
            progresso++;
            txtRg.setBackground(Color.red);
        }
        if (validar.valida_Cpf(txtCpf.getText()) == false) {
            msg += "CPF;\n";
            progresso++;
            txtCpf.setBackground(Color.red);
        }
        if (txtNasc.getDate().after(new Date()) && txtNasc.getDate().equals(new Date())) {
            msg = msg + "Data de nascimento;\n";
            progresso++;
            txtNasc.setBackground(Color.red);
        }
        if (lstTelefone.getModel().getSize() < 1) {
            msg += "Telefone;\n";
            progresso++;
            lstTelefone.setBackground(Color.red);
            lstTipo.setBackground(Color.red);
        }
        if (txtEmail.getText().replaceAll(" ", "").equals("") == false && txtEmail.getText().replaceAll(" ", "").length() > 0) {
            if (validar.validaEmail(txtEmail.getText()) == false) {
                msg += "E-mail;\n";
                progresso++;
                txtEmail.setBackground(Color.red);
            }
        }
        //Endereço
        if (txtRua.getText().length() < 3) {
            msg += "Logradouro;\n";
            progresso++;
            txtRua.setBackground(Color.red);
        }
        if (validar.validaNumero(txtNumero.getText()) == false) {
            msg += "Número;\n";
            progresso++;
            txtNumero.setBackground(Color.red);
        }
        if (validar.validaNome(txtBairro.getText().replaceAll(" ", "")) == false) {
            msg += "Bairro;\n";
            progresso++;
            txtBairro.setBackground(Color.red);
        }
        if (txtCep.getText().replaceAll("[_-]", "").replaceAll(" ", "").equals("") == false && txtCep.getText().replaceAll("[_-]", "").replaceAll(" ", "").length() > 0) {
            if (txtCep.getText().replaceAll("[_-]", "").replaceAll(" ", "").length() < 8) {
                msg += "CEP;\n";
                progresso++;
                txtCep.setBackground(Color.red);
            }
        }
        if (txtCidade.getText().replaceAll(" ", "").length() < 4) {
            msg += "Cidade;\n";
            progresso++;
            txtCidade.setBackground(Color.red);
        }
        if (txtLogin.getText().replaceAll(" ", "").length() < 5 || txtLogin.getText().replaceAll(" ", "").length()>10) {
            msg += "Login;\n";
            progresso++;
            txtLogin.setBackground(Color.red);
        }
        if (txtSenha1.getText().replaceAll(" ", "").equals(txtSenha2.getText().replaceAll(" ", "")) == false || txtSenha1.getText().replaceAll(" ", "").length() < 5 || txtSenha1.getText().replaceAll(" ", "").length()>10) {
            msg += "Senha;\n";
            progresso++;
            txtSenha2.setText("");
            txtSenha2.setBackground(Color.red);
        }
        return progresso;
    }//Fim validaTudo

    private void setHabilitaTudo(boolean verdade) {
        //Informações pessoais
        txtNome.setEnabled(verdade);
        txtCpf.setEnabled(verdade);
        txtRg.setEnabled(verdade);
        txtEmail.setEnabled(verdade);
        txtNasc.setEnabled(verdade);
        chkAdministrador.setEnabled(verdade);
        chkAtivo.setEnabled(verdade);
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
        txtLogin.setText("");
        txtSenha1.setText("");
        txtSenha2.setText("");
        chkAdministrador.setSelected(false);
        chkAtivo.setSelected(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpBtn = new javax.swing.ButtonGroup();
        painel = new javax.swing.JPanel();
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
        painelPessoais = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblCod = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        lblRg = new javax.swing.JLabel();
        txtRg = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        txtNome = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstTelefone = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstTipo = new javax.swing.JList();
        cmbTipo = new javax.swing.JComboBox();
        btnAdicionar = new javax.swing.JButton();
        btnSubir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNasc = new com.toedter.calendar.JDateChooser();
        chkAtivo = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        cmbPesquisa = new javax.swing.JComboBox();
        txtPesquisa = new javax.swing.JTextField();
        painelLogin = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSenha2 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txtSenha1 = new javax.swing.JPasswordField();
        btnNovo = new javax.swing.JButton();
        btnInserir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        chkAdministrador = new javax.swing.JCheckBox();
        btnAlterar = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        rbImprimirTodos = new javax.swing.JRadioButton();
        rbIndividualImprimir = new javax.swing.JRadioButton();
        btnImprimir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblSelecionado = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setTitle("FUNCIONÁRIO");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/funcionario_icone.png"))); // NOI18N
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
        painel.setPreferredSize(new java.awt.Dimension(800, 400));
        painel.setLayout(null);

        painelEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Endereço ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 0, 12))); // NOI18N
        painelEndereco.setLayout(null);

        lblRua.setFont(new java.awt.Font("sansserif", 1, 12));
        lblRua.setText("Logradouro: ");
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
        txtRua.setBounds(100, 30, 260, 23);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel1.setText("Nº:");
        painelEndereco.add(jLabel1);
        jLabel1.setBounds(20, 60, 30, 16);

        lblBairro.setFont(new java.awt.Font("sansserif", 1, 12));
        lblBairro.setText("Bairro:");
        painelEndereco.add(lblBairro);
        lblBairro.setBounds(150, 60, 50, 16);

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
        txtBairro.setBounds(200, 60, 160, 23);

        lblComplemento.setFont(new java.awt.Font("sansserif", 1, 12));
        lblComplemento.setText("Complemento:");
        painelEndereco.add(lblComplemento);
        lblComplemento.setBounds(20, 90, 100, 16);

        lblCep.setFont(new java.awt.Font("sansserif", 1, 12));
        lblCep.setText("CEP:");
        painelEndereco.add(lblCep);
        lblCep.setBounds(200, 90, 40, 16);

        lblEstado.setFont(new java.awt.Font("sansserif", 1, 12));
        lblEstado.setText("Estado:");
        painelEndereco.add(lblEstado);
        lblEstado.setBounds(20, 120, 50, 16);

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        painelEndereco.add(cmbEstado);
        cmbEstado.setBounds(70, 120, 100, 23);

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
        txtNumero.setBounds(50, 60, 80, 23);

        txtCep.setMinimumSize(new java.awt.Dimension(250, 20));
        txtCep.setPreferredSize(new java.awt.Dimension(150, 20));
        txtCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCepFocusGained(evt);
            }
        });
        painelEndereco.add(txtCep);
        txtCep.setBounds(230, 90, 130, 23);

        txtComplemento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtComplementoKeyReleased(evt);
            }
        });
        painelEndereco.add(txtComplemento);
        txtComplemento.setBounds(110, 90, 70, 23);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel2.setText("Cidade: ");
        painelEndereco.add(jLabel2);
        jLabel2.setBounds(180, 120, 50, 16);

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
        txtCidade.setBounds(230, 120, 130, 23);

        painel.add(painelEndereco);
        painelEndereco.setBounds(380, 0, 380, 170);

        painelPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Informações pessoais ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 0, 12))); // NOI18N
        painelPessoais.setOpaque(false);
        painelPessoais.setLayout(null);

        lblNome.setFont(new java.awt.Font("sansserif", 1, 12));
        lblNome.setText("Nome:");
        painelPessoais.add(lblNome);
        lblNome.setBounds(20, 50, 60, 16);

        lblCod.setFont(new java.awt.Font("sansserif", 1, 12));
        lblCod.setText("Código:");
        painelPessoais.add(lblCod);
        lblCod.setBounds(20, 20, 50, 16);

        txtCod.setText("<auto>");
        txtCod.setEnabled(false);
        painelPessoais.add(txtCod);
        txtCod.setBounds(80, 20, 50, 23);

        lblRg.setFont(new java.awt.Font("sansserif", 1, 12));
        lblRg.setText("RG:");
        painelPessoais.add(lblRg);
        lblRg.setBounds(40, 80, 40, 16);

        txtRg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRgFocusGained(evt);
            }
        });
        painelPessoais.add(txtRg);
        txtRg.setBounds(80, 80, 170, 23);

        lblCpf.setFont(new java.awt.Font("sansserif", 1, 12));
        lblCpf.setText("CPF:");
        painelPessoais.add(lblCpf);
        lblCpf.setBounds(30, 110, 50, 16);

        txtCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCpfFocusGained(evt);
            }
        });
        painelPessoais.add(txtCpf);
        txtCpf.setBounds(80, 110, 170, 23);

        txtNome.setColumns(10);
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
        txtNome.setBounds(80, 50, 270, 23);
        painelPessoais.add(txtTelefone);
        txtTelefone.setBounds(80, 170, 130, 23);

        lstTelefone.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
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
        jScrollPane2.setBounds(80, 190, 130, 50);

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
        jScrollPane3.setBounds(210, 190, 100, 50);

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Residencial", "Comercial", "Celular" }));
        cmbTipo.setPreferredSize(new java.awt.Dimension(63, 20));
        painelPessoais.add(cmbTipo);
        cmbTipo.setBounds(210, 170, 100, 23);

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/tel_add.png"))); // NOI18N
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        painelPessoais.add(btnAdicionar);
        btnAdicionar.setBounds(310, 170, 30, 23);

        btnSubir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/tel_subir.png"))); // NOI18N
        btnSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirActionPerformed(evt);
            }
        });
        painelPessoais.add(btnSubir);
        btnSubir.setBounds(310, 200, 30, 23);

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel6.setText("Telefone: ");
        painelPessoais.add(jLabel6);
        jLabel6.setBounds(20, 170, 60, 16);

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel7.setText("E-mail:");
        painelPessoais.add(jLabel7);
        jLabel7.setBounds(30, 240, 38, 16);

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
        txtEmail.setBounds(80, 240, 130, 23);

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel8.setText("Dt. nascimento:");
        painelPessoais.add(jLabel8);
        jLabel8.setBounds(10, 140, 90, 16);

        txtNasc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNascFocusGained(evt);
            }
        });
        painelPessoais.add(txtNasc);
        txtNasc.setBounds(110, 140, 140, 23);

        chkAtivo.setText("Ativo");
        painelPessoais.add(chkAtivo);
        chkAtivo.setBounds(200, 20, 70, 20);

        painel.add(painelPessoais);
        painelPessoais.setBounds(0, 0, 380, 280);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "  Pesquisa ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 0, 12))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        cmbPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código", "Nome", "RG", "CPF", "Telefone", "CEP", "Estado", "Login" }));
        jPanel2.add(cmbPesquisa);
        cmbPesquisa.setBounds(10, 20, 120, 23);

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });
        jPanel2.add(txtPesquisa);
        txtPesquisa.setBounds(130, 20, 250, 23);

        painel.add(jPanel2);
        jPanel2.setBounds(370, 330, 390, 60);

        painelLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 0, 12))); // NOI18N
        painelLogin.setOpaque(false);
        painelLogin.setLayout(null);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel3.setText("Login:");
        painelLogin.add(jLabel3);
        jLabel3.setBounds(30, 20, 40, 16);

        txtLogin.setColumns(8);
        txtLogin.setToolTipText("No min. 5 e no máx. 10");
        txtLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLoginFocusGained(evt);
            }
        });
        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLoginKeyReleased(evt);
            }
        });
        painelLogin.add(txtLogin);
        txtLogin.setBounds(70, 20, 100, 23);

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel4.setText("Confirme a senha:");
        painelLogin.add(jLabel4);
        jLabel4.setBounds(370, 20, 110, 20);

        txtSenha2.setToolTipText("Re-digite sua senha");
        txtSenha2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSenha2KeyReleased(evt);
            }
        });
        painelLogin.add(txtSenha2);
        txtSenha2.setBounds(480, 20, 109, 23);

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel5.setText("Senha:");
        painelLogin.add(jLabel5);
        jLabel5.setBounds(180, 20, 40, 16);

        txtSenha1.setToolTipText("No min. 5 e no máx. 10");
        txtSenha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenha1ActionPerformed(evt);
            }
        });
        txtSenha1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSenha1KeyReleased(evt);
            }
        });
        painelLogin.add(txtSenha1);
        txtSenha1.setBounds(230, 20, 109, 23);

        painel.add(painelLogin);
        painelLogin.setBounds(0, 275, 600, 50);

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
        btnNovo.setBounds(410, 170, 90, 50);

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
        btnInserir.setBounds(510, 170, 90, 50);

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
        btnCancelar.setBounds(610, 230, 90, 50);

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
        btnLimpar.setBounds(510, 230, 90, 50);

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
        btnExcluir.setBounds(410, 230, 90, 50);

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

        painel.add(jPanel4);
        jPanel4.setBounds(0, 320, 320, 70);

        chkAdministrador.setFont(new java.awt.Font("sansserif", 1, 12));
        chkAdministrador.setText("Administrador");
        painel.add(chkAdministrador);
        chkAdministrador.setBounds(610, 290, 110, 18);

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
        btnAlterar.setBounds(610, 170, 90, 50);

        getContentPane().add(painel, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(453, 200));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Funcionários"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabela.setMaximumSize(new java.awt.Dimension(453, 201));
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

        jPanel3.setMaximumSize(new java.awt.Dimension(10, 41));
        jPanel3.setMinimumSize(new java.awt.Dimension(10, 40));
        jPanel3.setPreferredSize(new java.awt.Dimension(10, 40));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        grpBtn.add(rbImprimirTodos);
        rbImprimirTodos.setFont(new java.awt.Font("sansserif", 1, 12));
        rbImprimirTodos.setSelected(true);
        rbImprimirTodos.setText("Todos");
        jPanel3.add(rbImprimirTodos);

        grpBtn.add(rbIndividualImprimir);
        rbIndividualImprimir.setFont(new java.awt.Font("sansserif", 1, 12));
        rbIndividualImprimir.setText("Individual");
        jPanel3.add(rbIndividualImprimir);

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/imprimir_icone.png"))); // NOI18N
        btnImprimir.setMnemonic('p');
        btnImprimir.setText("Imprimir");
        btnImprimir.setPreferredSize(new java.awt.Dimension(110, 40));
        jPanel3.add(btnImprimir);

        jLabel9.setText("Selecionado:");
        jPanel3.add(jLabel9);

        lblSelecionado.setFont(new java.awt.Font("Dialog", 0, 12));
        jPanel3.add(lblSelecionado);

        jLabel10.setText("Total:");
        jPanel3.add(jLabel10);

        lblTotal.setFont(new java.awt.Font("Dialog", 0, 12));
        jPanel3.add(lblTotal);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        Limpar();
        chkAtivo.setVisible(false);
        txtNome.grabFocus();
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnNovo.setEnabled(false);
        btnLimpar.setEnabled(true);
        btnInserir.setEnabled(true);
        btnCancelar.setEnabled(true);
        painelLogin.setVisible(true);
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

    //--------------- Atualizar Tabela ---------------------------------------------------
    private void atualizarTabela() {
        sql = "SELECT tbl_funcionario.cod_funcionario AS \"Código\", tbl_funcionario.nome_funcionario AS Nome, tbl_funcionario.cpf AS CPF," +
                "tbl_funcionario.rg AS RG, tbl_funcionario.dtNasc AS Nascimento, tbl_funcionario.administrador AS ADM, tbl_funcionario.dt_cadastro AS \"Cadastrado em\"," +
                "tbl_funcionario.ativo AS Ativo, tbl_endereco_funcionario.rua AS Rua, tbl_endereco_funcionario.numero AS Número," +
                "tbl_endereco_funcionario.bairro AS Bairro, tbl_endereco_funcionario.complemento AS Complemento, tbl_endereco_funcionario.cep AS CEP,tbl_endereco_funcionario.cidade AS Cidade, " +
                "tbl_endereco_funcionario.estado AS Estado, tbl_funcionario.email AS \"E-mail\" FROM tbl_endereco_funcionario INNER JOIN tbl_funcionario ON tbl_endereco_funcionario.cod_endereco = tbl_funcionario.cod_endereco";
        cmm.criarTabelaFuncionario(sql, tabela);
        lblTotal.setText(""+tabela.getRowCount());        
    }

    private void pesquisarTabela(String campo) {
        sql = "SELECT tbl_funcionario.cod_funcionario AS \"Código\", tbl_funcionario.nome_funcionario AS Nome, tbl_funcionario.cpf AS CPF," +
                "tbl_funcionario.rg AS RG, tbl_funcionario.dtNasc AS Nascimento, tbl_funcionario.administrador AS ADM, tbl_funcionario.dt_cadastro AS \"Cadastrado em\"," +
                "tbl_funcionario.ativo AS Ativo, tbl_endereco_funcionario.rua AS Rua, tbl_endereco_funcionario.numero AS Número," +
                "tbl_endereco_funcionario.bairro AS Bairro, tbl_endereco_funcionario.complemento AS Complemento, tbl_endereco_funcionario.cep AS CEP,tbl_endereco_funcionario.cidade AS Cidade, " +
                "tbl_endereco_funcionario.estado AS Estado, tbl_funcionario.email AS \"E-mail\" FROM tbl_endereco_funcionario INNER JOIN tbl_funcionario ON tbl_endereco_funcionario.cod_endereco = tbl_funcionario.cod_endereco WHERE " + campo;
        cmm.criarTabelaFuncionario(sql, tabela);
        lblTotal.setText(""+tabela.getRowCount());
    }

    private void Habilitar() {
        btnAlterar.setEnabled(true);
        btnExcluir.setEnabled(true);
        txtNome.setEditable(true);
        txtRg.setEditable(true);
        txtCpf.setEditable(true);
        txtRua.setEditable(true);
        txtNumero.setEditable(true);
        txtBairro.setEditable(true);
        txtComplemento.setEditable(true);
        txtCep.setEditable(true);
        txtCidade.setEditable(true);
        txtTelefone.setEditable(true);
        txtLogin.setEditable(true);
        txtSenha1.setEditable(true);
        txtSenha2.setEditable(true);
        txtPesquisa.setEditable(true);
        cmbPesquisa.setEnabled(true);
        cmbEstado.setEnabled(true);
        //btnTel.setEnabled(true);
        btnInserir.setEnabled(false);
        btnLimpar.setEnabled(false);
    }

    @SuppressWarnings("static-access")
    private void sincronizarTabela() {
        lblSelecionado.setText(""+(tabela.getSelectedRow()+1));
        txtCod.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
        txtNome.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        txtCpf.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
        txtRg.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
        try {
            txtNasc.setDate(cmm.formataData(tabela.getValueAt(tabela.getSelectedRow(), 4).toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        chkAdministrador.setSelected(false);
        if (tabela.getValueAt(tabela.getSelectedRow(), 5).toString().equals("1") == true) {
            chkAdministrador.setSelected(true);
        }
        chkAtivo.setSelected(false);
        if (tabela.getValueAt(tabela.getSelectedRow(), 7).toString().equals("1") == true) {
            chkAtivo.setSelected(true);
        }
        txtRua.setText(tabela.getValueAt(tabela.getSelectedRow(), 8).toString());
        txtNumero.setText(tabela.getValueAt(tabela.getSelectedRow(), 9).toString());
        txtBairro.setText(tabela.getValueAt(tabela.getSelectedRow(), 10).toString());
        try{
        txtComplemento.setText(tabela.getValueAt(tabela.getSelectedRow(), 11).toString());
        }catch(NullPointerException e){txtComplemento.setText("");}
        try{
        txtCep.setText(tabela.getValueAt(tabela.getSelectedRow(), 12).toString());
        }catch(NullPointerException e){txtCep.setText("");}
        txtCidade.setText(tabela.getValueAt(tabela.getSelectedRow(), 13).toString());
        cmbEstado.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 14).toString());
        cadfunc.selecionarTelefones(txtCod.getText(), listaTelefone, listaTipo);
        chkAtivo.setVisible(true);
        try{
        txtEmail.setText(tabela.getValueAt(tabela.getSelectedRow(), 15).toString());
        }catch(NullPointerException e){txtEmail.setText("");}
        con.Conecta();
        txtLogin.setText(cadfunc.pegaLogin(txtCod.getText()));
        txtSenha1.setText(cadfunc.pegaSenha(txtCod.getText()));
        txtSenha2.setText(txtSenha1.getText());
        con.Fecha();

    }

    private void cancelar() {
        Limpar();
        setHabilitaTudo(false);
        btnCancelar.setEnabled(false);
        btnInserir.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnAlterar.setSelected(false);
        btnExcluir.setEnabled(false);
        btnLimpar.setEnabled(false);
        btnNovo.setEnabled(true);
        tabela.clearSelection();
        lblTotal.setText("0");
        tabela.setEnabled(true);
        btnPrimeiro.setEnabled(true);
        btnProximo.setEnabled(true);
        btnAnterior.setEnabled(true);
        btnUltimo.setEnabled(true);
        txtPesquisa.setEnabled(true);
        painelLogin.setVisible(false);
    }

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        if (validaTudo() == 0) {
            pesquisarTabela("tbl_funcionario.cpf LIKE'" + txtCpf.getText() + "'");
            if (tabela.getRowCount() < 1) {
                try {
                    con.Conecta();
                    cadfunc = new CadFuncionario();
                    progresso = 0;
                    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String sData = sdf.format(new Date());
                    sql = "INSERT INTO tbl_endereco_funcionario(RUA,NUMERO,BAIRRO,COMPLEMENTO,CEP,CIDADE,ESTADO)VALUES('" + txtRua.getText() +
                            "'," + txtNumero.getText() + ",'" + txtBairro.getText() + "','" + txtComplemento.getText() + "','" + txtCep.getText() + "','" + txtCidade.getText() +
                            "','" + cmbEstado.getSelectedItem().toString() + "')";
                    progresso += cadfunc.CadastraEndereco(sql);
                    String codigoEndereco = cadfunc.pegaCodigoEndereco();
                    sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String sDtCadastro = sdf.format(txtNasc.getDate());//formata a data em um String seguindo a máscara.
                    adm = 0;
                    if (chkAdministrador.isSelected() == true) {
                        adm = 1;
                    }
                    //Passagem de instrução pra metodo Cadastra(String sql)
                    sql = "INSERT INTO tbl_funcionario(NOME_FUNCIONARIO,CPF,RG,COD_ENDERECO,LOGIN,SENHA,ADMINISTRADOR,EMAIL,DTNASC,DT_cadastro,ativo)VALUES('" + txtNome.getText() +
                            "','" + txtCpf.getText() + "','" + txtRg.getText() + "'," + codigoEndereco +
                            ",'" + txtLogin.getText() + "','" + txtSenha1.getText() + "'," + adm + ",'" + txtEmail.getText() + "','" + sData + "','" + sDtCadastro + "',1)";
                    progresso += cadfunc.cadastraFuncionario(sql);
                    String codigoFuncionario = cadfunc.pegaCodigoFuncionario();
                    for (int i = 0; i < listaTelefone.size(); i++) {
                        telefonis = (String) listaTelefone.get(i);
                        tipus = (String) listaTipo.get(i);
                        progresso += cadfunc.cadastraTelefone(codigoFuncionario, telefonis, tipus);
                    }
                    if (progresso == 0) {
                        JOptionPane.showMessageDialog(this, "Funcionário inserido com sucesso!", "Operação bem-sucedida!", JOptionPane.INFORMATION_MESSAGE);
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
                JOptionPane.showMessageDialog(this, "Um funcionário já foi cadastrado com este CPF.", "Atenção!", JOptionPane.WARNING_MESSAGE);
                txtCpf.setBackground(Color.red);
                txtCpf.grabFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, msg, "Preencha o(s) seguinte(s) corretamente:", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        Limpar();
}//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        con.Conecta();
        if (cadfunc.possuiVendas(txtCod.getText()) == false && cadfunc.possuiCaixa(txtCod.getText()) == false && cadfunc.possuiCompras(txtCod.getText()) == false && cadfunc.possuiSaida(txtCod.getText()) == false) {
            if (JOptionPane.showConfirmDialog(this, "Deseja realmente excluir este funcionario?\n" +
                    "*Esta operação não poderá ser desfeita\n" +
                    "caso seja executada.", "Atenção!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                try {
                    progresso = 0;
                    String cod = cadfunc.getCodigoEndereco(txtCod.getText());
                    progresso += cadfunc.excluirTelefone(txtCod.getText());
                    progresso += cadfunc.excluirFuncionario(txtCod.getText());
                    progresso += cadfunc.excluirEndereco(cod);
                    if (progresso == 0) {
                        JOptionPane.showMessageDialog(this, "Sucesso ao excluir funcionário.", "Removido com sucesso", JOptionPane.INFORMATION_MESSAGE);
                        con.Fecha();
                    } else {
                        JOptionPane.showMessageDialog(this, progresso + " erro(s) encontrados durante a operação.", "Erro!", JOptionPane.ERROR_MESSAGE);

                    }
                    con.Fecha();
                    cancelar();
                    atualizarTabela();
                } catch (Error er) {
                    JOptionPane.showMessageDialog(this, "Não foi possível a exclusão.\n" + er, "Erro!", JOptionPane.ERROR_MESSAGE);
                    er.printStackTrace();
                    con.Fecha();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Este funcionário possui dados cadastrados que dependem do seu nome.\n" +
                    "Você pode desativa-lo, removendo a seleção em \"Ativo\"", "Este funcionário não pode ser removido!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        Habilitar();
        sincronizarTabela();
    }//GEN-LAST:event_tabelaMouseClicked

    private void tabelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyReleased
        if ((evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
            Habilitar();
            sincronizarTabela();
        }
}//GEN-LAST:event_tabelaKeyReleased

    private void lstTelefoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstTelefoneMouseClicked
        lstTipo.setSelectedIndex(lstTelefone.getSelectedIndex());
}//GEN-LAST:event_lstTelefoneMouseClicked

    private void lstTelefoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lstTelefoneKeyReleased
        if ((evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
            lstTipo.setSelectedIndex(lstTelefone.getSelectedIndex());
        }
}//GEN-LAST:event_lstTelefoneKeyReleased

    private void lstTipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstTipoMouseClicked
        lstTelefone.setSelectedIndex(lstTipo.getSelectedIndex());
}//GEN-LAST:event_lstTipoMouseClicked

    private void lstTipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lstTipoKeyReleased
        if ((evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
            lstTelefone.setSelectedIndex(lstTipo.getSelectedIndex());
        }
}//GEN-LAST:event_lstTipoKeyReleased

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

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

        cmm.setFormataNumero("(##)####-####", txtTelefone, "0123456789", ' ');
        cmm.setFormataNumero("#####-###", txtCep, "0123456789", ' ');
        cmm.setFormataNumero("###.###.###-##", txtCpf, "0123456789", ' ');
        listaTelefone = new DefaultListModel();
        lstTelefone.setModel(listaTelefone);
        listaTipo = new DefaultListModel();
        lstTipo.setModel(listaTipo);        
        cancelar();
        atualizarTabela();
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            Careto = txtNome.getCaretPosition();
            cmm.getParaMaiuscula(txtNome);
            txtNome.setCaretPosition(Careto);
            pesquisarTabela("tbl_funcionario.nome_funcionario LIKE '" + txtNome.getText() + "%'");

        }
    }//GEN-LAST:event_txtNomeKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            Careto = txtEmail.getCaretPosition();
            cmm.getParaMinuscula(txtEmail);
            txtEmail.setCaretPosition(Careto);
        }
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_UP) && (evt.getKeyCode() != KeyEvent.VK_DOWN) && (evt.getKeyCode() != KeyEvent.VK_RIGHT) && (evt.getKeyCode() != KeyEvent.VK_LEFT)) {
            cmm.getParaMaiuscula(txtLogin);
        }
    }//GEN-LAST:event_txtLoginKeyReleased

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
        txtComplemento.setText(txtComplemento.getText().toUpperCase());
    }//GEN-LAST:event_txtComplementoKeyReleased

    private void txtCidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCidadeKeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            Careto = txtCidade.getCaretPosition();
            cmm.getParaMaiuscula(txtCidade);
            txtCidade.setCaretPosition(Careto);
        }
    }//GEN-LAST:event_txtCidadeKeyReleased

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        //TODO pesquisa em tempo real #funcionario
    }//GEN-LAST:event_txtPesquisaKeyReleased

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

    private void txtNascFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNascFocusGained
        txtNasc.setBackground(Color.white);
    }//GEN-LAST:event_txtNascFocusGained

    private void txtNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusGained
        txtNome.setBackground(Color.white);
    }//GEN-LAST:event_txtNomeFocusGained

    private void txtRgFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRgFocusGained
        txtRg.setBackground(Color.white);
    }//GEN-LAST:event_txtRgFocusGained

    private void txtCpfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCpfFocusGained
        txtCpf.setBackground(Color.white);
    }//GEN-LAST:event_txtCpfFocusGained

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        txtEmail.setBackground(Color.white);
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoginFocusGained
        txtLogin.setBackground(Color.white);
    }//GEN-LAST:event_txtLoginFocusGained

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

    private void txtNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyReleased
        try {
            if (validar.isNumeric("" + evt.getKeyChar() + "") == false && (evt.getKeyCode() != KeyEvent.VK_UP) && (evt.getKeyCode() != KeyEvent.VK_DOWN) && (evt.getKeyCode() != KeyEvent.VK_LEFT) && (evt.getKeyCode() != KeyEvent.VK_RIGHT)) {
                Careto = txtNumero.getCaretPosition();
                txtNumero.setText(txtNumero.getText().replaceAll("" + evt.getKeyChar() + "", ""));
                txtNumero.setCaretPosition(Careto);
            }
        } catch (IllegalArgumentException e) {
        }
    }//GEN-LAST:event_txtNumeroKeyReleased

    private void txtSenha1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenha1KeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            Careto = txtSenha1.getCaretPosition();
            cmm.getParaMaiuscula(txtSenha1);
            txtSenha1.setCaretPosition(Careto);
        }
    }//GEN-LAST:event_txtSenha1KeyReleased

    private void txtSenha2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenha2KeyReleased
        if ((evt.getKeyCode() != KeyEvent.VK_HOME) && (evt.getKeyCode() != KeyEvent.VK_END)) {
            Careto = txtSenha2.getCaretPosition();
            cmm.getParaMaiuscula(txtSenha2);
            txtSenha2.setCaretPosition(Careto);
        }
    }//GEN-LAST:event_txtSenha2KeyReleased

    private void txtSenha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenha1ActionPerformed
    }//GEN-LAST:event_txtSenha1ActionPerformed

    private void AlterarFuncionario() {
        try {
            con.Conecta();
            progresso = 0;
            cadfunc = new CadFuncionario();
            codEnd = cadfunc.getCodigoEndereco(txtCod.getText());
            sql = "UPDATE tbl_endereco_funcionario SET RUA='" + txtRua.getText() + "', NUMERO=" + txtNumero.getText() + "," +
                    "BAIRRO='" + txtBairro.getText() + "', COMPLEMENTO='" + txtComplemento.getText() + "'," +
                    "CEP='" + txtCep.getText() + "', CIDADE='" + txtCidade.getText() + "'," +
                    "ESTADO='" + cmbEstado.getSelectedItem().toString() + "' " +
                    "WHERE COD_ENDERECO=" + codEnd;
            progresso += cadfunc.alteraEndereco(sql);

            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            String sData = fmt.format(txtNasc.getDate());//formata a data em um String seguindo a máscara.

            if (chkAtivo.isSelected() == true) {
                adm = 1;
            } else {
                adm = 0;
            }
            sql = "UPDATE tbl_funcionario SET NOME_FUNCIONARIO='" + txtNome.getText() + "'," +
                    "CPF='" + txtCpf.getText() + "', RG='" + txtRg.getText() + "'," +
                    "ADMINISTRADOR=" + adm + ", EMAIL='" + txtEmail.getText() + "', " +
                    "LOGIN='" + txtLogin.getText() + "'," +
                    "SENHA='" + txtSenha1.getText() + "'," +
                    "DTNASC='" + sData + "', ATIVO=" + adm +
                    " WHERE COD_FUNCIONARIO=" + txtCod.getText();
            progresso += cadfunc.alteraFuncionario(sql);
            cadfunc.excluirTelefone(txtCod.getText());
            String codFunc = txtCod.getText();
            for (int i = 0; i < listaTelefone.size(); i++) {
                telefonis = (String) listaTelefone.get(i);
                tipus = (String) listaTipo.get(i);
                progresso += cadfunc.cadastraTelefone(codFunc, telefonis, tipus);
            }
            if (progresso == 0) {
                JOptionPane.showMessageDialog(this, "Funcionário atualizado com sucesso.", "Sucesso ao atualizar", JOptionPane.INFORMATION_MESSAGE);
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
            painelLogin.setVisible(true);
        } else {
            if (validaTudo() == 0) {
                pesquisarTabela("tbl_funcionario.cpf LIKE '" + txtCpf.getText() + "'");
                if (tabela.getRowCount() < 1) {
                    AlterarFuncionario();
                } else if (txtCod.getText().replaceAll(" ", "").equals(tabela.getValueAt(0, 0).toString().replaceAll(" ", "")) == true) {
                    AlterarFuncionario();
                } else {
                    JOptionPane.showMessageDialog(this, "Um funcionário já foi cadastrado com este CPF.", "Atenção!", JOptionPane.WARNING_MESSAGE);
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
    private javax.swing.JCheckBox chkAdministrador;
    private javax.swing.JCheckBox chkAtivo;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbPesquisa;
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.ButtonGroup grpBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCod;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRg;
    private javax.swing.JLabel lblRua;
    private javax.swing.JLabel lblSelecionado;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JList lstTelefone;
    private javax.swing.JList lstTipo;
    private javax.swing.JPanel painel;
    private javax.swing.JPanel painelEndereco;
    private javax.swing.JPanel painelLogin;
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
    private javax.swing.JTextField txtLogin;
    private com.toedter.calendar.JDateChooser txtNasc;
    private javax.swing.JFormattedTextField txtNome;
    private javax.swing.JFormattedTextField txtNumero;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtRg;
    private javax.swing.JTextField txtRua;
    private javax.swing.JPasswordField txtSenha1;
    private javax.swing.JPasswordField txtSenha2;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
