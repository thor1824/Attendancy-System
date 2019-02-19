/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.bll;


import attendancesystem.be.User;
import attendancesystem.be.Student;
import attendancesystem.be.Teacher;
import attendancesystem.dal.UserDAO;
import attendancesystem.dal.TeacherDAO;
import java.util.List;

/**
 *
 * @author Nijas Hansen
 */
public class BLLManager{
    
    TeacherDAO teachDAO = new TeacherDAO();
    UserDAO userDao;

    public BLLManager()
    {
        userDao = new UserDAO();
    }
    
    
    
    public List<Student> getAllStudents() {
        return getAllStudents();
    }

    public String getTeacherID(Teacher teacher) {
        return teacher.getTeacherID();
    }

    
    public String getTeacherPassword(Teacher teacher) {
        return teacher.getPassword();
    }

    public Teacher generateTeachers() {
        return teachDAO.generateTeachers();
    }

    public boolean handleLoginRequestMock(String username, String password)
    {
        return userDao.handleLoginRequest(username, password);
    }
    
//    public User handleLoginRequestReal(String username, String password)
//    {
//        new UnsupportedOperationException("not supported yet");
//    }
    
    
    
}
