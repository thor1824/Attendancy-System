/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.bll;

import attendancesystem.be.Absence;
import attendancesystem.be.Student;
import attendancesystem.be.User;
import attendancesystem.dal.db.AbsenceDbDao;
import attendancesystem.dal.db.StudentDbDao;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian
 */
public class LoginSimolator {

    public StudentDbDao studentDb;
    public AbsenceDbDao ab;

    List<Student> simStudents;
    List<Student> absend;
    List<Student> presend;

    public LoginSimolator() throws IOException, SQLException {
        studentDb = new StudentDbDao();
        addStudentToList();
    }

    /**
     * adds students to a sublist of 5
     *
     * @return a sublist of students
     * @throws SQLException
     * @throws SQLServerException
     * @throws IOException
     */
    public List addStudentToList() throws SQLException, SQLServerException, IOException {
        simStudents = studentDb.getAllStudents().subList(0, 4);

        return simStudents;
    }

    /**
     *
     * @return a random student from the sublist simStudents
     */
    public int getRandomStudent() {
        Random random = new Random();
        int randomNumber = random.nextInt(4);

        Student student = simStudents.get(randomNumber);

        return student.getStuID();
    }

    /**
     * creates absence for each student on the absend list
     *
     * @param absence
     */
    public void absentStudents(Absence absence) {

        for (Student student : absend) {
            try {
                ab.createAbsence(absence, student);
                studentDb.addDaysOfClass(student.getStuID());
            } catch (Exception ex) {
                Logger.getLogger(LoginSimolator.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public boolean studentsPresend() {
        
        try {
            Random rand = new Random();
            int randomNumber = rand.nextInt((347 - 1) + 1) + 1;
            
            return studentDb.addDaysOfClass(randomNumber);
        } catch (IOException ex) {
            Logger.getLogger(LoginSimolator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginSimolator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void setStudentToPresent(Student student) {
        simStudents.remove(student.getStuID());
        presend.add(student);
    }

    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        return dateFormat.format(date);
    }

    public void runOnTime() {
        Timer timer = new Timer();
        Calendar dato = Calendar.getInstance();
        dato.set(
                Calendar.MONDAY,
                Calendar.TUESDAY,
                Calendar.WEDNESDAY,
                Calendar.THURSDAY,
                Calendar.FRIDAY);
        dato.set(Calendar.HOUR, 0);
        dato.set(Calendar.MINUTE, 0);
        dato.set(Calendar.SECOND, 0);
        dato.set(Calendar.MILLISECOND, 0);
        timer.schedule(new TimeKeeper(), dato.getTime(), 1000 * 60 * 60 * 24 * 7);
    }
}
