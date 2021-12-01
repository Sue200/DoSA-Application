/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Farha
 */
public class AlumniNetworkSceneController implements Initializable {

    @FXML
    private TextField dept;
   
    @FXML
    private TextField major;
    @FXML
    private TextField phoneNo;
    @FXML
    private TextArea workingStatus;
    @FXML
    private TextField linkedIn;
    @FXML
    private CheckBox checkButton;
    @FXML
    private Label nameLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Button signUpButton;
    @FXML
    private TextField gradYear;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            nameLabel.setText(UserClass.getUsername());

            idLabel.setText(UserClass.getuserId());

            emailLabel.setText(UserClass.getemail());
           
            UserLoginSceneController usc = new UserLoginSceneController();
            if(usc.getSelectedUser()!= "Alumni"){
                signUpButton.setDisable(true);
            }
    }    

    @FXML
    private void signUpOnClick(ActionEvent event) {
       Validation v = new Validation();
       if(dept.getText().equals("")||gradYear.getText().equals("")|| major.getText().equals("")|| phoneNo.getText().equals("")|| linkedIn.getText().equals("")||
            workingStatus.getText().equals("")){
           if(v.validatePhoneNo(phoneNo.getText())){
                if(checkButton.isSelected()){
                    Alumni a = new Alumni();
                   a.alumniNetworkRegistration(nameLabel.getText(),idLabel.getText(),emailLabel.getText(), dept.getText()
                   ,Integer.parseInt(gradYear.getText()), major.getText(),Integer.parseInt(phoneNo.getText()),linkedIn.getText(),
                   workingStatus.getText());
                    Alert as = new Alert(Alert.AlertType.INFORMATION);
                   as.setTitle("Information Alert");
                  // a.setHeaderText("Dessemination of Notice...");
                   as.setContentText("Your registration has been completed."+"\n"+"Thank you for choosing to be part of our Alumni organization.");
                   as.showAndWait();         
    
                 }
                else{
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setTitle("Check button ");
                    a.setContentText("Check button has not been selected");
                    a.setHeaderText(null);
                    a.showAndWait();  
                }
           }
            else{
                
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setTitle("Validate Information ");
                a.setContentText("Please enter valid phone number.");
                a.setHeaderText(null);
                a.showAndWait();    
            }
        }
       else{
            Alert a = new Alert(Alert.AlertType.WARNING);
                a.setTitle("INFORMATION ");
                a.setContentText("Please fill up all the informations.");
                a.setHeaderText(null);
                a.showAndWait(); 
           
       
           
       }
       }
       
        
       
    
    
}
