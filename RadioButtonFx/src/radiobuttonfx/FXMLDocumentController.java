/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package radiobuttonfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author D E L L
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label gender;
    @FXML
    private RadioButton g1;
    @FXML
    private ToggleGroup buttongroup;
    @FXML
    private RadioButton g2;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void selectedgenter(ActionEvent event) {
        if(g1.isSelected()){
            gender.setText(g1.getText());
        }
        if(g2.isSelected()){
            gender.setText(g2.getText());
        }
    }
    
}
