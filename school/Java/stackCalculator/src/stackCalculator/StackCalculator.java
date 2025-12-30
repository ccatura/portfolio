package stackCalculator;
import java.util.Stack;

public class StackCalculator {
	Stack<Float> calculator = new Stack<>();
	Stack<Float> values = new Stack<>();
	String command;
	
	public StackCalculator() {

	}
	
	





	public void displayWelcomeMessage() {
		System.out.println("Welcome to the Stack Calculator.");
	}
	
	public void displayCommands() {
		System.out.println("Commands: push n, add, sub, mult, div, list, clear, commands, quit.");
	}
	
	public void push(String value) {
		float numericValue = Float.parseFloat(value);
		this.command = value;
		this.calculator.add(numericValue);
	}
	
	public float pop() {
		return this.calculator.removeLast();
	}
	
	public void size() {
		System.out.println(this.calculator.size());
	}
	
	public void getValues() {

	}
	
	public void listStack() {
		if (this.calculator.size() > 0) {
			for (float stack : this.calculator) {
				System.out.println(stack);
			}
		} else {
			System.out.println("empty");
		}
	}
	
	public void clearStack() {
		this.calculator.clear();
	}
	
	public boolean checkSize() {
		if (this.calculator.size() < 2) {
			System.out.println("Not enough values for operation.");
			return false;
		}
		return true;
	}
	
}
