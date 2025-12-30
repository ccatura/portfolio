//Charles Catura CIS406 Course project: Interest Rate Calculator Part II//
package interestRateCalculatorPart2;
import java.util.*;
import java.text.NumberFormat;
import java.util.Locale;


public class InterestRateCalculatorPart2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String cont = "y";
		System.out.println("Welcome to the Interest Calculator");
       NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
       double loanAmount = 0;
       double interestRate = 0;
       boolean isValid;
       
		while (cont.equalsIgnoreCase("y")) {
			System.out.println();
			
			// Enter loan amount until input is validated
			isValid = false;
			while (!isValid) {
				try {
					System.out.print("Enter Loan Amount:   ");
					loanAmount = Double.parseDouble(scanner.next());
					isValid = true;
				} catch (NumberFormatException e) {
					System.out.println("Error! Invalid numeric value. Try again.\n");
					isValid = false;
				}
			}
			
			// Enter interest rate until input is validated
			System.out.println();
			isValid = false;
			while (!isValid) {
				try {
					System.out.print("Enter Interest Rate: ");
					interestRate = Double.parseDouble(scanner.next());
					isValid = true;
				} catch (NumberFormatException e) {
					System.out.println("Error! Invalid numeric value. Try again.\n");
					isValid = false;
				}
			}
			
			
			//Crunch the numbers
			double interest =  loanAmount * (interestRate  / 100);
			
			System.out.println();
			System.out.println("Loan Amount:         " + currency.format(loanAmount));
			System.out.println("Interest rate:       " + interestRate + "%");
			System.out.println("Loan Amount:         " + currency.format(interest));
			
			scanner.nextLine();
			System.out.println();
			System.out.print("Continue? (y/n): ");
			cont = scanner.nextLine();
			
			
			
		}
     scanner.close();
     System.out.println();
     System.out.println("Bye!!");
	}
}
