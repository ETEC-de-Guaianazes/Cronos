package frontEnd;

import java.beans.PropertyVetoException;

public class frmCadCategoria extends javax.swing.JDialog {

    /** Creates new form frmCadCategoria */
    public frmCadCategoria(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desk = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de categoria");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(null);
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().add(desk, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        frameCategoria frm = new frameCategoria();
        desk.add(frm);
        try{
        frm.setVisible(true);
        frm.setMaximum(true);
        }catch(PropertyVetoException e){
        }
    }//GEN-LAST:event_formWindowOpened

    //    public static void main(String args[]) {
    //        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmCadCategoria dialog = new frmCadCategoria(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
    //    });
    //}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desk;
    // End of variables declaration//GEN-END:variables

}
