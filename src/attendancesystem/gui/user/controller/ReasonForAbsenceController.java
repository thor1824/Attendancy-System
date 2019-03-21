/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.user.controller;

import attendancesystem.gui.user.model.UserModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nijas Hansen
 */
public class ReasonForAbsenceController implements Initializable {
    
    private UserModel userModel;
    private Stage stage;
    private String explanation;

    @FXML
    private AnchorPane apReason;
    @FXML
    private JFXTextField txtfldReason;
    @FXML
    private JFXButton btnCancel;
    @FXML
    private JFXButton btnSend;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
    
    
    public void setModel(UserModel userModel) {
        this.userModel = userModel;

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void handleCancelBtn(MouseEvent event) {
         stage.close();
    }

    @FXML
    private void handleSendBtn(MouseEvent event) {
        
    }
    
}
