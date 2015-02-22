/*
 * frmCadCliente.java
 *
 * Created on 03/04/2010, 14:16:24
 */

package frontEnd;

import java.beans.PropertyVetoException;

/*
 * Classe responsável pela interação
 * Usuário <==> nível2
 */

public class frmCadFuncionario extends javax.swing.JDialog {

    /** Creates new form frmCadCliente */
    public frmCadFuncionario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desk = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administração");
        setMinimumSize(new java.awt.Dimension(400, 600));
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        desk.setDragMode(javax.swing.JDesktopPane.OUTLINE_DRAG_MODE);
        getContentPane().add(desk, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

// -------------- Evento quandoJanelaAberta -----------------------------
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        frameFuncionario frm = new frameFuncionario();
        desk.add(frm);
        try{
        frm.setVisible(true);
        frm.setMaximum(true);
        }catch(PropertyVetoException e){
        }
        this.setDefaultLookAndFeelDecorated(true);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        desk.removeAll();
    }//GEN-LAST:event_formWindowClosing

    /**
    * @param args the command line arguments
    */
    //public static void main(String args[]) {
   //     java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmCadFuncionario dialog = new frmCadFuncionario(new javax.swing.JFrame(), true);
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