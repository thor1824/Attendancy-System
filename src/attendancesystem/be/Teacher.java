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

    public Teacher(int userID, String firstName, String lastName, String email, String phoneNr, String cpr, int clearanceTier, String Adresse, String zipCode)
    {
        super(userID, firstName, lastName, email, phoneNr, cpr, clearanceTier, Adresse, zipCode);
    }
    
    
    
    
}
