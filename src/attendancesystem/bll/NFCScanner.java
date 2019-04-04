/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.bll;

import attendancesystem.be.Absence;
import attendancesystem.be.Student;
import attendancesystem.dal.db.AbsenceDbDao;
import attendancesystem.dal.db.StudentDbDao;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian
 */
public class NFCScanner {

    public StudentDbDao studentDb;
    public AbsenceDbDao ab;

    List<Student> simStudents;
    List<Student> absend;
    List<Student> presend;

    public NFCScanner() throws IOException, SQLException {
        studentDb = new StudentDbDao();
        
    }

    
    
    public void absentStudents(Absence absence) {

        for (Student student : absend) {
            try {
                ab.createAbsence(absence, student);
                studentDb.addDaysOfClass(student.getStuID());
            } catch (Exception ex) {
                Logger.getLogger(NFCScanner.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public boolean studentsPresend() {

        try {
            Random rand = new Random();
            int randomNumber = rand.nextInt((347 - 1) + 1) + 1;

            return studentDb.addDaysOfClass(randomNumber);
        } catch (IOException ex) {
            Logger.getLogger(NFCScanner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NFCScanner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void setStudentToPresent(Student student) {
        simStudents.remove(student.getStuID());
        presend.add(student);
    }
}
