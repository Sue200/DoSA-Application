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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class JobCircularController implements Initializable {

    @FXML
    private TableColumn<Job, String> jobColumn;
    @FXML
    private TableColumn<Job, String> orgColumn;
    @FXML
    private TableColumn<Job, String> dateColumn;
    @FXML
    private TableColumn<Job, String> jobdescriptionColumn;
    @FXML
    private TableView<Job> jobTableView;
    @FXML
    private Button deletebutton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          jobColumn.setCellValueFactory(new PropertyValueFactory<>("jobname"));
        orgColumn.setCellValueFactory(new PropertyValueFactory<>("jobOrg"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        jobdescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("jobDescription"));
        
        if(UserLoginSceneController.getSelectedUser().equals("Student") || UserLoginSceneController.getSelectedUser().equals("Administrative")){
            deletebutton.setVisible(false);
        }
    }    

    @FXML
    private void backOnClick(ActionEvent event) throws IOException {
         Parent p = FXMLLoader.load(getClass().getResource("MainApplicationDashboard.fxml"));
        Scene scene = new Scene(p);
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void loadtableOnClick(ActionEvent event) {
        File f = null;
       FileInputStream fis = null;      
       ObjectInputStream ois = null;
       System.out.println("reached here1");
      
         try{
            f = new File("JobCircularDatabase.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
             Job j;
            
            System.out.println("reached here2");
             try {
                while(true){
                       System.out.println("checking objects.");

                       j = (Job) ois.readObject();

                       System.out.println("reached here3");
                       //j.display();
                       jobTableView.getItems().add(j);
         
             }
             
             } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JobCircularController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        } catch (IOException ex) {
            try {
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
               // e.printStackTrace();
            }
           // ex.printStackTrace();
        }      
    }

    @FXML
    private void newJobOnclick(ActionEvent event) throws IOException {
        
        Parent p = FXMLLoader.load(getClass().getResource("NewJobPostScene.fxml"));
        Scene scene = new Scene(p);
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void deleteOnClick(ActionEvent event) {
        ObservableList<Job> selectedrows, allJobs;
        allJobs = jobTableView.getItems();
        selectedrows = jobTableView.getSelectionModel().getSelectedItems();
        for(Job i : selectedrows){
            allJobs.remove(i);
        }
        JobVacancies j ;
        if(UserLoginSceneController.getSelectedUser().equals("Alumni")){
            j = new Alumni();
            j.deleteJobPost(allJobs);
        }
        else if(UserLoginSceneController.getSelectedUser().equals("CITS")){
            j = new CITS();
            j.deleteJobPost(allJobs);
        }
        else if(UserLoginSceneController.getSelectedUser().equals("Faculty")){
            j = new Faculty();
            j.deleteJobPost(allJobs);
        }
    }
    
}
