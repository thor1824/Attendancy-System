/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.user.controller;

import attendancesystem.be.Student;
import attendancesystem.gui.user.model.UserModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Christian
 */
public class StudentMainController implements Initializable {

    private Student user;
    private UserModel usermodel;
    
    @FXML
    private GridPane grid;
    @FXML
    private Label fraværTimer;
    @FXML
    private Label alleTimer;
    @FXML
    private Label fraværProcent;
    @FXML
    private Label fraværTimer2;
    @FXML
    private Label fraværTimer3;
    @FXML
    private Label fraværTimer4;
    @FXML
    private Label fraværTimer5;
    @FXML
    private Label fraværTimer6;
    @FXML
    private AnchorPane pieChartAnchor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    public void setUser(Student user){
        this.user = user;
    }
    
    public void setModel (UserModel userModel){
        this.usermodel = userModel;
    }
    
    
}
