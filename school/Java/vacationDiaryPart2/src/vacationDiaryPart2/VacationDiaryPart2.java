//Charles Catura CIS406 Vacation Diary 2//
package vacationDiaryPart2;
import java.util.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class VacationDiaryPart2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean cont = true;
		String addMore;
		String dateStarted = "";
		String city = "";
		String country = "";
		int days = 0;
		String travelMode = "";
		String lastDate = "";
		int maxStringLength = 14;
		
		//Setup the arrays to store the multiple lines of data
		ArrayList<String> ArrDateStarted = new ArrayList<>();
		ArrayList<String> ArrCity = new ArrayList<>();
		ArrayList<String> ArrCountry = new ArrayList<>();
		ArrayList<Integer> ArrDays = new ArrayList<>();
		ArrayList<String> ArrTravelMode = new ArrayList<>();
		ArrayList<String> ArrAllTravelModes = new ArrayList<>(Arrays.asList("car", "bus", "airplane", "train", "ship"));
		
		
		//Start the formatted output to surround the user input data
		String formattedOutput = "\n" + "=".repeat(80);
		formattedOutput += "\n" + "=".repeat(32) + " Vacation Diary " + "=".repeat(32);
		formattedOutput += String.format(
				"%-15s %-4s %-15s %-3s %-15s %-4s %-4s %-4s %-15s\n",
				"\nDate",
				"",
				"City",
				"",
				"Country",
				"",
				"Days",
				"",
				"Mode"
				);
		formattedOutput += String.format(
				"%-12s %-4s %-12s %-4s %-12s %-5s %-4s %-4s %-12s\n",
				"==============",
				"",
				"==============",
				"",
				"==============",
				"",
				"====",
				"",
				"========="
				);
				
		
		//Start user input
		System.out.println("Vacation Diary");
		
		while (cont) {
			while (!dateFormatChecker(dateStarted)) {
				System.out.print("\nEnter date vacation started (mm/dd/yyyy): ");
				dateStarted = scanner.nextLine();
				lastDate = dateStarted;
				ArrDateStarted.add(lastDate);
			}
			dateStarted = ""; //Reset the dateStarted variable
			
			System.out.print("City visited: ");
			city = scanner.nextLine();
			ArrCity.add(truncateString(city, maxStringLength));
			
			System.out.print("Country visited: ");
			country = scanner.nextLine();
			ArrCountry.add(truncateString(country, maxStringLength));
			
			while (outSideRange(days, 0, 31)) {
				System.out.print("Number of days: ");
				days = scanner.nextInt();
				scanner.nextLine();
				if (outSideRange(days, 0, 31)) {
					System.out.println("Duration of days must be between 1 and 30. Try again.\n");
				}
			}
			ArrDays.add(days);
			days = 0; //Zero out the days variable to allow the while loop to function
			
			while (!isValidTravelMode(ArrAllTravelModes, travelMode)) {
				System.out.print("Enter mode of travel (car, airplane. ship, train, bus): ");
				travelMode = scanner.nextLine();
			}
			ArrTravelMode.add(truncateString(travelMode, maxStringLength - 5));
			travelMode = ""; //reset the travelMode variable
			
			System.out.print("Add more destinations? (y/n): ");
			addMore = scanner.nextLine();
			if (addMore.equalsIgnoreCase("y")) {
				cont = true;
			} else {
				cont = false;
			}

		}
		
			
		//Put the rest of the data and formatted output together
		int quantityOfTrips = ArrDateStarted.size();
		for (int j = 0; j < quantityOfTrips; j++) {
			formattedOutput += String.format(
					"%-15s %-3s %-15s %-3s %-15s %-4s %-4s %-4s %-15s\n",
					ArrDateStarted.get(j),
					"",
					ArrCity.get(j),
					"",
					ArrCountry.get(j),
					"",
					ArrDays.get(j),
					"",
					ArrTravelMode.get(j)
					);
		}
		
		
		formattedOutput += "=".repeat(80);
		System.out.println(formattedOutput);
		System.out.println("\nBye!!!");
		scanner.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Check if number is within range
    public static boolean outSideRange(int num, int low, int high) {
    	if (num <= low || num >= high) {
    		return true;
    	} else {
    		return false;
    	}

    }
    
    //Truncate string if longer than specified length
    public static String truncateString(String str, int max) {
    	if (str.length() > max) {
    		return str.substring(0, max);
    	} else {
    		return str;
    	}
    }
	
    //Check if mode of travel is within allowed modes
	public static boolean isValidTravelMode(ArrayList<String> ArrAllTravelModes, String travelMode) {
		return ArrAllTravelModes.contains(travelMode.toLowerCase());
	}
	
	//Check if date is formatted correctly
	public static boolean dateFormatChecker(String theDate) {
		// Define the  format.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		
        try {
            // Attempt to parse the string using the formatter.
            LocalDate.parse(theDate, formatter);
            // If parsing succeeds, the format is valid.
            return true;
        } catch (DateTimeParseException e) {
            // If parsing fails, the format is invalid.
        	return false;
        }
		
	}
	
	
	
	
}
