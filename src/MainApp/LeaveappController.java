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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


public class LeaveappController implements Initializable {

    
    @FXML
    private TextField noOfCoursesTaken;
    @FXML
    private TextArea coursesName;
    @FXML
    private TextArea reasonforLeave;
    @FXML
    private TextField leaveDuration;
    @FXML
    private DatePicker leaveDate;
    @FXML
    private DatePicker joinDate;
    @FXML
    private ComboBox<String> deptComboBox;
    @FXML
    private Label nameLabel;
    @FXML
    private Label idLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        deptComboBox.getItems().addAll("CSE", "EEE","ENV", "BBA","PHR","SS");
        deptComboBox.setValue("No Options Chosen");
        nameLabel.setText(UserClass.getUsername());
        idLabel.setText(UserClass.getuserId());
    }    

    @FXML
    private void submitOnClick(ActionEvent event) {
       // UserLoginSceneController u = new UserLoginSceneController();
        Faculty fa = new Faculty();
        if(UserLoginSceneController.getSelectedUser() != "Faculty"){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning Alert");
            a.setContentText("You are not eligible for this.");
            a.setHeaderText(null);
            a.showAndWait(); 
        }
        else{
            if(noOfCoursesTaken.getText().equals("")||coursesName.getText().equals("")|| reasonforLeave.getText().equals("No Options Chosen")||
                    leaveDuration.getText().equals("")|| leaveDate.getValue().equals(null)||joinDate.getValue().equals(null)||deptComboBox.getSelectionModel().getSelectedItem().equals("No Options Chosen")){
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setTitle("Warning Alert");
                a.setContentText("Please fill up all the informations.");
                a.setHeaderText(null);
                a.showAndWait();
            
             }
            else{
                fa.leaveApplication(nameLabel.getText(), Integer.parseInt(idLabel.getText()), Integer.parseInt(noOfCoursesTaken.getText()), coursesName.getText(),reasonforLeave.getText()
                    ,leaveDuration.getText(),leaveDate.getValue(),joinDate.getValue(),deptComboBox.getSelectionModel().getSelectedItem());
            
             JOptionPane.showMessageDialog(null, "Your application has been submitted");
            }
       
        }
    }
      
    
}
