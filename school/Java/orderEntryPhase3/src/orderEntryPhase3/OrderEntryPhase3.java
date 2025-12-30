//Charles Catura CIS406 Course project Phase 3//
package orderEntryPhase3;
import java.util.*;
import java.text.NumberFormat;
import java.util.ArrayList;

public class OrderEntryPhase3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String cont = "y";
		
		// Setup arrays for item info
        ArrayList<String> ArrItemNumber 			= new ArrayList<>();
        ArrayList<String> ArrItemDescription 		= new ArrayList<>();
        ArrayList<Float> ArrItemPrice 				= new ArrayList<>();
        ArrayList<Float> ArrItemQuantity 			= new ArrayList<>();
        ArrayList<Float> ArrItemTaxPercent 		= new ArrayList<>();
        ArrayList<Float> ArrItemTaxAmount 			= new ArrayList<>();
        ArrayList<Float> ArrItemGrossAmount 		= new ArrayList<>();
        ArrayList<Float> ArrItemDiscountPercent 	= new ArrayList<>();
        ArrayList<Float> ArrItemDiscountAmount 	= new ArrayList<>();
        ArrayList<Float> ArrItemNetAmount 			= new ArrayList<>();
        int i = 0; // For arrayList iteration

        // Start the loop of user-entered items until user enters 'n'
		while(cont.equals("y") || cont.equals("Y")) {
			// Get information from user
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
			System.out.println("");
			System.out.println("Order Details:");
			System.out.println("");
			
			System.out.printf("%-15s %-25s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %15s\n",
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
			
			System.out.printf("%-15s %-25s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %15s\n",
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
				System.out.printf("%-15s %-25s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %15s\n",
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
			
			System.out.println("");

			// Print out final totals
			NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
			System.out.printf("%-15s %-25s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %15s\n",
					"Totals",
					"# Items = " + i,
					"", "", "",
					currency.format(totalTaxAmount),
					currency.format(totalGrossAmount),
					"",
					currency.format(totalDiscountAmount),
					currency.format(totalNetAmount)
					);

			
			scanner.close();
		}
	}

