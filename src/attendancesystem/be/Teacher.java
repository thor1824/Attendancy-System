/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.be;

/**
 *
 * @author Nijas Hansen
 */
public class Teacher extends User{
    
    public Teacher(int teachID, String firstName, String lastName, String email, String phoneNr, String cpr, int clearanceTier, String Adresse, String zipCode, String picUrl)
    {
        super(teachID, firstName, lastName, email, phoneNr, cpr, clearanceTier, Adresse, zipCode, picUrl);
    }
    
    
    
    
}
