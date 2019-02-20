/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal;

import attendancesystem.be.UndocumentetModulAbsence;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Christian
 */
public class AbsenceDAO {
    HashMap<String, String> map1;
    HashMap<String, String> map2;
    HashMap<String, String> map3;
    HashMap<String, HashMap> mainMap;
    
    public AbsenceDAO() {
        map1 = createModulHashMap("10", "10", "22", "ITO", "John");
        map2 = createModulHashMap("10", "3", "10", "STD", "Jehova");
        map3 = createModulHashMap("10", "5", "99", "SCO", "Leming");
        
        mainMap = new HashMap<>();
        mainMap.put("ITO", map1);
        mainMap.put("STD", map2);
        mainMap.put("SCO", map3);
         
    }
    
    
    public HashMap<String, String> createModulHashMap(String StudenterID, String fraværendeTimer, String timerIAlt, String modulNavn, String lære ){
     HashMap<String, String> hMap = new HashMap<>();
     hMap.put("studentID", StudenterID);
     hMap.put("fraværendeTimer", fraværendeTimer);
     hMap.put("timerIAlt", timerIAlt);
     hMap.put("modulNavn", modulNavn);
     hMap.put("lære", lære);
     
     return hMap;
    }
    
    public HashMap<String, HashMap> getget()
    {
    return mainMap;
    }

    public ArrayList<UndocumentetModulAbsence> getUndocumentetAbsence() {
        ArrayList<UndocumentetModulAbsence> undocumentet = new ArrayList<>();
        UndocumentetModulAbsence mod1 = new UndocumentetModulAbsence("1", "02-22-2019", "SCO");
        UndocumentetModulAbsence mod2 = new UndocumentetModulAbsence("2", "02-22-2019", "SCO");
        UndocumentetModulAbsence mod3 = new UndocumentetModulAbsence("3", "02-22-2019", "SDE");
        undocumentet.add(mod1);
        undocumentet.add(mod2);
        undocumentet.add(mod3);
        return undocumentet;
    }
    
    
    
}
