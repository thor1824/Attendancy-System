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
    private String userName;
    private String fullName;
    private String email;
    private String phoneNr;
    private String cpr;
    private int clearanceTier;

    public User(int userID, String userName, String fullName, String email, String phoneNr, String cpr, int clearanceTier)
    {
        this.userID = userID;
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.phoneNr = phoneNr;
        this.cpr = cpr;
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
     * Set the value of fullName
     *
     * @param fullName new value of fullName
     */
    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }


    /**
     * Get the value of userName
     *
     * @return the value of userName
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * Set the value of userName
     *
     * @param UserName new value of userName
     */
    public void setUserName(String UserName)
    {
        this.userName = UserName;
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

    
    
    
}
