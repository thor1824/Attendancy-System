/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.main;

import attendancesystem.bll.PasswordEncryptor;
import attendancesystem.gui.admin.controller.LoginSceneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class AdminStart extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("attendancesystem/gui/admin/view/LoginScene.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        LoginSceneController controller = loader.getController();

        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        controller.setStage(stage);

        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}
