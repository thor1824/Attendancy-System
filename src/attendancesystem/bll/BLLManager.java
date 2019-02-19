/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.bll;

import attendancesystem.be.Student;
import attendancesystem.be.Teacher;
import attendancesystem.dal.AbsenceDAO;
import attendancesystem.dal.TeacherDAO;
import java.util.List;

/**
 *
 * @author Nijas Hansen
 */
public class BLLManager{
    
    TeacherDAO teachDAO = new TeacherDAO();
    AbsenceDAO absenceDAO = new AbsenceDAO();
    
    public List<Student> getAllStudents() {
        return getAllStudents();
    }

    public String getTeacherID(Teacher teacher) {
        return teacher.getTeacherID();
    }

    
    public String getTeacherPassword(Teacher teacher) {
        return teacher.getPassword();
    }

    public Teacher generateTeachers() {
        return teachDAO.generateTeachers();
    }
    
    public void getAbsencedModuls(){
        absenceDAO.getget();
    }
    
    
}
