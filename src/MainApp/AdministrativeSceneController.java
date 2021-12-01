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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Farha
 */
public class AdministrativeSceneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }    

    @FXML
    private void goBackbuttonOnclick(ActionEvent event) throws IOException {
        
         Parent root = FXMLLoader.load(getClass().getResource("MainApplicationDashboard.fxml"));
        Scene scene = new Scene(root);
         Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(scene);
        stg.setTitle("User Login");
        stg.show();
    }

    @FXML
    private void viewEventReportSceneOnClick(ActionEvent event) throws IOException {
         Parent part = FXMLLoader.load(getClass().getResource("ViewReportEvent.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void openEventSceneOnclick(ActionEvent event) throws IOException {
         Parent part = FXMLLoader.load(getClass().getResource("EventView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void openNoticeSceneOnClick(ActionEvent event) throws IOException {
         Parent part = FXMLLoader.load(getClass().getResource("NoticeScene.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void openAddMeritList(ActionEvent event) throws IOException {
         Parent part = FXMLLoader.load(getClass().getResource("UpdateMeritList.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }
    
   
}
