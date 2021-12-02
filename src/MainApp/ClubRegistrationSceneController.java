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
import javax.swing.JOptionPane;

public class ClubRegistrationSceneController implements Initializable {

    @FXML
    private TextArea ClubTextArea;
   
    @FXML
    private ComboBox<String> SelectDepartment;
    @FXML
    private ComboBox<String> SelectClub;
    @FXML
    private Label nameLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Label emailLabel;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // Student s = new Student();
        nameLabel.setText(Student.getUsername());
        idLabel.setText(Student.getuserId());
        emailLabel.setText(Student.getemail());
        SelectDepartment.getItems().addAll("CSE","EEE","BBA","PHR","ENV");
        SelectDepartment.setValue("No option chosen");
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
                         SelectClub.getItems().add(j.getClubName());

                       System.out.println("reached here3");
                     
                       
         
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
              
            }
          
        }      
       
        SelectClub.setValue("No options chosen");
    }    

    @FXML
    private void RegisterButton(ActionEvent event) throws IOException {
         String clubDescription = ClubTextArea.getText();
         String selectedDept = SelectDepartment.getSelectionModel().getSelectedItem();
         String selectedClub = SelectClub.getSelectionModel().getSelectedItem();
          

            if(clubDescription.equals("") || selectedDept.equals("No option chosen")|| selectedClub.equals("No option chosen")){
                JOptionPane.showMessageDialog(null,"Please fill up all the informations");
            }
            else{
                Student s = new Student();
                s.clubregister(nameLabel.getText(),idLabel.getText(),emailLabel.getText(), clubDescription, selectedDept, selectedClub);
                JOptionPane.showMessageDialog(null, "Your form has been submitted");
                 
                 ClubTextArea.setText(null);
                  SelectDepartment.setValue("CSE");
                  SelectClub.setValue("No options chosen");
            }
    }

    @FXML
    private void goBackButton(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("ViewClubInfo.fxml"));
        
        Scene scene = new Scene(p);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
            stg.setScene(scene);
            stg.setTitle("Club Information");
            stg.show();
        
    }
}
        
   
    
    

