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
public class User
{
    public static final int CLEARANCE_STUDENT = 1;
    public static final int CLEARANCE_TEACHER = 2;
    public static final int CLEARANCE_ADMIN = 3;
    
    private int userID;
    private int userName;
    
    
}
