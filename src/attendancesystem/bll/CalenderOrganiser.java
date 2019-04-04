/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.bll;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Christian
 */
public class CalenderOrganiser {

    Calendar validDate;
    
    public CalenderOrganiser() {
        this.validDate = Calendar.getInstance();
    }
    
    
    public boolean checkDate(Calendar cal) {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(dateFormat.format(cal.getTime()));
        System.out.println(dateFormat.format(validDate.getTime()));
        if (dateFormat.format(cal.getTime()).equals(dateFormat.format(validDate.getTime()))) {
            nextValidDate(cal);
            return true;
        }
        
        return false;
    }

    private void nextValidDate(Calendar cal) {
        int day = cal.get(Calendar.DAY_OF_WEEK);
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        int year = cal.get(Calendar.YEAR);
        day++;
        if (day >= 7) {
            day = 2;
            week++;
            if (week == 52) {
                week = 1;
                year++;
            }
        }

        validDate.setWeekDate(year, week, day);
    }

}
