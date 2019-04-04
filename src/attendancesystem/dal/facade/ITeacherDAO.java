/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.facade;

import attendancesystem.be.Teacher;
import java.util.List;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public interface ITeacherDAO
{

    public List<String> getSchoolClasses(Teacher teacher) throws Exception;

}
