/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.admin.controller;

import attendancesystem.be.Student;
import attendancesystem.be.User;
import attendancesystem.gui.admin.model.AdminModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Nijas Hansen
 */
public class SpecificStudentInfoController implements Initializable {

    @FXML
    private VBox vboxStudentInfo;

    private AdminModel adminmodel;
    private Student student;
    private User user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            adminmodel = new AdminModel();
        } catch (IOException ex) {
            Logger.getLogger(SpecificStudentInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setupVBox();
    }

    public void setupVBox() {

    }

    public void getInfo(Student student) {
        adminmodel.getAllAbsence(student);
    }

    public VBox getVboxStudentInfo() {
        return vboxStudentInfo;
    }

    public void setVboxStudentInfo(VBox vboxStudentInfo) {
        this.vboxStudentInfo = vboxStudentInfo;
    }

    public AdminModel getAdminmodel() {
        return adminmodel;
    }

    public void setAdminmodel(AdminModel adminmodel) {
        this.adminmodel = adminmodel;
    }

}
