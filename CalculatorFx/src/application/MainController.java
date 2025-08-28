package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class MainController {
	@FXML
	//private String value;
	private Label result;
	private String operator="";
	private boolean start=true;
	private Model model=new Model();
	long num1,num2;
	@FXML
	public void processNumbers(ActionEvent e) {
		if (start) {
			start=false;
			result.setText("");
		}
		String value=((Button)e.getSource()).getText();
		result.setText(result.getText()+value);
		
	}
	@FXML
public void processOperators(ActionEvent e) {
		String value=((Button)e.getSource()).getText();
		if(!value.equals("=")) {
			if(operator.isEmpty()) {
				operator=value;
				num1=Long.parseLong(result.getText());
				result.setText("");
			}
			
		}
		else {
			if(!operator.isEmpty() && !result.getText().isBlank()) {
				num2=Long.parseLong(result.getText());
			}
			result.setText(String.valueOf(model.calculate(num1, num2, operator)));
			start=true;
			operator="";
		}
	}
}
