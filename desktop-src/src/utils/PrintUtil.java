/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Component;
import java.io.File;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import pos.MainForm;

/**
 *
 * @author David Daniel Kurtz <daviddanielkurtz@gmail.com>
 */
public class PrintUtil {

    public void Printing(TableModel model, String jrxml, String frametitle, Map<String, Object> parameters, Component frame) {
        try {
            JRTableModelDataSource conn = new JRTableModelDataSource(model);

            File reportFile = null;
            reportFile = new File(jrxml);

            JasperDesign jasperDesign = JRXmlLoader.load(reportFile);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            JasperPrint jasperPrint;
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);

            JasperViewer jv = new JasperViewer(jasperPrint);
            JDialog viewer = new JDialog(MainForm.getInstance(), true);
            viewer.setTitle(frametitle);
            viewer.getContentPane().add(jv.getContentPane());

            viewer.setBounds(0, 0, 800, 600);
            viewer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            viewer.setVisible(true);
            viewer.toFront();

        } catch (JRException exc) {
            File reportFile = null;
            reportFile = new File(jrxml);
            JOptionPane.showMessageDialog(frame, reportFile.getAbsolutePath() + "\n" + exc.getMessage());
            System.out.println(exc.getMessage());
            exc.printStackTrace();
            LogsUtil.create(PrintUtil.class.getClass()).error("Error in printing:", exc);
        }
    }
}
