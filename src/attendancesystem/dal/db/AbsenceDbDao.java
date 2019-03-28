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
import java.util.logging.Level;
import java.util.logging.Logger;

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

        String sql = "SELECT * FROM [Atendens].[dbo].[Absense] WHERE StudID = (?) " +
                    "AND DialogBox IS NULL" +
                    "AND Reason IS NULL";



//                + "JOIN [Atendens].[dbo].[Subject] "
//                + "ON Subject.SubjectID = Absense.SubjectID"
//                + "JOIN [Atendens].[dbo].[Modul] ON Modul.ModulID = Absense.ModulID"
//                + "WHERE StudID = (?) AND Reason = (?)";

        Connection con = ServerConnect.getConnection(); //create connection

        PreparedStatement ps = con.prepareStatement(sql); //create prepared Statement

        System.out.println(user);

        ps.setInt(1, user.getUserID());
       // ps.setNull(2, Types.NVARCHAR);

        ResultSet rs = ps.executeQuery();

        ArrayList<Absence> absenceList = new ArrayList<>();

        while (rs.next()) {

            int studID = rs.getInt("StudID");
            String date = rs.getNString("Date");
            int absenceID = rs.getInt("AbsenceID");


            Absence ab = new Absence(studID, absenceID, date, null, null);


            absenceList.add(ab);
        }

        con.close();

        return absenceList;
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
    public ArrayList<Absence> getAllAbsence(Student studnt) throws IOException, SQLServerException, SQLException {
         Connection con = ServerConnect.getConnection();
         String sql = "SELECT * FROM [Atendens].[dbo].[Absense] WHERE StudID = (?)";

          PreparedStatement ps = con.prepareStatement(sql);
          ps.setInt(1, studnt.getStuID());

          ResultSet rs = ps.executeQuery();

          ArrayList<Absence> listOfAbsens = new ArrayList<>();

           while (rs.next()) {

               int studID = rs.getInt("StudID");
               int absenceID = rs.getInt("AbsenceID");
               String date = rs.getNString("Date");


                Absence absence = new Absence(studID, absenceID, null, null, date);

                listOfAbsens.add(absence);



           }
          con.close();

          return listOfAbsens;

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
        ps.setNString(2, absence.getDialogBox());
        ps.setInt(3, absence.getAbsenceID());

        int linesAffected = ps.executeUpdate();

        con.close();

        return linesAffected != 0;

    }



    @Override
    public List<Absence> getAllRequestAbence(Teacher teacher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Absence> getDocumentetAbsence(Student student) throws SQLException, SQLServerException, IOException{
        Connection con = ServerConnect.getConnection();
            String sql = "SELECT * FROM [Atendens].[dbo].[Absense] WHERE StudID = (?) " +
                    "AND DialogBox IS NOT NULL" +
                    "AND Reason IS NOT NULL";
                    //"AND approved IS NOT NULL"; +
//                    "AND WHERE approved > (?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, student.getStuID());
            //ps.setInt(2, 0);

             ResultSet rs = ps.executeQuery();

             ArrayList<Absence> listOfDocumentetAbsence = new ArrayList<>();

             while (rs.next()) {

                int studID = rs.getInt("StuID");
                int absenceID = rs.getInt("AbsenceID");
                String date = rs.getNString("Date");
                //String reason = rs.getNString("Reason");
                //String dialogBox = rs.getNString("DialogBox");

                Absence absence = new Absence(studID, absenceID, date, null, null);

                listOfDocumentetAbsence.add(absence);

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






    }
