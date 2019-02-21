/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.admin.model;

import attendancesystem.be.Student;
import attendancesystem.be.User;
import attendancesystem.bll.BLLManager;
import java.util.List;

/**
 *
 * @author Nijas Hansen
 */
public class AdminModel {
    
    BLLManager bllMan = new BLLManager();
    
    public List<Student> getAllStudents() {
        return bllMan.getAllStudents();
    }
   
    public User handleLoginRequestMock(String username, String password)
    {
        return bllMan.handleLoginRequest(username, password);
    }
    
//    public User handleLoginRequestReal(String username, String password)
//    {
//        User user = bllMan.handleLoginRequestReal(username, password);
//        return User;
//    }
    
}
