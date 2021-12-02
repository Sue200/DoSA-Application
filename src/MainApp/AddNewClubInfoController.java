/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddNewClubInfoController implements Initializable {

    @FXML
    private TextField clubName;
    @FXML
    private TextArea clubdescript;
    @FXML
    private TextField presName;
    @FXML
    private TextField vpName;
    @FXML
    private TextField secretaryName;
    @FXML
    private TextField gsName;
    @FXML
    private TextField treasureName;
    @FXML
    private TextField faName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addnewclubOnClick(ActionEvent event) {
        if(clubName.getText().equals("")||clubdescript.getText().equals("")||presName.getText().equals("")||gsName.getText().equals("")||
                    vpName.getText().equals("")){
                      File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("ClubDatabase.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            ClubMembers c = new ClubMembers(clubName.getText(),clubdescript.getText(),presName.getText(),gsName.getText(),
                    vpName.getText()
            );
            oos.writeObject(c);
            //j.display();
            System.out.println("Object done inserting into file");

        } catch (IOException ex) {
            Logger.getLogger(NewJobPostSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(NewJobPostSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        else{
            
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning Alert");
            a.setContentText("Please fill up all the informations.");
            a.setHeaderText(null);
            a.showAndWait();       
        }
            
    
    } 
        
    
    
}
