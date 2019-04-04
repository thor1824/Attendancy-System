/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.user.model;

import attendancesystem.be.Student;
import attendancesystem.be.Absence;
import attendancesystem.bll.BLLManager;
import attendancesystem.bll.facade.IBuisness;
import java.util.ArrayList;
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

    IBuisness bllMan;
    Student logedInStudent;

    public UserModel()
    {

        bllMan = new BLLManager();

    }

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
        } catch (Exception ex)
        {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Absence> getUndocumentetAbsence(Student user)
    {
        List<Absence> undocAbsences = new ArrayList<>();
        try
        {
            undocAbsences = bllMan.getUndocumentetAbsence(user);
        } catch (Exception ex)
        {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return undocAbsences;
    }

    public List<Absence> getDocumentetAbsence(Student student)
    {
        List<Absence> docAbsences = new ArrayList<>();
        try
        {
            docAbsences = bllMan.getDocumentetAbsence(student);
        } catch (Exception ex)
        {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return docAbsences;
    }

    public void setLogedInStudent(Student logedInStudent)
    {
        this.logedInStudent = logedInStudent;
    }

    public Student getLogedInStudent()
    {
        return logedInStudent;
    }

    public List<Absence> getAllAbsence(Student student)
    {
        List<Absence> Absences = new ArrayList<>();
        try
        {
            Absences = bllMan.getAllAbsence(student);
        } catch (Exception ex)
        {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Absences;
    }

    public boolean updateAbsence(Absence absnece)
    {
        boolean updated = false;
        try
        {
            updated = bllMan.updateAbsence(absnece);
        } catch (Exception ex)
        {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return updated;
    }

    public boolean makeAbsenceRequest(Absence absence)
    {
        boolean isRequested = false;
        try
        {
            isRequested = bllMan.makeAbsenceRequest(absence);
        } catch (Exception ex)
        {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isRequested;
    }

   
    public boolean scan()
    {
        return bllMan.scan();
    }

}
