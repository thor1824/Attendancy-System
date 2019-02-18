/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.admin.model;

import attendancesystem.be.Student;
import attendancesystem.be.Teacher;
import attendancesystem.bll.BLLManager;
import java.util.List;

/**
 *
 * @author Nijas Hansen
 */
public class AdminModel {
    
    BLLManager bllMan = new BLLManager();
    
    public List<Student> getAllStudents() {
        return bllMan.getAllStudents();
    }
    
    public String getTeacherID(Teacher teacher) {
        return bllMan.getTeacherID(teacher);
    }
    
    public String getTeacherPassword(Teacher teacher) {
        return bllMan.getTeacherPassword(teacher);
    }
    
    public Teacher generateTeachers() {
        return bllMan.generateTeachers();
    }
    
}
