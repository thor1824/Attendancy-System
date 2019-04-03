/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.user.controller;

import attendancesystem.be.Student;
import attendancesystem.be.Absence;
import attendancesystem.be.User;
import attendancesystem.gui.elements.AbsencentModulElement;
import attendancesystem.gui.user.model.UserModel;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Christian
 */
public class StudentMainController implements Initializable
{

    private Student user;
    private UserModel userModel;
    private PieChart pieChart;
    private Stage stage;
    private ArrayList<Absence> undocumentetAbsences;

    @FXML
    private AnchorPane pieChartAnchor;

    @FXML
    private VBox vBoxUndokumentet;

    public ArrayList<Student> liststudent;
    @FXML
    private Label lblPrecend;
    @FXML
    private Label lblUndoc;
    @FXML
    private Label lblDoc;
    @FXML
    private Label lblAbPro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

    }

    public void setUser(Student user) throws Exception
    {
        this.user = user;
        generateAbsenceElements(user);
        setPie();

    }

    public void setModel(UserModel userModel)
    {
        this.userModel = userModel;

    }

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }

    public void setPie() throws SQLException, SQLServerException, IOException
    {
        PieChart pie = userModel.getPieChard(user);
        pie.setPrefSize(333.0, 333.0);
        pie.setLabelsVisible(false);

        double sum = 0;
        double deviation = 0;
        for (PieChart.Data data : pie.getData())
        {

            String name = data.getName();
            if (name == "Undocumentet Absence")
            {
                deviation = deviation + data.getPieValue();
                sum = sum + data.getPieValue();
                lblUndoc.setText("" + (int) data.getPieValue());
            }
            if (name == "Documentet Absence")
            {
                deviation = deviation + data.getPieValue();
                sum = sum + data.getPieValue();
                lblDoc.setText("" + (int) data.getPieValue());
            }
            if (name == "Days of Precense")
            {
                sum = sum + data.getPieValue();
                lblPrecend.setText("" + (int) data.getPieValue());
            }
        }
        double procentage = deviation / sum * 100;
        DecimalFormat df = new DecimalFormat("#.00");
        lblAbPro.setText(df.format(procentage));

        pieChartAnchor.getChildren().add(pie);
        AnchorPane.setTopAnchor(pie, 10.0);
        AnchorPane.setLeftAnchor(pie, 10.0);

    }

    public void generateAbsenceElements(Student student) throws SQLException, Exception
    {

        List<Absence> undocumentedAbsences = userModel.getUndocumentetAbsence(student);
        undocumentedAbsences.addAll(userModel.getDocumentetAbsence(student));
        
        Collections.sort(undocumentedAbsences, new Comparator<Absence>()
        {
            @Override
            public int compare(Absence absence1, Absence absence2)
            {
                return Boolean.compare(absence1.isPending(), absence2.isPending());
            }
        });
        
        for (Absence undocumentedAbsence : undocumentedAbsences)
        {

            AbsencentModulElement ame = new AbsencentModulElement(undocumentedAbsence, vBoxUndokumentet);
            ame.setModel(userModel);
            vBoxUndokumentet.getChildren().add(ame.getAnchorPane());
        }
    }
    
    public void loginRandomStudent() {
        //Todo
        User user = userModel.getRandomStudent();
        
        
        
        
        
    }

//    
}
