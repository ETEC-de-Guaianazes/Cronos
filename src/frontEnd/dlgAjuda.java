package frontEnd;

import java.io.IOException;
import javax.swing.event.HyperlinkEvent;

/**
 * @author Programador
 */
public class dlgAjuda extends javax.swing.JDialog {

    /** Creates new form dlgAjuda */
    public dlgAjuda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelRolavel = new javax.swing.JScrollPane();
        painelEditor = new javax.swing.JEditorPane();
        barraProgresso = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cronos - Ajuda");
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        painelEditor.setEditable(false);
        painelEditor.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        painelEditor.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                painelEditorHyperlinkUpdate(evt);
            }
        });
        painelRolavel.setViewportView(painelEditor);

        getContentPane().add(painelRolavel, java.awt.BorderLayout.CENTER);

        barraProgresso.setFocusable(false);
        barraProgresso.setPreferredSize(new java.awt.Dimension(148, 20));
        getContentPane().add(barraProgresso, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        barraProgresso.setVisible(false);
        barraProgresso.setString("Carregando ajuda.html...");
        barraProgresso.setStringPainted(true);
        Thread exec = new Thread(new executar());
        barraProgresso.setIndeterminate(true);
        exec.start();
        //barraProgresso.setString("Pronto!");
                
        //barraProgresso.setIndeterminate(false);
    }//GEN-LAST:event_formWindowOpened

    private class executar implements Runnable {

        public void run() {
            java.net.URL helpURL = dlgAjuda.class.getResource("ajuda.html");
            if (helpURL != null) {
                try {
                    painelEditor.setPage(helpURL);                    
                } catch (IOException e) {
                    System.err.println("Dificuldades ao ler " + helpURL + ".");
                    barraProgresso.setString("Dificuldades ao ler " + helpURL + ".");
                }
            } else {
                System.err.println("ajuda.html nao encontrada.");
                barraProgresso.setString("Página ajuda.html não encontrada.");
            }
        }
    }

    private void painelEditorHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_painelEditorHyperlinkUpdate
        if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            try {
                painelEditor.setPage(evt.getURL());
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }//GEN-LAST:event_painelEditorHyperlinkUpdate
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgresso;
    private javax.swing.JEditorPane painelEditor;
    private javax.swing.JScrollPane painelRolavel;
    // End of variables declaration//GEN-END:variables
    }
