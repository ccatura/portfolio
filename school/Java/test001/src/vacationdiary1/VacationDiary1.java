//Charles Catura CIS406 Vacation Diary 1//
package vacationdiary1;
import java.util.*;
public class VacationDiary1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Vacation Diary");
		System.out.println("");
		System.out.print("Enter date vacation started (mm/dd/yyyy): ");
		String dateStarted = scanner.nextLine();
		
		System.out.print("City visited: ");
		String city = scanner.nextLine();
		
		System.out.print("Country visited: ");
		String country = scanner.nextLine();
		
		System.out.print("Number of days: ");
		String days = scanner.nextLine();
		
		System.out.print("Enter mode of travel (car, airplane. ship, train, bus): ");
		String travelMode = scanner.nextLine();

		System.out.println("");

		System.out.println("Details of your trip:");
		System.out.println("Date: " + dateStarted);
		System.out.println("City: " +  city);
		System.out.println("Country: " +  country);
		System.out.println("Number of days: " +  days);
		System.out.println("Traveled by: " +  travelMode);
		System.out.println("Bye!!!");
		scanner.close();
	}
}







