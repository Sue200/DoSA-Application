/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

//import com.sun.javafx.logging.PlatformLogger.Level;
import java.io.IOException;
//import java.lang.System.Logger;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class InquiryFormController implements Initializable {

    
    @FXML
    private TextField PhoneNumber;
    @FXML
    private TextArea AddressTextfield;
    @FXML
    private TextArea inquiryTextfield;
   
    @FXML
    private Label nameLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private TextField deptTextfield;
    @FXML
    private Button submitbutton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameLabel.setText(UserClass.getUsername());
        idLabel.setText(UserClass.getuserId());
        emailLabel.setText(UserClass.getemail());
        if(UserLoginSceneController.getSelectedUser()!= "Student"){
            submitbutton.setDisable(true);
        }
    }    

    @FXML
    private void SubmitInquiryButton(ActionEvent event) throws IOException {
        String dept = deptTextfield.getText();
         String PhoneNo = PhoneNumber.getText();
         String address = AddressTextfield.getText();
         String Inquirybox = inquiryTextfield.getText();
         Validation v = new Validation();
         
             if(dept.equals("")){
                JOptionPane.showMessageDialog(null,"Semester not found");
            }
            if(PhoneNo.equals("")){
                JOptionPane.showMessageDialog(null,"Phone number not found");
            }
            if(address.equals("")){
                JOptionPane.showMessageDialog(null,"Address not found");
            }
            if(Inquirybox.equals("")){
                JOptionPane.showMessageDialog(null,"Inquiry not found");
            }
            
            else{
                if(v.validatePhoneNo(PhoneNumber.getText())){
                  
                    Student s = new Student();
                    s.inquiryApplication(nameLabel.getText(),Integer.parseInt(idLabel.getText()), emailLabel.getText(),dept, Integer.parseInt(PhoneNumber.getText()),address,Inquirybox);
                    
                    
    
                         PhoneNumber.setText(null);
                          AddressTextfield.setText(null);
                          inquiryTextfield.setText(null);
                }
                else{
                     Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error Alert");
                    a.setHeaderText("INFORMATION ERROR");
                    a.setContentText("Please enter valid phone number");
                    a.showAndWait(); 
                }
                 
                 
                 
       
        }
        
         
    }

    @FXML
    private void ClearformButton(ActionEvent event) { 
        
        PhoneNumber.setText(null);
        AddressTextfield.setText(null);
        inquiryTextfield.setText(null);
       
    
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
