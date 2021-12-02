/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class MainApplicationDashboardController implements Initializable,Serializable {

   
    private MenuItem RequestForEduMenuItem;
    @FXML
   private MenuItem reportIncidentButton;
    @FXML
    private MenuBar myMenuBar;
    @FXML
    private Label userNameLabel;
    @FXML
    private MenuItem citsMenuItem;
    @FXML
    private MenuItem administrationMenuItem;
    @FXML
    private ImageView imageview2;
    @FXML
    private ImageView imageview3;
    @FXML
    private ImageView imageview;
    /**
     * Initializes the controller class.
     * 
     */
    
     @FXML
    private void openCITsSceneOnClick(ActionEvent event) throws IOException {
        UserLoginSceneController usc = new UserLoginSceneController();
        System.out.println(usc.getSelectedUser());
           if(usc.getSelectedUser()!= "CITS"){ 
            JOptionPane.showMessageDialog(null,"You do not have access to this page.Please contact with CITs");
        }
        else{
        Parent p = FXMLLoader.load(getClass().getResource("CITsScene.fxml"));
        Scene scene = new Scene(p);
        Stage stage;
        stage = (Stage) myMenuBar.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserClass use = new UserClass();
            UserLoginSceneController usc = new UserLoginSceneController();
            String n = use.getUsername();
            System.out.println(n);
            userNameLabel.setText(n);
        try {
            
            InputStream stream ,stream1, stream2;
            stream = new FileInputStream("D:\\JAVA SCENES\\DoSAlogo.png");
            stream1 = new FileInputStream("D:\\JAVA SCENES\\iubevent.jpg");
            stream2 = new FileInputStream("D:\\JAVA SCENES\\iubgrad.jpg");
            Image image1 = new Image(stream1);
            Image image2 = new Image(stream2);
            Image image = new Image(stream);
            imageview.setImage(image);
            imageview3.setImage(image2);
            imageview2.setImage(image1);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainApplicationDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    

    private void TrainingFormOnClick(ActionEvent event) throws IOException {
        
        
            Parent p = FXMLLoader.load(getClass().getResource("TrainingFormScene.fxml"));
            Scene scene = new Scene(p);
            Stage stage;
            stage = (Stage) myMenuBar.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        
        
    }
    
     
     

    

    @FXML
    private void CloseMenuItem(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void ViewEventMenuItemOnClick(ActionEvent event) throws IOException {
        
        Parent p = FXMLLoader.load(getClass().getResource("EventView.fxml"));
        Scene scene = new Scene(p);
        Stage stage;
        stage = (Stage) myMenuBar.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void TrainingFormMenuItemOnClick(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("TrainingFormScene.fxml"));
        Scene scene = new Scene(p);
        Stage stage;
        stage = (Stage) myMenuBar.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void requestForEduMenuitem(ActionEvent event) throws IOException {
      
         UserLoginSceneController usc = new UserLoginSceneController();
         System.out.println(usc.getSelectedUser());
           if(usc.getSelectedUser()!= "Faculty"){ 
            JOptionPane.showMessageDialog(null,"You do not have access to this page.Please contact with CITs");
        }
        else{
            Parent p = FXMLLoader.load(getClass().getResource("EducationChangeRequestBox.fxml"));
            Scene scene = new Scene(p);
            Stage stage;
            stage = (Stage) myMenuBar.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
         }
        
        
    }

    @FXML
    private void reportIncidentMenuItemOnClick(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("IncidentReportForm.fxml"));
        Scene scene = new Scene(p);
        Stage stage;
        stage = (Stage) myMenuBar.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void registerClubMenuItemOnclick(ActionEvent event) throws IOException {
        
        Parent p = FXMLLoader.load(getClass().getResource("ClubRegistrationScene.fxml"));
        Scene scene = new Scene(p);
        Stage stage;
        stage = (Stage) myMenuBar.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void requestScholarshipMenuItemOnClick(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("ScholarshipApplicationForm.fxml"));
        Scene scene = new Scene(p);
        Stage stage;
        stage = (Stage) myMenuBar.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void submitInquiryOnClick(ActionEvent event) throws IOException {
         Parent p = FXMLLoader.load(getClass().getResource("InquiryForm.fxml"));
        Scene scene = new Scene(p);
        Stage stage;
        stage = (Stage) myMenuBar.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void jobCircularMenuItemOnClick(ActionEvent event) throws IOException {
         Parent p = FXMLLoader.load(getClass().getResource("JobCircular.fxml"));
        Scene scene = new Scene(p);
        Stage stage;
        stage = (Stage) myMenuBar.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void viewNoticeOnClick(ActionEvent event) throws IOException {
        
         Parent p = FXMLLoader.load(getClass().getResource("NoticeScene.fxml"));
        Scene scene = new Scene(p);
        Stage stage;
        stage = (Stage) myMenuBar.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void OpenAlumniSceneOnclick(ActionEvent event) throws IOException {
        
        Parent p = FXMLLoader.load(getClass().getResource("AlumniScene.fxml"));
        Scene scene = new Scene(p);
        Stage stage;
        stage = (Stage) myMenuBar.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void ViewMeritListOnclick(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("ViewMeritListScene.fxml"));
        Scene scene = new Scene(p);
        Stage stage;
        stage = (Stage) myMenuBar.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void OpenDigitalLibrarySceneOnclick(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("LibrarymembershipScene.fxml"));
        Scene scene = new Scene(p);
        Stage stage;
        stage = (Stage) myMenuBar.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void OpenMentalCounsellingSceneOnclick(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("CounsellingScene.fxml"));
        Scene scene = new Scene(p);
        Stage stage;
        stage = (Stage) myMenuBar.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void OpenStudentNetworkSceneOnclick(ActionEvent event) throws IOException {
        
        Parent p = FXMLLoader.load(getClass().getResource("StudentNetworkScene.fxml"));
        Scene scene = new Scene(p);
        Stage stage;
        stage = (Stage) myMenuBar.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void openAdministrationSceneOnClick(ActionEvent event) throws IOException {
        UserLoginSceneController usc = new UserLoginSceneController();
        System.out.println(usc.getSelectedUser());
        
        if(usc.getSelectedUser()!= "Administrative"){ 
            JOptionPane.showMessageDialog(null,"You do not have access to this page.Please contact with CITs");
        }
        else{
               Parent p = FXMLLoader.load(getClass().getResource("AdministrativeScene.fxml"));
                Scene scene = new Scene(p);
                Stage stage;
                stage = (Stage) myMenuBar.getScene().getWindow();

                stage.setScene(scene);
                stage.show();
        }
    }

    @FXML
    private void OpenAlumniNetworkSceneOnclick(ActionEvent event) throws IOException {
        UserLoginSceneController usc = new UserLoginSceneController();
        /*if(usc.getSelectedUser() != "Alumni"){
             JOptionPane.showMessageDialog(null,"You do not have access to this page.Please contact with CITs");
        }
        else{*/
        Parent p = FXMLLoader.load(getClass().getResource("AlumniNetworkScene.fxml"));
                Scene scene = new Scene(p);
                Stage stage;
                stage = (Stage) myMenuBar.getScene().getWindow();

                stage.setScene(scene);
                stage.show();
    }
         
        
    

   

    
    
    
}
