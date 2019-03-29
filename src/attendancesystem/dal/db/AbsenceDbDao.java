/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.db;

import attendancesystem.dal.db.Server.ServerConnect;
import attendancesystem.dal.AbsenceDAO;
import attendancesystem.be.Absence;
import attendancesystem.be.Student;
import attendancesystem.be.Teacher;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class AbsenceDbDao implements AbsenceDAO {

    private static ServerConnect server;

    public AbsenceDbDao() throws IOException {

        this.server = new ServerConnect();
    }

    @Override
    public ArrayList<Absence> getUndocumentetAbsence(Student user) throws SQLException, SQLServerException, IOException {
        ArrayList<Absence> absences = new ArrayList<>();
        String sql = "SELECT * FROM [Atendens].[dbo].[Student] AS a "
                + "JOIN [Atendens].[dbo].[Class] AS b ON a.ClassID = b.ClassID "
                + "JOIN [Atendens].[dbo].[Absense] AS c ON a.StuID = c.StuID "
                + "WHERE a.StuID = (?) "
                + "AND Reason IS NULL";
        Connection con = ServerConnect.getConnection(); //create connection

        PreparedStatement ps = con.prepareStatement(sql); //create prepared Statement

        System.out.println(user);

        ps.setInt(1, user.getUserID());
        // ps.setNull(2, Types.NVARCHAR);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String stuFullName = rs.getString("StuFName") + " " + rs.getString("StuLName");
            String stuClass = rs.getString("ClassName");
            String date = rs.getString("Date");
            String reason = rs.getString("Reason");
            String explenation = rs.getString("DialogBox");
            int absenceID = rs.getInt("AbsenceID");
            int stuClassID = rs.getInt("ClassID");

            absences.add(new Absence(stuFullName, stuClassID, absenceID, stuClass, reason, explenation, date));

        }

        con.close();

        return absences;
    }
    
    @Override
    public int linesIngetUndocumentetAbsence(Student student) throws SQLException, SQLServerException, IOException{
        String sql = "SELECT COUNT(*) FROM [Atendens].[dbo].[Absense] WHERE StuID = (?) AND Reason IS NULL";
        int rowCount = -1;
        Connection con = ServerConnect.getConnection(); //create connection

        PreparedStatement ps = con.prepareStatement(sql); //create prepared Statement
        
        ps.setInt(1, student.getStuID());
        
        ResultSet rs = ps.executeQuery();
        
        rs.next();
        rowCount = rs.getInt(1);
        
        con.close();
        
        return rowCount;
    }
    
    @Override
    public int linesIngetDocumentetAbsence(Student student) throws SQLException, SQLServerException, IOException{
        String sql = "SELECT COUNT(*) FROM [Atendens].[dbo].[Absense] WHERE StuID = (?) AND Reason IS NOT NULL";
        int rowCount = -1;
        Connection con = ServerConnect.getConnection(); //create connection

        PreparedStatement ps = con.prepareStatement(sql); //create prepared Statement
        
        ps.setInt(1, student.getStuID());
        
        ResultSet rs = ps.executeQuery();
        
        rs.next();
        rowCount = rs.getInt(1);
        
        con.close();
        
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
    public List<Absence> getAllAbsence(Student student) throws IOException, SQLServerException, SQLException {
        List<Absence> absences = new ArrayList<>();
        Connection con = ServerConnect.getConnection();
        String sql = "SELECT * FROM [Atendens].[dbo].[Student] AS a "
                + "JOIN [Atendens].[dbo].[Class] AS b ON a.ClassID = b.ClassID "
                + "JOIN [Atendens].[dbo].[Absense] AS c ON a.StuID = c.StuID "
                + "WHERE a.StuID = (?);";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, student.getStuID());

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String stuFullName = rs.getString("StuFName") + " " + rs.getString("StuLName");
            String stuClass = rs.getString("ClassName");
            String date = rs.getString("Date");
            String reason = rs.getString("Reason");
            String explenation = rs.getString("DialogBox");
            int absenceID = rs.getInt("AbsenceID");
            int stuClassID = rs.getInt("ClassID");

            absences.add(new Absence(stuFullName, stuClassID, absenceID, stuClass, reason, explenation, date));

        }
        con.close();

        return absences;

    }

    public boolean deleteAbsens(Absence absence, Student student) throws SQLServerException, SQLException, IOException {
        //to do

        String sql = "DELETE FROM [Atendens].[dbo].[Absense] WHERE AbsenceID = (?) AND StuID = (?)";

        Connection con = ServerConnect.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        int linesAffected = ps.executeUpdate();

        ps.setInt(1, absence.getAbsenceID());
        ps.setInt(2, student.getStuID());

        con.close();

        return linesAffected != 0;
        //create prepared Statement
        //delete absens where userID =="input users ID"
        //check if entry was deletet
        //close connection
        //retrun true if deleted false if not
    }

    @Override
    public boolean updateAbsence(Absence absence) throws SQLException, SQLServerException, IOException {
        String sql = "UPDATE [Atendens].[dbo].[Absense] "
                + "SET Reason = (?), DialogBox = (?)"
                + "WHERE AbsenceID = (?)";

        Connection con = ServerConnect.getConnection(); //create connection

        PreparedStatement ps = con.prepareStatement(sql); //create prepared Statement

        ps.setNString(1, absence.getReason());
        ps.setNString(2, absence.getExplanation());
        ps.setInt(3, absence.getAbsenceID());

        int linesAffected = ps.executeUpdate();

        con.close();

        return linesAffected != 0;

    }

    @Override
    public List<Absence> getAllRequestAbence(Teacher teacher) throws SQLServerException, IOException, SQLException {
        List<Absence> absences = new ArrayList<>();
        Connection con = ServerConnect.getConnection();
        String sql = "SELECT * FROM [Atendens].[dbo].[Teacher_Class] AS a "
                + "JOIN [Atendens].[dbo].[Class_Absense] AS b ON a.ClassID = b.ClassID "
                + "JOIN [Atendens].[dbo].[Absense] AS c ON b.AbsenceID = c.AbsenceID "
                + "JOIN [Atendens].[dbo].[Class] AS d ON a.ClassID = d.ClassID "
                + "JOIN [Atendens].[dbo].[Student] AS e ON c.StuID = e.StuID "
                + "WHERE a.TeachID = ?;";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, teacher.getUserID());

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String stuFName = rs.getString("StuFName");
            
            String stuLName = rs.getString("StuLName");
            String stuFullName = stuFName + " " + stuLName;
            System.out.println(stuFullName);
            String stuClass = rs.getString("ClassName");
            String date = rs.getString("Date");
            String reason = rs.getString("Reason");
            String explenation = rs.getString("DialogBox");
            int absenceID = rs.getInt("AbsenceID");
            int stuClassID = rs.getInt("ClassID");

            absences.add(new Absence(stuFullName, stuClassID, absenceID, stuClass, reason, explenation, date));
            System.out.println(absences.get(0));
        }

        return absences;
    }

    @Override
    public ArrayList<Absence> getDocumentetAbsence(Student student) throws SQLException, SQLServerException, IOException {
        ArrayList<Absence> listOfDocumentetAbsence = new ArrayList<>();

        Connection con = ServerConnect.getConnection();
        String sql = "SELECT * FROM [Atendens].[dbo].[Student] AS a "
                + "JOIN [Atendens].[dbo].[Class] AS b ON a.ClassID = b.ClassID "
                + "JOIN [Atendens].[dbo].[Absense] AS c ON a.StuID = c.StuID "
                + "WHERE a.StuID = (?) "
                + "AND Reason IS NOT NULL;";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, student.getStuID());

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String stuFullName = rs.getString("StuFName") + " " + rs.getString("StuLName");
            String stuClass = rs.getString("ClassName");
            String date = rs.getString("Date");
            String reason = rs.getString("Reason");
            String explenation = rs.getString("DialogBox");
            int absenceID = rs.getInt("AbsenceID");
            int stuClassID = rs.getInt("ClassID");

            listOfDocumentetAbsence.add(new Absence(stuFullName, stuClassID, absenceID, stuClass, reason, explenation, date));
        }

        return listOfDocumentetAbsence;

    }

    public boolean createAbsence() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deleteAbsence() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean makeAbsenceRequest(Absence absence) throws Exception {
        Connection con = ServerConnect.getConnection();
        String sql = "INSERT INTO [Atendens].[dbo].[Class_Absense] (AbsenceID, ClassID) VALUES (?,?);";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, absence.getAbsenceID());
        ps.setInt(2, absence.getStuClassID());
        return ps.execute();

    }

    @Override
    public boolean approveRequest(Absence absence) throws Exception {
        Connection con = ServerConnect.getConnection();
        String updateSql = "UPDATE [Atendens].[dbo].[Absense] Set Approved = ? WHERE AbsenceID = ?;";
        String deleteSql = "DELETE FROM [Atendens].[dbo].[Class_Absense] WHERE AbsenceID = ?;";

        PreparedStatement upPs = con.prepareStatement(updateSql);
        upPs.setBoolean(1, true);
        upPs.setInt(2, absence.getAbsenceID());

        int linesAffectedUP = upPs.executeUpdate();

        if (linesAffectedUP != 0) {

            PreparedStatement delPs = con.prepareStatement(deleteSql);
            delPs.setInt(1, absence.getAbsenceID());
            int linesAffectedDel = delPs.executeUpdate();
            return linesAffectedDel != 0;
        }
        return linesAffectedUP != 0;
    }

    @Override
    public boolean declineAbsenceRequest(Absence absence) throws Exception {
        Connection con = ServerConnect.getConnection();
        String updateSql = "UPDATE [Atendens].[dbo].[Absense] Set Approved = ? WHERE AbsenceID = ?;";
        String deleteSql = "DELETE FROM [Atendens].[dbo].[Class_Absense] WHERE AbsenceID = ?;";

        PreparedStatement upPs = con.prepareStatement(updateSql);
        upPs.setBoolean(1, false);
        upPs.setInt(2, absence.getAbsenceID());

        int linesAffectedUP = upPs.executeUpdate();

        if (linesAffectedUP != 0) {

            PreparedStatement delPs = con.prepareStatement(deleteSql);
            delPs.setInt(1, absence.getAbsenceID());
            int linesAffectedDel = delPs.executeUpdate();
            return linesAffectedDel != 0;
        }
        return linesAffectedUP != 0;
    }

}
