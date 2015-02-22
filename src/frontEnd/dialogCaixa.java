/*
 * dialogCaixa.java
 *
 * Created on 06/06/2010, 12:32:48
 */
package frontEnd;

import Banco.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class dialogCaixa extends javax.swing.JDialog {

    private DefaultComboBoxModel mdlEntrada, mdlSaida;
    private CadProduto cadPro;
    private String sql;
    public sessao codfunc3;
    public CadMovimentacao cadmov = new CadMovimentacao();
    private SimpleDateFormat sdf;
    private frameCompra frm;

    /** Creates new form dialogCaixa */
    public dialogCaixa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddEntrada = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbEntrada = new javax.swing.JComboBox();
        cmbSaida = new javax.swing.JComboBox();
        btnNovaSaida = new javax.swing.JButton();
        btnNovaEntrada = new javax.swing.JButton();
        btnAddSaida = new javax.swing.JButton();
        lblValorAtual = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtValorSaida = new javax.swing.JTextField();
        txtValorEntrada = new javax.swing.JTextField();
        btnFechar = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        btnAddEntrada.setFont(new java.awt.Font("sansserif", 1, 12));
        btnAddEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/inserir_icone.png"))); // NOI18N
        btnAddEntrada.setToolTipText("Adicionar novo tipo de entrada");
        btnAddEntrada.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAddEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEntradaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddEntrada);
        btnAddEntrada.setBounds(440, 140, 50, 40);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18));
        jLabel1.setText("Saída:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 230, 60, 40);

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 18));
        jLabel2.setText("Valor em caixa:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 0, 130, 40);

        cmbEntrada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEntrada.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cmbEntradaPopupMenuWillBecomeVisible(evt);
            }
        });
        getContentPane().add(cmbEntrada);
        cmbEntrada.setBounds(90, 140, 350, 40);

        cmbSaida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSaida.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cmbSaidaPopupMenuWillBecomeVisible(evt);
            }
        });
        getContentPane().add(cmbSaida);
        cmbSaida.setBounds(90, 230, 350, 40);

        btnNovaSaida.setText("Efetuar");
        btnNovaSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaSaidaActionPerformed(evt);
            }
        });
        getContentPane().add(btnNovaSaida);
        btnNovaSaida.setBounds(360, 270, 80, 40);

        btnNovaEntrada.setText("Efetuar");
        btnNovaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaEntradaActionPerformed(evt);
            }
        });
        getContentPane().add(btnNovaEntrada);
        btnNovaEntrada.setBounds(360, 180, 80, 40);

        btnAddSaida.setFont(new java.awt.Font("sansserif", 1, 12));
        btnAddSaida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/inserir_icone.png"))); // NOI18N
        btnAddSaida.setToolTipText("Adicionar novo tipo de Saída");
        btnAddSaida.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAddSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSaidaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddSaida);
        btnAddSaida.setBounds(440, 230, 50, 40);

        lblValorAtual.setFont(new java.awt.Font("sansserif", 1, 36));
        lblValorAtual.setForeground(new java.awt.Color(100, 143, 172));
        lblValorAtual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblValorAtual);
        lblValorAtual.setBounds(10, 50, 480, 80);

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 18));
        jLabel3.setText("Valor:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 270, 50, 40);

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 18));
        jLabel4.setText("Entrada:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 140, 70, 40);

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 18));
        jLabel5.setText("Valor:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 180, 50, 40);
        getContentPane().add(txtValorSaida);
        txtValorSaida.setBounds(90, 270, 260, 40);
        getContentPane().add(txtValorEntrada);
        txtValorEntrada.setBounds(90, 180, 260, 40);

        btnFechar.setText("FECHAR");
        btnFechar.setEnabled(false);
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar);
        btnFechar.setBounds(260, 330, 150, 30);

        btnAbrir.setText("ABRIR");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        getContentPane().add(btnAbrir);
        btnAbrir.setBounds(60, 330, 130, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEntradaActionPerformed
        dialogEntrada dlgEntrada = new dialogEntrada(null, true);
        dlgEntrada.setSize(331, 190);
        dlgEntrada.setModal(true);
        dlgEntrada.setLocationRelativeTo(null);
        dlgEntrada.setResizable(false);
        dlgEntrada.setTitle("Nova Entrada");
        dlgEntrada.setVisible(true);
    }//GEN-LAST:event_btnAddEntradaActionPerformed

    private void btnAddSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSaidaActionPerformed
        dialogSaida dlgSaida = new dialogSaida(null, true);
        dlgSaida.setSize(331, 190);
        dlgSaida.setModal(true);
        dlgSaida.setLocationRelativeTo(null);
        dlgSaida.setResizable(false);
        dlgSaida.setTitle("Nova Saída");
        dlgSaida.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddSaidaActionPerformed

    public void habilitarsaida() {
        btnNovaSaida.setEnabled(true);
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        atualizarcombos();
        if (codfunc3.getCaixaaberto() == false) {
            cmbEntrada.setEnabled(false);
            txtValorEntrada.setEnabled(false);
            btnAddEntrada.setEnabled(false);
            btnNovaEntrada.setEnabled(false);
            cmbSaida.setEnabled(false);
            txtValorSaida.setEnabled(false);
            btnAddSaida.setEnabled(false);
            btnNovaSaida.setEnabled(false);
            btnFechar.setEnabled(false);
        } else {
            btnFechar.setEnabled(true);
            double lbl = Double.parseDouble(cadmov.pegavalorcaixa());
            lblValorAtual.setText(String.format("%.2f", lbl));
            lblValorAtual.setVisible(true);
            btnAbrir.setEnabled(false);
        }
        if (codfunc3.getDireito() == false) {
            cmbSaida.setEnabled(false);
            txtValorSaida.setEnabled(false);
            btnAddSaida.setEnabled(false);
            btnNovaSaida.setEnabled(false);
        }
    }//GEN-LAST:event_formWindowOpened

    private void cmbEntradaPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbEntradaPopupMenuWillBecomeVisible
        atualizarcombos();  // TODO add your handling code here:
    }//GEN-LAST:event_cmbEntradaPopupMenuWillBecomeVisible

    private void cmbSaidaPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbSaidaPopupMenuWillBecomeVisible
        atualizarcombos();// TODO add your handling code here:
    }//GEN-LAST:event_cmbSaidaPopupMenuWillBecomeVisible

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        codfunc3.CaixaA();
        btnAbrir.setEnabled(false);

        sdf = new SimpleDateFormat("hh:mm:ss");
        String sHora = sdf.format(new Date());
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sData = sdf.format(new Date());
        double valorinicial = Double.parseDouble(JOptionPane.showInputDialog(this, "Insira o valor inicial do caixa.", "Abertura de Caixa", JOptionPane.QUESTION_MESSAGE).replaceAll(",", "."));
        String teste = String.format("%.2f", valorinicial);
        System.out.println(teste);
        cadmov.AbreCaixa(teste, sData, sHora, codfunc3.getCodigoFuncionario());
        lblValorAtual.setVisible(true);
        double lbl = Double.parseDouble(cadmov.pegavalorcaixa());
        lblValorAtual.setText(String.format("%.2f", lbl));
        btnFechar.setEnabled(true);
        if (lblValorAtual.getText().length() > 0) {
            cmbEntrada.setEnabled(true);
            txtValorEntrada.setEnabled(true);
            btnAddEntrada.setEnabled(true);
            btnNovaEntrada.setEnabled(true);
            if (codfunc3.getDireito() == true) {
                cmbSaida.setEnabled(true);
                txtValorSaida.setEnabled(true);
                btnAddSaida.setEnabled(true);
                btnNovaSaida.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        codfunc3.CaixaF();
        btnAbrir.setEnabled(true);
        lblValorAtual.setVisible(false);
        btnFechar.setEnabled(false);
        cmbEntrada.setEnabled(false);
        txtValorEntrada.setEnabled(false);
        btnAddEntrada.setEnabled(false);
        btnNovaEntrada.setEnabled(false);
        cmbSaida.setEnabled(false);
        txtValorSaida.setEnabled(false);
        btnAddSaida.setEnabled(false);
        btnNovaSaida.setEnabled(false);
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnNovaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaEntradaActionPerformed
        cadmov.AtualizaCaixa(Double.parseDouble(txtValorEntrada.getText().replaceAll(",", ".")), true);
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dia = sdf.format(new Date());
        String orig = cadmov.pegaorigemEntrada(cmbEntrada.getSelectedItem().toString());
        cadmov.cadastraEntrada(dia, txtValorEntrada.getText().replaceAll(",", "."), orig, codfunc3.getCodigoFuncionario());
        double lbl = Double.parseDouble(cadmov.pegavalorcaixa());
        lblValorAtual.setText(String.format("%.2f", lbl));
        txtValorEntrada.setText("");
    }//GEN-LAST:event_btnNovaEntradaActionPerformed

    private void btnNovaSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaSaidaActionPerformed
        cadmov.AtualizaCaixa(Double.parseDouble(txtValorSaida.getText().replaceAll(",", ".")), false);
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dia = sdf.format(new Date());
        String orig = cadmov.pegaorigemSaida(cmbSaida.getSelectedItem().toString());
        cadmov.cadastraSaida(dia, txtValorSaida.getText().replaceAll(",", "."), orig, codfunc3.getCodigoFuncionario());
        double lbl = Double.parseDouble(cadmov.pegavalorcaixa());
        lblValorAtual.setText(String.format("%.2f", lbl));
        txtValorSaida.setText("");
    }//GEN-LAST:event_btnNovaSaidaActionPerformed

    private void atualizarcombos() {
        cadPro = new CadProduto();
        sql = "SELECT * FROM tbl_origem_entrada";
        mdlEntrada = new DefaultComboBoxModel();
        cadPro.getListaCombo(cmbEntrada, mdlEntrada, sql);
        sql = "SELECT * FROM tbl_origem_saida";
        mdlSaida = new DefaultComboBoxModel();
        cadPro.getListaCombo(cmbSaida, mdlSaida, sql);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnAddEntrada;
    private javax.swing.JButton btnAddSaida;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovaEntrada;
    private javax.swing.JButton btnNovaSaida;
    private javax.swing.JComboBox cmbEntrada;
    private javax.swing.JComboBox cmbSaida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblValorAtual;
    private javax.swing.JTextField txtValorEntrada;
    private javax.swing.JTextField txtValorSaida;
    // End of variables declaration//GEN-END:variables
}
