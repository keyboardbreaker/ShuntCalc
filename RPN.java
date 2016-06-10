import java.util.ArrayList;
import java.util.Stack;

public class RPN {
	ArrayList<String> rpnInput;
	// contains the workings of the rpn computation as it goes along
	Stack<String> workingStack;

	// used to take my sorted RPNString from ShuntingYardAlgorithm
	public RPN(ArrayList<String> s) {
		rpnInput = s;
		workingStack = new Stack<String>();
	}

	public String compute() {
		for (int i = 0; i < rpnInput.size(); i++) {
			if (rpnInput.get(i).length() > 1) // must be number
			{
				workingStack.push(rpnInput.get(i));
			} else if (Character.isDigit(rpnInput.get(i).charAt(0)))// Is also a
																	// number
			{
				workingStack.push(rpnInput.get(i));
			} else// Is an operator
			{
				//Check if stack is empty before popping. If it is, pretend the missing operands are zero.
				Double operand1 = workingStack.isEmpty() ? 0.0 : Double.parseDouble(workingStack.pop());
				Double operand2 = workingStack.isEmpty() ? 0.0 : Double.parseDouble(workingStack.pop());
				if (rpnInput.get(i).equals("*")) {
					workingStack.push(Double.toString(operand1 * operand2));
				} else if (rpnInput.get(i).equals("+")) {
					workingStack.push(Double.toString(operand1 + operand2));
				} else if (rpnInput.get(i).equals("-")) {
					workingStack.push(Double.toString(operand2 - operand1));
				} else if (rpnInput.get(i).equals("/")) {
					workingStack.push(Double.toString(operand2 / operand1));
				}
			}
		}
		return workingStack.pop();
	}
}
