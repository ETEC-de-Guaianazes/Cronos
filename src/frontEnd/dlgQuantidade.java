package frontEnd;

import Banco.Conexao;
import Validacoes.Validacao;
import javax.swing.JOptionPane;

public class dlgQuantidade extends javax.swing.JDialog {

    private Validacao verificador = new Validacao();
    private Comum cmm = new Comum();
    public int QtdeInicial=0, Qtde=0 , QTDE = 0;
    Conexao con = new Conexao();

    /** Creates new form dlgQuantidade */
    public dlgQuantidade(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelQtde = new javax.swing.JPanel();
        btnqtde = new javax.swing.JButton();
        txtQdte = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Remover quantos:");
        setIconImage(null);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        painelQtde.setMaximumSize(new java.awt.Dimension(244, 28));
        painelQtde.setMinimumSize(new java.awt.Dimension(244, 28));
        painelQtde.setPreferredSize(new java.awt.Dimension(244, 28));
        painelQtde.setLayout(null);

        btnqtde.setText("ADICIONAR");
        btnqtde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnqtdeActionPerformed(evt);
            }
        });
        painelQtde.add(btnqtde);
        btnqtde.setBounds(150, 0, 93, 30);
        painelQtde.add(txtQdte);
        txtQdte.setBounds(0, 0, 150, 30);

        getContentPane().add(painelQtde, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnqtdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnqtdeActionPerformed

        if(verificador.isNumeric(txtQdte.getText().replaceAll(" ",""))){
            Qtde = Integer.parseInt(txtQdte.getText().replaceAll(" ",""));
            

            if(btnqtde.getText().equals("ADICIONAR")){
                if(Qtde>0){
                    Qtde += QtdeInicial;
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Insira um numero acima de 0.","Impossível adicionar",JOptionPane.WARNING_MESSAGE);
                }
            }//Fim ADICIONAR

            else{
                if(Qtde<=QtdeInicial){
                    QTDE = Qtde;
                    Qtde = QtdeInicial-Qtde;
                    
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Insira um número menor ou igual a "+QtdeInicial + ".","Impossível remover",JOptionPane.WARNING_MESSAGE);
                }
            }//fim REMOVER
        }
        else{
            JOptionPane.showMessageDialog(null,"Digite números válidos!","Caracteres invalidos!",JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnqtdeActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       //cmm.setFormataNumero("", txtQdte, "0123456789", ' ');
       txtQdte.setText(""+QtdeInicial);


    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Qtde = -1;
    }//GEN-LAST:event_formWindowClosing

    /**
    * @param args the command line arguments
    */
            public void run() {
                dlgQuantidade dialog = new dlgQuantidade(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {                        
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnqtde;
    private javax.swing.JPanel painelQtde;
    private javax.swing.JTextField txtQdte;
    // End of variables declaration//GEN-END:variables

}
