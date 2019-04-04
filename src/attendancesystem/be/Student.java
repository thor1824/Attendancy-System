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
public class Student extends User
{

    private String schoolClass;
    private int StuID;
    private int daysPrecend;
    private int undocAbsence;
    private int docAbsence;

    public Student(int StuID, String firstName, String lastName, String email, String phoneNr, String cpr, String Adresse, String zipCode, String schoolClass, String picUrl, int daysPrecend, int undocAbsence, int docAbsence)
    {
        super(StuID, firstName, lastName, email, phoneNr, cpr, User.CLEARANCE_STUDENT, Adresse, zipCode, picUrl);
        this.schoolClass = schoolClass;
        this.StuID = StuID;
        this.daysPrecend = daysPrecend;
        this.undocAbsence = undocAbsence;
        this.docAbsence = docAbsence;
        
        
    }

    public int getUndocAbsence()
    {
        return undocAbsence;
    }

    public void setUndocAbsence(int undocAbsence)
    {
        this.undocAbsence = undocAbsence;
    }

    public int getDocAbsence()
    {
        return docAbsence;
    }

    public void setDocAbsence(int docAbsence)
    {
        this.docAbsence = docAbsence;
    }
    
    
    
    public int getDaysPrecend()
    {
        return daysPrecend;
    }

    public void setDaysPrecend(int daysPrecend)
    {
        this.daysPrecend = daysPrecend;
    }

    public int getStuID()
    {
        return StuID;
    }

    public void setStuID(int StuID)
    {
        this.StuID = StuID;
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
