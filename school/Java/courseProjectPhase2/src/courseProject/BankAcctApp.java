package courseProject;
import java.util.*;

public class BankAcctApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String custID = "";
		String custSSN = "";
		String custLastName = "";
		String custFirstName = "";
		String custStreet = "";
		String custCity = "";
		String custState = "";
		String custZip = "";
		String custPhone = "";
		String custIDPrompt = "Customer ID (non-blank, 5 chars): ";
		String custSSNPrompt = "Customer SSN (non-blank, no symbols): ";
		String custLastNamePrompt = "Customer last name (non-blank, no symbols or numbers): ";
		String custFirstNamePrompt = "Customer first name (non-blank, no symbols or numbers): ";
		String custStreetPrompt = "Customer street name (non-blank, no symbols): ";
		String custCityPrompt = "Customer city (non-blank, no symbols or numbers): ";
		String custStatePrompt = "Customer state (non-blank, no symbols or numbers, 2 chars): ";
		String custZipPrompt = "Customer zip code (non-blank, no symbols or letters, 5 chars): ";
		String custPhonePrompt = "Customer phone (non-blank, no symbols or letters): ";
		boolean cont;

		// Prompt ID#
		cont = false;
		while (!cont) {
			try {
				System.out.print(custIDPrompt);
				custID = input.nextLine();
				
				if (!DataEntry.checkStringForInt(custID) || !DataEntry.checkStringLength(custID, 5)) {
					throw new IllegalArgumentException("User Input Error.");
				}
				cont = true;
				
			} catch (IllegalArgumentException e) {
				System.out.print("\nInput Error: Try again.\n");
			}
		}
		
		// Prompt SS#
		cont = false;
		while (!cont) {
			try {
				System.out.print(custSSNPrompt);
				custSSN = input.nextLine();
				
				if (!DataEntry.checkStringForInt(custSSN) || !DataEntry.checkStringLength(custSSN, 9)) {
					throw new IllegalArgumentException("User Input Error.");
				}
				cont = true;
				
			} catch (IllegalArgumentException e) {
				System.out.print("\nInput Error: Try again.\n");
			}
		}

		// Prompt first name
		cont = false;
		while (!cont) {
			try {
				System.out.print(custFirstNamePrompt);
				custFirstName = input.nextLine();
				
				if (!DataEntry.checkString(custFirstName) || !DataEntry.checkMaxLength(custFirstName, 15)) {
					throw new IllegalArgumentException("User Input Error.");
				}
				cont = true;
				
			} catch (IllegalArgumentException e) {
				System.out.print("\nInput Error: Try again.\n");
			}
		}

		// Prompt last name
		cont = false;
		while (!cont) {
			try {
				System.out.print(custLastNamePrompt);
				custLastName = input.nextLine();
				
				if (!DataEntry.checkString(custLastName) || !DataEntry.checkMaxLength(custLastName, 20)) {
					throw new IllegalArgumentException("User Input Error.");
				}
				cont = true;
				
			} catch (IllegalArgumentException e) {
				System.out.print("\nInput Error: Try again.\n");
			}
		}
		
		
		// Prompt street
		cont = false;
		while (!cont) {
			try {
				System.out.print(custStreetPrompt);
				custStreet = input.nextLine();
				
				if (!DataEntry.checkString(custStreet) || !DataEntry.checkMaxLength(custStreet, 20)) {
					throw new IllegalArgumentException("User Input Error.");
				}
				cont = true;
				
			} catch (IllegalArgumentException e) {
				System.out.print("\nInput Error: Try again.\n");
			}
		}
		
		// Prompt city
		cont = false;
		while (!cont) {
			try {
				System.out.print(custCityPrompt);
				custCity = input.nextLine();
				
				if (!DataEntry.checkString(custCity) || !DataEntry.checkMaxLength(custCity, 20)) {
					throw new IllegalArgumentException("User Input Error.");
				}
				cont = true;
				
			} catch (IllegalArgumentException e) {
				System.out.print("\nInput Error: Try again.\n");
			}
		}
		
		// Prompt state
		cont = false;
		while (!cont) {
			try {
				System.out.print(custStatePrompt);
				custState = input.nextLine();
				
				if (!DataEntry.checkString(custState) || !DataEntry.checkStringLength(custState, 2) || DataEntry.checkStringForInt(custState)) {
					throw new IllegalArgumentException("User Input Error.");
				}
				cont = true;
				
			} catch (IllegalArgumentException e) {
				System.out.print("\nInput Error: Try again.\n");
			}
		}

		// Prompt zip
		cont = false;
		while (!cont) {
			try {
				System.out.print(custZipPrompt);
				custZip = input.nextLine();
				
				if (!DataEntry.checkStringForInt(custZip) || !DataEntry.checkStringLength(custZip, 5)) {
					throw new IllegalArgumentException("User Input Error.");
				}
				cont = true;
				
			} catch (IllegalArgumentException e) {
				System.out.print("\nInput Error: Try again.\n");
			}
		}

		// Prompt phone
		cont = false;
		while (!cont) {
			try {
				System.out.print(custPhonePrompt);
				custPhone = input.nextLine();
				
				if (!DataEntry.checkStringForInt(custPhone) || !DataEntry.checkStringLength(custPhone, 10)) {
					throw new IllegalArgumentException("User Input Error.");
				}
				cont = true;
				
			} catch (IllegalArgumentException e) {
				System.out.print("\nInput Error: Try again.\n");
			}
		}


		Customer cust1 = new Customer(custID,
									  custSSN,
									  custLastName,
									  custFirstName,
									  custStreet,
									  custCity,
									  custState,
									  custZip,
									  custPhone);

		
		System.out.print("\n");
		System.out.print(cust1.getAllCustomerInfo());

		input.close();
	}
}
