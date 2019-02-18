/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal;

import attendancesystem.be.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nijas Hansen
 */
public class StudentDAO {
    
    List<Student> students = new ArrayList<>();
    
    public List<Student> getAllStudents() {
        
        Student jens = new Student();
        jens.setName("Jens");
        jens.setSchoolClass("cs2018a");
        jens.seteMail("jen213@easv.dk");
        
        Student per = new Student();
        per.setName("Per");
        per.setSchoolClass("cs2018b");
        per.seteMail("per2319@easv.dk");
        
        
        students.add(jens);
        students.add(per);
        
        return students;
    }
}
