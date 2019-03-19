/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.Mock;


import attendancesystem.be.Student;
import attendancesystem.be.Teacher;
import attendancesystem.be.User;
import attendancesystem.dal.LoginDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class UserMockDAO implements LoginDAO
{
    public HashMap<String, User> users; 
    public UserMockDAO()
    {
        users = new HashMap<>();
        users.put("admin", new Teacher(1, "admin", "Peter Stegger", "Peter.Stegger@email.com", "2222222", "111111-1111", 0, "ribe", "6666", "pic"));
        
        
    }
    
    
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

    @Override
    public Student handleLoginRequestStudent(String username, String encrypytedPassword) throws SQLServerException, IOException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Teacher handleLoginRequestTeacher(String username, String encrypytedPassword) throws SQLServerException, IOException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
