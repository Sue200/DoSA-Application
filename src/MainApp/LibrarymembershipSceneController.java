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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Farha
 */
public class LibrarymembershipSceneController implements Initializable {

    @FXML
    private ComboBox<String> deptComboBox;
    @FXML
    private Label nameLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private TextField memberPin;
    @FXML
    private TextArea addressfield;
    @FXML
    private TextField phoneNo;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nameLabel.setText(UserClass.getUsername());
        idLabel.setText(UserClass.getuserId());
        emailLabel.setText(UserClass.getemail());
        deptComboBox.getItems().addAll("CSE","EEE", "BBA", "PHR", "ENV");
        deptComboBox.setValue("No option chosen");
    }    

    @FXML
    private void registerOnClick(ActionEvent event) {
        Validation v = new Validation();
     if(addressfield.getText().equals("") ||phoneNo.getText().equals("")||  memberPin.getText().equals("")||deptComboBox.getSelectionModel().getSelectedItem().equals("No option chosen")){
          Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning Alert");
            a.setContentText("Please fill up all informations to proceed");
            a.setHeaderText(null);
            a.showAndWait(); 
     }
     else{
         if(v.validatePhoneNo(phoneNo.getText())){
              Library m;
            if(UserLoginSceneController.getSelectedUser().equals("Alumni")){
                m = new Alumni();
                m.applyForLibraryMembership(nameLabel.getText(), emailLabel.getText(), addressfield.getText(),"Alumni", Integer.parseInt(idLabel.getText())
                    ,Integer.parseInt(phoneNo.getText()), Integer.parseInt(memberPin.getText()));
            }
            else if(UserLoginSceneController.getSelectedUser().equals("CITS")){
               m = new Student();
                m.applyForLibraryMembership(nameLabel.getText(), emailLabel.getText(), addressfield.getText(),"Student", Integer.parseInt(idLabel.getText())
                    ,Integer.parseInt(phoneNo.getText()), Integer.parseInt(memberPin.getText()));
            }
            else if(UserLoginSceneController.getSelectedUser().equals("Faculty")){
                m = new Faculty();
                m.applyForLibraryMembership(nameLabel.getText(), emailLabel.getText(), addressfield.getText(),"Faculty", Integer.parseInt(idLabel.getText())
                    ,Integer.parseInt(phoneNo.getText()), Integer.parseInt(memberPin.getText()));

             //Alert a = new Alert();

             addressfield.setText(null);
             phoneNo.setText(null);
             memberPin.setText(null);

            }
         }
     }
       
       
        



    }
}
    

