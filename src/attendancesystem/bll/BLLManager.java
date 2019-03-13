/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.bll;


import attendancesystem.be.User;
import attendancesystem.be.Student;
import attendancesystem.be.UndocumentetModulAbsence;
import attendancesystem.dal.UserDAO;
import attendancesystem.dal.AbsenceDAO;
import attendancesystem.dal.TeacherDAO;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 *
 * @author Nijas Hansen
 */
public class BLLManager{

    TeacherDAO teachDAO;
    AbsenceDAO absenceDAO;
    UserDAO userDao;
    PasswordEncryptor passEnc;

    public BLLManager()
    {
        userDao = new UserDAO();
        teachDAO = new TeacherDAO();
        absenceDAO = new AbsenceDAO();
        passEnc = new PasswordEncryptor();
    }



    public ArrayList<Student> getAllStudents() {
        return getAllStudents();
    }


    public User handleLoginRequest(String username, String password)
    {
        String hashedPassword;
        
        hashedPassword = passEnc.encryptPassword(password);
        
        System.out.println(hashedPassword);
        
        return userDao.handleLoginRequest(username, hashedPassword);
    }
    
    public ArrayList<UndocumentetModulAbsence> getUndocumentetAbsence(User user) {
        return absenceDAO.getUndocumentetAbsence(user); 
    }

    public PieChart buildPieChard() {
        ObservableList<PieChart.Data> pieChard = FXCollections.observableArrayList(
                new PieChart.Data("Timer", 100),
                new PieChart.Data("Fravær", 10));

        PieChart pie = new PieChart(pieChard);
        return pie;
    }


}