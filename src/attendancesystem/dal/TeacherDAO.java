/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal;

import attendancesystem.be.Teacher;
import attendancesystem.be.User;
import java.util.List;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public interface TeacherDAO
{

    void createTeacher(User user);

    void deleteTeacher(User user);

    void getAllTeachers();

    void getTeacher(User user);

    void updateTeacher(User user);

    public List<String> getSchoolClasses(Teacher teacher) throws Exception;
    
}
