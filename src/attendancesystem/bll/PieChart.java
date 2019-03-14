/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.bll;

import attendancesystem.be.User;
import attendancesystem.dal.StudentDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class PieChart
{
    
    public static javafx.scene.chart.PieChart buildPieChard(User user, StudentDAO sDao) {
        
        
        ObservableList<javafx.scene.chart.PieChart.Data> pieChard = FXCollections.observableArrayList(
                new javafx.scene.chart.PieChart.Data("Timer", 100),
                new javafx.scene.chart.PieChart.Data("Fravær", 10));

        javafx.scene.chart.PieChart pie = new javafx.scene.chart.PieChart(pieChard);
        return pie;
    }
}
