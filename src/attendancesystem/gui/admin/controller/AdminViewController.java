/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.admin.controller;

import attendancesystem.be.Absence;
import attendancesystem.be.Student;
import attendancesystem.be.Teacher;
import attendancesystem.gui.admin.tasks.UserElementLoader;
import attendancesystem.gui.admin.model.AdminModel;
import attendancesystem.gui.admin.tasks.UserElementIncrementLoader;
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
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class AdminViewController implements Initializable
{

    private AdminModel model;
    private Stage currentStage;
    private ObservableList<Student> obsStudents;
    private FilteredList<Student> searchList;
    private SortedList<Student> sortedData;
    private int maxLoad = 10;
    private List<Student> students;
    private static Teacher loggedInTeacher;
    private ObservableList<Absence> requests;
    private ExecutorService executor;
    private ArrayList<String> activeFilters;

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
    private JFXButton btnAbsReq;
    @FXML
    private Label lblReqCount;
    @FXML
    private JFXTextField txtSeach;
    @FXML
    private JFXCheckBox check11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        try
        {

            model = new AdminModel();
            students = model.getAllStudents();
            obsStudents = FXCollections.observableArrayList();
            obsStudents.setAll(students);

            setupSeachBarStu();
            sortedData = new SortedList<>(searchList); // Wrap the FilteredList in a SortedList.

            executor = Executors.newFixedThreadPool(1);

            SetUpUserElements();

            setUpScrollPane();

            setUpAbsenceRequest();

            hbxUserOverview.setSpacing(12);

            setupCheckBoxes();

        } catch (IOException ex)
        {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setupCheckBoxes()
    {
        activeFilters = new ArrayList<>();
        List<String> classes = model.getSchoolClasses(loggedInTeacher);
        double start = 60;
        for (String classe : classes)
        {
            JFXCheckBox cb = new JFXCheckBox(classe);
            cb.selectedProperty().addListener((observable, oldValue, newValue) ->
            {

                if (newValue == true)
                {
                    System.out.println("in:" + classe);
                    activeFilters.add(classe);
                }
                if (newValue == false)
                {
                    activeFilters.remove(classe);
                }
                seach(txtSeach.getText());
            });

            apMenu.getChildren().add(cb);
            AnchorPane.setLeftAnchor(cb, 20.0);
            AnchorPane.setTopAnchor(cb, start);
            start += 25.0;
        }
    }

    private void SetUpUserElements()
    {
        Instant start = Instant.now();

        for (int i = 0; i < maxLoad; i++)
        {

            createAndAddUserElement(sortedData.get(i));

        }

        Instant finish = Instant.now();
        long elapsedTime = Duration.between(start, finish).toMillis();
        System.out.println("createAndAddUserElement: " + elapsedTime + " ms");
    }

    private void setUpScrollPane()
    {
        spUsers.setFitToWidth(true);
        spUsers.setFitToHeight(true);
        //scrollPane load incriments
        spUsers.vvalueProperty().addListener((observable, oldValue, newValue) ->
        {
            if (newValue.doubleValue() == spUsers.getVmax())
            {
                if (maxLoad != sortedData.size())
                {
                    int loadIncriments = 10;
                    int oldMax = maxLoad;
                    int newMax = maxLoad + loadIncriments;
                    if (sortedData.size() > newMax)
                    {
                        for (int i = maxLoad + 1; i <= maxLoad + loadIncriments; i++)
                        {
                            createAndAddUserElement(sortedData.get(i));
                        }
                        maxLoad = newMax;
                    } else
                    {
                        for (int i = oldMax; i < sortedData.size(); i++)
                        {
                            createAndAddUserElement(sortedData.get(i));
                        }
                        maxLoad = sortedData.size();
                    }
                }
            }
        });
    }

    private void createAndAddUserElement(Student student)
    {
        UserElement user2 = new UserElement(student, model);
        hbxUserOverview.getChildren().add(user2);
    }

    void setStage(Stage stage)
    {
        this.currentStage = stage;
        currentStage.setOnCloseRequest(new EventHandler<WindowEvent>()
        {
            @Override
            public void handle(WindowEvent e)
            {
                Platform.exit();
                System.exit(0);
            }
        });
    }

    @FXML
    private void btnAllMy(ActionEvent event)
    {

    }

    @FXML
    private void asc(ActionEvent event)
    {

    }

    @FXML
    private void desc(ActionEvent event)
    {

    }

    private void setupSeachBarStu()
    {
        searchList = new FilteredList(obsStudents, p -> true);
        txtSeach.textProperty().addListener((observable, oldValue, newValue) ->
        {
            seach(newValue);

        });

    }

    private void seach(String newValue)
    {
        searchList.setPredicate(node ->
        {
            // If filter text is empty, display all Songs
            if ((newValue == null || newValue.isEmpty()) && activeFilters.isEmpty())
            {
                return true;
            }

            // Compare Title, Artist and Genre of every Song with filter text.
            String lowerCaseFilter = newValue.toLowerCase();
            Boolean bob = null;
            System.out.println(!activeFilters.isEmpty());
            System.out.println(activeFilters);
            if (!activeFilters.isEmpty())
            {
                for (String activeFilter : activeFilters)
                {
                    
                    if (activeFilter.toLowerCase().contains(node.getSchoolClass().toLowerCase()))
                    {
                        
                        bob = true;
                        break;
                    } else
                    {
                        bob = false;
                    }
                }
            }

            if (node.getFullName().toLowerCase().contains(lowerCaseFilter) && (bob == true || bob == null))
            {
                return true; // Filter matches Title.
            }
            

            return false; // Does not match.
        });

        if (sortedData.size() >= maxLoad)
        {
            UserElementIncrementLoader uLoader = new UserElementIncrementLoader(sortedData, model, 0, maxLoad, executor);
            executor.submit(uLoader);
            uLoader.valueProperty().addListener((obv, oldV, newV) ->
            {

                newV.sort(new Comparator<UserElement>()
                {
                    @Override
                    public int compare(UserElement o1, UserElement o2)
                    {
                        return o1.getStudent().getStuID() - o2.getStudent().getStuID();
                    }
                });
                hbxUserOverview.getChildren().setAll(newV);
            });
        } else
        {
            UserElementIncrementLoader uLoader = new UserElementIncrementLoader(sortedData, model, 0, sortedData.size(), executor);
            executor.submit(uLoader);
            uLoader.valueProperty().addListener((obv, oldV, newV) ->
            {
                newV.sort(new Comparator<UserElement>()
                {
                    @Override
                    public int compare(UserElement o1, UserElement o2)
                    {
                        return o1.getStudent().getStuID() - o2.getStudent().getStuID();
                    }
                });
                hbxUserOverview.getChildren().setAll(newV);
            });

        }
    }

    @FXML
    private void OpenRequests(ActionEvent event) throws IOException
    {
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

    private void setUpAbsenceRequest()
    {

        lblReqCount.setOpacity(0);
        requests = FXCollections.observableArrayList();

        requests.setAll(model.getAllRequestAbence(loggedInTeacher));
        if (requests.size() >= 1)
        {
            lblReqCount.setOpacity(1.0);
            if (requests.size() >= 100)
            {
                lblReqCount.setText("99+");
            } else
            {
                lblReqCount.setText("" + requests.size());
            }
        }

    }

    public static void setLoggedInTeacher(Teacher loggedInTeacher)
    {

        AdminViewController.loggedInTeacher = loggedInTeacher;
    }

    private void disableAllCheckBoxes()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
