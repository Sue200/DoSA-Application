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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class ScholarshipApplicationFormController implements Initializable {

    @FXML
    private CheckBox TickBox;
    @FXML
    private Label Studname;
    @FXML
    private Label studID;
    @FXML
    private Label studEmail;
    @FXML
    private ChoiceBox<String> ScholarshipTypeBox;
    @FXML
    private ChoiceBox<String> AnyotherScholarshipBox;
    @FXML
    private TextArea ReasonTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ScholarshipTypeBox.getItems().addAll("Financial Aid","Sibling Discount","Merit");
        ScholarshipTypeBox.getItems().add("ECA");
        ScholarshipTypeBox.setValue("No option Chosen");
        Studname.setText(UserClass.getUsername());
        studID.setText(UserClass.getuserId());
        studEmail.setText(UserClass.getemail());
        
        AnyotherScholarshipBox.getItems().addAll("Yes","No");
        AnyotherScholarshipBox.setValue("No");
        
    }    

    @FXML
    private void SubmitScholarshipButton(ActionEvent event) {
        Student s = new Student();
       
      if(TickBox.isSelected()){
          if(ScholarshipTypeBox.getSelectionModel().getSelectedItem().equals("No option Chosen")||
                  AnyotherScholarshipBox.getSelectionModel().getSelectedItem().equals("No option Chosen")||ReasonTextArea.getText().equals("")){
                  Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setTitle("Warning Alert");
                    a.setContentText("Please fill up all informations");
                    a.setHeaderText(null);
                    a.showAndWait();  
          }
          else{
                     s.scholarshipApplication(ScholarshipTypeBox.getSelectionModel().getSelectedItem(), 
                    AnyotherScholarshipBox.getSelectionModel().getSelectedItem(),ReasonTextArea.getText());
                    JOptionPane.showMessageDialog(null, "Your Application has been submitted successfully");

                    ReasonTextArea.setText(null);
                    AnyotherScholarshipBox.setValue("No option Chosen");
                    ScholarshipTypeBox.setValue("No");
          }
           
        }
      else{
          JOptionPane.showMessageDialog(null, "You cannot proceed further");
      }
        
    }

    @FXML
    private void goBackOnClick(ActionEvent event) throws IOException {
         Parent p = FXMLLoader.load(getClass().getResource("MainApplicationDashboard.fxml"));
        Scene scene = new Scene(p);
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
