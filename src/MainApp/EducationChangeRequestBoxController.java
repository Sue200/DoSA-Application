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
public class EducationChangeRequestBoxController implements Initializable {

    @FXML
    private TextField typeOfchange;
    @FXML
    private TextArea suggestionBoxArea;
    @FXML
    private ComboBox<String> designationComboBox;
    @FXML
    private Label nameLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private ComboBox<String> dept;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        designationComboBox.getItems().addAll("Professor","Adjunct lecturer","Lecturer");
        dept.getItems().addAll("CSE","EEE","PHR","BBA","ENV");
        dept.setValue("No option chosen");
       designationComboBox.setValue("no option chosen");
    }

    @FXML
    private void goBackSceneOnclick(ActionEvent event) throws IOException {
         Parent p = FXMLLoader.load(getClass().getResource("MainApplicationDashboard.fxml"));
        Scene scene = new Scene(p);
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void submitRequestOnClick(ActionEvent event) {
        
        Faculty f = new Faculty();
        if(typeOfchange.getText().equals("")|| designationComboBox.getSelectionModel().getSelectedItem().equals("No option chosen")||suggestionBoxArea.getText().equals("")||dept.getSelectionModel().getSelectedItem().equals("No option chosen")){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error Alert");
            a.setHeaderText("Error");
            a.setContentText("Cannot proceed with the form as informations are incomplete");
            a.showAndWait(); 
        }
        else{
             f.requestEduChange(nameLabel.getText(),idLabel.getText(),emailLabel.getText(),typeOfchange.getText(),
                designationComboBox.getSelectionModel().getSelectedItem(),suggestionBoxArea.getText(),dept.getSelectionModel().getSelectedItem());
              Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Information Alert");
                a.setHeaderText("CONFIRMATION");
                a.setContentText("Your request has been submitted.");
                a.showAndWait();     
                
               typeOfchange.setText(null);
               
                designationComboBox.setValue("No option chosen");
                suggestionBoxArea.setText(null);
                dept.setValue("No option chosen");
        }
       
        
        
        
    }
    
}
