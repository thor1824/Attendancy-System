/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.admin.controller;

import attendancesystem.be.Absence;
import attendancesystem.gui.admin.model.AdminModel;
import attendancesystem.gui.elements.AbsenceRequestElement;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class AdminAbsenceHandlerController implements Initializable {
    
    Stage stage;
    List<Absence> absences;
    AdminModel model;
    
    @FXML
    private VBox vbAbsence;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vbAbsence.setPadding(new Insets(5, 5, 5, 5));
        vbAbsence.setSpacing(10);
        
    }    

    @FXML
    private void accAll(ActionEvent event) {
    
    }

    @FXML
    private void cancel(ActionEvent event) {
        stage.close();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setAbsences(List<Absence> absences) {
        this.absences = absences;
        
        for (Absence absence : absences) {
            System.out.println(absence);
            AbsenceRequestElement are = new AbsenceRequestElement(absence, model, );
            vbAbsence.getChildren().add(are.getAnchorPane());
        }
    }

    public void setModel(AdminModel model) {
        this.model = model;
    }
    
    
    
}
