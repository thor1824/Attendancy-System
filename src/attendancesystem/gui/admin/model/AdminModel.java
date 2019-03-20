/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.admin.model;

import attendancesystem.be.Student;
import attendancesystem.be.User;
import attendancesystem.bll.BLLManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nijas Hansen
 */
public class AdminModel {
    
    BLLManager bllMan;
    

    public AdminModel() throws IOException
    {
        bllMan = new BLLManager();
    }
    
    
    
    public List<Student> getAllStudents() throws SQLException, SQLServerException, IOException {
        return bllMan.getAllStudents();
    }
   
    public User handleLoginRequestMock(String username, String password)
    {
        try {
            return bllMan.handleLoginRequestTeacher(username, password);
        } catch (IOException ex) {
            Logger.getLogger(AdminModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
//    public User handleLoginRequestReal(String username, String password)
//    {
//        User user = bllMan.handleLoginRequestReal(username, password);
//        return User;
//    }
    
}
