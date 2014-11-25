/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Daniel Kurtz <daviddanielkurtz@gmail.com>
 */
public class ConfigUtil {

    public static Conf user;

    public static Conf getUser() {
        if (user == null) {
            String str[] = ConfigUtil.readFile("conf/conf.dll").split("\n");
            user = new Conf();
            user.setHost(str[0]);
            user.setUsername(str[1]);
            user.setPassword(str[2]);
            user.setDatabaseName(str[3]);
        }
        return user;
    }

    public static void setUser(Conf user) {
        ConfigUtil.user = user;
    }

    private static String readFile(String fileLocation) {
        try {
            BufferedReader br = null;
            File file = new File(fileLocation);
            br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append('\n');
                line = br.readLine();
            }
            br.close();
            return sb.toString();
        } catch (IOException ex) {
            Logger.getLogger(ConfigUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
