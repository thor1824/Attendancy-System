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
    
    List<Student> students;

    public StudentDAO()
    {
        students = new ArrayList<>();
        //Create mockdata here
    }
    
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        
        return students;
    }
}
