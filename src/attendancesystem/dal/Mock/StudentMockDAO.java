/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.Mock;

import attendancesystem.dal.db.Server.ServerConnect;
import attendancesystem.be.Student;
import attendancesystem.dal.StudentDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    public List<Student> getStudentsFromClass(String className) throws SQLServerException, SQLException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createStudent(Student user, String username, String password) throws SQLServerException, SQLException, FileNotFoundException, IOException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteStudent(Student user) throws SQLServerException, SQLException, FileNotFoundException, IOException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student getStudent(int id) throws SQLServerException, SQLException, FileNotFoundException, IOException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateStudent(Student user) throws SQLServerException, SQLException, FileNotFoundException, IOException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setUserImage(Student user, String picURL) throws SQLServerException, SQLException, FileNotFoundException, IOException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
