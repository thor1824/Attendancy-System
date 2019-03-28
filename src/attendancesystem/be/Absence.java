/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.be;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class Absence {

    private String stuFullName;
    private int absenceID;
    private String stuClassName;
    private int stuClassID;
    private String reason;
    private String explanation;
    private String date;


    public Absence(String StuFullName, int stuClassID, int absenceID, String stuClass, String reason, String explanation, String date) {
        this.stuFullName = stuFullName;
        this.absenceID = absenceID;
        this.stuClassName = stuClass;
        this.reason = reason;
        this.explanation = explanation;
        this.date = date;
        this.stuClassID = stuClassID;
    }

    public int getStuClassID() {
        return stuClassID;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String dialogBox) {
        this.explanation = dialogBox;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public int getAbsenceID() {
        return absenceID;
    }

    public String getStuFullName() {
        return stuFullName;
    }

    public void setStuFullName(String stuFullName) {
        this.stuFullName = stuFullName;
    }

    public String getStuClass() {
        return stuClassName;
    }

    public void setStuClass(String stuClass) {
        this.stuClassName = stuClass;
    }

    @Override
    public String toString() {
        return stuFullName + "  "  + stuClassName + "  " + reason + "  " + explanation + "  " + date;
    }

    




}
