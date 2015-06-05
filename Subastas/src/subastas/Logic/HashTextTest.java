/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subastas.Logic;

import static java.awt.SystemColor.text;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.IOUtils;

/**
 *
 * @author Xelop
 */
public class HashTextTest {
 
    /**
     * @param args
     * @throws NoSuchAlgorithmException 
     */
    public static String sha1(String input){
        try {
            MessageDigest mDigest = MessageDigest.getInstance("SHA1");
            byte[] result = mDigest.digest(input.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < result.length; i++) {
                sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
            }
            
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(HashTextTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static String sha2(String input){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(input.getBytes());
            BigInteger hash = new BigInteger(1, md.digest());
            String result = hash.toString(16);
            result = result.toUpperCase();
            return result;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(HashTextTest.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
