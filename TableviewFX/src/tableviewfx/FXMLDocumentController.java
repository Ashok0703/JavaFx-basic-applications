/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package tableviewfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author D E L L
 */
public class FXMLDocumentController implements Initializable {
    
  
    @FXML
    private TableView<Employee> tableview;
    @FXML
    private TableColumn<Employee, Integer> colid;
    @FXML
    private TableColumn<Employee, String> colfname;
    @FXML
    private TableColumn<Employee, String> collname;
    @FXML
    private TableColumn<Employee, Integer> colage;
    
    private ObservableList<Employee> list=FXCollections.observableArrayList(
            new Employee(101,"Joseph","Shen",20),
            new Employee(102,"Jon","Sceno",20),
            new Employee(103,"Sugil","Kar",20)
    );
    @FXML
    private Label empname;
            
    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colfname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        collname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        colage.setCellValueFactory(new PropertyValueFactory<>("age"));
        tableview.setPlaceholder(new Label("No mployees Found"));
        tableview.setItems(list);
    }    

    @FXML
    private void mouseClicked(MouseEvent event) {
        if(event.getClickCount()>1){
            showEmployee();
        }
    }

    @FXML
    private void addemployee(ActionEvent event) {
        tableview.getItems().add(new Employee(201,"Arumugam","Balu",49));
    }

    private void showEmployee() {
        if(tableview.getSelectionModel().getSelectedItem()!=null){
            Employee emp=tableview.getSelectionModel().getSelectedItem();
            empname.setText(emp.getFirstname()+" "+emp.getLastname());
        }
    }
    
}
