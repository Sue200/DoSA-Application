/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;
//opens MainApp.Application to javafx.base ;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;


public class EventViewController implements Initializable{

    @FXML
    private TableColumn<Eventpicker, String> eventnameColumn;
    @FXML
    private TableColumn<Eventpicker, String> eventTimeColumn;
    @FXML
    private TableColumn<Eventpicker,String> eventVenueColumn;
    @FXML
    private TableView<Eventpicker> eventTableView;
    @FXML
    private Button button;
    @FXML
    private Button deleteEvent;
    @FXML
    private Label eventname;
    @FXML
    private TableColumn<Eventpicker, LocalDate> dateColumn;
   
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        eventnameColumn.setCellValueFactory(new PropertyValueFactory<>("eventname"));
        eventTimeColumn.setCellValueFactory(new PropertyValueFactory<>("eventTime"));
        eventVenueColumn.setCellValueFactory(new PropertyValueFactory<>("eventVenue"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("eventDate"));
        
        eventTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        if(UserLoginSceneController.getSelectedUser() != "Administrative"){
            button.setDisable(true);
          deleteEvent.setVisible(false);
            
        }
        eventTableView.setEditable(true);
       
    }    

    @FXML
    private void OpenRegistrationButton(ActionEvent event) throws IOException {
        //ObservableList<Eventpicker> selectedrow;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EventRegistrationScene.fxml"));
        Parent personViewParent = loader.load();
        Scene personViewScene = new Scene(personViewParent);
        //selectedrow = eventTableView.getSelectionModel().getSelectedItems();
       EventRegistrationSceneController controller = loader.getController();
       controller.initData(eventTableView.getSelectionModel().getSelectedItem());
       
       Stage window  = (Stage)((Node)event.getSource()).getScene().getWindow();
       window.setScene(personViewScene);
        window.show();
    }

    @FXML
    private void readBinaryForUpcomingEvents(ActionEvent event) throws FileNotFoundException, IOException {
      
       eventname.setText("All events");
       eventTableView.getItems().clear();
         File f = null;
       FileInputStream fis = null;      
       ObjectInputStream ois = null;
       System.out.println("reached here1");
      
         try{
            f = new File("UpcomingEvent.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
             Eventpicker p;
            
            System.out.println("reached here2");
            
             while(true){
                    System.out.println("checking objects.");
                    p = (Eventpicker) ois.readObject();
                    System.out.println("reached here3");
                    p.display();
                    //list.add(p);
                    eventTableView.getItems().add(p);
         
             }
            
        } catch (IOException ex) {
            try {
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
         
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(EventViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void viewClubEventButton(ActionEvent event) throws ClassNotFoundException {
         eventname.setText("Club");
          eventTableView.getItems().clear();
         File f = null;
       FileInputStream fis = null;      
       ObjectInputStream ois = null;
       System.out.println("reached here1");
      
         try{
            f = new File("ClubEventDatabase.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
             Eventpicker p;
            
            System.out.println("reached here2");
            
             while(true){
                    System.out.println("checking objects.");
                    p = (Eventpicker) ois.readObject();
                    System.out.println("reached here3");
                    p.display();
                   
                    eventTableView.getItems().add(p);
         
             }
            
        } catch (IOException ex) {
            try {
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
           // ex.printStackTrace();
        }      
        
    }

    @FXML
    private void ViewVolunteerWorkEvent(ActionEvent event) throws ClassNotFoundException {
         eventname.setText("Volunteer");
          eventTableView.getItems().clear();
         File f = null;
       FileInputStream fis = null;      
       ObjectInputStream ois = null;
       System.out.println("reached here1");
      
         try{
            f = new File("voltunteerEventDatabase.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
             Eventpicker p;
            
            System.out.println("reached here2");
            
             while(true){
                    System.out.println("checking objects.");
                    p = (Eventpicker) ois.readObject();
                    System.out.println("reached here3");
                    p.display();
                   
                    eventTableView.getItems().add(p);
         
             }
            
        } catch (IOException ex) {
            try {
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
           // ex.printStackTrace();
        }      
        
    }

    @FXML
    private void ViewSocialEvent(ActionEvent event) throws ClassNotFoundException {
        eventname.setText("Social");
        eventTableView.getItems().clear();
         File f = null;
       FileInputStream fis = null;      
       ObjectInputStream ois = null;
       System.out.println("reached here1");
      
         try{
            f = new File("SocialDatabase.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
             Eventpicker p;
            
            System.out.println("reached here2");
            
             while(true){
                    System.out.println("checking objects.");
                    p = (Eventpicker) ois.readObject();
                    System.out.println("reached here3");
                    p.display();
                   
                    eventTableView.getItems().add(p);
         
             }
            
        } catch (IOException ex) {
            try {
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
           // ex.printStackTrace();
        }      
        
        
    }

    @FXML
    private void AddEventOnClick(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("AddeventScene.fxml"));
        Scene scene = new Scene(root);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
         //stg.setTitle("Dashboard");
        stg.setScene(scene);
        stg.show();
        
        //jOption
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
    private void activateofficialuse(ActionEvent event) {
    }

    @FXML
    private void deleteOnClick(ActionEvent event) {
        ObservableList<Eventpicker> selectedRows, allevents;
        CITS c = new CITS();
         allevents = eventTableView.getItems();
         selectedRows = eventTableView.getSelectionModel().getSelectedItems();
         
         for(Eventpicker e : selectedRows){
             e.display();
             allevents.remove(e);
         }
         c.deleteEvents(eventname.getText(), allevents);
         
    }

   

}

   

    
    

