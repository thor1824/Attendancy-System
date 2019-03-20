/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.elements;

import attendancesystem.be.UndocumentetModulAbsence;
import attendancesystem.be.User;
import attendancesystem.gui.user.controller.ReasonForAbsenceController;
import attendancesystem.gui.user.model.UserModel;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Bruger
 */
public class AbsencentModulElement {

    private UserModel userModel;
    private User user;
    private int apHeight = 50;
    private int lblHeight = 12;
    private int lblVeticalMargin = (apHeight / 2) - (lblHeight / 2);
    private int lbl1 = 100;
    private int lbl2 = 200;
    private int lbl3 = 300;
    private int comboBox = 400;
    private int lblY = 4;
    private AnchorPane ap;

    public AbsencentModulElement(UndocumentetModulAbsence modAbsence, VBox vBox, UserModel model) {

        
        Label lblDato = new Label(modAbsence.getDate());
        Label lblFag = new Label(modAbsence.getSubject());
        Label lblModul = new Label(modAbsence.getModul());
        ap = new AnchorPane();

        ObservableList element = FXCollections.observableArrayList(
                "Sick",
                "DoctorAppointment",
                "Late",
                "Other");
        JFXComboBox comBox = new JFXComboBox(element);
        comBox.setPromptText("Vælg fraværsårsag:");

        ap.getChildren().addAll(lblDato, lblFag, lblModul, comBox);
        ap.setStyle("-fx-border-color:black");
        lblDato.setLayoutX(lbl3);
        lblFag.setLayoutX(lbl1);
        lblModul.setLayoutX(lbl2);
        comBox.setLayoutX(comboBox);
        lblDato.setLayoutY(lblVeticalMargin);
        lblFag.setLayoutY(lblVeticalMargin);
        lblModul.setLayoutY(lblVeticalMargin);
        comBox.setLayoutY(lblVeticalMargin + ((comBox.getHeight() - lblHeight) / 2));

        comBox.setOnAction((Event event) -> {
            String explanation = comBox.getValue().toString();
            String reason = "";
            if (comBox.getValue() == "Other") {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/attendancesystem/gui/user/view/ReasonForAbsence.fxml"));
                    
                    Parent root = loader.load();
                    Stage stage = new Stage();
                    stage.setAlwaysOnTop(true);
                    stage.setResizable(false);
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.setScene(new Scene(root));
                    ReasonForAbsenceController controller = loader.getController();
                    
                    controller.setModel(model);
                    controller.setStage(stage);
                    
                    stage.showAndWait();
                } catch (IOException ex) {
                    Logger.getLogger(AbsencentModulElement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            modAbsence.setExplenation(explanation);
            sendToDb(explanation);
            vBox.getChildren().remove(ap);
        });

    }

    public AnchorPane getAnchorPane() {
        return ap;
    }

    public String sendToDb(String value) {
        return value;
    }
    

    public void setModel(UserModel userModel) {
        this.userModel = userModel;

    }

}
