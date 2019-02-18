/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.admin.controller;

import attendancesystem.gui.elements.UserElement;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class AdminViewController implements Initializable
{
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
        UserElement user1 = new UserElement("Bo John", "10", "89898989", "Bo@email.com");
        UserElement user2 = new UserElement("Jens John", "10", "11111111", "Jens@email.com");
        UserElement user3 = new UserElement("Gert John", "10", "12345678", "Gert@email.com");
        hbxUserOverview.getChildren().addAll(user1.getUserPane(), user2.getUserPane(), user3.getUserPane());
        
        spUsers.setFitToWidth(true);

    }


}
