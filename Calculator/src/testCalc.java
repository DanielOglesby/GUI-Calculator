import javax.swing.JFrame;
import javax.swing.UIManager;

import java.awt.*;

public class testCalc {
	
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}catch(Exception e) {
			
		}
		Calc calculator = new Calc();
		calculator.setTitle("Learning GUI");
		//calculator.setBounds(500, 100, 450, 300);
		calculator.setSize(600, 800);
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.setVisible(true);
		calculator.setResizable(true);
		
	}
		
}
