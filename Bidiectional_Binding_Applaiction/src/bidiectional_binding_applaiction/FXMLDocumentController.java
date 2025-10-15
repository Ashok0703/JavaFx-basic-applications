/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package bidiectional_binding_applaiction;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import javafx.beans.property.Property;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 *
 * @author D E L L
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Slider slider;
    @FXML
    private TextField txtfield;
     private static final double VAL=30;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        slider.setValue(VAL);
        txtfield.setText(new Double(VAL).toString());
        txtfield.textProperty().bindBidirectional(slider.valueProperty(),NumberFormat.getNumberInstance());
    }    
    
}
