/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;

/**
 * FXML Controller class
 *
 * @author Farha
 */
public class ViewComplainBoxController implements Initializable {

    @FXML
    private ListView<IncidentReport> listview;
    @FXML
    private MenuButton urgencyMenuButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void backToPreviousSceneOnClick(ActionEvent event) {
        
    }

    @FXML
    private void viewhighLevel(ActionEvent event) throws ClassNotFoundException {
        ObservableList<IncidentReport> list = FXCollections.observableArrayList();
       AdministrativeStaff as = new AdministrativeStaff();
       list = as.viewComplaints("high");
       listview.setItems(list);
         
    }

    @FXML
    private void viewModerateLevel(ActionEvent event) throws ClassNotFoundException {
        ObservableList<IncidentReport> list = FXCollections.observableArrayList();
         AdministrativeStaff as = new AdministrativeStaff();
         list = as.viewComplaints("Moderate");
          listview.setItems(list);
    }

    @FXML
    private void viewLowLevel(ActionEvent event) throws ClassNotFoundException {
         ObservableList<IncidentReport> list = FXCollections.observableArrayList();
         AdministrativeStaff as = new AdministrativeStaff();
         as.viewComplaints("Low");
          listview.setItems(list);
         
    }
    
}
