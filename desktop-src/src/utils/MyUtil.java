/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

/**
 *
 * @author David Daniel Kurtz <daviddanielkurtz@gmail.com>
 */
public class MyUtil {

    public static final DecimalFormat df = new DecimalFormat("0000");
    public static final SimpleDateFormat dateFormatMMMMMddyyyy = new SimpleDateFormat("MMMMM dd, yyyy");
    public static final DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
    public static final String ADD = "ADD";
    public static final String EDIT = "EDIT";
    public static final String STOCKIN = "STOCKIN";
    public static final String STOCKOUT = "STOCKOUT";
    public static final String SALES = "SALES";

    public static void showErrorMessage(Component parrentComponent, String message) {
        JOptionPane.showMessageDialog(parrentComponent, message, "Oops!", JOptionPane.ERROR_MESSAGE);
    }

    public static void showSuccessMessage(Component parrentComponent, String message) {
        Image image = Toolkit.getDefaultToolkit().getImage(MyUtil.class.getClass().getResource("/images/done.png"));
        ImageIcon icon = new ImageIcon(image);
        JOptionPane.showMessageDialog(parrentComponent, message, null, JOptionPane.INFORMATION_MESSAGE, icon);
    }

    public static void showInfoMessage(Component parrentComponent, String message) {
        JOptionPane.showMessageDialog(parrentComponent, message, "Oops!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static synchronized void playSound(final String url) {
        new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                try {
                    File file = new File("audio/" + url);
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
    private static Thread thread;

    public static void playAudio() {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    File file = new File("audio/alert_audio.mp3");
                    AdvancedPlayer player = new AdvancedPlayer(new FileInputStream(file));
                    player.play();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MyUtil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JavaLayerException ex) {
                    Logger.getLogger(MyUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        thread.start();
    }

    public static void stopAudio() {
        thread.stop();
    }
}
