/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.user.controller;

import attendancesystem.gui.user.model.UserModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    private Label label;

    @FXML
    private AnchorPane apReason;
    @FXML
    private JFXTextArea txtfldReason;
    @FXML
    private JFXButton btnCancel;
    @FXML
    private JFXButton btnSend;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnSend.setDisable(true);
        
        label = new Label();
        
        txtfldReason.textProperty().addListener((obs, oldV, newV) -> {
        
            if (txtfldReason.getText().length() > 10)
            {
                btnSend.setDisable(false);
            }
            
        });
    }    

    public void bindExplanation(Label explanation) {
        explanation.textProperty().bind(label.textProperty());
        
    }
    
    
    public void setModel(UserModel userModel) {
        this.userModel = userModel;

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    @FXML
    private void handleCancelBtn(ActionEvent event)
    {
        stage.close();
    }

    @FXML
    private void handleSendBtn(ActionEvent event)
    {
        label.setText(txtfldReason.getText());
        stage.close();
    }
    
}
