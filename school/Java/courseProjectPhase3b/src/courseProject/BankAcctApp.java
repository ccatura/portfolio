package courseProject;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public class BankAcctApp extends JFrame {
	
	public static void main(String[] args) {
		

		// --- BEST PRACTICE: Run GUI setup on the Event Dispatch Thread (EDT) ---
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // 1. INSTANTIATE THE FRAME (THE WINDOW)
                JFrame frame = new JFrame("Customer Account Registration");

                // Set layout to 10 Rows (9 fields + 1 status/button row) and 2 Columns (Label + Field)
                frame.setLayout(new GridLayout(10, 2, 10, 5)); 
                
                // 2. CONFIGURE THE FRAME 
                frame.setPreferredSize(new Dimension(450, 500)); // Set a larger default size
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                frame.setLocationRelativeTo(null); 
                
                // 3. CREATE COMPONENTS
                
                // Input Fields
                JTextField custIDField = new JTextField(15);
                JTextField ssNumField = new JTextField(15);
                JTextField firstNameField = new JTextField(15);
                JTextField lastNameField = new JTextField(15);
                JTextField addressField = new JTextField(15); // Street Address
                JTextField cityField = new JTextField(15);
                JTextField stateField = new JTextField(15);
                JTextField zipField = new JTextField(15);
                JTextField phoneField = new JTextField(15);
                
                // Button
                JButton submitButton = new JButton("Submit Registration");
                
                // Status Label (to display the result of submission)
                JLabel statusLabel = new JLabel("Status: Ready to Register");

                // 4. ADD ACTION LISTENER 
                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Retrieve all input data
                        String custID = custIDField.getText().trim();
                        String ssNum = ssNumField.getText().trim();
                        String firstName = firstNameField.getText().trim();
                        String lastName = lastNameField.getText().trim();
                        String address = addressField.getText().trim();
                        String city = cityField.getText().trim();
                        String state = stateField.getText().trim();
                        String zip = zipField.getText().trim();
                        String phone = phoneField.getText().trim();
                        
                        // Basic validation: Check for at least two required fields
                        if (custID.isEmpty() || lastName.isEmpty()) {
                            statusLabel.setText("Status: Error! Account Number and Last Name are required.");
                        } else {
                            // Display confirmation
                            String output = String.format("Registered: %s %s (Acct: %s)", firstName, lastName, custID);
                            statusLabel.setText("Status: Success! " + output);
                            
                            // Clear fields after successful submission
                            custIDField.setText("");
                            ssNumField.setText("");
                            firstNameField.setText("");
                            lastNameField.setText("");
                            addressField.setText("");
                            cityField.setText("");
                            stateField.setText("");
                            zipField.setText("");
                            phoneField.setText("");
                        }
                    }
                });

                // 5. ADD COMPONENTS TO THE FRAME in GridLayout order (Row by Row)
                
                frame.add(new JLabel("Account Number:"));
                frame.add(custIDField); 
                
                frame.add(new JLabel("SS Number:"));
                frame.add(ssNumField);
                
                frame.add(new JLabel("First Name:"));
                frame.add(firstNameField);
                
                frame.add(new JLabel("Last Name:"));
                frame.add(lastNameField);
                
                frame.add(new JLabel("Street Address:"));
                frame.add(addressField);
                
                frame.add(new JLabel("City:"));
                frame.add(cityField);

                frame.add(new JLabel("State:"));
                frame.add(stateField);
                
                frame.add(new JLabel("Zip Code:"));
                frame.add(zipField);
                
                frame.add(new JLabel("Phone Number:"));
                frame.add(phoneField);

                // Row 10: Button and Status Label
                frame.add(submitButton); 
                frame.add(statusLabel); 
                
                // 6. DISPLAY THE FRAME 
                frame.pack(); // Pack components tightly based on preferred sizes
                frame.setVisible(true); 
            }
        });
	    
	    
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
		String transactionType = "BAL";
		
		boolean cont;
		boolean addCustCont;

		
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
			
			
			// Make transaction
			cont = false;
			while (!cont) {
				System.out.print("\nDEP, WTH, or BAL: ");
				transactionType = input.nextLine();
				
				if (transactionType.equalsIgnoreCase("dep") || transactionType.equalsIgnoreCase("wth")) {
					System.out.print(transactionType.toUpperCase() + " ammount: ");
					transactionAmmount = input.nextDouble();
					input.nextLine();
				}

				
				if (transactionType.equalsIgnoreCase("dep")) {
					newCustomer.savingsAccount.deposit(transactionAmmount);
				} else if (transactionType.equalsIgnoreCase("wth")) {
					newCustomer.savingsAccount.withdraw(transactionAmmount);
				} else {
					newCustomer.savingsAccount.getBalance();
				}
				
				System.out.println("Customer current balance: " + newCustomer.savingsAccount.getBalance());
				
				
				
				transactionAmmount = 0;
				transactionType = "";

			}
			
			
			
			
			
			
			
			
		} // End the Mother While Loop
		
		
		
		
		
		
		
		
		
		
		System.out.print("\n");
		System.out.println(allCustomers.get(0).getAllCustomerInfo());
		System.out.println("\n" + allCustomers.get(0));

		input.close();

	  }
	        
}

