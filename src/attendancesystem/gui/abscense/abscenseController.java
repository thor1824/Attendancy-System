/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.abscense;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Bruger
 */
public class abscenseController
{
    private int apHeight = 50;
    private int lblHeight = 12;
    private int lblVeticalMargin = (apHeight / 2) - (lblHeight / 2);
    private int lbl1 = 100; 
    private int lbl2 = 200;
    private int lbl3 = 300;
    private int combobox = 400;
    private int lblY = 4;
    
    public AnchorPane generateAbsenceElement(String dato, String fag, String modul)
    {
        
        Label lblDato = new Label(dato);
        Label lblFag = new Label(fag);
        Label lblModul = new Label(modul); 
        AnchorPane ap = new AnchorPane();
        ObservableList element = FXCollections.observableArrayList(
                "Syg",
                "Læge",
                "Forsent",
                "Andet");
        JFXComboBox comBox =  new JFXComboBox(element);
        comBox.setPromptText("Vælg fraværsårsag:");
        
        ap.getChildren().addAll(lblDato, lblFag, lblModul, comBox);
        lblDato.setLayoutX(lbl3);
        lblFag.setLayoutX(lbl1);
        lblModul.setLayoutX(lbl2);
        comBox.setLayoutX(combobox);
        lblDato.setLayoutY(lblY);
        lblFag.setLayoutY(lblY);
        lblModul.setLayoutY(lblY);
        
        return ap;
        
    }
    
    
}
