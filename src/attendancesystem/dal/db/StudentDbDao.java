/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.db;

import attendancesystem.dal.db.Server.ServerConnect;
import attendancesystem.dal.StudentDAO;
import attendancesystem.be.Student;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nijas Hansen
 */
public class StudentDbDao implements StudentDAO
{

    private static ServerConnect server;

    public StudentDbDao() throws IOException
    {

    }

    @Override
    public List<Student> getAllStudents() throws SQLServerException, SQLException, IOException
    {
        String sql = "SELECT * FROM [Atendens].[dbo].[Student] "
                + "join [Atendens].[dbo].[Class] on Class.ClassID = Student.ClassID;";

        Connection con = ServerConnect.getConnection(); //create connection

        PreparedStatement ps = con.prepareStatement(sql); //create prepared Statement
        ResultSet rs = ps.executeQuery(); //get all Students
        ArrayList<Student> students = new ArrayList<>();
        while (rs.next())
        {
            int stuID = rs.getInt("StuID");
            int Days_of_classes = rs.getInt("Days_of_classes");
            String stuLName = rs.getNString("StuLName");
            String stuFName = rs.getNString("StuFName");
            String stuClass = rs.getNString("ClassName");
            String stuPhone = rs.getNString("Phone");
            String stuEmail = rs.getNString("Email");
            String stuAdress = rs.getNString("Adress");
            String stuZip = rs.getNString("ZipCode");
            String stuCPR = rs.getNString("Cpr");
            String stuPicUrl = rs.getNString("StuPicURL");


            Student stu = new Student(stuID, stuFName, stuLName, stuEmail, stuPhone, stuCPR, stuAdress, stuZip, stuClass, stuPicUrl, Days_of_classes);
            //put Student in list
            students.add(stu);
        }

        //close connection
        con.close();

        return students;

    }

    @Override
    public boolean createStudent(Student student, String username, String encruptedPassword) throws SQLServerException, IOException, SQLException
    {
        String sqlSetLogin = "INSERT INTO [Atendens].[dbo].[Login] (Username, Password) "
                + "VALUES (?, ?);";
        String sqlSetStudent = "INSERT INTO [Atendens].[dbo].[Student] (UserID, StuLName, StuFName, ClassID, Phone, Email, Adress, ZipCode, Cpr) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        String sqlGetClass = "SELECT ClassID FROM [Atendens].[dbo].[Class] "
                + "WHERE ClassName = '" + student.getSchoolClass()+ "' ;";

        Connection con = ServerConnect.getConnection(); //create connection

        PreparedStatement psLogin = con.prepareStatement(sqlSetLogin, Statement.RETURN_GENERATED_KEYS); //create prepared Statement for Login
        psLogin.setNString(1, username);
        psLogin.setNString(2, encruptedPassword);

        if (psLogin.executeUpdate() != 0)
        {
            PreparedStatement psClass = con.prepareStatement(sqlGetClass);
            ResultSet rsClass = psClass.executeQuery();
            if (rsClass.next())
            {

                int userID = 0;
                ResultSet rsUserID = psLogin.getGeneratedKeys(); //extracts the auto generated key from Student tabel
                while (rsUserID.next())
                {
                    userID = rsUserID.getInt(1);
                }
                PreparedStatement psStudent = con.prepareStatement(sqlSetStudent, Statement.RETURN_GENERATED_KEYS); //create prepared Statement for Student
                psStudent.setInt(1, userID);
                psStudent.setNString(2, student.getLastName());
                psStudent.setNString(3, student.getFirstName());
                psStudent.setInt(4, rsClass.getInt(1));
                psStudent.setNString(5, student.getPhoneNr());
                psStudent.setNString(6, student.getEmail());
                psStudent.setNString(7, student.getAdresse());
                psStudent.setNString(8, student.getZipCode());
                psStudent.setNString(9, student.getCpr());

                int lineAffected = psStudent.executeUpdate();

                ResultSet rsStuID = psStudent.getGeneratedKeys();

                if (rsStuID.next())
                {
                    student.setUserID(rsStuID.getInt(1));
                    con.close(); //close connection
                    return lineAffected != 0; //create Student and return true if created, false if not
                }

            }
            con.close();
            return false; // return false because something failed
        }

        con.close();
        return false; // return false because something failed
    }

    @Override
    public boolean deleteStudent(Student student) throws SQLServerException, IOException, SQLException
    {
        String sql = "";
        Connection con = ServerConnect.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        //to do
        //create connection
        //create prepared Statement
        //delete Student where userID =="input users ID"
        //check if entry was deletet
        //close connection

        int lineAffected = ps.executeUpdate();
        con.close();
        return lineAffected != 0; //return true if deleted, false if not
    }

    @Override
    public Student getStudent(int id) throws SQLServerException, IOException, SQLException
    {
        String sql = "";
        int days_of_classes = 0;
        Connection con = ServerConnect.getConnection(); //create connection
        PreparedStatement ps = con.prepareStatement(sql); //create prepared Statement
        ResultSet rs = ps.executeQuery(); //get Student where userID =="input users ID"

        while (rs.next()) //does not enter if no student is found
        {

            con.close();
            return new Student(id, sql, sql, sql, sql, sql, sql, sql, sql, sql, days_of_classes);
        }
        con.close();

        //close connection
        //retrun Student
        return null;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLServerException, IOException, SQLException
    {
        String sql = "";
        Connection con = ServerConnect.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        //to do
        //create connection
        //create prepared Statement
        //update Student where userID =="input users ID"
        //check if entry was updated
        //close connection
        //retrun true if updated, false if not
        int lineAffected = ps.executeUpdate();
        con.close();
        return lineAffected != 0; //return true if deleted, false if not
    }

    @Override
    public List<Student> getStudentsFromClass(String className) throws SQLServerException, IOException, SQLException
    {
        String sql = "";
        Connection con = ServerConnect.getConnection(); //create connection
        PreparedStatement ps = con.prepareStatement(sql); //create prepared Statement

        ArrayList<Student> students = new ArrayList<>();

        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {

        }
        con.close();
        return students;
    }

    @Override
    public boolean setUserImage(Student user, String picURL) throws SQLServerException, SQLException, FileNotFoundException, IOException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getDaysOfClass(Student student) throws SQLServerException, IOException, SQLException{

        int daysofclass = 0;

        String sql = "SELECT Days_of_classes, StuID FROM [Atendens].[dbo].[Student] WHERE StuID = (?)";
        Connection con = ServerConnect.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, student.getStuID());

        ResultSet rs = ps.executeQuery();

        while (rs.next()){
           
            daysofclass = rs.getInt(1);

        }

        con.close();
        return daysofclass;
        
    }
    
    public boolean addDaysOfClass(Student student) throws SQLServerException, IOException, SQLException{
        
       
       String sql = "UPDATE [Atendens].[dbo].[Student] SET Days_of_classes = Days_of_classes +1  WHERE StuID = (?)";
        Connection con = ServerConnect.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, student.getStuID());

       int rowsAffected = ps.executeUpdate();
        if (rowsAffected == 1) {
            return true;
        }
        
        con.close();
        
        return false;
       
       

        } 
        
    



}
