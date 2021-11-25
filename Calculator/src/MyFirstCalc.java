import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyFirstCalc extends JFrame implements ActionListener{
	JLabel label1, label2, label3, label4;
	JTextField num1Field, num2Field;
	JButton addButton, multButton;
	JPanel panel;
	public MyFirstCalc() {
		label1 = new JLabel("Number 1: ");
		label2 = new JLabel("Number 2: ");
		label3 = new JLabel("Result: ");
		label4 = new JLabel();
		addButton = new JButton("+");
		multButton = new JButton("*");
		num1Field = new JTextField(10);
		num2Field = new JTextField(10);
		panel = new JPanel();
		
		panel.add(label1);
		panel.add(num1Field);
		panel.add(label2);
		panel.add(num2Field);
		panel.add(addButton);
		panel.add(multButton);
		panel.add(label3);
		panel.add(label4);
		
		add(panel, BorderLayout.NORTH);
		
		addButton.addActionListener(this);
		multButton.addActionListener(this);
	}
	
		public void actionPerformed(ActionEvent e) {
			int num1, num2;
			num1 = Integer.parseInt(num1Field.getText());
			num2 = Integer.parseInt(num2Field.getText());
			
			if(e.getSource() == addButton) {
				label4.setText("" + (num1 + num2));
			}
			else if (e.getSource() == addButton) {
				label4.setText("" + (num1 + num2));
			}
				
	}
		
}