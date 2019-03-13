/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem.gui.admin.controller;

import attendancesystem.be.User;
import attendancesystem.gui.admin.model.AdminModel;
import attendancesystem.gui.elements.UserElement;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Thorbjørn Schultz Damkjær
 */
public class AdminViewController implements Initializable {

    private AdminModel model;
    private User user;
    private Stage stage;
    private FilteredList<User> searchList;
    private SortedList<User> sortedData;

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

    UserElement user1 = new UserElement("Bo John", "10", "89898989", "Bo@email.com");
    UserElement user2 = new UserElement("Jens John", "10", "11111111", "Jens@email.com");
    UserElement user3 = new UserElement("Gert John", "10", "12345678", "Gert@email.com");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        model = new AdminModel();

        ArrayList<UserElement> arr = new ArrayList<>();
        for (int i = 0; i < 30; i++)
        {
            UserElement user1 = new UserElement("Bo John "+ i , "10", "89898989", "Bo@email.com");
             hbxUserOverview.getChildren().add(user1.getUserPane());
        }

        hbxUserOverview.setSpacing(12);

        spUsers.setFitToWidth(true);
        spUsers.setFitToHeight(true);

        combBoxSort.getItems().addAll(comboBox());

    }

    void setStage(Stage stage) {
        this.stage = stage;
    }

    void setUser(User user) {
        this.user = user;
    }

    @FXML
    private void btnAll(ActionEvent event) {
        hbxUserOverview.getChildren().clear();
        hbxUserOverview.getChildren().addAll(user1.getUserPane(), user2.getUserPane(), user3.getUserPane());
    }

    @FXML
    private void btnAllMy(ActionEvent event) {
        hbxUserOverview.getChildren().clear();
        hbxUserOverview.getChildren().addAll(user1.getUserPane(), user2.getUserPane());
    }

    @FXML
    private void btnClass(ActionEvent event) {
        hbxUserOverview.getChildren().clear();
        hbxUserOverview.getChildren().addAll(user2.getUserPane(), user1.getUserPane());
    }

    @FXML
    private void asc(ActionEvent event) {
        hbxUserOverview.getChildren().clear();
        hbxUserOverview.getChildren().addAll(user1.getUserPane(), user2.getUserPane(), user3.getUserPane());
    }

    @FXML
    private void desc(ActionEvent event) {
        hbxUserOverview.getChildren().clear();
        hbxUserOverview.getChildren().addAll(user3.getUserPane(), user2.getUserPane(), user1.getUserPane());
    }

    @FXML
    private void cehch1(ActionEvent event) {
        hbxUserOverview.getChildren().clear();
        hbxUserOverview.getChildren().addAll(user1.getUserPane());
    }

    public ArrayList comboBox() {
        ArrayList coBox = new ArrayList();
        coBox.add("First Name");
        coBox.add("Last Name");
        return coBox;
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
}
