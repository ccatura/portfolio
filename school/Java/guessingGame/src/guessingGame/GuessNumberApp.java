package guessingGame;

public class GuessNumberApp {
	public static void main(String[] args) {
		Game game = new Game(); // Initialize instance of game
		int guess;
		game.generateNumberToBeGuessed(); // Generate initial random number
		game.displayWelcomeMessage();
		
		while (true) {
			guess = game.makeGuess();
			if (game.isCorrectGuess(guess)) {
				if (game.continueGame()) {
					game.generateNumberToBeGuessed();
					continue;
				} else {
					break;
				}
			}
		}
	}
}
