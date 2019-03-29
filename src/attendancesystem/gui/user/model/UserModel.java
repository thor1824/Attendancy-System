/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.user.model;

import attendancesystem.be.Student;
import attendancesystem.be.Absence;
import attendancesystem.bll.BLLManager;
import attendancesystem.dal.db.AbsenceDbDao;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.chart.PieChart;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class UserModel
{

    BLLManager bllMan;

    AbsenceDbDao absenceDbDao;

    Student logedInStudent;

    public UserModel()
    {
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
    public PieChart getPieChard(Student student)
    {
        try
        {
            return bllMan.getPieChart(student);
        } catch (Exception ex)
        {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Student handleLoginRequest(String username, String password)
    {
        try
        {
            return bllMan.handleLoginRequestStudent(username, password);
        } catch (IOException ex)
        {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex)
        {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Absence> getUndocumentetAbsence(Student user) throws Exception
    {
        return bllMan.getUndocumentetAbsence(user);
    }

    public List<Student> getAllStudents() throws SQLException, SQLServerException, IOException
    {
        return bllMan.getAllStudents();
    }

    public void setLogedInStudent(Student logedInStudent)
    {
        this.logedInStudent = logedInStudent;
    }

    public Student getLogedInStudent()
    {
        return logedInStudent;
    }

    public List<Absence> getAllAbsence(Student student) throws Exception
    {
        return bllMan.getAllAbsence(student);
    }

    public boolean updateAbsence(Absence absnece) throws Exception
    {
        return bllMan.updateAbsence(absnece);
    }

    public boolean makeAbsenceRequest(Absence absence) throws Exception
    {
        return bllMan.makeAbsenceRequest(absence);
    }

}
