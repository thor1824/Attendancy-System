/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal;

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
public class StudentDAO {
    
    ServerConnect sc;
    List<Student> students;

  
    public List<Student> getAllStudents() throws SQLServerException, SQLException {
        List<Student> students = new ArrayList<>();
        Connection con = sc.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM [Atendens].[dbo].[Student]");
        
        while (rs.next()) {
            int userId = rs.getInt("UserID");
            int Stuid = rs.getInt("StuID");
            String StuLName = rs.getNString("StuLName");
            String StuFName = rs.getNString("StuFName");
            String PhoneNumber = rs.getNString("Phone");
            String Email= rs.getNString("Email");
            String Address = rs.getNString("Address");
            String Zip = rs.getNString("ZipCode");
            String picURL = rs.getNString("StuPicURL");
            
            

            Student student = new Student(userId, StuLName, Stuid, StuFName, StuFName, StuFName, Email, PhoneNumber, Zip, Address);

            students.add(student);

        }

        return students;
    }
    
    
    public StudentDAO()
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
