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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Farha
 */
public class TrainingFormSceneController implements Initializable {

    @FXML
    private TextArea reasonTextArea;
    @FXML
    private TextField designation;
    @FXML
    private TextField dept;
    @FXML
    private TextField phoneNo;
    @FXML
    private ComboBox<String> choiceBox;
    @FXML
    private Label nameLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private TextField typeText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameLabel.setText(UserClass.getUsername());
        idLabel.setText(UserClass.getuserId());
        emailLabel.setText(UserClass.getemail());
        choiceBox.getItems().addAll("Yes","No");
        choiceBox.setValue("-No option chosen-");
        
    }    

    @FXML
    private void goBackOnCick(ActionEvent event) throws IOException {
         Parent p = FXMLLoader.load(getClass().getResource("MainApplicationDashboard.fxml"));
        Scene scene = new Scene(p);
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void registerOnClick(ActionEvent event) {
        Validation v = new Validation();
        UserLoginSceneController us = new UserLoginSceneController();
        Faculty f = new Faculty();
        if(us.getSelectedUser() != "Faculty"){
             Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning Alert");
            a.setContentText("Y");
            a.setHeaderText(null);
            a.showAndWait();
        }
        else{
            if(reasonTextArea.getText().equals("")||designation.getText().equals("")|| dept.getText().equals("")|| phoneNo.getText().equals("")|| choiceBox.getSelectionModel().getSelectedItem().equals("-No option chosen-")){
               Alert a = new Alert(Alert.AlertType.WARNING);
                a.setTitle("Warning Alert");
                a.setContentText("Please fill up all the informations");
                a.setHeaderText(null);
                a.showAndWait();
            }
            else{
                if(v.validatePhoneNo(phoneNo.getText())){
                    f.registerForTraining(nameLabel.getText(),idLabel.getText(),emailLabel.getText(),reasonTextArea.getText(),designation.getText(),
                    dept.getText(), Integer.parseInt(phoneNo.getText()),choiceBox.getSelectionModel().getSelectedItem());
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setTitle("Information Alert");
                    a.setHeaderText("Notice");
                    a.setContentText("your form has been submitted"+"\n"+"You wil receive further instructions in due time. ");
                    a.showAndWait();
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
    
}
