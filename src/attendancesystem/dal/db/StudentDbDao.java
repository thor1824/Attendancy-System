/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.db;

import attendancesystem.dal.db.Server.ServerConnect;
import attendancesystem.dal.StudentDAO;
import attendancesystem.be.Student;
import attendancesystem.be.User;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
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
public class StudentDbDao implements StudentDAO {
    
    private static ServerConnect server;

    public StudentDbDao() throws IOException
    {

        this.server = new ServerConnect();
    }

    

    @Override
    public List<Student> getAllStudents() throws SQLServerException, SQLException
    {
        //to do
        //create connection
        //create prepared Statement
        //get all Students 
        //put in list
        //close connection
        //return list
        
        //christian
        List<Student> students = new ArrayList<>();
        Connection con = server.getConnection();
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
            
            

            
            
            Student student = new Student(userId, StuFName, StuLName, Email, PhoneNumber, Zip, Address, Zip);

            students.add(student);

        }

        return students;
    }

    @Override
    public void deleteStudent(User user)
    {
        //to do
        //create connection
        //create prepared Statement
        //delete Student where userID =="input users ID"
        //check if entry was deletet
        //close connection
        //retrun true if deleted, false if not
        
    }
    
    @Override
    public void getStudent(User user)
    {
        //to do
        //create connection
        //create prepared Statement
        //get Student where userID =="input users ID"
        //close connection
        //retrun Student
        
    }

    @Override
    public void updateStudent(User user)
    {
        //to do
        //create connection
        //create prepared Statement
        //update Student where userID =="input users ID"
        //check if entry was updated
        //close connection
        //retrun true if updated, false if not
    }

    @Override
    public void createStudent(User user)
    {
        //to do
        //create connection
        //create prepared Statement
        //create Student
        //check if entry was created
        //close connection
        //retrun true if created, false if not
    }
}
