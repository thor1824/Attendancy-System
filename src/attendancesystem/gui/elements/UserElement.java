/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.elements;

import attendancesystem.be.Student;
import attendancesystem.bll.BLLManager;
import attendancesystem.bll.PieChart;
import attendancesystem.gui.admin.controller.SpecificStudentInfoController;
import attendancesystem.gui.admin.model.AdminModel;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class UserElement
{

    private String defaultUserImageURL = "Resources/Images/deafultUserImage.png";
    private boolean previewMode = false;
    private int apUserPreviewHeight = 180;
    private int apUserRealHight = 600;
    private int ivMarginH = 15;
    private int ivMarginV = 15;
    private int ivWitgh = 150;
    private int ivHight = 150;
    private int ivWithMarginWidth = ivWitgh + (ivMarginH * 2); //there are ar margin on both sides of the ImageView
    private int lblVerticalOffset = 10;
    private int lblSize = 12;
    private int lblPreview_X = ivWithMarginWidth + lblVerticalOffset; //the X koordianate of the Labels containing Preview Info in the Preview AnchorPane
    private int numberOflblPreviews = 4; // number of labels show when the anchor pane is in preview mode
    private int lblNameOrder = 1; //Placement in a decending order
    private int lblIdOrder = 2; //placment in a decending order
    private int lblPhoneOrder = 3; //placement in a decending order
    private int lblEmailOrder = 4; //placement in a decending order
    private double lblDisplacementModifier = ivHight / (numberOflblPreviews * 2); //Modifies the spaces between the preview labels
    private double lblUserID_Y = (apUserPreviewHeight / numberOflblPreviews) * lblIdOrder - lblDisplacementModifier - lblSize;
    private double lblUserFullName_Y = (apUserPreviewHeight / numberOflblPreviews) * lblNameOrder - lblDisplacementModifier - lblSize;
    private double lblUserPhoneNr_Y = (apUserPreviewHeight / numberOflblPreviews) * lblPhoneOrder - lblDisplacementModifier - lblSize;
    private double lblUserEmail_Y = (apUserPreviewHeight / numberOflblPreviews) * lblEmailOrder - lblDisplacementModifier - lblSize;
    private double btnMaximizeHeight = 35;
    private double btnMaximizeWidth = 100;
    private double btnMaximizeMargin = 15;
    private double btnMaximize_TopAnchor = apUserPreviewHeight - btnMaximizeHeight - btnMaximizeMargin;
    private double btnMaximize_RightAnchor = btnMaximizeMargin;
    private double leftLabelAncor = 15.0;
    private double MoreLabelsToTop = 6.0;
    private AnchorPane apUser;
    private AnchorPane apMoreUserInfo;
    private final Student student;
    private AdminModel adminModel;

    public UserElement(Student student)
    {
        this.student = student;
        
        createPreviewPane();
    }

    private void createPreviewPane() {
        //Setup UserElement
        this.apUser = new AnchorPane();
        apUser.setStyle("-fx-background-color:#e6e6e6");
        //Create and add shadowEffect
        DropShadow ds1 = new DropShadow();
        ds1.setOffsetY(4.0f);
        ds1.setOffsetX(4.0f);
        ds1.setColor(new Color(0.183, 0.183, 0.149, 1.0));
        apUser.setEffect(ds1);
        setAnchorPaneHeight(apUser, apUserPreviewHeight);
        //setup User Image
        ImageView ivUser = new ImageView();
        try {
            ivUser.setImage(new Image(student.getPicUrl()));
        }catch (Exception e)
        {
            ivUser.setImage(new Image(defaultUserImageURL));
        }
        ivUser.setFitHeight(ivWitgh);
        ivUser.setFitWidth(ivHight);
        ivUser.setX(ivMarginH);
        ivUser.setY(ivMarginV);
        //create and adds Info Labels for the preview mode
        Label lblUserID = new Label("ID: " + student.getUserID());
        //        lblUserID.setStyle("-fx-text-fill:white");
        setXnYKordinats(lblUserID, lblPreview_X, lblUserID_Y);
        Label lblUserfullName = new Label("Name: " + student.getFullName());
        setXnYKordinats(lblUserfullName, lblPreview_X, lblUserFullName_Y);
        Label lblUserPhoneNr = new Label("Phone Nr: " + student.getPhoneNr());
        setXnYKordinats(lblUserPhoneNr, lblPreview_X, lblUserPhoneNr_Y);
        Label lblUserEmail = new Label("Email: " + student.getEmail());
        setXnYKordinats(lblUserEmail, lblPreview_X, lblUserEmail_Y);
        //creates and adds the button to maximice det userElement
        JFXButton btnMaximize = new JFXButton("Show More");
        btnMaximize.setMaxSize(btnMaximizeWidth, btnMaximizeHeight);
        btnMaximize.setMinSize(btnMaximizeWidth, btnMaximizeHeight);
        btnMaximize.setPrefSize(btnMaximizeWidth, btnMaximizeHeight);
        btnMaximize.setStyle("-fx-background-color:#4d79ff");
        btnMaximize.setTextFill(new Color(1, 1, 1, 1.0));
        AnchorPane.setRightAnchor(btnMaximize, btnMaximize_RightAnchor);
        AnchorPane.setTopAnchor(btnMaximize, btnMaximize_TopAnchor);
        createMoreInfoBox();
        //creates the button action to expand and collapses the UserElement
        btnMaximize.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                if (!previewMode)
                {
                    previewMode = true;
                    btnMaximize.setText("Show Less");
                    apUser.getChildren().add(apMoreUserInfo);
                    //add Diagram and Absence overview tha a place in the AnchorPane apMoreUserInfo
                    setAnchorPaneHeight(apUser, apUserRealHight);

                } else
                {
                    previewMode = false;
                    btnMaximize.setText("Show More");
                    apUser.getChildren().remove(apMoreUserInfo);
                    setAnchorPaneHeight(apUser, apUserPreviewHeight);
                }
            }
        });
        apUser.getChildren().addAll(lblUserfullName, lblUserID, lblUserEmail, lblUserPhoneNr, ivUser, btnMaximize);
    }

    public AnchorPane getUserPane()
    {
        return apUser;
    }

    private void setAnchorPaneHeight(AnchorPane ap, double height)
    {
        ap.setMinHeight(height);
        ap.setPrefHeight(height);
        ap.setMaxHeight(height);
//        ap.setMaxSize(width, height);
//        ap.setMinSize(width, height);
//        ap.setPrefSize(width, height);
    }
    
    private javafx.scene.chart.PieChart getPie(){
        javafx.scene.chart.PieChart pie = adminModel.getPieChart(student);
        AnchorPane.setTopAnchor(pie, MoreLabelsToTop + 80);
        AnchorPane.setRightAnchor(pie, leftLabelAncor);
        
        pie.setMinSize(200, 200);
        pie.setMaxSize(200, 200);
        apMoreUserInfo.getChildren().add(pie);
        
        return pie;
    }

    private void setXnYKordinats(Node node, double X, double Y)
    {
        node.setLayoutX(X);
        node.setLayoutY(Y);
    }

    private void createMoreInfoBox()
    {

        Label cpr = new Label("Cpr: " + student.getCpr());
        Label adress = new Label("Adress: " + student.getAdresse());
        Label schoolClass = new Label("Class: " + student.getSchoolClass());
        
        
        apMoreUserInfo = new AnchorPane(); //pie);
        setAnchorPaneHeight(apMoreUserInfo, apUserRealHight - apUserPreviewHeight);
        setXnYKordinats(apMoreUserInfo, 0, apUserPreviewHeight); // 0 so is allign with the parent AnchorPane
        apMoreUserInfo.getChildren().addAll(cpr, adress, schoolClass);
        AnchorPane.setTopAnchor(schoolClass, MoreLabelsToTop);
        AnchorPane.setLeftAnchor(schoolClass, leftLabelAncor);
        
        AnchorPane.setTopAnchor(adress, MoreLabelsToTop + 60);
        AnchorPane.setLeftAnchor(adress, leftLabelAncor);
        
        AnchorPane.setTopAnchor(cpr, MoreLabelsToTop + 30);
        AnchorPane.setLeftAnchor(cpr, leftLabelAncor);
        
        JFXButton btnShowStudentInfo = new JFXButton("Show Absence");
        apMoreUserInfo.getChildren().add(btnShowStudentInfo);
        AnchorPane.setBottomAnchor(btnShowStudentInfo, 30.0);
        AnchorPane.setRightAnchor(btnShowStudentInfo, 70.0);
        btnShowStudentInfo.setStyle("-fx-background-color:#4d79ff");
        btnShowStudentInfo.setTextFill(new Color(1, 1, 1, 1.0));
        //getPie();
        
        
        
        
        
        
        
        
        btnShowStudentInfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("attendancesystem/gui/admin/view/SpecificStudentInfo.fxml"));
                    
                    Parent root = loader.load();
                    Stage newStage = new Stage();
                    newStage.setResizable(false);
                    newStage.initStyle(StageStyle.DECORATED);
                    newStage.setScene(new Scene(root, 700.0, 650.0));
                    SpecificStudentInfoController controller = loader.getController();
                    controller.setStage(newStage);
                    controller.setStudent(student);
                    
                    
                    newStage.showAndWait();
                } catch (IOException ex) {
                    Logger.getLogger(UserElement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        

    }

}
