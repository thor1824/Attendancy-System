/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal;

import attendancesystem.be.Student;
import attendancesystem.be.User;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public interface StudentDAO
{

    void createStudent(User user);

    void deleteStudent(User user);

    List<Student> getAllStudents() throws SQLServerException, SQLException;

    void getStudent(User user);

    void updateStudent(User user);
    
}
