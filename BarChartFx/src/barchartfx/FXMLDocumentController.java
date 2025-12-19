/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package barchartfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

/**
 *
 * @author D E L L
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private BarChart<String, Integer> bargraph;
    @FXML
    private NumberAxis no_devices;
    @FXML
    private CategoryAxis category;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        XYChart.Series<String,Integer> series=new XYChart.Series();
        series.setName("Apple");
        series.getData().addAll(
                new XYChart.Data<>("Desktop",140),
                new XYChart.Data<>("Tab",51),
                new XYChart.Data<>("Mobile",30)
        );
         XYChart.Series<String,Integer> series1=new XYChart.Series();
        series1.setName("Windows");
        series1.getData().addAll(
                new XYChart.Data<>("Desktop",120),
                new XYChart.Data<>("Tab",40),
                new XYChart.Data<>("Mobile",50),
                new XYChart.Data<>("laptop",30)
        );
        bargraph.getData().addAll(series,series1);
    }    
    
}
