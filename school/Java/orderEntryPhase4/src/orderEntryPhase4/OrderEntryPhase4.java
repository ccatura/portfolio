//Charles Catura CIS406 Course project Phase 4//
package orderEntryPhase4;
import java.util.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderEntryPhase4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String cont = "y";
		String invoice = "";
		
		// Setup arrays for item info
		ArrayList<String> ArrItemNumber 			= new ArrayList<>();
        ArrayList<String> ArrItemDescription 		= new ArrayList<>();
        ArrayList<Float> ArrItemPrice 				= new ArrayList<>();
        ArrayList<Float> ArrItemQuantity 			= new ArrayList<>();
        ArrayList<Float> ArrItemTaxPercent 			= new ArrayList<>();
        ArrayList<Float> ArrItemTaxAmount 			= new ArrayList<>();
        ArrayList<Float> ArrItemGrossAmount 		= new ArrayList<>();
        ArrayList<Float> ArrItemDiscountPercent 	= new ArrayList<>();
        ArrayList<Float> ArrItemDiscountAmount 		= new ArrayList<>();
        ArrayList<Float> ArrItemNetAmount 			= new ArrayList<>();
        int i = 0; // For arrayList iteration

        // Get customer personal info
		System.out.print("Enter customer name: ");
		String customerName = scanner.nextLine();

		System.out.print("Enter customer street: ");
		String customerStreet = scanner.nextLine();

		System.out.print("Enter customer city: ");
		String customerCity = scanner.nextLine();

		System.out.print("Enter customer state: ");
		String customerState = scanner.nextLine();

		System.out.print("Enter customer zip: ");
		int customerZip = scanner.nextInt();
		scanner.nextLine();

		
        // Start the loop of user-entered items until user enters 'n'
		while(cont.equals("y") || cont.equals("Y")) {
			// Get item info from user
			System.out.print("Enter item number: ");
			String itemNumber = scanner.nextLine();
			
			System.out.print("Enter item description: ");
			String itemDescription = scanner.nextLine();
			
			System.out.print("Enter the item price: ");
			float itemPrice = scanner.nextFloat();
			
			System.out.print("Enter quantity ordered: ");
			float itemQuantity = scanner.nextInt();
			
			System.out.print("Enter tax percentage: ");
			float itemTaxPercent = scanner.nextFloat();
			
			System.out.print("Enter discount percent: ");
			float itemDiscountPercent = scanner.nextFloat();
			scanner.nextLine();
			System.out.println("");

			// Calculate all numbers
			float itemGrossAmount      = itemPrice       * itemQuantity;
			float itemTaxAmount        = itemGrossAmount * (itemTaxPercent * (float).01);
			itemGrossAmount            = itemGrossAmount + itemTaxAmount;
			float itemDiscountAmount   = itemGrossAmount * (itemDiscountPercent * (float).01);
			float itemNetAmount        = itemGrossAmount - itemDiscountAmount;
			
			// Add item to array
			ArrItemNumber.add(itemNumber);
			ArrItemDescription.add(itemDescription);
			ArrItemPrice.add(itemPrice);
			ArrItemQuantity.add(itemQuantity);
			ArrItemTaxPercent.add(itemTaxPercent);
			ArrItemTaxAmount.add(itemTaxAmount);
			ArrItemGrossAmount.add(itemGrossAmount);
			ArrItemDiscountPercent.add(itemDiscountPercent);
			ArrItemDiscountAmount.add(itemDiscountAmount);
			ArrItemNetAmount.add(itemNetAmount);
						
			// Ask user to continue adding item or end
			System.out.print("Continue? (y/n): ");
			cont = scanner.nextLine();
			
			// Only iterate to i for next item if user answers y
			if (cont.equals("y") || cont.equals("Y")) {
				i++; //
			}
			System.out.println("");

		}
		
			// Print out final details of all items
			invoice += "\nOrder Details\n";
			invoice += "Invoice Date: " + getFormattedDate() + "\n\n";
			
			invoice += String.format("%-34s %-34s %-35s %-31s %-15s\n",
					"Customer Name",
					"Customer Street",
					"Customer City",
					"Customer State",
					"Customer Zip Code"
					);
			
			invoice += String.format("%-34s %-34s %-35s %-31s %-15s\n",
					"-------------",
					"---------------",
					"-------------",
					"--------------",
					"-----------------"
					);

			invoice += String.format("%-34s %-34s %-35s %-31s %-15s\n",
					customerName,
					customerStreet,
					customerCity,
					customerState,
					customerZip
					);

			invoice += "\n";
			
			invoice += String.format("%-15s %-25s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %15s\n",
					"Item Number",
					"Item Description",
					"Item Price",
					"Quantity",
					"Tax %",
					"Tax Amt",
					"Gross Amt",
					"Discount %",
					"Discount Amt",
					"Net Amt");
			
			invoice += String.format("%-15s %-25s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %15s\n",
					"-----------",
					"----------------",
					"----------",
					"--------",
					"-----",
					"-------",
					"---------",
					"----------",
					"------------",
					"-------");
			
			// Initiate additional totals needed
			float totalTaxAmount = 0;
			float totalGrossAmount = 0;
			float totalDiscountAmount = 0;
			float totalNetAmount = 0;

			// Iterate through all items to display
			for (int j = 0; j<=i; j++) {
				NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
				invoice += String.format("%-15s %-25s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %15s\n",
						ArrItemNumber.get(j),
						ArrItemDescription.get(j),
						currency.format(ArrItemPrice.get(j)),
						ArrItemQuantity.get(j),
						ArrItemTaxPercent.get(j) + "%",
						currency.format(ArrItemTaxAmount.get(j)),
						currency.format(ArrItemGrossAmount.get(j)),
						ArrItemDiscountPercent.get(j) + "%",
						currency.format(ArrItemDiscountAmount.get(j)),
						currency.format(ArrItemNetAmount.get(j))
						);
				totalTaxAmount 		+= ArrItemTaxAmount.get(j);
				totalGrossAmount 	+= ArrItemGrossAmount.get(j);
				totalDiscountAmount += ArrItemDiscountAmount.get(j);
				totalNetAmount 		+= ArrItemNetAmount.get(j);
			}
			
			invoice += "\n";

			// Print out final totals
			NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
			invoice += String.format("%-15s %-25s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %15s\n",
					"Totals",
					"# Items = " + (i + 1),
					"", "", "",
					currency.format(totalTaxAmount),
					currency.format(totalGrossAmount),
					"",
					currency.format(totalDiscountAmount),
					currency.format(totalNetAmount)
					);

			System.out.print(invoice);
			scanner.close();
		}
	
	
	
	
	    public static String getFormattedDate() {
	        LocalDate today = LocalDate.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	        return today.format(formatter);
	    }
    
    
  
}

