package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class Controller {
	@FXML
	private Circle mycircle;

	@FXML
	private void up() {
	    mycircle.setCenterY(mycircle.getCenterY() - 10);
	}

	@FXML
	private void down() {
	    mycircle.setCenterY(mycircle.getCenterY() + 10);
	}

	@FXML
	private void left() {
	    mycircle.setCenterX(mycircle.getCenterX() - 10);
	}

	@FXML
	private void right() {
	    mycircle.setCenterX(mycircle.getCenterX() + 10);
	}

}
