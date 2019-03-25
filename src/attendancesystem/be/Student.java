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

    private String schoolClass;
    
   


    public Student(int StuID, String firstName, String lastName, String email, String phoneNr, String cpr, String Adresse, String zipCode, String schoolClass, String picUrl, int Days_of_classes)
    {
        super(StuID, firstName, lastName, email, phoneNr, cpr, User.CLEARANCE_STUDENT, Adresse, zipCode, picUrl);
        this.schoolClass = schoolClass;
        
        
        
    }

    public String getSchoolClass()
    {
        return schoolClass;
    }

    public void setSchoolClass(String schoolClass)
    {
        this.schoolClass = schoolClass;
    }

    @Override
    public String toString()
    {
        return "Student{" + super.toString() + ", schoolClass=" + schoolClass + '}';
    }

    

}
