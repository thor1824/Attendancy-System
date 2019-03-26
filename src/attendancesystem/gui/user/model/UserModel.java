/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.user.model;

import attendancesystem.be.Student;
import attendancesystem.be.Absence;
import attendancesystem.be.User;
import attendancesystem.bll.BLLManager;
import attendancesystem.dal.db.AbsenceDbDao;
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
    
    AbsenceDbDao aDD;
    
    Student logedInStudent;

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

    public Student handleLoginRequest(String username, String password) {
        try {
            return bllMan.handleLoginRequestStudent(username, password);
        } catch (IOException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Absence> getUndocumentetAbsence(Student user) throws Exception {
        return bllMan.getUndocumentetAbsence(user);
    }

    public List<Student> getAllStudents() throws SQLException, SQLServerException, IOException {
        return bllMan.getAllStudents();
    }

    public void setLogedInStudent(Student logedInStudent) {
        this.logedInStudent = logedInStudent;
    }

    public Student getLogedInStudent() {
        return logedInStudent;
    }
    
    
    public ArrayList<Absence> getAllAbsence() throws IOException, SQLException{
        return aDD.getAllAbsens(logedInStudent);
    }
    
    

}
