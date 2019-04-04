/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.facade;

import attendancesystem.be.Absence;
import attendancesystem.be.Student;
import attendancesystem.be.Teacher;
import java.util.List;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public interface IAbsenceDAO
{

    public boolean createAbsence(Absence absence, Student student) throws Exception;
    
    public List<Absence> getDocumentetAbsence(Student student) throws Exception;

    public List<Absence> getUndocumentetAbsence(Student user) throws Exception;

    public boolean updateAbsence(Absence absence) throws Exception;

    public List<Absence> getAllAbsence(Student student) throws Exception;

    public List<Absence> getAllRequestAbence(Teacher teacher) throws Exception;

    public boolean makeAbsenceRequest(Absence absence) throws Exception;
    
    public boolean approveRequest(Absence absence) throws Exception;
    
    public boolean declineAbsenceRequest(Absence absence) throws Exception;
    
    public int linesIngetDocumentetAbsence(Student student) throws Exception;
    
    public int linesIngetUndocumentetAbsence(Student student) throws Exception;

    public void createAbsenceBatch(List<Integer> absend, String date) throws Exception;

}
