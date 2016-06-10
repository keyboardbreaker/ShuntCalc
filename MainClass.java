import javax.swing.JFrame;

//use thus class to run everything!
public class MainClass {
	
    public static void main (String args[])
    {
        Calculator calculator = new Calculator(); //create calculator
//        OutputStack outputstack = new OutputStack(); //creates stack
        
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //terminates application when the window is closed by user
        calculator.setSize(255, 250); //frame size of calculator (width=300, height=200)
        calculator.setVisible(true); //displays window
        calculator.setResizable(false); // unresizable

    }//end of main
}
