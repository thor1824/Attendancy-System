/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.bll.essentials.scanner;

import attendancesystem.be.Student;
import attendancesystem.bll.essentials.CalenderOrganiser;
import attendancesystem.bll.essentials.IScanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import attendancesystem.dal.facade.IAbsenceDAO;
import attendancesystem.dal.facade.IStudentDAO;

/**
 *
 * @author Christian
 */
public class NFCScanner implements IScanner
{

    
    

    @Override
    public String scan()
    {
        Random rand = new Random();
        int randomNumber = rand.nextInt((347 - 1) + 1) + 1;
        
        return ""+randomNumber;
    }
    
    

}
