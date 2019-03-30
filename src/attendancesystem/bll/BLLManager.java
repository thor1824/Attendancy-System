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
import java.util.List;

/**
 *
 * @author Nijas Hansen
 */
public class BLLManager
{

    private TeacherDAO teachDao;
    private StudentDAO studentDao;
    private AbsenceDAO absenceDao;
    private LoginDAO loginDao;

    public BLLManager() throws IOException
    {
        loginDao = new LoginDbDao();
        teachDao = new TeacherMockDAO();
        absenceDao = new AbsenceDbDao();
        studentDao = new StudentDbDao();

    }

    public List<Student> getAllStudents() throws Exception
    {
        return studentDao.getAllStudents();
    }

    public Teacher handleLoginRequestTeacher(String username, String password) throws IOException, SQLException
    {

        String hashedPassword = PasswordEncryptor.encryptPassword(password);

        return loginDao.handleLoginRequestTeacher(username, hashedPassword);
    }

    public Student handleLoginRequestStudent(String username, String password) throws IOException, SQLException
    {

        String hashedPassword = PasswordEncryptor.encryptPassword(password);

        return loginDao.handleLoginRequestStudent(username, hashedPassword);
    }

    public List<Absence> getUndocumentetAbsence(Student user) throws Exception
    {
        return absenceDao.getUndocumentetAbsence(user);
    }

    public List<Absence> getDocumentetAbsence(Student user) throws Exception
    {
        return absenceDao.getDocumentetAbsence(user);
    }

    public javafx.scene.chart.PieChart getPieChart(Student student) throws Exception
    {
        return PieChart.buildPieChard(student, absenceDao, studentDao);
    }

    public boolean updateAbsence(Absence absence) throws Exception
    {
        return absenceDao.updateAbsence(absence);
    }

    public String sendToDb(String value)
    {
        return value;
    }

    public List<Absence> getAllAbsence(Student student) throws Exception
    {
        return absenceDao.getAllAbsence(student);
    }

    public List<Absence> getAllRequestAbence(Teacher teacher) throws Exception
    {
        return absenceDao.getAllRequestAbence(teacher);
    }

    public boolean makeAbsenceRequest(Absence absence) throws Exception
    {
        return absenceDao.makeAbsenceRequest(absence);
    }

    public boolean approveRequest(Absence absence) throws Exception
    {
        return absenceDao.approveRequest(absence);
    }

    public boolean declineAbsenceRequest(Absence absence) throws Exception
    {
        return absenceDao.declineAbsenceRequest(absence);
    }
}
