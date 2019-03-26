/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.admin.controller;

import attendancesystem.be.Absence;
import attendancesystem.be.Student;
import attendancesystem.be.User;
import attendancesystem.gui.admin.model.AdminModel;
import attendancesystem.gui.elements.UserElement;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
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

/**
 * FXML Controller class
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class AdminViewController implements Initializable
{

    private AdminModel model;
    private User user;
    private Student studen;
    private Stage currentStage;
    private FilteredList<User> searchList;
    private SortedList<User> sortedData;
    private int maxLoad = 30;
    List<Student> students;
    ArrayList<UserElement> arr;
    List<Student> Students;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        try
        {

            try
            {
                model = new AdminModel();
            } catch (IOException ex)
            {
                Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
            }

            ArrayList<UserElement> arr = new ArrayList<>();

            ArrayList<Student> lessStudents = new ArrayList<>();
            students = model.getAllStudents();
            Instant start = Instant.now();

            for (int i = 0; i < maxLoad; i++)
            {

                createAndAddUserElement(students.get(i), arr);

            }

            Instant finish = Instant.now();

            long elapsedTime = Duration.between(start, finish).toMillis();

            System.out.println(elapsedTime + " ms");

            //test ersattest med metode de gør med list<Student/user?>
            hbxUserOverview.setSpacing(12);

            spUsers.setFitToWidth(true);
            spUsers.setFitToHeight(true);

            combBoxSort.getItems().addAll(comboBox());

            //scrollPane load incriments
            spUsers.vvalueProperty().addListener((observable, oldValue, newValue) ->
            {
                System.out.println(newValue);
                System.out.println(spUsers.getVmax());
                if (newValue.doubleValue() == spUsers.getVmax())
                {
                    int loadIncriments = 10;
                    for (int i = maxLoad + 1; i <= maxLoad + loadIncriments; i++)
                    {
                        if (students.get(i) != null)
                        {
                            createAndAddUserElement(students.get(i), arr);

                        } else
                        {
                            break;
                        }
                    }
                    maxLoad = maxLoad + loadIncriments;
                }

            });

        } catch (SQLException ex)
        {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void createAndAddUserElement(Student student, ArrayList<UserElement> arr1)
    {
        UserElement user2 = new UserElement(student);
        hbxUserOverview.getChildren().add(user2.getUserPane());
    }

    void setStage(Stage stage)
    {
        this.currentStage = stage;
    }

    void setUser(User user)
    {
        this.user = user;
    }

    @FXML
    private void btnAll(ActionEvent event)
    {

    }

    @FXML
    private void btnAllMy(ActionEvent event)
    {

    }

    @FXML
    private void btnClass(ActionEvent event)
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

    @FXML
    private void cehch1(ActionEvent event)
    {

    }

    public ArrayList comboBox()
    {
        ArrayList coBox = new ArrayList();
        coBox.add("First Name");
        coBox.add("Last Name");
        return coBox;
    }

    private void setUserAncor()
    {

    }
//    private void setupSeachBar()
//    {
//        searchList = new FilteredList(mPlayer2.getActivelistOfSongs(), p -> true);
//        txtSearch.textProperty().addListener((observable, oldValue, newValue)
//                ->
//        {
//            searchList.setPredicate(song
//                    ->
//            {
//                // If filter text is empty, display all Songs
//                if (newValue == null || newValue.isEmpty())
//                {
//                    return true;
//                }
//
//                // Compare Title, Artist and Genre of every Song with filter text.
//                String lowerCaseFilter = newValue.toLowerCase();
//
//                if (song.getTitle().toLowerCase().contains(lowerCaseFilter))
//                {
//                    return true; // Filter matches Title.
//                } else if (song.getArtist().toLowerCase().contains(lowerCaseFilter))
//                {
//                    return true; // Filter matches Artist.
//                } else if (song.getGenre().toLowerCase().contains(lowerCaseFilter))
//                {
//                    return true; // Filter matches Genre.
//                }
//                return false; // Does not match.
//            });
//        });
//        sortedData = new SortedList<>(searchList); // Wrap the FilteredList in a SortedList.
//        sortedData.comparatorProperty().bind(tbvSongs.comparatorProperty()); // Bind the SortedList comparator to the TableView comparator.
//        tbvSongs.setItems(sortedData);//Add sorted (and filtered) data to the table.
//    }

    @FXML
    private void OpenRequests(ActionEvent event) throws IOException
    {
        List<Absence> bob = new ArrayList<>();
        bob.add(new Absence(maxLoad, maxLoad, "subjectID", "reason", "dialogBox", "date", "modulTimePeriod"));

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("attendancesystem/gui/admin/view/AdminAbsenceHandler.fxml"));

        Parent root = loader.load();
        Stage newStage = new Stage();
        newStage.setResizable(false);
        newStage.initStyle(StageStyle.UNDECORATED);
        newStage.setScene(new Scene(root, 515.0, 650.0));
        AdminAbsenceHandlerController controller = loader.getController();
        controller.setStage(newStage);
        controller.setAbsences(bob);
        
        newStage.showAndWait();

    }
}
