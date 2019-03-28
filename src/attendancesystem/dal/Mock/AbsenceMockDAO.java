/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.Mock;

import attendancesystem.be.Absence;
import attendancesystem.be.Student;
import attendancesystem.be.Teacher;
import attendancesystem.be.User;
import attendancesystem.dal.AbsenceDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class AbsenceMockDAO implements AbsenceDAO {

    ArrayList<Absence> undocumentet;

    public AbsenceMockDAO() {
        undocumentet = new ArrayList<>();
//        Absence mod1 = new Absence(0, 0, "subjectID", "reason", "dialogBox", "date", "modulTimePeriod");
//        Absence mod2 = new Absence(0, 0, "subjectID", "reason", "dialogBox", "date", "modulTimePeriod");
//        Absence mod3 = new Absence(0, 0, "subjectID", "reason", "dialogBox", "date", "modulTimePeriod");
//        undocumentet.add(mod1);
//        undocumentet.add(mod2);
//        undocumentet.add(mod3);

    }

    public ArrayList<Absence> getUndocumentetAbsence(User user) {

        return undocumentet;
    }

    @Override
    public void createAbsens() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAbsens() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getAllAbsens() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Absence> getDocumentetAbsence(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Absence> getUndocumentetAbsence(Student user) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateAbsens(Absence absence) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getAllAbsence() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Absence> getAllAbsence(Student student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Absence> getAllAbsens(Student student) throws IOException, SQLServerException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Absence> getAllRequestAbence(Teacher teacher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
