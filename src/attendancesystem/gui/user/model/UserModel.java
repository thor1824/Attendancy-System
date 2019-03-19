/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.user.model;

import attendancesystem.be.Student;
import attendancesystem.be.Teacher;
import attendancesystem.be.UndocumentetModulAbsence;
import attendancesystem.be.User;
import attendancesystem.bll.BLLManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.chart.PieChart;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class UserModel {

    BLLManager bll;

    BLLManager bllMan;

    public UserModel() {
        try
        {
            bllMan = new BLLManager();
        } catch (IOException ex)
        {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public String calculateDate()
//    {
//
//        return date and time
//    }
    public PieChart getPieChard(User user) {
        return bllMan.getPieChart(user);
    }

    public Student handleLoginRequestStudent(String username, String password) throws IOException, SQLException {
        
            return bllMan.handleLoginRequestStudent(username, password);
        
    }

    public ArrayList<UndocumentetModulAbsence> getUndocumentetAbsence(User user) {
        return bllMan.getUndocumentetAbsence(user);
    }

    public List<Student> getAllStudents() throws SQLException, SQLServerException, IOException {
        return bllMan.getAllStudents();
    }
    
    

}
