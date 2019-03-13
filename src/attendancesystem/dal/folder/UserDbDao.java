/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.folder;

import attendancesystem.be.User;
import attendancesystem.dal.ServerConnect;
import java.io.IOException;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class UserDbDao
{
    private static ServerConnect server;
    
    public UserDbDao() throws IOException {

        this.server = new ServerConnect();
    }
    
    
    public User handleLoginRequest(String username, String password)
    {
        //to do
        //connect to server
        //create prepared Statement 
        //get password where username == input username
        //check if user exist
        //if exist check if password == input password
        
        return null;
    }
}
