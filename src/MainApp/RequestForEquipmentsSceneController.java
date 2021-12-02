/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.io.FileNotFoundException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
//import javafx.scene.control.Cell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class RequestForEquipmentsSceneController implements Initializable {

    @FXML
    private TableView<Product> productTable;
    @FXML
    private TextField productname;
    @FXML
    private TextField quantity;
    @FXML
    private TableColumn<Product, SimpleStringProperty> productColumn;
    @FXML
    private TableColumn<Product, SimpleIntegerProperty> quantityColumn;
    private  ArrayList<Product> list = new ArrayList<Product>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("productQuantity"));
    }    

    @FXML
    private void submitrequestOncClick(ActionEvent event) throws FileNotFoundException {
        AdministrativeStaff f = new AdministrativeStaff();
        f.requestForEquipments(list);
    }                          
   



    @FXML
    private void addToTableOnClick(ActionEvent event) {
        Product p = new Product(productname.getText(), Integer.parseInt(quantity.getText()));
            productTable.getItems().add(p);
           list.add(p);
        
    }
}
