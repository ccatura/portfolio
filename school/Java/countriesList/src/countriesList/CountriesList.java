package countriesList;
import java.util.ArrayList;

public class CountriesList {
	ArrayList<String> countries = new ArrayList<String>();
	int menuOption;
	
	public CountriesList() {
		this.menuOption = menuOption;
	}
	
	public void displayWelcomeMessage() {
		System.out.println("Country List Manager\n");
	}
	
	public void displayMenu() {
		System.out.println("COMMAND MENU\n1 - List countries\n2 - Add country\n3 - Exit");
	}
	
	public void getMenuOption() {
		System.out.println();
	}
	
	public boolean checkForCountry(String country) {
		if (this.countries.contains(country)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addCountry(String country) {
		if (checkForCountry(country)) {
			System.out.println("Country already exists. Not added.\n");
		} else {
			this.countries.add(country);
			System.out.println("Country [" + country + "] added!\n");
		}
	}
	
	public void listCountries() {
		if (this.countries.size() == 0) {
			System.out.println("No countries in the list.");
		} else {
			this.countries.sort(null);
			System.out.println();
			for (int i=0; i<this.countries.size(); i++) {
				System.out.println(this.countries.get(i));
			}
		}
	}
}
