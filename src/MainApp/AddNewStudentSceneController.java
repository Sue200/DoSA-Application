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
import javafx.scene.control.TextField;


public class AddNewStudentSceneController implements Initializable {

    @FXML
    private TextField cgpaTextfield;
    @FXML
    private TextField TotalCreditsTextfield;
    @FXML
    private TextField PhoneNo;
    @FXML
    private TextField Semester;
    @FXML
    private TextField Department;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddStudentButton(ActionEvent event) {
    }

    @FXML
    private void ClearButton(ActionEvent event) {
    }
    
}
