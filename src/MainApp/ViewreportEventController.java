/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

//import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


public class ViewreportEventController implements Initializable,Serializable {

    @FXML
    private PieChart peichart;
    @FXML
    private Button loadpiechart;
    @FXML
    private Label statusLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadpiechart(ActionEvent event) {
        ObservableList <PieChart.Data> list = FXCollections.observableArrayList();
       AdministrativeStaff as = new AdministrativeStaff();
        list = as.viewReportOfEvent();
        peichart.setData(list);
        for(PieChart.Data data: peichart.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    statusLabel.setText(String.valueOf(data.getPieValue())+"Students");
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
                
                    
            
    
                );
                
                    
        }
    
    }



  
                    
    @FXML
    private void moveToPreviousScene(ActionEvent event) {

    }
    
}

   

