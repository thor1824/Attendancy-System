/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.folder;

import attendancesystem.dal.*;
import attendancesystem.be.UndocumentetModulAbsence;
import attendancesystem.be.User;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Christian
 */
public class AbsenceDbDao
{

    private static ServerConnect server;

    public AbsenceDbDao() throws IOException
    {

        this.server = new ServerConnect();
    }

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

    public void updateAbsens()
    {
        //to do
        //create connection
        //create prepared Statement
        //update absens where userID =="input users ID"
        //check if entry was updatet
        //close connection
        //retrun true if updated false if not
    }

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
