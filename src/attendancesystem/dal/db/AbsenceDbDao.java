/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.db;

import attendancesystem.dal.db.Server.ServerConnect;
import attendancesystem.dal.AbsenceDAO;
import attendancesystem.be.UndocumentetModulAbsence;
import attendancesystem.be.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Christian
 */
public class AbsenceDbDao implements AbsenceDAO
{

    private static ServerConnect server;

    public AbsenceDbDao() throws IOException
    {

        this.server = new ServerConnect();
    }

    @Override
    public ArrayList<UndocumentetModulAbsence> getUndocumentetAbsence(User user)
    {

        //to do
        //create connection
        //create prepared Statement
        //get all undocumentet absens from server where reason == null and userID =="input users ID"
        //put in list
        //close connection
        //return list
        return null;
    }

    @Override
    public ArrayList<UndocumentetModulAbsence> getDocumentetAbsence(User user)
    {
        
        //to do
        //create connection
        //create prepared Statement
        //get all undocumentet absens from server where reason != null and userID =="input users ID"
        //put in list
        //close connection
        //return list
        return null;
    }

    @Override
    public void getAllAbsens()
    {
        //to do
        //create connection
        //create prepared Statement
        //get all absens where userID =="input users ID"
        //put in list
        //close connection
        //return list
    }

    @Override
    public void deleteAbsens()
    {
        //to do
        //create connection
        //create prepared Statement
        //delete absens where userID =="input users ID"
        //check if entry was deletet
        //close connection
        //retrun true if deleted false if not
        
    }

    @Override
    public boolean updateAbsens()
    {
//        String sql = "UPDATE [Atendens].[dbo].[Absense] "
//                + "SET ";
//
//        Connection con = ServerConnect.getConnection(); //create connection
//
//        PreparedStatement ps = con.prepareStatement(sql); //create prepared Statement
//        
//        ps.setInt(0, 0);
//        ps.setNString(0, sql);
//        
//        int linesAffected = ps.executeUpdate();
//        
//        con.close();
//        
//        return linesAffected != 0;
        
        //to do
        //create connection
        //create prepared Statement
        //update absens where userID =="input users ID"
        //check if entry was updatet
        //close connection
        //retrun true if updated false if not
        
        return true;
    }

    @Override
    public void createAbsens()
    {
        //to do
        //create connection
        //create prepared Statement
        //create absens where userID =="input users ID"
        //check if entry was created
        //close connection
        //retrun true if created false if not
    }

}
