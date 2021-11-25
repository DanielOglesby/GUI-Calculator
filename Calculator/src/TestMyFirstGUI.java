import javax.swing.JFrame;

public class TestMyFirstGUI {
	public static void main(String[] args) {
		MyFirstGUI window = new MyFirstGUI();
		MyFirstCalc window2 = new MyFirstCalc();
		window2.setTitle("Learning GUI");
		window2.setSize(600, 600);
		window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window2.setVisible(true);
		window2.setResizable(true);

	}
}
