/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.db;

import attendancesystem.dal.db.Server.ServerConnect;
import attendancesystem.dal.TeacherDAO;
import attendancesystem.be.User;
import java.io.IOException;

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
}
