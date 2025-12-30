package ticTacToe;
import java.util.*;

public class TicTacToe {
	String[][] grid = new String[3][3];
	int rowNumber;
	int columnNumber;
	char player;
	boolean valid;
	boolean gridFull;
	String markSelected;
	Scanner scanner = new Scanner(System.in);

	public TicTacToe() {
		this.rowNumber = 0;
		this.columnNumber = 0;
		this.player = '1';
		this.markSelected = "X";
		this.valid = false;
		this.gridFull = false;
		initializeGrid();
	}
	
	public void startGame() {
		while (!checkForWinner()) {
			takeTurn();
		}
		displayWinnerMessage();
	}
	
	public void takeTurn() {
			while (!valid) {
				System.out.println("\n" + this.markSelected + "'s turn ");
				System.out.print("Pick a row (1, 2, 3): ");
				this.rowNumber = scanner.nextInt() - 1;
	
				System.out.print("Pick a column (1, 2, 3): ");
				this.columnNumber = scanner.nextInt() - 1;
				validateMove();
			}
			
			this.valid = false; // Resets valid for validateMove purposes
			System.out.println();
			this.grid[this.rowNumber][this.columnNumber] = this.markSelected;
			
			displayGrid();
			

			if (this.markSelected == "X") {
				this.markSelected = "O";
				this.player = '2';
			} else {
				this.markSelected = "X";
				this.player = '1';
			}
	}
	
	public boolean validateMove() {
		// Checks if chosen space is in range
		if (this.rowNumber < 0 || this.rowNumber > grid.length - 1 || this.columnNumber < 0 || this.columnNumber > grid.length - 1) {
			this.valid = false;
			System.out.println("\nChoice is out of range. Pick again.");
			displayGrid();
			return false;
		}
		
		// Checks if space is already taken
		if (this.grid[this.rowNumber][this.columnNumber] != " ") {
			this.valid = false;
			System.out.println("\nSpace taken. Pick again.");
			displayGrid();
			return false;
		}
		
		this.valid = true;
		return true;
	}
	
	public boolean checkForWinner() {

		if (this.grid[0][0].equals(this.grid[0][1]) && this.grid[0][1].equals(this.grid[0][2]) && (this.grid[0][0].equals("X") || (this.grid[0][0].equals("O")))) {
					return true;
				} else if (this.grid[1][0].equals(this.grid[1][1]) && this.grid[1][1].equals(this.grid[1][2]) && (this.grid[1][0].equals("X") || (this.grid[1][0].equals("O")))) {
					return true;
				} else if (this.grid[2][0].equals(this.grid[2][1]) && this.grid[2][1].equals(this.grid[2][2]) && (this.grid[2][0].equals("X") || (this.grid[2][0].equals("O")))) {
					return true;
				} else if (this.grid[0][0].equals(this.grid[1][0]) && this.grid[1][0].equals(this.grid[2][0]) && (this.grid[0][0].equals("X") || (this.grid[0][0].equals("O")))) {
					return true;
				} else if (this.grid[0][1].equals(this.grid[1][1]) && this.grid[1][1].equals(this.grid[2][1]) && (this.grid[0][1].equals("X") || (this.grid[0][1].equals("O")))) {
					return true;
				} else if (this.grid[0][2].equals(this.grid[1][2]) && this.grid[1][2].equals(this.grid[2][2]) && (this.grid[0][2].equals("X") || (this.grid[0][2].equals("O")))) {
					return true;
				} else if (this.grid[0][0].equals(this.grid[1][1]) && this.grid[1][1].equals(this.grid[2][2]) && (this.grid[0][0].equals("X") || (this.grid[0][0].equals("O")))) {
					return true;
				} else if (this.grid[2][0].equals(this.grid[1][1]) && this.grid[1][1].equals(this.grid[0][2]) && (this.grid[2][0].equals("X") || (this.grid[2][0].equals("O")))) {
					return true;
				} else {
					return false;
				}
	}
	
	public void initializeGrid() {
		for (int i=0; i < this.grid.length; i++) {
			for (int j=0; j <this.grid[i].length; j++) {
				this.grid[i][j] = " ";
			}
		}
	}
	
	public void displayGrid() {
		for (int i=0; i < this.grid.length; i++) {
			System.out.println("+---+---+---+");
			for (int j=0; j <this.grid[i].length; j++) {
				System.out.print("| " + this.grid[i][j] + " ");
			}
			System.out.println("|");
		}
		System.out.println("+---+---+---+");

	}
	
	public void displayWelcomeMessage() {
		System.out.println("Welcome to Tic Tac Toe\n");
	}
	
	public void displayWinnerMessage() {
		System.out.println("\nGame over.\n");
	}
	
	public void checkFull() {
		for (int i=0; i < this.grid.length; i++) {
			for (int j=0; j <this.grid[i].length; j++) {
				if (this.grid[i][j].equals(" ")) {
					this.gridFull = false;
				} else {
					this.gridFull = true;
				}
			}
		}
	}

}
