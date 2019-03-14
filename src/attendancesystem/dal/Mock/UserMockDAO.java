/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.Mock;


import attendancesystem.be.Teacher;
import attendancesystem.be.User;
import java.util.HashMap;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class UserMockDAO
{
    HashMap<String, User> users; 
    public UserMockDAO()
    {
        users = new HashMap<>();
        users.put("admin", new Teacher(1, "admin", "Peter Stegger", "Peter.Stegger@email.com", "2222222", "111111-1111"));
        users.put("7777", new Teacher(2, "sti1111", "Stig Stegger", "Stig.Stegger@email.com", "3333333", "222222-2222"));
        users.put("123123", new Teacher(3, "jeb1111", "Jebbe Stegger", "Jebbe.Stegger@email.com", "4444444", "333333-3333"));
        users.put("asdfg", new Teacher(4, "tre1111", "Ties Stegger", "Ties.Stegger@email.com", "5555555", "444444-4444"));
        users.put("1", new Teacher(5, "test", "test", "test@email.com", "5555555", "444444-4444"));
    }
    
    
    public User handleLoginRequest(String username, String password)
    {
        System.out.println("hej");
       if (users.containsKey(password))
       {
           User user = users.get(password);
           if (username.equals(user.getUserName()))
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
