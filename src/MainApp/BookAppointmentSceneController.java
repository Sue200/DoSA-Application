/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
//import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class BookAppointmentSceneController implements Initializable {

   
    @FXML
    private TextField ageTextfield;
    @FXML
    private ChoiceBox<String> previousAppointmentComboBox;
    @FXML
    private DatePicker datepicker;
    @FXML
    private TextField timeTextfield;
    @FXML
    private Label nameLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private RadioButton maleRadiobutton;
    @FXML
    private RadioButton femaleRadioButton;
    @FXML
    private RadioButton preferNotRadiobutton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // genderComboBox.getItems().setAll("Female", "Male");
        previousAppointmentComboBox.getItems().setAll("Yes","No");
       // genderComboBox.setValue("No Option chosen ");
        previousAppointmentComboBox.setValue("No");
    }    

    @FXML
    private void submitButtonOnClick(ActionEvent event) throws IOException {
       // String gender = genderComboBox.getSelectionModel().getSelectedItem();
       String gender;
       if(maleRadiobutton.isSelected()){
           gender = "Male";
       }
       else if(femaleRadioButton.isSelected()){
           gender = "Female";
       }
       else{
           gender = "unknown";
       }
        String option = previousAppointmentComboBox.getSelectionModel().getSelectedItem();
        LocalDate date =   datepicker.getValue();
        String time =  timeTextfield.getText();
        Student stud = new Student();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setHeaderText("Confirm your opinion...");
        a.setContentText("Are you sure that you want to submit the form ?");
                
        Optional<ButtonType> result = a.showAndWait();
        if(result.get() == ButtonType.OK){
           
            stud.bookAppointment(nameLabel.getText(),idLabel.getText(),ageTextfield.getText(),
                emailLabel.getText(),gender, option, date, time);
            showCustomInformationAlert("Your application has been submitted. You will get "
                    + "a confirmation email from your selected counselor as soon as possible"+"\n"+" Thank you.");
        }
        else{
            //show appropriate cancellation message
           
            ageTextfield.setText(null);
            showCustomInformationAlert("Your application has been cancelled!"); 
        }
        
    }

    private void showCustomInformationAlert(String the_task) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(the_task);
        a.showAndWait(); 
    }
    
    
}
