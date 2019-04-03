/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.elements;

import attendancesystem.be.Student;
import attendancesystem.gui.admin.controller.SpecificStudentInfoController;
import attendancesystem.gui.admin.model.AdminModel;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
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
public class UserElement extends AnchorPane {

    private static final String defaultUserImageURL = "Resources/Images/deafultUserImage.png";
    private boolean previewMode = false;
    private int apUserPreviewHeight = 180;
    private int apUserRealHight = 600;

    private AnchorPane apUser;
    private AnchorPane apMoreUserInfo;
    private Student student;
    private AdminModel adminModel;
    private JFXButton btnShowMore;

    public UserElement(Student student, AdminModel adminModel) {
        this.adminModel = adminModel;
        this.student = student;
        
        createPreviewPane();
        
        createUserInfoPane();
    }

    private void createPreviewPane() {
        setupAnchorPanePreview();
        
        setupImageView();
        
        setupLabelsPreview();
       
        setupShowMoreBtn();
    }

    private void setupShowMoreBtn() {

        //creates and adds the button to maximice det userElement
        double btnShowMoreHeight = 35;
        double btnShowMoreWidth = 100;

        btnShowMore = new JFXButton("Show More");
        btnShowMore.setPrefSize(btnShowMoreWidth, btnShowMoreHeight);
        btnShowMore.setStyle("-fx-background-color:#4d79ff");
        btnShowMore.setTextFill(new Color(1, 1, 1, 1.0));

        //creates the button action to expand and collapses the UserElement
        btnShowMore.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (!previewMode) {
                    showMore();

                } else {
                    showLess();
                }
            }

        });

        super.getChildren().addAll(btnShowMore);

        double btnMaximize_RightAnchor = 15;
        double btnMaximize_TopAnchor = apUserPreviewHeight - btnShowMoreHeight - btnMaximize_RightAnchor;

        AnchorPane.setRightAnchor(btnShowMore, btnMaximize_RightAnchor);
        AnchorPane.setTopAnchor(btnShowMore, btnMaximize_TopAnchor);
    }

    private void showMore() {
        previewMode = true;
        btnShowMore.setText("Show Less");
        super.getChildren().add(apMoreUserInfo);

        //add Diagram and Absence overview tha a place in the AnchorPane apMoreUserInfo
        super.setPrefHeight(apUserRealHight);
        super.setMinHeight(apUserRealHight);
        super.setMaxHeight(apUserRealHight);
    }

    private void showLess() {
        previewMode = false;
        btnShowMore.setText("Show More");
        super.getChildren().remove(apMoreUserInfo);
        super.setPrefHeight(apUserPreviewHeight);
        super.setMinHeight(apUserPreviewHeight);
        super.setMaxHeight(apUserPreviewHeight);
        
    }

    private void setupLabelsPreview() {
        //create and adds Info Labels for the preview mode

        Label lblId = new Label("ID:");
        lblId.setPrefWidth(45);
        lblId.setAlignment(Pos.CENTER_RIGHT);
        //apUser.getChildren().add(lblId);
        super.getChildren().add(lblId);
        AnchorPane.setLeftAnchor(lblId, 180.0);
        AnchorPane.setTopAnchor(lblId, 15.0);

        Label lblUserID = new Label("" + student.getUserID());
        super.getChildren().add(lblUserID);
        AnchorPane.setLeftAnchor(lblUserID, 250.0);
        AnchorPane.setTopAnchor(lblUserID, 15.0);

        Label lblName = new Label("Name:");
        lblName.setPrefWidth(45);
        lblName.setAlignment(Pos.CENTER_RIGHT);
        super.getChildren().add(lblName);
        AnchorPane.setLeftAnchor(lblName, 180.0);
        AnchorPane.setTopAnchor(lblName, 60.0);

        Label lblUserName = new Label(student.getFullName());
        super.getChildren().add(lblUserName);
        AnchorPane.setLeftAnchor(lblUserName, 250.0);
        AnchorPane.setTopAnchor(lblUserName, 60.0);

        Label lblClass = new Label("Class:");
        lblClass.setPrefWidth(45);
        lblClass.setAlignment(Pos.CENTER_RIGHT);
        super.getChildren().add(lblClass);
        AnchorPane.setLeftAnchor(lblClass, 180.0);
        AnchorPane.setTopAnchor(lblClass, 105.0);

        Label lblUserClass = new Label(student.getSchoolClass());
        super.getChildren().add(lblUserClass);
        AnchorPane.setLeftAnchor(lblUserClass, 250.0);
        AnchorPane.setTopAnchor(lblUserClass, 105.0);

        Label lblEmail = new Label("Email:");
        lblEmail.setPrefWidth(45);
        lblEmail.setAlignment(Pos.CENTER_RIGHT);
        super.getChildren().add(lblEmail);
        AnchorPane.setLeftAnchor(lblEmail, 180.0);
        AnchorPane.setTopAnchor(lblEmail, 150.0);

        Label lblUserEmail = new Label(student.getEmail());
        super.getChildren().add(lblUserEmail);
        AnchorPane.setLeftAnchor(lblUserEmail, 250.0);
        AnchorPane.setTopAnchor(lblUserEmail, 150.0);

    }

    private void setupImageView() {
        //setup User Image
        ImageView ivUser = new ImageView();
//        try {
//            ivUser.setImage(new Image(student.getPicUrl()));
//        } catch (Exception e) {
//            ivUser.setImage(new Image(defaultUserImageURL));
//        }
        
        ivUser.setImage(new Image(defaultUserImageURL));
        
        ivUser.setFitHeight(150);
        ivUser.setFitWidth(150);
        super.getChildren().add(ivUser);
        AnchorPane.setTopAnchor(ivUser, 15.0);
        AnchorPane.setLeftAnchor(ivUser, 15.0);
    }

    private void setupAnchorPanePreview() {
        //Create and add shadowEffect
        DropShadow ds1 = new DropShadow();
        ds1.setOffsetY(4.0f);
        ds1.setOffsetX(4.0f);
        ds1.setColor(new Color(0.183, 0.183, 0.149, 1.0));

        //Setup UserElement
        super.setStyle("-fx-background-color:#e6e6e6");
        super.setEffect(ds1);
        super.setPrefHeight(apUserPreviewHeight);
        super.setMinHeight(apUserPreviewHeight);
        super.setMaxHeight(apUserPreviewHeight);
    }

    private void createUserInfoPane() {
        setupAnchorPaneInfo();

        setupLabelInfo();

        setupPieChart();

        setupShowAbsenceBtn();

    }

    private void setupShowAbsenceBtn() {
        JFXButton btnShowAbsenceInfo = new JFXButton("Show Absence");

        btnShowAbsenceInfo.setStyle("-fx-background-color:#4d79ff");
        btnShowAbsenceInfo.setTextFill(new Color(1, 1, 1, 1.0));

        btnShowAbsenceInfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("attendancesystem/gui/admin/view/SpecificStudentInfo.fxml"));

                    Parent root = loader.load();
                    Stage newStage = new Stage();
                    newStage.setResizable(false);
                    newStage.initStyle(StageStyle.UNDECORATED);
                    newStage.setScene(new Scene(root, 500.0, 650.0));
                    SpecificStudentInfoController controller = loader.getController();
                    controller.setStage(newStage);
                    controller.setStudent(student);

                    newStage.showAndWait();
                } catch (IOException ex) {
                    Logger.getLogger(UserElement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        apMoreUserInfo.getChildren().add(btnShowAbsenceInfo);
        AnchorPane.setBottomAnchor(btnShowAbsenceInfo, 25.0);
        AnchorPane.setRightAnchor(btnShowAbsenceInfo, 40.0);
    }

    private void setupPieChart() {
        PieChart pie = adminModel.getPieChart(student);
        pie.setPrefSize(360, 360);
        pie.setLabelsVisible(false);
        apMoreUserInfo.getChildren().add(pie);
        AnchorPane.setTopAnchor(pie, 20.0);
        AnchorPane.setLeftAnchor(pie, 20.0);
    }

    private void setupLabelInfo() {
        Label cpr = new Label("Cpr:       " + student.getCpr());
        apMoreUserInfo.getChildren().add(cpr);
        AnchorPane.setTopAnchor(cpr, 130.0);
        AnchorPane.setLeftAnchor(cpr, 415.0);

        Label adress = new Label("Address:  " + student.getAdresse());
        apMoreUserInfo.getChildren().add(adress);
        AnchorPane.setTopAnchor(adress, 90.0);
        AnchorPane.setLeftAnchor(adress, 415.0);

        Label schoolClass = new Label("Phone:    " + student.getSchoolClass());
        apMoreUserInfo.getChildren().add(schoolClass);
        AnchorPane.setTopAnchor(schoolClass, 50.0);
        AnchorPane.setLeftAnchor(schoolClass, 415.0);
    }

    private void setupAnchorPaneInfo() {
        apMoreUserInfo = new AnchorPane();
        AnchorPane.setLeftAnchor(apMoreUserInfo, 0.0);
        AnchorPane.setBottomAnchor(apMoreUserInfo, 0.0);
        AnchorPane.setRightAnchor(apMoreUserInfo, 0.0);
        setAnchorPaneHeight(apMoreUserInfo, apUserRealHight - apUserPreviewHeight);
        setXnYKordinats(apMoreUserInfo, 0, apUserPreviewHeight);
    }

    private void setXnYKordinats(Node node, double X, double Y) {
        node.setLayoutX(X);
        node.setLayoutY(Y);
    }

    private void setAnchorPaneHeight(AnchorPane ap, double height) {
        ap.setMinHeight(height);
        ap.setPrefHeight(height);
        ap.setMaxHeight(height);
//        ap.setMaxSize(width, height);
//        ap.setMinSize(width, height);
//        ap.setPrefSize(width, height);
    }

    public AnchorPane getUserPane() {
        return apUser;
    }

    public Student getStudent() {
        return student;
    }

}
