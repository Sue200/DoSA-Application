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
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Farha
 */
public class AddUserSceneController implements Initializable,Serializable {

    @FXML
    private ComboBox<String> TypeUserBox;
    @FXML
    private TextField fullNameTextfield;
    @FXML
    private TextField UserIDTextfield;
    @FXML
    private TextField UserEmailTextfield;
    @FXML
    private Tab addnewUserTab;
    @FXML
    private TextField newpassword;
    @FXML
    private Tab showUserTab;
    private Student stud;
    @FXML
    private ComboBox<String> userSelected;
    @FXML
    private TableView<UserClass> userTable;
    @FXML
    private TableColumn<UserClass, String> nameClumn;
    @FXML
    private TableColumn<UserClass, String> idcolumn;
    @FXML
    private TableColumn<UserClass, String> emailColumn;
    @FXML
    private TableColumn<UserClass, String> passColumn;
    
    private Validation v = new Validation();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        TypeUserBox.getItems().addAll("Student", "Faculty","Alumni", "Administrative","CITS");
        TypeUserBox.setValue("Student");
        nameClumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        idcolumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        passColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        userSelected.getItems().addAll("Student", "Faculty","Alumni", "Administrative","CITS");
        userTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
    }

    @FXML
    private void ProceedButton(ActionEvent event) throws IOException {
        CITS newUser = new CITS();
        if(UserIDTextfield.getText().equals("")&& fullNameTextfield.getText().equals("")&&UserEmailTextfield.getText().equals("")&&
               newpassword.getText().equals("")){
            
             Alert a = new Alert(Alert.AlertType.WARNING);
                a.setTitle("Warning Alert");
                a.setContentText("Please fill up all the informations");
                a.setHeaderText(null);
                a.showAndWait();  
            
            
        }
        else{
            if(v.validateid(UserIDTextfield.getText())&& v.validateEmail(UserEmailTextfield.getText())){
                newUser.addNewUsers(UserIDTextfield.getText(),fullNameTextfield.getText(),
                UserEmailTextfield.getText(),
                newpassword.getText(),TypeUserBox.getSelectionModel().getSelectedItem());
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Information Alert");
                //a.setHeaderText("Dessemination of Notice...");
                a.setContentText("User has been added in the system");
                a.showAndWait();         
            
            }
            else{
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setTitle("Warning Alert");
                a.setContentText("Please enter valid inputs");
                a.setHeaderText(null);
                a.showAndWait();   
            }
        }
        
        
     
    }

    @FXML
    private void showAllUsersOnClick(ActionEvent event) throws ClassNotFoundException {
        
        if(userSelected.getSelectionModel().getSelectedItem().equals("Student")){
            
             File f = null;
            FileInputStream fis = null;      
            ObjectInputStream ois = null;

            try{
            f = new File("StudentDatabase.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
             Student s;
            
            System.out.println("reached here2");
            
             while(true){
                    System.out.println("checking objects.");
                    s = (Student) ois.readObject();
                    System.out.println("reached here3");
                    //s.display();
                    userTable.getItems().add(s);
         
             }
             } catch (IOException ex) {
            try {
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
              
            }
             }
        }
        
        
        else if(userSelected.getSelectionModel().getSelectedItem().equals("Faculty")){
            
            File f = null;
            FileInputStream fis = null;      
            ObjectInputStream ois = null;

            try{
            f = new File("FacultyDatabase.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
             Faculty fa;
            
            System.out.println("reached here2");
            
             while(true){
                    System.out.println("checking objects.");
                    fa = (Faculty) ois.readObject();
                    System.out.println("reached here3");
                   // s.display();
                    userTable.getItems().add(fa);
         
             }
            
        } catch (IOException ex) {
            try {
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
              
            }
        
        } 
        
    }
     else if(userSelected.getSelectionModel().getSelectedItem().equals("CITS")){
            
            File f = null;
            FileInputStream fis = null;      
            ObjectInputStream ois = null;

            try{
            f = new File("CITsDatabase.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
             CITS c;
            
            System.out.println("reached here2");
            
             while(true){
                    System.out.println("checking objects.");
                    c = (CITS) ois.readObject();
                    System.out.println("reached here3");
                   // s.display();
                    userTable.getItems().add(c);
         
             }
            
        } catch (IOException ex) {
            try {
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
              
            }
        
        }
     }
        else if(userSelected.getSelectionModel().getSelectedItem().equals("Alumni")){
            
            File f = null;
            FileInputStream fis = null;      
            ObjectInputStream ois = null;

            try{
            f = new File("AlumniDatabase.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
             Alumni a;
            
            System.out.println("reached here2");
            
             while(true){
                    System.out.println("checking objects.");
                    a = (Alumni) ois.readObject();
                    System.out.println("reached here3");
                   // s.display();
                    userTable.getItems().add(a);
         
             }
            
        } catch (IOException ex) {
            try {
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
              
            }
        
        }
        }
        else{
            File f = null;
            FileInputStream fis = null;      
            ObjectInputStream ois = null;

            try{
            f = new File("AdministrationDatabase.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
             AdministrativeStaff as;
            
            System.out.println("reached here2");
            
             while(true){
                    System.out.println("checking objects.");
                    as = (AdministrativeStaff) ois.readObject();
                    System.out.println("reached here3");
                   // s.display();
                    userTable.getItems().add(as);
         
             }
            
        } catch (IOException ex) {
            try {
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
              
            }
        
        }
        }
    }

    @FXML
    private void deleteUserOnClick(ActionEvent event) throws ClassNotFoundException {
      //  ArrayList<UserClass> p = new ArrayList<>(userTable.getSelectionModel().getSelectedItems());
        // ArrayList<UserClass> user = new ArrayList<UserClass>();
         ObservableList<UserClass> selectedRows, allUsers;
         allUsers = userTable.getItems();
         selectedRows = userTable.getSelectionModel().getSelectedItems();
         for(UserClass u : selectedRows){
             allUsers.remove(u);
         }
        if(userSelected.getSelectionModel().getSelectedItem().equals("Student")){
            
            File f = null;
            FileOutputStream fos = null;      
            ObjectOutputStream oos = null;
             
            try {
                    f = new File("StudentDatabase.bin");        
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);   
                    
                    for(UserClass j : allUsers){
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
    
}
      
        

    
    
       /* if(TypeUserBox.getSelectionModel().getSelectedItem().equals("Student")){
           // UserClass.addNewUser();
           
             Parent p = FXMLLoader.load(getClass().getResource("AddNewStudentScene.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
            //stg.setTitle("Dashboard");
            stg.setScene(newScene);
            stg.show();
            
        }
        else if(TypeUserBox.getSelectionModel().getSelectedItem() == "Faculty"){
            Parent p = FXMLLoader.load(getClass().getResource("AddNewFaculty.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
            //stg.setTitle("Dashboard");
            stg.setScene(newScene);
            stg.show();
        }
        else if(TypeUserBox.getSelectionModel().getSelectedItem().equals("Almuni")){
             Parent p = FXMLLoader.load(getClass().getResource("AddnewAlumniScene.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
            //stg.setTitle("Dashboard");
            stg.setScene(newScene);
            stg.show();
        }
        else if(TypeUserBox.getSelectionModel().getSelectedItem().equals("Administrative")){
              Parent p = FXMLLoader.load(getClass().getResource("AddnewAdministrativeScene.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
            //stg.setTitle("Dashboard");
            stg.setScene(newScene);
            stg.show();
        }
        else{
             Parent p = FXMLLoader.load(getClass().getResource("AddnewCITsScene.fxml"));
            Scene newScene = new Scene(p);
            Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
            //stg.setTitle("Dashboard");
            stg.setScene(newScene);
            stg.show();
        }
    }*/
    
    
