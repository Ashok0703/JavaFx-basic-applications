/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package stackview;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author D E L L
 */
public class ViewController implements Initializable {

    @FXML
    private ListView<String> view;
    @FXML
    private TextField ip;
    @FXML
    private Button push;
    @FXML
    private Button pop;

    /**
     * Initializes the controller class.
     */
    Stack<String> stack=new Stack<>();
    ObservableList<String> list=FXCollections.observableArrayList();

    /**
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        view.setItems(list);
    }    

    @FXML
    private void pushitem(ActionEvent event) {
        String input=ip.getText();
        if(!input.trim().isEmpty()){
            String pushed=stack.push(input);
          
            refreshList();
            ip.clear();
        }
        else{
            showMsg("Please Enter the Stack Element");
        }
    }

    @FXML
    private void popitem(ActionEvent event) {
        if(!stack.isEmpty()){
            String poped=stack.pop();
            showMsg("Poped element : "+poped);
            refreshList();
        }
        else{
            showMsg("Stack is Empty");
        }
    }
   public  void  refreshList(){
        list.setAll(stack);
        FXCollections.reverse(list);
        
    }
   public  void  showMsg(String s){
       Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
           alert.setHeaderText(null);
           alert.setContentText(s);
           alert.showAndWait();
       
   }
    
}
