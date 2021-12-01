/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Farha
 */
public class IncidentReportFormController implements Initializable {

    @FXML
    private Label Fullname;
    @FXML
    private Label userid;
    @FXML
    private TextField position;
    @FXML
    private TextField phoneNo;
    @FXML
    private TextField Address;
    @FXML
    private TextArea IncidentBox;
    @FXML
    private ComboBox<String> UrgencyComboBox;
    @FXML
    private AnchorPane reportAnchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UrgencyComboBox.getItems().add("--No options selected--");
        UrgencyComboBox.getItems().add("High");
        UrgencyComboBox.getItems().add("Moderate");
        UrgencyComboBox.getItems().add("Low");
        UrgencyComboBox.setValue("--No Options selected--");
        userid.setText(UserClass.getuserId());
        Fullname.setText(UserClass.getUsername());
       // UrgencyLabel.setText("Selected Urgency Level :" + UrgencyComboBox.Selecteditem());
        
    }   

    @FXML
    private void SubmitButton(ActionEvent event) {
        Validation v = new Validation();
        ReportIncident r ;
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setHeaderText("Confirmation Alert");
        a.setContentText("Choose your option below:");
        ButtonType buttonTypeOne = new ButtonType("Yes");
        ButtonType buttonTypeTwo = new ButtonType("No");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
        
        a.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> result = a.showAndWait();
        if(result.get() == buttonTypeOne){
            if(UrgencyComboBox.getSelectionModel().getSelectedItem().equals("--No Options selected--")||position.getText().equals("")||Address.getText().equals("")||IncidentBox.getText().equals("")||
                                             phoneNo.getText().equals("")){
                    Alert as = new Alert(Alert.AlertType.WARNING);
                    as.setTitle("Warning Alert");
                    as.setContentText("please fill up all the informations.");
                    as.setHeaderText(null);
                    as.showAndWait();
            }
            else{
                if(v.validatePhoneNo(phoneNo.getText())){
                    if(UserLoginSceneController.getSelectedUser().equals("Faculty")){

                             r = new Faculty();
                         r.incidentReportApplication(UrgencyComboBox.getSelectionModel().getSelectedItem(),Fullname.getText(),position.getText(),Address.getText(),IncidentBox.getText(),
                                         Integer.parseInt(userid.getText()),Integer.parseInt(phoneNo.getText()));
                           
                        }
              
           
                        else if(UserLoginSceneController.getSelectedUser().equals("Student")){
                         r = new Student();
                         r.incidentReportApplication(UrgencyComboBox.getSelectionModel().getSelectedItem(),Fullname.getText(),position.getText(),Address.getText(),IncidentBox.getText(),
                                             Integer.parseInt(userid.getText()),Integer.parseInt(phoneNo.getText()));
                         }
                         showCustomInformationAlert("Your request will be processed as soon as possible");
                          position.setText(null);
                          phoneNo.setText(null);
                          Address.setText(null);
                          IncidentBox.setText(null);
                     }
                else{
                    showCustomInformationAlert("Your request cannot be processed");
                }
            }
            
        }
        else if(result.get() == buttonTypeTwo){

                showCustomInformationAlert("Please continue with your request");
        }

        else{
                         //show appropriate cancellation message
            showCustomInformationAlert("Request hs been cancelled"); 
        } 
        
    
        
        
    }

    @FXML
    private void ClearInputs(ActionEvent event) {
        Fullname.setText(null);
        userid.setText(null);
        position.setText(null);
        phoneNo.setText(null);
        Address.setText(null);
        IncidentBox.setText(null);
        
    }

    @FXML
    private void backOnClick(ActionEvent event) throws IOException {
        
         Parent p = FXMLLoader.load(getClass().getResource("MainApplicationDashboard.fxml"));
        Scene scene = new Scene(p);
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void showCustomInformationAlert(String str) {
      Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(str);
        a.showAndWait();  
    }
    
    
    
}
