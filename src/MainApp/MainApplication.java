/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.IOException;
import java.io.Serializable;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Farha
 */
public class MainApplication extends Application implements Serializable{
    
    /**
     *
     * @param stage
     * @throws java.io.IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        
   //Parent root = FXMLLoader.load(getClass().getResource("UserLoginScene.fxml"));
    //Parent root = FXMLLoader.load(getClass().getResource("AddUserScene.fxml"));
        // Parent root = FXMLLoader.load(getClass().getResource("IncidentReportform.fxml"));
         Parent root = FXMLLoader.load(getClass().getResource("MainApplicationDashboard.fxml"));
    //Parent root = FXMLLoader.load(getClass().getResource("NoticeScene.fxml"));
      // Parent root = FXMLLoader.load(getClass().getResource("ScholarshipApplicationForm.fxml"));
       //  Parent root = FXMLLoader.load(getClass().getResource("ViewClubInfo.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("User Login");
        stage.show();
        
  
    } 
    public static void main(String[] args) {
        launch(args);
    }
    
}
