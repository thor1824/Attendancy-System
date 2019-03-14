/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal.Mock;

import attendancesystem.be.UndocumentetModulAbsence;
import attendancesystem.be.User;
import java.util.ArrayList;

/**
 *
 * @author Christian
 */
public class AbsenceMockDAO {
    ArrayList<UndocumentetModulAbsence> undocumentet;
    public AbsenceMockDAO() {
        undocumentet = new ArrayList<>();
        UndocumentetModulAbsence mod1 = new UndocumentetModulAbsence("1", "02-22-2019", "SCO");
        UndocumentetModulAbsence mod2 = new UndocumentetModulAbsence("2", "02-22-2019", "SCO");
        UndocumentetModulAbsence mod3 = new UndocumentetModulAbsence("3", "02-22-2019", "SDE");
        undocumentet.add(mod1);
        undocumentet.add(mod2);
        undocumentet.add(mod3);
         
    }
    

    public ArrayList<UndocumentetModulAbsence> getUndocumentetAbsence(User user) {
        
        return undocumentet;
    }
    
    
    
}
