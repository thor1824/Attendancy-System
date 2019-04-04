/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.bll.essentials;

import attendancesystem.be.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class PieChartGenerater {
    
    public static PieChart buildPieChard(Student student, int daysPresend, int daysUndocAbsence, int daysDocAbsence)
    {
        ObservableList<Data> pieData = FXCollections.observableArrayList(
                new Data("Days of Precense", daysPresend),
                new Data("Undocumentet Absence", daysUndocAbsence),
                new Data("Documentet Absence", daysDocAbsence)
        );

        PieChart pie = new PieChart(pieData);
        
        
        pie.setTitle("Absence");
        pie.setStartAngle(0);

        return pie;
    }
}
