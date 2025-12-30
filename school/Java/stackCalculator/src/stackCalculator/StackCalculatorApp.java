package stackCalculator;
import java.util.*;

public class StackCalculatorApp {
	public static void main(String[] args) {
		StackCalculator calculator = new StackCalculator();
		Scanner input = new Scanner(System.in);
		String commandInput = "";
		String command;
		String value = "";
		int vIndex;
		
		calculator.displayWelcomeMessage();
		System.out.println();
		calculator.displayCommands();
		
		while(true) {
			System.out.print("\nstack> ");
			commandInput = input.nextLine();
			
			
//			System.out.println();
			vIndex = commandInput.indexOf(' ');
			
			if (vIndex == -1) {
				command = commandInput;
				value= "";
			} else {
				command = commandInput.substring(0, vIndex);
				value = commandInput.substring(vIndex+1);
			}

			if (command.equals("push")) {
				calculator.push(value);
				calculator.listStack();
			} else if (command.equals("add")) {
				if (calculator.checkSize()) {
					float val2 = calculator.pop();
					float val1 = calculator.pop();
					float val3 = val1 + val2;
					String result = String.valueOf(val3);
					calculator.push(result);
					calculator.listStack();
				}
			} else if (command.equals("sub")) {
				if (calculator.checkSize()) {
					float val2 = calculator.pop();
					float val1 = calculator.pop();
					float val3 = val1 - val2;
					String result = String.valueOf(val3);
					calculator.push(result);
					calculator.listStack();		
				}
			} else if (command.equals("mult")) {
				if (calculator.checkSize()) {
					float val2 = calculator.pop();
					float val1 = calculator.pop();
					float val3 = val1 * val2;
					String result = String.valueOf(val3);
					calculator.push(result);
					calculator.listStack();		
				}
			} else if (command.equals("div")) {
				if (calculator.checkSize()) {
					float val2 = calculator.pop();
					float val1 = calculator.pop();
					float val3 = val1 / val2;
					String result = String.valueOf(val3);
					calculator.push(result);
					calculator.listStack();
				}
			} else if (command.equals("list")) {
				calculator.listStack();
			} else if (command.equals("clear")) {
				calculator.clearStack();
				calculator.listStack();
			} else if (command.equals("size")) {
				calculator.size();
			} else if (command.equals("quit")) {
				break;
			} else if (command.equals("commands") || command.equals("command")) {
				calculator.displayCommands();
			} else {
				System.out.println("Unrecognized command.");
				calculator.displayCommands();
			}


			
			
		}
		System.out.println("Thanks for using the Stack Calculator.");
		input.close();
	}

}
