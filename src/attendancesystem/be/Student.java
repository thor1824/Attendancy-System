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
    

    public Student(int userID, String fullName, int StudentID, String userName, String LastName, String FirstName, String email, String phoneNr, String cpr, String Adress)
    {
        super(userID, userName, fullName, email, phoneNr, cpr, User.CLEARANCE_STUDENT);
        
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
    
    
}
