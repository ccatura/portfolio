package courseProject;
import java.util.*;

public class BankAcctApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String custID;
		String custSSN;
		String custLastName;
		String custFirstName;
		String custStreet;
		String custCity;
		String custState;
		String custZip;
		String custPhone;
		String custIDPrompt = "Customer ID (non-blank, 5 chars): ";
		String custSSNPrompt = "Customer SSN (non-blank, no symbols): ";
		String custLastNamePrompt = "Customer last name (non-blank, no symbols or numbers): ";
		String custFirstNamePrompt = "Customer first name (non-blank, no symbols or numbers): ";
		String custStreetPrompt = "Customer street name (non-blank, no symbols): ";
		String custCityPrompt = "Customer city (non-blank, no symbols or numbers): ";
		String custStatePrompt = "Customer state (non-blank, no symbols or numbers, 2 chars): ";
		String custZipPrompt = "Customer zip code (non-blank, no symbols or letters, 5 chars): ";
		String custPhonePrompt = "Customer phone (non-blank, no symbols or letters): ";
		
		
		// Prompt ID
		System.out.print(custIDPrompt);
		custID = input.nextLine();
		while(!DataEntry.checkStringForInt(custID) || !DataEntry.checkStringLength(custID, 5)) {
			System.out.print("\nInput Error: Try again.\n");
			System.out.print(custIDPrompt);
			custID = input.nextLine();
		}

		// Prompt SS#
		System.out.print(custSSNPrompt);
		custSSN = input.nextLine();
		while(!DataEntry.checkStringForInt(custSSN) || !DataEntry.checkStringLength(custSSN, 9)) {
			System.out.print("\nInput Error: Try again.\n");
			System.out.print(custSSNPrompt);
			custSSN = input.nextLine();
		}

		// Prompt first name
		System.out.print(custFirstNamePrompt);
		custFirstName = input.nextLine();
		while(!DataEntry.checkString(custFirstName)) {
			System.out.print("\nInput Error: Try again.\n");
			System.out.print(custFirstNamePrompt);
			custFirstName = input.nextLine();
		}

		// Prompt last name
		System.out.print(custLastNamePrompt);
		custLastName = input.nextLine();
		while(!DataEntry.checkString(custLastName)) {
			System.out.print("\nInput Error: Try again.\n");
			System.out.print(custLastNamePrompt);
			custLastName = input.nextLine();
		}
		
		// Prompt street
		System.out.print(custStreetPrompt);
		custStreet = input.nextLine();
		while(!DataEntry.checkString(custStreet)) {
			System.out.print("\nInput Error: Try again.\n");
			System.out.print(custStreetPrompt);
			custStreet = input.nextLine();
		}
		
		// Prompt city
		System.out.print(custCityPrompt);
		custCity = input.nextLine();
		while(!DataEntry.checkString(custCity)) {
			System.out.print("\nInput Error: Try again.\n");
			System.out.print(custCityPrompt);
			custCity = input.nextLine();
		}
		
		// Prompt state
		System.out.print(custStatePrompt);
		custState = input.nextLine();
		while(!DataEntry.checkString(custState) || !DataEntry.checkStringLength(custState, 2) || DataEntry.checkStringForInt(custState)) {
			System.out.print("\nInput Error: Try again.\n");
			System.out.print(custStatePrompt);
			custState = input.nextLine();
		}

		// Prompt zip
		System.out.print(custZipPrompt);
		custZip = input.nextLine();
		while(!DataEntry.checkStringForInt(custZip) || !DataEntry.checkStringLength(custZip, 5)) {
			System.out.print("\nInput Error: Try again.\n");
			System.out.print(custZipPrompt);
			custZip = input.nextLine();
		}

		// Prompt phone
		System.out.print(custPhonePrompt);
		custPhone = input.nextLine();
		while(!DataEntry.checkStringForInt(custPhone) || !DataEntry.checkStringLength(custPhone, 10)) {
			System.out.print("\nInput Error: Try again.\n");
			System.out.print(custPhonePrompt);
			custPhone = input.nextLine();
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
