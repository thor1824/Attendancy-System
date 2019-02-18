/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.admin.controller;

import attendancesystem.be.Teacher;
import attendancesystem.gui.admin.model.AdminModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nijas Hansen
 */
public class LoginSceneController implements Initializable {
    
    private AdminModel model;
    private Teacher teacher;

    @FXML
    private ImageView imgviewAvatar;
    @FXML
    private JFXTextField txtfldTeacherID;
    @FXML
    private JFXPasswordField txtfldPassword;
    @FXML
    private JFXButton btnLogin;
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgviewAvatar.setImage(new Image("Resources/Images/Login-avatar.png"));
        model = new AdminModel();
        teacher = new Teacher();
        teacher = model.generateTeachers();
    }    
    
    @FXML
    private void handleLoginButton(MouseEvent event) {
        String username = txtfldTeacherID.getText();
        String password = txtfldPassword.getText();
        
        if (username.equals(model.getTeacherID(teacher)) && password.equals(model.getTeacherPassword(teacher))) {
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.close();
            
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            
            alert.setTitle("Incorrect input");
            alert.setHeaderText("TeacherID or Password are incorrect");
            alert.setContentText("Please confirm your input or contact system administrator");
            
            alert.show();
        }
        
    }
    
}
