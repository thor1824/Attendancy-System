/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.db;

import attendancesystem.be.Student;
import attendancesystem.bll.PasswordEncryptor;
import attendancesystem.dal.StudentDAO;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class dbTest
{
    public static void main(String[] args) throws IOException, SQLException
    {
        StudentDAO sd = new StudentDbDao();
        StudentDbDao sdb = new StudentDbDao();
        AbsenceDbDao ab = new AbsenceDbDao();
        Student test = new Student(1, "test", "test", "test", "test", "test", "test", "test", "CSa2018", "test", 0);
        
        //System.out.println(sd.createStudent(test, "test", PasswordEncryptor.encryptPassword("test")));
        
        System.out.println(ab.linesIngetDocumentetAbsence(test));
        sdb.addDaysOfClass(test);
    }

}
