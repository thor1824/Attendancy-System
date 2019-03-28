/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.admin.controller;

import attendancesystem.be.Absence;
import attendancesystem.be.Student;
import attendancesystem.gui.admin.model.AdminModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nijas Hansen
 */
public class SpecificStudentInfoController implements Initializable {

    private AdminModel adminmodel;
    private Student student;
    private Stage stage;
    @FXML
    private ListView<Absence> lstviewAbsenceInfo;
    private AnchorPane ap;
    @FXML
    private JFXButton btnCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            adminmodel = new AdminModel();
            makeButton();

        } catch (IOException ex) {
            Logger.getLogger(SpecificStudentInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void makeButton() {
        btnCancel.setText("Cancel");
        AnchorPane.setBottomAnchor(btnCancel, 30.0);
        AnchorPane.setRightAnchor(btnCancel, 70.0);
        btnCancel.setStyle("-fx-background-color:#4d79ff");
        btnCancel.setTextFill(new Color(1, 1, 1, 1.0));
        
        btnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });
    }

    public void setStudent(Student student) {
        this.student = student;
        List<Absence> absences = adminmodel.getAllAbsence(student);

        lstviewAbsenceInfo.getItems().addAll(absences);
    }

    public void setStage(Stage newStage) {
        this.stage = newStage;
    }

}
