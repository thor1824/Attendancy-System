/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.bll.essentials;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Christian
 */
public class CalenderOrganiser
{

    private Calendar validDate;
    private DateFormat dateFormat;
    private String nextValidDay;

    public CalenderOrganiser()
    {
        this.validDate = Calendar.getInstance();
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.nextValidDay = dateFormat.format(validDate.getTime());
    }

    public String checkDate(Calendar cal)
    {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (dateFormat.format(cal.getTime()).equals(nextValidDay))
        {
            nextValidDate(Calendar.getInstance());
            return priorDate(Calendar.getInstance());
        }

        return null;
    }

    private void nextValidDate(Calendar cal)
    { 
        int day = cal.get(Calendar.DAY_OF_WEEK);
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        int year = cal.get(Calendar.YEAR);
        day++;
        if (day >= 7)
        {
            day = 2;
            week++;
            if (week == 52)
            {
                week = 1;
                year++;
            }
        }

        validDate.setWeekDate(year, week, day);
        nextValidDay = dateFormat.format(validDate.getTime());
        System.out.println(nextValidDay);
    }

    private String priorDate(Calendar cal)
    {
        int day = cal.get(Calendar.DAY_OF_WEEK);
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        int year = cal.get(Calendar.YEAR);
        day--;
        if (day <= 1)
        {
            day = 6;
            week--;
            if (week <= 0)
            {
                week = 52;
                year--;
            }
        }
        Calendar priorDate = Calendar.getInstance();
        priorDate.setWeekDate(year, week, day);
        return dateFormat.format(priorDate.getTime());
    }

}
