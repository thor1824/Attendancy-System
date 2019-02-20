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
public class UndocumentetModulAbsence {
    
    
    private String Modul;
    private String timeOfArrival;
    private String date;
    private String explenation;
    private String subject;
    
    public UndocumentetModulAbsence(String Modul, String date, String subject) {
        this.Modul = Modul;
        this.date = date;
        this.subject = subject;
        this.timeOfArrival = "not Arrived";
    }
    
    

    /**
     * Get the value of subject
     *
     * @return the value of subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Set the value of subject
     *
     * @param subject new value of subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }


    /**
     * Get the value of explenation
     *
     * @return the value of explenation
     */
    public String getExplenation() {
        return explenation;
    }

    /**
     * Set the value of explenation
     *
     * @param explenation new value of explenation
     */
    public void setExplenation(String explenation) {
        this.explenation = explenation;
    }


    /**
     * Get the value of date
     *
     * @return the value of date
     */
    public String getDate() {
        return date;
    }

    /**
     * Set the value of date
     *
     * @param date new value of date
     */
    public void setDate(String date) {
        this.date = date;
    }


    /**
     * Get the value of timeOfArrival
     *
     * @return the value of timeOfArrival
     */
    public String getTimeOfArrival() {
        return timeOfArrival;
    }

    /**
     * Set the value of timeOfArrival
     *
     * @param timeOfArrival new value of timeOfArrival
     */
    public void setTimeOfArrival(String timeOfArrival) {
        this.timeOfArrival = timeOfArrival;
    }


    /**
     * Get the value of Modul
     *
     * @return the value of Modul
     */
    public String getModul() {
        return Modul;
    }

    /**
     * Set the value of Modul
     *
     * @param Modul new value of Modul
     */
    public void setModul(String Modul) {
        this.Modul = Modul;
    }

}
