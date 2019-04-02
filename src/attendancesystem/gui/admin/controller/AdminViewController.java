/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.admin.controller;

import attendancesystem.be.Absence;
import attendancesystem.be.Student;
import attendancesystem.be.Teacher;
import attendancesystem.gui.admin.UserElementLoader;
import attendancesystem.gui.admin.model.AdminModel;
import attendancesystem.gui.admin.view.UserElementIncrementLoader;
import attendancesystem.gui.elements.UserElement;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class AdminViewController implements Initializable {

    private AdminModel model;
    private Student studen;
    private Stage currentStage;
    ObservableList<Student> bob;
    private FilteredList<UserElement> searchListEle;
    private SortedList<UserElement> sortedDataEle;

    private FilteredList<Student> searchList;
    private SortedList<Student> sortedData;
    private int maxLoad = 10;
    private List<Student> students;
    private ArrayList<UserElement> arr;
    private List<Student> Students;
    private static Teacher loggedInTeacher;
    private ObservableList<Absence> requests;
    private ExecutorService executor;
    private UserElementLoader uLoader;

    @FXML
    private VBox hbxUserOverview;
    @FXML
    private ScrollPane spUsers;
    @FXML
    private AnchorPane apMenu;
    @FXML
    private JFXCheckBox check1;
    @FXML
    private JFXCheckBox chechAsc;
    @FXML
    private JFXCheckBox chechDesc;

    @FXML
    private JFXComboBox<?> combBoxSort;
    @FXML
    private JFXButton btnAbsReq;
    @FXML
    private Label lblReqCount;
    @FXML
    private JFXTextField txtSeach;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {

            model = new AdminModel();
            students = model.getAllStudents();
            bob = FXCollections.observableArrayList();
            bob.setAll(students);
            executor = Executors.newFixedThreadPool(10);
            SetUpUserElements();

            setUpScrollPane();

            setUpAbsenceRequest();

            hbxUserOverview.setSpacing(12);

            setupSeachBarStu();
//            txtSeach.textProperty().addListener((obs, oldV, newV) -> {
//                hbxUserOverview.getChildren().filtered(new Predicate<Node>() {
//                    @Override
//                    public boolean test(Node t) {
//                        if (!txtSeach.getText().isEmpty()) {
//                            UserElement temp = (UserElement) t;
//                            if (temp.getStudent().getFullName().contains(newV)) {
//                                return true;
//                            }
//
//                            return false;
//                        }
//                        return true;
//                    }
//                });
//            });

            combBoxSort.getItems().addAll(comboBox());

        } catch (IOException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void SetUpUserElements() {
        Instant start = Instant.now();

        for (int i = 0; i < maxLoad; i++) {
            
            createAndAddUserElement(students.get(i));

        }

        Instant finish = Instant.now();
        long elapsedTime = Duration.between(start, finish).toMillis();
        System.out.println("createAndAddUserElement: " + elapsedTime + " ms");
    }

    private void setUpScrollPane() {
        spUsers.setFitToWidth(true);
        spUsers.setFitToHeight(true);
        //scrollPane load incriments
        spUsers.vvalueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.doubleValue() == spUsers.getVmax()) {
                int loadIncriments = 10;
                for (int i = maxLoad + 1; i <= maxLoad + loadIncriments; i++) {
                    if (students.get(i) != null) {
                        createAndAddUserElement(students.get(i));
                    } else {
                        break;
                    }
                }
                maxLoad = maxLoad + loadIncriments;
            }
        });
    }

    private void createAndAddUserElement(Student student) {
        UserElement user2 = new UserElement(student, model);
        hbxUserOverview.getChildren().add(user2);
    }

    void setStage(Stage stage) {
        this.currentStage = stage;
    }

    @FXML
    private void btnAll(ActionEvent event) {

    }

    @FXML
    private void btnAllMy(ActionEvent event) {

    }

    @FXML
    private void btnClass(ActionEvent event) {

    }

    @FXML
    private void asc(ActionEvent event) {

    }

    @FXML
    private void desc(ActionEvent event) {

    }

    @FXML
    private void cehch1(ActionEvent event) {

    }

    public ArrayList comboBox() {
        ArrayList coBox = new ArrayList();
        coBox.add("First Name");
        coBox.add("Last Name");
        return coBox;
    }

    private void setUserAncor() {

    }

    private void setupSeachBarEle() {
        searchListEle = new FilteredList(hbxUserOverview.getChildren(), p -> true);
        txtSeach.textProperty().addListener((observable, oldValue, newValue) -> {
            searchListEle.setPredicate(node -> {
                // If filter text is empty, display all Songs
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare Title, Artist and Genre of every Song with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (node.getStudent().getFullName().toLowerCase().contains(lowerCaseFilter)) {
                    System.out.println(node.getStudent().getFullName());
                    return true; // Filter matches Title.
                }
                return false; // Does not match.
            });
            sortedDataEle = new SortedList<>(searchListEle); // Wrap the FilteredList in a SortedList.
            hbxUserOverview.getChildren().setAll(sortedDataEle);//Add sorted (and filtered) data to the table.
        });
//
//        hbxUserOverview.getChildren().setAll(searchList);//Add sorted (and filtered) data to the table.

    }

    private void setupSeachBarStu() {
        searchList = new FilteredList(bob, p -> true);
        txtSeach.textProperty().addListener((observable, oldValue, newValue) -> {
            searchList.setPredicate(node -> {
                // If filter text is empty, display all Songs
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare Title, Artist and Genre of every Song with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (node.getFullName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches Title.
                }

                return false; // Does not match.
            });
            sortedData = new SortedList<>(searchList); // Wrap the FilteredList in a SortedList.
            
//            if (sortedData.size() >= maxLoad) {
//                for (int i = 0; i < maxLoad; i++) {
//                    UserElementLoader uLoader = new UserElementLoader(sortedData.get(i), model);
//                    executor.submit(uLoader);
//                    uLoader.valueProperty().addListener((obv, oldV, newV) -> {
//                        hbxUserOverview.getChildren().add(newV);
//                    });
//
//                }
//
//            } else {
//                for (Student student : sortedData) {
//                    UserElementLoader uLoader = new UserElementLoader(student, model);
//                    executor.submit(uLoader);
//                    uLoader.valueProperty().addListener((obv, oldV, newV) -> {
//                        hbxUserOverview.getChildren().add(newV);
//                    });
//                }
//
//            }
            if (sortedData.size() >= maxLoad) {
                UserElementIncrementLoader uLoader = new UserElementIncrementLoader(sortedData, model, 0, maxLoad, executor);
                executor.submit(uLoader);
                uLoader.valueProperty().addListener((obv, oldV, newV) -> {
                    hbxUserOverview.getChildren().setAll(newV);
                });
            } else {
                UserElementIncrementLoader uLoader = new UserElementIncrementLoader(sortedData, model, 0, sortedData.size(), executor);
                executor.submit(uLoader);
                uLoader.valueProperty().addListener((obv, oldV, newV) -> {
                    hbxUserOverview.getChildren().setAll(newV);
                });

            }

        });

    }

    @FXML
    private void OpenRequests(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("attendancesystem/gui/admin/view/AdminAbsenceHandler.fxml"));

        Parent root = loader.load();
        Stage newStage = new Stage();
        newStage.setResizable(false);
        newStage.initStyle(StageStyle.UNDECORATED);
        newStage.setScene(new Scene(root, 515.0, 650.0));
        AdminAbsenceHandlerController controller = loader.getController();
        controller.setStage(newStage);
        controller.setModel(model);
        controller.setAbsences(requests);

        newStage.showAndWait();

    }

    private void setUpAbsenceRequest() {

        lblReqCount.setOpacity(0);
        requests = FXCollections.observableArrayList();

        requests.setAll(model.getAllRequestAbence(loggedInTeacher));
        if (requests.size() >= 1) {
            lblReqCount.setOpacity(1.0);
            if (requests.size() >= 100) {
                lblReqCount.setText("99+");
            } else {
                lblReqCount.setText("" + requests.size());
            }
        }

    }

    public static void setLoggedInTeacher(Teacher loggedInTeacher) {

        AdminViewController.loggedInTeacher = loggedInTeacher;
    }

}
