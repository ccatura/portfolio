package guessingGame;
import java.util.*;

public class Game {
	int number;
	int guessNumber;
	int counter;
	int previousGuess;
	String triesPhrase = "tries";
	Scanner scanner = new Scanner(System.in);
	
	public Game() {
		this.number = 0;
		this.guessNumber = -1;
		this.counter = 0;
		this.previousGuess = 0;
	}
	
	public int generateNumberToBeGuessed() {
		number = (int) (Math.random() * 100) + 1;
		this.counter = 0;
		this.guessNumber = -1;
		return number;
	}
	
	public int makeGuess() {
		this.counter ++; // Increments the counter higher each time a guess is made
		displayPleaseGuessMessage();
		this.previousGuess = this.guessNumber;
		this.guessNumber  = scanner.nextInt();
		if (this.previousGuess < 0) this.previousGuess = this.guessNumber;
		return this.guessNumber;
	}
	
	public boolean isCorrectGuess(int guess) {
		String feedback; // Will contain if you are too low or too high based on your guess
		int difference = guess - this.number;
		
		// Determines if guess is too low, of too high
		if (difference < 0 && Math.abs(difference) < 10) {
			feedback = "Too low!";
		} else if (difference < 0 && Math.abs(difference) >= 10) {
			feedback = "Way too low!";
		} else if (difference > 0 && Math.abs(difference) < 10) {
			feedback = "Too high!";
		} else if (difference > 0 && Math.abs(difference) >= 10) {
			feedback = "Way too high!";
		} else {
			feedback = "";
		}
		
		// Checks for warmth or cold
		if (this.guessNumber > this.previousGuess && this.guessNumber < this.number ||
			this.guessNumber < this.previousGuess && this.guessNumber > this.number) {
			feedback += " Getting warmer.";
		} else if (this.guessNumber > this.previousGuess && this.guessNumber > this.number ||
				   this.guessNumber < this.previousGuess && this.guessNumber < this.number) {
			feedback += " Getting colder.";
		}
		
		
		
		
		
		// Checks if guess is correct of not
		if (guess == this.number) {
			displayCorrectGuessMessage();
			return true;
		} else {
			displayGuessAgainMessage(feedback);
			return false;
		}
	}
	
	public boolean yesOrNo() {
		scanner.nextLine();
		String answer = scanner.nextLine();
		if (answer.equals("y")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean continueGame() {
		System.out.print("Try again? (y/n): ");
		if (yesOrNo()) {
			System.out.println("\n\n");
			return true;
		} else {
			System.out.println("\nBye - Come back soon!");
			return false;
		}
	}
	

	
	
	public void displayWelcomeMessage() {
		String message = 	"Welcome to the Guess the Number Game\n";
		message += 			"++++++++++++++++++++++++++++++++++++\n\n";
		message += 			"I'm thinking of a number from 1 to 100.\n";
		message += 			"try to guess it.\n";
		System.out.println(message);
	}
	
	public void displayPleaseGuessMessage() {
		String message = "Enter a number between 1 and 100: ";
		System.out.print(message);
	}
	
	public void displayCorrectGuessMessage() {
		// Formats the word "try" of "tries" if more than 1 guess. That's just my little thing.
		if (this.counter == 1) {
			triesPhrase = "try";
		} else {
			triesPhrase = "tries";
		}
		
		// Determines how well you did based on amount of guesses
		String message = String.format("You got it in %d %s.\n", this.counter, triesPhrase);
				if (this.counter <= 3) {
			message += "Great work! You are a mathematical wizard.";
		} else if (this.counter >= 4 && this.counter <= 7) {
			message += "Not too bad! You’ve got some potential.";
		} else {
			message += "What took you so long?";
		}
		message += "\n";
		System.out.println(message);
	}
	
	public void displayGuessAgainMessage(String feedback) {
		System.out.println(feedback + " Guess again.\n");
	}
	
}
