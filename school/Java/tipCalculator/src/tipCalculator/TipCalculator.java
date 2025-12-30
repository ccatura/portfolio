//Charles Catura CIS406 Course project: Tip Calculator//
package tipCalculator;
import java.util.*;

public class TipCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int tips[] = {15, 20, 25};

		String cont = "y";

		System.out.println("Tip Calculator");

		while (cont.equalsIgnoreCase("y")) {
			System.out.println();
			System.out.print("Cost of Meal: ");
			float costOfMeal = scanner.nextFloat();
			System.out.println();

			for (int x=0; x < tips.length; x++) {
				System.out.println(tips[x] + "%");
				float actualTip = costOfMeal * tips[x] / 100;
				float totalAmount = costOfMeal + actualTip;
				String tipFormatted = String.format("%.2f",  actualTip);
				String totalFormatted = String.format("%.2f",  totalAmount);
				System.out.println("Tip amount:   $" + tipFormatted);
				System.out.println("Total amount: $" + totalFormatted);
				
			}
			
			scanner.nextLine();
			System.out.print("Continue? (y/n): ");
			cont = scanner.nextLine();
			
			

			
		}
        scanner.close();
        System.out.println("Bye!!");
	}
}


