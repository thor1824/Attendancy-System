/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.Mock;

import attendancesystem.dal.db.Server.ServerConnect;
import attendancesystem.be.Student;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Nijas Hansen
 */
public class StudentMockDAO {
    
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
}
