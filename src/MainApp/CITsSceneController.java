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


public class CITsSceneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void updateUserOnClick(ActionEvent event) throws IOException {
        Parent part = FXMLLoader.load(getClass().getResource("AddUserScene.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void viewReportOnClick(ActionEvent event) throws IOException {
        Parent part = FXMLLoader.load(getClass().getResource("NumberOfUsersScene.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToJobSceneOnClick(ActionEvent event) throws IOException {
        Parent part = FXMLLoader.load(getClass().getResource("NewJobPostScene.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void updateEventOnClick(ActionEvent event) throws IOException {
        
        Parent part = FXMLLoader.load(getClass().getResource("EventView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void noticeSceneOnclick(ActionEvent event) throws IOException {
        
        Parent part = FXMLLoader.load(getClass().getResource("NoticeScene.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void backToDashboardOnClick(ActionEvent event) throws IOException {
         Parent p = FXMLLoader.load(getClass().getResource("MainApplicationDashboard.fxml"));
        Scene scene = new Scene(p);
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
