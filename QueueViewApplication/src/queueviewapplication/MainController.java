/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package queueviewapplication;

import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author D E L L
 */
public class MainController implements Initializable {

    @FXML
    private ListView<String> view;

    /**
     * Initializes the controller class.
     * 
     */
    Queue<String> queue=new LinkedList<>();
    ObservableList<String> list=FXCollections.observableArrayList();
    @FXML
    private TextField element;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        view.setItems(list);
    }    

    @FXML
    private void enqueueelement(ActionEvent event) {
        String ip=element.getText();
        if(!ip.trim().isEmpty()){
            queue.offer(ip);
            refreshList();
            element.clear();
        }
        else{
            showMsg("PLease Enter the Element!");
        }
    }

    @FXML
    private void dequeueelement(ActionEvent event) {
        if(!queue.isEmpty()){
            String r=queue.remove();
            refreshList();
            showMsg("Removed Element: "+r);
        }else{
            showMsg("Queue Is Empty!!");
        }
    }


    @FXML
    private void peekelement(ActionEvent event) {
        if(!queue.isEmpty()){
            String front=queue.peek();
            showMsg("Head Element: "+front);
        }else{
            showMsg("Queue Is Empty!!");
        }
    }
    public void showMsg(String s){
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();
        
    }
    public void refreshList(){
        list.setAll(queue);
        FXCollections.reverse(list);
    }
    
}
