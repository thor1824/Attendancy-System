/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal;

import attendancesystem.be.Student;
import attendancesystem.be.Teacher;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public interface LoginDAO
{

    public Student handleLoginRequestStudent(String username, String encrypytedPassword) throws SQLServerException, IOException, SQLException; 
            
    public Teacher handleLoginRequestTeacher(String username, String encrypytedPassword) throws SQLServerException, IOException, SQLException;
    
}
