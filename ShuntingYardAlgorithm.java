import java.util.Stack;
import java.util.ArrayList;
import java.lang.Character;

public class ShuntingYardAlgorithm {
	// creates an empty stack, lifo is my operator stack
	private Stack<String> operatorStack = new Stack<String>();
	private String textfield;
	private ArrayList<String> processedtextfield = new ArrayList<String>();
	private ArrayList<String> RPNString = new ArrayList<String>();
	private char currentToken;
	private ShuntingYardAlgorithm sya;

	public ShuntingYardAlgorithm(String s) {
		textfield = s;
		sya = this;
	}

	public boolean itsOperator(String s) {
		return (s.equals("/") || s.equals("*") || s.equals("+") || s
				.equals("-"));
	}

	// considers the expression in the textfield in terms of tokens
	public char characterParser() {
		// checks whether a number or operator was before a negative.
		boolean minusOperatorP;
		minusOperatorP = false;
		for (int i = 0; i < textfield.length(); i++) {
			currentToken = textfield.charAt(i);
			// convert char token to string type token
			String currentTokenString = Character.toString(currentToken);
			// it's an operator
			if (itsOperator(currentTokenString)) {
				if (currentTokenString.equals("-")) {
					if (minusOperatorP) {
						processedtextfield.add(currentTokenString);
						continue;
					}
					int j = numberscan(i);
					processedtextfield.add(textfield.substring(i, j));
					i = j - 1;
					continue;
				}
				minusOperatorP = false;
				processedtextfield.add(currentTokenString);
			}
			// is the token is a number?
			else if (Character.isDigit(currentToken)) {
				int j = numberscan(i);
				processedtextfield.add(textfield.substring(i, j));
				i = j - 1;
				minusOperatorP = true;
				continue;
			}
			// it's a bracket
			else {
				processedtextfield.add(currentTokenString);
				minusOperatorP = currentTokenString.equals(")");
			}
		}
		return currentToken;
	}

	// j is looking for the last occurence of a number, without exceeding length
	// textfield. (inclusive of decimal numbers.)
	public int numberscan(int i) {
		int j = i + 1;
		while (j < textfield.length()
				&& (Character.isDigit(textfield.charAt(j)) || Character
						.toString(textfield.charAt(j)).equals("."))) {
			j++;
		}
		return j;
	}

	public Stack<String> getOperatorStack() {
		return operatorStack;
	}

	public void Shunty() {
		for (int i = 0; i < processedtextfield.size(); i++) {
			String element = processedtextfield.get(i);
			System.out.println("\nCurrent element: " + element);
			if (itsOperator(element)) {
				String o1 = element;
				// peek looks at the object at the top of this
				// stack without removing it from the stack
				while (!getOperatorStack().empty()
						&& sya.opCompare(o1, getOperatorStack().peek())
						&& !getOperatorStack().peek().equals("(")) {
					RPNString.add(getOperatorStack().pop());
				}
				getOperatorStack().push(o1);
			}

			// deal with parentheses
			// Warning!: assumes matching parentheses. If this is not the case,
			// errors will strike with avengence
			else if (element.equals("(")) {
				getOperatorStack().push(element);
			}

			else if (element.equals(")")) {
				while (!getOperatorStack().peek().equals("(")) {
					RPNString.add(getOperatorStack().pop());
				}
				getOperatorStack().pop();
			}

			// it's a number
			else {
				RPNString.add(element);
				// System.out.println("Output queue" + RPNString);
			}
			System.out.println("Output queue: " + RPNString
					+ "\nOperator Stack: " + getOperatorStack());
		}

		// Once the input is read, empty the operator stack into the output
		// queue
		while (!getOperatorStack().isEmpty()) {
			RPNString.add(getOperatorStack().pop());
		}
	}

	// op1 and op2 are two operators.
	// checks if the precedence of o1 is less than or equal to that of o2
	public boolean opCompare(String o1, String o2) {
		if (o1.equals("-") || o1.equals("+") || o2.equals("*")
				|| o2.equals("/")) {
			return true;
		}
		return false;
	}

//	public static void main(String[] args) {
//		ShuntingYardAlgorithm sya = new ShuntingYardAlgorithm(
//				"((5.2-1.1*2)+1)/2");
//		System.out.println("textfield input = " + sya.textfield);
//		sya.characterParser();
//		sya.Shunty();
//		System.out.println("\nInput expression: " + sya.textfield);
//		System.out.println("Final answer: " + sya.RPNString);
//		RPN rpn = new RPN(sya.getRPNString());
//		try{
//			System.out.println(rpn.compute());
//		}
//		
//		catch (Exception e)	{
//
//		}
//		
//	}

	public ArrayList<String> getRPNString() {
		return RPNString;
	}
}
