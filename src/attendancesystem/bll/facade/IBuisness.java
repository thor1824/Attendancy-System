/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.bll.facade;

import attendancesystem.be.Absence;
import attendancesystem.be.Student;
import attendancesystem.be.Teacher;
import java.util.List;
import javafx.scene.chart.PieChart;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public interface IBuisness
{

    boolean scan();

    boolean approveRequest(Absence absence) throws Exception;

    boolean createAbsence(Absence absence, Student student) throws Exception;

    boolean declineAbsenceRequest(Absence absence) throws Exception;

    List<Absence> getAllAbsence(Student student) throws Exception;

    List<Absence> getAllRequestAbence(Teacher teacher) throws Exception;

    List<Student> getAllStudents() throws Exception;

    List<Absence> getDocumentetAbsence(Student user) throws Exception;

    PieChart getPieChart(Student student) throws Exception;

    List<String> getSchoolClasses(Teacher teacher) throws Exception;

    List<Absence> getUndocumentetAbsence(Student user) throws Exception;

    Student handleLoginRequestStudent(String username, String password) throws Exception;

    Teacher handleLoginRequestTeacher(String username, String password) throws Exception;

    boolean makeAbsenceRequest(Absence absence) throws Exception;

    boolean updateAbsence(Absence absence) throws Exception;
    
}
