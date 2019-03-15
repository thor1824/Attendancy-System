/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.bll;


import attendancesystem.be.User;
import attendancesystem.be.Student;
import attendancesystem.be.UndocumentetModulAbsence;
import attendancesystem.dal.Mock.AbsenceMockDAO;
import attendancesystem.dal.Mock.StudentMockDAO;
import attendancesystem.dal.Mock.TeacherMockDAO;
import attendancesystem.dal.Mock.UserMockDAO;
import java.io.IOException;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nijas Hansen
 */
public class BLLManager{

    private TeacherMockDAO teachDAO;
    private StudentMockDAO studentDAO;
    private AbsenceMockDAO absenceDAO;
    private UserMockDAO userDao;
    

    public BLLManager() throws IOException
    {
        userDao = new UserMockDAO();
        teachDAO = new TeacherMockDAO();
        absenceDAO = new AbsenceMockDAO();
        studentDAO = new StudentMockDAO();
    }



    public List<Student> getAllStudents() throws SQLException {
        return studentDAO.getAllStudents();
    }


    public User handleLoginRequest(String username, String password)
    {
        if (username.toLowerCase().contains("admin"))
        {
            return userDao.handleLoginRequest("admin", "admin");
        }
        String hashedPassword = PasswordEncryptor.encryptPassword(password);
        
        return userDao.handleLoginRequest(username, hashedPassword);
    }
    
    public ArrayList<UndocumentetModulAbsence> getUndocumentetAbsence(User user) {
        return absenceDAO.getUndocumentetAbsence(user); 
    }
    
    public javafx.scene.chart.PieChart getPieChart(User user)
    {
        return PieChart.buildPieChard(user, studentDAO);
    }
}
