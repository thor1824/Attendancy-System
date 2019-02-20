/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.user.model;

import attendancesystem.be.Student;
import attendancesystem.be.UndocumentetModulAbsence;
import attendancesystem.bll.BLLManager;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class UserModel
{   
    BLLManager bllMan;

    public UserModel() {
        bllMan = new BLLManager();
    }
    
    

//    public String calculateDate()
//    {
//       
//        return date and time
//    }
    
    
//    private PieChart buildPieChard(Student user){
//        ObservableList<PieChart.Data> pieChard = FXCollections.observableArrayList(
//        new PieChart.Data(""()),
//        new PieChart.Data("",()));
//       
//        PieChart pie = new PieChart(pieChard);
//        return pie;
//    }
    
    public boolean handleLoginRequestMock(String username, String password)
    {
        return bllMan.handleLoginRequestMock(username, password);
    }

    public ArrayList<UndocumentetModulAbsence> getUndocumentetAbsence() {
        return bllMan.getUndocumentetAbsence();
    }
}
