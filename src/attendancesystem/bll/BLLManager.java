/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.bll;

import attendancesystem.be.User;
import attendancesystem.be.Student;
import attendancesystem.be.Teacher;
import attendancesystem.be.Absence;
import attendancesystem.dal.AbsenceDAO;
import attendancesystem.dal.StudentDAO;
import attendancesystem.dal.TeacherDAO;
import attendancesystem.dal.LoginDAO;
import attendancesystem.dal.db.StudentDbDao;
import attendancesystem.dal.Mock.TeacherMockDAO;
import attendancesystem.dal.db.AbsenceDbDao;
import attendancesystem.dal.db.LoginDbDao;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nijas Hansen
 */
public class BLLManager {

    private TeacherDAO teachDAO;
    private StudentDAO studentDAO;
    private AbsenceDAO absenceDAO;
    private LoginDAO loginDao;


    public BLLManager() throws IOException {
      loginDao = new LoginDbDao();
      teachDAO = new TeacherMockDAO();
      absenceDAO = new AbsenceDbDao();
      studentDAO = new StudentDbDao();

    }

    public List<Student> getAllStudents() throws SQLException, SQLServerException, IOException {
        return studentDAO.getAllStudents();
    }

    public Teacher handleLoginRequestTeacher(String username, String password) throws IOException, SQLException {

        String hashedPassword = PasswordEncryptor.encryptPassword(password);

        return loginDao.handleLoginRequestTeacher(username, hashedPassword);
    }

    public Student handleLoginRequestStudent(String username, String password) throws IOException, SQLException {

        String hashedPassword = PasswordEncryptor.encryptPassword(password);

        return loginDao.handleLoginRequestStudent(username, hashedPassword);
    }

    public ArrayList<Absence> getUndocumentetAbsence(Student user) throws Exception {
        return absenceDAO.getUndocumentetAbsence(user);
    }

    public javafx.scene.chart.PieChart getPieChart(User user) {
        return PieChart.buildPieChard(user, studentDAO);
    }
    
    public boolean updateAbsence(Absence absence) throws Exception{
        return absenceDAO.updateAbsens(absence);
    }
    
    public String sendToDb(String value){
        return value;
    }
    
    public void getAllAbsence(Student student) {
        absenceDAO.getAllAbsence(student);
    }
}
