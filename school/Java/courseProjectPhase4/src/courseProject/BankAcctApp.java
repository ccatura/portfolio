package courseProject;
import java.util.*;

public class BankAcctApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Customer> allCustomers = new ArrayList<>();
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
		double transactionAmmount = 0;
		String transactionType = "";
		String accountType = "";

		boolean cont;
		boolean addCustCont;
		String quit = "n";

		
		
		
		
		addCustCont = false;
		while (!addCustCont) {
		
			// Prompt ID#
			cont = false;
			while (!cont) {
				try {
					System.out.println("Add new customer");
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
	
			
			// Create the Customer class instance for the new  customer
			Customer newCustomer = new Customer(custID,
										  custSSN,
										  custLastName,
										  custFirstName,
										  custStreet,
										  custCity,
										  custState,
										  custZip,
										  custPhone);
	
			allCustomers.add(newCustomer); //Add new customer to allCustomers arraylist
			
			
			// Checking or Savings
			System.out.print("\nChecking (CHK) or Savings (SAV) account: ");
			accountType = input.nextLine();
			System.out.println("New account type: " + accountType);

			
			// Make transaction
			cont = false;
			while (!cont) {
				System.out.print("\nDEP, WTH, BAL, or NEW: ");
				transactionType = input.nextLine();
				
				if (!transactionType.equalsIgnoreCase("new")) {
					if (transactionType.equalsIgnoreCase("dep") || transactionType.equalsIgnoreCase("wth")) {
						System.out.print(transactionType.toUpperCase() + " ammount: ");
						transactionAmmount = input.nextDouble();
						input.nextLine();
					}
	
					if (accountType.equalsIgnoreCase("sav")) {
						if (transactionType.equalsIgnoreCase("dep")) {
							newCustomer.savingsAccount.deposit(transactionAmmount);
						} else if (transactionType.equalsIgnoreCase("wth")) {
							newCustomer.savingsAccount.withdraw(transactionAmmount);
						} else {
							newCustomer.savingsAccount.getBalance();
						}
						System.out.println("Customer (" + newCustomer.savingsAccount.custID + ") current " + newCustomer.savingsAccount.accountType + " balance: " + newCustomer.savingsAccount.getBalance());
					} else if (accountType.equalsIgnoreCase("chk")) {
						if (transactionType.equalsIgnoreCase("dep")) {
							newCustomer.checkingAccount.deposit(transactionAmmount);
						} else if (transactionType.equalsIgnoreCase("wth")) {
							newCustomer.checkingAccount.withdraw(transactionAmmount);
						} else {
							newCustomer.checkingAccount.getBalance();
						}
						System.out.println("Customer (" + newCustomer.checkingAccount.custID + ") current " + newCustomer.checkingAccount.accountType + " balance: " + newCustomer.checkingAccount.getBalance());
					}
				} else {
					cont = true;
				}
				
				
				
				transactionAmmount = 0;
				transactionType = "";

			}
			
			
			System.out.print("Add new customer? (y/n): ");
			quit = input.nextLine();
			if (quit.equalsIgnoreCase("n")) {
				addCustCont = true;
			}

			
			
			
			
		} // End the Mother While Loop
		

		System.out.print("\n");
		System.out.println("Customers info:");
		System.out.println(allCustomers.get(0).getAllCustomerInfo());
		System.out.println("\n\n" + allCustomers.get(1).getAllCustomerInfo());

		input.close();
	}
}

