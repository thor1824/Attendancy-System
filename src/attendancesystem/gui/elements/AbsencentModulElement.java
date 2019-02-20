/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.elements;

import attendancesystem.be.UndocumentetModulAbsence;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Bruger
 */
public class AbsencentModulElement
{
    private int apHeight = 50;
    private int lblHeight = 12;
    private int lblVeticalMargin = (apHeight / 2) - (lblHeight / 2);
    private int lbl1 = 100; 
    private int lbl2 = 200;
    private int lbl3 = 300;
    private int comboBox = 400;
    private int lblY = 4;
    
    public void generateAbsenceElement(UndocumentetModulAbsence modAbsence, VBox vbox)
    {
        
        Label lblDato = new Label(modAbsence.getDate());
        Label lblFag = new Label(modAbsence.getSubject());
        Label lblModul = new Label(modAbsence.getModul()); 
        AnchorPane ap = new AnchorPane();
        vbox.getChildren().add(ap);
        ObservableList element = FXCollections.observableArrayList(
                "Sick",
                "DoctorAppointment",
                "Late",
                "Other");
        JFXComboBox comBox =  new JFXComboBox(element);
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
        comBox.setLayoutY(lblVeticalMargin + ((comBox.getHeight() - lblHeight)/2));
        
        
        comBox.setOnAction((Event event) -> {
            System.out.println(comBox.getValue());
            String explanation = comBox.getValue().toString();
//            if (comBox.getValue() == "Other")
//            {
//                //add a widow to write a message.
//            }
            modAbsence.setExplenation(explanation);
            vbox.getChildren().remove(ap);
        });
        
        
    }
    
    
}
