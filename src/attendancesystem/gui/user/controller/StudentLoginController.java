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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class StudentLoginController implements Initializable
{

    private static final String FAILED_FXML = "attendancesystem/gui/user/view/LoginFailed.fxml";
    private static final String SUCCES_FXML = "attendancesystem/gui/user/view/LoginSucces.fxml";
    private static final String MAIN_FXML = "attendancesystem/gui/user/view/StudentMain.fxml";
    private UserModel model;
    private Stage currentStage;

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
    private void btnSuccesPress(ActionEvent event)
    {

        if (model.scan())
        {
            try
            {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(SUCCES_FXML));

                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setAlwaysOnTop(true);
                stage.setResizable(false);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(new Scene(root));
                LoginSuccesController controller = loader.getController();
                controller.setStage(stage);
                controller.setDate();

                stage.showAndWait();
            } catch (IOException ex)
            {
                Logger.getLogger(StudentLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else
        {
            try
            {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(FAILED_FXML));

                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setAlwaysOnTop(true);
                stage.setResizable(false);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(new Scene(root));
                LoginFailedController controller = loader.getController();
                controller.setStage(stage);
                stage.showAndWait();
            } catch (IOException ex)
            {
                Logger.getLogger(StudentLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    private void btnLoginPress(ActionEvent event) throws IOException, Exception
    {

        try
        {

            Student user = model.handleLoginRequest(txtUserName.getText(), txtPassword.getText());

            if (user != null)
            {
                model.setLogedInStudent(user);
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
                currentStage.close();
            } else
            {
                throw new Exception();
            }
        } catch (NullPointerException e)
        {
            e.printStackTrace();
            lblLoginMessage.setStyle("-fx-text-fill:red");
            lblLoginMessage.setText("WRONG PASSWORD!!");
        }

    }

    public void setStage(Stage stage)
    {
        this.currentStage = stage;
    }

}
