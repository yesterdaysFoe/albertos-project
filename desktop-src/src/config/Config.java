/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author David Daniel Kurtz <daviddanielkurtz@gmail.com>
 */
public class Config {

    private static EntityManagerFactory instance;

    public static EntityManagerFactory getInstance() {

        if (instance == null) {
            config.Conf user = ConfigUtil.getUser();

            String connection = "jdbc:mysql://" + user.getHost() + "/"+ user.getDatabaseName();
            Map<String, String> connectionMap = new HashMap();
            connectionMap.put("javax.persistence.jdbc.url", connection);
            connectionMap.put("javax.persistence.jdbc.password", user.getPassword());
            connectionMap.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
            connectionMap.put("javax.persistence.jdbc.user", user.getUsername());
            instance = Persistence.createEntityManagerFactory("POSPU", connectionMap);
        }

        return instance;
    }

    public static void resetInstance() {
        instance = null;
    }
}
