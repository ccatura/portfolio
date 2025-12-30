//Charles Catura CIS406 Course project: Interest Rate Calculator//
package interestRateCalculatorPart1;
import java.util.*;
import java.text.NumberFormat;
import java.util.Locale;
public class InterestRateCalculatorPart1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String cont = "y";
		System.out.println("Welcome to the Interest Calculator");
       NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
		while (cont.equalsIgnoreCase("y")) {
			System.out.println();
			
			System.out.print("Enter Loan Amount:   ");
			double loanAmount = scanner.nextDouble();
			System.out.print("Enter Interest Rate: ");
			double interestRate = scanner.nextDouble();
			
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
