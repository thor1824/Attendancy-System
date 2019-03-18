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
public abstract class User
{
    public static final int CLEARANCE_STUDENT = 1;
    public static final int CLEARANCE_TEACHER = 2;
    public static final int CLEARANCE_ADMIN = 3;
    
    private int userID;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String phoneNr;
    private String cpr;
    private int clearanceTier;
    private String Adresse;
    private String zipCode;
    private String picUrl;

    public User(int userID, String firstName, String lastName, String email, String phoneNr, String cpr, int clearanceTier, String Adresse, String zipCode, String picUrl)
    {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.email = email;
        this.phoneNr = phoneNr;
        this.cpr = cpr;
        this.clearanceTier = clearanceTier;
        this.Adresse = Adresse;
        this.zipCode = zipCode;
        this.picUrl = picUrl;
    }

    public String getPicUrl()
    {
        return picUrl;
    }

    public void setPicUrl(String picUrl)
    {
        this.picUrl = picUrl;
    }
    
    
    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setUserID(int userID)
    {
        this.userID = userID;
    }
    
    
    
    public User getUser(User user){
        return user;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String LastName)
    {
        this.lastName = LastName;
    }

    public int getClearanceTier()
    {
        return clearanceTier;
    }

    public void setClearanceTier(int clearanceTier)
    {
        this.clearanceTier = clearanceTier;
    }

    
    
    /**
     * Get the value of clearanceTier
     *
     * @return the value of clearanceTier
     */
    public int getClearenceTier()
    {
        return clearanceTier;
    }

    /**
     * Set the value of clearanceTier
     *
     * @param clearenceTier new value of clearanceTier
     */
    public void setClearenceTier(int clearenceTier)
    {
        this.clearanceTier = clearenceTier;
    }
    
    /**
     * Get the value of cpr
     *
     * @return the value of cpr
     */
    public String getCpr()
    {
        return cpr;
    }

    /**
     * Set the value of cpr
     *
     * @param cpr new value of cpr
     */
    public void setCpr(String cpr)
    {
        this.cpr = cpr;
    }


    /**
     * Get the value of phoneNr
     *
     * @return the value of phoneNr
     */
    public String getPhoneNr()
    {
        return phoneNr;
    }

    /**
     * Set the value of phoneNr
     *
     * @param phoneNr new value of phoneNr
     */
    public void setPhoneNr(String phoneNr)
    {
        this.phoneNr = phoneNr;
    }


    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }


    /**
     * Get the value of fullName
     *
     * @return the value of fullName
     */
    public String getFullName()
    {
        return fullName;
    }





    /**
     * Get the value of int
     *
     * @return the value of int
     */
    public int getUserID()
    {
        return userID;
    }

    @Override
    public String toString()
    {
        return "userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", fullName=" + fullName + ", email=" + email + ", phoneNr=" + phoneNr + ", cpr=" + cpr + ", clearanceTier=" + clearanceTier + ", Adresse=" + Adresse + ", zipCode=" + zipCode + ", picUrl=" + picUrl;
    }
    
    
    
    
    
}
