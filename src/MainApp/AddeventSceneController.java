/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Farha
 */
public class AddeventSceneController implements Initializable,Serializable {

    @FXML
    private ComboBox<String> typeOfEventBox;
    @FXML
    private TextField EventnameTextfield;
    @FXML
    private TextField eventTimeTextfield;
    @FXML
    private TextField eventVenueTextfield;
    @FXML
    private DatePicker dateOfEvent;
    private CITS crew;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         typeOfEventBox.getItems().addAll("Social", "Volunteer","Club","University");
         typeOfEventBox.setValue("No option chosen");
    }    

    @FXML
    private void submitEventButton(ActionEvent event) {
        UpdateEvent e ;
        
        if(typeOfEventBox.getSelectionModel().getSelectedItem().equals("No option chosen")|| EventnameTextfield.getText().equals("")||
                eventTimeTextfield.getText().equals("")||eventVenueTextfield.getText().equals("")||dateOfEvent.getValue().equals("")){
            if(UserLoginSceneController.getSelectedUser().equals("CITS")){
            e = new CITS();
             e.addnewEvent(typeOfEventBox.getSelectionModel().getSelectedItem(),EventnameTextfield.getText(),
                eventTimeTextfield.getText(),eventVenueTextfield.getText(),dateOfEvent.getValue());
            
            }
           else if(UserLoginSceneController.getSelectedUser().equals("AdministrativeStaff")){
               e = new  AdministrativeStaff();
               e.addnewEvent(typeOfEventBox.getSelectionModel().getSelectedItem(),EventnameTextfield.getText(),
                    eventTimeTextfield.getText(),eventVenueTextfield.getText(),dateOfEvent.getValue());
            }
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Submission Status");
            a.setContentText("Your event has been successfully addded.");
            a.showAndWait();  
        }
        else{
            
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("Warning Alert");
        a.setContentText("Please fill up all the informations");
        a.setHeaderText(null);
        a.showAndWait();       
        }
       
}
}
