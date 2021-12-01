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
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Farha
 */
public class UpdateMeritListController implements Initializable {

    private ArrayList<String> fileTypeList;  
    @FXML
    private TextArea awardListTextArea;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileTypeList = new ArrayList<String>();
        fileTypeList.add("*.txt");
        fileTypeList.add("*.doc");
        fileTypeList.add("*.docx");
        fileTypeList.add("*.TXT");
        fileTypeList.add("*.DOC");
        fileTypeList.add("*.DOCX");
    }    

    @FXML
    private void submitButtonOnclick(ActionEvent event) throws IOException {
        
        AdministrativeStaff as = new AdministrativeStaff();
        String str = as.uploadNewmeritList("Dean's List");
        
        awardListTextArea.setText(str);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText(" Document upload");
        a.setContentText("Your file has been uploaded.");
        a.showAndWait();  
    }

    @FXML
    private void submitVCList(ActionEvent event) {
       
                
        AdministrativeStaff as = new AdministrativeStaff();
        String str = as.uploadNewmeritList("VC Merit List");
        
        awardListTextArea.setText(str);
         Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText(" Document upload");
        a.setContentText("Your file has been uploaded.");
        a.showAndWait();  
        
    }

    @FXML
    private void submitDMList(ActionEvent event) {
        
      AdministrativeStaff as = new AdministrativeStaff();
        String str = as.uploadNewmeritList("Dean's Merit List");
        
        awardListTextArea.setText(str);
         Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText(" Document upload");
        a.setContentText("Your file has been uploaded.");
        a.showAndWait();  
      
    }

    @FXML
    private void goToPreviousScene(ActionEvent event) throws IOException {
        Parent fileChooserViewParent = FXMLLoader.load(getClass().getResource("TrainingFormScene.fxml"));
     Scene fileChooserViewScene = new Scene(fileChooserViewParent);
     Stage newWindow = new Stage();
     newWindow.setScene(fileChooserViewScene);
     newWindow.show();  
        
    }
}

    

