/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.folder;

import attendancesystem.be.User;
import attendancesystem.dal.*;
import java.io.IOException;

/**
 *
 * @author Nijas Hansen
 */
public class StudentDbDao {
    
    private static ServerConnect server;

    public StudentDbDao() throws IOException
    {

        this.server = new ServerConnect();
    }

    

    public void getAllStudents()
    {
        //to do
        //create connection
        //create prepared Statement
        //get all Students 
        //put in list
        //close connection
        //return list
    }

    public void deleteStudent(User user)
    {
        //to do
        //create connection
        //create prepared Statement
        //delete Student where userID =="input users ID"
        //check if entry was deletet
        //close connection
        //retrun true if deleted, false if not
        
    }
    
    public void getStudent(User user)
    {
        //to do
        //create connection
        //create prepared Statement
        //get Student where userID =="input users ID"
        //close connection
        //retrun Student
        
    }

    public void updateStudent(User user)
    {
        //to do
        //create connection
        //create prepared Statement
        //update Student where userID =="input users ID"
        //check if entry was updated
        //close connection
        //retrun true if updated, false if not
    }

    public void createStudent(User user)
    {
        //to do
        //create connection
        //create prepared Statement
        //create Student
        //check if entry was created
        //close connection
        //retrun true if created, false if not
    }
}
