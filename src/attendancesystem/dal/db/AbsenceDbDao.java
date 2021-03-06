/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.db;

import attendancesystem.be.Absence;
import attendancesystem.be.Student;
import attendancesystem.be.Teacher;
import attendancesystem.dal.db.Server.ConnectionPool;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import attendancesystem.dal.facade.IAbsenceDAO;

/**
 *
 * @author Christian
 */
public class AbsenceDbDao implements IAbsenceDAO
{

    @Override
    public ArrayList<Absence> getUndocumentetAbsence(Student user) throws Exception
    {
        ArrayList<Absence> absences = new ArrayList<>();
        String sql = "SELECT * FROM [Atendens].[dbo].[Student] AS a "
                + "JOIN [Atendens].[dbo].[Class] AS b ON a.ClassID = b.ClassID "
                + "JOIN [Atendens].[dbo].[Absense] AS c ON a.StuID = c.StuID "
                + "WHERE a.StuID = (?) AND Approved = ? "
                + "OR a.StuID = (?) and Approved IS NULL";

        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection(); //create connection

        PreparedStatement ps = con.prepareStatement(sql); //create prepared Statement
        ps.setInt(1, user.getUserID());
        ps.setBoolean(2, false);
        ps.setInt(3, user.getUserID());

        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            String stuFullName = rs.getString("StuFName") + " " + rs.getString("StuLName");
            String stuClass = rs.getString("ClassName");
            String date = rs.getString("Date");
            String reason = rs.getString("Reason");
            String explenation = rs.getString("DialogBox");
            int absenceID = rs.getInt("AbsenceID");
            int stuClassID = rs.getInt("ClassID");
            boolean approved = rs.getBoolean("Approved");
            boolean pending = rs.getBoolean("Pending");

            absences.add(new Absence(stuFullName, stuClassID, absenceID, stuClass, reason, explenation, date, approved, pending));

        }

        cp.releaseConnection(con);

        return absences;
    }

    @Override
    public int linesIngetUndocumentetAbsence(Student student) throws Exception
    {
        String sql = "SELECT COUNT(*) FROM [Atendens].[dbo].[Absense] "
                + "WHERE StuID = (?) AND Approved = ? "
                + "OR StuID = (?) and Approved IS NULL";;
        int rowCount = -1;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection(); //create connection

        PreparedStatement ps = con.prepareStatement(sql); //create prepared Statement

        ps.setInt(1, student.getStuID());
        ps.setBoolean(2, false);
        ps.setInt(3, student.getStuID());

        ResultSet rs = ps.executeQuery();
        
        if (rs.next())
        {
            rowCount = rs.getInt(1);
        }

        cp.releaseConnection(con);

        return rowCount;
    }

    @Override
    public int linesIngetDocumentetAbsence(Student student) throws Exception
    {
        String sql = "SELECT COUNT(*) FROM [Atendens].[dbo].[Absense] "
                + "WHERE StuID = (?) AND Approved = ?";
        int rowCount = -1;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection(); //create connection

        PreparedStatement ps = con.prepareStatement(sql); //create prepared Statement

        ps.setInt(1, student.getStuID());
        ps.setBoolean(2, true);
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next())
        {
            rowCount = rs.getInt(1);
        }

        cp.releaseConnection(con);

        return rowCount;
    }

    /**
     *
     * @param studnt
     * @return
     * @throws IOException
     * @throws SQLServerException
     * @throws SQLException
     */
    @Override
    public List<Absence> getAllAbsence(Student student) throws Exception
    {
        List<Absence> absences = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection(); //create connection
        String sql = "SELECT * FROM [Atendens].[dbo].[Student] AS a "
                + "JOIN [Atendens].[dbo].[Class] AS b ON a.ClassID = b.ClassID "
                + "JOIN [Atendens].[dbo].[Absense] AS c ON a.StuID = c.StuID "
                + "WHERE a.StuID = (?);";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, student.getStuID());

        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            String stuFullName = rs.getString("StuFName") + " " + rs.getString("StuLName");
            String stuClass = rs.getString("ClassName");
            String date = rs.getString("Date");
            String reason = rs.getString("Reason");
            String explenation = rs.getString("DialogBox");
            int absenceID = rs.getInt("AbsenceID");
            int stuClassID = rs.getInt("ClassID");
            boolean approved = rs.getBoolean("Approved");
            boolean pending = rs.getBoolean("Pending");

            absences.add(new Absence(stuFullName, stuClassID, absenceID, stuClass, reason, explenation, date, approved, pending));

        }
        cp.releaseConnection(con);

        return absences;

    }

    @Override
    public boolean updateAbsence(Absence absence) throws Exception
    {
        String sql = "UPDATE [Atendens].[dbo].[Absense] "
                + "SET Reason = (?), DialogBox = (?), Pending = (?)"
                + "WHERE AbsenceID = (?)";

        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection(); //create connection

        PreparedStatement ps = con.prepareStatement(sql); //create prepared Statement

        ps.setNString(1, absence.getReason());
        ps.setNString(2, absence.getExplanation());
        ps.setBoolean(3, absence.isPending());
        ps.setInt(4, absence.getAbsenceID());

        int linesAffected = ps.executeUpdate();

        cp.releaseConnection(con);

        return linesAffected != 0;

    }

    @Override
    public List<Absence> getAllRequestAbence(Teacher teacher) throws Exception
    {
        List<Absence> absences = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection(); //create connection
        String sql = "SELECT * FROM [Atendens].[dbo].[Teacher_Class] AS a "
                + "JOIN [Atendens].[dbo].[Class_Absense] AS b ON a.ClassID = b.ClassID "
                + "JOIN [Atendens].[dbo].[Absense] AS c ON b.AbsenceID = c.AbsenceID "
                + "JOIN [Atendens].[dbo].[Class] AS d ON a.ClassID = d.ClassID "
                + "JOIN [Atendens].[dbo].[Student] AS e ON c.StuID = e.StuID "
                + "WHERE a.TeachID = ?;";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, teacher.getUserID());

        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            String stuFName = rs.getString("StuFName");
            String stuLName = rs.getString("StuLName");
            String stuFullName = stuFName + " " + stuLName;
            String stuClass = rs.getString("ClassName");
            String date = rs.getString("Date");
            String reason = rs.getString("Reason");
            String explenation = rs.getString("DialogBox");
            int absenceID = rs.getInt("AbsenceID");
            int stuClassID = rs.getInt("ClassID");
            boolean approved = rs.getBoolean("Approved");
            boolean pending = rs.getBoolean("Pending");

            absences.add(new Absence(stuFullName, stuClassID, absenceID, stuClass, reason, explenation, date, approved, pending));
        }
        cp.releaseConnection(con);

        return absences;
    }

    @Override
    public ArrayList<Absence> getDocumentetAbsence(Student student) throws Exception
    {
        ArrayList<Absence> listOfDocumentetAbsence = new ArrayList<>();

        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection(); //create connection

        String sql = "SELECT * FROM [Atendens].[dbo].[Student] AS a "
                + "JOIN [Atendens].[dbo].[Class] AS b ON a.ClassID = b.ClassID "
                + "JOIN [Atendens].[dbo].[Absense] AS c ON a.StuID = c.StuID "
                + "WHERE a.StuID = (?) AND Approved = ?;";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, student.getStuID());
        ps.setBoolean(2, true);

        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            String stuFullName = rs.getString("StuFName") + " " + rs.getString("StuLName");
            String stuClass = rs.getString("ClassName");
            String date = rs.getString("Date");
            String reason = rs.getString("Reason");
            String explenation = rs.getString("DialogBox");
            int absenceID = rs.getInt("AbsenceID");
            int stuClassID = rs.getInt("ClassID");
            boolean approved = rs.getBoolean("Approved");
            boolean pending = rs.getBoolean("Pending");

            listOfDocumentetAbsence.add(new Absence(stuFullName, stuClassID, absenceID, stuClass, reason, explenation, date, approved, pending));
        }

        cp.releaseConnection(con);

        return listOfDocumentetAbsence;

    }

    @Override
    public boolean makeAbsenceRequest(Absence absence) throws Exception
    {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection(); //create connection

        String sql = "INSERT INTO [Atendens].[dbo].[Class_Absense] (AbsenceID, ClassID) VALUES (?,?);";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, absence.getAbsenceID());
        ps.setInt(2, absence.getStuClassID());
        int linesAffected = ps.executeUpdate();

        cp.releaseConnection(con);

        return linesAffected != 0;

    }

    @Override
    public boolean approveRequest(Absence absence) throws Exception
    {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection(); //create connection

        String updateSql = "UPDATE [Atendens].[dbo].[Absense] "
                + "Set Approved = ?, Pending = ? "
                + "WHERE AbsenceID = ?;";
        
        String deleteSql = "DELETE FROM [Atendens].[dbo].[Class_Absense] "
                + "WHERE AbsenceID = ?;";

        PreparedStatement upPs = con.prepareStatement(updateSql);
        upPs.setBoolean(1, true);
        upPs.setBoolean(2, false);
        upPs.setInt(3, absence.getAbsenceID());

        int linesAffectedUP = upPs.executeUpdate();

        if (linesAffectedUP != 0)
        {

            PreparedStatement delPs = con.prepareStatement(deleteSql);
            delPs.setInt(1, absence.getAbsenceID());
            int linesAffectedDel = delPs.executeUpdate();
            return linesAffectedDel != 0;
        }

        cp.releaseConnection(con);

        return linesAffectedUP != 0;
    }

    @Override
    public boolean declineAbsenceRequest(Absence absence) throws Exception
    {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection(); //create connection

        String updateSql = "UPDATE [Atendens].[dbo].[Absense] Set Approved = ?, Pending = ? "
                + "WHERE AbsenceID = ?;";
        String deleteSql = "DELETE FROM [Atendens].[dbo].[Class_Absense] "
                + "WHERE AbsenceID = ?;";

        PreparedStatement upPs = con.prepareStatement(updateSql);
        upPs.setBoolean(1, false);
        upPs.setBoolean(2, false);
        upPs.setInt(3, absence.getAbsenceID());

        int linesAffectedUP = upPs.executeUpdate();

        if (linesAffectedUP != 0)
        {

            PreparedStatement delPs = con.prepareStatement(deleteSql);
            delPs.setInt(1, absence.getAbsenceID());
            int linesAffectedDel = delPs.executeUpdate();
            return linesAffectedDel != 0;
        }

        cp.releaseConnection(con);

        return linesAffectedUP != 0;
    }

    @Override
    public boolean createAbsence(Absence absence, Student student) throws Exception
    {

        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection(); //create connection

        String sql = "INSERT INTO [Atendens].[dbo].[Absense]"
                + "(StuID, Date ) VALUES (?, ?); ";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, student.getStuID());

        ps.setNString(4, absence.getDate());

        int affectedRows = ps.executeUpdate();

        return affectedRows != 0;

    }

    @Override
    public void createAbsenceBatch(List<Integer> absend, String date) throws Exception
    {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection(); //create connection
        String sql = "INSERT INTO [Atendens].[dbo].[Absense] (StuID, Date) VALUES (?,?);";

        PreparedStatement ps = con.prepareStatement(sql);
        for (Integer integer : absend)
        {
            ps.setInt(1, integer);
            ps.setString(1, date);
            ps.addBatch();
        }

        ps.executeBatch();
    }
}
 