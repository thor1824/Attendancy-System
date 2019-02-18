/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal;

import attendancesystem.be.Student;
import attendancesystem.be.Teacher;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nijas Hansen
 */
public class TeacherDAO {
    
    List<Student> students = new ArrayList<>();

    public List<Student> getAllStudents() {
        return getAllStudents();
    }
    
    public Teacher generateTeachers() {
        
        Teacher henriksen = new Teacher();
        henriksen.setName("Henriksen");
        henriksen.setTeacherID("Henriksen");
        henriksen.setPassword("Password");
        
        
        return henriksen;
    }
}
