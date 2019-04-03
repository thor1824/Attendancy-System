/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.bll;

import attendancesystem.be.Absence;
import java.util.TimerTask;

/**
 *
 * @author onech
 */
public class TimeKeeper extends TimerTask{
    LoginSimolator loginSim;
    Absence absence;

    @Override
    public void run() {
        loginSim.absentStudents(absence);
        loginSim.studentsPresend();
        
        
    }
    

    
}
