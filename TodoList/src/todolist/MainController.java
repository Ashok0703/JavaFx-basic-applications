/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package todolist;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author D E L L
 */
public class MainController implements Initializable {

    @FXML
    private ListView<String> tasklist;
    @FXML
    private TextField label;
    @FXML
    private ComboBox<String> category;
    @FXML
    private Button add;
    @FXML
    private Button rmv;

    /**
     * Initializes the controller class.
     */
    ObservableList<String> c=FXCollections.observableArrayList("Work","School","Home");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        category.setItems(c);
        category.setEditable(false);

    }    

    @FXML
    private void addTask(ActionEvent event) {
        String t=label.getText();
        String ctg=category.getValue();
        if(!t.isEmpty()&& ctg!=null){
            tasklist.getItems().add(t+"["+ctg+"]");
            label.clear();
            category.getSelectionModel().clearSelection();
            category.setValue(null);
        }
        else{
            Alert alert=new Alert(Alert.AlertType.WARNING,"Enter a task and category");
            alert.showAndWait();
        }
    }

    @FXML
    private void removeTask(ActionEvent event) {
        String removingtask=tasklist.getSelectionModel().getSelectedItem();
        if(removingtask!=null){
            tasklist.getItems().remove(removingtask);
            
        }else{
            Alert alert=new Alert(Alert.AlertType.WARNING,"Select the task to remove!");
            alert.showAndWait();
        }
    }
    
}
