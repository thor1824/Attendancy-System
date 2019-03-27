/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal;

import attendancesystem.be.Absence;
import attendancesystem.be.Student;
import attendancesystem.be.Teacher;
import attendancesystem.be.User;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public interface AbsenceDAO
{

    boolean createAbsence() throws Exception;

    boolean deleteAbsence() throws Exception;


    public List<Absence> getDocumentetAbsence(Student student) throws Exception;

    public List<Absence> getUndocumentetAbsence(Student user) throws Exception;

    boolean updateAbsence(Absence absence) throws Exception;

    public List<Absence> getAllAbsence(Student student) throws Exception;

    public List<Absence> getAllRequestAbence(Teacher teacher) throws Exception;

}
