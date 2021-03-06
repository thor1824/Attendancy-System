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
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class AdminAbsenceHandlerController implements Initializable
{

    Stage stage;
    List<Absence> absences;
    AdminModel model;
    Label label;

    @FXML
    private VBox vbAbsence;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        vbAbsence.setPadding(new Insets(5, 5, 5, 5));
        vbAbsence.setSpacing(10);

    }

    @FXML
    private void accAll(ActionEvent event)
    {

    }

    @FXML
    private void cancel(ActionEvent event)
    {
        stage.close();
    }

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }

    public void setAbsences(List<Absence> absences)
    {
        this.absences = absences;

        for (Absence absence : absences)
        {
            AbsenceRequestElement are = new AbsenceRequestElement(absence, model, vbAbsence);
            vbAbsence.getChildren().add(are.getAnchorPane());

        }
        vbAbsence.getChildren().addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Node> c)
            {
                label.setText(""+vbAbsence.getChildren().size());
            }
        });
    
    }

    public void setModel(AdminModel model)
    {
        this.model = model;
    }

    void setSizelbl(Label lblReqCount)
    {
        this.label = new Label("" + absences.size());
        lblReqCount.textProperty().bind(label.textProperty());
    }

}
