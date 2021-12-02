/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class ViewClubInfoController implements Initializable {

    @FXML
    private TextArea descriptionOfClubButton;
    @FXML
    private ComboBox<String> ViewClubBox;
    private StringBuilder fieldContent = new StringBuilder(""); 
    @FXML
    private Label presidentLabel;
    @FXML
    private Label vpLabel;
    @FXML
    private Label gsLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        presidentLabel.setText(null);
        vpLabel.setText(null);
        gsLabel.setText(null);
        File f = null;
        FileInputStream fis = null;      
       ObjectInputStream ois = null;
       System.out.println("reached here1");
      
         try{
            f = new File("ClubDatabase.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
             ClubMembers j;
            
            System.out.println("reached here2");
             try {
                while(true){
                       System.out.println("checking objects.");

                       j = (ClubMembers) ois.readObject();
                        ViewClubBox.getItems().add(j.getClubName());

                       System.out.println("reached here3");
                       //j.display();
                       
         
             }
             
             } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ViewClubInfoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        } catch (IOException ex) {
            try {
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
               e.printStackTrace();
            }
            ex.printStackTrace();
        }      
       
       ViewClubBox.setValue("No option chosen");
        
    }    

    @FXML
    private void viewDescriptionOnclick(ActionEvent event) {
        //Student stud = new Student();
        String selectedClub;
        selectedClub = ViewClubBox.getSelectionModel().getSelectedItem();
         File f = null;
        FileInputStream fis = null;      
       ObjectInputStream ois = null;
       System.out.println("reached here1");
      
         try{
            f = new File("ClubDatabase.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
             ClubMembers j;
            
            System.out.println("reached here2");
             try {
                while(true){
                       System.out.println("checking objects.");

                       j = (ClubMembers) ois.readObject();
                       if(j.getClubName().equals(selectedClub)){
                           fieldContent.append(j.getDescription());
                           descriptionOfClubButton.setText(fieldContent.toString());
                           presidentLabel.setText(j.getPresident());
                           vpLabel.setText(j.getVpresident());
                           gsLabel.setText(j.getGeneralSecretary());
                       }

                       System.out.println("reached here3");
                       //j.display();
                       
         
             }
             
             } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ViewClubInfoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        } catch (IOException ex) {
            try {
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
               e.printStackTrace();
            }
            ex.printStackTrace();
        }      
    }

    @FXML
    private void registerForClubButton(ActionEvent event) throws IOException {
        
        Parent p = FXMLLoader.load(getClass().getResource("ClubRegistrationScene"));
        Scene s = new Scene(p);
        Stage sg = (Stage)((Node)event.getSource()).getScene().getWindow();
        sg.setScene(s);
        sg.setTitle("Club Registration");
        sg.show();
        
    }

    @FXML
    private void goBacktohome(ActionEvent event) throws IOException {
         Parent p = FXMLLoader.load(getClass().getResource("MainApplicationDashboard.fxml"));
        Scene scene = new Scene(p);
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
