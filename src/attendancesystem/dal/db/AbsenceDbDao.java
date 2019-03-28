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

        String sql = "SELECT * FROM [Atendens].[dbo].[Absense] JOIN [Atendens].[dbo].[Subject] "
                + "ON Subject.SubjectID = Absense.SubjectID"
                + "JOIN [Atendens].[dbo].[Modul] ON Modul.ModulID = Absense.ModulID"
                + "WHERE StudID = (?) AND Reason = (?)";

        Connection con = ServerConnect.getConnection(); //create connection

        PreparedStatement ps = con.prepareStatement(sql); //create prepared Statement

        System.out.println(user);

        ps.setInt(1, user.getUserID());
        ps.setNull(2, Types.NVARCHAR);

        ResultSet rs = ps.executeQuery();

        ArrayList<Absence> absenceList = new ArrayList<>();

        while (rs.next()) {

            int studID = rs.getInt("StudID");
            String toa = rs.getNString("TOA");
            String date = rs.getNString("Date");
            int absenceID = rs.getInt("AbsenceID");


            Absence ab = new Absence(studID, absenceID, null, null, date);
            ab.setToa(toa);

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
    public ArrayList<Absence> getAllAbsens(Student studnt) throws IOException, SQLServerException, SQLException {
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
    public void deleteAbsens() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




    @Override
    public ArrayList<Absence> getAllAbsence(Student student) {
        try {
            Connection con = ServerConnect.getConnection();
            String sql = "SELECT * FROM [Atendens].[dbo].[Absense] WHERE StuID = (?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, student.getStuID());

            ResultSet rs = ps.executeQuery();

            ArrayList<Absence> listOfAbsens = new ArrayList<>();

            while (rs.next()) {

                int studID = rs.getInt("StuID");
                int absenceID = rs.getInt("AbsenceID");
                String date = rs.getNString("Date");

                Absence absence = new Absence(studID, absenceID, null, null, date);

                listOfAbsens.add(absence);

            }
            con.close();

            return listOfAbsens;

        } catch (SQLServerException ex) {
            Logger.getLogger(AbsenceDbDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AbsenceDbDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AbsenceDbDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public ArrayList<Absence> getDocumentetAbsence(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Absence> getAllRequestAbence(Teacher teacher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




    }
