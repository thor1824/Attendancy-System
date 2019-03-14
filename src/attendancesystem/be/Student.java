/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.be;

import javafx.beans.property.StringProperty;

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
    
    

    public Student(int userID, String fullName, int StudentID, String userName, String LastName, String FirstName, String email, String phoneNr, String cpr, String Adress)
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
    }
    
    
    

   
    
    

    public String getSchoolClass() {
        return schoolClass.get();
    }

    public void setSchoolClass(String value) {
        schoolClass.set(value);
    }

    public StringProperty schoolClassProperty() {
        return schoolClass;
    }
    
    public String getStudentName(){
        return FirstName + LastName;
    }
}
