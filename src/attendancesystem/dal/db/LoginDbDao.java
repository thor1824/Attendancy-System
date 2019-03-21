/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.db;

import attendancesystem.be.Student;
import attendancesystem.be.Teacher;
import attendancesystem.dal.LoginDAO;
import attendancesystem.dal.db.Server.ServerConnect;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class LoginDbDao implements LoginDAO
{

    @Override
    public Student handleLoginRequestStudent(String username, String encrypytedPassword) throws SQLServerException, IOException, SQLException {
        String sql = "SELECT * FROM [Atendens].[dbo].[Login] "
                + "JOIN [Atendens].[dbo].[Student] "
                + "ON Login.UserId = Student.UserID "
                + "JOIN [Atendens].[dbo].[Class] "
                + "ON Student.ClassID = Class.ClassID "
                + "WHERE Username = ? and Password = ?;";
        
        Connection con = ServerConnect.getConnection(); //create connection
        PreparedStatement ps = con.prepareStatement(sql); //create prepared Statement
        ps.setString(1, username);
        ps.setString(2, encrypytedPassword);
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            int id = rs.getInt("StuID");
            String fname = rs.getNString("StuFName");
            String lname = rs.getNString("StuLName");
            String email = rs.getNString("Email");
            String phone = rs.getNString("Phone");
            String cpr = rs.getNString("Cpr");
            String adress = rs.getNString("Adress");
            String zipCode = rs.getNString("ZipCode");
            String sClass = rs.getNString("ClassName");
            String picUrl = rs.getNString("StuPicUrl");
            return new Student(id, fname, lname, email, phone, cpr, adress, zipCode, sClass, picUrl);
        }
        return null;
    }

    @Override
    public Teacher handleLoginRequestTeacher(String username, String encrypytedPassword)  throws SQLServerException, IOException, SQLException{
        String sql = "SELECT * FROM [Atendens].[dbo].[Login] "
                + "JOIN [Atendens].[dbo].[Teacher] "
                + "on Login.UserId = Teacher.UserID "
                + "WHERE Username = ? and Password = ?;";
        
        Connection con = ServerConnect.getConnection(); //create connection
        PreparedStatement ps = con.prepareStatement(sql); //create prepared Statement
        ps.setString(1, username);
        ps.setString(2, encrypytedPassword);
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            int id = rs.getInt("TeachID");
            String fname = rs.getNString("TeachFName");
            String lname = rs.getNString("TeachLName");
            String email = rs.getNString("Email");
            String phone = rs.getNString("Phone");
            String cpr = rs.getNString("Cpr");
            String adress = rs.getNString("Adress");
            String zip = rs.getNString("ZipCode");
            String picUrl = rs.getNString("TeachPicUrl");
            int acces = rs.getInt("AccesLvl");
            return new Teacher(id, fname, lname, email, phone, cpr, acces, adress, zip, picUrl);
        }
        return null;
    }

    
    
    
    
    
}
