/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

/**
 *
 * @author Total SoftTech
 */
public class LogsUtil {

    private static Logger log;

    private static Logger performLogging(Class className, Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Logger logger = null;

        String filepath = "log/logs %s.dll";
        filepath = String.format(filepath, dateFormat.format(date));
        File f = new File("log");
        createLoggerFile(f, filepath);

        logger = Logger.getLogger(className);

        RollingFileAppender appender = new RollingFileAppender();
        createAppender(appender, filepath);
        logger.addAppender(appender);
        return logger;
    }

    private static void createAppender(RollingFileAppender appender, String filepath) {
        try {
            appender.setFile(filepath, true, true, 2048);
            PatternLayout patternLayout = createAppenderPattern();
            appender.setLayout(patternLayout);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LogsUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static PatternLayout createAppenderPattern() {
        PatternLayout patternLayout = new PatternLayout();
        patternLayout.setConversionPattern("%d [%t] %-5p %c- %m%n");
        return patternLayout;
    }

    private static void createLoggerFile(File f, String filepath) {
        try {
            f.mkdirs();
            f = new File(filepath);
            f.createNewFile();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LogsUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Logger create(Class className) {
        log = performLogging(className, new Date());
        return log;
    }
}
