/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class EventRegistrationSceneController implements Initializable {

  
    protected transient ObjectOutputStream oos;
    private String dept;
    private Eventpicker pick;
    @FXML
    private TextArea purposeTextArea;
    @FXML
    private Label eventLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label timeLabel;
    @FXML
    private Label venueLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private TextField semester;
    @FXML
    private TextField phoneNo;
    @FXML
    private ComboBox<String> deptCombo;
    private LocalDate eventDate;
    private Validation v = new Validation();
    /**
     * Initializes the controller class.
     */
    
    public void initData(Eventpicker e){
        pick = e;
        eventLabel.setText(pick.getEventname());
        timeLabel.setText(e.getEventTime());
        venueLabel.setText(e.getEventVenue());
        
        dateLabel.setText((e.getEventDate()).toString());
        eventDate = e.getEventDate();
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      nameLabel.setText(UserClass.getUsername());
      idLabel.setText(UserClass.getuserId());
      emailLabel.setText(UserClass.getemail());
      deptCombo.getItems().addAll("CSE","EEE","BBA","PHR","ENV","SS");
      deptCombo.setValue("No options chosen");
      
      
      
    }    

    @FXML
    private void submitFormRegister(ActionEvent event) {
        dept = deptCombo.getSelectionModel().getSelectedItem();
        Student s = new Student();
        
         Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setHeaderText("Confirm your opinion...");
        a.setContentText("Are you sure that you want to proceed?");
                
        Optional<ButtonType> result = a.showAndWait();
        if(result.get() == ButtonType.OK){
            if(dept.equals("No options chosen")||purposeTextArea.getText().equals("")||phoneNo.getText().equals("")||semester.getText().equals("")){
                 Alert as = new Alert(Alert.AlertType.ERROR);
                as.setTitle("Error Alert");
                as.setHeaderText("INFORMATION ERROR");
                as.setContentText("Cannot proceed because information is incomplete");
                as.showAndWait(); 
            }
            else{
                if(v.validatePhoneNo(phoneNo.getText())){
                s.eventRegistration(nameLabel.getText(),idLabel.getText(), emailLabel.getText(),dept,
                    eventLabel.getText(), purposeTextArea.getText(),Integer.parseInt(phoneNo.getText()),semester.getText(),venueLabel.getText(),timeLabel.getText(),
                    eventDate);
                  showCustomInformationAlert("Your registration is completed.");
                   deptCombo.setValue("No options chosen");
                   purposeTextArea.setText(null);
                   phoneNo.setText(null);
                   semester.setText(null);
            }
                else{
                     Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Alert");
                    alert.setContentText("Please enter valid phone number");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                    // showCustomInformationAlert("Your registration is cannot becompleted.");
                }
            }   
        }
        else{

            showCustomInformationAlert("Registration process is cancelled!"); 
        }
        
        
         
        
        
    }

    private void showCustomInformationAlert(String str) {
      Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(str);
        a.showAndWait();    
    }
    
}
