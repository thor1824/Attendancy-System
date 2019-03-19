/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.user.controller;

import attendancesystem.be.Student;
import attendancesystem.gui.user.model.UserModel;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class UserViewController implements Initializable
{

    private static final String FAILED_FXML = "attendancesystem/gui/user/view/LoginFailed.fxml";
    private static final String LATE_FXML = "attendancesystem/gui/user/view/LoginLate.fxml";
    private static final String SUCCES_FXML = "attendancesystem/gui/user/view/LoginSucces.fxml";
    private static final String MAIN_FXML = "attendancesystem/gui/user/view/StudentMain.fxml";
    private UserModel model;

    @FXML
    private Button btnLogin;
    @FXML
    private Button btnSucces;
    @FXML
    private Button btnLate;
    @FXML
    private Button btnFailed;
    @FXML
    private JFXTextField txtUserName;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private Label lblLoginMessage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        model = new UserModel();
    }

    @FXML
    private void btnSuccesPress(ActionEvent event) throws IOException
    {

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(SUCCES_FXML));

        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root));
        LoginSuccesController controller = loader.getController();
        controller.setModel(model);
        controller.setStage(stage);
        controller.setDate();
        stage.showAndWait();

    }

    @FXML
    private void btnLatePress(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(LATE_FXML));

        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root));
        LoginLateController controller = loader.getController();
        controller.setModel(model);
        controller.setStage(stage);
        controller.setDate();
        stage.showAndWait();

//        controller.setModel(model);
//        controller.setStage(stage);
    }

    @FXML
    private void btnFailedPress(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(FAILED_FXML));

        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root));
        LoginFailedController controller = loader.getController();
        controller.setModel(model);
        controller.setStage(stage);
        stage.showAndWait();

//        controller.setModel(model);
//        controller.setStage(stage);
    }

    @FXML
    private void btnLoginPress(ActionEvent event) throws IOException
    {

        try
        {
            Student user = model.handleLoginRequestStudent(txtUserName.getText(), txtPassword.getText());
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(MAIN_FXML));
            
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setAlwaysOnTop(true);
            stage.setResizable(false);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            StudentMainController controller = loader.getController();
            controller.setModel(model);
            controller.setStage(stage);
            controller.setUser(user);
            stage.show();
        } catch (Exception e)
        {
            lblLoginMessage.setStyle("-fx-text-fill:red");
            lblLoginMessage.setText("WRONG PASSWORD!!");
        }

    }

}
