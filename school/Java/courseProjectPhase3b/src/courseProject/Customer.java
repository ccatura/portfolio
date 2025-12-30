package courseProject;

public class Customer {
	String custID;
	String custSSN;
	String custLastName;
	String custFirstName;
	String custStreet;
	String custCity;
	String custState;
	String custZip;
	String custPhone;
	CheckingAccount checkingAccount;
	SavingsAccount savingsAccount;
	
	public Customer (String custID, String custSSN, String custLastName, String custFirstName, String custStreet, String custCity, String custState, String custZip, String custPhone) {
		this.custID = custID;
		this.custSSN = custSSN;
		this.custLastName = custLastName;
		this.custFirstName = custFirstName;
		this.custStreet = custStreet;
		this.custCity = custCity;
		this.custState = custState;
		this.custZip = custZip;
		this.custPhone = custPhone;
		this.checkingAccount = new CheckingAccount();
		this.savingsAccount = new SavingsAccount();
	}
	
	
	public void setCustID(String str) {
		this.custID = str;
	}
	
	public void setCustSSN(String str) {
		this.custSSN = str;
	}
	
	public void setCustLastName(String str) {
		this.custLastName = str;
	}
	
	public void setCustFirstName(String str) {
		this.custFirstName = str;
	}
	
	public void setCustStreet(String str) {
		this.custStreet = str;
	}
	
	public void setCustCity(String str) {
		this.custCity = str;
	}
	
	public void setCustState(String str) {
		this.custState = str;
	}
	
	public void setCustZip(String str) {
		this.custZip = str;
	}
	
	public void setCustPhone(String str) {
		this.custPhone = str;
	}
	
	public String getCustID() {
		return this.custID;
	}
	
	public String getCustSSN() {
		return this.custID;
	}
	
	public String getCustLastName() {
		return this.custLastName;
	}
	
	public String getCustFirstName() {
		return this.custFirstName;
	}
	
	public String getCustStreet() {
		return this.custStreet;
	}
	
	public String getCustCity() {
		return this.custCity;
	}
	
	public String getCustState() {
		return this.custState;
	}
	
	public String getCustZip() {
		return this.custZip;
	}
	
	public String getCustPhone() {
		return this.custPhone;
	}
	
	public String getAllCustomerInfo() {
		String custInfo = "";
		
		custInfo += "ID: " + this.custID +
					"\nSS#: " + this.custSSN.substring(0, 3) + "-" + this.custSSN.substring(3, 5) + "-" + this.custSSN.substring(5, 9) +
					"\nFirst Name: " + this.custFirstName +
					"\nLast Name: " + this.custLastName +
					"\nStreet: " + this.custStreet +
					"\nCity: " + this.custCity +
					"\nState: " + this.custState.toUpperCase() +
					"\nZip: " + this.custZip +
					"\nPhone: " + this.custPhone.substring(0, 3) + "-" + this.custPhone.substring(3, 6) + "-" + this.custPhone.substring(6, 10);
						
		return custInfo;
	}
	
	public CheckingAccount getChecklingAccount() {
		return checkingAccount;
	}
	
	public SavingsAccount getSavingsAccount() {
		return savingsAccount;
	}
	
	
	
	

}
