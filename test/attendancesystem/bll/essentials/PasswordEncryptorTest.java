/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.bll.essentials;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class PasswordEncryptorTest {
    
    public PasswordEncryptorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of encryptPassword method, of class PasswordEncryptor.
     */
    @Test
    public void testEncryptPassword() {
        System.out.println("encryptPassword");
        
        String password = "123456";
        String expResult = PasswordEncryptor.encryptPassword(password);
        String result = PasswordEncryptor.encryptPassword(password);
        
        assertEquals(expResult, result); //tests if pass hashes the password the same way
        
        assertFalse(result == password); //test if the hashed password is diffrent from the original
    }
    
}
