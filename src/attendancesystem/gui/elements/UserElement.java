/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.elements;

import attendancesystem.be.Student;
import attendancesystem.be.Teacher;
import attendancesystem.be.User;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class UserElement {

    private Student testStudent;
    private Teacher testTeacher;
    private String userID;
    private String userFullName;
    private String userPhoneNr;
    private String userEmail;
    private String defaultUserImageURL = "Resources/Images/deafultUserImage.png";
    private boolean previewMode = false;
    private int apUserPreviewHeight = 180;
    private int apUserPreviewWidth = 600;
    private int apUserRealHight = 600;
    private int apUserRealWidth = 600;
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
    private AnchorPane apUser;
    private AnchorPane apMoreUserInfo;
    private ImageView ivUser;
    private Label lblUserID;
    private Label lblUserfullName;
    private Label lblUserPhoneNr;
    private Label lblUserEmail;
    private JFXButton btnMaximize;

    public UserElement(String userFullName, String userID, String userPhoneNr, String userEmail) {
        this.userFullName = userFullName;
        this.userID = userID;
        this.userPhoneNr = userPhoneNr;
        this.userEmail = userEmail;
        apUser = new AnchorPane();
        
        DropShadow ds1 = new DropShadow();
        ds1.setOffsetY(4.0f);
        ds1.setOffsetX(4.0f);
        ds1.setColor(new Color(0.183, 0.183, 0.149, 1.0));
        
        apUser.setStyle("-fx-background-color:#e6e6e6");
        apUser.setEffect(ds1);
        
        setAnchorPaneSize(apUser, apUserPreviewWidth, apUserPreviewHeight);
        
        ObservableList<PieChart.Data> pieChard = FXCollections.observableArrayList(
                new PieChart.Data("Timer", 100),
                new PieChart.Data("Fravær", 10));

        PieChart pie = new PieChart(pieChard);
        
        apMoreUserInfo = new AnchorPane(new Label("more user data goes here"), pie);
        setAnchorPaneSize(apMoreUserInfo, apUserRealWidth, apUserRealHight - apUserPreviewHeight);
        setXnYKordinats(apMoreUserInfo, 0, apUserPreviewHeight); // 0 so is allign with the parent AnchorPane
        
        ivUser = new ImageView();
        ivUser.setImage(new Image(defaultUserImageURL));
        ivUser.setFitHeight(ivWitgh);
        ivUser.setFitWidth(ivHight);
        ivUser.setX(ivMarginH);
        ivUser.setY(ivMarginV);

        lblUserID = new Label("ID: " + userID);
//        lblUserID.setStyle("-fx-text-fill:white");
        setXnYKordinats(lblUserID, lblPreview_X, lblUserID_Y);

        lblUserfullName = new Label("Name: " + userFullName);
        setXnYKordinats(lblUserfullName, lblPreview_X, lblUserFullName_Y);

        lblUserPhoneNr = new Label("Phone Nr: " + userPhoneNr);
        setXnYKordinats(lblUserPhoneNr, lblPreview_X, lblUserPhoneNr_Y);

        lblUserEmail = new Label("Email: " + userEmail);
        setXnYKordinats(lblUserEmail, lblPreview_X, lblUserEmail_Y);

        btnMaximize = new JFXButton("Show More");
        btnMaximize.setMaxSize(btnMaximizeWidth, btnMaximizeHeight);
        btnMaximize.setMinSize(btnMaximizeWidth, btnMaximizeHeight);
        btnMaximize.setPrefSize(btnMaximizeWidth, btnMaximizeHeight);
        btnMaximize.setStyle("-fx-background-color:#4d79ff");
        btnMaximize.setTextFill(new Color(1, 1, 1, 1.0));
        

        AnchorPane.setRightAnchor(btnMaximize, btnMaximize_RightAnchor);
        System.out.println("");
        System.out.println(btnMaximize_TopAnchor);
        AnchorPane.setTopAnchor(btnMaximize, btnMaximize_TopAnchor);

        btnMaximize.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!previewMode) {
                    previewMode = true;
                    btnMaximize.setText("Show Less");
                    apUser.getChildren().add(apMoreUserInfo);
                    //add Diagram and Absence overview tha a place in the AnchorPane apMoreUserInfo
                    setAnchorPaneSize(apUser, apUserRealWidth, apUserRealHight);
                } else {
                    previewMode = false;
                    btnMaximize.setText("Show More");
                    apUser.getChildren().remove(apMoreUserInfo);
                    setAnchorPaneSize(apUser, apUserPreviewWidth, apUserPreviewHeight);
                }
            }
        });

        setXnYKordinats(btnMaximize, btnMaximize_TopAnchor, btnMaximize_RightAnchor);

        apUser.getChildren().addAll(lblUserfullName, lblUserID, lblUserEmail, lblUserPhoneNr, ivUser, btnMaximize);
    }

    public AnchorPane getUserPane() {
        return apUser;
    }

    private void setUserImage(Image image) {
        try {
            ivUser.setImage(image);
        } catch (Exception e) {
            System.out.println("User: " + userFullName + " Has no Picture Yet");
        }
    }

    private void setAnchorPaneSize(AnchorPane ap, double width, double height) {
        ap.setMinHeight(height);
        ap.setPrefHeight(height);
        ap.setMaxHeight(height);
//        ap.setMaxSize(width, height);
//        ap.setMinSize(width, height);
//        ap.setPrefSize(width, height);
    }

    private void setXnYKordinats(Node node, double X, double Y) {
        node.setLayoutX(X);
        node.setLayoutY(Y);
    }
    
    public AnchorPane createInfo(User user)
    {
        if (user.getClass().equals(testStudent.getClass()))
        {
            return createStudentInfo(null);
        }
        if(user.getClass().equals(testTeacher.getClass()))
        {
            return createTeacherInfo(null);
        }
        else return null;
    }
    
    private AnchorPane createStudentInfo(Student student)
    {
        return null;
    }
    private AnchorPane createTeacherInfo(Teacher teacher)
    {
        return null;
    }
    
    
}