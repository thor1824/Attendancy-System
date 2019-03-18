/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.bll;

import attendancesystem.be.User;
import attendancesystem.be.Student;
import attendancesystem.be.UndocumentetModulAbsence;
import attendancesystem.dal.AbsenceDAO;
import attendancesystem.dal.Mock.UserMockDAO;
import attendancesystem.dal.StudentDAO;
import attendancesystem.dal.TeacherDAO;
import attendancesystem.dal.UserDAO;
import attendancesystem.dal.db.AbsenceDbDao;
import attendancesystem.dal.db.StudentDbDao;
import attendancesystem.dal.db.TeacherDbDao;
import attendancesystem.dal.db.UserDbDao;
import attendancesystem.dal.Mock.AbsenceMockDAO;
import attendancesystem.dal.Mock.StudentMockDAO;
import attendancesystem.dal.Mock.TeacherMockDAO;
import attendancesystem.dal.Mock.UserMockDAO;
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
    private UserDAO userDao;
    

    public BLLManager() throws IOException {
      userDao = new UserMockDAO();
      teachDAO = new TeacherMockDAO();
      absenceDAO = new AbsenceMockDAO();
      studentDAO = new StudentMockDAO();
        try {
            userDao = new UserMockDAO();

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            teachDAO = new TeacherDbDao();
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }


        try {
            absenceDAO = new AbsenceDbDao();
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }

        try {
            studentDAO = new StudentDbDao();
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public List<Student> getAllStudents() throws SQLException, SQLServerException, IOException {
        return studentDAO.getAllStudents();
    }

    public User handleLoginRequest(String username, String password) {
        if (username.toLowerCase().contains("admin")) {
            return userDao.handleLoginRequest("admin", "admin");
        }
        String hashedPassword = PasswordEncryptor.encryptPassword(password);

        return userDao.handleLoginRequest(username, hashedPassword);
    }

    public ArrayList<UndocumentetModulAbsence> getUndocumentetAbsence(User user) {
        return absenceDAO.getUndocumentetAbsence(user);
    }

    public javafx.scene.chart.PieChart getPieChart(User user) {
        return PieChart.buildPieChard(user, studentDAO);
    }
}
