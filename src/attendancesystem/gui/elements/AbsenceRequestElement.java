/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.elements;

import attendancesystem.be.Absence;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class AbsenceRequestElement {
    
    
    
    private final double AP_WIDTH = 441.0;
    private final double AP_HIGHT = 60.0;
    private final double LBL_HIGHT = 20.0;
    private final double BTN_HIGHT = 15.0;
    private AnchorPane ap;
    private final Absence absence;
    public AbsenceRequestElement(Absence absence) {
        this.absence = absence;
        generateAnchorPane();
        generateLabels();
        genrateButtons();
        
    }

    private void generateAnchorPane() {
        DropShadow ds1 = new DropShadow();
        ds1.setOffsetY(4.0f);
        ds1.setOffsetX(4.0f);
        ds1.setColor(new Color(0.183, 0.183, 0.149, 1.0));
        
        ap = new AnchorPane();
        ap.setMaxSize(AP_WIDTH, AP_HIGHT);
        ap.setMinSize(AP_WIDTH, AP_HIGHT);
        ap.setPrefSize(AP_WIDTH, AP_HIGHT);
        ap.setEffect(ds1);
        ap.setStyle("-fx-background-color:lightgray");
        

    }

    private void genrateButtons() {
        JFXButton btnAccept = new JFXButton("Accept");
        btnAccept.setStyle("-fx-background-color:#4d79ff");
        btnAccept.setTextFill(new Color(1, 1, 1, 1.0));
        
        btnAccept.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Accepted");
            }
        });
        
        ap.getChildren().add(btnAccept);
        AnchorPane.setRightAnchor(btnAccept, 70.0);
        AnchorPane.setBottomAnchor(btnAccept, BTN_HIGHT);
        
        
        JFXButton btnDecline = new JFXButton("Decline");
        btnDecline.setStyle("-fx-background-color:#4d79ff");
        btnDecline.setTextFill(new Color(1, 1, 1, 1.0));
        btnDecline.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Declined");
            }
        });
        
        ap.getChildren().add(btnDecline);
        
        AnchorPane.setRightAnchor(btnDecline, 10.0);
        AnchorPane.setBottomAnchor(btnDecline, BTN_HIGHT);
    }

    private void generateLabels() {
        Label lblName = new Label(""+absence.getStudID());
        lblName.setWrapText(true);
        lblName.setAlignment(Pos.CENTER_LEFT);
        
        ap.getChildren().add(lblName);
        AnchorPane.setTopAnchor(lblName, 0.0);
        AnchorPane.setBottomAnchor(lblName, 0.0);
        AnchorPane.setLeftAnchor(lblName, 10.0);
        
        Label lblClass = new Label(""+absence.getSubjectID());
        ap.getChildren().add(lblClass);
        AnchorPane.setBottomAnchor(lblClass, LBL_HIGHT);
        AnchorPane.setLeftAnchor(lblClass, 110.0);
        
        Label lblDay = new Label(""+absence.getDate());
        ap.getChildren().add(lblDay);
        AnchorPane.setBottomAnchor(lblDay, LBL_HIGHT);
        AnchorPane.setLeftAnchor(lblDay, 180.0);
        
        Label lblReason = new Label(""+absence.getReason());
        ap.getChildren().add(lblReason);
        AnchorPane.setBottomAnchor(lblReason, LBL_HIGHT);
        AnchorPane.setLeftAnchor(lblReason, 250.0);
    }

    public AnchorPane getAnchorPane() {
        return ap;
    }
    
    
    
}
