/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.bll;

import attendancesystem.be.Student;
import attendancesystem.be.User;
import attendancesystem.dal.db.StudentDbDao;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Christian
 */
public class LoginSimolator {

    public StudentDbDao studentDb;
    List<Student> simStudents;

    public List addStudentToList() throws SQLException, SQLServerException, IOException {

        simStudents = studentDb.getAllStudents().subList(0, 4);

        return simStudents;
    }

    public User setUserByTime() {
        //todo

        LocalDate locDate = LocalDate.now();

        simStudents.get(0);

        return null;
    }

    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        return dateFormat.format(date);
    }
}
