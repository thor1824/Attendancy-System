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
public class Student extends User{
    
    private String picUrl;
    
    public Student(int userID, String firstName, String lastName, String email, String phoneNr, String cpr, String Adresse, String zipCode)
    {
        super(userID, firstName, lastName, email, phoneNr, cpr, User.CLEARANCE_STUDENT, Adresse, zipCode);
    }

    public String getPicUrl()
    {
        return picUrl;
    }

    public void setPicUrl(String picUrl)
    {
        this.picUrl = picUrl;
    }
    
    

    

    

    
    
    
}
