/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.bll.essentials;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Nijas Hansen
 */
public class PasswordEncryptor {
    
    /**
     * takes a given password and encrypts it to MD5 format 
     * then returns the formatted password
     * @param password
     * @return 
     */
    public static String encryptPassword(String password) {
        
        String hashedPassword = null;
        
        try {
            //sets messagedigest to MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            md.update(password.getBytes());
            
            byte[] bytes = md.digest();
            
            
            StringBuilder sb = new StringBuilder();
            //for each letter it replaces the character with a random HEX number
            for (int i = 0; i < bytes.length; i++) {
                
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,
                        16).substring(1));
            }
            
            //sets the string to be the formatted password
            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        
        return hashedPassword;
        
    }
    
}
