import javax.swing.JFrame; //provides basic window features
import javax.swing.JButton; //provides buttons for GUI
import javax.swing.JTextField; // provides visual field for user
import java.awt.FlowLayout; // constants used for positioning and orientating components on window
import java.awt.event.ActionListener; //provides object handler to listen for events, the event being the user pressing a button
import java.awt.event.ActionEvent; // for calling after the user performs an event 

public class Calculator extends JFrame // calculator is a subclass of JFrame, it
// inherits the features of a window
{
	// fields for my calculator
	private JTextField display;
	private JButton button0;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton buttonLeftBracket;
	private JButton buttonRightBracket;
	private JButton buttonPlus;
	private JButton buttonMinus;
	private JButton buttonMultiply;
	private JButton buttonDivide;
	private JButton buttonEquals;
	private JButton buttonPlusMinus;
	private JButton buttonDecimal;
	private JButton buttonC;
	private JButton buttonMR;
	private JButton buttonMPlus;
	private JButton buttonMC;
	private JButton buttonBackspace;
	private String memoryVariable;

	public String getMemoryVariable() {
		return memoryVariable;
	}

	public void setMemoryVariable(String memoryVariable) {
		this.memoryVariable = memoryVariable;
	}

	// Calculator constuctor adds calculator features to JFrame
	public Calculator() {
		super("yjt21 Calculator"); // titlebar
		setLayout(new FlowLayout());// sets frame layout
		display = new JTextField(20); // 20 columns wide

		display.setEditable(false); // makes the field not editable by keyboard
									// commands

		add(display);// adds display to JFrame

		// JButton constructor with string argument
		buttonC = new JButton("C");
		/*
		 * setToolTipText specifies the tool ti[ that displayed when user
		 * positions the mouse cursor over the JButton in the GUI
		 */
		buttonC.setToolTipText("This will delete everything");

		add(buttonC); // add ButtonC to JFrame

		buttonMR = new JButton("MR");
		add(buttonMR);

		buttonMPlus = new JButton("M+");
		add(buttonMPlus);

		buttonMC = new JButton("MC");
		add(buttonMC);

		buttonBackspace = new JButton("Backspace");
		buttonBackspace
				.setToolTipText("This will remove the last character on the textfield, display");
		add(buttonBackspace);

		buttonLeftBracket = new JButton("   (    ");
		add(buttonLeftBracket);

		buttonRightBracket = new JButton("   )    ");
		add(buttonRightBracket);

		button0 = new JButton("0");
		add(button0);

		button1 = new JButton("1");
		add(button1);

		button2 = new JButton("2");
		add(button2);

		button3 = new JButton("3");
		add(button3);

		button4 = new JButton("4");
		add(button4);

		button5 = new JButton("5");
		add(button5);

		button6 = new JButton("6");
		add(button6);

		button7 = new JButton("7");
		add(button7);

		button8 = new JButton("8");
		add(button8);

		button9 = new JButton("9");
		add(button9);

		buttonDecimal = new JButton(" . ");
		buttonDecimal.setToolTipText("Adds a decimal point to the textField");
		add(buttonDecimal);
		
		buttonDivide = new JButton("/");
		buttonDivide.setToolTipText("Divide");
		add(buttonDivide);

		buttonPlus = new JButton("+");
		buttonPlus.setToolTipText("Add");
		add(buttonPlus);

		buttonMinus = new JButton("-");
		buttonMinus.setToolTipText("Subtract");
		add(buttonMinus);

		buttonMultiply = new JButton("*");
		buttonMultiply.setToolTipText("Multiply");
		add(buttonMultiply);

		buttonPlusMinus = new JButton("+/-"); // arguments (button String =
		// "+/-")
		add(buttonPlusMinus);


		buttonEquals = new JButton("                      =                      ");
		add(buttonEquals);

		// register event handler creates CalculatorHandler object and assigned
		// to variable handler
		CalculatorHandler handler = new CalculatorHandler();

		/*
		 * methods to register the event for each component. it recieves as its
		 * argument an ActionListener object, which can be an object of any
		 * class that implements ActionListener. The object handler is an
		 * ActionListener because Calculator implements ActionListener the
		 * object listens for events
		 */
		display.addActionListener(handler); // event registration statements
											// that specify handler as the event
											// handler for JTextField, display

		// event registration statements that specify handler as the event
		// handler for my buttons
		button0.addActionListener(handler);
		button1.addActionListener(handler);
		button2.addActionListener(handler);
		button3.addActionListener(handler);
		button4.addActionListener(handler);
		button5.addActionListener(handler);
		button6.addActionListener(handler);
		button7.addActionListener(handler);
		button8.addActionListener(handler);
		button9.addActionListener(handler);
		buttonLeftBracket.addActionListener(handler);
		buttonRightBracket.addActionListener(handler);
		buttonPlus.addActionListener(handler);
		buttonMinus.addActionListener(handler);
		buttonMultiply.addActionListener(handler);
		buttonDivide.addActionListener(handler);
		buttonEquals.addActionListener(handler);
		buttonPlusMinus.addActionListener(handler);
		buttonDecimal.addActionListener(handler);
		buttonC.addActionListener(handler);
		buttonMR.addActionListener(handler);
		buttonMPlus.addActionListener(handler);
		buttonMC.addActionListener(handler);
		buttonBackspace.addActionListener(handler);

	}// end of Calculator constructor

	public String getdisplay() {
		return display.getText();
	}

	// private inner class for event handling
	private class CalculatorHandler implements ActionListener {
		// process calculator events
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == button0)

				display.setText(display.getText() + "0");

			if (event.getSource() == button1)

				display.setText(display.getText() + "1");

			if (event.getSource() == button2)

				display.setText(display.getText() + "2");

			if (event.getSource() == button3)

				display.setText(display.getText() + "3");

			if (event.getSource() == button4)

				display.setText(display.getText() + "4");

			if (event.getSource() == button5)

				display.setText(display.getText() + "5");

			if (event.getSource() == button6)

				display.setText(display.getText() + "6");

			if (event.getSource() == button7)

				display.setText(display.getText() + "7");

			if (event.getSource() == button8)

				display.setText(display.getText() + "8");

			if (event.getSource() == button9)

				display.setText(display.getText() + "9");

			if (event.getSource() == buttonLeftBracket)

				display.setText(display.getText() + "(");

			if (event.getSource() == buttonRightBracket)

				display.setText(display.getText() + ")");

			if (event.getSource() == buttonPlus)

				display.setText(display.getText() + "+");

			if (event.getSource() == buttonMinus)

				display.setText(display.getText() + "-");

			if (event.getSource() == buttonMultiply)

				display.setText(display.getText() + "*");

			if (event.getSource() == buttonDivide)

				display.setText(display.getText() + "/");

			if (event.getSource() == buttonPlusMinus)

				if (display.getText().equals("")) // if the textfield, display
													// contains nothing
				{
					// do nothing
				}

				else if (display.getText().charAt(0) == '-') //
				{
					display.setText(display.getText().substring(1,
							display.getText().length()));
				}

				else {
					display.setText("-" + display.getText());
				}

			if (event.getSource() == buttonDecimal) {
				display.setText(display.getText() + ".");
			}

			if (event.getSource() == buttonC)

				display.setText("");

			if(event.getSource() == buttonMR){
				setMemoryVariable(display.getText());

			}

			if(event.getSource() == buttonMPlus){
				display.setText(display.getText() + getMemoryVariable());
			}
			
			if(event.getSource() == buttonMC){
				setMemoryVariable("");
			}
			
			
			if (event.getSource() == buttonBackspace)
				if (display.getText().equals("")) // if nothing is displayed on
													// the textField, display
				{
					// do nothing
				}
				/*
				 * makes the current text on the textfield a substring so that
				 * it can be editted by deleting the length by 1 character
				 */
				else {
					display.setText(display.getText().substring(0,
							display.getText().length() - 1));
				}

			// evaluate my textfield, display
			if (event.getSource() == buttonEquals) {

				if (display.getText().equals("")) {
					//
					// display.setText("");
				}

				else {
					ShuntingYardAlgorithm sya = new ShuntingYardAlgorithm(
							display.getText());
					sya.characterParser();
					sya.Shunty();
					RPN rpn = new RPN(sya.getRPNString());
					// System.out.println(rpn.compute());
					// evaluate and run algorithm

					try {
						display.setText(rpn.compute());
					}

					catch (Exception e) {
						display.setText("Syntax Error, press C to continue.");

					}
				}
			} // end of buttonEquals
		} // end of actionPerformed
	} // end of CalculatorHandler
}// end of Calculator
