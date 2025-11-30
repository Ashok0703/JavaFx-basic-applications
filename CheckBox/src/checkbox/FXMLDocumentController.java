/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package checkbox;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author D E L L
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label count;
    @FXML
    private ListView<?> LISTVIEW;
    @FXML
    private CheckBox c1;
    @FXML
    private CheckBox c2;
    @FXML
    private CheckBox c3;
    @FXML
    private CheckBox c4;
    
    ObservableList list=FXCollections.observableArrayList();
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        LISTVIEW.setItems(list);
    }    

    @FXML
    private void action(ActionEvent event) {
        list.clear();
        int c=0;
        if(c1.isSelected()){
            c++;
            list.add(c1.getText());
            
            
        }
        if(c2.isSelected()){
            c++;
            list.add(c2.getText());
            
        }
        if(c3.isSelected()){
            c++;
            list.add(c3.getText());
            
        }
        if(c4.isSelected()){
            c++;
            list.add(c4.getText());
            
        }
        count.setText(c+"");
    }
    
}
