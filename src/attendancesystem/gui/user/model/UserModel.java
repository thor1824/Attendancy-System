/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.user.model;

import attendancesystem.be.Student;
<<<<<<< HEAD
import attendancesystem.bll.BLLManager;
=======
import attendancesystem.be.UndocumentetModulAbsence;
import attendancesystem.bll.BLLManager;
import java.util.ArrayList;
>>>>>>> 3c191971f24f2961dce908c1b708eed65e32ce35
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

 
/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class UserModel
<<<<<<< HEAD
{
    BLLManager bll;
=======
{   
    BLLManager bllMan;

    public UserModel() {
        bllMan = new BLLManager();
    }
    
    
>>>>>>> 3c191971f24f2961dce908c1b708eed65e32ce35

//    public String calculateDate()
//    {
//       
//        return date and time
//    }
    
    
<<<<<<< HEAD
    
//    
//    private PieChart buildPieChard(Student user){
//        ObservableList<PieChart.Data> pieChard = FXCollections.observableArrayList(
//        new PieChart.Data(bll.getAbsencedModuls()
=======
//    private PieChart buildPieChard(Student user){
//        ObservableList<PieChart.Data> pieChard = FXCollections.observableArrayList(
//        new PieChart.Data(""()),
>>>>>>> 3c191971f24f2961dce908c1b708eed65e32ce35
//        new PieChart.Data("",()));
//       
//        PieChart pie = new PieChart(pieChard);
//        return pie;
//    }
<<<<<<< HEAD
=======
    
    public boolean handleLoginRequestMock(String username, String password)
    {
        return bllMan.handleLoginRequestMock(username, password);
    }

    public ArrayList<UndocumentetModulAbsence> getUndocumentetAbsence() {
        return bllMan.getUndocumentetAbsence();
    }
>>>>>>> 3c191971f24f2961dce908c1b708eed65e32ce35
}
