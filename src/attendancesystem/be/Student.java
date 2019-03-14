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

    private StringProperty schoolClass;
    private String fullName;
    private int StudentID;
    private String LastName;
    private String FirstName;
    private String email;
    private String phoneNr;
    private String cpr;
    private String Adress;
    private String picUrl;


    public Student(int userID, String firstName, String lastName, String email, String phoneNr, String cpr, String Adresse, String zipCode)
    {
        super(userID, userName, fullName, email, phoneNr, cpr, User.CLEARANCE_STUDENT);
        this.schoolClass = schoolClass;
        this.fullName = fullName;
        this.StudentID = StudentID;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.email = email;
        this.phoneNr = phoneNr;
        this.cpr = cpr;
        this.Adress = Adress;
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









    public String getStudentName(){
        return FirstName + LastName;
    }
}
