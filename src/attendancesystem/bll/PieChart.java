/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.bll;

import attendancesystem.be.Student;
import attendancesystem.be.User;
import attendancesystem.dal.StudentDAO;
import attendancesystem.dal.db.AbsenceDbDao;
import attendancesystem.dal.db.StudentDbDao;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class PieChart
{
    
    
    public static javafx.scene.chart.PieChart buildPieChard(Student student, AbsenceDbDao aDao) throws SQLException, SQLServerException, IOException {
        StudentDbDao db = new StudentDbDao();
        
        ObservableList<javafx.scene.chart.PieChart.Data> pieChard = FXCollections.observableArrayList(
                new javafx.scene.chart.PieChart.Data("Undocumentet Absence", aDao.getUndocumentetAbsence((Student) student).size()),
                new javafx.scene.chart.PieChart.Data("Fravær", aDao.getDocumentetAbsence((Student) student).size()),
                new javafx.scene.chart.PieChart.Data("Antalet af dage", db.daysOfClass((Student) student)));
                

       
        javafx.scene.chart.PieChart pie = new javafx.scene.chart.PieChart(pieChard);
        pie.setTitle("Diagram over fravær");
        pie.setStartAngle(10);
       
        return pie;
    }
}
