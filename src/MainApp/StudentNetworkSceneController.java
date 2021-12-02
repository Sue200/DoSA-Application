/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class StudentNetworkSceneController implements Initializable {

    @FXML
    private TextField deptName;
    @FXML
    private TextField linkedInLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label idLabel;
    @FXML
    private TextArea goalsTextArea;
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
    }    

    @FXML
    private void backOnClick(ActionEvent event) throws IOException {
         Parent p = FXMLLoader.load(getClass().getResource("MainApplicationDashboard.fxml"));
        Scene scene = new Scene(p);
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void registerOnClick(ActionEvent event) {
        Validation v = new Validation();
    
        if(deptName.getText().equals("") ||phoneNo.getText().equals("")||  linkedInLabel.getText().equals("")||goalsTextArea.getText().equals("")){
          Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning Alert");
            a.setContentText("Please fill up all informations to proceed");
            a.setHeaderText(null);
            a.showAndWait(); 
        }
        else{
            if(v.validatePhoneNo(phoneNo.getText())){
                if(UserLoginSceneController.getSelectedUser().equals("Student")){
                Student s = new  Student();
                s.studentnetworkRegister(nameLabel.getText(),idLabel.getText(),emailLabel.getText(),
                        deptName.getText(),linkedInLabel.getText(),goalsTextArea.getText(),Integer.parseInt(phoneNo.getText()));

                }
                else if(UserLoginSceneController.getSelectedUser().equals("Alumni")){
                    Alumni a = new Alumni();
                      a.studentnetworkRegister(nameLabel.getText(),idLabel.getText(),emailLabel.getText(),
                            deptName.getText(),linkedInLabel.getText(),goalsTextArea.getText(),Integer.parseInt(phoneNo.getText()));

                }
                else{
                     Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setTitle("Warning Alert");
                    a.setContentText("You are not eligible for this");
                    a.setHeaderText(null);
                    a.showAndWait();  
                     //***********insert alert**********************//
                }
            }
            else{
                Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setTitle("Warning Alert");
                    a.setContentText("Please enter valid phone number");
                    a.setHeaderText(null);
                    a.showAndWait();  
            }
    }   
            
    
    
   
    
    
}
}
