/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import utils.LogsUtil;
import utils.MyUtil;

/**
 *
 * @author David Daniel Kurtz <daviddanielkurtz@gmail.com>
 */
public class POS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    MainForm.setLookAndFeel();
                    MainForm.getInstance().setVisible(true);
                    MainForm.getInstance().setExtendedState(JFrame.MAXIMIZED_BOTH);
                    MainForm.getInstance().setIconImage(Toolkit.getDefaultToolkit().getImage(POS.class.getClass().getResource("/images/white-circle.png"))); // Changed title icon
                    
                    LoginForm.getInstance().setLocationRelativeTo(MainForm.getInstance());
                    LoginForm.getInstance().setVisible(true);
                    
                    MainForm.getInstance().reset();
                    MainForm.getInstance().initProducts();
                }
            });
        } catch (Exception e) {
            LogsUtil.create(POS.class.getClass()).error(POS.class.getSimpleName(), e);
            Logger.getLogger(POS.class.getSimpleName()).log(Level.SEVERE, null, e);
            MyUtil.showErrorMessage(null, "Error: " + e.getMessage());
            System.exit(0);
        }
    }
}
