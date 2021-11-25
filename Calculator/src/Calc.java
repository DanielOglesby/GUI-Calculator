import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Calc extends JFrame implements ActionListener, MouseListener {
	JPanel myPanel; //initialize elements... JButtons, JLabels, JTextPanes, etc
	JLabel myLabel;
	JTextField textField;
	JButton button0, button1, button2, button3, button4, button5, button6, button7,
	button8, button9, buttonDiv, buttonMult, buttonSub, buttonAdd, buttonEquals, buttonMod,
	buttonRightBracket, buttonLeftBracket, buttonC, buttonCE, buttonBackspace, buttonSize;
	JTextPane pane1, paneDecimal, paneHex, paneOctal, paneBinary, paneTop;
	
	public Calc() {
		
		//initialize all elements
		//didn't use WindowBuilder for this
		myPanel = new JPanel(new GridBagLayout());
		textField = new JTextField();
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = gc.BOTH;
		gc.weightx = 1;
		gc.fill = gc.BOTH;
		gc.weighty = 0;
		Font f = new Font(Font.SANS_SERIF, 10, 20);
		paneTop = new JTextPane();
		pane1 = new JTextPane();
		pane1.setFont(f);
		//////////// first column ///////////////
		button0 = new JButton("0");
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		/////////// second column //////////////
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		////////// third column ////////////////
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");
		///////// fourth column ///////////////
		buttonDiv = new JButton("/");
		buttonMult = new JButton("X");
		buttonSub = new JButton("-");
		buttonAdd = new JButton("+");
		buttonMod = new JButton("%");
		buttonEquals = new JButton("=");
		buttonRightBracket = new JButton(")");
		buttonLeftBracket = new JButton("(");
		paneDecimal = new JTextPane();
		paneHex = new JTextPane();
		paneOctal = new JTextPane();
		paneBinary = new JTextPane();
		buttonC = new JButton("C");
		buttonCE = new JButton("CE");
		buttonBackspace = new JButton("Back");
		buttonSize = new JButton("Word");
		
		gc.fill = GridBagConstraints.HORIZONTAL;
		//make all panes uneditable
		pane1.setEditable(false);
		paneDecimal.setEditable(false);
		paneHex.setEditable(false);
		paneOctal.setEditable(false);
		paneBinary.setEditable(false);
		myPanel.add(pane1); // this is the main pane where numerical operations go
		//////////// first column ///////////////
		gc.gridx = 1; //use gridx & gridy values to organize elements in panel
		gc.gridy = 2;
		myPanel.add(buttonSize, gc);
		gc.gridy = 3;
		myPanel.add(button7, gc);
		gc.gridy = 4;
		myPanel.add(button4, gc);
		gc.gridy = 5;
		myPanel.add(button1, gc);
		//////////// second column ///////////////
		gc.gridx = 2;
		gc.gridy = 2;
		myPanel.add(buttonC, gc);
		gc.gridy = 3;
		myPanel.add(button8, gc);
		gc.gridy = 4;
		myPanel.add(button5, gc);
		gc.gridy = 5;
		myPanel.add(button2, gc);
		gc.gridy = 6;
		myPanel.add(button0, gc);
		/////////// third column //////////////
		gc.gridx = 3;
		gc.gridy = 2;
		myPanel.add(buttonCE, gc);
		gc.gridy = 3;
		myPanel.add(button9, gc);
		gc.gridy = 4;
		myPanel.add(button6, gc);
		gc.gridy = 5;
		myPanel.add(button3, gc);
		gc.gridy = 6;
		////////// fourth column ////////////////
		gc.gridx = 4;
		gc.gridy = 2;
		myPanel.add(buttonBackspace, gc);
		gc.gridy = 3;
		myPanel.add(buttonDiv, gc);
		gc.gridy = 4;
		myPanel.add(buttonMult, gc);
		gc.gridy = 5;
		myPanel.add(buttonSub, gc);
		gc.gridy = 6;
		myPanel.add(buttonAdd, gc);
		gc.gridy = 7;
		myPanel.add(buttonMod, gc);
		gc.gridy = 8;
		myPanel.add(buttonEquals, gc);
		//////////// left side ///////////////
		gc.gridx = 1;
		gc.gridy = 7;
		myPanel.add(buttonRightBracket, gc);
		gc.gridy = 8;
		myPanel.add(buttonLeftBracket, gc);
		////////////conversions ///////////////
		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.WEST;
		myPanel.add(paneHex, gc);
		gc.gridy = 4;
		myPanel.add(paneDecimal, gc);
		gc.gridy = 5;
		myPanel.add(paneOctal, gc);
		gc.gridy = 6;
		myPanel.add(paneBinary, gc);
		
		add(myPanel, BorderLayout.CENTER);
		
		//add action and mouse listeners for each button on the panel, so that we can do operations with them later
		button0.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		buttonDiv.addActionListener(this);
		buttonMult.addActionListener(this);
		buttonSub.addActionListener(this);
		buttonAdd.addActionListener(this);
		buttonEquals.addActionListener(this);
		buttonRightBracket.addActionListener(this);
		buttonLeftBracket.addActionListener(this);
		buttonC.addActionListener(this);
		buttonCE.addActionListener(this);
		buttonBackspace.addActionListener(this);
		buttonSize.addActionListener(this);
		buttonMod.addActionListener(this);
		button0.addMouseListener(this);
		button1.addMouseListener(this);
		button2.addMouseListener(this);
		button3.addMouseListener(this);
		button4.addMouseListener(this);
		button5.addMouseListener(this);
		button6.addMouseListener(this);
		button7.addMouseListener(this);
		button8.addMouseListener(this);
		button9.addMouseListener(this);
		buttonDiv.addMouseListener(this);
		buttonMult.addMouseListener(this);
		buttonSub.addMouseListener(this);
		buttonAdd.addMouseListener(this);
		buttonEquals.addMouseListener(this);
		buttonRightBracket.addMouseListener(this);
		buttonLeftBracket.addMouseListener(this);	
		buttonC.addMouseListener(this);
		buttonCE.addMouseListener(this);
		buttonBackspace.addMouseListener(this);
		buttonSize.addMouseListener(this);
		buttonMod.addMouseListener(this);
		
				
	}
	
	
	public void actionPerformed(ActionEvent e) {
}
	//use mousePressed & mouseListener to give buttons functionality
	public void mousePressed (MouseEvent e) {
		if(e.getSource() == button0)
			pane1.setText(pane1.getText() + "0");
		if(e.getSource() == button1)
			pane1.setText(pane1.getText()+"1");
		if(e.getSource() == button2)
			pane1.setText(pane1.getText()+"2");
		if(e.getSource() == button3)
			pane1.setText(pane1.getText()+"3");
		if(e.getSource() == button4)
			pane1.setText(pane1.getText()+"4");
		if(e.getSource() == button5)
			pane1.setText(pane1.getText()+"5");
		if(e.getSource() == button6)
			pane1.setText(pane1.getText()+"6");
		if(e.getSource() == button7)
			pane1.setText(pane1.getText()+"7");
		if(e.getSource() == button8)
			pane1.setText(pane1.getText()+"8");
		if(e.getSource() == button9)
			pane1.setText(pane1.getText()+"9");
		if(e.getSource() == buttonDiv)
			pane1.setText(pane1.getText()+"/");
		if(e.getSource() == buttonMult)
			pane1.setText(pane1.getText()+"*");
		if(e.getSource() == buttonSub)
			pane1.setText(pane1.getText()+"-");
		if(e.getSource() == buttonAdd)
			pane1.setText(pane1.getText()+"+");
		if(e.getSource() == buttonMod)
			pane1.setText(pane1.getText()+'%');
		if(e.getSource() == buttonRightBracket)
			pane1.setText(pane1.getText()+")");
		if(e.getSource() == buttonLeftBracket)
			pane1.setText(pane1.getText()+"(");
		if(e.getSource() == buttonC)
			pane1.setText("");
		if(e.getSource() == buttonCE) 
			pane1.setText("");
		if(e.getSource() == buttonSize) { 
			int count = 0;
			if(buttonSize.getText() == "Word") { //if set to word, change to QWord
				buttonSize.setText("QWord");				
			}
			else if(buttonSize.getText() == "QWord") { //if set to QWord, change to DWord
				buttonSize.setText("DWord");
			}
			else if(buttonSize.getText() == "DWord") { //if set to DWord, change to Byte
				buttonSize.setText("Byte");
			}
			else 									//else change back to Word
				buttonSize.setText("Word");
			
			
		}
		if(e.getSource() == buttonBackspace) { //when backspace button is pressed, delete last character in pane1
			String initial = pane1.getText();
			char[] arr = initial.toCharArray();
			char[] arr2 = new char[arr.length-1];
			
			for(int i = 0; i < arr.length-1; i++) {
				arr2[i] = arr[i];
			}
			
			String out = "";
			
			for(int i = 0; i < arr2.length; i++) {
				out += arr2[i];
			}
			pane1.setText(out);
		}
		if(e.getSource() == buttonEquals) { //when equals button is pressed, do these operations
			char[] arr = pane1.getText().toCharArray();
			String expression = pane1.getText(); //get expression from current main pane text
			int evaluated = evaluateExpression(expression); //evaluate the expression using evaluateExpression function below
			String text = Integer.toString(evaluated); //make the evaluated expression back into a string
			pane1.setText(text); //display string on main pane
			//...simultaneously
			//hex, bin, oct conversions
			String bin = dec2Bin(evaluated);
			paneBinary.setText("BIN = " + bin);
			String hex = dec2Hex(evaluated);
			paneHex.setText("HEX = " + hex);
			String oct = toOctal(evaluated);
			paneOctal.setText("OCT = " + oct);
			paneDecimal.setText("DEC = " + text);
			
		}
	}
	public void mouseEntered (MouseEvent e) {
		
	}
	public void mouseExited (MouseEvent e) {
		
	}
	public void mouseReleased (MouseEvent e) {

	}
	public void mouseClicked (MouseEvent e) {
		
	}
	
	public static int evaluateExpression(String expression) {
		// Create operandStack to store operands
		Stack<Integer> operandStack = new Stack<>();

		// Create operatorStack to store operators
		Stack<Character> operatorStack = new Stack<>();

		// Insert blanks around (, ), +, -, /, and *
		expression = insertBlanks(expression);

		// Extract operands and operators
		String[] tokens = expression.split(" ");

		// Phase 1: Scan tokens
		for (String token: tokens) {
		if (token.length() == 0) // Blank space
		continue; // Back to the while loop to extract the next token
		else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
		// Process all +, -, *, /,%,^ in the top of the operator stack
		while (!operatorStack.isEmpty() &&
		(operatorStack.peek() == '+' ||
		operatorStack.peek() == '-' ||
		operatorStack.peek() == '*' ||
		operatorStack.peek() == '/'||operatorStack.peek()=='^'||
		operatorStack.peek()=='%')) {
		processAnOperator(operandStack, operatorStack);
		}

		// Push the + or - operator into the operator stack
		operatorStack.push(token.charAt(0));
		}
		else if (token.charAt(0) =='^') {
		  

		// Push the ^ operator into the operator stack
		operatorStack.push(token.charAt(0));
		}
		else if (token.charAt(0) == '*' || token.charAt(0) == '/'||token.charAt(0)=='%') {
		// Process all *, /,% in the top of the operator stack
		while (!operatorStack.isEmpty() &&
		(operatorStack.peek() == '*' ||
		operatorStack.peek() == '/'||
		operatorStack.peek()=='%'||operatorStack.peek()=='^')) {
		processAnOperator(operandStack, operatorStack);
		}

		// Push the * or /,% operator into the operator stack
		operatorStack.push(token.charAt(0));
		}
		else if (token.trim().charAt(0) == '(') {
		operatorStack.push('('); // Push '(' to stack
		}
		else if (token.trim().charAt(0) == ')') {
		// Process all the operators in the stack until seeing '('
		while (operatorStack.peek() != '(') {
		processAnOperator(operandStack, operatorStack);
		}

		operatorStack.pop(); // Pop the '(' symbol from the stack
		}
		else { // An operand scanned
		// Push an operand to the stack
		operandStack.push(new Integer(token));
		}
		}

		// Phase 2: process all the remaining operators in the stack
		while (!operatorStack.isEmpty()) {
		processAnOperator(operandStack, operatorStack);
		}

		// Return the result
		return operandStack.pop();
		}

		/** Process one operator: Take an operator from operatorStack and
		* apply it on the operands in the operandStack */
		public static void processAnOperator(
		Stack<Integer> operandStack, Stack<Character> operatorStack) {
		char op = operatorStack.pop();
		int op1 = operandStack.pop();
		int op2 = operandStack.pop();
		if (op == '+')
		operandStack.push(op2 + op1);
		else if (op == '-')
		operandStack.push(op2 - op1);
		else if (op == '*')
		operandStack.push(op2 * op1);
		else if (op == '/')
		operandStack.push(op2 / op1);
		else if(op=='%')
		operandStack.push(op2%op1);
		else if(op=='^'){
		operandStack.push((int)Math.pow((double)op2,(double)op1));}
		}

		public static String insertBlanks(String s) {
		String result = "";

		for (int i = 0; i < s.length(); i++) {
		if (s.charAt(i) == '(' || s.charAt(i) == ')' ||
		s.charAt(i) == '+' || s.charAt(i) == '-' ||
		s.charAt(i) == '*' || s.charAt(i) == '/'
		||s.charAt(i)=='%' || s.charAt(i)=='^')
		result += " " + s.charAt(i) + " ";
		else
		result += s.charAt(i);
		}

		return result;
		}


	  
	  //below are the conversion functions used to find hex, octal, binary
		public static String dec2Bin(int value) {
			 int binary;
			if (value == 0)
			      binary = 0;
			   else
			      binary = value % 2 + 10 * ( Integer.parseInt(dec2Bin(value / 2)) );
			
			return Integer.toString(binary);
		}
		
		public static String dec2Hex(int value)
		{
			String result = "";
	        int n = value;
	        int remainder = n % 16;

	        if (n == 0) {
	            return "";
	        } else {
	            switch (remainder) {
	                case 10:
	                    result = "A";
	                    break;
	                case 11:
	                    result = "B";
	                    break;
	                case 12:
	                    result = "C";
	                    break;
	                case 13:
	                    result = "D";
	                    break;
	                case 14:
	                    result = "E";
	                    break;
	                case 15:
	                    result = "F";
	                    break;
	                default:
	                    result = remainder + result;
	                    break;
	            }
	            return dec2Hex(n / 16) + result;
	        }
	}
		
		public static int hex2Dec(String hexString) {
			int decimal = 0;
			String hexCode = "0123456789ABCDEF";
			hexString = hexString.toUpperCase();
			int length = hexString.length();
			if (length > 0) {
				char ch = hexString.charAt(0);
				int digit = hexCode.indexOf(ch);
				String substring = hexString.substring(1);
				decimal = digit * (int) Math.pow(16, length - 1) + hex2Dec(substring);
			}
			return decimal;
		}
		
		public static int bin2Dec(String binaryString) {
			int len = binaryString.length();
		    if (len == 0) return 0;
		    String now = binaryString.substring(0,1);
		    String later = binaryString.substring(1);
		    return Integer.parseInt(now) * (int)Math.pow(2, len-1) + bin2Dec(later);  
		}
		static int i = 1;
		
		public static String toOctal(int decimal){    
		    int rem;   
		    String octal=""; 

		    char octalchars[]={'0','1','2','3','4','5','6','7'};  

		    while(decimal>0)  
		    {  
		       rem=decimal%8;   
		       octal=octalchars[rem]+octal;   
		       decimal=decimal/8;  
		    }  
		    return octal;  
		}    
		
		public static String arrayToString(int[] arr) {
			String str = "";
			for(int i = 0; i < arr.length; i++) {
				str += arr[i];
			}
			return str;
		}
}
	
