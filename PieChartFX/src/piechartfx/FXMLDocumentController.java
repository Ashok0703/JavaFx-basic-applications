/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package piechartfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author D E L L
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private PieChart deptstudents;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showpiechart(ActionEvent event) {
        ObservableList<Data> list=FXCollections.observableArrayList(
        new PieChart.Data("IT", 180),
        new PieChart.Data("CSE", 250),
        new PieChart.Data("ECE", 160),
        new PieChart.Data("EEE", 100)
        
    );
        deptstudents.setData(list);
    for(final PieChart.Data data:deptstudents.getData()){
        data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                double res= (data.getPieValue()/690)*100;
                label.setText(data.getName()+" "+res);
            }
            
        });
    }
    }
    
}
