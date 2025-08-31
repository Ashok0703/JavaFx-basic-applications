package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
	@FXML
	private Label txtresult;
	@FXML
	private TextField txtuser;
	@FXML
	private TextField txtpass;
	@FXML
	public void login(ActionEvent e) throws Exception {
		if(txtuser.getText().equals("user") && txtpass.getText().equals("pass")) {
			txtresult.setText("Login SuccessFul");
			Stage primaryStage=new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("loginsuccessPage.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		else {
			txtresult.setText("Username or Password wrong");
		}
	}
}
