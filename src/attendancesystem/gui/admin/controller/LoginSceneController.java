/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.admin.controller;

import attendancesystem.be.Teacher;
import attendancesystem.be.User;
import attendancesystem.gui.admin.model.AdminModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nijas Hansen
 */
public class LoginSceneController implements Initializable
{
    
    private final String MAIN_FXML = "attendancesystem/gui/admin/view/AdminView.fxml";
    private AdminModel model;
    private Teacher teacher;
    private Stage stage;

    @FXML
    private ImageView imgviewAvatar;
    @FXML
    private JFXTextField txtfldTeacherID;
    @FXML
    private JFXPasswordField txtfldPassword;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private Label lblLogMessage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        imgviewAvatar.setImage(new Image("Resources/Images/Login-avatar.png"));
        this.model = new AdminModel();
    }

    @FXML
    private void handleLoginButton(MouseEvent event) throws IOException
    {
        String username = txtfldTeacherID.getText();
        String password = txtfldPassword.getText();
        
        try
        {
            System.out.println("ho");
            User user = model.handleLoginRequestMock(username, password);
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(MAIN_FXML));
            
            Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            AdminViewController controller = loader.getController();
            controller.setStage(newStage);
            controller.setUser(user);
            newStage.setMaximized(true);
            newStage.show();
            stage.close();
            
        } catch (NullPointerException e)
        {
            e.printStackTrace();
            lblLogMessage.setStyle("-fx-text-fill:red");
            lblLogMessage.setText("WRONG PASSWORD!!");
        }
        

    }

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }

    void setModel(AdminModel model)
    {
        this.model = model;
    }
}
