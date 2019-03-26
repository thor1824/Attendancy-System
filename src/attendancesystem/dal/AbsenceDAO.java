/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal;

import attendancesystem.be.Absence;
import attendancesystem.be.Student;
import attendancesystem.be.User;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public interface AbsenceDAO
{

    void createAbsens();

    void deleteAbsens();

    ArrayList<Absence> getDocumentetAbsence(User user);

    ArrayList<Absence> getUndocumentetAbsence(Student user) throws Exception;

    boolean updateAbsens(Absence absence) throws Exception;

    public ArrayList<Absence> getAllAbsens(Student student) throws IOException, SQLServerException, SQLException;
    
}
