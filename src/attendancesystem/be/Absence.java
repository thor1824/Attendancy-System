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

    private int studID;
    private int absenceID;
    private String subjectID;
    private String toa;
    private String reason;
    private String dialogBox;
    private String date;
    private String modulTimePeriod;

    public Absence(int studID, int absenceID, String reason, String dialogBox, String date) {
        this.studID = studID;
        this.absenceID = absenceID;

        this.toa = "not arrived";
        this.reason = reason;
        this.dialogBox = dialogBox;
        this.date = date;

    }

    public int getStudID() {
        return studID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getToa() {
        return toa;
    }

    public void setToa(String toa) {
        this.toa = toa;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDialogBox() {
        return dialogBox;
    }

    public void setDialogBox(String dialogBox) {
        this.dialogBox = dialogBox;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getModulTimePeriod() {
        return modulTimePeriod;
    }

    public void setModulTimePeriod(String modulTimePeriod) {
        this.modulTimePeriod = modulTimePeriod;
    }

    public int getAbsenceID() {
        return absenceID;
    }

    @Override
    public String toString() {
        return "Absence:" + "studID=" + studID + ", absenceID=" + absenceID + ", toa=" + toa + ", reason=" + reason + ", dialogBox=" + dialogBox + ", date=" + date;
    }

    
    
    

}
