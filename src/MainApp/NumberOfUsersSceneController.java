/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author Farha
 */
public class NumberOfUsersSceneController implements Initializable {

    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private BarChart<String,Number> userBarChart;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        series.getData().add(new XYChart.Data<String,Number>("Faculty",0));
        series.getData().add(new XYChart.Data<String,Number>("Student",0));
        series.getData().add(new XYChart.Data<String,Number>("Alumni",0));
        series.getData().add(new XYChart.Data<String,Number>("Administration",0));
        series.getData().add(new XYChart.Data<String,Number>("CITS",0));
        //series.setName("User Information");
        userBarChart.getData().add(series);
    }   
    

    @FXML
    private void existOnclick(ActionEvent event) {
    }

    @FXML
    private void RefreshOnClick(ActionEvent event) {
        int[] y = null;
        CITS c = new CITS();
        y = c.viewTotalUsersReport();
         XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        series.getData().add(new XYChart.Data<String,Number>("Faculty",y[2]));
        series.getData().add(new XYChart.Data<String,Number>("Student",y[1]));
        series.getData().add(new XYChart.Data<String,Number>("Alumni",y[3]));
        series.getData().add(new XYChart.Data<String,Number>("Administration",y[4]));
        series.getData().add(new XYChart.Data<String,Number>("CITS",y[0]));
        series.setName("User Information");
        userBarChart.getData().add(series);
     }
   
    
}
