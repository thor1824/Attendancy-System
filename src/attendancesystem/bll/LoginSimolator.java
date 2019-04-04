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

//    public LoginSimolator(StudentDbDao studentDb, AbsenceDbDao ab, List<Student> simStudents, List<Student> absend, List<Student> presend) {
//        this.studentDb = studentDb;
//        this.ab = ab;
//        this.simStudents = simStudents;
//        this.absend = absend;
//        this.presend = presend;
//    }
    public List addStudentToList() throws SQLException, SQLServerException, IOException {

        simStudents = studentDb.getAllStudents().subList(0, 4);

        return simStudents;
    }

    /**
     *
     * @returns a random student from the sublist simStudents
     */
    public User getRandomStudent() {
        Random random = new Random();
        int randomNumber = random.nextInt(5);

        User student = simStudents.get(randomNumber);

        return student;
    }

    public User setUserByTime() {
        //todo

        Random rand = new Random();
        int randomNumber = rand.nextInt(5);

        User user = simStudents.get(randomNumber);

        return null;
    }

    public void absentStudents(Absence absence) {

        for (Student student : absend) {
            try {
                ab.createAbsence(absence, student);
                studentDb.addDaysOfClass(student);
            } catch (Exception ex) {
                Logger.getLogger(LoginSimolator.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void studentsPresend() {
        for (Student student : presend) {
            try {
                studentDb.addDaysOfClass(student);
            } catch (IOException ex) {
                Logger.getLogger(LoginSimolator.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(LoginSimolator.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
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

//    public void runOnTime() {
//        Timer timer = new Timer();
//        Calendar dato = Calendar.getInstance();
//        dato.set(
//                Calendar.DAY_OF_WEEK,
//                Calendar.MONDAY,
//                Calendar.TUESDAY,
//                Calendar.WEDNESDAY,
//                Calendar.THURSDAY,
//                Calendar.FRIDAY);
//
//        dato.set(Calendar.HOUR, 0);
//        dato.set(Calendar.MINUTE, 0);
//        dato.set(Calendar.SECOND, 0);
//        dato.set(Calendar.MILLISECOND, 0);
//
//        timer.schedule(new TimeKeeper(), dato.getTime().);
//        timer.
//    }
}
