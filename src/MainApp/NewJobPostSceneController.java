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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class NewJobPostSceneController implements Initializable {

    @FXML
    private TextField jobname;
    @FXML
    private TextField orgname;
    @FXML
    private TextArea descript;
    @FXML
    private DatePicker uploaddate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void submitOnClick(ActionEvent event) {
        if(jobname.getText().equals("")|| orgname.getText().equals("")||descript.getText().equals("")|| uploaddate.getValue().equals(null)){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error Alert");
            a.setHeaderText("Fatal Error!");
            a.setContentText("Informations are incomplete");
            a.showAndWait(); 
        }
        else{
            JobVacancies j ;
            if(UserLoginSceneController.getSelectedUser().equals("Alumni")){
                j= new Alumni();
                j.addnewJobPost(jobname.getText(), orgname.getText(), descript.getText(), uploaddate.getValue());
            }
            else if(UserLoginSceneController.getSelectedUser().equals("CITS")){
               j = new CITS();
                j.addnewJobPost(jobname.getText(), orgname.getText(), descript.getText(), uploaddate.getValue());
            }
            else if(UserLoginSceneController.getSelectedUser().equals("Faculty")){
               j = new Faculty();
                j.addnewJobPost(jobname.getText(), orgname.getText(), descript.getText(), uploaddate.getValue());
            }
             Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Confirmation");
            a.setContentText("Your post has been created. Thank you.");
            a.showAndWait();    

            } 
        }
         
}
