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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class UserLoginSceneController implements Initializable {

    @FXML
    private TextField UserIDTextfield;
    @FXML
    private TextField PasswordTextfield;
    private UserClass user;
    @FXML
    private ComboBox<String> UserTypeBox;
    
    private  static String option;
    /**
     * Initializes the controller class.
     * @return 
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserTypeBox.getItems().addAll("Student", "Faculty","Alumni","Administrative","CITS");
        UserTypeBox.setValue("No option chosen");
        
    } 
    
    @FXML
    private void LoginOnClickButton(ActionEvent e) throws IOException {
         
        option = UserTypeBox.getSelectionModel().getSelectedItem();
        System.out.println(option);
       
            if( UserClass.verifylogin(UserIDTextfield.getText(),PasswordTextfield.getText(),
                                        UserTypeBox.getSelectionModel().getSelectedItem())){
                Parent p = FXMLLoader.load(getClass().getResource("MainApplicationDashboard.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)e.getSource()).getScene().getWindow();
            //stg.setTitle("Dashboard");
            stg.setScene(newScene);
            stg.show();
            }
            else{
                System.out.println("Not found");
            }
        }
        
    public static String getSelectedUser(){
        System.out.println("I am here");
        //option = UserTypeBox.getSelectionModel().getSelectedItem();
        System.out.println("I am here");
        System.out.println(option);
            return option;
    }  
        
      

    
}
