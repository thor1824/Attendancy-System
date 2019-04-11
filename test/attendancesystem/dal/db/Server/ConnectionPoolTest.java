/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.db.Server;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class ConnectionPoolTest {
    
    public ConnectionPoolTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getInstance method, of class ConnectionPool.
     */
    @Test
    public void testGetInstance() throws Exception {
        System.out.println("getInstance");
        ConnectionPool expResult1 = ConnectionPool.getInstance();
        ConnectionPool result1 = ConnectionPool.getInstance();
        System.out.println(expResult1);
        System.out.println(result1);
        assertEquals(expResult1.toString(), result1.toString());
        
    }

    /**
     * Test of getConnection method, of class ConnectionPool.
     */
    @Test
    public void testGetAndReleaseConnection() throws Exception {
        System.out.println("getConnection");
        ConnectionPool instance = ConnectionPool.getInstance();
        Connection con = instance.getConnection();
        
        assertFalse(con == null);
        
        int beforePull = 30;
        
        int AfterPull = 29;
        
        assertFalse(instance.size() == beforePull);
        
        
        assertEquals(AfterPull, instance.size());
        int afterReleasePull = 30;
        instance.releaseConnection(con);
        assertEquals(afterReleasePull, instance.size());
        
    }

    /**
     * Test of releaseConnection method, of class ConnectionPool.
     */
    @Test
    public void testReleaseConnection() throws SQLServerException, IOException {
        System.out.println("releaseConnection");
        ConnectionPool instance = ConnectionPool.getInstance();
        Connection con = instance.getConnection();
        
        assertFalse(con == null);
        
        
        int afterPull = 29;
        int afterReleasePull = 30;
        
        assertEquals(afterPull, instance.size());
        
        instance.releaseConnection(con);
        
        assertEquals(afterReleasePull, instance.size());
    }
    
}
