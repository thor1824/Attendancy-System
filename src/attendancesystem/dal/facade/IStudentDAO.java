/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.facade;

import attendancesystem.be.Student;
import java.util.List;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public interface IStudentDAO
{

    public boolean createStudent(Student user, String username, String password) throws Exception;

    public List<Student> getAllStudents() throws Exception;

    public int getDaysOfClass(Student user) throws Exception;

    public boolean addDaysOfClass(int randomNumber) throws Exception;

}
