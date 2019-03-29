/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.bll;

import attendancesystem.be.Student;
import attendancesystem.dal.AbsenceDAO;
import attendancesystem.dal.StudentDAO;
import attendancesystem.dal.db.StudentDbDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class PieChart
{
    
    
    public static javafx.scene.chart.PieChart buildPieChard(Student student, AbsenceDAO absenceDao, StudentDAO studenDao ) throws Exception {
        StudentDbDao db = new StudentDbDao();
        
        ObservableList<javafx.scene.chart.PieChart.Data> pieChard = FXCollections.observableArrayList(
                new javafx.scene.chart.PieChart.Data("Undocumentet Absence", absenceDao.linesIngetUndocumentetAbsence(student)),
                new javafx.scene.chart.PieChart.Data("Documentet Absence", absenceDao.linesIngetDocumentetAbsence(student)),
                new javafx.scene.chart.PieChart.Data("Days of Precense", db.daysOfClass(student)));
                

       
        javafx.scene.chart.PieChart pie = new javafx.scene.chart.PieChart(pieChard);
        pie.setTitle("Absence");
        pie.setStartAngle(10);
       
        return pie;
    }
}
