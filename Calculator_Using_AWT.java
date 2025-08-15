package BasicJavaApplications.AWT_Applications.Calculator;
import java.awt.*;
import javax.script.*;
import java.awt.event.*;
class Calculator extends Frame implements ActionListener{
	TextField display;
	Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,clr,plus,minus,div,mul,eqls;
	Calculator(){
		setLayout(null);
		setVisible(true);
		setSize(500,350);
		display=new TextField("0");
		display.setBounds(50, 50, 400, 50);
	
		add(display);
		plus=new Button("+");
		plus.setBounds(50, 250, 100, 50);
		plus.addActionListener(this);
		add(plus);
		minus=new Button("-");
		minus.setBounds(150, 250, 100, 50);
		minus.addActionListener(this);
		add(minus);
		mul=new Button("*");
		mul.setBounds(250, 250, 100, 50);
		mul.addActionListener(this);
		add(mul);
		div=new Button("/");
		div.setBounds(350, 250, 100, 50);
		div.addActionListener(this);
		add(div);
		clr=new Button("C");
		clr.setBounds(250, 200, 100, 50);
		clr.addActionListener(this);
		add(clr);
		eqls=new Button("=");
		eqls.setBounds(350, 200, 100, 50);
		eqls.addActionListener(this);
		add(eqls);
		b1=new Button("1");
		b1.setBounds(50, 200, 100, 50);
		b1.addActionListener(this);
		add(b1);
		b0=new Button("0");
		b0.setBounds(150, 200, 100, 50);
		b0.addActionListener(this);
		add(b0);
		b2=new Button("2");
		b2.setBounds(50, 150, 100, 50);
		b2.addActionListener(this);
		add(b2);
		b3=new Button("3");
		b3.setBounds(150, 150, 100, 50);
		b3.addActionListener(this);
		add(b3);
		b4=new Button("4");
		b4.setBounds(250, 150, 100, 50);
		b4.addActionListener(this);
		add(b4);
		b5=new Button("5");
		b5.setBounds(350, 150, 100, 50);
		b5.addActionListener(this);
		add(b5);
		b6=new Button("6");
		b6.setBounds(50, 100, 100, 50);
		b6.addActionListener(this);
		add(b6);
		b7=new Button("7");
		b7.setBounds(150, 100, 100, 50);
		b7.addActionListener(this);
		add(b7);
		b8=new Button("8");
		b8.setBounds(250, 100, 100, 50);
		b8.addActionListener(this);
		add(b8);
		b9=new Button("9");
		b9.setBounds(350, 100, 100, 50);
		b9.addActionListener(this);
		add(b9);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b0) {
			display.setText(display.getText()+"0");
		}
		if(e.getSource()==b1) {
			display.setText(display.getText()+"1");
		}
		if(e.getSource()==b2) {
			display.setText(display.getText()+"2");
		}
		if(e.getSource()==b3) {
			display.setText(display.getText()+"3");
		}
		if(e.getSource()==b4) {
			display.setText(display.getText()+"4");
		}
		if(e.getSource()==b5) {
			display.setText(display.getText()+"5");
		}
		if(e.getSource()==b6) {
			display.setText(display.getText()+"6");
		}
		if(e.getSource()==b7) {
			display.setText(display.getText()+"7");
		}
		if(e.getSource()==b8) {
			display.setText(display.getText()+"8");
		}
		if(e.getSource()==b9) {
			display.setText(display.getText()+"9");
		}
		if(e.getSource()==plus) {
			display.setText(display.getText()+"+");
		}
		if(e.getSource()==minus) {
			display.setText(display.getText()+"-");
		}
		if(e.getSource()==mul) {
			display.setText(display.getText()+"*");
		}
		if(e.getSource()==div) {
			display.setText(display.getText()+"/");
		}
		if(e.getSource()==clr) {
			display.setText("0");
		}
		if (e.getSource() == eqls) {
		    try {
		        String exp = display.getText().trim();

		        // Find the operator position
		        int opPos = -1;
		        char operator = ' ';
		        for (char op : new char[]{'+', '-', '*', '/'}) {
		            opPos = exp.indexOf(op);
		            if (opPos != -1) {
		                operator = op;
		                break;
		            }
		        }

		        if (opPos == -1) {
		            display.setText("Error"); // No operator found
		            return;
		        }

		        // Split operands
		        double num1 = Double.parseDouble(exp.substring(0, opPos));
		        double num2 = Double.parseDouble(exp.substring(opPos + 1));

		        double result = 0;
		        switch (operator) {
		            case '+': result = num1 + num2; break;
		            case '-': result = num1 - num2; break;
		            case '*': result = num1 * num2; break;
		            case '/':
		                if (num2 == 0) {
		                    display.setText("Error");
		                    return;
		                }
		                result = num1 / num2;
		                break;
		        }

		        display.setText(String.valueOf(result));

		    } catch (Exception ex) {
		        display.setText("Error");
		    }
		}

	}
	
}
public class Calculator_Using_AWT {
	public static void main(String args[]) {
		Calculator c=new Calculator();
	}
}
