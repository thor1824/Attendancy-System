/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal;

import attendancesystem.be.Student;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public interface StudentDAO
{
    boolean createStudent(Student user, String username, String password) throws SQLServerException, SQLException, FileNotFoundException, IOException;

    boolean deleteStudent(Student user) throws SQLServerException, SQLException, FileNotFoundException, IOException;

    List<Student> getAllStudents() throws SQLServerException, SQLException, FileNotFoundException, IOException;
    
    List<Student> getStudentsFromClass(String className) throws SQLServerException, SQLException, FileNotFoundException, IOException;

    Student getStudent(int id) throws SQLServerException, SQLException, FileNotFoundException, IOException;

    boolean updateStudent(Student user) throws SQLServerException, SQLException, FileNotFoundException, IOException;
    
    boolean setUserImage(Student user, String picURL) throws SQLServerException, SQLException, FileNotFoundException, IOException;

}
