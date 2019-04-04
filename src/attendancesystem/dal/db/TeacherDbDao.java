/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.db;

import attendancesystem.be.Teacher;
import attendancesystem.dal.db.Server.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import attendancesystem.dal.facade.ITeacherDAO;

/**
 *
 * @author Nijas Hansen
 */
public class TeacherDbDao implements ITeacherDAO
{

    @Override
    public List<String> getSchoolClasses(Teacher teacher) throws Exception
    {
        List<String> classes = new ArrayList<>();
        
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection(); //create connection
        
        String sql = "SELECT * FROM [Atendens].[dbo].[Teacher_Class] AS a "
                + "JOIN [Atendens].[dbo].[Class] AS b ON a.ClassID = b.ClassID "
                + "WHERE a.TeachID = (?);";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, teacher.getUserID());

        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            classes.add(rs.getString("ClassName"));
        }
        cp.releaseConnection(con);

        return classes;
    }
}
