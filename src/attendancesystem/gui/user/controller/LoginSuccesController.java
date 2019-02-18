/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.user.controller;

import attendancesystem.gui.user.model.UserModel;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class LoginSuccesController implements Initializable
{

    UserModel model;
    Stage stage;

    @FXML
    private Label lblArrivalTime;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(event -> stage.close());
        delay.play();
    }

    void setModel(UserModel model)
    {
        this.model = model;
    }

    void setStage(Stage stage)
    {
        this.stage = stage;
    }

    void setDate()
    {
       Calendar cal = Calendar.getInstance();
       lblArrivalTime.setText("Time of Arrival: " + cal.getTime().toString());
    }

}
