/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.elements;

import attendancesystem.be.Absence;
import attendancesystem.gui.user.controller.ReasonForAbsenceController;
import attendancesystem.gui.user.model.UserModel;
import com.jfoenix.controls.JFXButton;
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
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Bruger
 */
public class AbsencentModulElement
{

    private UserModel userModel;
    private AnchorPane ap;
    private VBox vBox;
    private Absence absence;
    private JFXComboBox comBox;
    private JFXButton btnSend;

    public AbsencentModulElement(Absence absence, VBox vBox)
    {
        this.absence = absence;
        this.vBox = vBox;

        createAnchorPane();
    }

    private void createAnchorPane()
    {

        DropShadow ds1 = new DropShadow();
        ds1.setOffsetY(4.0f);
        ds1.setOffsetX(4.0f);
        ds1.setColor(new Color(0.183, 0.183, 0.149, 1.0));

        ap = new AnchorPane();
        ap.setPrefHeight(60.0);

        ap.setStyle("-fx-background-color:lightGray");
        ap.setEffect(ds1);
        ap.setId("absenceAp");

        Label lblDato = new Label("Date:    " + absence.getDate());
        lblDato.setFont(new Font(14));
        ap.getChildren().add(lblDato);
        AnchorPane.setTopAnchor(lblDato, 16.5);
        AnchorPane.setLeftAnchor(lblDato, 200.0);

        Label lblFag = new Label("Class:    " + absence.getStuClass());
        lblFag.setFont(new Font(14));
        ap.getChildren().add(lblFag);
        AnchorPane.setTopAnchor(lblFag, 16.5);
        AnchorPane.setLeftAnchor(lblFag, 30.0);

        if (absence.isApproved())
        {
            Label lblApp = new Label("Approved");
            lblApp.setFont(new Font(13));
            ap.getChildren().add(lblApp);
            AnchorPane.setTopAnchor(lblApp, 16.5);
            AnchorPane.setRightAnchor(lblApp, 30.0);
            
            Label lblReason = new Label(absence.getReason());
            lblReason.setFont(new Font(13));
            ap.getChildren().add(lblReason);
            AnchorPane.setTopAnchor(lblReason, 16.5);
            AnchorPane.setRightAnchor(lblReason, 165.0);

        }
        else if (absence.isPending())
        {
            Label lblApp = new Label("Pending");
            lblApp.setFont(new Font(13));
            ap.getChildren().add(lblApp);
            AnchorPane.setTopAnchor(lblApp, 16.5);
            AnchorPane.setRightAnchor(lblApp, 30.0);

            Label lblReason = new Label(absence.getReason());
            lblReason.setFont(new Font(13));
            ap.getChildren().add(lblReason);
            AnchorPane.setTopAnchor(lblReason, 16.5);
            AnchorPane.setRightAnchor(lblReason, 165.0);

        } else
        {
            setupComboBox();
            setupButton();
        }

    }

    private void setupButton()
    {
        btnSend = new JFXButton("Send");
        btnSend.setPrefSize(65, 30);
        btnSend.setFont(new Font(14));
        btnSend.setId("btnSend");
        btnSend.setDisable(true);
        btnSend.setButtonType(JFXButton.ButtonType.RAISED);

        ap.getChildren().add(btnSend);
        AnchorPane.setTopAnchor(btnSend, 9.0);
        AnchorPane.setRightAnchor(btnSend, 15.0);

        btnSend.setOnAction((event) ->
        {
            try
            {
                String reason = comBox.getValue().toString();
                Label lblExplanation = new Label();
                if (comBox.getValue() == "Other")
                {
                    try
                    {

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/attendancesystem/gui/user/view/ReasonForAbsence.fxml"));

                        Parent root = loader.load();
                        Stage stage = new Stage();
                        stage.setAlwaysOnTop(true);
                        stage.setResizable(false);
                        stage.initStyle(StageStyle.UNDECORATED);
                        stage.setScene(new Scene(root));
                        ReasonForAbsenceController controller = loader.getController();

                        controller.setModel(userModel);
                        controller.setStage(stage);
                        controller.setExplanation(lblExplanation);

                        stage.showAndWait();

                    } catch (IOException ex)
                    {
                        Logger.getLogger(AbsencentModulElement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (comBox.getValue() != "Other")
                {
                    absence.setReason(reason);
                    absence.setPending(true);
                    userModel.makeAbsenceRequest(absence);
                    userModel.updateAbsence(absence);
                    vBox.getChildren().remove(ap);
                    AbsencentModulElement newAme = new AbsencentModulElement(absence, vBox);
                    vBox.getChildren().add(newAme.getAnchorPane());
                }
                if (comBox.getValue() == "Other" && !lblExplanation.getText().isEmpty())
                {
                    absence.setReason(reason);
                    absence.setExplanation(lblExplanation.getText());
                    absence.setPending(true);
                    userModel.makeAbsenceRequest(absence);
                    userModel.updateAbsence(absence);
                    vBox.getChildren().remove(ap);
                    AbsencentModulElement newAme = new AbsencentModulElement(absence, vBox);

                    vBox.getChildren().add(newAme.getAnchorPane());
                }
            } catch (Exception ex)
            {
                Logger.getLogger(AbsencentModulElement.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    private void setupComboBox()
    {
        ObservableList element = FXCollections.observableArrayList(
                "Sick",
                "Doctor",
                "Late",
                "Other");

        comBox = new JFXComboBox(element);
        comBox.setPromptText("Choose Cause:");
        comBox.setId("absCombo");
        comBox.setStyle("-fx-font-size : 13");
        comBox.setPrefSize(140, 35);

        ap.getChildren().add(comBox);
        AnchorPane.setTopAnchor(comBox, 7.0);
        AnchorPane.setRightAnchor(comBox, 110.0);

        comBox.setOnAction((Event event) ->
        {
            if (comBox.getValue() != comBox.getPromptText())
            {
                btnSend.setDisable(false);
            }

        });
    }

    public AnchorPane getAnchorPane()
    {
        return ap;
    }

    public void setModel(UserModel userModel)
    {
        this.userModel = userModel;

    }

}
