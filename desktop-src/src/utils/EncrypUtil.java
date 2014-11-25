/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

/**
 *
 * @author Total SoftTech
 */
public class EncrypUtil {

    public static String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncrypUtil.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }

    }

    private static void writeToFile(String filename, Object objectToWrite) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            final File file = new File(filename);
            file.mkdir();
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(objectToWrite);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                oos.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }

    private static Object readFromFile(String filename) throws Exception {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Object object = null;
        try {
            fis = new FileInputStream(filename);
            ois = new ObjectInputStream(fis);
            object = ois.readObject();
        } catch (Exception e) {
        } finally {
            if (ois != null) {
                ois.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return object;
    }

    public static void encryptedTextToFile(String strToEncrypt, String fileLocation) {
        try {
            SecretKey key = KeyGenerator.getInstance("DES").generateKey();
            writeToFile("dbconfig/dbkey.key", key);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(1, key);
            SealedObject sealedObject = new SealedObject(strToEncrypt, cipher);
            writeToFile(fileLocation, sealedObject);
        } catch (Exception ex) {
            Logger.getLogger(EncrypUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String decryptTextFromFile(String fileLocation) {
        try {
            SecretKey key = (SecretKey) readFromFile("dbconfig/dbkey.key");
            SealedObject sealedObject = (SealedObject) readFromFile(fileLocation);

            if (sealedObject != null) {
                String algorithmName = sealedObject.getAlgorithm();
                Cipher cipher = Cipher.getInstance(algorithmName);
                cipher.init(2, key);
                return (String) sealedObject.getObject(cipher);
            } else {
                return "host:user:password";
            }
        } catch (Exception ex) {
            Logger.getLogger(EncrypUtil.class.getName()).log(Level.SEVERE, null, ex);
            return "host:user:password";
        }
    }
}
