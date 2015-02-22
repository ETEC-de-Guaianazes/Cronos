/*
 * Tela principal, contendo menus e abas-guias
 *
 * Created on 03/04/2010, 14:01:25
 */
package frontEnd;

import Banco.Conexao;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import Banco.sessao;
import javax.swing.ImageIcon;

public class telaPrincipal extends javax.swing.JFrame implements Runnable {

    // Privates: Formulários usados por esta classe
    private SimpleDateFormat sdf;
    public sessao Sessao = new sessao();
    private Conexao con = new Conexao();

    /** Creates new form telaPrincipal */
    public telaPrincipal() {
        initComponents();
        new Thread(this).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusBar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        painelAbas = new javax.swing.JTabbedPane();
        abaInicio = new javax.swing.JLayeredPane();
        lbldesenhoCliente1 = new javax.swing.JLabel();
        btnInicioVenda = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        abaVenda = new javax.swing.JDesktopPane();
        lbldesenhoVenda = new javax.swing.JLabel();
        abaCompra = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        lbldesenhoCompra = new javax.swing.JLabel();
        abaCliente = new javax.swing.JDesktopPane();
        lbldesenhoCliente = new javax.swing.JLabel();
        abaProduto = new javax.swing.JDesktopPane();
        lbldesenhoProduto = new javax.swing.JLabel();
        abaServico = new javax.swing.JDesktopPane();
        lbldesenhoServico = new javax.swing.JLabel();
        abaFornecedor = new javax.swing.JDesktopPane();
        lbldesenhoFornecedor = new javax.swing.JLabel();
        abaCategoria = new javax.swing.JDesktopPane();
        lbldesenhoCategoria = new javax.swing.JLabel();
        abaFabricante = new javax.swing.JDesktopPane();
        lbldesenhoFabricante = new javax.swing.JLabel();
        abaRelatorio = new javax.swing.JPanel();
        lblRelatorio = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menuAlpha = new javax.swing.JMenu();
        jSeparator3 = new javax.swing.JSeparator();
        ItemCaixa = new javax.swing.JMenuItem();
        itemLogout = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        itemSair = new javax.swing.JMenuItem();
        menuAdministrador = new javax.swing.JMenu();
        itemAdmCadFuncionario = new javax.swing.JMenuItem();
        menuAdmManutencao = new javax.swing.JMenu();
        itemBackup = new javax.swing.JMenuItem();
        itemRestaurar = new javax.swing.JMenuItem();
        menuOpcoes = new javax.swing.JMenu();
        menuAjuda = new javax.swing.JMenu();
        itemIndice = new javax.swing.JMenuItem();
        itemManual = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        menuSobre = new javax.swing.JMenu();
        itemAlphablend = new javax.swing.JMenuItem();
        itemCronos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cronos 1.0");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(Toolkit.getDefaultToolkit().getImage("/Imagens/hora_icone.png"));
        setLocationByPlatform(true);
        setResizable(false);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.BorderLayout(5, 3));

        statusBar.setForeground(javax.swing.UIManager.getDefaults().getColor("Menu.background"));
        statusBar.setMaximumSize(new java.awt.Dimension(400, 25));
        statusBar.setMinimumSize(new java.awt.Dimension(400, 25));
        statusBar.setPreferredSize(new java.awt.Dimension(400, 25));
        statusBar.setRequestFocusEnabled(false);
        statusBar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 3, 0));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel2.setText("Usuário:");
        statusBar.add(jLabel2);

        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/usuario_icone.png"))); // NOI18N
        lblUsuario.setText("    ");
        lblUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        statusBar.add(lblUsuario);

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator7.setPreferredSize(new java.awt.Dimension(3, 22));
        statusBar.add(jSeparator7);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/hora_icone.png"))); // NOI18N
        jLabel3.setText("Hora:");
        statusBar.add(jLabel3);

        lblHora.setText("hora     ");
        lblHora.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblHora.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        statusBar.add(lblHora);

        getContentPane().add(statusBar, java.awt.BorderLayout.SOUTH);

        painelAbas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painelAbas.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        painelAbas.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        painelAbas.setAutoscrolls(true);
        painelAbas.setFont(new java.awt.Font("sansserif", 1, 12));
        painelAbas.setPreferredSize(new java.awt.Dimension(250, 100));
        painelAbas.setVerifyInputWhenFocusTarget(false);

        abaInicio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " INÍCIO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 36))); // NOI18N
        abaInicio.setPreferredSize(new java.awt.Dimension(0, 100));

        lbldesenhoCliente1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldesenhoCliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/principal cronos.png"))); // NOI18N
        lbldesenhoCliente1.setBounds(200, 160, 410, 310);
        abaInicio.add(lbldesenhoCliente1, javax.swing.JLayeredPane.PALETTE_LAYER);

        btnInicioVenda.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnInicioVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Venda.png"))); // NOI18N
        btnInicioVenda.setText("VENDA");
        btnInicioVenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInicioVenda.setPreferredSize(new java.awt.Dimension(142, 83));
        btnInicioVenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInicioVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInicioVendaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInicioVendaMouseExited(evt);
            }
        });
        btnInicioVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioVendaActionPerformed(evt);
            }
        });
        btnInicioVenda.setBounds(50, 70, 142, 110);
        abaInicio.add(btnInicioVenda, javax.swing.JLayeredPane.DRAG_LAYER);

        jButton2.setFont(new java.awt.Font("sansserif", 1, 14));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/produto_aba.png"))); // NOI18N
        jButton2.setText("NOVO PRODUTO");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(20, 280, 148, 100);
        abaInicio.add(jButton2, javax.swing.JLayeredPane.DRAG_LAYER);

        jButton3.setFont(new java.awt.Font("sansserif", 1, 14));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/estoque_icone.png"))); // NOI18N
        jButton3.setAutoscrolls(true);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setLabel("ESTOQUE");
        jButton3.setPreferredSize(new java.awt.Dimension(142, 83));
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.setBounds(120, 490, 142, 100);
        abaInicio.add(jButton3, javax.swing.JLayeredPane.MODAL_LAYER);

        painelAbas.addTab("", new javax.swing.ImageIcon(getClass().getResource("/Imagens/inicio_aba.png")), abaInicio, "INÍCIO"); // NOI18N
        abaInicio.getAccessibleContext().setAccessibleName("");

        abaVenda.setOpaque(false);
        abaVenda.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                abaVendaComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                abaVendaComponentShown(evt);
            }
        });

        lbldesenhoVenda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldesenhoVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Venda_fundo.png"))); // NOI18N
        lbldesenhoVenda.setBounds(0, 0, 640, 640);
        abaVenda.add(lbldesenhoVenda, javax.swing.JLayeredPane.DEFAULT_LAYER);

        painelAbas.addTab("", new javax.swing.ImageIcon(getClass().getResource("/Imagens/venda_aba.png")), abaVenda, "EFETUE UMA VENDA OU SALVE UM ORÇAMENTO"); // NOI18N

        abaCompra.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                abaCompraComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                abaCompraComponentShown(evt);
            }
        });
        jLabel1.setBounds(110, 210, -1, -1);
        abaCompra.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbldesenhoCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Compras.png"))); // NOI18N
        lbldesenhoCompra.setBounds(0, 0, 610, 640);
        abaCompra.add(lbldesenhoCompra, javax.swing.JLayeredPane.DEFAULT_LAYER);

        painelAbas.addTab("", new javax.swing.ImageIcon(getClass().getResource("/Imagens/compra_aba.png")), abaCompra, "EFETUE UMA COMPRA"); // NOI18N

        abaCliente.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                abaClienteComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                abaClienteComponentShown(evt);
            }
        });

        lbldesenhoCliente.setBackground(new java.awt.Color(255, 255, 255));
        lbldesenhoCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldesenhoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Cliente.png"))); // NOI18N
        lbldesenhoCliente.setBounds(0, 0, 640, 640);
        abaCliente.add(lbldesenhoCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        painelAbas.addTab("", new javax.swing.ImageIcon(getClass().getResource("/Imagens/cliente_aba.png")), abaCliente, "CONTROLE DE CLIENTES"); // NOI18N

        abaProduto.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                abaProdutoComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                abaProdutoComponentShown(evt);
            }
        });

        lbldesenhoProduto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldesenhoProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Produtos.png"))); // NOI18N
        lbldesenhoProduto.setBounds(0, 0, 640, 640);
        abaProduto.add(lbldesenhoProduto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        painelAbas.addTab("", new javax.swing.ImageIcon(getClass().getResource("/Imagens/produto_aba.png")), abaProduto, "CONTROLE DE PRODUTOS"); // NOI18N

        abaServico.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                abaServicoComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                abaServicoComponentShown(evt);
            }
        });

        lbldesenhoServico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldesenhoServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Servicos.png"))); // NOI18N
        lbldesenhoServico.setBounds(0, 0, 640, 640);
        abaServico.add(lbldesenhoServico, javax.swing.JLayeredPane.DEFAULT_LAYER);

        painelAbas.addTab("", new javax.swing.ImageIcon(getClass().getResource("/Imagens/servico_aba.png")), abaServico, "CONTROLE DE SERVIÇOS"); // NOI18N

        abaFornecedor.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                abaFornecedorComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                abaFornecedorComponentShown(evt);
            }
        });

        lbldesenhoFornecedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldesenhoFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Fornecedor.png"))); // NOI18N
        lbldesenhoFornecedor.setBounds(0, 0, 640, 640);
        abaFornecedor.add(lbldesenhoFornecedor, javax.swing.JLayeredPane.DEFAULT_LAYER);

        painelAbas.addTab("", new javax.swing.ImageIcon(getClass().getResource("/Imagens/fornecedor_aba.png")), abaFornecedor, "CONTROLE DE FORNECEDORES"); // NOI18N

        abaCategoria.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                abaCategoriaComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                abaCategoriaComponentShown(evt);
            }
        });

        lbldesenhoCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldesenhoCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Categoria.png"))); // NOI18N
        lbldesenhoCategoria.setBounds(0, 0, 640, 640);
        abaCategoria.add(lbldesenhoCategoria, javax.swing.JLayeredPane.DEFAULT_LAYER);

        painelAbas.addTab("", new javax.swing.ImageIcon(getClass().getResource("/Imagens/categoria_aba.png")), abaCategoria, "CONTROLE DE CATEGORIAS"); // NOI18N

        abaFabricante.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                abaFabricanteComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                abaFabricanteComponentShown(evt);
            }
        });

        lbldesenhoFabricante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldesenhoFabricante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Fabricante.png"))); // NOI18N
        lbldesenhoFabricante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbldesenhoFabricante.setMaximumSize(abaFabricante.getPreferredSize());
        lbldesenhoFabricante.setMinimumSize(abaFabricante.getPreferredSize());
        lbldesenhoFabricante.setPreferredSize(abaFabricante.getPreferredSize());
        lbldesenhoFabricante.setBounds(0, 0, 640, 640);
        abaFabricante.add(lbldesenhoFabricante, javax.swing.JLayeredPane.DEFAULT_LAYER);

        painelAbas.addTab("", new javax.swing.ImageIcon(getClass().getResource("/Imagens/fabricante_aba.png")), abaFabricante, "CONTROLE DE FABRICANTES"); // NOI18N

        abaRelatorio.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.acceleratorForeground")));
        abaRelatorio.setOpaque(false);
        abaRelatorio.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                abaRelatorioComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                abaRelatorioComponentShown(evt);
            }
        });
        abaRelatorio.setLayout(null);

        lblRelatorio.setFont(new java.awt.Font("Dialog", 1, 36));
        lblRelatorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRelatorio.setText("RELATÓRIOS");
        abaRelatorio.add(lblRelatorio);
        lblRelatorio.setBounds(0, 0, 290, 70);

        painelAbas.addTab("", new javax.swing.ImageIcon(getClass().getResource("/Imagens/relatorios_aba.png")), abaRelatorio, "MONTE, ATRAVÉS DE PESQUISAS, RELATÓRIOS"); // NOI18N

        getContentPane().add(painelAbas, java.awt.BorderLayout.CENTER);

        menuAlpha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/hora_icone.png"))); // NOI18N
        menuAlpha.setMnemonic('A');
        menuAlpha.setText("AlphaMenu");
        menuAlpha.setToolTipText("Alpha Menu");
        menuAlpha.setFont(new java.awt.Font("sansserif", 1, 12));
        menuAlpha.add(jSeparator3);

        ItemCaixa.setText("Caixa");
        ItemCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemCaixaActionPerformed(evt);
            }
        });
        menuAlpha.add(ItemCaixa);

        itemLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
        itemLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logout_icone.png"))); // NOI18N
        itemLogout.setMnemonic('L');
        itemLogout.setText("Logout");
        itemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLogoutActionPerformed(evt);
            }
        });
        menuAlpha.add(itemLogout);
        menuAlpha.add(jSeparator1);

        itemSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        itemSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/sair_icone.png"))); // NOI18N
        itemSair.setMnemonic('S');
        itemSair.setText("Sair");
        itemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSairActionPerformed(evt);
            }
        });
        menuAlpha.add(itemSair);

        barraMenu.add(menuAlpha);

        menuAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/administrador_menu.png"))); // NOI18N
        menuAdministrador.setMnemonic('d');
        menuAdministrador.setText("Administrador");
        menuAdministrador.setFont(new java.awt.Font("sansserif", 1, 12));

        itemAdmCadFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/funcionario_menu.png"))); // NOI18N
        itemAdmCadFuncionario.setMnemonic('f');
        itemAdmCadFuncionario.setText("Controle de funcionário");
        itemAdmCadFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAdmCadFuncionarioActionPerformed(evt);
            }
        });
        menuAdministrador.add(itemAdmCadFuncionario);

        menuAdmManutencao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/manutencao_menu.png"))); // NOI18N
        menuAdmManutencao.setMnemonic('M');
        menuAdmManutencao.setText("Manutenção");

        itemBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/backup_menu.png"))); // NOI18N
        itemBackup.setText("Backup");
        itemBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBackupActionPerformed(evt);
            }
        });
        menuAdmManutencao.add(itemBackup);

        itemRestaurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/restore_menu.png"))); // NOI18N
        itemRestaurar.setText("Restaurar");
        itemRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRestaurarActionPerformed(evt);
            }
        });
        menuAdmManutencao.add(itemRestaurar);

        menuAdministrador.add(menuAdmManutencao);

        barraMenu.add(menuAdministrador);

        menuOpcoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/opcoes_menu.png"))); // NOI18N
        menuOpcoes.setMnemonic('O');
        menuOpcoes.setText("Opções");
        menuOpcoes.setFont(new java.awt.Font("sansserif", 1, 12));
        barraMenu.add(menuOpcoes);

        menuAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ajuda_menu.png"))); // NOI18N
        menuAjuda.setMnemonic('j');
        menuAjuda.setText("Ajuda");
        menuAjuda.setFont(new java.awt.Font("sansserif", 1, 12));

        itemIndice.setMnemonic('\u00cd');
        itemIndice.setText("Índice  de atalhos");
        menuAjuda.add(itemIndice);

        itemManual.setMnemonic('n');
        itemManual.setText("Manual");
        itemManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemManualActionPerformed(evt);
            }
        });
        menuAjuda.add(itemManual);
        menuAjuda.add(jSeparator2);

        menuSobre.setMnemonic('S');
        menuSobre.setText("Sobre...");

        itemAlphablend.setText("Alpha Blend");
        menuSobre.add(itemAlphablend);

        itemCronos.setText("Cronos");
        menuSobre.add(itemCronos);

        menuAjuda.add(menuSobre);

        barraMenu.add(menuAjuda);

        setJMenuBar(barraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSairActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Isto encerrará a aplicação inteira.", "Deseja realmente sair?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
            Sessao.sair();
            System.exit(0);
        }
    }//GEN-LAST:event_itemSairActionPerformed

    private void abaFabricanteComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaFabricanteComponentShown
        frameCadFabricante frm = new frameCadFabricante();
        abaFabricante.add(frm);
        try {
            frm.setVisible(true);
            frm.setMaximum(true);
        } catch (PropertyVetoException e) {
        }
    }//GEN-LAST:event_abaFabricanteComponentShown

    private void abaFabricanteComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaFabricanteComponentHidden
        abaFabricante.removeAll();
        abaFabricante.add(lbldesenhoFabricante);
    }//GEN-LAST:event_abaFabricanteComponentHidden

    private void abaClienteComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaClienteComponentShown
        frameCliente frm = new frameCliente();
        abaCliente.add(frm);
        try {
            frm.setVisible(true);
            frm.setMaximum(true);
        } catch (PropertyVetoException e) {
        }
    }//GEN-LAST:event_abaClienteComponentShown

    private void abaClienteComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaClienteComponentHidden
        abaCliente.removeAll();
        abaCliente.add(lbldesenhoCliente);
    }//GEN-LAST:event_abaClienteComponentHidden

    private void abaProdutoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaProdutoComponentShown
        frameProduto frm = new frameProduto();
        abaProduto.add(frm);
        try {
            frm.setVisible(true);
            frm.setMaximum(true);
        } catch (PropertyVetoException e) {
        }
    }//GEN-LAST:event_abaProdutoComponentShown

    private void abaProdutoComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaProdutoComponentHidden
        abaProduto.removeAll();
        abaProduto.add(lbldesenhoProduto);
    }//GEN-LAST:event_abaProdutoComponentHidden

    private void abaCategoriaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaCategoriaComponentShown
        frameCategoria frm = new frameCategoria();
        abaCategoria.add(frm);
        try {
            frm.setVisible(true);
            frm.setMaximum(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_abaCategoriaComponentShown

    private void abaCategoriaComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaCategoriaComponentHidden
        abaCategoria.removeAll();
        abaCategoria.add(lbldesenhoCategoria);
    }//GEN-LAST:event_abaCategoriaComponentHidden

    private void abaFornecedorComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaFornecedorComponentShown
        frameFornecedor frm = new frameFornecedor();
        abaFornecedor.add(frm);
        try {
            frm.setVisible(true);
            frm.setMaximum(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_abaFornecedorComponentShown

    private void abaFornecedorComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaFornecedorComponentHidden
        abaFornecedor.removeAll();
        abaFornecedor.add(lbldesenhoFornecedor);
    }//GEN-LAST:event_abaFornecedorComponentHidden

    private void abaServicoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaServicoComponentShown
        frameServico frm = new frameServico();
        abaServico.add(frm);
        try {
            frm.setVisible(true);
            frm.setMaximum(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_abaServicoComponentShown

    private void abaServicoComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaServicoComponentHidden
        abaServico.removeAll();
        abaServico.add(lbldesenhoServico);
    }//GEN-LAST:event_abaServicoComponentHidden

    private void abaVendaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaVendaComponentShown
        frameVenda frm = new frameVenda();
        abaVenda.add(frm);
        try {
            frm.setVisible(true);
            frm.setMaximum(true);
            frm.codfunc = Sessao;
        } catch (PropertyVetoException e) {
        }
    }//GEN-LAST:event_abaVendaComponentShown

    private void abaVendaComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaVendaComponentHidden
        abaVenda.removeAll();
        abaVenda.add(lbldesenhoVenda);
    }//GEN-LAST:event_abaVendaComponentHidden

    private void abaCompraComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaCompraComponentShown
        frameCompra frm = new frameCompra();
        abaCompra.add(frm);
        try {
            frm.setVisible(true);
            frm.setMaximum(true);
            frm.codfunc2 = Sessao;
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_abaCompraComponentShown

    private void itemAdmCadFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAdmCadFuncionarioActionPerformed
        frmCadFuncionario frm = new frmCadFuncionario(this, true);
        frm.setSize(800, 650);
        frm.setLocationRelativeTo(this);
        frm.setVisible(true);
        frm.setModal(true);
    }//GEN-LAST:event_itemAdmCadFuncionarioActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        logar();
        this.setExtendedState(6);
    }//GEN-LAST:event_formWindowOpened

    private void btnInicioVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioVendaActionPerformed
        painelAbas.setSelectedIndex(1);
    }//GEN-LAST:event_btnInicioVendaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        painelAbas.setSelectedIndex(5);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void itemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLogoutActionPerformed
        int resposta = JOptionPane.showConfirmDialog(this, "Você será direcionado a tela de login caso escolha YES.", "Deseja realmente sair?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resposta == JOptionPane.YES_OPTION) {
            Sessao.sair();
            frmLogin frmL = new frmLogin();
            frmL.setSize(347, 160);
            frmL.setLocationRelativeTo(null);
            frmL.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_itemLogoutActionPerformed

    private void abaRelatorioComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaRelatorioComponentShown
        frameRelatorio frm = new frameRelatorio();
        abaRelatorio.removeAll();
        abaRelatorio.add(frm);
        try {
            frm.setVisible(true);
            frm.setMaximum(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_abaRelatorioComponentShown

    private void abaRelatorioComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaRelatorioComponentHidden
        abaRelatorio.removeAll();
        abaRelatorio.add(lblRelatorio);
    }//GEN-LAST:event_abaRelatorioComponentHidden

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dialogEstoque frm = new dialogEstoque(this, true);
        frm.setSize(640, 600);
        frm.setModal(true);
        frm.setLocationRelativeTo(null);
        frm.setResizable(false);
        frm.setTitle("Estoque");
        frm.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnInicioVendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioVendaMouseEntered
        btnInicioVenda.setSize(170, 150);
    }//GEN-LAST:event_btnInicioVendaMouseEntered

    private void btnInicioVendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioVendaMouseExited
        btnInicioVenda.setSize(142, 110);
    }//GEN-LAST:event_btnInicioVendaMouseExited

    private void ItemCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemCaixaActionPerformed
        dialogCaixa frm = new dialogCaixa(this, true);
        frm.codfunc3 = Sessao;
        frm.setSize(513, 491);
        frm.setModal(true);
        frm.setLocationRelativeTo(null);
        frm.setResizable(false);
        frm.setTitle("Caixa");
        frm.setVisible(true);
    }//GEN-LAST:event_ItemCaixaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (JOptionPane.showConfirmDialog(this, "Isto encerrará a aplicação inteira.", "Deseja realmente sair?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
            Sessao.sair();
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void abaCompraComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaCompraComponentHidden
        abaCompra.removeAll();
        abaCompra.add(lbldesenhoCompra);
    }//GEN-LAST:event_abaCompraComponentHidden

    private void itemBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBackupActionPerformed
        try {
            con.Conecta();
            con.backUpDatabase();
            JOptionPane.showMessageDialog(this, "Cópia de segurança realizada com sucesso!.", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível realizar a cópia de segurança de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_itemBackupActionPerformed

    private void itemManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemManualActionPerformed
        dlgAjuda frm = new dlgAjuda(this, true);
        frm.setSize(800, 650);
        frm.setLocationRelativeTo(this);
        frm.setVisible(true);
        frm.setResizable(false);
        frm.setModal(true);
    }//GEN-LAST:event_itemManualActionPerformed

    private void itemRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRestaurarActionPerformed
        con.Conecta();
        con.Fecha();
        try {
            if (con.restaurarDatabase() == 0) {
                JOptionPane.showMessageDialog(this, "Restauração de dados realizada com sucesso!.", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível realizar a restauração de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível realizar a restauração de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_itemRestaurarActionPerformed

    public void run() {
        while (true) {
            try {
                lblHora.setToolTipText(new Date().toString());
                sdf = new SimpleDateFormat("hh:mm:ss");
                lblHora.setText(sdf.format(new Date()));
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                System.out.println("Erro na hora.");
                ie.printStackTrace();
            }
        }
    }

    private void logar() {
        if (Sessao.getDireito() == true) {
            menuAdministrador.setEnabled(true);
            //TODO  habilitar opção de inserir saída(true);
            lblUsuario.setText(Sessao.getnomeFuncionario() + " (ADMINISTRADOR)");
            lblUsuario.setIcon(new ImageIcon(getClass().getResource("/Imagens/adm_icone.png")));
        } else {
            menuAdministrador.setEnabled(false);
            //TODO habilitar opção de inserir saída (false);
            lblUsuario.setText(Sessao.getnomeFuncionario() + " (FUNCIONÁRIO)");
            lblUsuario.setIcon(new ImageIcon(getClass().getResource("/Imagens/usuario_icone.png")));
        }
    }//logadoAdministrador
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ItemCaixa;
    private javax.swing.JDesktopPane abaCategoria;
    private javax.swing.JDesktopPane abaCliente;
    private javax.swing.JDesktopPane abaCompra;
    private javax.swing.JDesktopPane abaFabricante;
    private javax.swing.JDesktopPane abaFornecedor;
    private javax.swing.JLayeredPane abaInicio;
    private javax.swing.JDesktopPane abaProduto;
    private javax.swing.JPanel abaRelatorio;
    private javax.swing.JDesktopPane abaServico;
    private javax.swing.JDesktopPane abaVenda;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnInicioVenda;
    private javax.swing.JMenuItem itemAdmCadFuncionario;
    private javax.swing.JMenuItem itemAlphablend;
    private javax.swing.JMenuItem itemBackup;
    private javax.swing.JMenuItem itemCronos;
    private javax.swing.JMenuItem itemIndice;
    private javax.swing.JMenuItem itemLogout;
    private javax.swing.JMenuItem itemManual;
    private javax.swing.JMenuItem itemRestaurar;
    private javax.swing.JMenuItem itemSair;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblRelatorio;
    public javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lbldesenhoCategoria;
    private javax.swing.JLabel lbldesenhoCliente;
    private javax.swing.JLabel lbldesenhoCliente1;
    private javax.swing.JLabel lbldesenhoCompra;
    private javax.swing.JLabel lbldesenhoFabricante;
    private javax.swing.JLabel lbldesenhoFornecedor;
    private javax.swing.JLabel lbldesenhoProduto;
    private javax.swing.JLabel lbldesenhoServico;
    private javax.swing.JLabel lbldesenhoVenda;
    private javax.swing.JMenu menuAdmManutencao;
    private javax.swing.JMenu menuAdministrador;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuAlpha;
    private javax.swing.JMenu menuOpcoes;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JTabbedPane painelAbas;
    private javax.swing.JPanel statusBar;
    // End of variables declaration//GEN-END:variables
}
