/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.admin.view;

import attendancesystem.be.Absence;
import attendancesystem.gui.elements.AbsenceRequestElement;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    
    @FXML
    private VBox vbAbsence;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
            AbsenceRequestElement are = new AbsenceRequestElement(absence);
            vbAbsence.getChildren().add(are.getAnchorPane());
        }
    }
    
    
    
}