/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package booklibrary;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author D E L L
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML
    private TextField tfid;
    @FXML
    private TextField tftitle;
    @FXML
    private TextField tfauthor;
    @FXML
    private TextField tfpageno;
    @FXML
    private TableView<Book> tv;
    @FXML
    private TableColumn<Book, Integer> colid;
    @FXML
    private TableColumn<Book, String> coltitle;
    @FXML
    private TableColumn<Book, String> colauthor;
    @FXML
    private TableColumn<Book, Integer> colpageno;
    @FXML
    private Button btninsert;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()==btninsert){
            insertRecord();
        }
        if(event.getSource()==btnupdate){
            updateRecord();
        }
        if(event.getSource()==btndelete){
            deleteRecord();
        }
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showBooks();
    }    
    public Connection getConnection(){
        Connection conn;
        try{
            conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/javafxdatabase","postgres","postgresql");
            return conn;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
        
    }
    public ObservableList<Book> getBookList(){
        ObservableList<Book> booklist = FXCollections.observableArrayList();
        Connection conn=getConnection();
        Statement st;
        ResultSet rs;
        try{
            st=conn.createStatement();
            rs=st.executeQuery("select * from book_library");
            while(rs.next()){
                Book book=new Book(rs.getInt("id"),rs.getString("title"),rs.getString("author"),rs.getInt("pageno"));
                booklist.add(book);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return booklist;
    }
    public void showBooks(){
        ObservableList<Book> list=getBookList();
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        coltitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colauthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colpageno.setCellValueFactory(new PropertyValueFactory<>("pageno"));
        tv.setItems(list);
    }
    public void insertRecord(){
        String qry="INSERT INTO book_library(title,author,pageno) values ('"+tftitle.getText()+"','"+tfauthor.getText()+"',"+tfpageno.getText()+")";
        executeQuery(qry);
        tftitle.clear();
        tfauthor.clear();
        tfpageno.clear();
        tfid.clear();
        showBooks();
    }
    public void updateRecord(){
        String qry="UPDATE book_library SET title='"+tftitle.getText()+"',author='"+tfauthor.getText()+"',pageno="+tfpageno.getText()+" WHERE id="+tfid.getText()+";";
        executeQuery(qry);
        tftitle.clear();
        tfauthor.clear();
        tfpageno.clear();
        tfid.clear();
        showBooks();
    }

    private void executeQuery(String qry) {
        Connection conn=getConnection();
        Statement st;
        try{
            st=conn.createStatement();
            st.executeUpdate(qry);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void deleteRecord() {
        String qry="DELETE FROM book_library WHERE id="+tfid.getText()+"";
        executeQuery(qry);
        tftitle.clear();
        tfauthor.clear();
        tfpageno.clear();
        tfid.clear();
        showBooks();
    }

    @FXML
    private void rowClicked(MouseEvent event) {
       Book bookdata=tv.getSelectionModel().getSelectedItem();
       tfid.setText(String.valueOf(bookdata.getId()));
       tftitle.setText(bookdata.getTitle());
       tfauthor.setText(bookdata.getAuthor());
       tfpageno.setText(String.valueOf(bookdata.getPageno()));
    }
    
}
