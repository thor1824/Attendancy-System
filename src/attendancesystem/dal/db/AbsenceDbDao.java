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
import attendancesystem.be.User;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
  //
        String sql = "SELECT * FROM [Atendens].[dbo].[Absense] JOIN [Atendens].[dbo].[Subject] "
                + "ON Subject.SubjectID = Absense.SubjectID "
                + "JOIN [Atendens].[dbo].[Modul] ON Modul.ModulID = Absense.ModulID "
                + "WHERE StudID = (?) AND Reason IS NULL";

        Connection con = ServerConnect.getConnection(); //create connection

        PreparedStatement ps = con.prepareStatement(sql); //create prepared Statement

        System.out.println(user);
        
        ps.setInt(1, user.getUserID());
       
        ResultSet rs = ps.executeQuery();

        ArrayList<Absence> absenceList = new ArrayList<>();

        while (rs.next()) {

            int studID = rs.getInt("StudID");
            String subjectID = rs.getNString("Name");
            String toa = rs.getNString("TOA");
            String date = rs.getNString("Date");
            int absenceID = rs.getInt("AbsenceID");
            String modulStart = rs.getNString("Start");
            String modulEnd = rs.getNString("End");

            Absence ab = new Absence(studID, absenceID, subjectID, null, null, date, modulStart + " " + modulEnd);
            ab.setToa(toa);

            absenceList.add(ab);
        }

        con.close();

        return absenceList;
    }

    @Override
    public ArrayList<Absence> getDocumentetAbsence(User user) {

        //to do
        //create connection
        //create prepared Statement
        //get all undocumentet absens from server where reason != null and userID =="input users ID"
        //put in list
        //close connection
        //return list
        return null;
    }

//    @Override
//    public void getAllAbsens(User user) throws SQLServerException, IOException {
//        //to do
//         Connection con = ServerConnect.getConnection();
//        String sql = "SELECT * FROM [Atendens].[dbo].[Absense]  "
//        //get all absens where userID =="input users ID"
//        //put in list
//        //close connection
//        //return list
//    }

    @Override
    public void deleteAbsens() {
        //to do
        //create connection
        //create prepared Statement
        //delete absens where userID =="input users ID"
        //check if entry was deletet
        //close connection
        //retrun true if deleted false if not

    }

    @Override
    public boolean updateAbsens(Absence absence) throws SQLException, SQLServerException, IOException {
        String sql = "UPDATE [Atendens].[dbo].[Absense] "
                + "SET Reason = (?), DialogBox = (?)"
                + "WHERE AbsenceID = (?)";

        Connection con = ServerConnect.getConnection(); //create connection

        PreparedStatement ps = con.prepareStatement(sql); //create prepared Statement

        ps.setNString(1, absence.getReason());
        ps.setNString(2, absence.getDialogBox());
        ps.setInt(3, absence.getAbsenceID());

        int linesAffected = ps.executeUpdate();

        con.close();

        return linesAffected != 0;

        //to do
        //create connection
        //create prepared Statement
        //update absens where userID =="input users ID"
        //check if entry was updatet
        //close connection
        //retrun true if updated false if not
    }

    @Override
    public void createAbsens() {
        //to do
        //create connection
        //create prepared Statement
        //create absens where userID =="input users ID"
        //check if entry was created
        //close connection
        //retrun true if created false if not
    }

    @Override
    public void getAllAbsens() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
