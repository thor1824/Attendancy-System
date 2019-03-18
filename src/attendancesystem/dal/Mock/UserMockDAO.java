/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.Mock;


import attendancesystem.be.Teacher;
import attendancesystem.be.User;
import attendancesystem.dal.UserDAO;
import java.util.HashMap;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class UserMockDAO implements UserDAO
{
    public HashMap<String, User> users; 
    public UserMockDAO()
    {
        users = new HashMap<>();
        users.put("admin", new Teacher(1, "admin", "Peter Stegger", "Peter.Stegger@email.com", "2222222", "111111-1111", 0, "ribe", "6666", "pic"));
        
        
    }
    
    @Override
    public User handleLoginRequest(String username, String password)
    {
        System.out.println("hej");
       if (users.containsKey(password))
       {
           User user = users.get(password);
           if (username.equals("admin"))
           {
               
               return user;
           }
           else
           {
               System.out.println("user exits but not the right password");
               return null;
           }
       }
       else
       {
           return null;
       }
    }
    
}
