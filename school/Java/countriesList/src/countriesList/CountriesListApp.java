package countriesList;
import java.util.*;

public class CountriesListApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		CountriesList countries1 = new CountriesList();
		String answer;
		
		countries1.displayWelcomeMessage();
		countries1.displayMenu();
		System.out.println();

		while (true) {
			System.out.print("Enter menu number: ");

			answer = input.nextLine();
			if (answer.equals("1")) {
				countries1.listCountries();
				System.out.println();
			} else if (answer.equals("2")) {
				System.out.print("Country: ");
				countries1.addCountry(input.nextLine());
			} else if (answer.equals("3")) {
				break;
			} else {
				System.out.println("\nPlease enter one of the above options.");
			}
		}
		
		System.out.print("\nK, bye!");
		
		
		input.close();
	}

}
