/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.be;

import java.util.ArrayList;

/**
 *
 * @author Nijas Hansen
 */
public class Teacher extends User{

    ArrayList<String> subject;
    
    public Teacher(int userID, String userName, String fullName, String email, String phoneNr, String cpr)
    {
        super(userID, userName, fullName, email, phoneNr, cpr, User.CLEARANCE_TEACHER);
    }
    
    
    
}
