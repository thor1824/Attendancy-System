/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal;

import java.util.HashMap;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class UserDAO
{
    HashMap<String, String> users; 
    public UserDAO()
    {
        users = new HashMap<>();
        users.put("bob", "6666");
        users.put("john", "7777");
        users.put("peter", "123123");
        users.put("jeppe", "asdfg");
    }
    
    
    public boolean handleLoginRequest(String username, String password)
    {
       if (users.containsKey(username))
       {
           String pw = users.get(username);
           if (pw.equals(password))
           {
               
               return true;
           }
           else
           {
               System.out.println("user exits but not the right password");
               return false;
           }
       }
       else
       {
           return false;
       }
    }
    
}
