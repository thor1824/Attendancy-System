/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.user.controller;

import attendancesystem.be.Student;
import attendancesystem.be.Absence;
import attendancesystem.gui.elements.AbsencentModulElement;
import attendancesystem.gui.user.model.UserModel;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Christian
 */
public class StudentMainController implements Initializable {

    private Student user;
    private UserModel userModel;
    private Stage stage;
    private ArrayList<Absence> undocumentetAbsences;
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

    @FXML
    private Tab tabAbsence;
    @FXML
    private VBox vBoxUndokumentet;

    public ArrayList<Student> liststudent;
    @FXML
    private AnchorPane apReason;
    @FXML
    private JFXTextField txtfldReason;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

            grid.setStyle("-fx-border-color:black");
            
            System.out.println(userModel);
            
            this.user = userModel.getLogedInStudent();

            //setPie();

            addToHMap(user);

        } catch (Exception ex) {
            Logger.getLogger(StudentMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateAbsenceElements() throws Exception {
        undocumentetAbsences = new ArrayList<>();
        undocumentetAbsences = userModel.getUndocumentetAbsence(user);

//        for (UndocumentetModulAbsence undocumentetModulAbsence : undocumentetAbsences) {
//            System.out.println("hej");
//            abModEle.generateAbsenceElement(undocumentetModulAbsence, vBoxUndokumentet);
//        }
    }

    public void setUser(Student user) throws Exception {
        this.user = user;
        System.out.println(user);

    }

    public void setModel(UserModel userModel) {
        this.userModel = userModel;

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setPie() {
        pieChartAnchor.getChildren().add(userModel.getPieChard(user));

    }

    public void addToHMap(Student student) throws SQLException, Exception {
        System.out.println(student);
        ArrayList<Absence> list = userModel.getUndocumentetAbsence(student);
        int i = 0;

        System.out.println(list);

        for (Absence absence : list) {
            AbsencentModulElement ame = new AbsencentModulElement(vBoxUndokumentet, absence, userModel);

            vBoxUndokumentet.getChildren().add(ame.getAnchorPane());

//            Label modul = new Label(undocumentetModulAbsence.getModul());
//            Label date = new Label(undocumentetModulAbsence.getDate());
//            Label subject = new Label(undocumentetModulAbsence.getSubject());
//            Label absHours = new Label(undocumentetModulAbsence.getAbsenceHours());
//            Label absProcent = new Label(undocumentetModulAbsence.getAbsenceProcent());
//            
//            
//            grid.add(modul, 0, i + 1);
//            grid.add(date, 1, i + 1);
//            grid.add(subject, 2, i + 1);
//            grid.add(absHours, 3, i + 1);
//            grid.add(absProcent, 4, i + 1);
//            i++;
        }
    }

//    private void addLabelsSub() {
//        int start = 2;
//
//        for (int i = 0; i < liststudent.size(); i++) {
//            Label label = new Label();
//            grid.add(label, 0, start);
//            label.setText(liststudent.get(i).toString());
//            start++;
//            
//        }
// 
//    }
//    private void addLabelsHa() {
//        int start = 2;
//        for (Integer ha : hMap.values()) {
//            Label label = new Label();
//            grid.add(label, 2, start);
//            label.setText((ha.toString()));
//            start++;
//        }
//    }
}
