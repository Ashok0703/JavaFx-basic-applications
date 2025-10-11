/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package counter.using.fxproperties;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author D E L L
 */
public class ViewController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button increase;
    @FXML
    private Button decrease;

    private IntegerProperty count=new SimpleIntegerProperty(0);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        label.textProperty().bind(Bindings.concat("Count : ",count.asString()));
    }    

    @FXML
    private void increment(ActionEvent event) {
        count.set(count.get()+1);
    }

    @FXML
    private void decrement(ActionEvent event) {
        count.set(count.get()-1);
    }
    
}
