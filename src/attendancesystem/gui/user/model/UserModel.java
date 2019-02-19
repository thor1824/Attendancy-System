/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.user.model;

import attendancesystem.be.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class UserModel
{

//    public String calculateDate()
//    {
//       
//        return date and time
//    }
    
    
    private PieChart buildPieChard(Student user){
        ObservableList<PieChart.Data> pieChard = FXCollections.observableArrayList(
        new PieChart.Data(""()),
        new PieChart.Data("",()));
       
        PieChart pie = new PieChart(pieChard);
        return pie;
    }
}
