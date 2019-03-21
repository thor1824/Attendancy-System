/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.user.controller;

import attendancesystem.be.Student;
import attendancesystem.be.Absence;
import attendancesystem.gui.elements.AbsencentModulElement;
import attendancesystem.gui.user.model.UserModel;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Christian
 */
public class StudentMainController implements Initializable {

    private Student user;
    private UserModel userModel;
    private Stage stage;
    private ArrayList<Absence> undocumentetAbsences;
    @FXML
    private GridPane grid;
    @FXML
    private Label fraværTimer;
    @FXML
    private Label alleTimer;
    @FXML
    private Label fraværProcent;
    @FXML
    private Label fraværTimer2;
    @FXML
    private Label fraværTimer3;
    @FXML
    private Label fraværTimer4;
    @FXML
    private Label fraværTimer5;
    @FXML
    private Label fraværTimer6;
    @FXML
    private AnchorPane pieChartAnchor;

    @FXML
    private Tab tabAbsence;
    @FXML
    private VBox vBoxUndokumentet;

    public ArrayList<Student> liststudent;
    @FXML
    private AnchorPane apReason;
    @FXML
    private JFXTextField txtfldReason;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

            grid.setStyle("-fx-border-color:black");
           
            
            
            

            //setPie();

            

        } catch (Exception ex) {
            Logger.getLogger(StudentMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

    public void setUser(Student user) throws Exception {
        this.user = user;
        System.out.println(user);
        System.out.println("hej");
        generateAbsenceElements(user);
        setPie();

    }

    public void setModel(UserModel userModel) {
        this.userModel = userModel;

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setPie() {
        pieChartAnchor.getChildren().add(userModel.getPieChard(user));

    }

    public void generateAbsenceElements(Student student) throws SQLException, Exception {
        System.out.println(student);
        ArrayList<Absence> list = userModel.getUndocumentetAbsence(student);
        
        
        System.out.println(list);

        for (Absence absence : list) {
            System.out.println(absence.getAbsenceID());
            AbsencentModulElement ame = new AbsencentModulElement(vBoxUndokumentet, absence, userModel);

            

        }
    }

//    
}
