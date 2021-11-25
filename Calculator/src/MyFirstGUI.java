import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyFirstGUI extends JFrame implements ActionListener {
	JButton xButton, yButton;
	JLabel label1;
	
	public MyFirstGUI() {
		xButton = new JButton("X");
		yButton = new JButton("Y");
		label1 = new JLabel("Leave me alone!!!");
		add(xButton, BorderLayout.WEST);
		add(yButton, BorderLayout.CENTER);
		add(label1, BorderLayout.EAST);
		
		xButton.addActionListener(this);
		yButton.addActionListener(this);
		
	}
	
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == xButton) {
				label1.setText(("xButton"));
			}
			if (e.getSource() == yButton) {
				label1.setText(("yButton"));
						
		}
		
	}
}
