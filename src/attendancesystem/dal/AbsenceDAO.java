/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal;

import attendancesystem.be.UndocumentetModulAbsence;
import attendancesystem.be.User;
import java.util.ArrayList;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public interface AbsenceDAO
{

    void createAbsens();

    void deleteAbsens();

    void getAllAbsens();

    ArrayList<UndocumentetModulAbsence> getDocumentetAbsence(User user);

    ArrayList<UndocumentetModulAbsence> getUndocumentetAbsence(User user);

    void updateAbsens();
    
}
