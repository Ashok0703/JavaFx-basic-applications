package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
	@FXML
	private Label mylabel;
	public void generateRandom(ActionEvent e) {
		Random r=new Random();
		int random=r.nextInt(10)+1;
		mylabel.setText(Integer.toString(random));
	}
}
