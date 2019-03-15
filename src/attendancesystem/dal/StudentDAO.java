/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal;

import attendancesystem.be.Student;
import attendancesystem.be.User;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public interface StudentDAO
{


//    public List<Student> getAllStudents() throws SQLServerException, SQLException {
//        List<Student> students = new ArrayList<>();
//        Connection con = sc.getConnection();
//        Statement st = con.createStatement();
//
//        String sql = "SELECT * FROM [Atendens].[dbo].[Student] VALUES (?)(?)(?)(?)(?)(?)(?)(?)(?)";
//        PreparedStatement prSt = con.prepareStatement(sql);
//        ResultSet rs = prSt.executeQuery();
//
//        while (rs.next()) {
//            int userId = rs.getInt(1);
//            int Stuid = rs.getInt(2);
//            String StuLName= rs.getString(3);
//            String StuFName = rs.getString(4);
//            String PhoneNumber = rs.getNString("Phone");
//            String Email= rs.getNString("Email");
//            String Address = rs.getNString("Address");
//            String Zip = rs.getNString("ZipCode");
//            String picURL = rs.getNString("StuPicURL");
//
//
//
//            Student student = new Student(userId, StuLName, Stuid, StuFName, StuFName, StuFName, Email, PhoneNumber, Zip, Address);
//
//            students.add(student);
//
//        }
//
//        return students;
//    }


    public StudentDAO()
    {
        students = new ArrayList<>();
        //Create mockdata here
    }

    void createStudent(User user);

    void deleteStudent(User user);

    List<Student> getAllStudents() throws SQLServerException, SQLException;

    void getStudent(User user);

    void updateStudent(User user);

}
