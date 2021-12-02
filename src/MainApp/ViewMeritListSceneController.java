/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

//import com.sun.javafx.logging.PlatformLogger.Level;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.lang.System.Logger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


public class ViewMeritListSceneController implements Initializable {

    @FXML
    private ListView<String> mainMeritList;
    @FXML
    private Label awardLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        awardLabel.setText(null);
        
    }    

    @FXML
    private void goBackOnClick(ActionEvent event) throws IOException {
         Parent p = FXMLLoader.load(getClass().getResource("MainApplicationDashboard.fxml"));
        Scene scene = new Scene(p);
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void deanListOnClick(ActionEvent event) throws FileNotFoundException {
        mainMeritList.getItems().setAll(" ");
        awardLabel.setText("Dean Award");
        File f = new File("DeanListDatabase.txt");
        String str = null;
        Scanner sc;
        System.out.println("Let us begin");
        try{
            sc = new Scanner(f);
            System.out.println("here 1");
            while(sc.hasNextLine()){
                  System.out.println("here 2");
                str = sc.nextLine();
                  System.out.println("here 3");
                mainMeritList.getItems().add(str);
                  System.out.println("completed");
            }
        }catch(FileNotFoundException ex){
            Logger.getLogger(ViewMeritListSceneController.class.getName()).log(Level.SEVERE, null, ex);
            
        }

        
    }

    @FXML
    private void viewVCList(ActionEvent event) {
        mainMeritList.getItems().setAll(" ");
         awardLabel.setText("Chancellor Award");
        File f = new File("VCMeritDatabase.txt");
        String str = null;
        Scanner sc;
        System.out.println("Let us begin");
        try{
            sc = new Scanner(f);
            System.out.println("here 1");
            while(sc.hasNextLine()){
                  System.out.println("here 2");
                str = sc.nextLine();
                  System.out.println("here 3");
                mainMeritList.getItems().add(str);
                  System.out.println("completed");
            }
        }catch(FileNotFoundException ex){
            Logger.getLogger(ViewMeritListSceneController.class.getName()).log(Level.SEVERE, null, ex);
            
        }

    }

    @FXML
    private void viewDMlist(ActionEvent event) {
       //mainMeritList.getItems().setAll(null);
       mainMeritList.getItems().setAll(" ");
         awardLabel.setText("Dean merit Award");
        File f = new File("DeansMeritDatabase.txt");
        String str = null;
        Scanner sc;
        System.out.println("Let us begin");
        try{
            sc = new Scanner(f);
            System.out.println("here 1");
            while(sc.hasNextLine()){
                  System.out.println("here 2");
                str = sc.nextLine();
                  System.out.println("here 3");
                mainMeritList.getItems().add(str);
                  System.out.println("completed");
            }
        }catch(FileNotFoundException ex){
            Logger.getLogger(ViewMeritListSceneController.class.getName()).log(Level.SEVERE, null, ex);
            
        }

    }
    
    
    
}
