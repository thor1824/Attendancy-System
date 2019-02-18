/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.dal;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Bruger
 */
public class FraværDAO
{
    public ObservableList combBox()
    {
        ObservableList<String> fravaer = FXCollections.observableArrayList(
                "Syg",
                "Læge",
                "Forsent",
                "Andet");
        return fravaer;
    }
    
    public ArrayList<String> dato()
    {
        ArrayList<String> date = new ArrayList();
        
        date.add(0, "02-01-2019");
        date.add(1, "09-01-2019");
        date.add(2, "02-02-2019");
        
        return date;
    }
    
    public ArrayList<String> fag()
    {
        ArrayList<String> fag = new ArrayList();
        
        fag.add(0, "SCO");
        fag.add(1, "SDE");
        fag.add(2, "ITO");
        
        return fag;
    }
    
    public ArrayList<String> modul()
    {
        ArrayList<String> modul = new ArrayList();
        
        modul.add(0, "1. lektion");
        modul.add(1, "2. lektion");
        modul.add(2, "3. lektion");
        
        return modul;
    }
}
