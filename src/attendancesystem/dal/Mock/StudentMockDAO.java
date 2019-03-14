/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.Mock;

import attendancesystem.dal.db.Server.ServerConnect;
import attendancesystem.be.Student;
import attendancesystem.be.User;
import attendancesystem.dal.StudentDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Nijas Hansen
 */
public class StudentMockDAO implements StudentDAO{
    
    ServerConnect sc;
    List<Student> students;

  
    public List<Student> getAllStudents() throws SQLServerException, SQLException {
        return null;
    }
    
    
    public StudentMockDAO()
    {
        students = new ArrayList<>();
        //Create mockdata here
    }
    
//    public ArrayList<Student> getAllStudents() {
//        ArrayList<Student> students = new ArrayList<>();
//        
//        return students;
//    }

    @Override
    public void createStudent(User user)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteStudent(User user)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getStudent(User user)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateStudent(User user)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
