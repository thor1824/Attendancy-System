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
import java.util.Date;
import java.util.List;
import java.util.Random;
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

    public LoginSimolator(StudentDbDao studentDb, AbsenceDbDao ab, List<Student> simStudents, List<Student> absend, List<Student> presend) {
        this.studentDb = studentDb;
        this.ab = ab;
        this.simStudents = simStudents;
        this.absend = absend;
        this.presend = presend;
    }
    
    

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
        LocalDate locDate = LocalDate.now();

        User user = simStudents.get(randomNumber);
        
        return null;
    }
    
    public void absentStudents(Absence absence){
        
        for (Student student : absend) {
            try {
                ab.createAbsence(absence, student);
                studentDb.addDaysOfClass(student);
            } catch (Exception ex) {
                Logger.getLogger(LoginSimolator.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    public void studentsPresend() throws IOException, SQLException{
        for (Student student : presend) {
            studentDb.addDaysOfClass(student);
            
        }
    }
    
    public void setAbsendStudentToPresent(Student student){
        simStudents.remove(student.getStuID());
        presend.add(student);
    }

    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        return dateFormat.format(date);
    }
}
