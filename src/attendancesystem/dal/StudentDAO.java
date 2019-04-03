/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal;

import attendancesystem.be.Student;
import java.util.List;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public interface StudentDAO
{
    boolean createStudent(Student user, String username, String password) throws Exception;

    boolean deleteStudent(Student user)  throws Exception;

    List<Student> getAllStudents()  throws Exception;
    
    List<Student> getStudentsFromClass(String className)  throws Exception;

    Student getStudent(int id)  throws Exception;

    boolean updateStudent(Student user)  throws Exception;
    
    int getDaysOfClass(Student user) throws Exception;
    
    boolean setUserImage(Student user, String picURL)  throws Exception;

}
