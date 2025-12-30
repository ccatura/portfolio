package courseProject;

public class CheckingAccount extends Account implements AccountInterface {
	public CheckingAccount(String custID) {
		super(custID);
	}

	String accountNumber;
	String accountType = "checking";
	double serviceFee = .50;
	double interestRate = .02;
	double overdraftFee = 30;
	
	@Override
	public void withdraw(double transactionAmmount) {
		if (this.balance > 0) {
			this.balance -= transactionAmmount + serviceFee;
			if (this.balance < 0) {
				System.out.println("Overdraft fee of " + overdraftFee + " applied");
				this.balance -= overdraftFee;
			}
		} else {
			System.out.println("Insufficient funds.");
		}

		this.getBalance();
	}

	@Override
	public void deposit(double transactionAmmount) {
		this.balance += transactionAmmount;
	}

}
