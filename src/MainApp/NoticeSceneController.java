/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public  class NoticeSceneController implements Initializable{

    @FXML
    private TextArea announcementTextArea;
    @FXML
    private DatePicker uploadDate;
    @FXML
    private TableColumn<Notice, String> annoucementColumn;
    @FXML
    private TableColumn<Notice, LocalDate> dateColumn;
    @FXML
    private TableView<Notice> noticeTable;
    @FXML
    private Button deleteButton;
    @FXML
    private Button postButton;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        annoucementColumn.setCellValueFactory(new PropertyValueFactory<Notice, String>("announcement"));
         dateColumn.setCellValueFactory(new PropertyValueFactory<Notice, LocalDate>("date"));
         noticeTable.setEditable(true);
        
         annoucementColumn.setCellFactory(TextFieldTableCell.forTableColumn());
          noticeTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
          if(UserLoginSceneController.getSelectedUser().equals("Student") || UserLoginSceneController.getSelectedUser().equals("Alumni")){
               deleteButton.setVisible(false);
               postButton.setDisable(true);
                
          }
        
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
    private void loadAnnoucementOnClick(ActionEvent event) throws ClassNotFoundException {
        noticeTable.getItems().clear();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
         try{
             f = new File("NoticeDatabase.bin");
             fis = new FileInputStream(f);
             ois = new ObjectInputStream(fis);
            Notice note ;
            
                 while(true){
                     System.out.println("checking objects.");
                     note = (Notice)ois.readObject();
                    System.out.println("I am here");
                         noticeTable.getItems().add(note);
                 }

         } catch (IOException ex) { } 
         finally {
             try {
                 if(ois != null) ois.close();
             } catch (IOException ex) { }
         }
    }
    
     @FXML
    private void addPostOnClick(ActionEvent event) {
        //ObservableList<Notice> list = null;
        UpdateNotice n ;
         if(UserLoginSceneController.getSelectedUser().equals("Administrative")){
            n = new AdministrativeStaff();
              noticeTable.getItems().add(n.addnewnotice(announcementTextArea.getText(),uploadDate.getValue()));
            //noticeTable.getItems().add(list);
        }
        else if(UserLoginSceneController.getSelectedUser().equals("CITS")){
            n = new CITS();
            noticeTable.getItems().add(n.addnewnotice(announcementTextArea.getText(),uploadDate.getValue()));
        }
        else if(UserLoginSceneController.getSelectedUser().equals("Faculty")){
           n = new Faculty();
           noticeTable.getItems().add(n.addnewnotice(announcementTextArea.getText(),uploadDate.getValue()));
        }
        else{
                 Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error Alert");
                a.setHeaderText("Fatal Error!");
                a.setContentText("You are not eligible to post");
                a.showAndWait(); 
        }
        
        announcementTextArea.setText(null);
        uploadDate.setValue(null);
        
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Confirmation");
        a.setContentText("Your Notice has been uploaded Thank you.");
        a.showAndWait();    
       
        
            
      
    }
    

    @FXML
    private void deleteNoticeOnclick(ActionEvent event) {
        ObservableList<Notice> selectedRows, allnotices;
         allnotices = noticeTable.getItems();
         selectedRows = noticeTable.getSelectionModel().getSelectedItems();
         
         
         for(Notice e : selectedRows){
             allnotices.remove(e);
         }
         
         UpdateNotice n;
         if(UserLoginSceneController.getSelectedUser().equals("Administrative")){
            n = new AdministrativeStaff();
              n.deleteNotice(allnotices);
           // noticeTable.getItems().add(list);
        }
        else if(UserLoginSceneController.getSelectedUser().equals("CITS")){
            n = new CITS();
             n.deleteNotice(allnotices);
        }
        else if(UserLoginSceneController.getSelectedUser().equals("Faculty")){
           n = new Faculty();
            n.deleteNotice(allnotices);
        }
         
    }    

    @FXML
    private void editAnnouncementColumn(TableColumn.CellEditEvent<Notice, String> event) {
         ObservableList<Notice> allnotice;
        allnotice = noticeTable.getItems();
        Notice n = noticeTable.getSelectionModel().getSelectedItem();
       // allnotice.remove(n);
        n.setAnnouncement(event.getNewValue());
        //allnotice.add(n);
        
        CITS c = new CITS();
        
        
        File f = null;
          FileOutputStream fos = null;      
          ObjectOutputStream oos = null;
          
            try {
                    f = new File("NoticeDatabase.bin");        
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                   
                    
                    for(Notice j : allnotice){
                         oos.writeObject(j);
                        
                    }
             

            } catch (IOException ex) {
                Logger.getLogger(AddUserSceneController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if(oos != null) oos.close();
                    
                } catch (IOException ex) {
                    Logger.getLogger(AddUserSceneController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
    }

    
         
    }
        
    

   

