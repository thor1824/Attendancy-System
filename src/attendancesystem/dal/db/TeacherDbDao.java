/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.db;

import attendancesystem.be.Absence;
import attendancesystem.be.Teacher;
import attendancesystem.dal.db.Server.ServerConnect;
import attendancesystem.dal.TeacherDAO;
import attendancesystem.be.User;
import attendancesystem.dal.db.Server.ConnectionPool;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nijas Hansen
 */
public class TeacherDbDao implements TeacherDAO {
    
    private static ServerConnect server;

    public TeacherDbDao() throws IOException
    {

        this.server = new ServerConnect();
    }

    

    @Override
    public void getAllTeachers()
    {
        //to do
        //create connection
        //create prepared Statement
        //get all Teachers 
        //put in list
        //close connection
        //return list
    }

    @Override
    public void getTeacher(User user)
    {
        //to do
        //create connection
        //create prepared Statement
        //get Teacher where userID =="input users ID"
        //close connection
        //retrun Teacher
        
    }
    
    @Override
    public void deleteTeacher(User user)
    {
        //to do
        //create connection
        //create prepared Statement
        //delete Teacher where userID =="input users ID"
        //check if entry was deletet
        //close connection
        //retrun true if deleted, false if not
        
    }

    @Override
    public void updateTeacher(User user)
    {
        //to do
        //create connection
        //create prepared Statement
        //update Teacher where userID =="input users ID"
        //check if entry was updated
        //close connection
        //retrun true if updated, false if not
        
    }

    @Override
    public void createTeacher(User user)
    {
        //to do
        //create connection
        //create prepared Statement
        //create Teacher
        //check if entry was created
        //close connection
        //retrun true if created, false if not
        
    }

    @Override
    public List<String> getSchoolClasses(Teacher teacher) throws Exception
    {
       List<String> classes = new ArrayList<>();
       ConnectionPool cp= ConnectionPool.getInstance();
        Connection con = cp.getConnection(); //create connection
        String sql = "SELECT * FROM [Atendens].[dbo].[Teacher_Class] AS a "
                + "JOIN [Atendens].[dbo].[Class] AS b ON a.ClassID = b.ClassID "
                + "WHERE a.TeachID = (?);";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, teacher.getUserID());

        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            classes.add(rs.getString("ClassName"));
        }
        cp.releaseConnection(con);
        
        return classes;
    }
}
