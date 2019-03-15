/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.Mock;

import attendancesystem.be.UndocumentetModulAbsence;
import attendancesystem.be.User;
import attendancesystem.dal.AbsenceDAO;
import java.util.ArrayList;

/**
 *
 * @author Christian
 */
public class AbsenceMockDAO implements AbsenceDAO{
    ArrayList<UndocumentetModulAbsence> undocumentet;
    public AbsenceMockDAO() {
        undocumentet = new ArrayList<>();
        UndocumentetModulAbsence mod1 = new UndocumentetModulAbsence("1", "02-22-2019", "ITO", "2", "4%");
        UndocumentetModulAbsence mod2 = new UndocumentetModulAbsence("2", "02-22-2019", "SCO", "15", "30%");
        UndocumentetModulAbsence mod3 = new UndocumentetModulAbsence("3", "02-22-2019", "SDE", "5", "10%");
        undocumentet.add(mod1);
        undocumentet.add(mod2);
        undocumentet.add(mod3);
         
    }
    

    public ArrayList<UndocumentetModulAbsence> getUndocumentetAbsence(User user) {
        
        return undocumentet;
    }

    @Override
    public void createAbsens()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAbsens()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getAllAbsens()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<UndocumentetModulAbsence> getDocumentetAbsence(User user)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateAbsens()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
