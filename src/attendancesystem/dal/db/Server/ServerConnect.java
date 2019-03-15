/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.db.Server;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author Nijas Hansen establishing connection between program and database by
 * using the file "database.settings".
 */
public class ServerConnect
{

    private static final String PROP_FILE = "src/attendancesystem/dal/db/server/database.settings";
    private SQLServerDataSource ds;

    public ServerConnect() throws IOException
    {
        Properties databaseProperties = new Properties();
        databaseProperties.load(new FileInputStream(PROP_FILE));
        ds = new SQLServerDataSource();
        ds.setServerName(databaseProperties.getProperty("Server"));
        ds.setDatabaseName(databaseProperties.getProperty("Database"));
        ds.setUser(databaseProperties.getProperty("User"));
        ds.setPassword(databaseProperties.getProperty("Password"));
    }
    
    /**
     * Get the Connection object to the server
     * 
     * @return
     * @throws SQLServerException 
     */
    public Connection getConnection() throws SQLServerException
    {
        return ds.getConnection();
    }

}
