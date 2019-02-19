/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.admin.controller;

import attendancesystem.gui.admin.model.AdminModel;
import attendancesystem.gui.elements.UserElement;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class AdminViewController implements Initializable
{
    AdminModel model;
    
    @FXML
    private VBox hbxUserOverview;
    @FXML
    private ScrollPane spUsers;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        model = new AdminModel();
        UserElement user1 = new UserElement("Bo John", "10", "89898989", "Bo@email.com");
        UserElement user2 = new UserElement("Jens John", "10", "11111111", "Jens@email.com");
        UserElement user3 = new UserElement("Gert John", "10", "12345678", "Gert@email.com");
        hbxUserOverview.getChildren().addAll(user1.getUserPane(), user2.getUserPane(), user3.getUserPane());
        
        spUsers.setFitToWidth(true);

        try {
            startLoginScreen();
        } catch (IOException ex) {
        }
    }
    
    private void startLoginScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("attendancesystem/gui/admin/view/LoginScene.fxml"));

        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        LoginSceneController controller = loader.getController();
        controller.setModel(model);
        controller.setStage(stage);
        
        
        stage.showAndWait();
        
        
        
    }


}
