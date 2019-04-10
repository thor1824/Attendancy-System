 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.db.Server;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class ConnectionPool
{

    private static ConnectionPool connectionPool;
    private static Deque<Connection> cPool;

    private ConnectionPool(int startPool) throws SQLServerException, IOException
    {
        cPool = new ArrayDeque<>();
        for (int i = 0; i < startPool; i++)
        {
            cPool.add(ServerConnect.getConnection());
        }
    }

    public static ConnectionPool getInstance() throws SQLServerException, IOException
    {
        if (connectionPool == null)
        {
            connectionPool = new ConnectionPool(30);
        }
        return connectionPool;
    }
    

    public synchronized Connection getConnection() throws SQLServerException, IOException
    {

        if (cPool.isEmpty())
        {
            Connection con = ServerConnect.getConnection();
            cPool.add(con);
            return cPool.poll();
        }
        return cPool.poll();
        
    }

    public synchronized void releaseConnection(Connection con)
    {

        cPool.push(con);
    }
    
    public int size()
    {
        return cPool.size();
    }

}
