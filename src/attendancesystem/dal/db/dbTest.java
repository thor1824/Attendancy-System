/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.db;

import attendancesystem.be.Student;
import attendancesystem.bll.CalenderOrganiser;
import attendancesystem.bll.NFCScanner;
import attendancesystem.dal.StudentDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class dbTest {

    public static void main(String[] args) throws IOException, SQLException {
        StudentDAO sd = new StudentDbDao();
        StudentDbDao sdb = new StudentDbDao();
        AbsenceDbDao ab = new AbsenceDbDao();
        NFCScanner logSim = new NFCScanner();
        Student test = new Student(1, "test", "test", "test", "test", "test", "test", "test", "CSa2018", "test", 0);
        
        Calendar dato = Calendar.getInstance();
        dato.set(
                Calendar.DAY_OF_WEEK,
                Calendar.MONDAY);
        System.out.println(dato.getTime());

        Calendar cal = Calendar.getInstance();
        cal.set(
                Calendar.DAY_OF_WEEK,
                Calendar.SUNDAY);

        int day = cal.get(Calendar.DAY_OF_WEEK);
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        int year = cal.get(Calendar.YEAR);
        System.out.println(day);
        System.out.println(week);
        System.out.println(year);
        cal.set(Calendar.DAY_OF_WEEK, 7);
        CalenderOrganiser calorg = new CalenderOrganiser();
        calorg.checkDate(cal);

    }

}
