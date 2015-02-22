/* Classe principal */

import frontEnd.frmLogin;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.pushingpixels.substance.api.skin.SubstanceMistAquaLookAndFeel;

public class Principal {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(new SubstanceMistAquaLookAndFeel());
                    SubstanceMistAquaLookAndFeel.setToUseConstantThemesOnDialogs(true);
                    JFrame.setDefaultLookAndFeelDecorated(true);
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    //telaPrincipal frm = new telaPrincipal();
                    frmLogin frm = new frmLogin();
                    //frm.setLocationRelativeTo(null);
                    frm.setVisible(true);                    

                } catch (Exception e) {
                }
            }
        });
    }//Método
}//Classe

