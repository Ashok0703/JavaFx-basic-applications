package application;

public class Model {
	public float calculate(long num1,long num2,String op) {
		switch(op) {
		case "+":
			return (float)num1+num2;
			
		case "-":
			return (float)num1-num2;
			
		case "/":
			return (float)num1/num2;
		case "*":
			return (float)num1*num2;
		default:
			break;
			
		}
		
		return 0;
	}
}
